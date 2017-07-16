package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.domain.Escolaridade;
import java.util.List;
import model.serviceimpl.ManterEscolaridadeImpl;
import model.service.ManterEscolaridade;
import model.service.ManterEscolaridade;
import model.daoimpl.EscolaridadeDAOImpl;
import model.daoimpl.EscolaridadeDAOImpl;
import model.domain.Usuario;
import model.serviceimpl.ManterUsuarioImpl;
import model.service.ManterUsuario;
import model.daoimpl.UsuarioDAOImpl;
import model.daoimpl.UsuarioDAOImpl;
import controller.Login;

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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

    int logado = Login.validarSessao(request, response);
    Usuario usuario = null;
    List<Escolaridade> listEscolaridade = null;
    if(logado==1) {
        Long cod_Usuario = (Long) request.getSession().getAttribute("cod_Usuario");
        ManterUsuario manterUsuario = new ManterUsuarioImpl(UsuarioDAOImpl.getInstance());
        usuario = manterUsuario.getUsuarioById(cod_Usuario);
        
        ManterEscolaridade manterEscolaridade = new ManterEscolaridadeImpl(EscolaridadeDAOImpl.getInstance());
        listEscolaridade = manterEscolaridade.getAll();
    }

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>JSP Page</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Menu.jsp", out, false);
      out.write("\r\n");
      out.write("        <H4 style=\"color: #47525E; padding-left: 80px;\">Aproveitamento:</H4>\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("          <H5 style=\"color: #47525E; display: inline;\">Perguntas respondidas:</H5> <H5 style=\"color: #C55353; display: inline;\">250</H5>\r\n");
      out.write("          <H5 style=\"color: #47525E; display: inline; padding-left: 50px;\">Perguntas acertadas:</H5> <H5 style=\"color: #C55353; display: inline;\">175</H5>\r\n");
      out.write("          <br>\r\n");
      out.write("          <br>\r\n");
      out.write("          <H5 style=\"color: #47525E; display: inline;\">Coeficiente de acerto:</H5> <H5 style=\"color: #C55353; display: inline;\">70%</H5>\r\n");
      out.write("          <div class=\"progress\" style=\"z-index: -1;\">\r\n");
      out.write("            <div class=\"determinate\" style=\"width: 70%; z-index: -11;\"></div>\r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <br>\r\n");
      out.write("        <br>\r\n");
      out.write("\r\n");
      out.write("        <H4 style=\"color: #47525E; padding-left: 80px; display: inline;\">O que deseja alterar </H4> <H4 style=\"color: #C55353; display: inline;\">Usuário?</H4>\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <form class=\"col s12\" method=\"post\" name=\"formPerfil\">\r\n");
      out.write("                <input type='hidden' name='table' value='Usuario'>\r\n");
      out.write("                <input type='hidden' name='acao' value='alterar'>\r\n");
      out.write("                \r\n");
      out.write("                <div class=\"input-field col s6\">\r\n");
      out.write("                    <i class=\"material-icons prefix\">account_circle</i>\r\n");
      out.write("                    <input name=\"nome\" type=\"text\" class=\"validate\" value=\"");
      out.print( usuario.getNome() );
      out.write("\">\r\n");
      out.write("                    <label for=\"nome\">Nome completo</label>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"input-field col s6\">\r\n");
      out.write("                    <i class=\"material-icons prefix\">email</i>\r\n");
      out.write("                    <input name=\"email\" type=\"email\" class=\"validate\" value=\"");
      out.print( usuario.getEmail() );
      out.write("\">\r\n");
      out.write("                    <label for=\"email\">E-mail</label>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <br>\r\n");
      out.write("\r\n");
      out.write("                <label for=\"escolhe_data\">Data de nascimento:</label>\r\n");
      out.write("                <div class=\"input-field col s6\">\r\n");
      out.write("                    <i class=\"material-icons prefix\">perm_contact_calendar</i>\r\n");
      out.write("                    <input name=\"dataNascimento\" type=\"date\" class=\"validate\" value=\"");
      out.print( usuario.getDataNascimento() );
      out.write("\">\r\n");
      out.write("                </div>\r\n");
      out.write("                \r\n");
      out.write("                <label for=\"escolaridade\">Escolaridade:</label>\r\n");
      out.write("                <input type='hidden' name=\"escolaridadeInput\" value=''>\r\n");
      out.write("                <div class=\"input-field col s6\">\r\n");
      out.write("                    <i class=\"material-icons prefix\">class</i>\r\n");
      out.write("                    <select id=\"escolaridade\">\r\n");
      out.write("                        ");

                        for(int i=0; i<listEscolaridade.size(); i++) {
                        
      out.write("\r\n");
      out.write("                            <option value=\"");
      out.print( listEscolaridade.get(i).getId() );
      out.write('"');
      out.write('>');
      out.print( listEscolaridade.get(i).getNome() );
      out.write("</option>\r\n");
      out.write("                        ");

                        }
                        
      out.write("\r\n");
      out.write("                    </select>\r\n");
      out.write("                </div>\r\n");
      out.write("                \r\n");
      out.write("                <script type=\"text/javascript\">\r\n");
      out.write("                    var select = document.getElementById(\"escolaridade\");\r\n");
      out.write("                    var escolaridade = select.options[");
      out.print( usuario.getEscolaridade().getId()-1 );
      out.write("];\r\n");
      out.write("                    escolaridade.selected = true;\r\n");
      out.write("                </script>\r\n");
      out.write("\r\n");
      out.write("                <br>\r\n");
      out.write("\r\n");
      out.write("                <label for=\"senha\">Senha:</label>\r\n");
      out.write("                <div class=\"input-field col s6\">\r\n");
      out.write("                    <i class=\"material-icons prefix\">lock_outline</i>\r\n");
      out.write("                    <input name=\"senha\" type=\"password\" class=\"validate\">\r\n");
      out.write("                </div>\r\n");
      out.write("                <label for=\"senha\">Confirmar senha:</label>\r\n");
      out.write("                <div class=\"input-field col s6\">\r\n");
      out.write("                    <input name=\"confirmarSenha\" type=\"password\">\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <br>\r\n");
      out.write("                <br>\r\n");
      out.write("                <br>\r\n");
      out.write("\r\n");
      out.write("                <div align=\"right\">\r\n");
      out.write("                    <button class=\"btn waves-effect waves-light\" type=\"button\" onclick=\"paginaInicial(document.formPerfil)\">Cancelar</button>\r\n");
      out.write("\r\n");
      out.write("                    <button class=\"btn waves-effect waves-light\" type=\"button\" name=\"action\" onclick=\"validarCamposPerfil(document.formPerfil)\">Confirmar\r\n");
      out.write("                        <i class=\"material-icons right\">send</i>\r\n");
      out.write("                    </button>\r\n");
      out.write("                </div>\r\n");
      out.write("            </form>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <br>\r\n");
      out.write("        <br>\r\n");
      out.write("\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Footer.jsp", out, false);
      out.write("\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
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
