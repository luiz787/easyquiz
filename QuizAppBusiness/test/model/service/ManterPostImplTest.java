package model.service;

import model.dao.PostDAO;
import model.dao.PostDAOImpl;
import model.domain.Post;
import model.exception.ExcecaoNegocio;
import model.exception.ExcecaoPersistencia;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ManterPostImplTest {
    private static ManterPost manterPost;
    private static PostDAO postDAO;
    private Post post;

    public ManterPostImplTest() {}

    @BeforeClass
    public static void setUpClass() throws Exception {
        postDAO = PostDAOImpl.getInstancia();
        manterPost = new ManterPostImpl(postDAO);
    }


    @Before
    public void setUp() throws Exception {
        this.post = new Post();
    }

    /**
     * Test of inserirPost method, of class ManterPostImpl.
     */
    @Test
    public void testInserirPostNulo() throws Exception {
        System.out.println("inserirPost - post nulo");
        
        try{
            post = null;
            manterPost.inserirPost(post);
        } catch(ExcecaoNegocio ex) {
            return;
        }
        
        fail("A excecao de post nulo nao foi capturada");
    }
    
    @Test
    public void testInserirPostConteudoNulo() throws Exception {
        System.out.println("inserirPost - conteudo do post nulo");
        
        try{
            post.setConteudo(null);
            manterPost.inserirPost(post);
        } catch(ExcecaoNegocio ex) {
            String mensagemErro = ex.getMessage();
            String mensagemEsperada = "Nada foi escrito!\n\n";
            assertTrue(mensagemErro.contains(mensagemEsperada));
            return;
        }
        
        fail("A excecao de post com conteudo nulo nao foi capturada");
    }
    
    @Test
    public void testInserirPostDataNulo() throws Exception {
        System.out.println("inserirPost - data do post nula");
        
        try{
            post.setDataCriacao(null);
            manterPost.inserirPost(post);
        } catch(ExcecaoNegocio ex) {
            String mensagemErro = ex.getMessage();
            String mensagemEsperada = "Nenhuma data informada!\n\n";
            assertTrue(mensagemErro.contains(mensagemEsperada));
            return;
        }
        
        fail("A excecao de post com data nula nao foi capturada");
    }

    @Test
    public void testInserirPostIdNulo() throws Exception {
        System.out.println("inserirPost - ID do post nulo");
        
        try{
            post.setId(null);
            manterPost.inserirPost(post);
        } catch(ExcecaoNegocio ex) {
            String mensagemErro = ex.getMessage();
            String mensagemEsperada = "Nenhum ID informado!\n\n";
            assertTrue(mensagemErro.contains(mensagemEsperada));
            return;
        }
        
        fail("A excecao de post com ID nulo nao foi capturada");
    }
    
    @Test
    public void testInserirPostIdAutorNulo() throws Exception {
        System.out.println("inserirPost - ID do autor nulo");
        
        try{
            post.setIdAutor(null);
            manterPost.inserirPost(post);
        } catch(ExcecaoNegocio ex) {
            String mensagemErro = ex.getMessage();
            String mensagemEsperada = "O ID do autor não foi informado!\n\n";
            assertTrue(mensagemErro.contains(mensagemEsperada));
            return;
        }
        
        fail("A excecao de post com ID do autor nulo nao foi capturada");
    }
    
    @Test
    public void testInserirPostIdQuestaoNulo() throws Exception {
        System.out.println("inserirPost - ID da questão nulo");
        
        try{
            post.setIdQuestao(null);
            manterPost.inserirPost(post);
        } catch(ExcecaoNegocio ex) {
            String mensagemErro = ex.getMessage();
            String mensagemEsperada = "O ID da questão não foi informado!\n\n";
            assertTrue(mensagemErro.contains(mensagemEsperada));
            return;
        }
        
        fail("A excecao de post com ID da questao nula nao foi capturada");
    }

    /**
     * Test of getAll method, of class ManterPostImpl.
     */
    @Test
    public void testGetAll() throws Exception {
        System.out.println("teste getAll");
        
        try{
            Long idQuestao = null;
            manterPost.getAll(idQuestao);
        } catch(ExcecaoPersistencia ex) {
            return;
        }
        
        fail("A excecao de getAll com idQuestao nulo nao foi capturado");
    } 
}
