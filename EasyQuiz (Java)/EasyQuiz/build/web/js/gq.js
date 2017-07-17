/*Alterar para questões abertas (possuem ou não img), questões fechadas que não possuem img*/
function editarquestao(idQuestao, botaoEditar) {
    /*let nomeDivImg = "containerImg" + idQuestao;
    let divImg = document.getElementById(nomeDivImg);
    if (divImg != null) {
        addBotoesImg(idQuestao);
    }*/
    enunToTextArea(idQuestao);
    let divAltFechada = document.getElementById("alternativas"+idQuestao);
    let divQAberta = document.getElementById("resposta-aberta"+idQuestao);
    if (divAltFechada != null) {
        alternativasToTextArea(idQuestao);
    } else if (divQAberta != null) {
        respostaToTextArea(idQuestao);
    }
    let btnEditar = botaoEditar;
    let btnParent = btnEditar.parentElement;
    let divBtnExcluir = document.getElementsByName("divExcluir").item(0);
    let btnExcluir = divBtnExcluir.childNodes.item(1);
    let botaoConfirma = document.createElement("button");
    botaoConfirma.setAttribute("class", "btn waves-effect waves-light deep-orange darken-1");
    botaoConfirma.setAttribute("type", "button");
    botaoConfirma.setAttribute("name", "submitbtn");
    let parametro = "editarQuestaoFormulario(document.form"+idQuestao+")";
    botaoConfirma.setAttribute("onclick", parametro);
    botaoConfirma.innerHTML = "Confirmar";
    let iconBtnConf = document.createElement("i");
    iconBtnConf.setAttribute("class", "material-icons right");
    iconBtnConf.innerHTML = "send";
    botaoConfirma.appendChild(iconBtnConf);
    btnParent.replaceChild(botaoConfirma, btnEditar);
    let botaoCancela = document.createElement("a");
    botaoCancela.setAttribute("class", "btn waves-effect waves-light deep-orange darken-1");
    botaoCancela.innerHTML = "Cancelar";
    botaoCancela.setAttribute("onclick", "window.location.reload()")
    let iconBtnCancela = document.createElement("i");
    iconBtnCancela.setAttribute("class", "material-icons right");
    iconBtnCancela.innerHTML = "cancel";
    botaoCancela.appendChild(iconBtnCancela);
    divBtnExcluir.replaceChild(botaoCancela, btnExcluir);
}

function editarQuestaoFormulario(form){
    alert(form);
    caminhourl = "/EasyQuiz/servletweb?acao=EditarQuestao";
    form.action = caminhourl;
    form.submit();
}

function respostaToTextArea(idQuestao) {
    let divResposta = document.getElementById("resposta-aberta"+idQuestao);
    let paragrafo = divResposta.childNodes.item(1);
    let texto = paragrafo.innerHTML;
    let txtArea = document.createElement("textarea");
    txtArea.setAttribute("id", "resposta-correta"+idQuestao);
    txtArea.setAttribute("name", "resposta-correta"+idQuestao)
    $(txtArea).val(texto);
    divResposta.replaceChild(txtArea, paragrafo);
    let id = idQuestao;
    let questao = document.getElementById(id);
}

function addBotoesImg(idQuestao) {
    let id = idQuestao;
    let content = document.getElementById(id).childNodes.item(3);
    let containerImg = content.childNodes.item(1);
    let row = document.createElement("div");
    row.setAttribute("class", "row");
    let colBtnExcluir = document.createElement("div");
    colBtnExcluir.setAttribute("class", "col s4 offset-s2");
    let colBtnAlterar = document.createElement("div");
    colBtnAlterar.setAttribute("class", "col s4");

    let botaoAlterar = document.createElement("a");
    botaoAlterar.setAttribute("class", "waves-effect waves-light btn deep-orange darken-1");
    //botaoAlterar.innerHTML = "Alterar imagem";
    let iconBotaoAlterar = document.createElement("i");
    iconBotaoAlterar.className = "material-icons center";
    iconBotaoAlterar.innerHTML = "edit";
    botaoAlterar.appendChild(iconBotaoAlterar);
    botaoAlterar.setAttribute("onclick", "alterarImg(this)");
    let botaoExcluir = document.createElement("a");
    botaoExcluir.setAttribute("class", "waves-effect waves-light btn deep-orange darken-1");
    botaoExcluir.setAttribute("onclick", "excluirImg(this)");
    let iconBotaoExcluir = document.createElement("i");
    iconBotaoExcluir.className = "material-icons center";
    iconBotaoExcluir.innerHTML = "delete";
    botaoExcluir.appendChild(iconBotaoExcluir);
    colBtnExcluir.appendChild(botaoExcluir);
    colBtnAlterar.appendChild(botaoAlterar);
    row.appendChild(colBtnExcluir);
    row.appendChild(colBtnAlterar);
    containerImg.appendChild(row);
}

function alterarImg(botaoAlterar) {
    let btn = botaoAlterar;
    let containerImg = btn.parentElement.parentElement.parentElement;
    let inputImg = document.createElement("input");
    inputImg.setAttribute("type", "file");
    inputImg.setAttribute("name", "imagem");
    let img = containerImg.getElementsByTagName("img").item(0);
    containerImg.replaceChild(inputImg, img);
}

function excluirImg(botaoExcluir) {
    let btn = botaoExcluir;
    let rowBotoes = btn.parentElement.parentElement;
    let colAlterar = rowBotoes.getElementsByTagName("div").item(1);
    let colRemover = rowBotoes.getElementsByTagName("div").item(0);
    let containerImg = btn.parentElement.parentElement.parentElement;
    containerImg.removeChild(containerImg.getElementsByTagName("img").item(0));
    rowBotoes.removeChild(colAlterar);
    rowBotoes.removeChild(colRemover);
    let colBotaoAdd = document.createElement("div");
    colBotaoAdd.setAttribute("class", "col s12");
    let botaoAdd = document.createElement("input");
    botaoAdd.setAttribute("type", "file");
    botaoAdd.setAttribute("form", "form1");
    botaoAdd.setAttribute("name", "novaImg");
    rowBotoes.appendChild(colBotaoAdd);
    colBotaoAdd.appendChild(botaoAdd);
}

function enunToTextArea(idQuestao) {
    let contador = 0;
    let id = idQuestao;
    let content = document.getElementById(id).childNodes.item(3);
    let form = document.getElementById("form"+id);
    let divForm = form.childNodes.item(1);
    let enunciado = divForm.childNodes.item(1);
    let paragrafoEnunciado = enunciado.childNodes.item(1);
    let txtEnunciado = paragrafoEnunciado.innerHTML;
    let txtAreaEnunciado = document.createElement("textarea");
    //txtAreaEnunciado.className = "materialize-textarea";
    let idAtual = "txtAreaEnun" + contador;
    txtAreaEnunciado.setAttribute("id", idAtual);
    txtAreaEnunciado.setAttribute("name", idAtual);
    $(txtAreaEnunciado).val(txtEnunciado);
    let inputField = document.createElement("div");
    inputField.setAttribute("class", "input-field col s12");
    enunciado.removeChild(paragrafoEnunciado);
    enunciado.appendChild(inputField);
    inputField.appendChild(txtAreaEnunciado);
}

function alternativasToTextArea(idQuestao) {
    let id = idQuestao;
    console.log("Id da questao: "+id);
    //let content = document.getElementById(id).childNodes.item(3);
    //console.log("DIV CONTENT: "+content);
    //console.log(content.childNodes);
    //let form = document.getElementById("form"+idQuestao);
    //let form = content.childNodes.item(3);
    //let divForm = form.childNodes.item(1);
    let divAlt = document.getElementById("alternativas"+idQuestao); //DIV Alternativas
    let divAltChildren = divAlt.getElementsByTagName("p");
    let iteracao = divAltChildren.length;
    for (let i = 0; i < iteracao; i++) {
        let paragrafoAtual = divAltChildren[0];
        let label = paragrafoAtual.childNodes.item(3);
        let divRow = document.createElement("div");
        divRow.setAttribute("class", "row");
        let colTxtArea = document.createElement("div");
        colTxtArea.setAttribute("class", "col s9");
        let colBtn = document.createElement("div");
        colBtn.setAttribute("class", "col s3");
        let botaoExcluir = document.createElement("a");
        botaoExcluir.setAttribute("class", "waves-effect waves-light btn deep-orange darken-1 disabled");
        botaoExcluir.setAttribute("id", "botaoExcluir" + i);
        botaoExcluir.setAttribute("onclick", "excluirAlternativa(this)");
        let iconBotaoExcluir = document.createElement("i");
        iconBotaoExcluir.className = "material-icons center";
        iconBotaoExcluir.innerHTML = "delete";
        botaoExcluir.appendChild(iconBotaoExcluir);
        colBtn.appendChild(botaoExcluir);
        divRow.appendChild(colTxtArea);
        divRow.appendChild(colBtn);
        let txtAreaAlternativa = document.createElement("textarea");
        txtAreaAlternativa.style.resize = "vertical";
        txtAreaAlternativa.setAttribute("name", "txtArea"+idQuestao+"-"+i);
        let texto = label.textContent;
        texto = texto.slice(2);
        $(txtAreaAlternativa).val(texto);
        colTxtArea.appendChild(txtAreaAlternativa);
        divAlt.replaceChild(divRow, paragrafoAtual);
    }
    addBotaoAddAlternativas(divAlt);
}

function excluirAlternativa(botaoExcluir) {
    let botao = botaoExcluir;
    let divCol = botao.parentElement;
    let divRow = divCol.parentElement;
    let divAlt = divRow.parentElement;
    divAlt.removeChild(divRow);
}

function addBotaoAddAlternativas(divAlt) {
    let divRow = document.createElement("div");
    divRow.setAttribute("class", "row");
    let col = document.createElement("div");
    col.setAttribute("class", "col s12");
    let botaoAdd = document.createElement("a");
    botaoAdd.setAttribute("class", "waves-effect waves-light btn deep-orange darken-1 disabled");
    botaoAdd.setAttribute("id", "botaoAddAlt");
    botaoAdd.setAttribute("onclick", "addAlternativa(this)");
    botaoAdd.innerHTML = "Alternativa";
    let iconBotaoAdd = document.createElement("i");
    iconBotaoAdd.className = "material-icons left";
    iconBotaoAdd.innerHTML = "add";
    botaoAdd.appendChild(iconBotaoAdd);
    divRow.appendChild(col);
    col.appendChild(botaoAdd);
    divAlt.appendChild(divRow);
}

function addAlternativa(botaoAdd) {
    let botao = botaoAdd;
    let divAlt = botao.parentElement.parentElement.parentElement; //LUL
    let divRowReferencia = botao.parentElement.parentElement;
    let divRow = document.createElement("div");
    divRow.setAttribute("class", "row");
    let colTxtArea = document.createElement("div");
    colTxtArea.setAttribute("class", "col s9");
    let colBtn = document.createElement("div");
    colBtn.setAttribute("class", "col s3");
    let botaoExcluir = document.createElement("a");
    botaoExcluir.setAttribute("class", "waves-effect waves-light btn deep-orange darken-1");
    //botaoExcluir.setAttribute("id", "botaoExcluirNova");
    botaoExcluir.setAttribute("onclick", "excluirAlternativa(this)");
    let iconBotaoExcluir = document.createElement("i");
    iconBotaoExcluir.className = "material-icons center";
    iconBotaoExcluir.innerHTML = "delete";
    botaoExcluir.appendChild(iconBotaoExcluir);
    colBtn.appendChild(botaoExcluir);
    divRow.appendChild(colTxtArea);
    divRow.appendChild(colBtn);
    let txtAreaAlternativa = document.createElement("textarea");
    txtAreaAlternativa.style.resize = "vertical";
    colTxtArea.appendChild(txtAreaAlternativa);
    divAlt.insertBefore(divRow, divRowReferencia);
    //FIXME: problema com o ID do botaoExcluir repetido. Talvez esse botão não precise de ID.
}