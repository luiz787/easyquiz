package controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import model.daoimpl.QuestaoDAOImpl;
import model.daoimpl.QuestaoFechadaDAOImpl;
import model.domain.Questao;
import model.domain.QuestaoFechada;
import model.service.ManterQuestao;
import model.service.ManterQuestaoFechada;
import model.serviceimpl.ManterQuestaoFechadaImpl;
import model.serviceimpl.ManterQuestaoImpl;

public class ListarQuestao {
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            ManterQuestao manterQuestao = new ManterQuestaoImpl(QuestaoDAOImpl.getInstance());
            List<Questao> listQuestao = manterQuestao.getAll();
            ManterQuestaoFechada manterQuestaoFechada = 
                    new ManterQuestaoFechadaImpl(QuestaoFechadaDAOImpl.getInstance());
            List<QuestaoFechada> listQuestaoFechada = manterQuestaoFechada.getAll();
            
            if (listQuestao != null) {
                
                request.setAttribute("listQuestao", listQuestao);
                request.setAttribute("listQuestaoFechada", listQuestaoFechada);
                
                if(request.getSession().getAttribute("numeroPagina")==null) {
                    request.getSession().setAttribute("numeroPagina", 0);
                    System.out.println("Criou numeroPagina");
                } else {
                    String acao = request.getParameter("acao");
                    System.out.println("ACAO: "+acao);
                    if(acao!=null) {
                        if(acao.equals("ProximaPagina")) {
                            int numeroPagina = (Integer) request.getSession().getAttribute("numeroPagina");
                            System.out.println("ProximaPagina: "+numeroPagina);
                            request.getSession().setAttribute("numeroPagina", ++numeroPagina);
                        } else if(acao.equals("PaginaAnterior")) {
                            int numeroPagina = (Integer) request.getSession().getAttribute("numeroPagina");
                            System.out.println("PaginaAnterior"+numeroPagina);
                            request.getSession().setAttribute("numeroPagina", --numeroPagina);
                        }
                    }
                }
                System.out.println("KKKKKKKKKKKKKK");
                jsp = "/TelaQuestoes.jsp";
            } else {
                String erro = "Não existe Questoes!";
                request.setAttribute("erro", erro);
                jsp = "/erro.jsp";
            }

        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }
}
