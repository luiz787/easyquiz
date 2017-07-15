function ResponderQuestao(form) {
    var id = form.index.value;
    var contadorRespostaQuestao = form.contadorRespostaQuestao.value;
    var logado = form.logado.value;
    if(contadorRespostaQuestao<10 || logado==1) {
        if(form.tipoQuestao.value=='A') {
            if(document.querySelector("#textArea"+id).value.length!=0) {
                var txtResposta = document.querySelector("#textArea"+id).value;
                
                var respostaBase = form.respostaBase.value;
                var resultado = document.querySelector("#resultado"+id);
                resultado.style.color='black';
                resultado.style.backgroundColor='lightgreen';
                resultado.innerHTML="<b>Resposta Base:</b><p>"+respostaBase+"</p>";
                
                ContadorRespostaQuestao(form, txtResposta);
                
            } else {
                var resultado = document.querySelector("#resultado"+id);
                resultado.style.color='orange';
                resultado.style.backgroundColor='';
                resultado.innerHTML="Escreva alguma resposta!";
            }

        } else if(form.tipoQuestao.value=='F') {
            if(document.querySelector("input[name='grupo"+id+"']:checked")!=null) {
                var alternativa = (document.querySelector("input[name='grupo"+id+"']:checked").id);
                alternativa = alternativa.substr(alternativa.length - 1);
                alternativa++;

                var letra = 64;
                var respostaCorreta = form.respostaCorreta.value;

                letra = (letra+parseInt(respostaCorreta));

                if(alternativa==respostaCorreta) {
                    var resultado = document.querySelector("#resultado"+id);
                    resultado.style.color='green';
                    resultado.innerHTML="Parabéns! Você acertou!";
                } else {
                    var resultado = document.querySelector("#resultado"+id);
                    resultado.style.color='red';
                    resultado.innerHTML="Você errou! Resposta: "+String.fromCharCode(letra);
                }
                if(form.logado.value==1) {
                    GravarAlterarTabela(form, alternativa);
                } else {
                    ContadorRespostaQuestao(form, alternativa);
                }
            } else {
                var resultado = document.querySelector("#resultado"+id);
                resultado.style.color='orange';
                resultado.innerHTML="Selecione uma alternativa!";
            }
        }
    } else {
        alert("Voce excedeu o limite de questoes a ser respondidas! "
              + "Efetue o cadastro para responder mais questões.");
    }
}

function GravarAlterarTabela(form, alternativa) {
    var table = form.table.value;
    if (table == "QuestaoFechadaResposta") {
        if (form.acao.value == "gravar")
            caminhourl = "/EasyQuiz/servletweb?acao=GravarQuestaoFechadaResposta&resposta="+alternativa;
    }
    form.action = caminhourl;
    form.submit();
}

function ContadorRespostaQuestao(form, resposta) {
    caminhourl = "/EasyQuiz/servletweb?acao=ContadorRespostaQuestao&resposta="+resposta;
    form.action = caminhourl;
    form.submit();
}

function proximaPagina(form) {
    caminhourl = "/EasyQuiz/servletweb";
    form.acao.value="ProximaPagina";
    form.action = caminhourl;
    form.submit();
}

function paginaAnterior(form) {
    caminhourl = "/EasyQuiz/servletweb";
    form.acao.value="PaginaAnterior";
    form.action = caminhourl;
    form.submit();
}

function validarCamposLogin() {
    var frm = document.frmLogin;
    var email = frm.email.value;
    var senha = frm.senha.value;

    if (email == "") {
        alert("Favor, preencha o campo email!");
        frm.email.focus();
        return false;
    } else if (senha == "") {
        alert("Favor, preencha o campo senha!");
        frm.senha.focus();
        return false;
    } else {
        caminhourl = "/EasyQuiz/servletweb?acao=Logar";
        document.forms[0].action = caminhourl;
        window.document.forms[0].submit();
        return true;
    }
}