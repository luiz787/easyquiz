package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.serviceimpl.ManterEscolaridadeImpl;
import model.domain.Escolaridade;
import model.service.ManterEscolaridade;
import model.daoimpl.EscolaridadeDAOImpl;
import model.domain.Usuario;
import model.serviceimpl.ManterUsuarioImpl;
import model.service.ManterUsuario;
import model.service.ManterUsuario;
import model.daoimpl.UsuarioDAOImpl;
import model.daoimpl.UsuarioDAOImpl;
import model.serviceimpl.ManterPerfilImpl;
import model.service.ManterPerfil;
import model.service.ManterPerfil;
import model.daoimpl.PerfilDAOImpl;
import model.daoimpl.PerfilDAOImpl;
import model.domain.Perfil;
import controller.ListarQuestao;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

            /*
            ManterPerfil manterPerfil = new ManterPerfilImpl(PerfilDAOImpl.getInstance());
            Perfil perfil = manterPerfil.getPerfilById(new Long(1));
            ManterEscolaridade manterEscolaridade = new ManterEscolaridadeImpl(EscolaridadeDAOImpl.getInstance());
            Escolaridade escolaridade = manterEscolaridade.getEscolaridadeById(new Long(1));
            ManterUsuario manterUsuario = new ManterUsuarioImpl(UsuarioDAOImpl.getInstance());
            Usuario usuario = new Usuario();
            usuario.setDataNascimento(java.sql.Date.valueOf("2010-05-28"));
            usuario.setNome("Gabriel Victor");
            usuario.setPerfil(perfil);
            usuario.setEmail("gabrielvictor@gmail.com");
            usuario.setSenha("123456789");
            usuario.setEscolaridade(escolaridade);
            
            Long id = manterUsuario.cadastrarUsuario(usuario);
            System.out.println("ID usuario: "+id);
            */
            
    request.getSession().setAttribute("contadorRespostaQuestao", 0);
    String jsp = ListarQuestao.execute(request);
    RequestDispatcher rd = request.getRequestDispatcher(jsp);
    rd.forward(request, response);

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
