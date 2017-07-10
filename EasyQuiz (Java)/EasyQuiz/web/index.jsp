<%@page import="controller.ListarQuestao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    request.getSession().setAttribute("contadorRespostaQuestao", 0);
    String jsp = ListarQuestao.execute(request);
    RequestDispatcher rd = request.getRequestDispatcher(jsp);
    rd.forward(request, response);
%>