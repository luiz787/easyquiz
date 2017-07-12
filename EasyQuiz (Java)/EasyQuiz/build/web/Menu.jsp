<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!--- Javascrip -->
<script type="text/javascript">

  $(document).ready(function() {
      $('select').material_select();
  });


	function mostrarform() {
		var element = document.getElementById("pesquisa");
		if (element.style.display =="none") {element.style.display = "block";} else {element.style.display = "none";}
	}
</script>

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
                    <a class="btn-small waves-effect waves-light grey darken-2 btn" href="#">Cadastrar</a>
                </ul>
            </div>
            <div class="row" style="background-color: #EE6363; margin-top: 15px;" >
                <div class="col s8" >Matérias comuns:
                    <a id="botao-matematica" class="waves-effect waves-light" style="margin-left: 5px; margin-right: 5px; padding-left: 5px; padding-right: 5px; padding-top: 2px; background-color: #E5E9F2; color: #47525E">Matemática</a>
                    <a id="botao-portugues" class="waves-effect waves-light" style="margin-left: 5px; margin-right: 5px; padding-left: 5px; padding-right: 5px; padding-top: 2px; background-color: #E5E9F2; color: #47525E">Português</a>
                    <a id="botao-fisica" class="waves-effect waves-light" style="margin-left: 5px; margin-right: 5px; padding-left: 5px; padding-right: 5px; padding-top:    2px; background-color: #E5E9F2; color: #47525E">Física</a>
                </div>
                <div class="col s4">
                    <a class="btn-small waves-effect waves-light grey darken-2 btn" onclick="mostrarform()">Filtrar</a></li>  			
                </div>
            </div>
            <div class="row " id="pesquisa" style="display: none; position: absolute;   width: 47%; background: rgba(255, 255, 255, 0.7);">
                <div class="col s12 offset-s12" id="pesquisa" style="border: 4px solid; border-color:#D3D3D3; background: rgba(255, 255, 255, 1.0); ; text-align:center;border-radius: 10px;" >
                    <form>
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
                                    <option value="" disabled selected>Escolha uma Matéria</option>
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
