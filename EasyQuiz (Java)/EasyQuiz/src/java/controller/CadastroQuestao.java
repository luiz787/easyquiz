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
                String tipo = request.getParameter("tipo");
                String dificuldade = request.getParameter("dificuldade");
                String disciplina = request.getParameter("disciplina");
                String modulo = request.getParameter("moduloo");
                if (request.getAttribute("listDificuldade")!=null && request.getAttribute("listDisciplina")!=null
                        && request.getAttribute("listModulo")!=null){
                }
                for (int i=0; i<dificuldades.size(); i++){
                    if (dificuldade.equals(dificuldades.get(i).getDescricao())){
                        questao.setDificuldade(dificuldades.get(i));
                    }
                }
                
                Disciplina objDisciplina=null;
                boolean gravouDisciplina = false;
                for (int i=0; i<disciplinas.size(); i++){
                    if (disciplina.equals(disciplinas.get(i).getNome())){
                        objDisciplina = disciplinas.get(i);
                        questao.setDisciplina(objDisciplina);
                        gravouDisciplina = true;
                    }
                }
                if (!gravouDisciplina){
                    Disciplina novaDisciplina = new Disciplina();
                    novaDisciplina.setNome(disciplina);
                    Long novoIdDisciplina = manterDisciplina.cadastrarDisciplina(novaDisciplina);
                    novaDisciplina.setId(novoIdDisciplina);
                    questao.setDisciplina(novaDisciplina);
                    objDisciplina = novaDisciplina;
                }
                
                boolean gravouModulo = false;
                for (int i=0; i<modulos.size(); i++){
                    if (modulo.equals(modulos.get(i).getNome())){
                        questao.setModulo(modulos.get(i));
                        gravouModulo = true;
                    }
                }
                if (!gravouModulo){
                    Modulo novoModulo = new Modulo();
                    novoModulo.setNome(modulo);
                    novoModulo.setDisciplina(objDisciplina); //get Disciplina que foi colocada pelo usuário (se nao existia já foi criada)
                    Long novoIdModulo = manterModulo.cadastrarModulo(novoModulo);
                    novoModulo.setId(novoIdModulo);
                    questao.setModulo(novoModulo);
                }
                questao.setTxtEnunciado(enunciado);
                if (tipo.equals("aberta")){
                    questao.setIdTipo('A');
                    String resposta = request.getParameter("txtresposta");
                    questao.setTxtResposta(resposta);
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
                        qf[i].setQuestao(questao);
                        qf[i].setSeqAlternativa(new Long(i+1));
                        qf[i].setTxtAlternativa(alternativas[i]);
                        questoesFechadas.add(qf[i]);
                    }
                    int seqCorreta = Integer.parseInt(request.getParameter("group1"))+1;
                    questao.setSeqQuestaoCorreta(new Long(seqCorreta));
                    for (int i=0; i<questoesFechadas.size(); i++){
                    }
                    boolean result = manterQuestao.alterarQuestao(questao);
                    ManterQuestaoFechada manterQuestaoFechada = new ManterQuestaoFechadaImpl(QuestaoFechadaDAOImpl.getInstance());
                    manterQuestaoFechada.cadastrarQuestaoFechada(questoesFechadas); //algo está dando errado AQUI
                }
            jsp = "/cadastroquestao.jsp";
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }
}