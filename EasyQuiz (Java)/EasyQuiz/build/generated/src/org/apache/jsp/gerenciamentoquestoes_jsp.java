package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class gerenciamentoquestoes_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"/>\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1.0\"/>\n");
      out.write("        <title>EasyQuiz</title>\n");
      out.write("\n");
      out.write("  <!-- CSS  -->\n");
      out.write("        <link href=\"https://fonts.googleapis.com/icon?family=Material+Icons\" rel=\"stylesheet\">\n");
      out.write("\t<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/css/materialize.min.css\">\n");
      out.write("\t<link rel=\"stylesheet\" href=\"css/gq.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <!--- Javascrip -->\n");
      out.write("\n");
      out.write("<!-- nav cor #EE6363 -->\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Menu.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("    <div class=\"container\" style=\" z-index: 1\">\n");
      out.write("   \t\t<div class=\"container\">\n");
      out.write("\t\t\t\t<h4>Questões cadastradas:</h4>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div class=\"row\">\n");
      out.write("\t\t\t\t<div class=\"col s8 m9 l9\" id=\"divQuestoes\">\n");
      out.write("\t\t\t\t<div class=\"container questao\" id=\"questao1\">\t\n");
      out.write("\t\t\t\t\t<div class=\"deep-orange darken-1 white-text cabecalho\">\n");
      out.write("\t\t\t\t\t<strong>Física</strong> > Termodinâmica\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<div class=\"content-questao\">\n");
      out.write("\t\t\t\t\t\t<div class=\"container\" id=\"container-img1\">\n");
      out.write("\t\t\t\t\t\t\t<img id=\"imagem1\" class=\"responsive-img center\" src=\"Geladeira.png\">\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t<form action=\"#\" id=\"form1\">\n");
      out.write("\t\t\t\t\t\t\t<div>\n");
      out.write("\t\t\t\t\t\t\t\t<div id=\"enunciado1\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<p class=\"enun\">A invenção da geladeira proporcionou uma revolução no aproveitamento dos alimentos, ao permitir que fossem armazenados e transportados por longos períodos. A figura apresentada ilustra o processo cíclico de funcionamento de uma geladeira, em que um gás no interior de uma tubulação é forçado a circular entre o congelador e a parte externa da geladeira. É por meio dos processos de compressão, que ocorre na parte externa, e de expansão, que ocorre na parte interna, que o gás proporciona a troca de calor entre o interior e o exterior da geladeira. Nos processos de transformação de energia envolvidos no funcionamento da geladeira, </p>\n");
      out.write("\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t<div id=\"alternativas1\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<p>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input class=\"with-gap\" name=\"grupo1\" type=\"radio\" id=\"alternativa1\"  />\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<label for=\"alternativa1\"><b>a)</b> a expansão do gás é um processo que cede a energia necessária ao resfriamento da parte interna da geladeira. </label>\n");
      out.write("\t\t\t\t\t\t\t\t\t</p>\n");
      out.write("\t\t\t\t\t\t\t\t\t<p>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input class=\"with-gap\" name=\"grupo1\" type=\"radio\" id=\"alternativa2\"  />\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<label for=\"alternativa2\"><b>b)</b> o calor flui de forma não espontânea da parte mais fria, no interior, para a mais quente, no exterior da geladeira. </label>\n");
      out.write("\t\t\t\t\t\t\t\t\t</p>\n");
      out.write("\t\t\t\t\t\t\t\t\t<p>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input class=\"with-gap\" name=\"grupo1\" type=\"radio\" id=\"alternativa3\"  />\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<label for=\"alternativa3\"><b>c)</b> a quantidade de calor cedida ao meio externo é igual ao calor retirado da geladeira.</label>\n");
      out.write("\t\t\t\t\t\t\t\t</p>\n");
      out.write("\t\t\t\t\t\t\t\t<p>\n");
      out.write("\t\t\t\t\t\t\t\t\t<input class=\"with-gap\" name=\"grupo1\" type=\"radio\" id=\"alternativa4\"  />\n");
      out.write("\t\t\t\t\t\t\t\t\t<label for=\"alternativa4\"><b>d)</b> a eficiência é tanto maior quanto menos isolado termicamente do ambiente externo for o seu compartimento interno.</label>\n");
      out.write("\t\t\t\t\t\t\t\t</p>\n");
      out.write("\t\t\t\t\t\t\t\t<p>\n");
      out.write("\t\t\t\t\t\t\t\t\t<input class=\"with-gap\" name=\"grupo1\" type=\"radio\" id=\"alternativa5\"  />\n");
      out.write("\t\t\t\t\t\t\t\t\t<label for=\"alternativa5\"><b>e)</b> a energia retirada do interior pode ser devolvida à geladeira abrindo-se a sua porta, o que reduz seu consumo de energia.</label>\n");
      out.write("\t\t\t\t\t\t\t\t</p>\n");
      out.write("\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t<br>\n");
      out.write("\t\t\t\t\t\t\t<div class=\"row\">\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"col s6\" name=\"divEditar\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<a class=\"waves-effect waves-light btn deep-orange darken-1\" onclick=\"editarquestao('questao1', this)\"><i class=\"material-icons left\">edit</i>Editar questão</a>\n");
      out.write("\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"col s6\" name=\"divExcluir\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<a class=\"waves-effect waves-light btn deep-orange darken-1\"><i class=\"material-icons left\">delete</i>Excluir questão</a>\n");
      out.write("\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t</form>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div class=\"container questao\" id=\"questao2\">\t\n");
      out.write("\t\t\t\t\t<div class=\"deep-orange darken-1 white-text cabecalho\">\n");
      out.write("\t\t\t\t\t<strong>Português</strong> > Modernismo\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<div class=\"content-questao\">\n");
      out.write("\t\t\t\t\t\t<form action=\"#\" id=\"form2\">\n");
      out.write("\t\t\t\t\t\t\t<div>\n");
      out.write("\t\t\t\t\t\t\t\t<div id=\"enunciado2\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<p class=\"enun\">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>\n");
      out.write("\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t<div id=\"resposta-aberta2\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>\n");
      out.write("\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t<br>\n");
      out.write("\t\t\t\t\t\t\t<div class=\"row\">\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"col s6\" name=\"divEditar\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<a class=\"waves-effect waves-light btn deep-orange darken-1\" onclick=\"editarquestao('questao2', this)\"><i class=\"material-icons left\">edit</i>Editar questão</a>\n");
      out.write("\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"col s6\" name=\"divExcluir\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<a class=\"waves-effect waves-light btn deep-orange darken-1\"><i class=\"material-icons left\">delete</i>Excluir questão</a>\n");
      out.write("\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t</form>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div class=\"col s4 m3 l3\">\n");
      out.write("\t\t\t\t<a class=\"waves-effect waves-light btn deep-orange darken-1\" href=\"adicionarQuestao.jsp\"><i class=\"material-icons left\">add</i>Adicionar questão</a><!-- mudar cor -->\n");
      out.write("\t\t</div>\t\n");
      out.write("\t\t</div>\n");
      out.write("    </div>\n");
      out.write("    \n");
      out.write("    <br><br>\n");
      out.write("  ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Footer.jsp", out, false);
      out.write("\n");
      out.write("  <!--  Scripts-->\n");
      out.write("  <script src=\"js/gq.js\"></script>\n");
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
