/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

/**
 *
 * @author badop
 */
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import sla.servico.NegocioServico;
import sla.servico.Servico;

public class ServicoUnitTest {

    NegocioServico negocio;
    Servico serv;

    @Before
    public void setUp() {
        //Instanciando objeto a ser utilizado nos testes.. 
        negocio = new NegocioServico();
        serv = new Servico();
    }

    // Início do bloco de testes unitários 
    //Módulo Insert
    //Cadastro com objeto null
    @Test(expected = RuntimeException.class)
    public void CadastroServicoObjetoNulo() throws Exception {

        //Arranjar
        serv = null;
        //Agir
        negocio.cadastrarServico(serv);

        //Avaliar
    }

    //Cadastro com descrição nula -> descricao = null;
    @Test(expected = RuntimeException.class)
    public void CadastroServicoDescricaoNull() throws Exception {
        //Arranjar
        serv.setDescricao(null);
        serv.setPreco(10);

        //Agir
        negocio.cadastrarServico(serv);

        //Avaliar
    }

    //Cadastro com preco = 0
    @Test(expected = RuntimeException.class)
    public void CadastroServicoPrecoZero() throws Exception {
        //Arranjar
        serv.setDescricao("Limpeza");
        serv.setPreco(0);
        //Agir
        negocio.cadastrarServico(serv);

        //Avaliar
    }

    //Cadastro com descrição acima do limite de caracteres -> descricao.length > 50 ;
    @Test(expected = RuntimeException.class)
    public void CadastroServicoDescricaoEstourandoLimiteCarac() throws Exception {
        //Arranjar
        serv.setDescricao("123456789012345678901234567890123456789012345678901");
        serv.setPreco(10);

        //Agir
        negocio.cadastrarServico(serv);

        //Avaliar
    }

    //Cadastro com descrição vazia -> ""
    @Test(expected = RuntimeException.class)
    public void CadastroServicoDescricaoVazia() throws Exception {
        //Arranjar
        serv.setDescricao("");
        serv.setPreco(50);

        //Agir
        negocio.cadastrarServico(serv);

        //Avaliar
    }

    /*Testes unitários do módulo Update
     Update passando objeto null*/
    @Test(expected = RuntimeException.class)
    public void UpdateServicoObjetoNull() throws Exception {
        serv = null;
        negocio.alterarServico(serv);

    }

    //Update passando descricao null
    @Test(expected = RuntimeException.class)
    public void UpdateServicoDescricaoNull() throws Exception {
        serv = new Servico();
        serv.setCodServico(1);
        serv.setDescricao(null);
        serv.setPreco(10);
        negocio.alterarServico(serv);

    }

    //Update passando descricao vazia 
    @Test(expected = RuntimeException.class)
    public void UpdateServicoDescricaoVazia() throws Exception {
        serv = new Servico();
        serv.setCodServico(1);
        serv.setDescricao("");
        serv.setPreco(10);
        negocio.alterarServico(serv);

    }

    //Update estourando limite de caracteres para descricao
    @Test(expected = RuntimeException.class)
    public void UpdateServicoDescricaoEstourandoLimiteCaracteres() throws Exception {
        serv = new Servico();
        serv.setCodServico(1);
        serv.setDescricao("012345678901234567890123456789012345678901234567891");
        serv.setPreco(10);
        negocio.alterarServico(serv);
    }

    //Update passando preço inválido
    @Test(expected = RuntimeException.class)
    public void UpdateServicoPrecoInvalido() throws Exception {
        serv = new Servico();
        serv.setCodServico(1);
        serv.setDescricao("Limpeza");
        serv.setPreco(0);
        negocio.alterarServico(serv);

    }

    //Fim dos testes unitários do módulo update
    //Testes unitários do módulo Select
    // Select servico passando descricao = null
    @Test(expected = RuntimeException.class)
    public void SelectServicoDescricaoNull() throws Exception {

        //Arranjar
        serv = new Servico();
        serv.setDescricao(null);
        //Agir
        List<Servico> lista = negocio.consultarServico(serv);
        fail();
        //Avaliar
    }

    //Select passando id=0 e descricao vazia
    @Test(expected = RuntimeException.class)
    public void SelectServicoIdDescricaoInvalidos1() throws Exception {

        //Arranjar
        serv = new Servico();
        serv.setCodServico(0);
        serv.setDescricao("");
        //Agir
        List<Servico> list = negocio.consultarServico(serv);
        fail();
        //Avaliar
    }

    //Select estourando limite de caracteres para descricao
    @Test(expected = RuntimeException.class)
    public void SelectServicoDescricaoEstourandoLimiteCaracteres2() throws Exception {
        serv = new Servico();
        serv.setCodServico(1);
        serv.setDescricao("012345678901234567890123456789012345678901234567891");//Descricao com 51 caracteres (max permitido ->50)
        serv.setPreco(10);
        List<Servico> lista = negocio.consultarServico(serv);
        fail();
    }

    //Select passando id=0 e descricao null
    @Test(expected = RuntimeException.class)
    public void SelectServicoIdDescricaoInvalidos2() throws Exception {

        //Arranjar
        serv = new Servico();
        serv.setCodServico(0);
        serv.setDescricao(null);
        //Agir
        List<Servico> list = negocio.consultarServico(serv);
        fail();
        //Avaliar
    }

    //Select passando id=0 e descricao.length>50
    @Test(expected = RuntimeException.class)
    public void SelectServicoIdDescricaoInvalidos3() throws Exception {

        //Arranjar
        serv = new Servico();
        serv.setCodServico(0);
        serv.setDescricao("012345678901234567890123456789012345678901234567891");
        //Agir
        List<Servico> list = negocio.consultarServico(serv);
        fail();
        //Avaliar
    }

    //Select passando objeto nulo
    @Test(expected = RuntimeException.class)
    public void SelectServicoObjetoNull() throws Exception {

        //Arranjar
        serv = null;
        //Agir
        List<Servico> list = negocio.consultarServico(serv);
        fail();
        //Avaliar
    }

    /*Testes unitários do módulo Delete
     Delete passando objeto null*/
    @Test(expected = RuntimeException.class)
    public void DeleteServicoObjetoNulo() throws Exception {

        //Arranjar
        serv = null;
        //Agir
        negocio.removerServicoCod(serv);

        //Avaliar
    }

    //Delete serviço passando id<0
    @Test(expected = RuntimeException.class)
    public void DeleteServicoIdNegativo() throws Exception {

        //Arranjar
        serv = new Servico();
        serv.setCodServico(-1);
        //Agir
        negocio.removerServicoCod(serv);

        //Avaliar
    }

    // Fim do bloco de testes unitários 
}
