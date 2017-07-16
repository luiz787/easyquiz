package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class TelaPerfil_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Menu.jsp", out, false);
      out.write("\n");
      out.write("        <H4 style=\"color: #47525E; padding-left: 80px;\">Aproveitamento:</H4>\n");
      out.write("    <div class=\"container\">\n");
      out.write("      <H5 style=\"color: #47525E; display: inline;\">Perguntas respondidas:</H5> <H5 style=\"color: #C55353; display: inline;\">250</H5>\n");
      out.write("      <H5 style=\"color: #47525E; display: inline; padding-left: 50px;\">Perguntas acertadas:</H5> <H5 style=\"color: #C55353; display: inline;\">175</H5>\n");
      out.write("      <br>\n");
      out.write("      <br>\n");
      out.write("      <H5 style=\"color: #47525E; display: inline;\">Coeficiente de acerto:</H5> <H5 style=\"color: #C55353; display: inline;\">70%</H5>\n");
      out.write("      <div class=\"progress\" style=\"z-index: -1;\">\n");
      out.write("        <div class=\"determinate\" style=\"width: 70%; z-index: -11;\"></div>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <br>\n");
      out.write("    <br>\n");
      out.write("\n");
      out.write("    <H4 style=\"color: #47525E; padding-left: 80px; display: inline;\">O que deseja alterar </H4> <H4 style=\"color: #C55353; display: inline;\">Usuário?</H4>\n");
      out.write("    <div class=\"container\">\n");
      out.write("      <form class=\"col s12\">\n");
      out.write("          <div class=\"input-field col s6\">\n");
      out.write("            <i class=\"material-icons prefix\">account_circle</i>\n");
      out.write("            <input id=\"nome\" type=\"text\" class=\"validate\">\n");
      out.write("            <label for=\"nome\">Nome completo</label>\n");
      out.write("          </div>\n");
      out.write("\n");
      out.write("          <div class=\"input-field col s6\">\n");
      out.write("            <i class=\"material-icons prefix\">email</i>\n");
      out.write("            <input id=\"email\" type=\"email\" class=\"validate\">\n");
      out.write("            <label for=\"email\">E-mail</label>\n");
      out.write("          </div>\n");
      out.write("\n");
      out.write("          <br>\n");
      out.write("\n");
      out.write("          <label for=\"escolhe_data\">Data de nascimento:</label>\n");
      out.write("          <div class=\"input-field col s6\">\n");
      out.write("            <i class=\"material-icons prefix\">perm_contact_calendar</i>\n");
      out.write("            <input id=\"escolhe_data\" type=\"date\" class=\"validate\">\n");
      out.write("          </div>\n");
      out.write("\n");
      out.write("          <label for=\"escolaridade\">Escolaridade:</label>\n");
      out.write("          <div class=\"input-field col s6\">\n");
      out.write("          <i class=\"material-icons prefix\">class</i>\n");
      out.write("            <select id=\"escolaridade\">\n");
      out.write("              <option value=\"\" selected>Escolaridade</option>\n");
      out.write("              <option value=\"1\">Analfabeto</option>\n");
      out.write("              <option value=\"2\">Fundamental incompleto</option>\n");
      out.write("              <option value=\"3\">Fundamental completo</option>\n");
      out.write("              <option value=\"4\">Médio incompleto</option>\n");
      out.write("              <option value=\"5\">Médio completo</option>\n");
      out.write("              <option value=\"6\">Superior incompleto</option>\n");
      out.write("              <option value=\"7\">Superior completo</option>\n");
      out.write("              <option value=\"8\">Pós graduado</option>\n");
      out.write("            </select>\n");
      out.write("          </div>\n");
      out.write("\n");
      out.write("          <br>\n");
      out.write("\n");
      out.write("          <label for=\"senha\">Senha:</label>\n");
      out.write("          <div class=\"input-field col s6\">\n");
      out.write("            <i class=\"material-icons prefix\">lock_outline</i>\n");
      out.write("            <input id=\"senha\" type=\"password\" class=\"validate\">\n");
      out.write("          </div>\n");
      out.write("          <label for=\"senha\">Confirmar senha:</label>\n");
      out.write("          <div class=\"input-field col s6\">\n");
      out.write("            <input type=\"password\" id=\"confirma_senha\">\n");
      out.write("          </div>\n");
      out.write("\n");
      out.write("          <br>\n");
      out.write("          <br>\n");
      out.write("          <br>\n");
      out.write("\n");
      out.write("          <div align=\"right\">\n");
      out.write("            <button class=\"btn waves-effect waves-light\" type=\"button\" onclick=\"window.open('../Tela de questões/TelaQuestoes.html');\">Cancelar</button>\n");
      out.write("\n");
      out.write("            <button class=\"btn waves-effect waves-light\" type=\"submit\" name=\"action\" onclick=\"window.open('../Tela de questões/TelaQuestoes.html');\">Confirmar\n");
      out.write("              <i class=\"material-icons right\">send</i>\n");
      out.write("            </button>\n");
      out.write("          </div>\n");
      out.write("          \n");
      out.write("      </form>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <br>\n");
      out.write("    <br>\n");
      out.write("        \n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Footer.jsp", out, false);
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
