/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;
import sla.clientes.ClientePessoaFisica;
import sla.clientes.ClientePessoaJuridica;
import sla.clientes.NegocioCliente;

/**
 *
 * @author badop
 */
public class ClienteIntTest {

    NegocioCliente negocio;
    ClientePessoaFisica pf;
    ClientePessoaJuridica pj;

    //Falta implementar fluxo do update, tanto pra teste unitario como teste de integração
    @Before
    public void setUp() {
        //Instanciando objeto a ser utilizado nos testes.. 
        negocio = new NegocioCliente();
        pf = new ClientePessoaFisica();
        pj = new ClientePessoaJuridica();

    }

    //Cadastro pf  passando dados de um cliente previamente cadastrado na base de dados
    @Test(expected = RuntimeException.class)
    public void CadastroPfExistente() throws Exception {
        //Arranjar
        pf = new ClientePessoaFisica();
        pf.setCli_Cpf("055.186.754-04");
        pf.setNome("Pedro");
        pf.setSexo("m");
        pf.setCep("54.410-010");
        pf.setLogradouro("Av Bernardo Vieira de Melo");
        pf.setNumeroLogradouro("300");
        pf.setComplemento("300");
        pf.setBairro("Piedade");
        pf.setCidade("Recife");
        pf.setEstado("PE");
        pf.setEmail("bps@gmail.com");
        pf.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.cadastrarClientePF(pf);
        fail();

        //Avaliar
    }

    //Cadastro pj  passando dados de um cliente previamente cadastrado na base de dados
    @Test(expected = RuntimeException.class)
    public void CadastroPjExistente() throws Exception {
        pj = new ClientePessoaJuridica();
        pj.setCli_Cnpj("XX.XXX.XXX/YYYY-ZZ");
        pj.setRazaoSocial("Teste30");
        pj.setCep("54.410-010");
        pj.setLogradouro("Av Bernardo Vieira de Melo");
        pj.setNumeroLogradouro("300");
        pj.setComplemento("300");
        pj.setBairro("Piedade");
        pj.setCidade("Recife");
        pj.setEstado("PE");
        pj.setEmail("bps@gmail.com");
        pj.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.cadastrarClientePJ(pj);

        //Avaliar
        fail();

        //Avaliar
    }

    //Delete pf não existente no banco
    @Test(expected = RuntimeException.class)
    public void DeletePfNaoExistente() throws Exception {

        //Arranjar
        pf = new ClientePessoaFisica();
        pf.setCli_Codigo(9999999);
        pf.setCli_Cpf("");
        pf.setNome("");

        //Agir
        negocio.removerClientePFCod(pf);
        fail();

        //Avaliar
    }

    //Delete pj não existente no banco
    @Test(expected = RuntimeException.class)
    public void DeletePjNaoExistente() throws Exception {

        //Arranjar
        pj = new ClientePessoaJuridica();
        pj.setCli_Codigo(9999999);
        pj.setCli_Cnpj("");
        //Agir
        negocio.removerClientePJCod(pj);

        //Avaliar
    }

    //Fluxo  ListarPF
    @Test
    public void ListarPfTest() throws Exception {
        //Pra CT funcionar deve haver clientes previamente cadastrados na base de dados
        List<ClientePessoaFisica> lista = negocio.listarClientePF();
        int count = lista.size();
        assertTrue(count > 0);
    }

    //Fluxo  ListarPj
    @Test
    public void ListarPjTest() throws Exception {
        //Pra CT funcionar deve haver clientes previamente cadastrados na base de dados
        List<ClientePessoaJuridica> lista = negocio.listarClientePJ();
        int count = lista.size();
        assertTrue(count > 0);
    }

    //Fluxo CadastroPF
    @Test
    public void CadastroPfTest() throws Exception {

        List<ClientePessoaFisica> lista = negocio.listarClientePF();
        int count = 0;
        if (!(lista.isEmpty())) {
            count = lista.size();
        }
        //Arranjar
        pf = new ClientePessoaFisica();
        pf.setCli_Cpf("055.186.754-02");
        pf.setNome("Bernardoo");
        pf.setSexo("m");
        pf.setCep("54.410-010");
        pf.setLogradouro("Av Bernardo Vieira de Melo");
        pf.setNumeroLogradouro("300");
        pf.setComplemento("300");
        pf.setBairro("Piedade");
        pf.setCidade("Recife");
        pf.setEstado("PE");
        pf.setEmail("bps@gmail.com");
        pf.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.cadastrarClientePF(pf);

        List<ClientePessoaFisica> listaPosInsert = negocio.listarClientePF();
        int countPosInsert = listaPosInsert.size();
        assertTrue(countPosInsert - count == 1);
    }

    //Fluxo de CadastroPJ
    @Test
    public void CadastroPjTest() throws Exception {
        List<ClientePessoaJuridica> lista = negocio.listarClientePJ();
        int count = 0;
        if (!(lista.isEmpty())) {
            count = lista.size();
        }
        pj = new ClientePessoaJuridica();
        pj.setCli_Cnpj("XX.XXX.XXX/YYYY-ZZ");
        pj.setRazaoSocial("Teste9");
        pj.setCep("54.410-010");
        pj.setLogradouro("Av Bernardo Vieira de Melo");
        pj.setNumeroLogradouro("300");
        pj.setComplemento("300");
        pj.setBairro("Boa Viagem");
        pj.setCidade("Jaboatão dos Guararapes");
        pj.setEstado("PE");
        pj.setEmail("bps@gmail.com");
        pj.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.cadastrarClientePJ(pj);

        List<ClientePessoaJuridica> listaPosInsert = negocio.listarClientePJ();
        int countPosInsert = listaPosInsert.size();
        assertTrue(countPosInsert - count == 1);

    }

    //Fluxo  ConsultarPF usando ID
    @Test
    public void ConsultarPfIdTest() throws Exception {
        pf = new ClientePessoaFisica();
        pf.setCli_Codigo(1);
        List<ClientePessoaFisica> lista = negocio.consultarClientePF(pf);
        int count = lista.size();
        assertTrue(count > 0);
    }

    //Fluxo  ConsultarPF usando CPF
    @Test
    public void ConsultarPfCPFTest() throws Exception {
        pf = new ClientePessoaFisica();
        pf.setCli_Codigo(-1);
        pf.setCli_Cpf("055.186.754-02");
        List<ClientePessoaFisica> lista = negocio.consultarClientePF(pf);
        int count = lista.size();
        assertTrue(count > 0);
    }

    //Fluxo  ConsultarPF usando Nome
    @Test
    public void ConsultarPfNomeTest() throws Exception {
        pf = new ClientePessoaFisica();
        pf.setCli_Codigo(0);
        pf.setCli_Cpf("");
        pf.setNome("Pedro");
        List<ClientePessoaFisica> lista = negocio.consultarClientePF(pf);
        int count = lista.size();
        assertTrue(count > 0);
    }

    //teste de consulta passando 3 parametros invalidos(id<=0) && cpf = null  && nome=null
    @Test(expected = RuntimeException.class)
    public void ConsultarPfCodCpfNomeInvalidos() throws Exception {
        pf = new ClientePessoaFisica();
        pf.setCli_Codigo(-1);
        pf.setCli_Cpf(null);
        pf.setNome(null);
        List<ClientePessoaFisica> lista = negocio.consultarClientePF(pf);
        int count = lista.size();
        assertTrue(count > 0);
    }

    //Fluxo  ConsultarPJ usando Id
    @Test
    public void ConsultarPjIdTest() throws Exception {
        pj = new ClientePessoaJuridica();
        pj.setCli_Codigo(4);
        pj.setCli_Cnpj("");
        List<ClientePessoaJuridica> lista = negocio.consultarClientePJ(pj);
        int count = lista.size();
        assertTrue(count > 0);
    }

    //Fluxo  ConsultarPJ passando Id inexistente
    @Test
    public void ConsultarPjIdInexistente() throws Exception {
        pj = new ClientePessoaJuridica();
        pj.setCli_Codigo(999999999);
        pj.setCli_Cnpj("");
        List<ClientePessoaJuridica> lista = negocio.consultarClientePJ(pj);
        assertTrue(lista.size()<=0);
        
    }

    //Fluxo  ConsultarPJ usando Cnpj
    @Test
    public void ConsultarPjCNPJTest() throws Exception {
        pj = new ClientePessoaJuridica();
        pj.setCli_Codigo(-1);
        pj.setCli_Cnpj("XX.XXX.XXX/YYYY-ZZ");
        List<ClientePessoaJuridica> lista = negocio.consultarClientePJ(pj);
        int count = lista.size();
        assertTrue(count > 0);
    }

    //Fluxo  DeletePF
    @Test
    public void DeletePfTest() throws Exception {
        pf = new ClientePessoaFisica();
        pf.setCli_Codigo(3);
        List<ClientePessoaFisica> lista = negocio.listarClientePF();
        //Alimentando quantidade de registros no banco..
        int count = lista.size();
        negocio.removerClientePFCod(pf);
        List<ClientePessoaFisica> listaPosDelete = negocio.listarClientePF();
        int countPosDelete = listaPosDelete.size();
        assertTrue(count - countPosDelete == 1);

    }

    //Fluxo  DeletePJ
    @Test
    public void DeletePjTest() throws Exception {
        pj = new ClientePessoaJuridica();
        pj.setCli_Codigo(6);
        pj.setCli_Cnpj("");
        List<ClientePessoaJuridica> lista = negocio.listarClientePJ();
        //Alimentando quantidade de registros no banco..
        int count = lista.size();
        negocio.removerClientePJCod(pj);
        List<ClientePessoaJuridica> listaPosDelete = negocio.listarClientePJ();
        int countPosDelete = listaPosDelete.size();
        assertTrue(count - countPosDelete == 1);

    }

    @Test
    //Fluxo Update PF
    public void UpdatePfTest() throws Exception {

        //Arranjar
        pf = new ClientePessoaFisica();
        pf.setCli_Codigo(1);
        pf.setCli_Cpf("055.186.754-98");
        pf.setNome("Bernardoooooooooo");
        pf.setSexo("M");
        pf.setCep("54.410-011");
        pf.setLogradouro("Av Bernardo Vieira de Meloo");
        pf.setNumeroLogradouro("3000");
        pf.setComplemento("3000");
        pf.setBairro("Piedaade");
        pf.setCidade("Recifee");
        pf.setEstado("PE");
        pf.setEmail("bpss@gmail.com");
        pf.setTelefone("(81)9.8189-9981");

        //Agir
        negocio.alterarClientePF(pf);
        //Fazendo consulta pelo id..
        pf = new ClientePessoaFisica();
        pf.setCli_Codigo(1);
        List<ClientePessoaFisica> listapos = negocio.consultarClientePF(pf);
        pf = listapos.get(0);
        assertEquals(new String("055.186.754-98"), pf.getCli_Cpf());

    }

    //Fluxo  ConsultarPJ passando Id inexistente
    @Test
    public void ConsultarPfIdInexistente() throws Exception {
        pf = new ClientePessoaFisica();
        pf.setCli_Codigo(999999999);
        pf.setCli_Cpf("");
        List<ClientePessoaFisica> lista = negocio.consultarClientePF(pf);
        assertTrue(lista.size()<=0);
        
    }

    @Test(expected = RuntimeException.class)
    //Fluxo Update PF
    public void UpdatePfExistente() throws Exception {

        //Arranjar
        pf = new ClientePessoaFisica();
        pf.setCli_Codigo(1);
        pf.setCli_Cpf("055.186.754-04");
        pf.setNome("Pedro");
        pf.setSexo("m");
        pf.setCep("54.410-010");
        pf.setLogradouro("Av Bernardo Vieira de Melo");
        pf.setNumeroLogradouro("300");
        pf.setComplemento("300");
        pf.setBairro("Piedade");
        pf.setCidade("Recife");
        pf.setEstado("PE");
        pf.setEmail("bps@gmail.com");
        pf.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.alterarClientePF(pf);
        fail();

    }

    @Test
    //Fluxo Update PJ
    public void UpdatePjTest() throws Exception {
        //Arranjar
        pj = new ClientePessoaJuridica();
        pj.setCli_Codigo(4);
        pj.setCli_Cnpj("XX.XXX.XXX/YYYY-ZZ");
        pj.setRazaoSocial("Teste65");
        pj.setCep("54.410-015");
        pj.setLogradouro("Av Bernardo Vieira de Melooooooo");
        pj.setNumeroLogradouro("2331");
        pj.setComplemento("3022");
        pj.setBairro("Piedadeee");
        pj.setCidade("Jaboatão dos Guararaapes");
        pj.setEstado("PE");
        pj.setEmail("bpsss@gmail.com");
        pj.setTelefone("(81)8.8188-9981");

        //Agir
        negocio.alterarClientePJ(pj);
        //Fazendo consulta pelo id..
        pj = new ClientePessoaJuridica();
        pj.setCli_Codigo(4);
        //Alimentando cnpj aleatorio para fazer consulta no banco(Classe de negócio nao permite que entre cnpj.length!=18)
        pj.setCli_Cnpj("123456789012345678");
        List<ClientePessoaJuridica> lista = negocio.consultarClientePJ(pj);
        pj = lista.get(0);
        assertEquals(new String("XX.XXX.XXX/YYYY-ZZ"), pj.getCli_Cnpj());

    }

    //Update pj  passando dados de um cliente previamente cadastrado na base de dados
    @Test(expected = RuntimeException.class)
    public void UpdatePjExistente() throws Exception {
        pj = new ClientePessoaJuridica();
        pj.setCli_Cnpj("XX.XXX.XXX/YYYY-ZZ");
        pj.setRazaoSocial("Teste3");
        pj.setCep("54.410-010");
        pj.setLogradouro("Av Bernardo Vieira de Melo");
        pj.setNumeroLogradouro("300");
        pj.setComplemento("300");
        pj.setBairro("Piedade");
        pj.setCidade("Recife");
        pj.setEstado("PE");
        pj.setEmail("bps@gmail.com");
        pj.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.alterarClientePJ(pj);

        //Avaliar
        fail();

        //Avaliar
    }

}
