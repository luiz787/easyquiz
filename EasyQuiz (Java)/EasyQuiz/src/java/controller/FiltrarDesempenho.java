package controller;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import model.daoimpl.QuestaoFechadaRespostaDAOImpl;
import model.domain.QuestaoFechadaResposta;
import model.service.ManterQuestaoFechadaResposta;
import model.serviceimpl.ManterQuestaoFechadaRespostaImpl;

public class FiltrarDesempenho {
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            System.out.println("Data Inicio: "+request.getParameter("dataInicio"));
            System.out.println("Data Inicio: "+request.getParameter("dataFim"));
            
/*
            System.out.println("toString: " + formatador.toString());
            //toString: 2016-10-31T23:59:59                                                                                                                                                                                                                           
            System.out.println("format:   " + formatador.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            //format:   2016-10-31 23:59:59 
            */
            DateTimeFormatter formataHora = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            LocalDateTime formatador1 = LocalDateTime.parse(request.getParameter("dataInicio")+" 00:00:00", formataHora);
            LocalDateTime formatador2 = LocalDateTime.parse(request.getParameter("dataFim")+" 23:59:59", formataHora);

            String dataInicioString = formatador1.format(formataHora);
            String dataFimString = formatador2.format(formataHora);
            
            LocalDateTime dateTimeInicio = LocalDateTime.parse(dataInicioString, formataHora);
            LocalDateTime dateTimeFim = LocalDateTime.parse(dataFimString, formataHora);
            
            Instant dat_Inicio = dateTimeInicio.atZone(ZoneId.of("GMT-0")).toInstant();
            Instant dat_Fim = dateTimeFim.atZone(ZoneId.of("GMT-0")).toInstant();
            
            System.out.println("InstantInicio: "+dat_Inicio);
            System.out.println("InstantFim: "+dat_Fim);
            
            Long cod_Usuario = (Long) request.getSession().getAttribute("cod_Usuario");

            ManterQuestaoFechadaResposta manterQuestaoFechadaResposta 
                    = new ManterQuestaoFechadaRespostaImpl(QuestaoFechadaRespostaDAOImpl.getInstance());
            List<QuestaoFechadaResposta> listQuestaoFechadaResposta =
                manterQuestaoFechadaResposta.getAllByUsuarioPeriodo(cod_Usuario, dat_Inicio, dat_Fim);
            
            
            System.out.println("Size Array: "+listQuestaoFechadaResposta.size());
            request.getSession().setAttribute("Desempenho", listQuestaoFechadaResposta);
                
            
            //SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
            //java.util.Date dateInicio = formatador.parse(request.getParameter("dataInicio"));
            //Instant dat_Inicio = dateInicio.toInstant();
            //LocalDateTime dateFim = formatador.parse(request.getParameter("dataFim"));
            //Instant dat_Fim = dateFim.atZone(ZoneId.of("GMT-3")).toInstant();

            //System.out.println("INSTANTE: "+java.sql.Timestamp.from(dat_Inicio));
            //System.out.println("INSTANTE: "+java.sql.Timestamp.from(dat_Fim));
            /*
            ManterQuestaoFechadaResposta manterQuestaoFechadaResposta 
                    = new ManterQuestaoFechadaRespostaImpl(QuestaoFechadaRespostaDAOImpl.getInstance());
            List<QuestaoFechadaResposta> listQuestaoFechadaResposta =
                manterQuestaoFechadaResposta.getAllByUsuarioPeriodo(cod_Usuario, dat_Inicio, dat_Fim);
            */
            jsp = "/TelaPerfil.jsp";
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }
}
