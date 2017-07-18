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
            DateTimeFormatter formataHora = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            LocalDateTime formatador1 = LocalDateTime.parse(request.getParameter("dataInicio")+" 00:00:00", formataHora);
            LocalDateTime formatador2 = LocalDateTime.parse(request.getParameter("dataFim")+" 23:59:59", formataHora);

            String dataInicioString = formatador1.format(formataHora);
            String dataFimString = formatador2.format(formataHora);
            
            LocalDateTime dateTimeInicio = LocalDateTime.parse(dataInicioString, formataHora);
            LocalDateTime dateTimeFim = LocalDateTime.parse(dataFimString, formataHora);
            
            Instant dat_Inicio = dateTimeInicio.atZone(ZoneId.of("GMT-0")).toInstant();
            Instant dat_Fim = dateTimeFim.atZone(ZoneId.of("GMT-0")).toInstant();
            
            
            Long cod_Usuario = (Long) request.getSession().getAttribute("cod_Usuario");

            ManterQuestaoFechadaResposta manterQuestaoFechadaResposta 
                    = new ManterQuestaoFechadaRespostaImpl(QuestaoFechadaRespostaDAOImpl.getInstance());
            List<QuestaoFechadaResposta> listQuestaoFechadaResposta =
                manterQuestaoFechadaResposta.getAllByUsuarioPeriodo(cod_Usuario, dat_Inicio, dat_Fim);
            
            
            
            request.getSession().setAttribute("Desempenho", listQuestaoFechadaResposta);
            jsp = "/TelaPerfil.jsp";
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }
}
