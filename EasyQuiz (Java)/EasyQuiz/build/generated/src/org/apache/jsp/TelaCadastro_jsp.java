package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class TelaCadastro_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"/>\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1.0\"/>\n");
      out.write("        <title>EasyQuiz</title>\n");
      out.write("\n");
      out.write("        <!-- CSS  -->\n");
      out.write("        <link href=\"https://fonts.googleapis.com/icon?family=Material+Icons\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"css/materialize.css\" type=\"text/css\" rel=\"stylesheet\" media=\"screen,projection\"/>\n");
      out.write("        <link href=\"css/style.css\" type=\"text/css\" rel=\"stylesheet\" media=\"screen,projection\"/>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Menu.jsp", out, false);
      out.write("\n");
      out.write("        \n");
      out.write("        <br>\n");
      out.write("        <H4 style=\"color: #47525E; padding-left: 80px;\">Preencha todos os campos a seguir:</H4>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <form class=\"col s12\" action=\"Cadastra\" method=\"POST\">\n");
      out.write("                <div class=\"input-field col s6\"  style=\"z-index: 0;\">\n");
      out.write("                    <i class=\"material-icons prefix\">account_circle</i>\n");
      out.write("                    <input id=\"nome\" name=\"nome\" type=\"text\" class=\"validate\">\n");
      out.write("                    <label for=\"nome\">Nome completo</label>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"input-field col s6\"  style=\"z-index: 0;\">\n");
      out.write("                    <i class=\"material-icons prefix\">email</i>\n");
      out.write("                    <input id=\"email\" name=\"email\" type=\"email\" class=\"validate\">\n");
      out.write("                    <label for=\"email\">E-mail</label>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <br>\n");
      out.write("\n");
      out.write("                <label for=\"escolhe_data\">Data de nascimento:</label>\n");
      out.write("                <div class=\"input-field col s6\">\n");
      out.write("                    <i class=\"material-icons prefix\">perm_contact_calendar</i>\n");
      out.write("                    <input id=\"data\" name=\"data\" type=\"date\" class=\"validate\">\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <label for=\"escolaridade\">Escolaridade:</label>\n");
      out.write("                <div class=\"input-field col s6\">\n");
      out.write("                    <i class=\"material-icons prefix\">class</i>\n");
      out.write("                    <select id=\"escolaridade\" name=\"escolaridade\">\n");
      out.write("                        <option disabled selected>Escolaridade</option>\n");
      out.write("                        <option value=\"Analfabeto\">Analfabeto</option>\n");
      out.write("                        <option value=\"Fundamental incompleto\">Fundamental incompleto</option>\n");
      out.write("                        <option value=\"Fundamental completo\">Fundamental completo</option>\n");
      out.write("                        <option value=\"Médio incompleto\">Médio incompleto</option>\n");
      out.write("                        <option value=\"Médio completo\">Médio completo</option>\n");
      out.write("                        <option value=\"Superior incompleto\">Superior incompleto</option>\n");
      out.write("                        <option value=\"Superior completo\">Superior completo</option>\n");
      out.write("                        <option value=\"Pós graduado\">Pós graduado</option>\n");
      out.write("                    </select>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <br>\n");
      out.write("\n");
      out.write("                <label for=\"senha\">Senha:</label>\n");
      out.write("                <div class=\"input-field col s6\">\n");
      out.write("                    <i class=\"material-icons prefix\">lock_outline</i>\n");
      out.write("                    <input id=\"senha\" name=\"senha\" type=\"password\" class=\"validate\">\n");
      out.write("                </div>\n");
      out.write("                <label for=\"confirma_senha\">Confirmar senha:</label>\n");
      out.write("                <div class=\"input-field col s6\">\n");
      out.write("                    <input type=\"password\" id=\"confirma_senha\">\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <br>\n");
      out.write("                <br>\n");
      out.write("                <br>\n");
      out.write("\n");
      out.write("                <div align=\"right\">\n");
      out.write("                    <button class=\"btn waves-effect waves-light\" type=\"button\">Cancelar</button>\n");
      out.write("\n");
      out.write("                    <button class=\"btn waves-effect waves-light\" type=\"submit\" name=\"action\">Confirmar\n");
      out.write("                        <i class=\"material-icons right\">send</i>\n");
      out.write("                    </button>\n");
      out.write("                </div>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <br>\n");
      out.write("        <br>\n");
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
