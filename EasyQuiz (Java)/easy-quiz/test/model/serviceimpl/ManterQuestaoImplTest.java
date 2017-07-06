/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import model.dao.QuestaoDAO;
import model.daoimpl.QuestaoDAOImpl;
import model.domain.Questao;
import model.domain.QuestaoAberta;
import model.domain.QuestaoFechada;
import model.exception.ExcecaoNegocio;
import model.exception.ExcecaoPersistencia;
import model.service.ManterQuestao;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author F43L
 */
public class ManterQuestaoImplTest {
    
    private static ManterQuestao questaoManagement;
    private static QuestaoDAO questaoDAO;
    private Questao questao;
    private QuestaoAberta questaoa;
    private QuestaoFechada questaof;
    private static List<Long> questaoList;
    
    public ManterQuestaoImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        questaoDAO = QuestaoDAOImpl.getInstancia();
        questaoManagement = new ManterQuestaoImpl(questaoDAO);
        questaoList = new ArrayList<>();
    }
    
   
    
    @Before
    
    public void setUp() { //instancia questoes
        this.questao = new Questao();
        this.questaoa = new QuestaoAberta();
        this.questaof = new QuestaoFechada();
    }
    
    @After
    public void tearDown() throws ExcecaoPersistencia {
     /*for(Long id: questaoList){
                questaoDAO.delete(id);

    }
*/
    }

    /**
     * Test of cadastrarQuestao method, of class ManterQuestaoImpl.
     */
    @Test
    public void testCadastrarQuestao1() throws Exception {
        
        try {
            //testa entrada de questao null
            questao = null;
            questaoManagement.cadastrarQuestao(questao);
        } catch(ExcecaoNegocio ex) {
            return;
        }
        
        fail("A exceção esperada não foi capturada.");
    }
    
    @Test
    public void testCadastrarQuestao2() throws Exception {
        
        try {
            //testa entrada de enunciado null
            questao.setEnunciado(null);
            questaoManagement.cadastrarQuestao(questao);
        } catch(ExcecaoNegocio ex) {
            String msgErr = ex.getMessage();
            String msgEsperada = "A questão precisa de enunciado.";
            assertTrue(msgErr.contains(msgEsperada));
            return;
        }
        
      
        
        fail("Falha não identificada.");
    }
    
    @Test
    public void testCadastrarQuestao3() throws Exception {
        
        try {
            //testa entrada de enunciado vazia
            questao.setEnunciado("");
            questaoManagement.cadastrarQuestao(questao);
        } catch(ExcecaoNegocio ex) {
            String msgErr = ex.getMessage();
            String msgEsperada = "A questão precisa de enunciado.";
            assertTrue(msgErr.contains(msgEsperada));
            return;
        }
        
      
        
        fail("Falha não identificada.");
    }
    
    @Test
    public void testCadastrarQuestao4() throws Exception {
        
        try {
            //testa entrada de dificuldade fora do conjunto permitido
            questao.setDificuldade(5);
            questaoManagement.cadastrarQuestao(questao);
        } catch(ExcecaoNegocio ex) {
            String msgErr = ex.getMessage();
            String msgEsperada = "A difículdade da questão deve ser representada por um inteiro de 1 a 4.";
            assertTrue(msgErr.contains(msgEsperada));
            return;
        }
        
      
        
        fail("Falha não identificada.");
    }
    
    @Test
    public void testCadastrarQuestao5() throws Exception {
        
        try {
            //testa entrada de disciplina null
            questao.setDisciplina(null);
            questaoManagement.cadastrarQuestao(questao);
        } catch(ExcecaoNegocio ex) {
            String msgErr = ex.getMessage();
            String msgEsperada = "A questão precisa de uma Disciplina.";
            assertTrue(msgErr.contains(msgEsperada));
            return;
        }
        
      
        
        fail("Falha não identificada.");
    }

    
    
    @Test
    public void testCadastrarQuestao6() throws Exception {
        
        try {
            //testa entrada de disciplina vazia
            questao.setDisciplina("");
            questaoManagement.cadastrarQuestao(questao);
        } catch(ExcecaoNegocio ex) {
            String msgErr = ex.getMessage();
            String msgEsperada = "A questão precisa de uma Disciplina.";
            assertTrue(msgErr.contains(msgEsperada));
            return;
        }
        
      
        
        fail("Falha não identificada disciplina vazia.");
    }
    
    
    
    @Test
    public void testCadastrarQuestao7() throws Exception {
        
        try {
            //testa se resposta da questao aberta e nula
            questaoa.setResposta(null);
            questaoManagement.cadastrarQuestao(questaoa);
        } catch(ExcecaoNegocio ex) {
            String msgErr = ex.getMessage();
            String msgEsperada = "A questão aberta precisa de uma resposta padrão.";
            assertTrue(msgErr.contains(msgEsperada));
            return;
        }
        
      
        
        fail("Falha não identificada disciplina vazia.");
    }
    
    
    @Test
    public void testCadastrarQuestao8() throws Exception {
        
        try {
            //testa se resposta da questao aberta e vazia
            questaoa.setResposta("");
            questaoManagement.cadastrarQuestao(questaoa);
        } catch(ExcecaoNegocio ex) {
            String msgErr = ex.getMessage();
            String msgEsperada = "A questão aberta precisa de uma resposta padrão.";
            assertTrue(msgErr.contains(msgEsperada));
            return;
        }
        
      
        
        fail("Falha não identificada disciplina vazia.");
    }
    
    @Test
    public void testCadastrarQuestao9() throws Exception {
        
        try {
            //testa se a questao fechada tem alternativa
            questaof.setAlternativas(null);
            questaoManagement.cadastrarQuestao(questaof);
        } catch(ExcecaoNegocio ex) {
            String msgErr = ex.getMessage();
            String msgEsperada = "A questão fechada precisa de alternativas.";
            assertTrue(msgErr.contains(msgEsperada));
            return;
        }
        
      
        
        fail("Falha não identificada disciplina vazia.");
    }

    @Test
    public void testCadastrarQuestao10() throws Exception {
        
        try {
            //testa se a questao fechada tem mais de uma alternativa
            String resposta[] = {"resposta"};
            questaof.setAlternativas(resposta);
            questaoManagement.cadastrarQuestao(questaof);
        } catch(ExcecaoNegocio ex) {
            String msgErr = ex.getMessage();
            String msgEsperada = "A questão fechada deve conter pelo menos 2 alternativas.";
            assertTrue(msgErr.contains(msgEsperada));
            return;
        }
        
      
        
        fail("Falha não identificada disciplina vazia.");
    }  

    @Test
    public void testCadastrarQuestao11() throws Exception {
        
        try {
            //testa se a questao fechada tem alternativa correta
            questaof.setAlternativaCorreta(null);
            questaoManagement.cadastrarQuestao(questaof);
        } catch(ExcecaoNegocio ex) {
            String msgErr = ex.getMessage();
            String msgEsperada = "A questão fechada deve conter uma alternativa correta.";
            assertTrue(msgErr.contains(msgEsperada));
            return;
        }
        
      
        
        fail("Falha não identificada disciplina vazia.");
    }  


    @Test
    public void testCadastrarQuestao12() throws Exception {
        
        try {
            //testa se a alternativa correta faz parte das alternativas
            String resposta[] = {"resposta1","resposta2","resposta3"};
            questaof.setAlternativas(resposta);
            long l=4;
            
            questaof.setAlternativaCorreta(l);
            questaoManagement.cadastrarQuestao(questaof);
        } catch(ExcecaoNegocio ex) {
            String msgErr = ex.getMessage();
            String msgEsperada = "A alternativa correta deve estar contida nas alternativas.";
            assertTrue(msgErr.contains(msgEsperada));
            return;
        }
        
      
        
        fail("Falha não identificada disciplina vazia.");
    }     
   
    //TESTE COM ALTERAR QUESTOES
    
    @Test
    public void testAlterarQuestao1() throws Exception {
        
        try {
            //testa entrada de questao null
            questao = null;
            questaoManagement.alterarQuestao(questao);
        } catch(ExcecaoNegocio ex) {
            return;
        }
        
        fail("A exceção esperada não foi capturada.");
    }
    
    @Test
    public void testAlterarQuestao2() throws Exception {
        
        try {
            //testa entrada de enunciado null
            questao.setEnunciado(null);
            questaoManagement.alterarQuestao(questao);
        } catch(ExcecaoNegocio ex) {
            String msgErr = ex.getMessage();
            String msgEsperada = "A questão precisa de enunciado para ser alterada.";
            assertTrue(msgErr.contains(msgEsperada));
            return;
        }
        
      
        
        fail("Falha não identificada.");
    }
    
    @Test
    public void testAlterarQuestao3() throws Exception {
        
        try {
            //testa entrada de enunciado vazia
            questao.setEnunciado("");
            questaoManagement.alterarQuestao(questao);
        } catch(ExcecaoNegocio ex) {
            String msgErr = ex.getMessage();
            String msgEsperada = "A questão precisa de enunciado para ser alterada.";
            assertTrue(msgErr.contains(msgEsperada));
            return;
        }
        
      
        
        fail("Falha não identificada.");
    }
    
    @Test
    public void testAlterarQuestao4() throws Exception {
        
        try {
            //testa entrada de dificuldade fora do conjunto permitido
            questao.setDificuldade(5);
            questaoManagement.alterarQuestao(questao);
        } catch(ExcecaoNegocio ex) {
            String msgErr = ex.getMessage();
            String msgEsperada = "A difículdade da questão deve ser representada por um inteiro de 1 a 4.";
            assertTrue(msgErr.contains(msgEsperada));
            return;
        }
        
      
        
        fail("Falha não identificada.");
    }
    
    @Test
    public void testAlterarQuestao5() throws Exception {
        
        try {
            //testa entrada de disciplina null
            questao.setDisciplina(null);
            questaoManagement.alterarQuestao(questao);
        } catch(ExcecaoNegocio ex) {
            String msgErr = ex.getMessage();
            String msgEsperada = "A questão precisa de uma Disciplina para ser alterada.";
            assertTrue(msgErr.contains(msgEsperada));
            return;
        }
        
      
        
        fail("Falha não identificada.");
    }

    
  
    @Test
    public void testAlterarQuestao6() throws Exception {
        
        try {
            //testa entrada de disciplina vazia
            questao.setDisciplina("");
            questaoManagement.alterarQuestao(questao);
        } catch(ExcecaoNegocio ex) {
            String msgErr = ex.getMessage();
            String msgEsperada = "A questão precisa de uma Disciplina para ser alterada.";
            assertTrue(msgErr.contains(msgEsperada));
            return;
        }
        
      
        
        fail("Falha não identificada disciplina vazia.");
    }
    
    
    
    @Test
    public void testAlterarQuestao7() throws Exception {
        
        try {
            //testa se resposta da questao aberta e nula
            questaoa.setResposta(null);
            questaoManagement.alterarQuestao(questaoa);
        } catch(ExcecaoNegocio ex) {
            String msgErr = ex.getMessage();
            String msgEsperada = "A questão aberta precisa de uma resposta padrão para ser alterada.";
            assertTrue(msgErr.contains(msgEsperada));
            return;
        }
        
      
        
        fail("Falha não identificada disciplina vazia.");
    }
    
    
    @Test
    public void testAlterarQuestao8() throws Exception {
        
        try {
            //testa se resposta da questao aberta e vazia
            questaoa.setResposta("");
            questaoManagement.alterarQuestao(questaoa);
        } catch(ExcecaoNegocio ex) {
            String msgErr = ex.getMessage();
            String msgEsperada = "A questão aberta precisa de uma resposta padrão para ser alterada.";
            assertTrue(msgErr.contains(msgEsperada));
            return;
        }
        
      
        
        fail("Falha não identificada disciplina vazia.");
    }
    
    @Test
    public void testAlterarQuestao9() throws Exception {
        
        try {
            //testa se a questao fechada tem alternativa
            questaof.setAlternativas(null);
            questaoManagement.alterarQuestao(questaof);
        } catch(ExcecaoNegocio ex) {
            String msgErr = ex.getMessage();
            String msgEsperada = "A questão fechada precisa de alternativas para ser alterada.";
            assertTrue(msgErr.contains(msgEsperada));
            return;
        }
        
      
        
        fail("Falha não identificada disciplina vazia.");
    }

    @Test
    public void testAlterarQuestao10() throws Exception {
        
        try {
            //testa se a questao fechada tem mais de uma alternativa
            String resposta[] = {"resposta"};
            questaof.setAlternativas(resposta);
            questaoManagement.alterarQuestao(questaof);
        } catch(ExcecaoNegocio ex) {
            String msgErr = ex.getMessage();
            String msgEsperada = "A questão fechada deve conter pelo menos 2 alternativas para ser alterada.";
            assertTrue(msgErr.contains(msgEsperada));
            return;
        }
        
      
        
        fail("Falha não identificada disciplina vazia.");
    }  

    @Test
    public void testAlterarQuestao11() throws Exception {
        
        try {
            //testa se a questao fechada tem alternativa correta
            questaof.setAlternativaCorreta(null);
            questaoManagement.alterarQuestao(questaof);
        } catch(ExcecaoNegocio ex) {
            String msgErr = ex.getMessage();
            String msgEsperada = "A questão fechada deve conter uma alternativa correta para ser alterada.";
            assertTrue(msgErr.contains(msgEsperada));
            return;
        }
        
      
        
        fail("Falha não identificada disciplina vazia.");
    }
    
  
    @Test
    public void testAlterarQuestao12() throws Exception {
        
        try {
            //testa se a alternativa correta faz parte das alternativas
            String resposta[] = {"resposta1","resposta2","resposta3"};
            questaof.setAlternativas(resposta);
            long a =4;
            questaof.setAlternativaCorreta(a);
            questaoManagement.alterarQuestao(questaof);
        } catch(ExcecaoNegocio ex) {
            String msgErr = ex.getMessage();
            String msgEsperada = "A alternativa correta deve estar contida nas alternativas para ser alterada.";
            assertTrue(msgErr.contains(msgEsperada));
            return;
        }
        
      
        
        fail("Falha não identificada disciplina vazia.");
    }     
    
    
    //TESTE PARA DELETAR QUESTAO
    
    @Test
    public void testDeletarQuestao() throws Exception {
        
        try {
            // testa a entrada de um id null na exclusao de uma questao
            questaoManagement.deletarQuestao(null); 
        } catch(ExcecaoPersistencia ex) {
            String msgErr = ex.getMessage();
            String msgEsperada = "Insira um id válido para deletar a questão.";
            assertTrue(msgErr.contains(msgEsperada));
            return;
        }
        
        fail("Falha não identificada.");
    }  
    
    //TESTE PARA GET QUESTAO
    
     @Test
    public void testGetQuestaoById() throws Exception {
        
        try {
            // testa a entrada de um id null na busca de um questao
            questaoManagement.getQuestaoById(null); 
        } catch(ExcecaoPersistencia ex) {
            String msgErr = ex.getMessage();
            String msgEsperada = "Insira um id válido para pesquisar uma questão.";
            assertTrue(msgErr.contains(msgEsperada));
            return;
        }
        
        fail("Falha não identificada.");
    }
    

   // */
    /**
     * Test of alterarQuestao method, of class ManterQuestaoImpl.
     */
    
    
}
