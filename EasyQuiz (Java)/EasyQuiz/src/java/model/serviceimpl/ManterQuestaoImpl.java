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
        
        if (questao.getModulo() == null) {
            errMsgList.add("A questão precisa de um Modulo.");
        }
        
        if (questao.getDificuldade()==null) {
            errMsgList.add("A difículdade da questão não pode ser nula.");
        }
        
        if (!errMsgList.isEmpty()) {
            String errMsg = "";
            for (String msg : errMsgList) {
                errMsg += (msg + "\n");
            }
            throw new ExcecaoNegocio(errMsg);
        }
        
        Long result = questaoDAO.insert(questao);
        
        return result;
    }

    @Override
    public boolean alterarQuestao(Questao questao) throws ExcecaoPersistencia, ExcecaoNegocio {
        List<String> errMsgList = new ArrayList<>();
        
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
        
        if (!errMsgList.isEmpty()) {
            String errMsg = "";
            for (String msg : errMsgList) {
                errMsg += (msg + "\n");
            }
            throw new ExcecaoNegocio(errMsg);
        }
        
        boolean result = questaoDAO.update(questao);
        return result;
    }

    @Override
    public Questao deletarQuestao(Long id) throws ExcecaoPersistencia {
        if (id == null){
            throw new ExcecaoPersistencia("Insira um id válido para deletar a questão.");
        }
        Questao result = questaoDAO.delete(id);
        return result;
    }

    @Override
    public Questao getQuestaoById(Long id) throws ExcecaoPersistencia {
        if (id == null){
            throw new ExcecaoPersistencia("Insira um id válido para pesquisar uma questão.");
        }
        Questao result = questaoDAO.getQuestaoById(id);
        return result;
    }

    @Override
    public List<Questao> getAll() throws ExcecaoPersistencia {
        List<Questao> result = questaoDAO.listAll();
        return result;
    }

    @Override
    public List<Questao> getAll(char cod_Tipo) throws ExcecaoPersistencia {
        List<Questao> result = questaoDAO.listAll(cod_Tipo);
        return result;
    }
}
