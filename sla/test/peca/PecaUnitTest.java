/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peca;

import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import sla.pecas.NegocioPeca;
import sla.pecas.Peca;

public class PecaUnitTest {

    NegocioPeca negocio;
    Peca peca;

    //Falta implementar fluxo do update, tanto pra teste unitario como teste de integração
    @Before
    public void setUp() {
        //Instanciando objeto a ser utilizado nos testes.. 
        negocio = new NegocioPeca();
        peca = new Peca();

    }

    // Início do bloco de testes unitários   
    //Módulo Insert
    //Cadastro com objeto null
    @Test(expected = RuntimeException.class)
    public void CadastroPecaObjetoNulo() throws Exception {

        //Arranjar
        peca = null;
        //Agir
        negocio.cadastrarPeca(peca);

        //Avaliar
    }

    //Cadastro com descrição nula -> descricao = null;
    @Test(expected = RuntimeException.class)
    public void CadastroPecaDescricaoNull() throws Exception {
        //Arranjar
        peca.setDescricao(null);

        //Agir
        negocio.cadastrarPeca(peca);

        //Avaliar
    }

    //Cadastro com preco = 0
    @Test(expected = RuntimeException.class)
    public void CadastroPecaPrecoZero() throws Exception {
        //Arranjar
        peca.setDescricao("Carro");
        peca.setPreco(0);
        //Agir
        negocio.cadastrarPeca(peca);

        //Avaliar
    }

    //Cadastro com descrição acima do limite de caracteres -> descricao.length > 50 ;
    @Test(expected = RuntimeException.class)
    public void CadastroPecaDescricaoEstourandoLimiteCarac() throws Exception {
        //Arranjar
        peca.setDescricao("123456789012345678901234567890123456789012345678901");

        //Agir
        negocio.cadastrarPeca(peca);

        //Avaliar
    }

    //Cadastro com descrição vazia -> ""
    @Test(expected = RuntimeException.class)
    public void CadastroPecaDescricaoVazia() throws Exception {
        //Arranjar
        peca.setDescricao("");
        peca.setPreco(50);

        //Agir
        negocio.cadastrarPeca(peca);

        //Avaliar
    }

    //Testes unitários do módulo Select
    // Select peca passando descricao = null
    @Test(expected = RuntimeException.class)
    public void SelectPecaDescricaoNull() throws Exception {

        //Arranjar
        peca = new Peca();
        peca.setDescricao(null);
        //Agir
        List<Peca> lista = negocio.consultarPeca(peca);
        fail();
        //Avaliar
    }

    //Select passando descricao estourando limite de caracteres
    @Test(expected = RuntimeException.class)
    public void SelectPecaDescricaoEstourandoLimiteCaracteres() throws Exception {

        //Arranjar
        peca = new Peca();
        peca.setCodigo(0);
        peca.setDescricao("123456789012345678901234567890123456789012345678901"); //Descrição com 51 caracteres (max permitido->50)
        //Agir
        List<Peca> list = negocio.consultarPeca(peca);
        fail();
        //Avaliar
    }
    
        //Select passando id>=0 e descricao estourando limite de caracteres
    @Test(expected = RuntimeException.class)
    public void SelectPecaDescricaoEstourandoLimiteCaracteres2() throws Exception {

        //Arranjar
        peca = new Peca();
        peca.setCodigo(2);
        peca.setDescricao("123456789012345678901234567890123456789012345678901");//Descrição com 51 caracteres (max permitido->50)
        //Agir
        List<Peca> list = negocio.consultarPeca(peca);
        fail();
        //Avaliar
    }
    
     //Select passando id=0 e descricao vazia
    @Test(expected = RuntimeException.class)
    public void SelectPecaIdDescricaoInvalidos() throws Exception {

        //Arranjar
        peca = new Peca();
        peca.setCodigo(0);
        peca.setDescricao("");
        //Agir
        List<Peca> list = negocio.consultarPeca(peca);
        fail();
        //Avaliar
    }



    //Select passando id=0 e descricao.length>50
    @Test(expected = RuntimeException.class)
    public void SelectPecaIdDescricaoInvalidos3() throws Exception {

        //Arranjar
        peca = new Peca();
        peca.setCodigo(0);
        peca.setDescricao("012345678901234567890123456789012345678901234567891");
        //Agir
        List<Peca> list = negocio.consultarPeca(peca);
        fail();
        //Avaliar
    }

    //Select passando objeto nulo
    @Test(expected = RuntimeException.class)
    public void SelectPecaObjetoNull() throws Exception {

        //Arranjar
        peca = null;
        //Agir
        List<Peca> list = negocio.consultarPeca(peca);
        fail();
        //Avaliar
    }

    /*Testes unitários do módulo Delete
     Delete passando objeto null*/
    @Test(expected = RuntimeException.class)
    public void DeletePecaObjetoNulo() throws Exception {

        //Arranjar
        peca = null;
        //Agir
        negocio.removerPecaCod(peca);

        //Avaliar
    }
    
      
     //Delete passando id<0
    @Test(expected = RuntimeException.class)
    public void DeletePecaDescricaoNull() throws Exception {
        peca = new Peca();
        peca.setCodigo(-1);
        
        negocio.removerPecaCod(peca);

    }

    /*Testes unitários do módulo Update
     Update passando objeto null*/
    @Test(expected = RuntimeException.class)
    public void UpdatePecaObjetoNull() throws Exception {
        peca = null;
        negocio.alterarPeca(peca);

    }

    //Update passando descricao null
    @Test(expected = RuntimeException.class)
    public void UpdatePecaDescricaoNull() throws Exception {
        peca = new Peca();
        peca.setCodigo(1);
        peca.setDescricao(null);
        peca.setPreco(100);
        negocio.alterarPeca(peca);

    }
  

    //Update passando descricao vacia 
    @Test(expected = RuntimeException.class)
    public void UpdatePecaDescricaoVazia() throws Exception {
        peca = new Peca();
        peca.setCodigo(1);
        peca.setDescricao("");
        peca.setPreco(100);
        negocio.alterarPeca(peca);

    }

    //Update estourando limite de caracteres para descricao
    @Test(expected = RuntimeException.class)
    public void UpdatePecaDescricaoEstourandoLimiteCaracteres() throws Exception {
        peca = new Peca();
        peca.setCodigo(1);
        peca.setDescricao("012345678901234567890123456789012345678901234567891");
        peca.setPreco(100);
        negocio.alterarPeca(peca);

    }

    //Update passando preço inválido
    @Test(expected = RuntimeException.class)
    public void UpdatePecaPrecoInvalido() throws Exception {
        peca = new Peca();
        peca.setCodigo(1);
        peca.setDescricao("Ferrari");
        peca.setPreco(0);
        negocio.alterarPeca(peca);

    }

    //Fim dos testes unitários do módulo update
}
