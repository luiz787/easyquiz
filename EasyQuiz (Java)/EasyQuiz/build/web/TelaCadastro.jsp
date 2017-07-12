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
        <jsp:include page ="Menu.jsp"/>
        
        <br>
        <H4 style="color: #47525E; padding-left: 80px;">Preencha todos os campos a seguir:</H4>
        <div class="container">
            <form class="col s12" action="Cadastra" method="POST">
                <div class="input-field col s6"  style="z-index: 0;">
                    <i class="material-icons prefix">account_circle</i>
                    <input id="nome" name="nome" type="text" class="validate">
                    <label for="nome">Nome completo</label>
                </div>

                <div class="input-field col s6"  style="z-index: 0;">
                    <i class="material-icons prefix">email</i>
                    <input id="email" name="email" type="email" class="validate">
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
                    <select id="escolaridade" name="escolaridade">
                        <option disabled selected>Escolaridade</option>
                        <option value="Analfabeto">Analfabeto</option>
                        <option value="Fundamental incompleto">Fundamental incompleto</option>
                        <option value="Fundamental completo">Fundamental completo</option>
                        <option value="Médio incompleto">Médio incompleto</option>
                        <option value="Médio completo">Médio completo</option>
                        <option value="Superior incompleto">Superior incompleto</option>
                        <option value="Superior completo">Superior completo</option>
                        <option value="Pós graduado">Pós graduado</option>
                    </select>
                </div>

                <br>

                <label for="senha">Senha:</label>
                <div class="input-field col s6">
                    <i class="material-icons prefix">lock_outline</i>
                    <input id="senha" name="senha" type="password" class="validate">
                </div>
                <label for="confirma_senha">Confirmar senha:</label>
                <div class="input-field col s6">
                    <input type="password" id="confirma_senha">
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
        
        <jsp:include page ="Footer.jsp"/>
    </body>
</html>
