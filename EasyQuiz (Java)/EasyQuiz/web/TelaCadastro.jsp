<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <jsp:include page ="Menu.jsp"/>
    <head>
        <meta charset="UTF-8">
        <!-- JavaScript  -->
        <script type="text/javascript" src="dist/jquery.validate.js" ></script>
        <script type="text/javascript" src="dist/jquery.validate.min.js" ></script>
        <script type="text/javascript" src="dist/additional-methods.min.js" ></script>
        <script type="text/javascript" src="dist/additional-methods.js" ></script>
        <script type="text/javascript" src="js/validaForm.js"></script>
    </head>
    <body>
        <br>
        <H4 style="color: #47525E; padding-left: 80px;">Preencha todos os campos a seguir:</H4>
        <div class="container">
            <form class="col s12" action="Cadastra" method="POST" id="formCadastro">
                <div class="input-field col s12">
                    <i class="material-icons prefix">account_circle</i>
                    <label for="nome">Nome completo</label>
                    <input id="nome" name="nome" type="text" class="validate" minlength="10">
                </div>

                <div class="input-field col s6">
                    <i class="material-icons prefix">email</i>
                    <label for="emailCadastro">E-mail</label>
                    <input id="emailCadastro" name="emailCadastro" type="email" class="validate" >
                </div>

                <br>

                <label for="data">Data de nascimento:</label>
                <div class="input-field col s6">
                    <i class="material-icons prefix">perm_contact_calendar</i>
                    <input id="data" name="data" type="date" class="validate" >
                </div>

                <label for="escolaridade">Escolaridade:</label>
                <div class="input-field col s6">
                    <i class="material-icons prefix">class</i>
                    <select name="escolaridade" id="escolaridade">
                        <option value="">Escolaridade</option>
                        <option value="Analfabeto">Analfabeto</option>
                        <option value="Fundamental incompleto">Fundamental incompleto</option>
                        <option value="Fundamental completo">Fundamental completo</option>
                        <option value="Medio incompleto">Médio incompleto</option>
                        <option value="Medio completo">Médio completo</option>
                        <option value="Superior incompleto">Superior incompleto</option>
                        <option value="Superior completo">Superior completo</option>
                        <option value="Mestrado">Mestrado</option>
                        <option value="Doutorado">Doutorado</option>
                    </select>
                </div>

                <br>

                <label for="perfil">Perfil:</label>
                <div class="input-field col s6">
                    <i class="material-icons prefix">perm_identity</i>
                    <select name="perfil" id="perfil">
                        <option value="">Perfil</option>
                        <option value="aluno">Aluno</option>
                        <option value="professor">Professor</option>
                    </select>
                </div>

                <br>

                <label for="senhaCadastro">Senha:</label>
                <div class="input-field col s6">
                    <i class="material-icons prefix">lock_outline</i>
                    <input id="senhaCadastro" name="senhaCadastro" type="password" class="validate" >
                </div>
                <label for="confirma_senha">Confirmar senha:</label>
                <div class="input-field col s6">
                    <input type="password" id="confirma_senha" name="confirma_senha">
                </div>

                <br>
                <br>
                <br>
                <div>
                <a class="btn waves-effect waves-light" href="/EasyQuiz/servletweb?acao=PaginaInicial">Cancelar</a>
                </div>
                <div align="right">
                    <button class="btn waves-effect waves-light" class="submit" type="submit" value="submit" name="action">Confirmar
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