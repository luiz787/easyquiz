package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import controller.Login;
import model.domain.Disciplina;

public final class adicionarQuestao_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");

    int logado = Login.validarSessao(request, response);

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"/>\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1.0\"/>\n");
      out.write("        <title>EasyQuiz</title>\n");
      out.write("\n");
      out.write("        <!-- CSS  -->\n");
      out.write("        <link href=\"https://fonts.googleapis.com/icon?family=Material+Icons\" rel=\"stylesheet\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/css/materialize.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/gq.css\">\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <!--- Javascrip -->\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            function mostrarform() {\n");
      out.write("                var element = document.getElementById(\"pesquisa\");\n");
      out.write("                if (element.style.display == \"none\") {\n");
      out.write("                    element.style.display = \"block\";\n");
      out.write("                } else {\n");
      out.write("                    element.style.display = \"none\";\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("        <!-- nav cor #EE6363 -->\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Menu.jsp", out, false);
      out.write("\n");
      out.write("        ");

            if (logado != 0) {
        
      out.write("        \n");
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"container\" style=\" z-index: 1\">\n");
      out.write("            <form id=\"cadastro\" method=\"GET\" action=\"cadastro.jsp\">\n");
      out.write("                <div>\n");
      out.write("                    <h3>Cadastrar questão</h3>\n");
      out.write("                    Tipo da questão:\n");
      out.write("                    <p>\n");
      out.write("                        <input class=\"with-gap\" name=\"tipo\" type=\"radio\" id=\"tipoAberta\" value=\"aberta\" onclick=\"questaoAberta()\"/>\n");
      out.write("                        <label for=\"tipoAberta\">Aberta</label>\n");
      out.write("                    </p>\n");
      out.write("                    <p>\n");
      out.write("                        <input class=\"with-gap\" name=\"tipo\" type=\"radio\" id=\"tipoFechada\" value=\"fechada\" checked=\"checked\" onclick=\"window.location.reload()\"/>\n");
      out.write("                        <label for=\"tipoFechada\">Fechada</label>\n");
      out.write("                    </p>\n");
      out.write("                </div>\n");
      out.write("                <div id=\"dados\">\n");
      out.write("                    <div class=\"input-field\">\n");
      out.write("                        <select id=\"disciplina\" name=\"disciplina\">\n");
      out.write("                            <option value=\"\" disabled selected>Escolha a disciplina</option>\n");
      out.write("                            <option value=\"Física\">Física</option>\n");
      out.write("                            <option value=\"Matemática\">Matemática</option>\n");
      out.write("                            <option value=\"Sistemas Operacionais\">Sistemas Operacionais</option>\n");
      out.write("                        </select>\n");
      out.write("                        <label>Disciplina</label>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"input-field\">\n");
      out.write("                        <select id=\"modulo\" name=\"modulo\">\n");
      out.write("                            <option value=\"\" disabled selected>Escolha o módulo</option>\n");
      out.write("                            <option value=\"Máquinas térmicas\">Máquinas térmicas</option>\n");
      out.write("                            <option value=\"Óptica\">Óptica</option>\n");
      out.write("                            <option value=\"Termodinâmica\">Termodinâmica</option>\n");
      out.write("                        </select>\n");
      out.write("                        <label>Módulo</label>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"input-field\">\n");
      out.write("                        <select id=\"dificuldade\" name=\"dificuldade\">\n");
      out.write("                            <option value=\"\" disabled selected>Escolha a dificuldade</option>\n");
      out.write("                            <option value=\"Fácil\">Fácil</option>\n");
      out.write("                            <option value=\"Médio\">Médio</option>\n");
      out.write("                            <option value=\"Difícil\">Difícil</option>\n");
      out.write("                            <option value=\"Desafio\">Desafio</option>\n");
      out.write("                        </select>\n");
      out.write("                        <label>Módulo</label>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div id=\"divEnunciado\">\n");
      out.write("                    <h5>Enunciado</h5>\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"input-field col s12\">\n");
      out.write("                            <textarea name=\"enunciado\" id=\"enunciado\" class=\"materialize-textarea\"></textarea>\n");
      out.write("                            <label for=\"enunciado\">Enunciado</label>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div id=\"divAlternativas\">\n");
      out.write("                    <h5>Alternativas</h5>\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"input-field col s2\">\n");
      out.write("                            <input class=\"with-gap\" name=\"group1\" type=\"radio\" id=\"test1\" value=\"0\" />\n");
      out.write("                            <label for=\"test1\">Correta</label>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"input-field col s7\">\n");
      out.write("                            <textarea name=\"alt0\" id=\"alt0\" class=\"materialize-textarea\"></textarea>\n");
      out.write("                            <label for=\"textarea1\">Alternativa</label>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col s3\">\n");
      out.write("                            <a class=\"waves-effect waves-light btn deep-orange darken-1\" onclick=\"excluirAlternativa(this)\"><i class=\"material-icons left\">delete</i>Excluir</a>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"input-field col s2\">\n");
      out.write("                            <input class=\"with-gap\" name=\"group1\" type=\"radio\" id=\"test2\" value=\"1\"/>\n");
      out.write("                            <label for=\"test2\">Correta</label>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"input-field col s7\">\n");
      out.write("                            <textarea name=\"alt1\" id=\"alt1\" class=\"materialize-textarea\"></textarea>\n");
      out.write("                            <label for=\"textarea1\">Alternativa</label>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col s3\">\n");
      out.write("                            <a class=\"waves-effect waves-light btn deep-orange darken-1\" onclick=\"excluirAlternativa(this)\"><i class=\"material-icons left\">delete</i>Excluir</a>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"input-field col s2\">\n");
      out.write("                            <input class=\"with-gap\" name=\"group1\" type=\"radio\" id=\"test3\" value=\"2\"/>\n");
      out.write("                            <label for=\"test3\">Correta</label>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"input-field col s7\">\n");
      out.write("                            <textarea name=\"alt2\" id=\"alt2\" class=\"materialize-textarea\"></textarea>\n");
      out.write("                            <label for=\"textarea1\">Alternativa</label>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col s3\">\n");
      out.write("                            <a class=\"waves-effect waves-light btn deep-orange darken-1\" onclick=\"excluirAlternativa(this)\"><i class=\"material-icons left\">delete</i>Excluir</a>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"input-field col s2\">\n");
      out.write("                            <input class=\"with-gap\" name=\"group1\" type=\"radio\" id=\"test4\" value=\"3\"/>\n");
      out.write("                            <label for=\"test4\">Correta</label>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"input-field col s7\">\n");
      out.write("                            <textarea name=\"alt3\" id=\"alt3\" class=\"materialize-textarea\"></textarea>\n");
      out.write("                            <label for=\"textarea1\">Alternativa</label>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col s3\">\n");
      out.write("                            <a class=\"waves-effect waves-light btn deep-orange darken-1\" onclick=\"excluirAlternativa(this)\"><i class=\"material-icons left\">delete</i>Excluir</a>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col s12\">\n");
      out.write("                            <a class=\"waves-effect waves-light btn deep-orange darken-1\" onclick=\"addAlternativa(this)\"><i class=\"material-icons left\">add</i>Adicionar alternativa</a>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"row\" id=\"linhafinal\">\n");
      out.write("                    <div class=\"col s6\">\n");
      out.write("                        <button class=\"btn waves-effect waves-light deep-orange darken-1\" type=\"submit\" name=\"action\">Confirmar\n");
      out.write("                            <i class=\"material-icons right\">send</i>\n");
      out.write("                        </button>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col s6\">\n");
      out.write("                        <a class=\"waves-effect waves-light btn deep-orange darken-1\" href=\"gerenciamentoquestoes.html\"><i class=\"material-icons left\">cancel</i>Cancelar</a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("        ");

        } else {
        
      out.write("\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <h4>Funcionalidade exclusiva para professores.</h4>\n");
      out.write("            <a class=\"waves-effect waves-light btn deep-orange darken-1\" href=\"index.jsp\">Voltar</a>\n");
      out.write("        </div>\n");
      out.write("        ");

            }
        
      out.write("    \n");
      out.write("        <br><br>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Footer.jsp", out, false);
      out.write("\n");
      out.write("        <!--  Scripts-->\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/materialize/0.99.0/js/materialize.min.js\"></script>\n");
      out.write("        <script src=\"js/addQuestao.js\"></script>\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("                                            $(document).ready(function () {\n");
      out.write("                                                $('select').material_select();\n");
      out.write("                                            });\n");
      out.write("        </script>\n");
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
