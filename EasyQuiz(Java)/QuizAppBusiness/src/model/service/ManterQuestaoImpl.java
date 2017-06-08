/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service;

import java.util.ArrayList;
import java.util.List;
import model.dao.QuestaoDAO;
import model.domain.Questao;
import model.domain.QuestaoAberta;
import model.domain.QuestaoFechada;
import model.exception.ExcecaoNegocio;
import model.exception.ExcecaoPersistencia;

/**
 *
 * @author Aluno
 */
public class ManterQuestaoImpl implements ManterQuestao {

    private final QuestaoDAO questaoDAO;

    public ManterQuestaoImpl(QuestaoDAO questaoDAO) {
        this.questaoDAO = questaoDAO;
    }
    
    
    
    @Override
    public Long cadastrarQuestao(Questao questao) throws ExcecaoNegocio, ExcecaoPersistencia {
        
        List<String> errMsgList = new ArrayList<>();
        
        if(questao == null){
            throw new ExcecaoNegocio("Nenhuma questão informada");
        }
        
        if ((questao.getEnunciado() == null) || (questao.getEnunciado().isEmpty())) {
            errMsgList.add("A questão precisa de enunciado.");
        } 
        
        if ((questao.getDisciplina() == null) || (questao.getDisciplina().isEmpty())) {
            errMsgList.add("A questão precisa de uma Disciplina.");
        }
        
        if ((questao.getDificuldade() != 1) && (questao.getDificuldade() != 2) && (questao.getDificuldade() != 3) && (questao.getDificuldade() != 4)) {
            errMsgList.add("A difículdade da questão deve ser representada por um inteiro de 1 a 4.");
        }        
 
        if (questao instanceof QuestaoAberta){
            
            if((((QuestaoAberta) questao).getResposta() == null) || (((QuestaoAberta) questao).getResposta().isEmpty())){
                errMsgList.add("A questão aberta precisa de uma resposta padrão.");
            }
            
        } else if (questao instanceof QuestaoFechada){
            
            if(((QuestaoFechada) questao).getAlternativas() == null) {
                errMsgList.add("A questão fechada precisa de alternativas.");
            }else if(((QuestaoFechada) questao).getAlternativas().length <= 1 ){
                errMsgList.add("A questão fechada deve conter pelo menos 2 alternativas.");
            }
            
            if(((QuestaoFechada) questao).getAlternativaCorreta() == null){
                errMsgList.add("A questão fechada deve conter uma alternativa correta.");
            }else if(((QuestaoFechada) questao).getAlternativaCorreta().intValue() > ((QuestaoFechada) questao).getAlternativas().length){
                errMsgList.add("A alternativa correta deve estar contida nas alternativas.");
            }
            
        } else {
            errMsgList.add("Uma questao deve ser Aberta ou Fechada");
        }
        
        
        if (!errMsgList.isEmpty()) {
            String errMsg = "";
            for (String msg : errMsgList) {
                errMsg += (msg + "\n");
            }
            throw new ExcecaoNegocio(errMsg);
        }
        
        questaoDAO.insert(questao);
        
        return questao.getId();
    }

    @Override
    public void alterarQuestao(Questao questao) throws ExcecaoNegocio, ExcecaoPersistencia {
        List<String> errMsgList = new ArrayList<>();
        /*teste github*/
        if(questao == null){
            throw new ExcecaoNegocio("Nenhuma questão informada");
        }
        if (questao.getId() == null){
            errMsgList.add("O id deve ser válido para selecionar a questão á ser alterada.");
        }
                
        if ((questao.getEnunciado() == null) || (questao.getEnunciado().isEmpty())) {
            errMsgList.add("A questão precisa de enunciado para ser alterada.");
        } 

        
        if ((questao.getDificuldade() != 1) && (questao.getDificuldade() != 2) && (questao.getDificuldade() != 3) && (questao.getDificuldade() != 4)) {
            errMsgList.add("A difículdade da questão deve ser representada por um inteiro de 1 a 4.");
        } 
        
        if((questao.getDisciplina() == null) || questao.getDisciplina().isEmpty()){
            errMsgList.add("A questão precisa de uma Disciplina para ser alterada.");
        }
        
        if (questao instanceof QuestaoAberta){
            
            if((((QuestaoAberta) questao).getResposta() == null) ||((QuestaoAberta) questao).getResposta().isEmpty()){
                errMsgList.add("A questão aberta precisa de uma resposta padrão para ser alterada.");
            }
            
        } else if (questao instanceof QuestaoFechada){
            
            if(((QuestaoFechada) questao).getAlternativas() == null){
                errMsgList.add("A questão fechada precisa de alternativas para ser alterada.");
            }else if(((QuestaoFechada) questao).getAlternativas().length <= 1 ){
                errMsgList.add("A questão fechada deve conter pelo menos 2 alternativas para ser alterada.");
            }
            
            if(((QuestaoFechada) questao).getAlternativaCorreta() == null){
                errMsgList.add("A questão fechada deve conter uma alternativa correta para ser alterada.");
            }else if(((QuestaoFechada) questao).getAlternativaCorreta().intValue() > ((QuestaoFechada) questao).getAlternativas().length){
                errMsgList.add("A alternativa correta deve estar contida nas alternativas para ser alterada.");
            }
            // Integer.parseInt(String.valueOf(((QuestaoFechada) questao).getAlternativaCorreta()));
            
        } else {
            errMsgList.add("Uma questao deve ser Aberta ou Fechada.");
        }
        
        
        if (!errMsgList.isEmpty()) {
            String errMsg = "";
            for (String msg : errMsgList) {
                errMsg += (msg + "\n");
            }
            throw new ExcecaoNegocio(errMsg);
        }
        
    }

    @Override
    public void deletarQuestao(Long id) throws ExcecaoPersistencia {
        if (id == null){
            throw new ExcecaoPersistencia("Insira um id válido para deletar a questão.");
        }
        
        questaoDAO.delete(id);
    }

    @Override
    public Questao getQuestaoById(Long id) throws ExcecaoPersistencia {
         if (id == null){
            throw new ExcecaoPersistencia("Insira um id válido para pesquisar uma questão.");
        }
        return questaoDAO.getQuestaoById(id);
    }

    @Override
    public List<Questao> listAll() throws ExcecaoPersistencia {

        
            return questaoDAO.listAll();
    }

}
