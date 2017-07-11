package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

    /*
    ManterPerfil manterPerfil = new ManterPerfilImpl(PerfilDAOImpl.getInstance());
    Perfil perfil = manterPerfil.getPerfilById(new Long(2));
    ManterUsuario manterUsuario = new ManterUsuarioImpl(UsuarioDAOImpl.getInstance());
    Usuario usuario = new Usuario();
    usuario.setDat_Nascimento(java.sql.Date.valueOf("2017-07-09"));
    usuario.setNom_Usuario("Victor Gabriel");
    usuario.setPerfil(perfil);
    usuario.setTxt_Email("andromenus@gmail.com");
    usuario.setTxt_Senha("123");
    manterUsuario.cadastrarUsuario(usuario);
    */
    /*
    if(request.getSession().getAttribute("cod_Usuario")==null) {
        Login.execute(request);
    }
    */
    int logado = Login.validarSessao(request, response);
    int contadorRespostaQuestao = (Integer) request.getSession().getAttribute("contadorRespostaQuestao");

      out.write("\n");
      out.write("\n");
      out.write("\n");

    if(request.getSession().getAttribute("numeroPagina")==null) {
        request.getSession().setAttribute("numeroPagina", 0);
    }
    int numeroPagina = (Integer) request.getSession().getAttribute("numeroPagina");
    int maxQuestao = 0;

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"/>\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1.0\"/>\n");
      out.write("        <script type=\"text/javascript\" language=\"JavaScript\" src=\"js/webvalida.js\"></script>\n");
      out.write("        <title>EasyQuiz</title>\n");
      out.write("\n");
      out.write("        <!-- CSS  -->\n");
      out.write("        <link href=\"https://fonts.googleapis.com/icon?family=Material+Icons\" rel=\"stylesheet\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/materialize.css\"/>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\"/>\n");
      out.write("\n");
      out.write("        <style type=\"text/css\">\n");
      out.write("            [type=\"radio\"].with-gap:checked + label:before,\n");
      out.write("            [type=\"radio\"].with-gap:checked + label:after {\n");
      out.write("              border: 2px solid #f4511e;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            [type=\"radio\"].with-gap:checked + label:after {\n");
      out.write("              background-color: #f4511e;\n");
      out.write("            }\n");
      out.write("            .row {\n");
      out.write("              z-index: 1;\n");
      out.write("            }\n");
      out.write("            .card {\n");
      out.write("              width: 700px;\n");
      out.write("              z-index: 0;\n");
      out.write("            }\n");
      out.write("            .card-panel {\n");
      out.write("              width: 100%;\n");
      out.write("              height: 45px;\n");
      out.write("              padding-top: 0%;\n");
      out.write("            }\n");
      out.write("            .card-image {\n");
      out.write("              height: 250px;\n");
      out.write("            }\n");
      out.write("            .card-image img {\n");
      out.write("              max-height: 100%;\n");
      out.write("              max-width: 100%;\n");
      out.write("            }\n");
      out.write("            .card-content {\n");
      out.write("                height: 60%;\n");
      out.write("            }\n");
      out.write("            .card-action {\n");
      out.write("              height: 70px;\n");
      out.write("            }\n");
      out.write("            .container{\n");
      out.write("              width: 100%;\n");
      out.write("            }\n");
      out.write("            label{\n");
      out.write("              color: black;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <nav class=\"nav-extended\" style=\"background-color:#FFFFFF;\">\n");
      out.write("            <div class=\"container\" style=\"display: inline; margin-left: 50px;\">\n");
      out.write("                <a id=\"logo-container\" href=\"#\" style=\"color:#47525E; font-size: 32px;\">EasyQuiz</a>\n");
      out.write("                <ul id=\"side-nav\" class=\"right hide-on-med-and-down\">\n");
      out.write("                    <li> \n");
      out.write("                        <input id=\"email\" placeholder=\"email\" type=\"email\" class=\"form-control\" style=\"color: #696969;border-color:#D3D3D3;\">\n");
      out.write("                    </li>\n");
      out.write("                    <li>&ensp;</li>\n");
      out.write("                    <li>\n");
      out.write("                        <input id=\"password\" placeholder=\"senha\" type=\"password\" class=\"validate\" style=\"color: #696969;border-color:#D3D3D3;\">\n");
      out.write("                    </li>\n");
      out.write("                    <a class=\"btn-small waves-effect waves-light grey darken-2 btn\" href=\"#\">Login</a>\n");
      out.write("                    <a class=\"btn-small waves-effect waves-light grey darken-2 btn\" href=\"#\">Cadastrar</a>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"row\" style=\"background-color: #EE6363; margin-top: 15px;\" >\n");
      out.write("                <div class=\"col s8\" >Matérias comuns:\n");
      out.write("                    <a id=\"botao-matematica\" class=\"waves-effect waves-light\" style=\"margin-left: 5px; margin-right: 5px; padding-left: 5px; padding-right: 5px; padding-top: 2px; background-color: #E5E9F2; color: #47525E\">Matemática</a>\n");
      out.write("                    <a id=\"botao-portugues\" class=\"waves-effect waves-light\" style=\"margin-left: 5px; margin-right: 5px; padding-left: 5px; padding-right: 5px; padding-top: 2px; background-color: #E5E9F2; color: #47525E\">Português</a>\n");
      out.write("                    <a id=\"botao-fisica\" class=\"waves-effect waves-light\" style=\"margin-left: 5px; margin-right: 5px; padding-left: 5px; padding-right: 5px; padding-top:    2px; background-color: #E5E9F2; color: #47525E\">Física</a>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col s4\">\n");
      out.write("                    <a class=\"btn-small waves-effect waves-light grey darken-2 btn\" onclick=\"mostrarform()\">Filtrar</a></li>  \t\t\t\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"row \" id=\"pesquisa\" style=\"display: none; position: absolute;   width: 47%; background: rgba(255, 255, 255, 0.7);\">\n");
      out.write("                <div class=\"col s12 offset-s12\" id=\"pesquisa\" style=\"border: 4px solid; border-color:#D3D3D3; background: rgba(255, 255, 255, 1.0); ; text-align:center;border-radius: 10px; z-index: 2;\" >\n");
      out.write("                    <form>\n");
      out.write("                        <input id=\"search\" type=\"search\" placeholder=\"Busque por palavras chave\" style=\"color: #696969;\">\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"input-field col s6\">\n");
      out.write("                                <select id=\"nivel\">\n");
      out.write("                                    <option value=\"\" disabled selected>Escolha uma Dificuldade</option>\n");
      out.write("                                    <option value=\"1\">Fácil</option>\n");
      out.write("                                    <option value=\"2\">Médio</option>\n");
      out.write("                                    <option value=\"3\">Difícil</option>\n");
      out.write("                                    <option value=\"4\">Desafio</option>\n");
      out.write("                                    <option value=\"0\">Nenhum</option>\n");
      out.write("                                </select>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"input-field col s6\">\n");
      out.write("                                <select id=\"materia\">\n");
      out.write("                                    <option value=\"\" disabled selected>Escolha uma Matéria</option>\n");
      out.write("                                    <option value=\"1\">Matemática</option>\n");
      out.write("                                    <option value=\"2\">Português</option>\n");
      out.write("                                    <option value=\"3\">Física</option>\n");
      out.write("                                    <option value=\"4\">Geografia</option>\n");
      out.write("                                    <option value=\"5\">História</option>\n");
      out.write("                                    <option value=\"6\">Química</option>\n");
      out.write("                                    <option value=\"7\">Inglês</option>\n");
      out.write("                                    <option value=\"0\">Nenhum</option>\n");
      out.write("                                </select>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"input-field col s6\">\n");
      out.write("                                <select id=\"tipo\">\n");
      out.write("                                    <option value=\"\" disabled selected>Escolha um tipo</option>\n");
      out.write("                                    <option value=\"1\">Aberta</option>\n");
      out.write("                                    <option value=\"2\">Fechada</option>\n");
      out.write("                                    <option value=\"3\">Nenhum</option>\n");
      out.write("                                </select>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"input-field col s6\">\n");
      out.write("                                <select id=\"materia\">\n");
      out.write("                                    <option value=\"\" disabled selected>Escolha um módulo</option>\n");
      out.write("                                    <option value=\"0\">Nenhum</option>\n");
      out.write("                                </select>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </form>\n");
      out.write("                    <button class=\"btn-large waves-effect waves-light grey darken-2\" type=\"submit\" name=\"action\">avançar \n");
      out.write("                        <i class=\"material-icons right\">send</i>\n");
      out.write("                    </button>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("\n");
      out.write("        <div class=\"container\" >\n");

    if(request.getAttribute("listQuestao")!=null) {
        List<Questao> listQuestao = (List<Questao>) request.getAttribute("listQuestao");
        List<QuestaoFechada> listQuestaoFechada = (List<QuestaoFechada>) request.getAttribute("listQuestaoFechada");
        
        if((listQuestao.size()-(numeroPagina*5))<5) {
            maxQuestao=listQuestao.size();
        } else {
            maxQuestao=((numeroPagina*5)+5);
        }
        for(int i=(5*numeroPagina); i<maxQuestao; i++) {
            Questao questao = listQuestao.get(i);
            if(questao.getIdTipo()=='F') {
                ArrayList<QuestaoFechada> alternativas = new ArrayList();
                Long cod_Questao = questao.getId();
                for (QuestaoFechada object : listQuestaoFechada) {
                    if (object.getQuestao().getId() == cod_Questao) {
                        alternativas.add(object);
                    }
                }

      out.write("\n");
      out.write("            <div class=\"row\" >\n");
      out.write("                <div class=\"col s12 m4\" > \n");
      out.write("                    <div class=\"card\" >\n");
      out.write("                        <div class=\"card-panel #f4511e deep-orange darken-1 white-text\">\n");
      out.write("                            <div>\n");
      out.write("                                <b style=\"padding-top: 0px\">Disciplina: </b><span id='");
      out.print("disciplina"+i);
      out.write('\'');
      out.write('>');
      out.print( questao.getDisciplina().getNome() );
      out.write("</span>\n");
      out.write("                                <b style=\"padding-left:50%;padding-top: 0px\">Dificuldade: </b><span id='");
      out.print("dificuldade"+i);
      out.write('\'');
      out.write('>');
      out.print( questao.getDificuldade().getDescricao() );
      out.write("</span>\n");
      out.write("                            </div>\n");
      out.write("                            <div>\n");
      out.write("                                <span id='");
      out.print("modulo"+i);
      out.write("' style=\"\"><b>Módulo: </b>");
      out.print( questao.getModulo().getNome() );
      out.write("</span>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"card-image\">\n");
      out.write("                            <img id='");
      out.print("imagem"+i);
      out.write("' class=\"responsive-img\" src=\"img/Geladeira.png\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"card-content\">\n");
      out.write("                            <div id='");
      out.print("enunciado"+i);
      out.write("'>\n");
      out.write("                                <p><b>");
      out.print( questao.getTxtEnunciado() );
      out.write("</b></p>\n");
      out.write("                            </div>\n");
      out.write("                            <div id='");
      out.print("alternativas"+i);
      out.write("'>\n");
      out.write("                                <form method=\"post\" name='");
      out.print("formInserirResposta"+i);
      out.write("'>\n");
      out.write("                                    <input type='hidden' name='table' value='QuestaoFechadaResposta'>\n");
      out.write("                                    <input type='hidden' name='acao' value='gravar'>\n");
      out.write("                                    <input type='hidden' name='logado' value='");
      out.print( logado );
      out.write("'>\n");
      out.write("                                    <input type='hidden' name='contadorRespostaQuestao' value='");
      out.print( contadorRespostaQuestao );
      out.write("'>\n");
      out.write("                                    <input type='hidden' name='questao' value='");
      out.print( questao.getId() );
      out.write("'>\n");
      out.write("                                    <input type='hidden' name='tipoQuestao' value='");
      out.print( questao.getIdTipo() );
      out.write("'>\n");
      out.write("                                    <input type='hidden' name='respostaCorreta' value='");
      out.print( questao.getSeqQuestaoCorreta() );
      out.write("'>\n");
      out.write("                                    <input type='hidden' name='resposta' value=''>\n");

                                    char letra='a';
                                    for(int j=0; j<alternativas.size(); j++) {
                                        

      out.write("\n");
      out.write("                                    <p>\n");
      out.write("                                        <input class=\"with-gap\" name='");
      out.print("grupo"+i);
      out.write("' type=\"radio\" id='");
      out.print("grupo"+i+"alternativa"+j);
      out.write("'  />\n");
      out.write("                                        <label id='");
      out.print("grupo"+i+"txtAlternativa"+j);
      out.write("' for='");
      out.print("grupo"+i+"alternativa"+j);
      out.write("'><b>");
      out.print(((char)(letra+j))+")");
      out.write("</b> ");
      out.print( alternativas.get(j).getTxtAlternativa() );
      out.write(" </label>\n");
      out.write("                                    </p>\n");

                                    }

      out.write("\n");
      out.write("                                </form>\n");
      out.write("                                <br>\n");
      out.write("                                <h6 id='");
      out.print("resultado"+i);
      out.write("' ></h6>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"card-action\">\n");
      out.write("                            <button onclick=\"Responder(document.");
      out.print("formInserirResposta"+i);
      out.write(")\" class=\"btn waves-effect waves-orange orange right\" style=\"background-color: #f4511e !important;\" id='");
      out.print("responder"+i);
      out.write("'>Responder</button>\n");
      out.write("                            <a id='");
      out.print("forum"+i);
      out.write("' href=\"#\"><b>Forum</b></a>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");

            } else {

      out.write("\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col s12 m4\">\n");
      out.write("                    <div class=\"card\">\n");
      out.write("                        <div class=\"card-panel #f4511e deep-orange darken-1 white-text\">\n");
      out.write("                            <div style=\"\">\n");
      out.write("                                <b style=\"padding-top: 0px\">Disciplina: </b><span id='");
      out.print("disciplina"+i);
      out.write('\'');
      out.write('>');
      out.print( questao.getDisciplina().getNome() );
      out.write("</span>\n");
      out.write("                                <b style=\"padding-left:50%;padding-top: 0px\">Dificuldade: </b><span id='");
      out.print("dificuldade"+i);
      out.write('\'');
      out.write('>');
      out.print( questao.getDificuldade().getDescricao() );
      out.write("</span>\n");
      out.write("                            </div>\n");
      out.write("                            <div>\n");
      out.write("                                <span id='");
      out.print("modulo"+i);
      out.write("' style=\"\"><b>Módulo: </b>");
      out.print( questao.getModulo().getNome() );
      out.write("</span>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <!--\n");
      out.write("                        <div class=\"card-image\">\n");
      out.write("                            <img id=\"imagem2\" class=\"responsive-img\" src=\"\">\n");
      out.write("                        </div>\n");
      out.write("                        -->\n");
      out.write("                        <div class=\"card-content\">\n");
      out.write("                            <div id='");
      out.print("enunciado"+i);
      out.write("'>\n");
      out.write("                                <p><b>");
      out.print( questao.getTxtEnunciado() );
      out.write("</b></p>\n");
      out.write("                            </div>\n");
      out.write("                            <div id='");
      out.print("respostaAberta"+i);
      out.write("'>\n");
      out.write("                                <form method=\"post\" name='");
      out.print("formInserirResposta"+i);
      out.write("'>\n");
      out.write("                                    <input type='hidden' name='table' value='QuestaoAbertaResposta'>\n");
      out.write("                                    <input type='hidden' name='logado' value='");
      out.print( logado );
      out.write("'>\n");
      out.write("                                    <input type='hidden' name='contadorRespostaQuestao' value='");
      out.print( contadorRespostaQuestao );
      out.write("'>\n");
      out.write("                                    <input type='hidden' name='questao' value='");
      out.print( questao.getId() );
      out.write("'>\n");
      out.write("                                    <input type='hidden' name='tipoQuestao' value='");
      out.print( questao.getIdTipo() );
      out.write("'>\n");
      out.write("                                    <input type='hidden' name='respostaBase' value='");
      out.print( questao.getTxtResposta() );
      out.write("'>\n");
      out.write("                                    <input type='hidden' name='resposta' value=''>\n");
      out.write("                                    <div class=\"row\">\n");
      out.write("                                        <div class=\"input-field col s12\">\n");
      out.write("                                            <textarea id='");
      out.print("textArea"+i);
      out.write("' class=\"materialize-textarea\"></textarea>\n");
      out.write("                                            <label for='");
      out.print("textArea"+i);
      out.write("'>Resposta:</label>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div id='");
      out.print("respostaBase"+i);
      out.write("' class=\"row\">\n");
      out.write("                                        \n");
      out.write("                                    </div>\n");
      out.write("                                    \n");
      out.write("                                </form>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"card-action\">\n");
      out.write("                            <button onclick=\"Responder(document.");
      out.print("formInserirResposta"+i);
      out.write(")\" class=\"btn waves-effect waves-orange orange right\" style=\"background-color: #f4511e !important;\" id='");
      out.print("responder"+i);
      out.write("'>Responder</button>\n");
      out.write("                            <a id='");
      out.print("forum"+i);
      out.write("' href=\"#\"><b>Forum</b></a>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");

            }
        }
    } else {

      out.write("\n");
      out.write("<h2 style=\"text-align: center;\"><b> Não há questões cadastradas!</b></h2>\n");

        for(int i=0; i<20; i++) {

      out.write("\n");
      out.write("<br>\n");

        }
    }

      out.write("  \n");
      out.write("        </div>\n");
      out.write("        <div>\n");
      out.write("        <h6 style=\"text-align: center;\">Página: ");
      out.print((numeroPagina+1));
      out.write("</h6>\n");
      out.write("        <form name=\"formPagina\" action='post'>\n");
      out.write("            <input type='hidden' name='acao' value=''>\n");
      out.write("            <input type='hidden' name='numeroPagina' value='");
      out.print((numeroPagina+1));
      out.write("'>\n");
      out.write("            <input type='hidden' name='maxQuestao' value='");
      out.print(maxQuestao);
      out.write("'>\n");
      out.write("            <button onclick=\"proximaPagina(document.formPagina)\" class=\"btn waves-effect waves-orange orange right\" style=\"background-color: #f4511e !important; margin-left: 70%;\" id='teste75'>Próxima Página</button>\n");
      out.write("            <button onclick=\"paginaAnterior(document.formPagina)\" class=\"btn waves-effect waves-orange orange right\" style=\"background-color: #f4511e !important;\" id='1'>Página Anterior</button>\n");
      out.write("        </form>\n");
      out.write("        </div>\n");
      out.write("        <br>\n");
      out.write("        <br>\n");
      out.write("        \n");
      out.write("\n");
      out.write("\n");
      out.write("        <footer class=\"page-footer orange\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col l6 s12\">\n");
      out.write("                        <h5 class=\"white-text\">Quem somos</h5>\n");
      out.write("                        <p class=\"grey-text text-lighten-4\">Luiz Augusto Dias Berto</p>\n");
      out.write("                        <p class=\"grey-text text-lighten-4\">Maria Carolina</p>\n");
      out.write("                        <p class=\"grey-text text-lighten-4\">Rafael Gontijo</p>\n");
      out.write("                        <p class=\"grey-text text-lighten-4\">Victor César</p>\n");
      out.write("                        <p class=\"grey-text text-lighten-4\">Victor Gabriel</p>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col l3 s12\">\n");
      out.write("                        <h5 class=\"white-text\">Conecte-se</h5>\n");
      out.write("                        <ul>\n");
      out.write("                            <li><a class=\"white-text\" href=\"http://www.cefetmg.br/\">CEFET-MG</a></li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"footer-copyright\">\n");
      out.write("                <div class=\"container\">\n");
      out.write("                    Feito com <a class=\"orange-text text-lighten-3\" href=\"http://materializecss.com\">Materialize</a>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </footer>\n");
      out.write("\n");
      out.write("\n");
      out.write("        \n");
      out.write("        <!--Scripts-->\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-2.1.1.min.js\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" language=\"JavaScript\" src=\"js/materialize.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" language=\"JavaScript\" src=\"js/init.js\"></script>\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            $(document).ready(function() {\n");
      out.write("                $('select').material_select();\n");
      out.write("            });\n");
      out.write("            function mostrarform() {\n");
      out.write("                var element = document.getElementById(\"pesquisa\");\n");
      out.write("                if (element.style.display ==\"none\") {element.style.display = \"block\";} else {element.style.display = \"none\";}\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
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
