<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
        <title>EasyQuiz</title>

        <!-- CSS  -->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link href="css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
        <link href="css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

    </head>
    <body>


        <!--- Javascrip -->
        <script type="text/javascript">

            $(document).ready(function () {
                $('select').material_select();
            });


            function mostrarform() {
                var element = document.getElementById("pesquisa");
                if (element.style.display == "none") {
                    element.style.display = "block";
                } else {
                    element.style.display = "none";
                }
            }
        </script>

        <!-- nav cor #EE6363 -->
        <nav class="nav-extended" style="background-color:#FFFFFF;">

            <div class="container" style="display: inline; margin-left: 50px;">
                <a id="logo-container" href="#" style="color:#47525E; font-size: 32px;">EasyQuiz</a>

                <ul id="side-nav" class="right hide-on-med-and-down">

                    <li> 
                        <input id="email" placeholder="email" type="email" class="form-control" style="color: #696969;border-color:#D3D3D3;"> 

                    </li>

                    <li>&ensp;</li>

                    <li>
                        <input id="password" placeholder="senha" type="password" class="validate" style="color: #696969;border-color:#D3D3D3;">
                    </li>
                    <a class="btn-small waves-effect waves-light grey darken-2 btn" href="#">Login</a>
                    <a class="btn-small waves-effect waves-light grey darken-2 btn" href="#"">Cadastrar</a>
                </ul>
            </div>


            <div class="row" style="background-color: #EE6363; margin-top: 15px;" >
                <div  class="col s8" >Disciplinas comuns:
                    <a id="botao-matematica" class="waves-effect waves-light" style="margin-left: 5px; margin-right: 5px; padding-left: 5px; padding-right: 5px; padding-top: 2px; background-color: #E5E9F2; color: #47525E">Matemática</a>
                    <a id="botao-portugues" class="waves-effect waves-light" style="margin-left: 5px; margin-right: 5px; padding-left: 5px; padding-right: 5px; padding-top: 2px; background-color: #E5E9F2; color: #47525E">Português</a>
                    <a id="botao-fisica" class="waves-effect waves-light" style="margin-left: 5px; margin-right: 5px; padding-left: 5px; padding-right: 5px; padding-top:    2px; background-color: #E5E9F2; color: #47525E">Física</a>
                </div>
                <div class="col s4">
                    <a class="btn-small waves-effect waves-light grey darken-2 btn" onclick="mostrarform()">Filtrar</a></li>  			
                </div>

            </div>

            <div class="row " id="pesquisa" style="display: none; position: absolute;   width: 47%; background: rgba(255, 255, 255, 0.7);">
                <div class="col s12 offset-s12" id="pesquisa" style="border: 4px solid; border-color:#D3D3D3; background: rgba(255, 255, 255, 1.0); ; text-align:center;border-radius: 10px; z-index: 2;" >

                    <form style="background-color: #FFF;">

                        <input id="search" type="search" placeholder="Busque por palavras chave" style="color: #696969;">

                        <div class="row">
                            <div class="input-field col s6">
                                <select id="nivel">
                                    <option value="" disabled selected>Escolha uma Dificuldade</option>
                                    <option value="1">Fácil</option>
                                    <option value="2">Médio</option>
                                    <option value="3">Difícil</option>
                                    <option value="4">Desafio</option>
                                    <option value="0">Nenhum</option>
                                </select>
                            </div>

                            <div class="input-field col s6">
                                <select id="materia">
                                    <option value="" disabled selected>Escolha uma Disciplina</option>
                                    <option value="1">Matemática</option>
                                    <option value="2">Português</option>
                                    <option value="3">Física</option>
                                    <option value="4">Geografia</option>
                                    <option value="5">História</option>
                                    <option value="6">Química</option>
                                    <option value="7">Inglês</option>
                                    <option value="0">Nenhum</option>
                                </select>
                            </div>
                        </div>

                        <div class="row">
                            <div class="input-field col s6">
                                <select id="tipo">
                                    <option value="" disabled selected>Escolha um tipo</option>
                                    <option value="1">Aberta</option>
                                    <option value="2">Fechada</option>
                                    <option value="3">Nenhum</option>
                                </select>
                            </div>

                            <div class="input-field col s6">
                                <select id="materia">
                                    <option value="" disabled selected>Escolha um módulo</option>
                                    <option value="0">Nenhum</option>
                                </select>
                            </div>
                        </div>

                    </form>
                    <button class="btn-large waves-effect waves-light grey darken-2" type="submit" name="action">avançar 
                        <i class="material-icons right">send</i>
                    </button>
                </div>
            </div>
        </nav>

        <br>
        <H4 style="color: #47525E; padding-left: 80px;">Preencha todos os campos a seguir:</H4>
        <div class="container">
            <form class="col s12" action="criaUsuario" method="POST">
                <div class="input-field col s6">
                    <i class="material-icons prefix">account_circle</i>
                    <input id="nome" name="nome" type="text" class="validate">
                    <label for="nome">Nome completo</label>
                </div>

                <div class="input-field col s6">
                    <i class="material-icons prefix">email</i>
                    <input id="email" name="nome" type="email" class="validate">
                    <label for="email">E-mail</label>
                </div>

                <br>

                <label for="escolhe_data">Data de nascimento:</label>
                <div class="input-field col s6">
                    <i class="material-icons prefix">perm_contact_calendar</i>
                    <input id="data" name="data" type="date" class="validate">
                </div>

                <label for="escolaridade">Escolaridade:</label>
                <div class="input-field col s6">
                    <i class="material-icons prefix">class</i>
                    <select id="escolaridade" id="escolaridade" name="escolaridade">
                        <option value="" disabled selected>Escolaridade</option>
                        <option value="1">Analfabeto</option>
                        <option value="2">Fundamental incompleto</option>
                        <option value="3">Fundamental completo</option>
                        <option value="4">Médio incompleto</option>
                        <option value="5">Médio completo</option>
                        <option value="6">Superior incompleto</option>
                        <option value="7">Superior completo</option>
                        <option value="8">Pós graduado</option>
                    </select>
                </div>

                <br>

                <label for="senha">Senha:</label>
                <div class="input-field col s6">
                    <i class="material-icons prefix">lock_outline</i>
                    <input id="senha" name="senha" type="password" class="validate">
                </div>
                <label for="senha">Confirmar senha:</label>
                <div class="input-field col s6">
                    <input type="password" id="confirma_senha" name="confirma_senha">
                </div>

                <br>
                <br>
                <br>

                <div align="right">
                    <button class="btn waves-effect waves-light" type="button">Cancelar</button>

                    <button class="btn waves-effect waves-light" type="submit" name="action">Confirmar
                        <i class="material-icons right">send</i>
                    </button>
                </div>

            </form>
        </div>

        <br>
        <br>

        <footer class="page-footer orange">
            <div class="container">
                <div class="row">
                    <div class="col l6 s12">
                        <h5 class="white-text">Quem somos</h5>
                        <p class="grey-text text-lighten-4">Luiz Augusto Dias Berto</p>
                        <p class="grey-text text-lighten-4">Maria Carolina</p>
                        <p class="grey-text text-lighten-4">Rafael Gontijo</p>
                        <p class="grey-text text-lighten-4">Victor César</p>
                        <p class="grey-text text-lighten-4">Victor Gabriel</p>
                    </div>
                    <div class="col l3 s12">
                        <h5 class="white-text">Conecte-se</h5>
                        <ul>
                            <li><a class="white-text" href="http://www.cefetmg.br/">CEFET-MG</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="footer-copyright">
                <div class="container">
                    Feito com <a class="orange-text text-lighten-3" href="http://materializecss.com">Materialize</a>
                </div>
            </div>
        </footer>


        <!--  Scripts-->
        <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script src="js/materialize.js"></script>
        <script src="js/init.js"></script>

    </body>
</html>