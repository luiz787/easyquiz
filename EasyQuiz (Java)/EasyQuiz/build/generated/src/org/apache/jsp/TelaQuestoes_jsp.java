package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.domain.QuestaoFechadaResposta;
import model.domain.Perfil;
import model.domain.Usuario;
import model.service.ManterPerfil;
import model.serviceimpl.ManterPerfilImpl;
import model.daoimpl.PerfilDAOImpl;
import model.serviceimpl.ManterUsuarioImpl;
import model.service.ManterUsuario;
import model.service.ManterUsuario;
import model.daoimpl.UsuarioDAOImpl;
import java.time.ZoneId;
import java.sql.Timestamp;
import java.time.Instant;
import controller.Login;
import model.domain.QuestaoFechada;
import java.util.ArrayList;
import java.util.Enumeration;
import model.domain.Questao;
import java.util.List;
import controller.ListarQuestao;

public final class TelaQuestoes_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=UTF-8");
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

    int logado = Login.validarSessao(request, response);
    int contadorRespostaQuestao = (Integer) request.getSession().getAttribute("contadorRespostaQuestao");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

    if(request.getSession().getAttribute("numeroPagina")==null) {
        request.getSession().setAttribute("numeroPagina", 0);
    }
    int numeroPagina = (Integer) request.getSession().getAttribute("numeroPagina");
    int maxQuestao = 0;
    boolean showBotaoProximaPagina=false;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"/>\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1.0\"/>\r\n");
      out.write("        <title>EasyQuiz</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Menu.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"container\" >\r\n");

    if(request.getAttribute("listQuestao")!=null) {
        List<Questao> listQuestao = (List<Questao>) request.getAttribute("listQuestao");
        List<QuestaoFechada> listQuestaoFechada = (List<QuestaoFechada>) request.getAttribute("listQuestaoFechada");
        
        List<QuestaoFechadaResposta> listQuestaoFechadaResposta=null;
        if(request.getAttribute("listQuestaoFechadaResposta")!=null) {
            listQuestaoFechadaResposta = 
                (List<QuestaoFechadaResposta>) request.getAttribute("listQuestaoFechadaResposta");
        } else {
            listQuestaoFechadaResposta = 
                (List<QuestaoFechadaResposta>) request.getSession().getAttribute("listRespostaNaoLogado");
        }
        
        List<Questao> listQuestaoAbertaResposta=null;
        if(request.getSession().getAttribute("listTxtRespostaNaoLogado")!=null) {
            listQuestaoAbertaResposta = 
                    (List<Questao>) request.getSession().getAttribute("listTxtRespostaNaoLogado");
        }
        
        if((listQuestao.size()-(numeroPagina*5))<5) {
            maxQuestao=listQuestao.size();
        } else {
            maxQuestao=((numeroPagina*5)+5);
            showBotaoProximaPagina=true;
        }
        
        for(int i=(5*numeroPagina); i<maxQuestao; i++) {
            Questao questao = listQuestao.get(i);
            Long cod_Questao = questao.getId();
            if(questao.getIdTipo()=='F' && listQuestaoFechada!=null) {
                ArrayList<QuestaoFechada> alternativas = new ArrayList();
                for (QuestaoFechada object : listQuestaoFechada) {
                    if (object.getQuestao().getId() == cod_Questao) {
                        alternativas.add(object);
                    }
                }
                Long resposta=null;
                QuestaoFechadaResposta questaoFechadaResposta;
                if(logado==1) {
                    questaoFechadaResposta = new QuestaoFechadaResposta();
                    if(listQuestaoFechadaResposta!=null) {
                        for (QuestaoFechadaResposta object : listQuestaoFechadaResposta) {
                            if (object.getQuestao().getId() == cod_Questao) {
                                questaoFechadaResposta = object;
                            }
                        }
                    }
                    resposta = questaoFechadaResposta.getSeqQuestaoResposta();
                } else {
                    questaoFechadaResposta = new QuestaoFechadaResposta();
                    if(listQuestaoFechadaResposta!=null) {
                        for (QuestaoFechadaResposta object : listQuestaoFechadaResposta) {
                            if (object.getQuestao().getId() == cod_Questao) {
                                questaoFechadaResposta = object;
                            }
                        }
                    }
                    resposta = questaoFechadaResposta.getSeqQuestaoResposta();
                }
                
                

      out.write("\r\n");
      out.write("            <div class=\"row\" >\r\n");
      out.write("                <div class=\"col s12 m4\" > \r\n");
      out.write("                    <div class=\"card\" >\r\n");
      out.write("                        <div class=\"card-panel #f4511e deep-orange darken-1 white-text\">\r\n");
      out.write("                            <div>\r\n");
      out.write("                                <b style=\"padding-top: 0px\">Disciplina: </b><span id='");
      out.print("disciplina"+i);
      out.write('\'');
      out.write('>');
      out.print( questao.getDisciplina().getNome() );
      out.write("</span>\r\n");
      out.write("                                <b style=\"padding-left:50%;padding-top: 0px\">Dificuldade: </b><span id='");
      out.print("dificuldade"+i);
      out.write('\'');
      out.write('>');
      out.print( questao.getDificuldade().getDescricao() );
      out.write("</span>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div>\r\n");
      out.write("                                <span id='");
      out.print("modulo"+i);
      out.write("' style=\"\"><b>Módulo: </b>");
      out.print( questao.getModulo().getNome() );
      out.write("</span>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        ");

                            if(questao.getImgEnunciado()!=null) {
                        
      out.write("\r\n");
      out.write("                        <div class=\"card-image\">\r\n");
      out.write("                            <img id='");
      out.print("imagem"+i);
      out.write("' class=\"responsive-img\" src=\"/EasyQuiz/servletweb?acao=CarregaImagem&questao=");
      out.print( questao.getId());
      out.write("\">\r\n");
      out.write("                        </div>\r\n");
      out.write("                        ");

                            }
                        
      out.write("\r\n");
      out.write("                        <div class=\"card-content\">\r\n");
      out.write("                            <div id='");
      out.print("enunciado"+i);
      out.write("'>\r\n");
      out.write("                                <p><b>");
      out.print( questao.getTxtEnunciado() );
      out.write("</b></p>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div id='");
      out.print("alternativas"+i);
      out.write("'>\r\n");
      out.write("                                <form method=\"post\" name='");
      out.print("formInserirResposta"+i);
      out.write("'>\r\n");
      out.write("                                    <input type='hidden' name='index' value='");
      out.print( i );
      out.write("'>\r\n");
      out.write("                                    <input type='hidden' name='table' value='QuestaoFechadaResposta'>\r\n");
      out.write("                                    <input type='hidden' name='acao' value='gravar'>\r\n");
      out.write("                                    <input type='hidden' name='logado' value='");
      out.print( logado );
      out.write("'>\r\n");
      out.write("                                    <input type='hidden' name='contadorRespostaQuestao' value='");
      out.print( contadorRespostaQuestao );
      out.write("'>\r\n");
      out.write("                                    <input type='hidden' name='questao' value='");
      out.print( questao.getId() );
      out.write("'>\r\n");
      out.write("                                    <input type='hidden' name='tipoQuestao' value='");
      out.print( questao.getIdTipo() );
      out.write("'>\r\n");
      out.write("                                    <input type='hidden' name='respostaCorreta' value='");
      out.print( questao.getSeqQuestaoCorreta() );
      out.write("'>\r\n");
      out.write("                                    <input type='hidden' name='resposta' id='");
      out.print("resposta"+i);
      out.write("' value='");
      out.print( resposta );
      out.write("'>\r\n");
      out.write("                                    \r\n");

                                    char letra='a';
                                    for(int j=0; j<alternativas.size(); j++) {
                                        

      out.write("\r\n");
      out.write("                                    <p>\r\n");
      out.write("                                        <input class=\"with-gap\" name='");
      out.print("grupo"+i);
      out.write("' type=\"radio\" id='");
      out.print("grupo"+i+"alternativa"+j);
      out.write("'  />\r\n");
      out.write("                                        <label id='");
      out.print("grupo"+i+"txtAlternativa"+j);
      out.write("' for='");
      out.print("grupo"+i+"alternativa"+j);
      out.write("'><b>");
      out.print(((char)(letra+j))+")");
      out.write("</b> ");
      out.print( alternativas.get(j).getTxtAlternativa() );
      out.write(" </label>\r\n");
      out.write("                                    </p>\r\n");

                                    }

      out.write("\r\n");
      out.write("                                </form>\r\n");
      out.write("                                <br>\r\n");
      out.write("                                <h6 id='");
      out.print("resultado"+i);
      out.write("' ></h6>\r\n");
      out.write("                                <script type=\"text/javascript\">\r\n");
      out.write("                                        var form = document.getElementsByName('");
      out.print("formInserirResposta"+i);
      out.write("')[0];\r\n");
      out.write("                                        var index = form.index.value;\r\n");
      out.write("                                        var resposta = document.getElementById(\"resposta\"+index).value;\r\n");
      out.write("                                        if(resposta!='null') {\r\n");
      out.write("                                            var alternativa = \"grupo");
      out.print(i);
      out.write("alternativa\"+(resposta-1);\r\n");
      out.write("                                            var radioAlternativa = document.getElementById(alternativa);\r\n");
      out.write("                                            radioAlternativa.checked = true;\r\n");
      out.write("\r\n");
      out.write("                                            var respostaCorreta = form.respostaCorreta.value;\r\n");
      out.write("                                            var letra = 64;\r\n");
      out.write("                                            var letra = (letra+parseInt(respostaCorreta));\r\n");
      out.write("                                            if(resposta==respostaCorreta) {\r\n");
      out.write("                                                var resultado = document.querySelector(\"#resultado\"+index);\r\n");
      out.write("                                                resultado.style.color='green';\r\n");
      out.write("                                                resultado.innerHTML=\"Parabéns! Você acertou!\";\r\n");
      out.write("                                            } else {\r\n");
      out.write("                                                var resultado = document.querySelector(\"#resultado\"+index);\r\n");
      out.write("                                                resultado.style.color='red';\r\n");
      out.write("                                                resultado.innerHTML=\"Você errou! Resposta: \"+String.fromCharCode(letra);\r\n");
      out.write("                                            }\r\n");
      out.write("                                        }\r\n");
      out.write("                                </script>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"card-action\">\r\n");
      out.write("                            <button onclick=\"ResponderQuestao(document.");
      out.print("formInserirResposta"+i);
      out.write(")\" class=\"btn waves-effect waves-orange orange right\" style=\"background-color: #f4511e !important;\" id='");
      out.print("responder"+i);
      out.write("'>Responder</button>\r\n");
      out.write("                            <a id='");
      out.print("forum"+i);
      out.write("' href=\"/EasyQuiz/servletweb?acao=ListarForum&questao=");
      out.print( questao.getId());
      out.write("\"><b>Forum</b></a>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");

            } else if(questao.getIdTipo()=='A') {
                String resposta=null;
                Questao questaoAbertaResposta = new Questao();
                    if(listQuestaoAbertaResposta!=null) {
                        for (Questao object : listQuestaoAbertaResposta) {
                            if (object.getId() == cod_Questao) {
                                questaoAbertaResposta = object;
                            }
                        }
                    }
                    resposta = questaoAbertaResposta.getTxtResposta();

      out.write("\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("                <div class=\"col s12 m4\">\r\n");
      out.write("                    <div class=\"card\">\r\n");
      out.write("                        <div class=\"card-panel #f4511e deep-orange darken-1 white-text\">\r\n");
      out.write("                            <div style=\"\">\r\n");
      out.write("                                <b style=\"padding-top: 0px\">Disciplina: </b><span id='");
      out.print("disciplina"+i);
      out.write('\'');
      out.write('>');
      out.print( questao.getDisciplina().getNome() );
      out.write("</span>\r\n");
      out.write("                                <b style=\"padding-left:50%;padding-top: 0px\">Dificuldade: </b><span id='");
      out.print("dificuldade"+i);
      out.write('\'');
      out.write('>');
      out.print( questao.getDificuldade().getDescricao() );
      out.write("</span>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div>\r\n");
      out.write("                                <span id='");
      out.print("modulo"+i);
      out.write("' style=\"\"><b>Módulo: </b>");
      out.print( questao.getModulo().getNome() );
      out.write("</span>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        ");

                            if(questao.getImgEnunciado()!=null) {
                        
      out.write("\r\n");
      out.write("                        <div class=\"card-image\">\r\n");
      out.write("                            <img id='");
      out.print("imagem"+i);
      out.write("' class=\"responsive-img\" src=\"/EasyQuiz/servletweb?acao=CarregaImagem&questao=");
      out.print( questao.getId());
      out.write("\">\r\n");
      out.write("                        </div>\r\n");
      out.write("                        ");

                            }
                        
      out.write("\r\n");
      out.write("                        <div class=\"card-content\">\r\n");
      out.write("                            <div id='");
      out.print("enunciado"+i);
      out.write("'>\r\n");
      out.write("                                <p><b>");
      out.print( questao.getTxtEnunciado() );
      out.write("</b></p>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div id='");
      out.print("respostaAberta"+i);
      out.write("'>\r\n");
      out.write("                                <form method=\"post\" name='");
      out.print("formInserirResposta"+i);
      out.write("'>\r\n");
      out.write("                                    <input type='hidden' name='index' value='");
      out.print( i );
      out.write("'>\r\n");
      out.write("                                    <input type='hidden' name='table' value='QuestaoAbertaResposta'>\r\n");
      out.write("                                    <input type='hidden' name='logado' value='");
      out.print( logado );
      out.write("'>\r\n");
      out.write("                                    <input type='hidden' name='contadorRespostaQuestao' value='");
      out.print( contadorRespostaQuestao );
      out.write("'>\r\n");
      out.write("                                    <input type='hidden' name='questao' value='");
      out.print( questao.getId() );
      out.write("'>\r\n");
      out.write("                                    <input type='hidden' name='tipoQuestao' value='");
      out.print( questao.getIdTipo() );
      out.write("'>\r\n");
      out.write("                                    <input type='hidden' name='respostaBase' value='");
      out.print( questao.getTxtResposta() );
      out.write("'>\r\n");
      out.write("                                    <input type='hidden' name='resposta' id='");
      out.print("resposta"+i);
      out.write("' value='");
      out.print( resposta );
      out.write("'>\r\n");
      out.write("                                    <div class=\"row\">\r\n");
      out.write("                                        <div class=\"input-field col s12\">\r\n");
      out.write("                                            <textarea id='");
      out.print("textArea"+i);
      out.write("' class=\"materialize-textarea\"></textarea>\r\n");
      out.write("                                            <label for='");
      out.print("textArea"+i);
      out.write("'>Resposta:</label>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </form>\r\n");
      out.write("                                <br>\r\n");
      out.write("                                <div id='");
      out.print("resultado"+i);
      out.write("' class=\"row\">\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <script type=\"text/javascript\">\r\n");
      out.write("                                        var form = document.getElementsByName('");
      out.print("formInserirResposta"+i);
      out.write("')[0];\r\n");
      out.write("                                        var index = form.index.value;\r\n");
      out.write("                                        var resposta = document.getElementById(\"resposta\"+index).value;\r\n");
      out.write("                                        if(resposta!='null') {\r\n");
      out.write("                                            var txtResposta = \"");
      out.print("textArea"+i);
      out.write("\";\r\n");
      out.write("                                            var textAreaResposta = document.getElementById(txtResposta);\r\n");
      out.write("                                            textAreaResposta.innerHTML = resposta;\r\n");
      out.write("\r\n");
      out.write("                                            var respostaBase = form.respostaBase.value;\r\n");
      out.write("                                            var resultado = document.querySelector(\"#resultado\"+index);\r\n");
      out.write("                                            resultado.style.color='black';\r\n");
      out.write("                                            resultado.style.backgroundColor='lightgreen';\r\n");
      out.write("                                            resultado.innerHTML=\"<b>Resposta Base:</b><p>\"+respostaBase+\"</p>\";\r\n");
      out.write("                                        }\r\n");
      out.write("                                </script>\r\n");
      out.write("                                    \r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"card-action\">\r\n");
      out.write("                            <button onclick=\"ResponderQuestao(document.");
      out.print("formInserirResposta"+i);
      out.write(")\" class=\"btn waves-effect waves-orange orange right\" style=\"background-color: #f4511e !important;\" id='");
      out.print("responder"+i);
      out.write("'>Responder</button>\r\n");
      out.write("                            <a id='");
      out.print("forum"+i);
      out.write("' href=\"/EasyQuiz/servletweb?acao=ListarForum&questao=");
      out.print( questao.getId());
      out.write("\"><b>Forum</b></a>\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");

            }
        }
    } else {

      out.write("\r\n");
      out.write("<h2 style=\"text-align: center;\"><b> Não há questões cadastradas!</b></h2>\r\n");

        for(int i=0; i<20; i++) {

      out.write("\r\n");
      out.write("<br>\r\n");

        }
    }

      out.write("  \r\n");
      out.write("        </div>\r\n");
      out.write("        <div>\r\n");
      out.write("        <h6 style=\"text-align: center;\">Página: ");
      out.print((numeroPagina+1));
      out.write("</h6>\r\n");
      out.write("        <form name=\"formPagina\" action='post'>\r\n");
      out.write("            <input type='hidden' name='acao' value=''>\r\n");
      out.write("            <input type='hidden' name='numeroPagina' value='");
      out.print((numeroPagina+1));
      out.write("'>\r\n");
      out.write("            <input type='hidden' name='maxQuestao' value='");
      out.print(maxQuestao);
      out.write("'>\r\n");
      out.write("            <div class=\"card-action\">\r\n");
      out.write("            ");

                if(showBotaoProximaPagina) {
            
      out.write("\r\n");
      out.write("            \r\n");
      out.write("            <button onclick=\"proximaPagina(document.formPagina)\" class=\"btn waves-effect waves-orange orange right\" style=\"background-color: #f4511e !important; \" id=\"Próxima\">Próxima Página</button>\r\n");
      out.write("            \r\n");
      out.write("            ");

                }
                if(numeroPagina>0) {
            
      out.write("\r\n");
      out.write("            <button onclick=\"paginaAnterior(document.formPagina)\" class=\"btn waves-effect waves-orange orange right\" style=\"background-color: #f4511e !important; \" id=\"Anterior\">Página Anterior</button>\r\n");
      out.write("            \r\n");
      out.write("            ");

                }
            
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("        </form>\r\n");
      out.write("        </div>\r\n");
      out.write("        <br>\r\n");
      out.write("        <br>\r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Footer.jsp", out, false);
      out.write("\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
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
