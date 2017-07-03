function addAlternativa(botaoAdd) {
    let botao = botaoAdd;
    let divAlt = botao.parentElement;
    let divRow = document.createElement("div");
    divRow.setAttribute("class", "row");
    let colTxtArea = document.createElement("div");
    colTxtArea.setAttribute("class", "input-field col s9");
    let colBtn = document.createElement("div");
    colBtn.setAttribute("class", "col s3");
    let botaoExcluir = document.createElement("a");
    botaoExcluir.setAttribute("class", "waves-effect waves-light btn deep-orange darken-1");
    //botaoExcluir.setAttribute("id", "botaoExcluirNova");
    botaoExcluir.setAttribute("onclick", "excluirAlternativa(this)");
    botaoExcluir.innerHTML = "Excluir";
    let iconBotaoExcluir = document.createElement("i");
    iconBotaoExcluir.className = "material-icons left";
    iconBotaoExcluir.innerHTML = "delete";
    botaoExcluir.appendChild(iconBotaoExcluir);
    colBtn.appendChild(botaoExcluir);
    divRow.appendChild(colTxtArea);
    divRow.appendChild(colBtn);
    let txtAreaAlternativa = document.createElement("textarea");
    txtAreaAlternativa.setAttribute("class", "materialize-textarea");
    txtAreaAlternativa.setAttribute("id", "alt5");
    let label = document.createElement("label");
    label.setAttribute("for", "alt5");
    label.innerHTML = "Alternativa";
    colTxtArea.appendChild(txtAreaAlternativa);
    colTxtArea.appendChild(label);
    divAlt.insertBefore(divRow, botao);
    //FIXME: problema com o ID da textArea que tem q ser dinâmico.
}

function excluirAlternativa(botaoExcluir) {
    let botao = botaoExcluir;
    let divCol = botao.parentElement;
    let divRow = divCol.parentElement;
    let divAlt = divRow.parentElement;
    divAlt.removeChild(divRow);
}

function questaoAberta() {
    let form = document.getElementById("cadastro");
    let remover = document.getElementById("divAlternativas");
    form.removeChild(remover);
    let divRespostaAberta = document.createElement("div");
    divRespostaAberta.setAttribute("id", "divAberta");
    let divRow = document.createElement("div");
    divRow.setAttribute("class", "row");
    let divCol = document.createElement("div");
    divCol.setAttribute("class", "input-field col s12");
    let txtAreaRespAberta = document.createElement("textarea");
    txtAreaRespAberta.setAttribute("id", "txtresposta");
    txtAreaRespAberta.setAttribute("class", "materialize-textarea");
    let labelresposta = document.createElement("label");
    labelresposta.setAttribute("for", "txtresposta");
    labelresposta.innerHTML = "Resposta correta";
    divCol.appendChild(txtAreaRespAberta);
    divCol.appendChild(labelresposta);
    divRow.appendChild(divCol);
    divRespostaAberta.appendChild(divRow);
    let linha = document.getElementById("linhafinal");
    form.insertBefore(divRespostaAberta, linha);
}