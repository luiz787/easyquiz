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
            
            if (listQuestao != null && listQuestaoFechada != null) {
                
                request.setAttribute("listQuestao", listQuestao);
                request.setAttribute("listQuestaoFechada", listQuestaoFechada);
                if(request.getAttribute("numeroPagina") == null) {
                    request.setAttribute("numeroPagina", 0);
                } else {
                    String acao = request.getParameter("acao");
                    System.out.println("Que bosta");
                    if(acao.equals("ProximaPagina")) {
                        int numeroPagina = (Integer) request.getAttribute("numeroPagina");
                        System.out.println("(Proxima)ListarQuestao: "+numeroPagina);
                        request.setAttribute("numeroPagina", ++numeroPagina);
                    } else if(acao.equals("PaginaAnterior")) {
                        int numeroPagina = (Integer) request.getAttribute("numeroPagina");
                        System.out.println("(Anterior)ListarQuestao: "+numeroPagina);
                        request.setAttribute("numeroPagina", --numeroPagina);
                    }
                    
                }
                jsp = "/TelaQuestoes.jsp";
            } else {
                String erro = "Não existe Clientes!";
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
