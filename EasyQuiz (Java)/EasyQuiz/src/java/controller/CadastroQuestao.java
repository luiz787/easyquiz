/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import model.daoimpl.DificuldadeDAOImpl;
import model.daoimpl.DisciplinaDAOImpl;
import model.daoimpl.ModuloDAOImpl;
import model.daoimpl.QuestaoDAOImpl;
import model.daoimpl.QuestaoFechadaDAOImpl;
import model.domain.Dificuldade;
import model.domain.Disciplina;
import model.domain.Modulo;
import model.domain.Questao;
import model.domain.QuestaoFechada;
import model.service.ManterDificuldade;
import model.service.ManterDisciplina;
import model.service.ManterModulo;
import model.service.ManterQuestao;
import model.service.ManterQuestaoFechada;
import model.serviceimpl.ManterDificuldadeImpl;
import model.serviceimpl.ManterDisciplinaImpl;
import model.serviceimpl.ManterModuloImpl;
import model.serviceimpl.ManterQuestaoFechadaImpl;
import model.serviceimpl.ManterQuestaoImpl;
/**
 *
 * @author Luiz
 */
public class CadastroQuestao {
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            System.out.println("Teste AddQuestaoo");
            ManterDisciplina manterDisciplina = new ManterDisciplinaImpl(DisciplinaDAOImpl.getInstance());
            List<Disciplina> disciplinas = manterDisciplina.getAll();
            ManterModulo manterModulo = new ManterModuloImpl(ModuloDAOImpl.getInstance());
            List<Modulo> modulos = manterModulo.getAll();
            ManterDificuldade manterDificuldade = new ManterDificuldadeImpl(DificuldadeDAOImpl.getInstance());
            List<Dificuldade> dificuldades = manterDificuldade.listAll();
            request.setAttribute("listDisciplina", disciplinas);
            request.setAttribute("listModulo", modulos);
            request.setAttribute("listDificuldade", dificuldades);
            Questao questao = new Questao();
                String enunciado = request.getParameter("enunciado");
                System.out.println("Enunciado: " + enunciado);
                String tipo = request.getParameter("tipo");
                System.out.println("Tipo (A ou F): " + tipo);
                String dificuldade = request.getParameter("dificuldade");
                System.out.println("Dificuldade: "+dificuldade);
                String disciplina = request.getParameter("disciplina");
                System.out.println("Disciplina: "+disciplina);
                String modulo = request.getParameter("modulo");
                System.out.println("Modulo: "+ modulo);
                if (request.getAttribute("listDificuldade")!=null && request.getAttribute("listDisciplina")!=null
                        && request.getAttribute("listModulo")!=null){
                    System.out.println("Deu certo.");
                }
                System.out.println("debug");
                //List<Dificuldade> listDificuldade = (List<Dificuldade>) request.getAttribute("listDificuldade");
                System.out.println("debug");
                for (int i=0; i<dificuldades.size(); i++){
                    System.out.println(dificuldades.get(i).getDescricao());
                    if (dificuldade.equals(dificuldades.get(i).getDescricao())){
                        questao.setDificuldade(dificuldades.get(i));
                    }
                }
                System.out.println("Dificuldade da questão setada: "+questao.getDificuldade().getDescricao());
                
                //List<Disciplina> listDisciplina = (List<Disciplina>) request.getAttribute("listDisciplina");
                for (int i=0; i<disciplinas.size(); i++){
                    if (disciplina.equals(disciplinas.get(i).getNome())){
                        questao.setDisciplina(disciplinas.get(i));
                    }
                }
                
                //List<Modulo> listModulo = (List<Modulo>) request.getAttribute("listModulo");
                for (int i=0; i<modulos.size(); i++){
                    if (modulo.equals(modulos.get(i).getNome())){
                        questao.setModulo(modulos.get(i));
                    }
                }
                
                questao.setTxtEnunciado(enunciado);
                if (tipo.equals("aberta")){
                    questao.setIdTipo('A');
                    String resposta = request.getParameter("txtresposta");
                    questao.setTxtResposta(resposta);
                    System.out.println("Resposta correta: "+resposta);
                } else {
                    questao.setIdTipo('F');
                }
                ManterQuestao manterQuestao = new ManterQuestaoImpl(QuestaoDAOImpl.getInstance());
                Long novoId = manterQuestao.cadastrarQuestao(questao);
                questao.setId(novoId);
                if (tipo.equals("fechada")){
                    QuestaoFechada[] qf = new QuestaoFechada[4];
                    String[] alternativas = new String[4];
                    List<QuestaoFechada> questoesFechadas = new ArrayList();
                    for (int i=0; i<alternativas.length; i++){
                        qf[i] = new QuestaoFechada();
                        alternativas[i] = request.getParameter("alt"+i);
                        System.out.println(alternativas[i]);
                        qf[i].setQuestao(questao);
                        qf[i].setSeqAlternativa(new Long(i+1));
                        qf[i].setTxtAlternativa(alternativas[i]);
                        questoesFechadas.add(qf[i]);
                    }
                    int seqCorreta = Integer.parseInt(request.getParameter("group1"))+1;
                    questao.setSeqQuestaoCorreta(new Long(seqCorreta));
                    System.out.println(seqCorreta);
                    System.out.println("debug alternativasss");
                    for (int i=0; i<questoesFechadas.size(); i++){
                        System.out.println(questoesFechadas.get(i).getTxtAlternativa());
                    }
                    ManterQuestaoFechada manterQuestaoFechada = new ManterQuestaoFechadaImpl(QuestaoFechadaDAOImpl.getInstance());
                    manterQuestaoFechada.cadastrarQuestaoFechada(questoesFechadas); //algo está dando errado AQUI
                }
                System.out.println("NOVO ID DA QUESTAO: "+novoId);
                /*System.out.println("\n\nFINALIZANDO");
                System.out.println(questao.getTxtEnunciado());
                System.out.println(questao.getIdTipo());
                if (questao.getIdTipo()=='A'){
                    System.out.println(questao.getTxtResposta());
                } else {
                    System.out.println("SEQUENCIAL CORRETO: "+questao.getSeqQuestaoCorreta());
                    
                }*/
            jsp = "/cadastro.jsp";
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }
}
