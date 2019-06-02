/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peca;

import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;
import sla.pecas.NegocioPeca;
import sla.pecas.Peca;

/**
 *
 * @author badop
 */
public class PecaIntTest {
    
    NegocioPeca negocio;
    Peca peca;
    
        //Falta implementar fluxo do update, tanto pra teste unitario como teste de integração
    @Before
    public void setUp() {
        //Instanciando objeto a ser utilizado nos testes.. 
        negocio = new NegocioPeca();
        peca = new Peca();

    }
    
    
    
    /* Testes de integração da classe Peca */
    
    
     //Cadastro peça já existente no banco   OBS: Pra ter o resultado esperado, deve ter pelo menos 1 peça cadastrada no banco
    @Test(expected = RuntimeException.class)
    public void CadastroPecaExistente() throws Exception {

        //Arranjar
        peca = new Peca();
        peca.setDescricao("Carroo");
        peca.setPreco(10);
        //Agir
        negocio.cadastrarPeca(peca);
        fail();
        //Avaliar
    }
    
      //Delete peça não existente no banco
    @Test(expected = RuntimeException.class)
    public void DeletePecaNaoExistente() throws Exception {

        //Arranjar
        peca = new Peca();
        peca.setCodigo(999999999);
        //Agir
        negocio.removerPecaCod(peca);

        //Avaliar
    }
    
    //Fluxo  ListarPecas
    @Test
    public void ListarPecaTest() throws Exception {
        peca = new Peca();
        List<Peca> lista = negocio.listarPeca(peca);
        int count = lista.size();
        assertTrue(count > 0);
    }

    //Fluxo de Cadastro de peca
    @Test
    public void CadastroPecaTest() throws Exception {
        peca = new Peca();
        List<Peca> lista = negocio.listarPeca(peca);
        int count = 0;
        if (!(lista.isEmpty())) {
            count = lista.size();
        }
        peca.setDescricao("Porsche");
        peca.setPreco(10);
        negocio.cadastrarPeca(peca);
        List<Peca> listaPosInsert = negocio.listarPeca(peca);
        int countPosInsert = listaPosInsert.size();
        assertTrue(countPosInsert - count == 1);

    }

    //Fluxo  ConsultarPeca usando ID
    @Test
    public void ConsultarPecaId() throws Exception {
        peca = new Peca();
        peca.setCodigo(1);
        List<Peca> lista = negocio.consultarPeca(peca);
        int count = lista.size();
        assertTrue(count > 0);
    }

    //Fluxo  ConsultarPeca usando Descricao
    @Test
    public void ConsultarPecaDescricao() throws Exception {
        peca = new Peca();
        peca.setCodigo(0);
        peca.setDescricao("Carroo");
        List<Peca> lista = negocio.consultarPeca(peca);
        int count = lista.size();
        assertTrue(count > 0);
    }

    //Fluxo  DeletePeca
    @Test
    public void DeletePecaTest() throws Exception {
        peca = new Peca();
        peca.setCodigo(3);
        List<Peca> lista = negocio.listarPeca(peca);
        //Alimentando quantidade de registros no banco..
        int count = lista.size();
        negocio.removerPecaCod(peca);
        List<Peca> listaPosDelete = negocio.listarPeca(peca);
        int countPosDelete = listaPosDelete.size();
        assertTrue(count - countPosDelete == 1);

    }

    //Fluxo Update descricao
      @Test
    public void UpdatePecaDescricaoTest() throws Exception {
        peca = new Peca();
        peca.setCodigo(1);
        peca.setDescricao("Ferrari");
        peca.setPreco(10);
        negocio.alterarPeca(peca);
        //Fazendo consulta pelo id..
        List<Peca> lista = negocio.consultarPeca(peca);
        Peca pecaTest = lista.get(0);
        assertEquals("Ferrari",pecaTest.getDescricao());

    }

    //Fluxo Update preco
      @Test
    public void UpdatePecaPrecoTest() throws Exception {
        peca = new Peca();
        peca.setCodigo(1);
        peca.setDescricao("Ferrari");
        peca.setPreco(100000);
        negocio.alterarPeca(peca);
        //Fazendo consulta pelo id..
        List<Peca> lista = negocio.consultarPeca(peca);
        Peca pecaTest = lista.get(0);
        assertEquals("Ferrari", pecaTest.getDescricao());
    }
    
        //Update peça já existente no banco  
    @Test(expected = RuntimeException.class)
    public void UpdatePecaExistente() throws Exception {

        //Arranjar
        peca = new Peca();
        peca.setCodigo(4);
        peca.setDescricao("Carroo");
        peca.setPreco(10);
        //Agir
        negocio.alterarPeca(peca);
        fail();
        //Avaliar
    }

    //Fim do bloco de testes de integração e testes de sistema
    
}
