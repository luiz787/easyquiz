/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.serviceimpl;

import java.util.ArrayList;
import model.service.*;
import model.domain.Questao;
import model.exception.ExcecaoNegocio;
import model.exception.ExcecaoPersistencia;
import java.util.List;
import model.dao.QuestaoDAO;
import model.daoimpl.QuestaoDAOImpl;
import model.domain.Questao;
import model.domain.QuestaoFechada;

/**
 *
 * @author Luiz
 */
public class ManterQuestaoImpl implements ManterQuestao {
    private final QuestaoDAO questaoDAO;
    
    public ManterQuestaoImpl(QuestaoDAO questaoDAO) {
        this.questaoDAO = questaoDAO;
    }

    @Override
    public Long cadastrarQuestao(Questao questao) throws ExcecaoPersistencia, ExcecaoNegocio {
        List<String> errMsgList = new ArrayList<>();
        
        if(questao == null){
            throw new ExcecaoNegocio("Nenhuma questão informada");
        }
        
        if ((questao.getTxtEnunciado()== null) || (questao.getTxtEnunciado().isEmpty())) {
            errMsgList.add("A questão precisa de enunciado.");
        } 
        
        if (questao.getDisciplina() == null) {
            errMsgList.add("A questão precisa de uma Disciplina.");
        }
        
        if (questao.getDificuldade()==null) {
            errMsgList.add("A difículdade da questão não pode ser nula.");
        }
        
        /*if (questao instanceof QuestaoFechada){
            
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
        }*/
        // QuestaoFechada extends Questao?
        
        
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
    public void alterarQuestao(Questao questao) throws ExcecaoPersistencia, ExcecaoNegocio {
        List<String> errMsgList = new ArrayList<>();
        /*teste github*/
        if(questao == null){
            throw new ExcecaoNegocio("Nenhuma questão informada");
        }
        if (questao.getId() == null){
            errMsgList.add("O id deve ser válido para selecionar a questão á ser alterada.");
        }
                
        if ((questao.getTxtEnunciado()== null) || (questao.getTxtEnunciado().isEmpty())) {
            errMsgList.add("A questão precisa de enunciado para ser alterada.");
        } 

        
        if (questao.getDificuldade()==null) {
            errMsgList.add("A dificuldade não pode ser nula.");
        } 
        
        if(questao.getDisciplina() == null){
            errMsgList.add("A questão precisa de uma Disciplina para ser alterada.");
        }
        /*if (questao instanceof QuestaoFechada){
            
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
        }*/
        
        
        if (!errMsgList.isEmpty()) {
            String errMsg = "";
            for (String msg : errMsgList) {
                errMsg += (msg + "\n");
            }
            throw new ExcecaoNegocio(errMsg);
        }
        questaoDAO.update(questao);
    }

    @Override
    public Questao deletarQuestao(Long id) throws ExcecaoPersistencia {
        if (id == null){
            throw new ExcecaoPersistencia("Insira um id válido para deletar a questão.");
        }
        return questaoDAO.delete(id);
    }

    @Override
    public Questao getQuestaoById(Long id) throws ExcecaoPersistencia {
        if (id == null){
            throw new ExcecaoPersistencia("Insira um id válido para pesquisar uma questão.");
        }
        return questaoDAO.getQuestaoById(id);
    }

    @Override
    public List<Questao> getAll() throws ExcecaoPersistencia {
        List<Questao> result = questaoDAO.listAll();
        return result;
    }

    @Override
    public List<Questao> getAll(char cod_Tipo) throws ExcecaoPersistencia {
        return questaoDAO.listAll(cod_Tipo);
    }
}
