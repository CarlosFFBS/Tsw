 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import sla.clientes.ClientePessoaFisica;
import sla.clientes.ClientePessoaJuridica;
import sla.clientes.NegocioCliente;

public class ClienteUnitTest {

    NegocioCliente negocio;
    ClientePessoaFisica pf;
    ClientePessoaJuridica pj;

    //Falta implementar fluxo do update, tanto pra teste unitario como teste de integração
    @Before
    public void setUp() {
        //Instanciando objeto a ser utilizado nos testes.. 
        negocio = new NegocioCliente();

    }

    // Início do bloco de testes unitários   
    //Módulo Insert PF
    //Cadastro PF com objeto null
    @Test(expected = RuntimeException.class)
    public void CadastroPFObjetoNulo() throws Exception {

        //Arranjar
        pf = null;
        //Agir
        negocio.cadastrarClientePF(pf);

        //Avaliar
    }

    //Cadastro PF com cpf null 
    @Test(expected = RuntimeException.class)
    public void CadastroPfCpfNull() throws Exception {
        //Arranjar
        pf = new ClientePessoaFisica();
        pf.setCli_Cpf(null);
        pf.setNome("Pedro");
        pf.setSexo("m");
        pf.setCep("54.410-010");
        pf.setLogradouro("Av Bernardo Vieira de Melo");
        pf.setNumeroLogradouro("3074");
        pf.setComplemento("302");
        pf.setBairro("Piedade");
        pf.setCidade("Jaboatão dos Guararapes");
        pf.setEstado("PE");
        pf.setEmail("bps@gmail.com");
        pf.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.cadastrarClientePF(pf);

        //Avaliar
    }

    //Cadastro pf com CPF estourando limite de caracteres. Esse test case tambem vale pro cenário de cpf com tamanho inferior ao tamanho necessário(cpf.length =14).
    @Test(expected = RuntimeException.class)
    public void CadastroPfCpfLengthInvalido() throws Exception {
        //Arranjar
        pf = new ClientePessoaFisica();
        pf.setCli_Cpf("055.186.754-022");
        pf.setNome("Pedro");
        pf.setSexo("m");
        pf.setCep("54.410-010");
        pf.setLogradouro("Av Bernardo Vieira de Melo");
        pf.setNumeroLogradouro("3074");
        pf.setComplemento("302");
        pf.setBairro("Piedade");
        pf.setCidade("Jaboatão dos Guararapes");
        pf.setEstado("PE");
        pf.setEmail("bps@gmail.com");
        pf.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.cadastrarClientePF(pf);

        //Avaliar
    }

    //Cadastro pf com Nome null;
    @Test(expected = RuntimeException.class)
    public void CadastroPfNomeNull() throws Exception {
        //Arranjar
        pf = new ClientePessoaFisica();
        pf.setCli_Cpf("055.186.754-02");
        pf.setNome(null);
        pf.setSexo("m");
        pf.setCep("54.410-010");
        pf.setLogradouro("Av Bernardo Vieira de Melo");
        pf.setNumeroLogradouro("3074");
        pf.setComplemento("302");
        pf.setBairro("Piedade");
        pf.setCidade("Jaboatão dos Guararapes");
        pf.setEstado("PE");
        pf.setEmail("bps@gmail.com");
        pf.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.cadastrarClientePF(pf);

        //Avaliar
    }

    //Cadastro pf com Nome vazio;
    @Test(expected = RuntimeException.class)
    public void CadastroPfNomeVazio() throws Exception {
        //Arranjar
        pf = new ClientePessoaFisica();
        pf.setCli_Cpf("055.186.754-02");
        pf.setNome("");
        pf.setSexo("m");
        pf.setCep("54.410-010");
        pf.setLogradouro("Av Bernardo Vieira de Melo");
        pf.setNumeroLogradouro("3074");
        pf.setComplemento("302");
        pf.setBairro("Piedade");
        pf.setCidade("Jaboatão dos Guararapes");
        pf.setEstado("PE");
        pf.setEmail("bps@gmail.com");
        pf.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.cadastrarClientePF(pf);

        //Avaliar
    }

    //Cadastro pf com Nome estourando limite de caracteres(nome.length=50);
    @Test(expected = RuntimeException.class)
    public void CadastroPfNomeEstourandoLimiteCaracteres() throws Exception {
        //Arranjar
        pf = new ClientePessoaFisica();
        pf.setCli_Cpf("055.186.754-02");
        pf.setNome("BernardoBernardoBernardoBernardoBernardoBernardoooo");
        pf.setSexo("m");
        pf.setCep("54.410-010");
        pf.setLogradouro("Av Bernardo Vieira de Melo");
        pf.setNumeroLogradouro("3074");
        pf.setComplemento("302");
        pf.setBairro("Piedade");
        pf.setCidade("Jaboatão dos Guararapes");
        pf.setEstado("PE");
        pf.setEmail("bps@gmail.com");
        pf.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.cadastrarClientePF(pf);

        //Avaliar
    }

    //Cadastro pf  passando telefone null
    @Test(expected = RuntimeException.class)
    public void CadastroPfTelefoneNull() throws Exception {
        //Arranjar
        pf = new ClientePessoaFisica();
        pf.setCli_Cpf("055.186.754-02");
        pf.setNome("Bernardo");
        pf.setSexo("m");
        pf.setCep("54.410-010");
        pf.setLogradouro("Av Bernardo Vieira de Melo");
        pf.setNumeroLogradouro("3074");
        pf.setComplemento("302");
        pf.setBairro("Piedade");
        pf.setCidade("Jaboatão dos Guararapes");
        pf.setEstado("PE");
        pf.setEmail("bps@gmail.com");
        pf.setTelefone(null);

        //Agir
        negocio.cadastrarClientePF(pf);

        //Avaliar
    }

    //Cadastro pf  passando telefone vazio
    @Test(expected = RuntimeException.class)
    public void CadastroPfTelefoneVazio() throws Exception {
        //Arranjar
        pf = new ClientePessoaFisica();
        pf.setCli_Cpf("055.186.754-02");
        pf.setNome("Bernardo");
        pf.setSexo("m");
        pf.setCep("54.410-010");
        pf.setLogradouro("Av Bernardo Vieira de Melo");
        pf.setNumeroLogradouro("3074");
        pf.setComplemento("302");
        pf.setBairro("Piedade");
        pf.setCidade("Jaboatão dos Guararapes");
        pf.setEstado("PE");
        pf.setEmail("bps@gmail.com");
        pf.setTelefone("");

        //Agir
        negocio.cadastrarClientePF(pf);

        //Avaliar
    }

    //Cadastro pf  passando cep null
    @Test(expected = RuntimeException.class)
    public void CadastroPfCepNull() throws Exception {
        //Arranjar
        pf = new ClientePessoaFisica();
        pf.setCli_Cpf("055.186.754-02");
        pf.setNome("Bernardo");
        pf.setSexo("m");
        pf.setCep(null);
        pf.setLogradouro("Av Bernardo Vieira de Melo");
        pf.setNumeroLogradouro("3074");
        pf.setComplemento("302");
        pf.setBairro("Piedade");
        pf.setCidade("Jaboatão dos Guararapes");
        pf.setEstado("PE");
        pf.setEmail("bps@gmail.com");
        pf.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.cadastrarClientePF(pf);

        //Avaliar
    }

    //Cadastro pf  passando cep com menos caracteres que o necessário (cep.length=10)
    @Test(expected = RuntimeException.class)
    public void CadastroPfCepLengthInvalido() throws Exception {
        //Arranjar
        pf = new ClientePessoaFisica();
        pf.setCli_Cpf("055.186.754-02");
        pf.setNome("Bernardo");
        pf.setSexo("m");
        pf.setCep("54.410-01"); //Cep com 09 caracteres
        pf.setLogradouro("Av Bernardo Vieira de Melo");
        pf.setNumeroLogradouro("3074");
        pf.setComplemento("302");
        pf.setBairro("Piedade");
        pf.setCidade("Jaboatão dos Guararapes");
        pf.setEstado("PE");
        pf.setEmail("bps@gmail.com");
        pf.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.cadastrarClientePF(pf);

        //Avaliar
    }

    //Cadastro pf  passando Logradouro Null
    @Test(expected = RuntimeException.class)
    public void CadastroPfLogradouroNull() throws Exception {
        //Arranjar
        pf = new ClientePessoaFisica();
        pf.setCli_Cpf("055.186.754-02");
        pf.setNome("Bernardo");
        pf.setSexo("m");
        pf.setCep("54.410-010");
        pf.setLogradouro(null); //Logradouro Null
        pf.setNumeroLogradouro("3074");
        pf.setComplemento("302");
        pf.setBairro("Piedade");
        pf.setCidade("Jaboatão dos Guararapes");
        pf.setEstado("PE");
        pf.setEmail("bps@gmail.com");
        pf.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.cadastrarClientePF(pf);

        //Avaliar
    }

    //Cadastro pf  passando logradouro vazio
    @Test(expected = RuntimeException.class)
    public void CadastroPfLogradouroVazio() throws Exception {
        //Arranjar
        pf = new ClientePessoaFisica();
        pf.setCli_Cpf("055.186.754-02");
        pf.setNome("Bernardo");
        pf.setSexo("m");
        pf.setCep("54.410-010");
        pf.setLogradouro("");//Logradouro vazio.
        pf.setNumeroLogradouro("3074");
        pf.setComplemento("302");
        pf.setBairro("Piedade");
        pf.setCidade("Jaboatão dos Guararapes");
        pf.setEstado("PE");
        pf.setEmail("bps@gmail.com");
        pf.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.cadastrarClientePF(pf);

        //Avaliar
    }

    //Cadastro pf  passando logradouro estourando limite de caracteres
    @Test(expected = RuntimeException.class)
    public void CadastroPfLogradouroEstourandoLimiteCaracteres() throws Exception {
        //Arranjar
        pf = new ClientePessoaFisica();
        pf.setCli_Cpf("055.186.754-02");
        pf.setNome("Bernardo");
        pf.setSexo("m");
        pf.setCep("54.410-010");
        pf.setLogradouro("PIEDADEPIEDADEPIEDADEPIEDADEPIEDADEPIEDADEPIEDADEPIEDADEEEEEEE");//Logradouro com 62 caracteres (Máx permitido -> 50)
        pf.setNumeroLogradouro("3074");
        pf.setComplemento("302");
        pf.setBairro("Piedade");
        pf.setCidade("Jaboatão dos Guararapes");
        pf.setEstado("PE");
        pf.setEmail("bps@gmail.com");
        pf.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.cadastrarClientePF(pf);

        //Avaliar
    }

    //Cadastro pf  passando numero do logradouro null
    @Test(expected = RuntimeException.class)
    public void CadastroPfNumeroLogradouroNull() throws Exception {
        //Arranjar
        pf = new ClientePessoaFisica();
        pf.setCli_Cpf("055.186.754-02");
        pf.setNome("Bernardo");
        pf.setSexo("m");
        pf.setCep("54.410-010");
        pf.setLogradouro("Av Bernardo Vieira de Melo");
        pf.setNumeroLogradouro(null);//numeroLogradouro null
        pf.setComplemento("302");
        pf.setBairro("Piedade");
        pf.setCidade("Jaboatão dos Guararapes");
        pf.setEstado("PE");
        pf.setEmail("bps@gmail.com");
        pf.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.cadastrarClientePF(pf);

        //Avaliar
    }

    //Cadastro pf  passando numeroLogradouro vazio
    @Test(expected = RuntimeException.class)
    public void CadastroPfNumeroLogradouroVazio() throws Exception {
        //Arranjar
        pf = new ClientePessoaFisica();
        pf.setCli_Cpf("055.186.754-02");
        pf.setNome("Bernardo");
        pf.setSexo("m");
        pf.setCep("54.410-010");
        pf.setLogradouro("Av Bernardo Vieira de Melo");
        pf.setNumeroLogradouro("");//numeroLogradouro vazio
        pf.setComplemento("302");
        pf.setBairro("Piedade");
        pf.setCidade("Jaboatão dos Guararapes");
        pf.setEstado("PE");
        pf.setEmail("bps@gmail.com");
        pf.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.cadastrarClientePF(pf);

        //Avaliar
    }

    //Cadastro pf  passando numeroLogradouro estourando limite de caracteres
    @Test(expected = RuntimeException.class)
    public void CadastroPfNumeroLogradouroEstourandoLimiteCaracteres() throws Exception {
        //Arranjar
        pf = new ClientePessoaFisica();
        pf.setCli_Cpf("055.186.754-02");
        pf.setNome("Bernardo");
        pf.setSexo("m");
        pf.setCep("54.410-010");
        pf.setLogradouro("Av Bernardo Vieira de Melo");
        pf.setNumeroLogradouro("123456789012345678901");//numeroLogradouro com 21 caracteres (máx permitido ->20)
        pf.setComplemento("302");
        pf.setBairro("Piedade");
        pf.setCidade("Jaboatão dos Guararapes");
        pf.setEstado("PE");
        pf.setEmail("bps@gmail.com");
        pf.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.cadastrarClientePF(pf);

        //Avaliar
    }

    //Cadastro pf  passando complemento null
    @Test(expected = RuntimeException.class)
    public void CadastroPfComplementoNull() throws Exception {
        //Arranjar
        pf = new ClientePessoaFisica();
        pf.setCli_Cpf("055.186.754-02");
        pf.setNome("Bernardo");
        pf.setSexo("m");
        pf.setCep("54.410-010");
        pf.setLogradouro("Av Bernardo Vieira de Melo");
        pf.setNumeroLogradouro("300");
        pf.setComplemento(null);// Complemento Null
        pf.setBairro("Piedade");
        pf.setCidade("Jaboatão dos Guararapes");
        pf.setEstado("PE");
        pf.setEmail("bps@gmail.com");
        pf.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.cadastrarClientePF(pf);

        //Avaliar
    }

    //Cadastro pf  passando complemento null
    @Test(expected = RuntimeException.class)
    public void CadastroPfComplementoEstourandoLimiteCaracteres() throws Exception {
        //Arranjar
        pf = new ClientePessoaFisica();
        pf.setCli_Cpf("055.186.754-02");
        pf.setNome("Bernardo");
        pf.setSexo("m");
        pf.setCep("54.410-010");
        pf.setLogradouro("Av Bernardo Vieira de Melo");
        pf.setNumeroLogradouro("300");
        pf.setComplemento("123456789012345678901");// Complemento com 21 caracteres (máx permitido ->20)
        pf.setBairro("Piedade");
        pf.setCidade("Jaboatão dos Guararapes");
        pf.setEstado("PE");
        pf.setEmail("bps@gmail.com");
        pf.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.cadastrarClientePF(pf);

        //Avaliar
    }

    //Cadastro pf  passando bairro null
    @Test(expected = RuntimeException.class)
    public void CadastroPfBairroNull() throws Exception {
        //Arranjar
        pf = new ClientePessoaFisica();
        pf.setCli_Cpf("055.186.754-02");
        pf.setNome("Bernardo");
        pf.setSexo("m");
        pf.setCep("54.410-010");
        pf.setLogradouro("Av Bernardo Vieira de Melo");
        pf.setNumeroLogradouro("300");
        pf.setComplemento("300");
        pf.setBairro(null);//Bairro Null
        pf.setCidade("Jaboatão dos Guararapes");
        pf.setEstado("PE");
        pf.setEmail("bps@gmail.com");
        pf.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.cadastrarClientePF(pf);

        //Avaliar
    }

    //Cadastro pf  passando bairro vazio
    @Test(expected = RuntimeException.class)
    public void CadastroPfBairroVazio() throws Exception {
        //Arranjar
        pf = new ClientePessoaFisica();
        pf.setCli_Cpf("055.186.754-02");
        pf.setNome("Bernardo");
        pf.setSexo("m");
        pf.setCep("54.410-010");
        pf.setLogradouro("Av Bernardo Vieira de Melo");
        pf.setNumeroLogradouro("300");
        pf.setComplemento("300");
        pf.setBairro("");//Bairro vazio
        pf.setCidade("Jaboatão dos Guararapes");
        pf.setEstado("PE");
        pf.setEmail("bps@gmail.com");
        pf.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.cadastrarClientePF(pf);

        //Avaliar
    }

    //Cadastro pf  passando bairro estourando limite de caracteres
    @Test(expected = RuntimeException.class)
    public void CadastroPfBairroEstourandoLimiteCaracteres() throws Exception {
        //Arranjar
        pf = new ClientePessoaFisica();
        pf.setCli_Cpf("055.186.754-02");
        pf.setNome("Bernardo");
        pf.setSexo("m");
        pf.setCep("54.410-010");
        pf.setLogradouro("Av Bernardo Vieira de Melo");
        pf.setNumeroLogradouro("300");
        pf.setComplemento("366");
        pf.setBairro("PiedadePiedadePiedade");// Bairro com 21 caracteres (máx permitido ->20)
        pf.setCidade("Jaboatão dos Guararapes");
        pf.setEstado("PE");
        pf.setEmail("bps@gmail.com");
        pf.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.cadastrarClientePF(pf);

        //Avaliar
    }

    //Cadastro pf  passando cidade null
    @Test(expected = RuntimeException.class)
    public void CadastroPfCidadeNull() throws Exception {
        //Arranjar
        pf = new ClientePessoaFisica();
        pf.setCli_Cpf("055.186.754-02");
        pf.setNome("Bernardo");
        pf.setSexo("m");
        pf.setCep("54.410-010");
        pf.setLogradouro("Av Bernardo Vieira de Melo");
        pf.setNumeroLogradouro("300");
        pf.setComplemento("300");
        pf.setBairro("Piedade");
        pf.setCidade(null);//Cidade Null
        pf.setEstado("PE");
        pf.setEmail("bps@gmail.com");
        pf.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.cadastrarClientePF(pf);

        //Avaliar
    }

    //Cadastro pf  passando cidade vazio
    @Test(expected = RuntimeException.class)
    public void CadastroPfCidadeVazio() throws Exception {
        //Arranjar
        pf = new ClientePessoaFisica();
        pf.setCli_Cpf("055.186.754-02");
        pf.setNome("Bernardo");
        pf.setSexo("m");
        pf.setCep("54.410-010");
        pf.setLogradouro("Av Bernardo Vieira de Melo");
        pf.setNumeroLogradouro("300");
        pf.setComplemento("300");
        pf.setBairro("Piedade");
        pf.setCidade("");//Cidade Vazio
        pf.setEstado("PE");
        pf.setEmail("bps@gmail.com");
        pf.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.cadastrarClientePF(pf);

        //Avaliar
    }

    //Cadastro pf  passando cidade estourando limite caracteres
    @Test(expected = RuntimeException.class)
    public void CadastroPfCidadeEstourandoLimiteCaracteres() throws Exception {
        //Arranjar
        pf = new ClientePessoaFisica();
        pf.setCli_Cpf("055.186.754-02");
        pf.setNome("Bernardo");
        pf.setSexo("m");
        pf.setCep("54.410-010");
        pf.setLogradouro("Av Bernardo Vieira de Melo");
        pf.setNumeroLogradouro("300");
        pf.setComplemento("300");
        pf.setBairro("Piedade");
        pf.setCidade("123456789012345678901234567890123456789012345678901234567890");//Cidade com 60 caracteres(máx permitido ->50)
        pf.setEstado("PE");
        pf.setEmail("bps@gmail.com");
        pf.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.cadastrarClientePF(pf);

        //Avaliar
    }

    //Cadastro pf  passando estado null
    @Test(expected = RuntimeException.class)
    public void CadastroPfEstadoNull() throws Exception {
        //Arranjar
        pf = new ClientePessoaFisica();
        pf.setCli_Cpf("055.186.754-02");
        pf.setNome("Bernardo");
        pf.setSexo("m");
        pf.setCep("54.410-010");
        pf.setLogradouro("Av Bernardo Vieira de Melo");
        pf.setNumeroLogradouro("300");
        pf.setComplemento("300");
        pf.setBairro("Piedade");
        pf.setCidade("Recife");
        pf.setEstado(null);//Estado null
        pf.setEmail("bps@gmail.com");
        pf.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.cadastrarClientePF(pf);

        //Avaliar
    }

    //Cadastro pf  passando estado vazio
    @Test(expected = RuntimeException.class)
    public void CadastroPfEstadoVazio() throws Exception {
        //Arranjar
        pf = new ClientePessoaFisica();
        pf.setCli_Cpf("055.186.754-02");
        pf.setNome("Bernardo");
        pf.setSexo("m");
        pf.setCep("54.410-010");
        pf.setLogradouro("Av Bernardo Vieira de Melo");
        pf.setNumeroLogradouro("300");
        pf.setComplemento("300");
        pf.setBairro("Piedade");
        pf.setCidade("Recife");
        pf.setEstado("");//Estado vazio
        pf.setEmail("bps@gmail.com");
        pf.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.cadastrarClientePF(pf);

        //Avaliar
    }

    //Cadastro pf  passando estado estourando limite de caracteres
    @Test(expected = RuntimeException.class)
    public void CadastroPfEstadoEstourandoLimiteCaracteres() throws Exception {
        //Arranjar
        pf = new ClientePessoaFisica();
        pf.setCli_Cpf("055.186.754-02");
        pf.setNome("Bernardo");
        pf.setSexo("m");
        pf.setCep("54.410-010");
        pf.setLogradouro("Av Bernardo Vieira de Melo");
        pf.setNumeroLogradouro("300");
        pf.setComplemento("300");
        pf.setBairro("Piedade");
        pf.setCidade("Recife");
        pf.setEstado("Pernambuco");//Estado com 10 caracteres (máx permitido->10)
        pf.setEmail("bps@gmail.com");
        pf.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.cadastrarClientePF(pf);

        //Avaliar
    }

    //Cadastro pf  passando email null
    @Test(expected = RuntimeException.class)
    public void CadastroPfEmailNull() throws Exception {
        //Arranjar
        pf = new ClientePessoaFisica();
        pf.setCli_Cpf("055.186.754-02");
        pf.setNome("Bernardo");
        pf.setSexo("m");
        pf.setCep("54.410-010");
        pf.setLogradouro("Av Bernardo Vieira de Melo");
        pf.setNumeroLogradouro("300");
        pf.setComplemento("300");
        pf.setBairro("Piedade");
        pf.setCidade("Recife");
        pf.setEstado("PE");
        pf.setEmail(null);//Email null
        pf.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.cadastrarClientePF(pf);

        //Avaliar
    }

    //Cadastro pf  passando email vazio
    @Test(expected = RuntimeException.class)
    public void CadastroPfEmailVazio() throws Exception {
        //Arranjar
        pf = new ClientePessoaFisica();
        pf.setCli_Cpf("055.186.754-02");
        pf.setNome("Bernardo");
        pf.setSexo("m");
        pf.setCep("54.410-010");
        pf.setLogradouro("Av Bernardo Vieira de Melo");
        pf.setNumeroLogradouro("300");
        pf.setComplemento("300");
        pf.setBairro("Piedade");
        pf.setCidade("Recife");
        pf.setEstado("PE");
        pf.setEmail("");//Email vazio
        pf.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.cadastrarClientePF(pf);

        //Avaliar
    }

    //Cadastro pf  passando email vazio
    @Test(expected = RuntimeException.class)
    public void CadastroPfEmailEstourandoLimiteCaracteres() throws Exception {
        //Arranjar
        pf = new ClientePessoaFisica();
        pf.setCli_Cpf("055.186.754-02");
        pf.setNome("Bernardo");
        pf.setSexo("m");
        pf.setCep("54.410-010");
        pf.setLogradouro("Av Bernardo Vieira de Melo");
        pf.setNumeroLogradouro("300");
        pf.setComplemento("300");
        pf.setBairro("Piedade");
        pf.setCidade("Recife");
        pf.setEstado("PE");
        pf.setEmail("bernardoppbernardoppbernardoppbernardoppbernardoppp");//Email com 51 caracteres(máx permitido->50)
        pf.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.cadastrarClientePF(pf);

        //Avaliar
    }

    //Cadastro pf  passando sexo null
    @Test(expected = RuntimeException.class)
    public void CadastroPfSexoNull() throws Exception {
        //Arranjar
        pf = new ClientePessoaFisica();
        pf.setCli_Cpf("055.186.754-02");
        pf.setNome("Bernardo");
        pf.setSexo(null);//sexo null
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

        //Avaliar
    }

    //Cadastro pf  passando sexo vazio
    @Test(expected = RuntimeException.class)
    public void CadastroPfSexoVazio() throws Exception {
        //Arranjar
        pf = new ClientePessoaFisica();
        pf.setCli_Cpf("055.186.754-02");
        pf.setNome("Bernardo");
        pf.setSexo("");//sexo vazio
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

        //Avaliar
    }

    //Cadastro pf  passando sexo  com tamanho de campo inválido (campoo deve ter apenas 1 caractere)
    @Test(expected = RuntimeException.class)
    public void CadastroPfSexoEstourandoLimiteCaracteres() throws Exception {
        //Arranjar
        pf = new ClientePessoaFisica();
        pf.setCli_Cpf("055.186.754-02");
        pf.setNome("Bernardo");
        pf.setSexo("mm");//sexo com 2 caracteres (máx permitido ->1)
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

        //Avaliar
    }

   

    /*Fim do módulo de testes unitários INSERT PF 
     Início do módulo de testes unitários INSERT PJ*/
    //Cadastro PJ com objeto null
    @Test(expected = RuntimeException.class)
    public void CadastroPJObjetoNulo() throws Exception {

        //Arranjar
        pj = null;
        //Agir
        negocio.cadastrarClientePJ(pj);

        //Avaliar
    }

    //Cadastro PJ com cnpj null 
    @Test(expected = RuntimeException.class)
    public void CadastroPjCnpjNull() throws Exception {
        //Arranjar
        pj = new ClientePessoaJuridica();
        pj.setCli_Cnpj(null);
        pj.setRazaoSocial("Teste");
        pj.setCep("54.410-010");
        pj.setLogradouro("Av Bernardo Vieira de Melo");
        pj.setNumeroLogradouro("3074");
        pj.setComplemento("302");
        pj.setBairro("Piedade");
        pj.setCidade("Jaboatão dos Guararapes");
        pj.setEstado("PE");
        pj.setEmail("bps@gmail.com");
        pj.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.cadastrarClientePJ(pj);

        //Avaliar
    }

    //Cadastro pj com cnpj estourando limite de caracteres. Esse test case tambem vale pro cenário de cnpj com tamanho inferior ao tamanho necessário(cnpj.length =18).
    @Test(expected = RuntimeException.class)
    public void CadastroPjCnpjLengthInvalido() throws Exception {
        //Arranjar
        pj = new ClientePessoaJuridica();
        pj.setCli_Cnpj("XX.XXX.XXX/YYYY-ZZZ");// CNPJ com 19 caracteres (máx permitido-> 18)
        pj.setRazaoSocial("Teste");
        pj.setCep("54.410-010");
        pj.setLogradouro("Av Bernardo Vieira de Melo");
        pj.setNumeroLogradouro("3074");
        pj.setComplemento("302");
        pj.setBairro("Piedade");
        pj.setCidade("Jaboatão dos Guararapes");
        pj.setEstado("PE");
        pj.setEmail("bps@gmail.com");
        pj.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.cadastrarClientePJ(pj);

        //Avaliar
    }

    //Cadastro pj com Razao social null;
    @Test(expected = RuntimeException.class)
    public void CadastroPjRazaoSocialNull() throws Exception {
        //Arranjar
        pj = new ClientePessoaJuridica();
        pj.setCli_Cnpj("XX.XXX.XXX/YYYY-ZZ");
        pj.setRazaoSocial(null);// Razão social null
        pj.setCep("54.410-010");
        pj.setLogradouro("Av Bernardo Vieira de Melo");
        pj.setNumeroLogradouro("3074");
        pj.setComplemento("302");
        pj.setBairro("Piedade");
        pj.setCidade("Jaboatão dos Guararapes");
        pj.setEstado("PE");
        pj.setEmail("bps@gmail.com");
        pj.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.cadastrarClientePJ(pj);

        //Avaliar
    }

    //Cadastro pj com Razão social vazio ;
    @Test(expected = RuntimeException.class)
    public void CadastroPjRazaoSocialVazio() throws Exception {
        //Arranjar
        pj = new ClientePessoaJuridica();
        pj.setCli_Cnpj("XX.XXX.XXX/YYYY-ZZ");
        pj.setRazaoSocial("");// Razão social vazio
        pj.setCep("54.410-010");
        pj.setLogradouro("Av Bernardo Vieira de Melo");
        pj.setNumeroLogradouro("3074");
        pj.setComplemento("302");
        pj.setBairro("Piedade");
        pj.setCidade("Jaboatão dos Guararapes");
        pj.setEstado("PE");
        pj.setEmail("bps@gmail.com");
        pj.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.cadastrarClientePJ(pj);

        //Avaliar
    }

    //Cadastro pj com razao social estourando limite de caracteres(razaoSocial.length=60);
    @Test(expected = RuntimeException.class)
    public void CadastroPjRazaoSocialEstourandoLimiteCaracteres() throws Exception {
        //Arranjar
        pj = new ClientePessoaJuridica();
        pj.setCli_Cnpj("XX.XXX.XXX/YYYY-ZZ");
        pj.setRazaoSocial("1234567890123456789012345678901234567890123456789012345678901");// Razão social com 61 caracteres(máx permitido ->60)
        pj.setCep("54.410-010");
        pj.setLogradouro("Av Bernardo Vieira de Melo");
        pj.setNumeroLogradouro("3074");
        pj.setComplemento("302");
        pj.setBairro("Piedade");
        pj.setCidade("Jaboatão dos Guararapes");
        pj.setEstado("PE");
        pj.setEmail("bps@gmail.com");
        pj.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.cadastrarClientePJ(pj);

        //Avaliar
    }

    //Cadastro pj  passando telefone null
    @Test(expected = RuntimeException.class)
    public void CadastroPjTelefoneNull() throws Exception {
        //Arranjar
        pj = new ClientePessoaJuridica();
        pj.setCli_Cnpj("XX.XXX.XXX/YYYY-ZZ");
        pj.setRazaoSocial("Teste");
        pj.setCep("54.410-010");
        pj.setLogradouro("Av Bernardo Vieira de Melo");
        pj.setNumeroLogradouro("3074");
        pj.setComplemento("302");
        pj.setBairro("Piedade");
        pj.setCidade("Jaboatão dos Guararapes");
        pj.setEstado("PE");
        pj.setEmail("bps@gmail.com");
        pj.setTelefone(null);//Telefone null

        //Agir
        negocio.cadastrarClientePJ(pj);

        //Avaliar
    }

    //Cadastro pj  passando telefone vazio
    @Test(expected = RuntimeException.class)
    public void CadastroPjTelefoneVazio() throws Exception {
        //Arranjar
        pj = new ClientePessoaJuridica();
        pj.setCli_Cnpj("XX.XXX.XXX/YYYY-ZZ");
        pj.setRazaoSocial("Teste");
        pj.setCep("54.410-010");
        pj.setLogradouro("Av Bernardo Vieira de Melo");
        pj.setNumeroLogradouro("3074");
        pj.setComplemento("302");
        pj.setBairro("Piedade");
        pj.setCidade("Jaboatão dos Guararapes");
        pj.setEstado("PE");
        pj.setEmail("bps@gmail.com");
        pj.setTelefone("");//Telefone vazio

        //Agir
        negocio.cadastrarClientePJ(pj);

        //Avaliar
    }

    //Cadastro pj  passando cep null
    @Test(expected = RuntimeException.class)
    public void CadastroPjCepNull() throws Exception {
        //Arranjar
        pj = new ClientePessoaJuridica();
        pj.setCli_Cnpj("XX.XXX.XXX/YYYY-ZZ");
        pj.setRazaoSocial("Teste");
        pj.setCep(null);//CEP null
        pj.setLogradouro("Av Bernardo Vieira de Melo");
        pj.setNumeroLogradouro("3074");
        pj.setComplemento("302");
        pj.setBairro("Piedade");
        pj.setCidade("Jaboatão dos Guararapes");
        pj.setEstado("PE");
        pj.setEmail("bps@gmail.com");
        pj.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.cadastrarClientePJ(pj);

        //Avaliar
    }

    //Cadastro pj  passando cep com menos caracteres que o necessário (cep.length=10)
    @Test(expected = RuntimeException.class)
    public void CadastroPjCepLengthInvalido() throws Exception {
        //Arranjar
        pj = new ClientePessoaJuridica();
        pj.setCli_Cnpj("XX.XXX.XXX/YYYY-ZZ");
        pj.setRazaoSocial("Teste");
        pj.setCep("123");//CEP com 3 caracteres (campo deve conter 10 caracteres)
        pj.setLogradouro("Av Bernardo Vieira de Melo");
        pj.setNumeroLogradouro("3074");
        pj.setComplemento("302");
        pj.setBairro("Piedade");
        pj.setCidade("Jaboatão dos Guararapes");
        pj.setEstado("PE");
        pj.setEmail("bps@gmail.com");
        pj.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.cadastrarClientePJ(pj);

        //Avaliar
    }

    //Cadastro pj  passando Logradouro Null
    @Test(expected = RuntimeException.class)
    public void CadastroPjLogradouroNull() throws Exception {
        //Arranjar
        pj = new ClientePessoaJuridica();
        pj.setCli_Cnpj("XX.XXX.XXX/YYYY-ZZ");
        pj.setRazaoSocial("Teste");
        pj.setCep("54.410-010");
        pj.setLogradouro(null);//Logradouro null
        pj.setNumeroLogradouro("3074");
        pj.setComplemento("302");
        pj.setBairro("Piedade");
        pj.setCidade("Jaboatão dos Guararapes");
        pj.setEstado("PE");
        pj.setEmail("bps@gmail.com");
        pj.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.cadastrarClientePJ(pj);

        //Avaliar
    }

    //Cadastro pj  passando logradouro vazio
    @Test(expected = RuntimeException.class)
    public void CadastroPjLogradouroVazio() throws Exception {
        //Arranjar
        pj = new ClientePessoaJuridica();
        pj.setCli_Cnpj("XX.XXX.XXX/YYYY-ZZ");
        pj.setRazaoSocial("Teste");
        pj.setCep("54.410-010");
        pj.setLogradouro("");//Logradouro vazio
        pj.setNumeroLogradouro("3074");
        pj.setComplemento("302");
        pj.setBairro("Piedade");
        pj.setCidade("Jaboatão dos Guararapes");
        pj.setEstado("PE");
        pj.setEmail("bps@gmail.com");
        pj.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.cadastrarClientePJ(pj);

        //Avaliar
    }

    //Cadastro pj  passando logradouro estourando limite de caracteres
    @Test(expected = RuntimeException.class)
    public void CadastroPjLogradouroEstourandoLimiteCaracteres() throws Exception {
        //Arranjar
        pj = new ClientePessoaJuridica();
        pj.setCli_Cnpj("XX.XXX.XXX/YYYY-ZZ");
        pj.setRazaoSocial("Teste");
        pj.setCep("54.410-010");
        pj.setLogradouro("1234567890123456789012345678901234567890123456789012345678901");//Logradouro com 61 caracteres (máx ->60 )
        pj.setNumeroLogradouro("3074");
        pj.setComplemento("302");
        pj.setBairro("Piedade");
        pj.setCidade("Jaboatão dos Guararapes");
        pj.setEstado("PE");
        pj.setEmail("bps@gmail.com");
        pj.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.cadastrarClientePJ(pj);

        //Avaliar
    }

    //Cadastro pj  passando numero do logradouro null
    @Test(expected = RuntimeException.class)
    public void CadastroPjNumeroLogradouroNull() throws Exception {
        //Arranjar
        pj = new ClientePessoaJuridica();
        pj.setCli_Cnpj("XX.XXX.XXX/YYYY-ZZ");
        pj.setRazaoSocial("Teste");
        pj.setCep("54.410-010");
        pj.setLogradouro("Av Bernardo Vieira de Melo");
        pj.setNumeroLogradouro(null);//NumeroLogradouro null
        pj.setComplemento("302");
        pj.setBairro("Piedade");
        pj.setCidade("Jaboatão dos Guararapes");
        pj.setEstado("PE");
        pj.setEmail("bps@gmail.com");
        pj.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.cadastrarClientePJ(pj);

        //Avaliar
    }

    //Cadastro pj  passando numeroLogradouro vazio
    @Test(expected = RuntimeException.class)
    public void CadastroPjNumeroLogradouroVazio() throws Exception {
        //Arranjar
        pj = new ClientePessoaJuridica();
        pj.setCli_Cnpj("XX.XXX.XXX/YYYY-ZZ");
        pj.setRazaoSocial("Teste");
        pj.setCep("54.410-010");
        pj.setLogradouro("Av Bernardo Vieira de Melo");
        pj.setNumeroLogradouro("");//NumeroLogradouro vazio
        pj.setComplemento("302");
        pj.setBairro("Piedade");
        pj.setCidade("Jaboatão dos Guararapes");
        pj.setEstado("PE");
        pj.setEmail("bps@gmail.com");
        pj.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.cadastrarClientePJ(pj);

        //Avaliar
    }

    //Cadastro pj  passando numeroLogradouro estourando limite de caracteres
    @Test(expected = RuntimeException.class)
    public void CadastroPjNumeroLogradouroEstourandoLimiteCaracteres() throws Exception {
        //Arranjar
        pj = new ClientePessoaJuridica();
        pj.setCli_Cnpj("XX.XXX.XXX/YYYY-ZZ");
        pj.setRazaoSocial("Teste");
        pj.setCep("54.410-010");
        pj.setLogradouro("Av Bernardo Vieira de Melo");
        pj.setNumeroLogradouro("123456789012345678901");//NumeroLogradouro com 21 caracteres (máx permitido->20)
        pj.setComplemento("302");
        pj.setBairro("Piedade");
        pj.setCidade("Jaboatão dos Guararapes");
        pj.setEstado("PE");
        pj.setEmail("bps@gmail.com");
        pj.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.cadastrarClientePJ(pj);

        //Avaliar
    }

    //Cadastro pj  passando complemento null
    @Test(expected = RuntimeException.class)
    public void CadastroPjComplementoNull() throws Exception {
        pj = new ClientePessoaJuridica();
        pj.setCli_Cnpj("XX.XXX.XXX/YYYY-ZZ");
        pj.setRazaoSocial("Teste");
        pj.setCep("54.410-010");
        pj.setLogradouro("Av Bernardo Vieira de Melo");
        pj.setNumeroLogradouro("300");
        pj.setComplemento(null);//Complemento null
        pj.setBairro("Piedade");
        pj.setCidade("Jaboatão dos Guararapes");
        pj.setEstado("PE");
        pj.setEmail("bps@gmail.com");
        pj.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.cadastrarClientePJ(pj);

        //Avaliar
    }

    //Cadastro pj  passando complemento estourando limite de caracteres
    @Test(expected = RuntimeException.class)
    public void CadastroPjComplementoEstourandoLimiteCaracteres() throws Exception {
        pj = new ClientePessoaJuridica();
        pj.setCli_Cnpj("XX.XXX.XXX/YYYY-ZZ");
        pj.setRazaoSocial("Teste");
        pj.setCep("54.410-010");
        pj.setLogradouro("Av Bernardo Vieira de Melo");
        pj.setNumeroLogradouro("300");
        pj.setComplemento("1234567890123456789011");//Complemento com 21 caracteres (max permitido -> 20)
        pj.setBairro("Piedade");
        pj.setCidade("Jaboatão dos Guararapes");
        pj.setEstado("PE");
        pj.setEmail("bps@gmail.com");
        pj.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.cadastrarClientePJ(pj);

        //Avaliar
    }

    //Cadastro pj  passando bairro null
    @Test(expected = RuntimeException.class)
    public void CadastroPjBairroNull() throws Exception {
        pj = new ClientePessoaJuridica();
        pj.setCli_Cnpj("XX.XXX.XXX/YYYY-ZZ");
        pj.setRazaoSocial("Teste");
        pj.setCep("54.410-010");
        pj.setLogradouro("Av Bernardo Vieira de Melo");
        pj.setNumeroLogradouro("300");
        pj.setComplemento("300");
        pj.setBairro(null);//Bairro null
        pj.setCidade("Jaboatão dos Guararapes");
        pj.setEstado("PE");
        pj.setEmail("bps@gmail.com");
        pj.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.cadastrarClientePJ(pj);

        //Avaliar
    }

    //Cadastro pj  passando bairro vazio
    @Test(expected = RuntimeException.class)
    public void CadastroPjBairroVazio() throws Exception {
        pj = new ClientePessoaJuridica();
        pj.setCli_Cnpj("XX.XXX.XXX/YYYY-ZZ");
        pj.setRazaoSocial("Teste");
        pj.setCep("54.410-010");
        pj.setLogradouro("Av Bernardo Vieira de Melo");
        pj.setNumeroLogradouro("300");
        pj.setComplemento("300");
        pj.setBairro("");//Bairro vazio
        pj.setCidade("Jaboatão dos Guararapes");
        pj.setEstado("PE");
        pj.setEmail("bps@gmail.com");
        pj.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.cadastrarClientePJ(pj);

        //Avaliar
    }

    //Cadastro pj  passando bairro estourando limite de caracteres
    @Test(expected = RuntimeException.class)
    public void CadastroPjBairroEstourandoLimiteCaracteres() throws Exception {
        pj = new ClientePessoaJuridica();
        pj.setCli_Cnpj("XX.XXX.XXX/YYYY-ZZ");
        pj.setRazaoSocial("Teste");
        pj.setCep("54.410-010");
        pj.setLogradouro("Av Bernardo Vieira de Melo");
        pj.setNumeroLogradouro("300");
        pj.setComplemento("300");
        pj.setBairro("123456789012345678901");//Bairro com 21 caracteres (max permitido -> 20)
        pj.setCidade("Jaboatão dos Guararapes");
        pj.setEstado("PE");
        pj.setEmail("bps@gmail.com");
        pj.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.cadastrarClientePJ(pj);

        //Avaliar
    }

    //Cadastro pj  passando cidade null
    @Test(expected = RuntimeException.class)
    public void CadastroPjCidadeNull() throws Exception {
        pj = new ClientePessoaJuridica();
        pj.setCli_Cnpj("XX.XXX.XXX/YYYY-ZZ");
        pj.setRazaoSocial("Teste");
        pj.setCep("54.410-010");
        pj.setLogradouro("Av Bernardo Vieira de Melo");
        pj.setNumeroLogradouro("300");
        pj.setComplemento("300");
        pj.setBairro("Piedade");
        pj.setCidade(null);//Cidade null
        pj.setEstado("PE");
        pj.setEmail("bps@gmail.com");
        pj.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.cadastrarClientePJ(pj);

        //Avaliar
    }

    //Cadastro pj  passando cidade vazio
    @Test(expected = RuntimeException.class)
    public void CadastroPjCidadeVazio() throws Exception {
        pj = new ClientePessoaJuridica();
        pj.setCli_Cnpj("XX.XXX.XXX/YYYY-ZZ");
        pj.setRazaoSocial("Teste");
        pj.setCep("54.410-010");
        pj.setLogradouro("Av Bernardo Vieira de Melo");
        pj.setNumeroLogradouro("300");
        pj.setComplemento("300");
        pj.setBairro("Piedade");
        pj.setCidade("");//Cidade vazio
        pj.setEstado("PE");
        pj.setEmail("bps@gmail.com");
        pj.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.cadastrarClientePJ(pj);

        //Avaliar
    }

    //Cadastro pj  passando cidade estourando limite caracteres
    @Test(expected = RuntimeException.class)
    public void CadastroPjCidadeEstourandoLimiteCaracteres() throws Exception {
        pj = new ClientePessoaJuridica();
        pj.setCli_Cnpj("XX.XXX.XXX/YYYY-ZZ");
        pj.setRazaoSocial("Teste");
        pj.setCep("54.410-010");
        pj.setLogradouro("Av Bernardo Vieira de Melo");
        pj.setNumeroLogradouro("300");
        pj.setComplemento("300");
        pj.setBairro("Piedade");
        pj.setCidade("12345678901234567890112345678901234567890112345678901234567890");//Cidade com 62 caracteres (max permitido-> 50)
        pj.setEstado("PE");
        pj.setEmail("bps@gmail.com");
        pj.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.cadastrarClientePJ(pj);

        //Avaliar
    }

    //Cadastro pj  passando estado null
    @Test(expected = RuntimeException.class)
    public void CadastroPjEstadoNull() throws Exception {
        pj = new ClientePessoaJuridica();
        pj.setCli_Cnpj("XX.XXX.XXX/YYYY-ZZ");
        pj.setRazaoSocial("Teste");
        pj.setCep("54.410-010");
        pj.setLogradouro("Av Bernardo Vieira de Melo");
        pj.setNumeroLogradouro("300");
        pj.setComplemento("300");
        pj.setBairro("Piedade");
        pj.setCidade("Recife");
        pj.setEstado(null);//Estado null
        pj.setEmail("bps@gmail.com");
        pj.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.cadastrarClientePJ(pj);

        //Avaliar
    }

    //Cadastro pj  passando estado vazio
    @Test(expected = RuntimeException.class)
    public void CadastroPjEstadoVazio() throws Exception {
        pj = new ClientePessoaJuridica();
        pj.setCli_Cnpj("XX.XXX.XXX/YYYY-ZZ");
        pj.setRazaoSocial("Teste");
        pj.setCep("54.410-010");
        pj.setLogradouro("Av Bernardo Vieira de Melo");
        pj.setNumeroLogradouro("300");
        pj.setComplemento("300");
        pj.setBairro("Piedade");
        pj.setCidade("Recife");
        pj.setEstado("");//Estado vazio
        pj.setEmail("bps@gmail.com");
        pj.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.cadastrarClientePJ(pj);

        //Avaliar
    }

    //Cadastro pj  passando estado estourando limite de caracteres
    @Test(expected = RuntimeException.class)
    public void CadastroPjEstadoEstourandoLimiteCaracteres() throws Exception {
        pj = new ClientePessoaJuridica();
        pj.setCli_Cnpj("XX.XXX.XXX/YYYY-ZZ");
        pj.setRazaoSocial("Teste");
        pj.setCep("54.410-010");
        pj.setLogradouro("Av Bernardo Vieira de Melo");
        pj.setNumeroLogradouro("300");
        pj.setComplemento("300");
        pj.setBairro("Piedade");
        pj.setCidade("Recife");
        pj.setEstado("PEE");//Estado com 3 caracteres (max permitido -> 2)
        pj.setEmail("bps@gmail.com");
        pj.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.cadastrarClientePJ(pj);

        //Avaliar
    }

    //Cadastro pj  passando email null
    @Test(expected = RuntimeException.class)
    public void CadastroPjEmailNull() throws Exception {
        pj = new ClientePessoaJuridica();
        pj.setCli_Cnpj("XX.XXX.XXX/YYYY-ZZ");
        pj.setRazaoSocial("Teste");
        pj.setCep("54.410-010");
        pj.setLogradouro("Av Bernardo Vieira de Melo");
        pj.setNumeroLogradouro("300");
        pj.setComplemento("300");
        pj.setBairro("Piedade");
        pj.setCidade("Recife");
        pj.setEstado("PE");
        pj.setEmail(null);//Email null
        pj.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.cadastrarClientePJ(pj);

        //Avaliar
    }

    //Cadastro pj  passando email vazio
    @Test(expected = RuntimeException.class)
    public void CadastroPjEmailVazio() throws Exception {
        pj = new ClientePessoaJuridica();
        pj.setCli_Cnpj("XX.XXX.XXX/YYYY-ZZ");
        pj.setRazaoSocial("Teste");
        pj.setCep("54.410-010");
        pj.setLogradouro("Av Bernardo Vieira de Melo");
        pj.setNumeroLogradouro("300");
        pj.setComplemento("300");
        pj.setBairro("Piedade");
        pj.setCidade("Recife");
        pj.setEstado("PE");
        pj.setEmail("");//Email vazio
        pj.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.cadastrarClientePJ(pj);

        //Avaliar
    }

    //Cadastro pj  passando email estourando limite de caracteres
    @Test(expected = RuntimeException.class)
    public void CadastroPjEmailEstourandoLimiteCaracteres() throws Exception {
        pj = new ClientePessoaJuridica();
        pj.setCli_Cnpj("XX.XXX.XXX/YYYY-ZZ");
        pj.setRazaoSocial("Teste");
        pj.setCep("54.410-010");
        pj.setLogradouro("Av Bernardo Vieira de Melo");
        pj.setNumeroLogradouro("300");
        pj.setComplemento("300");
        pj.setBairro("Piedade");
        pj.setCidade("Recife");
        pj.setEstado("PE");
        pj.setEmail("123456789012345678901234567890123456789012345678901");//Email  com 51 caracteres (max permitido -> 50)
        pj.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.cadastrarClientePJ(pj);

        //Avaliar
    }


    //Fim do módulo de testes unitários INSERT PJ

    //Testes unitários do módulo Select
    // Select pf passando objeto null
    @Test(expected = RuntimeException.class)
    public void SelectPfObjetoNull() throws Exception {

        //Arranjar
        pf = null;

        //Agir
        List<ClientePessoaFisica> lista = negocio.consultarClientePF(pf);
        fail();
        //Avaliar
    }

    // Select pj passando objeto null
    @Test(expected = RuntimeException.class)
    public void SelectPjObjetoNull() throws Exception {

        //Arranjar
        pj = null;

        //Agir
        List<ClientePessoaJuridica> lista = negocio.consultarClientePJ(pj);
        fail();
        //Avaliar
    }


    /*Testes unitários do módulo Delete
     Delete  pf passando objeto null*/
    @Test(expected = RuntimeException.class)
    public void DeletePfObjetoNulo() throws Exception {

        //Arranjar
        pf = null;
        //Agir
        negocio.removerClientePFCod(pf);
        //Avaliar
    }

   
    //  Delete  pf passando objeto null
    @Test(expected = RuntimeException.class)
    public void DeletePjObjetoNulo() throws Exception {

        //Arranjar
        pj = null;
        //Agir
        negocio.removerClientePJCod(pj);
        //Avaliar
    }
    
      //  Delete  pf passando id<0
    @Test(expected = RuntimeException.class)
    public void DeletePfIdNegativo() throws Exception {

        //Arranjar
        pf = new ClientePessoaFisica();
        pf.setCli_Codigo(-1);
        //Agir
        negocio.removerClientePFCod(pf);
        //Avaliar
    }
    
        //  Delete  pf passando id inexistente no banco
    @Test(expected = RuntimeException.class)
    public void DeletePfInexistente() throws Exception {

        //Arranjar
        pf = new ClientePessoaFisica();
        pf.setCli_Codigo(999999999);
        //Agir
        negocio.removerClientePFCod(pf);
        //Avaliar
    }
    
      //  Delete  pj passando id<0
    @Test(expected = RuntimeException.class)
    public void DeletePjIdNegativo() throws Exception {

        //Arranjar
        pj = new ClientePessoaJuridica();
        pj.setCli_Codigo(-1);
        //Agir
        negocio.removerClientePJCod(pj);
        //Avaliar
    }
    
    
       //  Delete  pj passando id inexistente no banco
    @Test(expected = RuntimeException.class)
    public void DeletePjInexistente() throws Exception {

        //Arranjar
        pj = new ClientePessoaJuridica();
        pj.setCli_Codigo(9999999);
        //Agir
        negocio.removerClientePJCod(pj);
        //Avaliar
    }

   

    /*Testes unitários do módulo Update
     Update passando objeto null*/
//INICIO
    //Update PF com objeto null
    @Test(expected = RuntimeException.class)
    public void UpdatePFObjetoNulo() throws Exception {

        //Arranjar
        pf = null;
        //Agir
        negocio.alterarClientePF(pf);

        //Avaliar
    }

    //Update PF com cpf null 
    @Test(expected = RuntimeException.class)
    public void UpdatePfCpfNull() throws Exception {
        //Arranjar
        pf = new ClientePessoaFisica();
        pf.setCli_Cpf(null);
        pf.setNome("Pedro");
        pf.setSexo("m");
        pf.setCep("54.410-010");
        pf.setLogradouro("Av Bernardo Vieira de Melo");
        pf.setNumeroLogradouro("3074");
        pf.setComplemento("302");
        pf.setBairro("Piedade");
        pf.setCidade("Jaboatão dos Guararapes");
        pf.setEstado("PE");
        pf.setEmail("bps@gmail.com");
        pf.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.alterarClientePF(pf);

        //Avaliar
    }

    //Update pf com CPF estourando limite de caracteres. Esse test case tambem vale pro cenário de cpf com tamanho inferior ao tamanho necessário(cpf.length =14).
    @Test(expected = RuntimeException.class)
    public void UpdatePfCpfLengthInvalido() throws Exception {
        //Arranjar
        pf = new ClientePessoaFisica();
        pf.setCli_Cpf("055.186.754-022");
        pf.setNome("Pedro");
        pf.setSexo("m");
        pf.setCep("54.410-010");
        pf.setLogradouro("Av Bernardo Vieira de Melo");
        pf.setNumeroLogradouro("3074");
        pf.setComplemento("302");
        pf.setBairro("Piedade");
        pf.setCidade("Jaboatão dos Guararapes");
        pf.setEstado("PE");
        pf.setEmail("bps@gmail.com");
        pf.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.alterarClientePF(pf);

        //Avaliar
    }

    //Update pf com Nome null;
    @Test(expected = RuntimeException.class)
    public void UpdatePfNomeNull() throws Exception {
        //Arranjar
        pf = new ClientePessoaFisica();
        pf.setCli_Cpf("055.186.754-02");
        pf.setNome(null);
        pf.setSexo("m");
        pf.setCep("54.410-010");
        pf.setLogradouro("Av Bernardo Vieira de Melo");
        pf.setNumeroLogradouro("3074");
        pf.setComplemento("302");
        pf.setBairro("Piedade");
        pf.setCidade("Jaboatão dos Guararapes");
        pf.setEstado("PE");
        pf.setEmail("bps@gmail.com");
        pf.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.alterarClientePF(pf);

        //Avaliar
    }

    //Update pf com Nome vazio;
    @Test(expected = RuntimeException.class)
    public void UpdatePfNomeVazio() throws Exception {
        //Arranjar
        pf = new ClientePessoaFisica();
        pf.setCli_Cpf("055.186.754-02");
        pf.setNome("");
        pf.setSexo("m");
        pf.setCep("54.410-010");
        pf.setLogradouro("Av Bernardo Vieira de Melo");
        pf.setNumeroLogradouro("3074");
        pf.setComplemento("302");
        pf.setBairro("Piedade");
        pf.setCidade("Jaboatão dos Guararapes");
        pf.setEstado("PE");
        pf.setEmail("bps@gmail.com");
        pf.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.alterarClientePF(pf);

        //Avaliar
    }

    //Update pf com Nome estourando limite de caracteres(nome.length=50);
    @Test(expected = RuntimeException.class)
    public void UpdatePfNomeEstourandoLimiteCaracteres() throws Exception {
        //Arranjar
        pf = new ClientePessoaFisica();
        pf.setCli_Cpf("055.186.754-02");
        pf.setNome("BernardoBeBernardoBeBernardoBeBernardoBeBernardoBeBernardoBeBernardoBeBernardoBeBernardoBeBernardoBe1");//Nome com 101 caracteres(max permitido->20)
        pf.setSexo("m");
        pf.setCep("54.410-010");
        pf.setLogradouro("Av Bernardo Vieira de Melo");
        pf.setNumeroLogradouro("3074");
        pf.setComplemento("302");
        pf.setBairro("Piedade");
        pf.setCidade("Jaboatão dos Guararapes");
        pf.setEstado("PE");
        pf.setEmail("bps@gmail.com");
        pf.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.alterarClientePF(pf);

        //Avaliar
    }

    //Update pf  passando telefone null
    @Test(expected = RuntimeException.class)
    public void UpdatePfTelefoneNull() throws Exception {
        //Arranjar
        pf = new ClientePessoaFisica();
        pf.setCli_Cpf("055.186.754-02");
        pf.setNome("Bernardo");
        pf.setSexo("m");
        pf.setCep("54.410-010");
        pf.setLogradouro("Av Bernardo Vieira de Melo");
        pf.setNumeroLogradouro("3074");
        pf.setComplemento("302");
        pf.setBairro("Piedade");
        pf.setCidade("Jaboatão dos Guararapes");
        pf.setEstado("PE");
        pf.setEmail("bps@gmail.com");
        pf.setTelefone(null);

        //Agir
        negocio.alterarClientePF(pf);

        //Avaliar
    }
    
    

    //Cadastro pf  passando telefone vazio
    @Test(expected = RuntimeException.class)
    public void UpdatePfTelefoneVazio() throws Exception {
        //Arranjar
        pf = new ClientePessoaFisica();
        pf.setCli_Cpf("055.186.754-02");
        pf.setNome("Bernardo");
        pf.setSexo("m");
        pf.setCep("54.410-010");
        pf.setLogradouro("Av Bernardo Vieira de Melo");
        pf.setNumeroLogradouro("3074");
        pf.setComplemento("302");
        pf.setBairro("Piedade");
        pf.setCidade("Jaboatão dos Guararapes");
        pf.setEstado("PE");
        pf.setEmail("bps@gmail.com");
        pf.setTelefone("");

        //Agir
        negocio.alterarClientePF(pf);

        //Avaliar
    }

    //Update pf  passando cep null
    @Test(expected = RuntimeException.class)
    public void UpdatePfCepNull() throws Exception {
        //Arranjar
        pf = new ClientePessoaFisica();
        pf.setCli_Cpf("055.186.754-02");
        pf.setNome("Bernardo");
        pf.setSexo("m");
        pf.setCep(null);//Cep null
        pf.setLogradouro("Av Bernardo Vieira de Melo");
        pf.setNumeroLogradouro("3074");
        pf.setComplemento("302");
        pf.setBairro("Piedade");
        pf.setCidade("Jaboatão dos Guararapes");
        pf.setEstado("PE");
        pf.setEmail("bps@gmail.com");
        pf.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.alterarClientePF(pf);

        //Avaliar
    }

    //Update pf  passando cep com menos caracteres que o necessário (cep.length=10)
    @Test(expected = RuntimeException.class)
    public void UpdatePfCepLengthInvalido() throws Exception {
        //Arranjar
        pf = new ClientePessoaFisica();
        pf.setCli_Cpf("055.186.754-02");
        pf.setNome("Bernardo");
        pf.setSexo("m");
        pf.setCep("54.410-01"); //Cep com 09 caracteres
        pf.setLogradouro("Av Bernardo Vieira de Melo");
        pf.setNumeroLogradouro("3074");
        pf.setComplemento("302");
        pf.setBairro("Piedade");
        pf.setCidade("Jaboatão dos Guararapes");
        pf.setEstado("PE");
        pf.setEmail("bps@gmail.com");
        pf.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.alterarClientePF(pf);

        //Avaliar
    }

    //Update pf  passando Logradouro Null
    @Test(expected = RuntimeException.class)
    public void UpdatePfLogradouroNull() throws Exception {
        //Arranjar
        pf = new ClientePessoaFisica();
        pf.setCli_Cpf("055.186.754-02");
        pf.setNome("Bernardo");
        pf.setSexo("m");
        pf.setCep("54.410-010");
        pf.setLogradouro(null); //Logradouro Null
        pf.setNumeroLogradouro("3074");
        pf.setComplemento("302");
        pf.setBairro("Piedade");
        pf.setCidade("Jaboatão dos Guararapes");
        pf.setEstado("PE");
        pf.setEmail("bps@gmail.com");
        pf.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.alterarClientePF(pf);

        //Avaliar
    }

    //Update pf  passando logradouro vazio
    @Test(expected = RuntimeException.class)
    public void UpdatePfLogradouroVazio() throws Exception {
        //Arranjar
        pf = new ClientePessoaFisica();
        pf.setCli_Cpf("055.186.754-02");
        pf.setNome("Bernardo");
        pf.setSexo("m");
        pf.setCep("54.410-010");
        pf.setLogradouro("");//Logradouro vazio.
        pf.setNumeroLogradouro("3074");
        pf.setComplemento("302");
        pf.setBairro("Piedade");
        pf.setCidade("Jaboatão dos Guararapes");
        pf.setEstado("PE");
        pf.setEmail("bps@gmail.com");
        pf.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.alterarClientePF(pf);

        //Avaliar
    }

    //Update pf  passando logradouro estourando limite de caracteres
    @Test(expected = RuntimeException.class)
    public void UpdatePfLogradouroEstourandoLimiteCaracteres() throws Exception {
        //Arranjar
        pf = new ClientePessoaFisica();
        pf.setCli_Cpf("055.186.754-02");
        pf.setNome("Bernardo");
        pf.setSexo("m");
        pf.setCep("54.410-010");
        pf.setLogradouro("PIEDADEPIEDADEPIEDADEPIEDADEPIEDADEPIEDADEPIEDADEPIEDADEEEEEEE");//Logradouro com 62 caracteres (Máx permitido -> 50)
        pf.setNumeroLogradouro("3074");
        pf.setComplemento("302");
        pf.setBairro("Piedade");
        pf.setCidade("Jaboatão dos Guararapes");
        pf.setEstado("PE");
        pf.setEmail("bps@gmail.com");
        pf.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.alterarClientePF(pf);

        //Avaliar
    }

    //Update pf  passando numero do logradouro null
    @Test(expected = RuntimeException.class)
    public void UpdatePfNumeroLogradouroNull() throws Exception {
        //Arranjar
        pf = new ClientePessoaFisica();
        pf.setCli_Cpf("055.186.754-02");
        pf.setNome("Bernardo");
        pf.setSexo("m");
        pf.setCep("54.410-010");
        pf.setLogradouro("Av Bernardo Vieira de Melo");
        pf.setNumeroLogradouro(null);//numeroLogradouro null
        pf.setComplemento("302");
        pf.setBairro("Piedade");
        pf.setCidade("Jaboatão dos Guararapes");
        pf.setEstado("PE");
        pf.setEmail("bps@gmail.com");
        pf.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.alterarClientePF(pf);

        //Avaliar
    }

    //Update pf  passando numeroLogradouro vazio
    @Test(expected = RuntimeException.class)
    public void UpdatePfNumeroLogradouroVazio() throws Exception {
        //Arranjar
        pf = new ClientePessoaFisica();
        pf.setCli_Cpf("055.186.754-02");
        pf.setNome("Bernardo");
        pf.setSexo("m");
        pf.setCep("54.410-010");
        pf.setLogradouro("Av Bernardo Vieira de Melo");
        pf.setNumeroLogradouro("");//numeroLogradouro vazio
        pf.setComplemento("302");
        pf.setBairro("Piedade");
        pf.setCidade("Jaboatão dos Guararapes");
        pf.setEstado("PE");
        pf.setEmail("bps@gmail.com");
        pf.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.alterarClientePF(pf);

        //Avaliar
    }

    //Update pf  passando numeroLogradouro estourando limite de caracteres
    @Test(expected = RuntimeException.class)
    public void UpdatePfNumeroLogradouroEstourandoLimiteCaracteres() throws Exception {
        //Arranjar
        pf = new ClientePessoaFisica();
        pf.setCli_Cpf("055.186.754-02");
        pf.setNome("Bernardo");
        pf.setSexo("m");
        pf.setCep("54.410-010");
        pf.setLogradouro("Av Bernardo Vieira de Melo");
        pf.setNumeroLogradouro("123456789012345678901");//numeroLogradouro com 21 caracteres (máx permitido ->20)
        pf.setComplemento("302");
        pf.setBairro("Piedade");
        pf.setCidade("Jaboatão dos Guararapes");
        pf.setEstado("PE");
        pf.setEmail("bps@gmail.com");
        pf.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.alterarClientePF(pf);

        //Avaliar
    }

    //Update pf  passando complemento null
    @Test(expected = RuntimeException.class)
    public void UpdatePfComplementoNull() throws Exception {
        //Arranjar
        pf = new ClientePessoaFisica();
        pf.setCli_Cpf("055.186.754-02");
        pf.setNome("Bernardo");
        pf.setSexo("m");
        pf.setCep("54.410-010");
        pf.setLogradouro("Av Bernardo Vieira de Melo");
        pf.setNumeroLogradouro("300");
        pf.setComplemento(null);// Complemento Null
        pf.setBairro("Piedade");
        pf.setCidade("Jaboatão dos Guararapes");
        pf.setEstado("PE");
        pf.setEmail("bps@gmail.com");
        pf.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.alterarClientePF(pf);

        //Avaliar
    }

    //Update pf  passando complemento null
    @Test(expected = RuntimeException.class)
    public void UpdatePfComplementoEstourandoLimiteCaracteres() throws Exception {
        //Arranjar
        pf = new ClientePessoaFisica();
        pf.setCli_Cpf("055.186.754-02");
        pf.setNome("Bernardo");
        pf.setSexo("m");
        pf.setCep("54.410-010");
        pf.setLogradouro("Av Bernardo Vieira de Melo");
        pf.setNumeroLogradouro("300");
        pf.setComplemento("123456789012345678901");// Complemento com 21 caracteres (máx permitido ->20)
        pf.setBairro("Piedade");
        pf.setCidade("Jaboatão dos Guararapes");
        pf.setEstado("PE");
        pf.setEmail("bps@gmail.com");
        pf.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.alterarClientePF(pf);

        //Avaliar
    }

    //Update pf  passando bairro null
    @Test(expected = RuntimeException.class)
    public void UpdatePfBairroNull() throws Exception {
        //Arranjar
        pf = new ClientePessoaFisica();
        pf.setCli_Cpf("055.186.754-02");
        pf.setNome("Bernardo");
        pf.setSexo("m");
        pf.setCep("54.410-010");
        pf.setLogradouro("Av Bernardo Vieira de Melo");
        pf.setNumeroLogradouro("300");
        pf.setComplemento("300");
        pf.setBairro(null);//Bairro Null
        pf.setCidade("Jaboatão dos Guararapes");
        pf.setEstado("PE");
        pf.setEmail("bps@gmail.com");
        pf.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.alterarClientePF(pf);

        //Avaliar
    }

    //Update pf  passando bairro vazio
    @Test(expected = RuntimeException.class)
    public void UpdatePfBairroVazio() throws Exception {
        //Arranjar
        pf = new ClientePessoaFisica();
        pf.setCli_Cpf("055.186.754-02");
        pf.setNome("Bernardo");
        pf.setSexo("m");
        pf.setCep("54.410-010");
        pf.setLogradouro("Av Bernardo Vieira de Melo");
        pf.setNumeroLogradouro("300");
        pf.setComplemento("300");
        pf.setBairro("");//Bairro vazio
        pf.setCidade("Jaboatão dos Guararapes");
        pf.setEstado("PE");
        pf.setEmail("bps@gmail.com");
        pf.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.alterarClientePF(pf);

        //Avaliar
    }

    //Update pf  passando bairro estourando limite de caracteres
    @Test(expected = RuntimeException.class)
    public void UpdatePfBairroEstourandoLimiteCaracteres() throws Exception {
        //Arranjar
        pf = new ClientePessoaFisica();
        pf.setCli_Cpf("055.186.754-02");
        pf.setNome("Bernardo");
        pf.setSexo("m");
        pf.setCep("54.410-010");
        pf.setLogradouro("Av Bernardo Vieira de Melo");
        pf.setNumeroLogradouro("300");
        pf.setComplemento("366");
        pf.setBairro("PiedadePiedadePiedade");// Bairro com 21 caracteres (máx permitido ->20)
        pf.setCidade("Jaboatão dos Guararapes");
        pf.setEstado("PE");
        pf.setEmail("bps@gmail.com");
        pf.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.alterarClientePF(pf);

        //Avaliar
    }

    //Update pf  passando cidade null
    @Test(expected = RuntimeException.class)
    public void UpdatePfCidadeNull() throws Exception {
        //Arranjar
        pf = new ClientePessoaFisica();
        pf.setCli_Cpf("055.186.754-02");
        pf.setNome("Bernardo");
        pf.setSexo("m");
        pf.setCep("54.410-010");
        pf.setLogradouro("Av Bernardo Vieira de Melo");
        pf.setNumeroLogradouro("300");
        pf.setComplemento("300");
        pf.setBairro("Piedade");
        pf.setCidade(null);//Cidade Null
        pf.setEstado("PE");
        pf.setEmail("bps@gmail.com");
        pf.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.alterarClientePF(pf);

        //Avaliar
    }

    //Update pf  passando cidade vazio
    @Test(expected = RuntimeException.class)
    public void UpdatePfCidadeVazio() throws Exception {
        //Arranjar
        pf = new ClientePessoaFisica();
        pf.setCli_Cpf("055.186.754-02");
        pf.setNome("Bernardo");
        pf.setSexo("m");
        pf.setCep("54.410-010");
        pf.setLogradouro("Av Bernardo Vieira de Melo");
        pf.setNumeroLogradouro("300");
        pf.setComplemento("300");
        pf.setBairro("Piedade");
        pf.setCidade("");//Cidade Vazio
        pf.setEstado("PE");
        pf.setEmail("bps@gmail.com");
        pf.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.alterarClientePF(pf);

        //Avaliar
    }

    //Update pf  passando cidade estourando limite caracteres
    @Test(expected = RuntimeException.class)
    public void UpdatePfCidadeEstourandoLimiteCaracteres() throws Exception {
        //Arranjar
        pf = new ClientePessoaFisica();
        pf.setCli_Cpf("055.186.754-02");
        pf.setNome("Bernardo");
        pf.setSexo("m");
        pf.setCep("54.410-010");
        pf.setLogradouro("Av Bernardo Vieira de Melo");
        pf.setNumeroLogradouro("300");
        pf.setComplemento("300");
        pf.setBairro("Piedade");
        pf.setCidade("RecifeRecifeReciferec");//Cidade com 21 caracteres(máx permitido ->20)
        pf.setEstado("PE");
        pf.setEmail("bps@gmail.com");
        pf.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.alterarClientePF(pf);

        //Avaliar
    }

    //Update pf  passando estado null
    @Test(expected = RuntimeException.class)
    public void UpdatePfEstadoNull() throws Exception {
        //Arranjar
        pf = new ClientePessoaFisica();
        pf.setCli_Cpf("055.186.754-02");
        pf.setNome("Bernardo");
        pf.setSexo("m");
        pf.setCep("54.410-010");
        pf.setLogradouro("Av Bernardo Vieira de Melo");
        pf.setNumeroLogradouro("300");
        pf.setComplemento("300");
        pf.setBairro("Piedade");
        pf.setCidade("Recife");
        pf.setEstado(null);//Estado null
        pf.setEmail("bps@gmail.com");
        pf.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.alterarClientePF(pf);

        //Avaliar
    }

    //Update pf  passando estado vazio
    @Test(expected = RuntimeException.class)
    public void UpdatePfEstadoVazio() throws Exception {
        //Arranjar
        pf = new ClientePessoaFisica();
        pf.setCli_Cpf("055.186.754-02");
        pf.setNome("Bernardo");
        pf.setSexo("m");
        pf.setCep("54.410-010");
        pf.setLogradouro("Av Bernardo Vieira de Melo");
        pf.setNumeroLogradouro("300");
        pf.setComplemento("300");
        pf.setBairro("Piedade");
        pf.setCidade("Recife");
        pf.setEstado("");//Estado vazio
        pf.setEmail("bps@gmail.com");
        pf.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.alterarClientePF(pf);

        //Avaliar
    }

    //Update pf  passando estado estourando limite de caracteres
    @Test(expected = RuntimeException.class)
    public void UpdatePfEstadoEstourandoLimiteCaracteres() throws Exception {
        //Arranjar
        pf = new ClientePessoaFisica();
        pf.setCli_Cpf("055.186.754-02");
        pf.setNome("Bernardo");
        pf.setSexo("m");
        pf.setCep("54.410-010");
        pf.setLogradouro("Av Bernardo Vieira de Melo");
        pf.setNumeroLogradouro("300");
        pf.setComplemento("300");
        pf.setBairro("Piedade");
        pf.setCidade("Recife");
        pf.setEstado("Pernambuco");//Estado com 10 caracteres (máx permitido->10)
        pf.setEmail("bps@gmail.com");
        pf.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.alterarClientePF(pf);

        //Avaliar
    }

    //Update pf  passando email null
    @Test(expected = RuntimeException.class)
    public void UpdatePfEmailNull() throws Exception {
        //Arranjar
        pf = new ClientePessoaFisica();
        pf.setCli_Cpf("055.186.754-02");
        pf.setNome("Bernardo");
        pf.setSexo("m");
        pf.setCep("54.410-010");
        pf.setLogradouro("Av Bernardo Vieira de Melo");
        pf.setNumeroLogradouro("300");
        pf.setComplemento("300");
        pf.setBairro("Piedade");
        pf.setCidade("Recife");
        pf.setEstado("PE");
        pf.setEmail(null);//Email null
        pf.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.alterarClientePF(pf);

        //Avaliar
    }

    //Update pf  passando email vazio
    @Test(expected = RuntimeException.class)
    public void UpdatePfEmailVazio() throws Exception {
        //Arranjar
        pf = new ClientePessoaFisica();
        pf.setCli_Cpf("055.186.754-02");
        pf.setNome("Bernardo");
        pf.setSexo("m");
        pf.setCep("54.410-010");
        pf.setLogradouro("Av Bernardo Vieira de Melo");
        pf.setNumeroLogradouro("300");
        pf.setComplemento("300");
        pf.setBairro("Piedade");
        pf.setCidade("Recife");
        pf.setEstado("PE");
        pf.setEmail("");//Email vazio
        pf.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.alterarClientePF(pf);

        //Avaliar
    }

    //Update pf  passando email vazio
    @Test(expected = RuntimeException.class)
    public void UpdatePfEmailEstourandoLimiteCaracteres() throws Exception {
        //Arranjar
        pf = new ClientePessoaFisica();
        pf.setCli_Cpf("055.186.754-02");
        pf.setNome("Bernardo");
        pf.setSexo("m");
        pf.setCep("54.410-010");
        pf.setLogradouro("Av Bernardo Vieira de Melo");
        pf.setNumeroLogradouro("300");
        pf.setComplemento("300");
        pf.setBairro("Piedade");
        pf.setCidade("Recife");
        pf.setEstado("PE");
        pf.setEmail("bernardoppbernardoppbernardoppbernardoppbernardoppp");//Email com 51 caracteres(máx permitido->50)
        pf.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.alterarClientePF(pf);

        //Avaliar
    }

    //Update pf  passando sexo null
    @Test(expected = RuntimeException.class)
    public void UpdatePfSexoNull() throws Exception {
        //Arranjar
        pf = new ClientePessoaFisica();
        pf.setCli_Cpf("055.186.754-02");
        pf.setNome("Bernardo");
        pf.setSexo(null);//sexo null
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

        //Avaliar
    }

    //Update pf  passando sexo vazio
    @Test(expected = RuntimeException.class)
    public void UpdatePfSexoVazio() throws Exception {
        //Arranjar
        pf = new ClientePessoaFisica();
        pf.setCli_Cpf("055.186.754-02");
        pf.setNome("Bernardo");
        pf.setSexo("");//sexo vazio
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

        //Avaliar
    }

    //Update pf  passando sexo  com tamanho de campo inválido (campoo deve ter apenas 1 caractere)
    @Test(expected = RuntimeException.class)
    public void UpdatePfSexoEstourandoLimiteCaracteres() throws Exception {
        //Arranjar
        pf = new ClientePessoaFisica();
        pf.setCli_Cpf("055.186.754-02");
        pf.setNome("Bernardo");
        pf.setSexo("mm");//sexo com 2 caracteres (máx permitido ->1)
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

        //Avaliar
    }

    //Update PJ com objeto null
    @Test(expected = RuntimeException.class)
    public void UpdatePJObjetoNulo() throws Exception {

        //Arranjar
        pj = null;
        //Agir
        negocio.alterarClientePJ(pj);

        //Avaliar
    }

    //Update PJ com cnpj null 
    @Test(expected = RuntimeException.class)
    public void UpdatePjCnpjNull() throws Exception {
        //Arranjar
        pj = new ClientePessoaJuridica();
        pj.setCli_Cnpj(null);
        pj.setRazaoSocial("Teste");
        pj.setCep("54.410-010");
        pj.setLogradouro("Av Bernardo Vieira de Melo");
        pj.setNumeroLogradouro("3074");
        pj.setComplemento("302");
        pj.setBairro("Piedade");
        pj.setCidade("Jaboatão dos Guararapes");
        pj.setEstado("PE");
        pj.setEmail("bps@gmail.com");
        pj.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.alterarClientePJ(pj);

        //Avaliar
    }

    //Update pj com cnpj estourando limite de caracteres. Esse test case tambem vale pro cenário de cnpj com tamanho inferior ao tamanho necessário(cnpj.length =18).
    @Test(expected = RuntimeException.class)
    public void UpdatePjCnpjLengthInvalido() throws Exception {
        //Arranjar
        pj = new ClientePessoaJuridica();
        pj.setCli_Cnpj("XX.XXX.XXX/YYYY-ZZZ");// CNPJ com 19 caracteres (máx permitido-> 18)
        pj.setRazaoSocial("Teste");
        pj.setCep("54.410-010");
        pj.setLogradouro("Av Bernardo Vieira de Melo");
        pj.setNumeroLogradouro("3074");
        pj.setComplemento("302");
        pj.setBairro("Piedade");
        pj.setCidade("Jaboatão dos Guararapes");
        pj.setEstado("PE");
        pj.setEmail("bps@gmail.com");
        pj.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.alterarClientePJ(pj);

        //Avaliar
    }

    //Update pj com Razao social null;
    @Test(expected = RuntimeException.class)
    public void UpdatePjRazaoSocialNull() throws Exception {
        //Arranjar
        pj = new ClientePessoaJuridica();
        pj.setCli_Cnpj("XX.XXX.XXX/YYYY-ZZ");
        pj.setRazaoSocial(null);// Razão social null
        pj.setCep("54.410-010");
        pj.setLogradouro("Av Bernardo Vieira de Melo");
        pj.setNumeroLogradouro("3074");
        pj.setComplemento("302");
        pj.setBairro("Piedade");
        pj.setCidade("Jaboatão dos Guararapes");
        pj.setEstado("PE");
        pj.setEmail("bps@gmail.com");
        pj.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.alterarClientePJ(pj);

        //Avaliar
    }

    //Update pj com Razão social vazio ;
    @Test(expected = RuntimeException.class)
    public void UpdatePjRazaoSocialVazio() throws Exception {
        //Arranjar
        pj = new ClientePessoaJuridica();
        pj.setCli_Cnpj("XX.XXX.XXX/YYYY-ZZ");
        pj.setRazaoSocial("");// Razão social vazio
        pj.setCep("54.410-010");
        pj.setLogradouro("Av Bernardo Vieira de Melo");
        pj.setNumeroLogradouro("3074");
        pj.setComplemento("302");
        pj.setBairro("Piedade");
        pj.setCidade("Jaboatão dos Guararapes");
        pj.setEstado("PE");
        pj.setEmail("bps@gmail.com");
        pj.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.alterarClientePJ(pj);

        //Avaliar
    }

    //Update pj com razao social estourando limite de caracteres(razaoSocial.length=60);
    @Test(expected = RuntimeException.class)
    public void UpdatePjRazaoSocialEstourandoLimiteCaracteres() throws Exception {
        //Arranjar
        pj = new ClientePessoaJuridica();
        pj.setCli_Cnpj("XX.XXX.XXX/YYYY-ZZ");
        pj.setRazaoSocial("1234567890123456789012345678901234567890123456789012345678901");// Razão social com 61 caracteres(máx permitido ->60)
        pj.setCep("54.410-010");
        pj.setLogradouro("Av Bernardo Vieira de Melo");
        pj.setNumeroLogradouro("3074");
        pj.setComplemento("302");
        pj.setBairro("Piedade");
        pj.setCidade("Jaboatão dos Guararapes");
        pj.setEstado("PE");
        pj.setEmail("bps@gmail.com");
        pj.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.alterarClientePJ(pj);

        //Avaliar
    }

    //Update pj  passando telefone null
    @Test(expected = RuntimeException.class)
    public void UpdatePjTelefoneNull() throws Exception {
        //Arranjar
        pj = new ClientePessoaJuridica();
        pj.setCli_Cnpj("XX.XXX.XXX/YYYY-ZZ");
        pj.setRazaoSocial("Teste");
        pj.setCep("54.410-010");
        pj.setLogradouro("Av Bernardo Vieira de Melo");
        pj.setNumeroLogradouro("3074");
        pj.setComplemento("302");
        pj.setBairro("Piedade");
        pj.setCidade("Jaboatão dos Guararapes");
        pj.setEstado("PE");
        pj.setEmail("bps@gmail.com");
        pj.setTelefone(null);//Telefone null

        //Agir
        negocio.alterarClientePJ(pj);

        //Avaliar
    }

    //Update pj  passando telefone vazio
    @Test(expected = RuntimeException.class)
    public void UpdatePjTelefoneVazio() throws Exception {
        //Arranjar
        pj = new ClientePessoaJuridica();
        pj.setCli_Cnpj("XX.XXX.XXX/YYYY-ZZ");
        pj.setRazaoSocial("Teste");
        pj.setCep("54.410-010");
        pj.setLogradouro("Av Bernardo Vieira de Melo");
        pj.setNumeroLogradouro("3074");
        pj.setComplemento("302");
        pj.setBairro("Piedade");
        pj.setCidade("Jaboatão dos Guararapes");
        pj.setEstado("PE");
        pj.setEmail("bps@gmail.com");
        pj.setTelefone("");//Telefone vazio

        //Agir
        negocio.alterarClientePJ(pj);

        //Avaliar
    }

    //Update pj  passando cep null
    @Test(expected = RuntimeException.class)
    public void UpdatePjCepNull() throws Exception {
        //Arranjar
        pj = new ClientePessoaJuridica();
        pj.setCli_Cnpj("XX.XXX.XXX/YYYY-ZZ");
        pj.setRazaoSocial("Teste");
        pj.setCep(null);//CEP null
        pj.setLogradouro("Av Bernardo Vieira de Melo");
        pj.setNumeroLogradouro("3074");
        pj.setComplemento("302");
        pj.setBairro("Piedade");
        pj.setCidade("Jaboatão dos Guararapes");
        pj.setEstado("PE");
        pj.setEmail("bps@gmail.com");
        pj.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.alterarClientePJ(pj);

        //Avaliar
    }

    //Update pj  passando cep com menos caracteres que o necessário (cep.length=10)
    @Test(expected = RuntimeException.class)
    public void UpdatePjCepLengthInvalido() throws Exception {
        //Arranjar
        pj = new ClientePessoaJuridica();
        pj.setCli_Cnpj("XX.XXX.XXX/YYYY-ZZ");
        pj.setRazaoSocial("Teste");
        pj.setCep("123");//CEP com 3 caracteres (campo deve conter 10 caracteres)
        pj.setLogradouro("Av Bernardo Vieira de Melo");
        pj.setNumeroLogradouro("3074");
        pj.setComplemento("302");
        pj.setBairro("Piedade");
        pj.setCidade("Jaboatão dos Guararapes");
        pj.setEstado("PE");
        pj.setEmail("bps@gmail.com");
        pj.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.alterarClientePJ(pj);

        //Avaliar
    }

    //Update pj  passando Logradouro Null
    @Test(expected = RuntimeException.class)
    public void UpdatePjLogradouroNull() throws Exception {
        //Arranjar
        pj = new ClientePessoaJuridica();
        pj.setCli_Cnpj("XX.XXX.XXX/YYYY-ZZ");
        pj.setRazaoSocial("Teste");
        pj.setCep("54.410-010");
        pj.setLogradouro(null);//Logradouro null
        pj.setNumeroLogradouro("3074");
        pj.setComplemento("302");
        pj.setBairro("Piedade");
        pj.setCidade("Jaboatão dos Guararapes");
        pj.setEstado("PE");
        pj.setEmail("bps@gmail.com");
        pj.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.alterarClientePJ(pj);

        //Avaliar
    }

    //Update pj  passando logradouro vazio
    @Test(expected = RuntimeException.class)
    public void UpdatePjLogradouroVazio() throws Exception {
        //Arranjar
        pj = new ClientePessoaJuridica();
        pj.setCli_Cnpj("XX.XXX.XXX/YYYY-ZZ");
        pj.setRazaoSocial("Teste");
        pj.setCep("54.410-010");
        pj.setLogradouro("");//Logradouro vazio
        pj.setNumeroLogradouro("3074");
        pj.setComplemento("302");
        pj.setBairro("Piedade");
        pj.setCidade("Jaboatão dos Guararapes");
        pj.setEstado("PE");
        pj.setEmail("bps@gmail.com");
        pj.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.alterarClientePJ(pj);

        //Avaliar
    }

    //Update pj  passando logradouro estourando limite de caracteres
    @Test(expected = RuntimeException.class)
    public void UpdatePjLogradouroEstourandoLimiteCaracteres() throws Exception {
        //Arranjar
        pj = new ClientePessoaJuridica();
        pj.setCli_Cnpj("XX.XXX.XXX/YYYY-ZZ");
        pj.setRazaoSocial("Teste");
        pj.setCep("54.410-010");
        pj.setLogradouro("1234567890123456789012345678901234567890123456789012345678901");//Logradouro com 61 caracteres (máx ->60 )
        pj.setNumeroLogradouro("3074");
        pj.setComplemento("302");
        pj.setBairro("Piedade");
        pj.setCidade("Jaboatão dos Guararapes");
        pj.setEstado("PE");
        pj.setEmail("bps@gmail.com");
        pj.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.alterarClientePJ(pj);

        //Avaliar
    }

    //Update pj  passando numero do logradouro null
    @Test(expected = RuntimeException.class)
    public void UpdatePjNumeroLogradouroNull() throws Exception {
        //Arranjar
        pj = new ClientePessoaJuridica();
        pj.setCli_Cnpj("XX.XXX.XXX/YYYY-ZZ");
        pj.setRazaoSocial("Teste");
        pj.setCep("54.410-010");
        pj.setLogradouro("Av Bernardo Vieira de Melo");
        pj.setNumeroLogradouro(null);//NumeroLogradouro null
        pj.setComplemento("302");
        pj.setBairro("Piedade");
        pj.setCidade("Jaboatão dos Guararapes");
        pj.setEstado("PE");
        pj.setEmail("bps@gmail.com");
        pj.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.alterarClientePJ(pj);

        //Avaliar
    }

    //Update pj  passando numeroLogradouro vazio
    @Test(expected = RuntimeException.class)
    public void UpdatePjNumeroLogradouroVazio() throws Exception {
        //Arranjar
        pj = new ClientePessoaJuridica();
        pj.setCli_Cnpj("XX.XXX.XXX/YYYY-ZZ");
        pj.setRazaoSocial("Teste");
        pj.setCep("54.410-010");
        pj.setLogradouro("Av Bernardo Vieira de Melo");
        pj.setNumeroLogradouro("");//NumeroLogradouro vazio
        pj.setComplemento("302");
        pj.setBairro("Piedade");
        pj.setCidade("Jaboatão dos Guararapes");
        pj.setEstado("PE");
        pj.setEmail("bps@gmail.com");
        pj.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.alterarClientePJ(pj);

        //Avaliar
    }

    //Update pj  passando numeroLogradouro estourando limite de caracteres
    @Test(expected = RuntimeException.class)
    public void UpdatePjNumeroLogradouroEstourandoLimiteCaracteres() throws Exception {
        //Arranjar
        pj = new ClientePessoaJuridica();
        pj.setCli_Cnpj("XX.XXX.XXX/YYYY-ZZ");
        pj.setRazaoSocial("Teste");
        pj.setCep("54.410-010");
        pj.setLogradouro("Av Bernardo Vieira de Melo");
        pj.setNumeroLogradouro("123456789012345678901");//NumeroLogradouro com 21 caracteres (máx permitido->20)
        pj.setComplemento("302");
        pj.setBairro("Piedade");
        pj.setCidade("Jaboatão dos Guararapes");
        pj.setEstado("PE");
        pj.setEmail("bps@gmail.com");
        pj.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.alterarClientePJ(pj);

        //Avaliar
    }

    //Update pj  passando complemento null
    @Test(expected = RuntimeException.class)
    public void UpdatePjComplementoNull() throws Exception {
        pj = new ClientePessoaJuridica();
        pj.setCli_Cnpj("XX.XXX.XXX/YYYY-ZZ");
        pj.setRazaoSocial("Teste");
        pj.setCep("54.410-010");
        pj.setLogradouro("Av Bernardo Vieira de Melo");
        pj.setNumeroLogradouro("300");
        pj.setComplemento(null);//Complemento null
        pj.setBairro("Piedade");
        pj.setCidade("Jaboatão dos Guararapes");
        pj.setEstado("PE");
        pj.setEmail("bps@gmail.com");
        pj.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.alterarClientePJ(pj);

        //Avaliar
    }

    //Update pj  passando complemento estourando limite de caracteres
    @Test(expected = RuntimeException.class)
    public void UpdatePjComplementoEstourandoLimiteCaracteres() throws Exception {
        pj = new ClientePessoaJuridica();
        pj.setCli_Cnpj("XX.XXX.XXX/YYYY-ZZ");
        pj.setRazaoSocial("Teste");
        pj.setCep("54.410-010");
        pj.setLogradouro("Av Bernardo Vieira de Melo");
        pj.setNumeroLogradouro("300");
        pj.setComplemento("123456789012345678901");//Complemento com 21 caracteres (max permitido -> 20)
        pj.setBairro("Piedade");
        pj.setCidade("Jaboatão dos Guararapes");
        pj.setEstado("PE");
        pj.setEmail("bps@gmail.com");
        pj.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.alterarClientePJ(pj);

        //Avaliar
    }

    //Update pj  passando bairro null
    @Test(expected = RuntimeException.class)
    public void UpdatePjBairroNull() throws Exception {
        pj = new ClientePessoaJuridica();
        pj.setCli_Cnpj("XX.XXX.XXX/YYYY-ZZ");
        pj.setRazaoSocial("Teste");
        pj.setCep("54.410-010");
        pj.setLogradouro("Av Bernardo Vieira de Melo");
        pj.setNumeroLogradouro("300");
        pj.setComplemento("300");
        pj.setBairro(null);//Bairro null
        pj.setCidade("Jaboatão dos Guararapes");
        pj.setEstado("PE");
        pj.setEmail("bps@gmail.com");
        pj.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.alterarClientePJ(pj);

        //Avaliar
    }

    //Update pj  passando bairro vazio
    @Test(expected = RuntimeException.class)
    public void UpdatePjBairroVazio() throws Exception {
        pj = new ClientePessoaJuridica();
        pj.setCli_Cnpj("XX.XXX.XXX/YYYY-ZZ");
        pj.setRazaoSocial("Teste");
        pj.setCep("54.410-010");
        pj.setLogradouro("Av Bernardo Vieira de Melo");
        pj.setNumeroLogradouro("300");
        pj.setComplemento("300");
        pj.setBairro("");//Bairro vazio
        pj.setCidade("Jaboatão dos Guararapes");
        pj.setEstado("PE");
        pj.setEmail("bps@gmail.com");
        pj.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.alterarClientePJ(pj);

        //Avaliar
    }

    //Update pj  passando bairro estourando limite de caracteres
    @Test(expected = RuntimeException.class)
    public void UpdatePjBairroEstourandoLimiteCaracteres() throws Exception {
        pj = new ClientePessoaJuridica();
        pj.setCli_Cnpj("XX.XXX.XXX/YYYY-ZZ");
        pj.setRazaoSocial("Teste");
        pj.setCep("54.410-010");
        pj.setLogradouro("Av Bernardo Vieira de Melo");
        pj.setNumeroLogradouro("300");
        pj.setComplemento("300");
        pj.setBairro("123456789012345678901");//Bairro com 21 caracteres (max permitido -> 20)
        pj.setCidade("Jaboatão dos Guararapes");
        pj.setEstado("PE");
        pj.setEmail("bps@gmail.com");
        pj.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.alterarClientePJ(pj);

        //Avaliar
    }

    //Update pj  passando cidade null
    @Test(expected = RuntimeException.class)
    public void UpdatePjCidadeNull() throws Exception {
        pj = new ClientePessoaJuridica();
        pj.setCli_Cnpj("XX.XXX.XXX/YYYY-ZZ");
        pj.setRazaoSocial("Teste");
        pj.setCep("54.410-010");
        pj.setLogradouro("Av Bernardo Vieira de Melo");
        pj.setNumeroLogradouro("300");
        pj.setComplemento("300");
        pj.setBairro("Piedade");
        pj.setCidade(null);//Cidade null
        pj.setEstado("PE");
        pj.setEmail("bps@gmail.com");
        pj.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.alterarClientePJ(pj);

        //Avaliar
    }

    //Update pj  passando cidade vazio
    @Test(expected = RuntimeException.class)
    public void UpdatePjCidadeVazio() throws Exception {
        pj = new ClientePessoaJuridica();
        pj.setCli_Cnpj("XX.XXX.XXX/YYYY-ZZ");
        pj.setRazaoSocial("Teste");
        pj.setCep("54.410-010");
        pj.setLogradouro("Av Bernardo Vieira de Melo");
        pj.setNumeroLogradouro("300");
        pj.setComplemento("300");
        pj.setBairro("Piedade");
        pj.setCidade("");//Cidade vazio
        pj.setEstado("PE");
        pj.setEmail("bps@gmail.com");
        pj.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.alterarClientePJ(pj);

        //Avaliar
    }

    //Update pj  passando cidade estourando limite caracteres
    @Test(expected = RuntimeException.class)
    public void UpdatePjCidadeEstourandoLimiteCaracteres() throws Exception {
        pj = new ClientePessoaJuridica();
        pj.setCli_Cnpj("XX.XXX.XXX/YYYY-ZZ");
        pj.setRazaoSocial("Teste");
        pj.setCep("54.410-010");
        pj.setLogradouro("Av Bernardo Vieira de Melo");
        pj.setNumeroLogradouro("300");
        pj.setComplemento("300");
        pj.setBairro("Piedade");
        pj.setCidade("123456789012345678901234567890123456789012345678901");//Cidade com 51 caracteres (max permitido-> 50)
        pj.setEstado("PE");
        pj.setEmail("bps@gmail.com");
        pj.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.alterarClientePJ(pj);

        //Avaliar
    }

    //Update pj  passando estado null
    @Test(expected = RuntimeException.class)
    public void UpdatePjEstadoNull() throws Exception {
        pj = new ClientePessoaJuridica();
        pj.setCli_Cnpj("XX.XXX.XXX/YYYY-ZZ");
        pj.setRazaoSocial("Teste");
        pj.setCep("54.410-010");
        pj.setLogradouro("Av Bernardo Vieira de Melo");
        pj.setNumeroLogradouro("300");
        pj.setComplemento("300");
        pj.setBairro("Piedade");
        pj.setCidade("Recife");
        pj.setEstado(null);//Estado null
        pj.setEmail("bps@gmail.com");
        pj.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.alterarClientePJ(pj);

        //Avaliar
    }

    //Update pj  passando estado vazio
    @Test(expected = RuntimeException.class)
    public void UpdatePjEstadoVazio() throws Exception {
        pj = new ClientePessoaJuridica();
        pj.setCli_Cnpj("XX.XXX.XXX/YYYY-ZZ");
        pj.setRazaoSocial("Teste");
        pj.setCep("54.410-010");
        pj.setLogradouro("Av Bernardo Vieira de Melo");
        pj.setNumeroLogradouro("300");
        pj.setComplemento("300");
        pj.setBairro("Piedade");
        pj.setCidade("Recife");
        pj.setEstado("");//Estado vazio
        pj.setEmail("bps@gmail.com");
        pj.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.alterarClientePJ(pj);

        //Avaliar
    }

    //Update pj  passando estado estourando limite de caracteres
    @Test(expected = RuntimeException.class)
    public void UpdatePjEstadoEstourandoLimiteCaracteres() throws Exception {
        pj = new ClientePessoaJuridica();
        pj.setCli_Cnpj("XX.XXX.XXX/YYYY-ZZ");
        pj.setRazaoSocial("Teste");
        pj.setCep("54.410-010");
        pj.setLogradouro("Av Bernardo Vieira de Melo");
        pj.setNumeroLogradouro("300");
        pj.setComplemento("300");
        pj.setBairro("Piedade");
        pj.setCidade("Recife");
        pj.setEstado("PEE");//Estado com 3 caracteres (max permitido -> 2)
        pj.setEmail("bps@gmail.com");
        pj.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.alterarClientePJ(pj);

        //Avaliar
    }

    //Update pj  passando email null
    @Test(expected = RuntimeException.class)
    public void UpdatePjEmailNull() throws Exception {
        pj = new ClientePessoaJuridica();
        pj.setCli_Cnpj("XX.XXX.XXX/YYYY-ZZ");
        pj.setRazaoSocial("Teste");
        pj.setCep("54.410-010");
        pj.setLogradouro("Av Bernardo Vieira de Melo");
        pj.setNumeroLogradouro("300");
        pj.setComplemento("300");
        pj.setBairro("Piedade");
        pj.setCidade("Recife");
        pj.setEstado("PE");
        pj.setEmail(null);//Email null
        pj.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.alterarClientePJ(pj);

        //Avaliar
    }

    //Update pj  passando email vazio
    @Test(expected = RuntimeException.class)
    public void UpdatePjEmailVazio() throws Exception {
        pj = new ClientePessoaJuridica();
        pj.setCli_Cnpj("XX.XXX.XXX/YYYY-ZZ");
        pj.setRazaoSocial("Teste");
        pj.setCep("54.410-010");
        pj.setLogradouro("Av Bernardo Vieira de Melo");
        pj.setNumeroLogradouro("300");
        pj.setComplemento("300");
        pj.setBairro("Piedade");
        pj.setCidade("Recife");
        pj.setEstado("PE");
        pj.setEmail("");//Email vazio
        pj.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.alterarClientePJ(pj);

        //Avaliar
    }

    //Update pj  passando email estourando limite de caracteres
    @Test(expected = RuntimeException.class)
    public void UpdatePjEmailEstourandoLimiteCaracteres() throws Exception {
        pj = new ClientePessoaJuridica();
        pj.setCli_Cnpj("XX.XXX.XXX/YYYY-ZZ");
        pj.setRazaoSocial("Teste");
        pj.setCep("54.410-010");
        pj.setLogradouro("Av Bernardo Vieira de Melo");
        pj.setNumeroLogradouro("300");
        pj.setComplemento("300");
        pj.setBairro("Piedade");
        pj.setCidade("Recife");
        pj.setEstado("PE");
        pj.setEmail("123456789012345678901234567890123456789012345678901");//Email  com 51 caracteres (max permitido -> 50)
        pj.setTelefone("(81)9.8188-9981");

        //Agir
        negocio.alterarClientePJ(pj);

        //Avaliar
    }

    //Fim dos testes unitários do módulo update
  
}
