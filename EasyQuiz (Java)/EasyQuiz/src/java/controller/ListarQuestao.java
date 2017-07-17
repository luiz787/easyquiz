package controller;

import java.time.Instant;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import model.daoimpl.QuestaoDAOImpl;
import model.daoimpl.QuestaoFechadaDAOImpl;
import model.daoimpl.QuestaoFechadaRespostaDAOImpl;
import model.domain.Questao;
import model.domain.QuestaoFechada;
import model.domain.QuestaoFechadaResposta;
import model.service.ManterQuestao;
import model.service.ManterQuestaoFechada;
import model.service.ManterQuestaoFechadaResposta;
import model.serviceimpl.ManterQuestaoFechadaImpl;
import model.serviceimpl.ManterQuestaoFechadaRespostaImpl;
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
            
          
             
            for (int i=0; i < listQuestao.size(); i++ ) { 
               Questao Q = listQuestao.get(i);
           if ( request.getParameter("nivel")!=  null  )  {
               if(!request.getParameter("nivel").equals(""))  { 
                 if(! Q.getDificuldade().getId().toString().equals(request.getParameter("nivel"))){
                        listQuestao.remove(Q);
                        i--;
                        continue;
                    }
               }
           }
           if ( request.getParameter("materia") !=  null ) {
               if(!request.getParameter("materia").equals(""))  { 
                        if(! Q.getDisciplina().getId().toString().equals(request.getParameter("materia"))){
                        listQuestao.remove(Q);
                        i--;
                        continue;
                    }
               }        
            }
             if ( request.getParameter("modulo") !=  null ) {
                 if(!request.getParameter("nivel").equals(""))  { 
                        if(! Q.getModulo().getId().toString().equals(request.getParameter("modulo"))){
                        listQuestao.remove(Q);
                        i--;
                        continue;
                    }
                 }
            }
            if ( request.getParameter("tipo") !=  null ) {
                if(!request.getParameter("tipo").equals(""))  { 
                        System.out.println("tipo request:" +request.getParameter("tipo") + " tipo questao: "+ Q.getIdTipo() );
                        if(!request.getParameter("tipo").contains(String.valueOf(Q.getIdTipo())) ){
                    
                            listQuestao.remove(Q);
                            i--;
                            continue;
                    }
                }        
            }
            if ( request.getParameter("palavras") !=  null ) {
                if(!request.getParameter("palavras").equals(""))  { 
                        if(! Q.getTxtEnunciado().contains(request.getParameter("palavras"))){
                        listQuestao.remove(Q);
                        i--;
                        continue;
                    }
                }        
            }
            
             
            }
            
            
            
            if(request.getSession().getAttribute("cod_Usuario")!=null) {
                ListarQuestaoFechadaResposta.execute(request);
            }
            
            request.setAttribute("listQuestao", listQuestao);

            request.setAttribute("listQuestaoFechada", listQuestaoFechada);
            
            jsp = "/TelaQuestoes.jsp";

        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }
}
