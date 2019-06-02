/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;
import sla.servico.NegocioServico;
import sla.servico.Servico;

/**
 *
 * @author badop
 */
public class ServicoIntTest {

    NegocioServico negocio;
    Servico serv;

    @Before
    public void setUp() {
        //Instanciando objeto a ser utilizado nos testes.. 
        negocio = new NegocioServico();
        serv = new Servico();
    }

    //Cadastro serviço já existente no banco  
    @Test(expected = RuntimeException.class)
    public void CadastroServicoExistente() throws Exception {

        //Arranjar
        serv = new Servico();
        serv.setDescricao("Limpeza4");
        serv.setPreco(10);
        //Agir
        negocio.cadastrarServico(serv);
        fail();
        //Avaliar
    }

    //Delete servico não existente no banco
    @Test(expected = RuntimeException.class)
    public void DeleteServicoNaoExistente() throws Exception {

        //Arranjar
        serv = new Servico();
        serv.setCodServico(999999999);
        //Agir
        negocio.removerServicoCod(serv);

        //Avaliar
    }
    //Fluxo  ListarServicos

    @Test
    public void ListarServicoTest() throws Exception {
        serv = new Servico();
        List<Servico> lista = negocio.listarServico();
        int count = lista.size();
        assertTrue(count > 0);
    }

    //Fluxo de Cadastro de Servico
    @Test
    public void CadastroServicoTest() throws Exception {
        serv = new Servico();
        List<Servico> lista = negocio.listarServico();
        int count = 0;
        if (!(lista.isEmpty())) {
            count = lista.size();
        }
        serv.setDescricao("Limpeza33333");
        serv.setPreco(100);
        negocio.cadastrarServico(serv);
        List<Servico> listaPosInsert = negocio.listarServico();
        int countPosInsert = listaPosInsert.size();
        assertTrue(countPosInsert - count == 1);

    }

    //Fluxo  ConsultarServico usando ID
    @Test
    public void ConsultarServicoId() throws Exception {
        serv = new Servico();
        serv.setCodServico(1);
        List<Servico> lista = negocio.consultarServico(serv);
        int count = lista.size();
        assertTrue(count > 0);
    }

    //Fluxo  ConsultarServico usando Descricao
    @Test
    public void ConsultarServicoDescricao() throws Exception {
        serv = new Servico();
        serv.setCodServico(0);
        serv.setDescricao("Limpeza4");
        List<Servico> lista = negocio.consultarServico(serv);
        int count = lista.size();
        assertTrue(count > 0);
    }

    //Fluxo  DeletarServico 
    @Test
    public void DeleteServicoTest() throws Exception {
        serv = new Servico();
        serv.setCodServico(2);
        List<Servico> lista = negocio.listarServico();
        //Alimentando quantidade de registros no banco..
        int count = lista.size();
        negocio.removerServicoCod(serv);
        List<Servico> listaPosDelete = negocio.listarServico();
        int countPosDelete = listaPosDelete.size();
        assertTrue(count - countPosDelete == 1);

    }

    @Test
    //Fluxo Update descricao
    public void UpdateServicoDescricaoTest() throws Exception {
        serv = new Servico();
        serv.setCodServico(1);
        serv.setDescricao("Limpezaupdate");
        serv.setPreco(10);
        negocio.alterarServico(serv);
        //Fazendo consulta pelo id..
        List<Servico> lista = negocio.consultarServico(serv);
        Servico servTest = lista.get(0);
        assertEquals(new String("Limpezaupdate"), servTest.getDescricao());

    }

    @Test
    //Fluxo Update preco
    public void UpdateServicoPrecoTest() throws Exception {
        serv = new Servico();
        serv.setCodServico(1);
        serv.setDescricao("LimpezaUpdate");
        serv.setPreco(100);
        negocio.alterarServico(serv);
        //Fazendo consulta pelo id..
        List<Servico> lista = negocio.consultarServico(serv);
        Servico servTest = lista.get(0);
        assertEquals(100.0, servTest.getPreco());
    }

    @Test(expected = RuntimeException.class)
    //Fluxo Update preco
    public void UpdateServicoExistente() throws Exception {
        serv = new Servico();
        serv.setCodServico(1);
        serv.setDescricao("Limpeza4");
        serv.setPreco(10);
        negocio.alterarServico(serv);
        //Fazendo consulta pelo id..
        List<Servico> lista = negocio.consultarServico(serv);
        fail();
    }

}
