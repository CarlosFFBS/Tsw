package contrato;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sla.clientes.ClientePessoaFisica;
import sla.clientes.ClientePessoaJuridica;
import sla.contrato.ContratoPF;
import sla.contrato.ContratoPJ;
import sla.contrato.DadosContrato;
import sla.contrato.NegocioContrato;



/**
 * @author carlosffbs
 */
public class ContratoIntegrationTest {
    NegocioContrato nc;

    ContratoPF contratoPF;
    ContratoPF contratoPfNovo;
    ContratoPJ contratoPjNovo;
    ContratoPJ contratoPJ;
    ClientePessoaFisica pf1;
    ClientePessoaFisica pf2;
    ClientePessoaFisica pf3;
   
    ClientePessoaJuridica pj1;
    ClientePessoaJuridica pj2;
    ClientePessoaJuridica pj3;
    
   
    
    Date dataTeste1;
    Date dataTeste2;
    Date dataTeste3;
    SimpleDateFormat sdf;
    DadosContrato daoFalso;
       
    @Before
    public void starUp() throws ParseException, Exception{
        contratoPF = new ContratoPF();  
        contratoPJ = new ContratoPJ();
        contratoPfNovo = new ContratoPF();  
        contratoPjNovo = new ContratoPJ();
        pf1 = new ClientePessoaFisica();
        pf1.setBairro("BOA VIAGEM");
        pf1.setCep("51130310");
        pf1.setCidade("RECIFE");
        pf1.setCli_Codigo(10);
        pf1.setCli_Cpf("00070385588");
        pf1.setComplemento("AP 01");
        pf1.setEmail("aaa@gmail.com");
        pf1.setEstado("PE");
        pf1.setLogradouro("Rua A");
        pf1.setNome("Carlos");
        pf1.setNumeroLogradouro("111");
        pf1.setSexo("Male");
        pf1.setTelefone("98888-8888");
        pf2 = new ClientePessoaFisica();
        pf2.setBairro("BOA VIAGEM");
        pf2.setCep("51130310");
        pf2.setCidade("RECIFE");
        pf2.setCli_Codigo(11);
        pf2.setCli_Cpf("00011122233");
        pf2.setComplemento("AP 01");
        pf2.setEmail("bbb@gmail.com");
        pf2.setEstado("PE");
        pf2.setLogradouro("Rua A");
        pf2.setNome("Clara");
        pf2.setNumeroLogradouro("111");
        pf2.setSexo("Female");
        pf2.setTelefone("98888-8888");
        
        pj1 = new ClientePessoaJuridica();
        pj1.setBairro("BOA VIAGEM");
        pj1.setCep("51130310");
        pj1.setCidade("RECIFE");
        pj1.setCli_Codigo(20);
        pj1.setCli_Cnpj("11222333444455");
        pj1.setComplemento("AP 01");
        pj1.setEmail("ccc@gmail.com");
        pj1.setEstado("PE");
        pj1.setLogradouro("Rua A");
        pj1.setRazaoSocial("Creative");
        pj1.setNumeroLogradouro("111");
        pj1.setTelefone("98888-8888");
        
        pj2 = new ClientePessoaJuridica();
        pj2.setBairro("BOA VIAGEM");
        pj2.setCep("51130310");
        pj2.setCidade("RECIFE");
        pj2.setCli_Codigo(20);
        pj2.setCli_Cnpj("22333444555566");
        pj2.setComplemento("AP 01");
        pj2.setEmail("ccc@gmail.com");
        pj2.setEstado("PE");
        pj2.setLogradouro("Rua A");
        pj2.setRazaoSocial("Florenkids");
        pj2.setNumeroLogradouro("222");
        pj2.setTelefone("98877-6688");
        
        nc = new NegocioContrato();
        
        sdf = new SimpleDateFormat("dd/MM/yyyy");
        dataTeste1 = sdf.parse("01/01/2018");
        dataTeste2 = sdf.parse("01/01/2019");
        dataTeste3 = sdf.parse("01/01/2020");
    }
    
   
    //Classes equivalencias CadastrarContrato:
    
//Caminho feliz
@Test//(expected=RuntimeException.class)
public void CadastrarContratoPfTestOk() throws Exception{
    
//Arrumar   
    contratoPF.setClientePF(pf1);
    contratoPF.setIdContrato(1);
    contratoPF.setCobrePeca(true);
    contratoPF.setInicioContrato(dataTeste1);
    contratoPF.setFimContrato(dataTeste3);
    contratoPF.setValor((float) 1000.00);
    contratoPF.setUmAtendimento(2);
    contratoPF.setFimAtendimento(7);
    contratoPF.setTotalEquipamento(10);
     
//Agir
    boolean teste = nc.cadastrarContratoPF(contratoPF);

//Avaliar   
    Assert.assertTrue(teste);
}
   
@Test(expected = RuntimeException.class)
public void CadastrarContratoPFTestContratoNull() throws Exception{
    //Arrumar
    contratoPF = null;
    //Agir
    boolean teste = nc.cadastrarContratoPF(contratoPF);
    //Avaliar
    Assert.assertTrue(teste);
}
   
@Test(expected = RuntimeException.class)
public void CadastrarContratoPfTestClienteNull() throws Exception{
//Arrumar
    pf3 = null;
    contratoPF.setClientePF(pf3);
//Agir
    boolean teste = nc.cadastrarContratoPF(contratoPF);
//Avaliar
    Assert.assertTrue(teste);
}

@Test(expected = RuntimeException.class)
public void CadastrarContratoPfTestDataInicioNull() throws Exception{
    //Arrumar
    Date data = sdf.parse(null);
    contratoPF.setClientePF(pf1);
    contratoPF.setIdContrato(1);
    contratoPF.setCobrePeca(true);
    contratoPF.setInicioContrato(data);
    contratoPF.setFimContrato(dataTeste3);
    contratoPF.setValor((float) 1000.00);
    contratoPF.setTotalEquipamento(10);
   //Agir
    boolean teste = nc.cadastrarContratoPF(contratoPF);
    //Avaliar   
    Assert.assertTrue(teste);
}

@Test(expected = ParseException.class)
public void CadastrarContratoPfTestDataInicioVazio() throws Exception{
    //Arrumar

    Date data = sdf.parse("");
    contratoPF.setClientePF(pf1);
    contratoPF.setIdContrato(1);
    contratoPF.setCobrePeca(true);
    contratoPF.setInicioContrato(data);
    contratoPF.setFimContrato(dataTeste3);
    contratoPF.setValor((float) 1000.00);
    contratoPF.setTotalEquipamento(10);
   //Agir
    boolean teste = nc.cadastrarContratoPF(contratoPF);
    //Avaliar   
    Assert.assertTrue(teste);
}

@Test(expected = ParseException.class)
public void CadastrarContratoPfTestDataFimVazio() throws Exception{
    //Arrumar
    Date data = sdf.parse("");
    contratoPF.setClientePF(pf1);
    contratoPF.setIdContrato(1);
    contratoPF.setCobrePeca(true);
    contratoPF.setInicioContrato(dataTeste1);
    contratoPF.setFimContrato(data);
    contratoPF.setValor((float) 1000.00);
    contratoPF.setTotalEquipamento(10);
   //Agir
    boolean teste = nc.cadastrarContratoPF(contratoPF);
    //Avaliar   
    Assert.assertTrue(teste);
}

@Test(expected = RuntimeException.class)
public void CadastrarContratoPfTestDataFimNull() throws Exception{
    //Arrumar
    Date data = sdf.parse(null);
    contratoPF.setClientePF(pf1);
    contratoPF.setIdContrato(1);
    contratoPF.setCobrePeca(true);
    contratoPF.setInicioContrato(dataTeste1);
    contratoPF.setFimContrato(data);
    contratoPF.setValor((float) 1000.00);
    contratoPF.setTotalEquipamento(10);
   //Agir
    boolean teste = nc.cadastrarContratoPF(contratoPF);
    //Avaliar   
    Assert.assertTrue(teste);
}

@Test(expected = RuntimeException.class)
public void CadastrarContratoPfTestDataInicioAfterFim() throws Exception{
    //Arrumar
    contratoPF.setClientePF(pf1);
    contratoPF.setIdContrato(1);
    contratoPF.setCobrePeca(true);
    contratoPF.setInicioContrato(dataTeste2);
    contratoPF.setFimContrato(dataTeste1);
    contratoPF.setValor((float) 1000.00);
    contratoPF.setTotalEquipamento(10);
   //Agir
    boolean teste = nc.cadastrarContratoPF(contratoPF);
    //Avaliar   
    Assert.assertTrue(teste);
}    

@Test(expected = RuntimeException.class)
public void CadastrarContratoPfTestDataInicioIgualFim() throws Exception{
    //Arrumar
    contratoPF.setClientePF(pf1);
    contratoPF.setIdContrato(1);
    contratoPF.setCobrePeca(true);
    contratoPF.setInicioContrato(dataTeste2);
    contratoPF.setFimContrato(dataTeste2);
    contratoPF.setValor((float) 1000.00);
    contratoPF.setTotalEquipamento(10);
   //Agir
    boolean teste = nc.cadastrarContratoPF(contratoPF);
    //Avaliar   
    Assert.assertTrue(teste);
}

@Test(expected = RuntimeException.class)
public void CadastrarContratoPfTestTotalEquipNegativo() throws Exception{
    //Arrumar
    contratoPF.setClientePF(pf1);
    contratoPF.setIdContrato(1);
    contratoPF.setCobrePeca(true);
    contratoPF.setInicioContrato(dataTeste1);
    contratoPF.setFimContrato(dataTeste2);
    contratoPF.setValor((float) 1000.00);
    contratoPF.setTotalEquipamento(-10);
   //Agir
    boolean teste = nc.cadastrarContratoPF(contratoPF);
    //Avaliar   
    Assert.assertTrue(teste);
}    
    
@Test(expected = RuntimeException.class)
public void CadastrarContratoPfTestTotalEquipZero() throws Exception{
    //Arrumar
    contratoPF.setClientePF(pf1);
    contratoPF.setIdContrato(1);
    contratoPF.setCobrePeca(true);
    contratoPF.setInicioContrato(dataTeste1);
    contratoPF.setFimContrato(dataTeste2);
    contratoPF.setValor((float) 1000.00);
    contratoPF.setTotalEquipamento(0);
   //Agir
    boolean teste = nc.cadastrarContratoPF(contratoPF);
    //Avaliar   
    Assert.assertTrue(teste);
}    

@Test(expected = RuntimeException.class)
public void CadastrarContratoPfTestValorContratoZero() throws Exception{
    //Arrumar
    contratoPF.setClientePF(pf1);
    contratoPF.setIdContrato(1);
    contratoPF.setCobrePeca(true);
    contratoPF.setInicioContrato(dataTeste1);
    contratoPF.setFimContrato(dataTeste2);
    contratoPF.setValor((float) 0);
    contratoPF.setTotalEquipamento(10);
   //Agir
    boolean teste = nc.cadastrarContratoPF(contratoPF);
    //Avaliar   
    Assert.assertTrue(teste);
} 

@Test(expected = RuntimeException.class)
public void CadastrarContratoPfTestValorContratoNegativo() throws Exception{
    //Arrumar
    contratoPF.setClientePF(pf1);
    contratoPF.setIdContrato(1);
    contratoPF.setCobrePeca(true);
    contratoPF.setInicioContrato(dataTeste1);
    contratoPF.setFimContrato(dataTeste2);
    contratoPF.setValor((float) -1000.00);
    contratoPF.setTotalEquipamento(10);
   //Agir
    boolean teste = nc.cadastrarContratoPF(contratoPF);
    //Avaliar   
    Assert.assertTrue(teste);
}

       //Início testes cadastrarContratoPj
    
@Test
public void CadastrarContratoPjTestOk() throws Exception{
    //Arrumar
    contratoPJ.setClientePJ(pj1);
    contratoPJ.setIdContrato(1);
    contratoPJ.setCobrePeca(true);
    contratoPJ.setInicioContrato(dataTeste1);
    contratoPJ.setFimContrato(dataTeste3);
    contratoPJ.setUmAtendimento(2);
    contratoPJ.setFimAtendimento(7);
    contratoPJ.setValor((float) 1000.00);
    contratoPJ.setTotalEquipamento(10);

   //Agir
    boolean teste = nc.cadastrarContratoPJ(contratoPJ);
    //Avaliar   
    Assert.assertTrue(teste);
}

@Test(expected = RuntimeException.class)
public void CadastrarContratoPJTestContratoNull() throws Exception{
    //Arrumar
    contratoPJ = null;
    //Agir
    boolean teste = nc.cadastrarContratoPJ(contratoPJ);
    //Avaliar
    Assert.assertTrue(teste);
}

@Test(expected = RuntimeException.class)
public void CadastrarContratoPJTestClienteNull() throws Exception{
    //Arrumar
    pj3 = null;
    contratoPJ.setClientePJ(pj3);
    //Agir
    boolean teste = nc.cadastrarContratoPJ(contratoPJ);
    //Avaliar
    Assert.assertTrue(teste);
}

@Test(expected = RuntimeException.class)
public void CadastrarContratoPjTestDataInicioNull() throws Exception{
    //Arrumar
    contratoPJ.setClientePJ(pj1);
    contratoPJ.setIdContrato(1);
    contratoPJ.setCobrePeca(true);
    contratoPJ.setInicioContrato(null);
    contratoPJ.setFimContrato(dataTeste3);
    contratoPJ.setValor((float) 1000.00);
    contratoPJ.setTotalEquipamento(10);
   //Agir
    boolean teste = nc.cadastrarContratoPJ(contratoPJ);
    //Avaliar   
    Assert.assertTrue(teste);
}

@Test(expected = RuntimeException.class)
public void CadastrarContratoPjTestDataFimNull() throws Exception{
    //Arrumar
     
    contratoPJ.setClientePJ(pj1);
    contratoPJ.setIdContrato(1);
    contratoPJ.setCobrePeca(true);
    contratoPJ.setInicioContrato(dataTeste1);
    contratoPJ.setFimContrato(null);
    contratoPJ.setValor((float) 1000.00);
    contratoPJ.setTotalEquipamento(10);
   //Agir
    boolean teste = nc.cadastrarContratoPJ(contratoPJ);
    //Avaliar   
    Assert.assertTrue(teste);
}

@Test(expected = RuntimeException.class)
public void CadastrarContratoPjTestDataInicioAfterFim() throws Exception{
    //Arrumar

    contratoPJ.setClientePJ(pj1);
    contratoPJ.setIdContrato(1);
    contratoPJ.setCobrePeca(true);
    contratoPJ.setInicioContrato(dataTeste3);
    contratoPJ.setFimContrato(dataTeste1);
    contratoPJ.setValor((float) 1000.00);
    contratoPJ.setTotalEquipamento(10);
   //Agir
    boolean teste = nc.cadastrarContratoPJ(contratoPJ);
    //Avaliar   
    Assert.assertTrue(teste);
}    

@Test(expected = RuntimeException.class)
public void CadastrarContratoPjTestDataInicioIgualFim() throws Exception{
    //Arrumar
 
    contratoPJ.setClientePJ(pj1);
    contratoPJ.setIdContrato(1);
    contratoPJ.setCobrePeca(true);
    contratoPJ.setInicioContrato(dataTeste2);
    contratoPJ.setFimContrato(dataTeste2);
    contratoPJ.setValor((float) 1000.00);
    contratoPJ.setTotalEquipamento(10);
   //Agir
    boolean teste = nc.cadastrarContratoPJ(contratoPJ);
    //Avaliar   
    Assert.assertTrue(teste);
}

@Test(expected = RuntimeException.class)
public void CadastrarContratoPjTestTotalEquipNegativo() throws Exception{
    //Arrumar

    contratoPJ.setClientePJ(pj1);
    contratoPJ.setIdContrato(1);
    contratoPJ.setCobrePeca(true);
    contratoPJ.setInicioContrato(dataTeste1);
    contratoPJ.setFimContrato(dataTeste3);
    contratoPJ.setValor((float) 1000.00);
    contratoPJ.setTotalEquipamento(-10);
   //Agir
    boolean teste = nc.cadastrarContratoPJ(contratoPJ);
    //Avaliar   
    Assert.assertTrue(teste);
}    
    
@Test(expected = RuntimeException.class)
public void CadastrarContratoPjTestTotalEquipZero() throws Exception{
    //Arrumar
     
    contratoPJ.setClientePJ(pj1);
    contratoPJ.setIdContrato(1);
    contratoPJ.setCobrePeca(true);
    contratoPJ.setInicioContrato(dataTeste1);
    contratoPJ.setFimContrato(dataTeste3);
    contratoPJ.setValor((float) 1000.00);
    contratoPJ.setTotalEquipamento(0);
   //Agir
    boolean teste = nc.cadastrarContratoPJ(contratoPJ);
    //Avaliar   
    Assert.assertTrue(teste);
}  

@Test(expected = RuntimeException.class)
public void CadastrarContratoPjTestValorContratoZero() throws Exception{
    //Arrumar
  
    contratoPJ.setClientePJ(pj1);
    contratoPJ.setIdContrato(1);
    contratoPJ.setCobrePeca(true);
    contratoPJ.setInicioContrato(dataTeste1);
    contratoPJ.setFimContrato(dataTeste3);
    contratoPJ.setValor((float) 0);
    contratoPJ.setTotalEquipamento(10);
   //Agir
    boolean teste = nc.cadastrarContratoPJ(contratoPJ);
    //Avaliar   
    Assert.assertTrue(teste);
} 

@Test(expected = RuntimeException.class)
public void CadastrarContratoPjTestValorContratoNegativo() throws Exception{
    //Arrumar

    contratoPJ.setClientePJ(pj1);
    contratoPJ.setIdContrato(1);
    contratoPJ.setCobrePeca(true);
    contratoPJ.setInicioContrato(dataTeste1);
    contratoPJ.setFimContrato(dataTeste3);
    contratoPJ.setValor((float) -1000.00);
    contratoPJ.setTotalEquipamento(10);
   //Agir
    boolean teste = nc.cadastrarContratoPJ(contratoPJ);
    //Avaliar   
    Assert.assertTrue(teste);  
}   


//alterarContratoPF
//Caminho feliz
@Test(expected = RuntimeException.class)
public void alterarContratoPfTestOk() throws Exception{
    //Arrumar
 
    contratoPF.setClientePF(pf2);
    contratoPF.setIdContrato(1);
    contratoPF.setCobrePeca(true);
    contratoPF.setInicioContrato(dataTeste1);
    contratoPF.setFimContrato(dataTeste3);
    contratoPF.setValor((float) 1000.00);
    contratoPF.setUmAtendimento(2);
    contratoPF.setFimAtendimento(7);
    contratoPF.setTotalEquipamento(10);

   //Agir
    boolean teste = nc.alterarContratoPF(contratoPF);
    //Avaliar   
    Assert.assertTrue(teste);
}
  
@Test(expected = RuntimeException.class)
public void alterarContratoPFTestContratoNull() throws Exception{
    //Arrumar
    contratoPF = null;
    //Agir
    boolean teste = nc.alterarContratoPF(contratoPF);
    //Avaliar
    Assert.assertTrue(teste);
}
   
@Test(expected = RuntimeException.class)
public void alterarContratoPfTestClienteNull() throws Exception{
    //Arrumar
    contratoPF.setClientePF(null);
    //Agir
    boolean teste = nc.alterarContratoPF(contratoPF);
    //Avaliar
    Assert.assertTrue(teste);
}

@Test(expected = RuntimeException.class)
public void alterarContratoPfTestDataInicioNull() throws Exception{
    //Arrumar
 
    Date data = sdf.parse(null);
    contratoPF.setClientePF(pf1);
    contratoPF.setIdContrato(1);
    contratoPF.setCobrePeca(true);
    contratoPF.setInicioContrato(data);
    contratoPF.setFimContrato(dataTeste3);
    contratoPF.setValor((float) 1000.00);
    contratoPF.setTotalEquipamento(10);
   //Agir
    boolean teste = nc.alterarContratoPF(contratoPF);
    //Avaliar   
    Assert.assertTrue(teste);
}

@Test(expected = ParseException.class)
public void alterarContratoPfTestDataInicioVazio() throws Exception{
    //Arrumar

    Date data = sdf.parse("");
    contratoPF.setClientePF(pf1);
    contratoPF.setIdContrato(1);
    contratoPF.setCobrePeca(true);
    contratoPF.setInicioContrato(data);
    contratoPF.setFimContrato(dataTeste3);
    contratoPF.setValor((float) 1000.00);
    contratoPF.setTotalEquipamento(10);
   //Agir
    boolean teste = nc.alterarContratoPF(contratoPF);
    //Avaliar   
    Assert.assertTrue(teste);
}

@Test(expected = ParseException.class)
public void alterarContratoPfTestDataFimVazio() throws Exception{
    //Arrumar

    Date data = sdf.parse("");
    contratoPF.setClientePF(pf1);
    contratoPF.setIdContrato(1);
    contratoPF.setCobrePeca(true);
    contratoPF.setInicioContrato(dataTeste1);
    contratoPF.setFimContrato(data);
    contratoPF.setValor((float) 1000.00);
    contratoPF.setTotalEquipamento(10);
   //Agir
    boolean teste = nc.alterarContratoPF(contratoPF);
    //Avaliar   
    Assert.assertTrue(teste);
}

@Test(expected = RuntimeException.class)
public void alterarContratoPfTestDataFimNull() throws Exception{
    //Arrumar
   
    Date data = sdf.parse(null);
    contratoPF.setClientePF(pf1);
    contratoPF.setIdContrato(1);
    contratoPF.setCobrePeca(true);
    contratoPF.setInicioContrato(dataTeste1);
    contratoPF.setFimContrato(data);
    contratoPF.setValor((float) 1000.00);
    contratoPF.setTotalEquipamento(10);
   //Agir
    boolean teste = nc.alterarContratoPF(contratoPF);
    //Avaliar   
    Assert.assertTrue(teste);
}

@Test(expected = RuntimeException.class)
public void alterarContratoPfTestDataInicioAfterFim() throws Exception{
    //Arrumar
   
    contratoPF.setClientePF(pf1);
    contratoPF.setIdContrato(1);
    contratoPF.setCobrePeca(true);
    contratoPF.setInicioContrato(dataTeste2);
    contratoPF.setFimContrato(dataTeste1);
    contratoPF.setValor((float) 1000.00);
    contratoPF.setTotalEquipamento(10);
   //Agir
    boolean teste = nc.alterarContratoPF(contratoPF);
    //Avaliar   
    Assert.assertTrue(teste);
}    

@Test(expected = RuntimeException.class)
public void alterarContratoPfTestDataInicioIgualFim() throws Exception{
    //Arrumar

    contratoPF.setClientePF(pf1);
    contratoPF.setIdContrato(1);
    contratoPF.setCobrePeca(true);
    contratoPF.setInicioContrato(dataTeste2);
    contratoPF.setFimContrato(dataTeste2);
    contratoPF.setValor((float) 1000.00);
    contratoPF.setTotalEquipamento(10);
   //Agir
    boolean teste = nc.alterarContratoPF(contratoPF);
    //Avaliar   
    Assert.assertTrue(teste);
}

@Test(expected = RuntimeException.class)
public void alterarContratoPfTestTotalEquipNegativo() throws Exception{
    //Arrumar

    contratoPF.setClientePF(pf1);
    contratoPF.setIdContrato(1);
    contratoPF.setCobrePeca(true);
    contratoPF.setInicioContrato(dataTeste1);
    contratoPF.setFimContrato(dataTeste2);
    contratoPF.setValor((float) 1000.00);
    contratoPF.setTotalEquipamento(-10);
   //Agir
    boolean teste = nc.alterarContratoPF(contratoPF);
    //Avaliar   
    Assert.assertTrue(teste);
}    
    
@Test(expected = RuntimeException.class)
public void alterarContratoPfTestTotalEquipZero() throws Exception{
    //Arrumar
   
    contratoPF.setClientePF(pf1);
    contratoPF.setIdContrato(1);
    contratoPF.setCobrePeca(true);
    contratoPF.setInicioContrato(dataTeste1);
    contratoPF.setFimContrato(dataTeste2);
    contratoPF.setValor((float) 1000.00);
    contratoPF.setTotalEquipamento(0);
   //Agir
    boolean teste = nc.alterarContratoPF(contratoPF);
    //Avaliar   
    Assert.assertTrue(teste);
}    

@Test(expected = RuntimeException.class)
public void alterarContratoPfTestValorContratoZero() throws Exception{
    //Arrumar
  
    contratoPF.setClientePF(pf1);
    contratoPF.setIdContrato(1);
    contratoPF.setCobrePeca(true);
    contratoPF.setInicioContrato(dataTeste1);
    contratoPF.setFimContrato(dataTeste2);
    contratoPF.setValor((float) 0);
    contratoPF.setTotalEquipamento(10);
   //Agir
    boolean teste = nc.alterarContratoPF(contratoPF);
    //Avaliar   
    Assert.assertTrue(teste);
} 

@Test(expected = RuntimeException.class)
public void alterarContratoPfTestValorContratoNegativo() throws Exception{
    //Arrumar

    contratoPF.setClientePF(pf1);
    contratoPF.setIdContrato(1);
    contratoPF.setCobrePeca(true);
    contratoPF.setInicioContrato(dataTeste1);
    contratoPF.setFimContrato(dataTeste2);
    contratoPF.setValor((float) -1000.00);
    contratoPF.setTotalEquipamento(10);
   //Agir
    boolean teste = nc.alterarContratoPF(contratoPF);
    //Avaliar   
    Assert.assertTrue(teste);
}


//alterarContratoPJ

@Test(expected = RuntimeException.class)
public void AlterarContratoPjTestOk() throws Exception{
    //Arrumar
    
    contratoPJ.setClientePJ(pj2);
    contratoPJ.setIdContrato(1);
    contratoPJ.setCobrePeca(true);
    contratoPJ.setInicioContrato(dataTeste1);
    contratoPJ.setFimContrato(dataTeste3);
    contratoPJ.setUmAtendimento(2);
    contratoPJ.setFimAtendimento(7);
    contratoPJ.setValor((float) 1000.00);
    contratoPJ.setTotalEquipamento(10);
    
   //Agir
    boolean teste = nc.alterarContratoPJ(contratoPJ);
    //Avaliar   
    Assert.assertTrue(teste);
}
  
@Test(expected = RuntimeException.class)
public void AlterarContratoPJTestContratoNull() throws Exception{
    //Arrumar
    contratoPJ = null;
    //Agir
    boolean teste = nc.alterarContratoPJ(contratoPJ);
    //Avaliar
    Assert.assertTrue(teste);
}

@Test(expected = RuntimeException.class)
public void alterarContratoPJTestClienteNull() throws Exception{
    //Arrumar
    contratoPJ.setClientePJ(null);
    //Agir
    boolean teste = nc.alterarContratoPJ(contratoPJ);
    //Avaliar
    Assert.assertTrue(teste);
}

@Test(expected = RuntimeException.class)
public void alterarContratoPjTestDataInicioNull() throws Exception{
    //Arrumar

    contratoPJ.setClientePJ(pj1);
    contratoPJ.setIdContrato(1);
    contratoPJ.setCobrePeca(true);
    contratoPJ.setInicioContrato(null);
    contratoPJ.setFimContrato(dataTeste3);
    contratoPJ.setValor((float) 1000.00);
    contratoPJ.setTotalEquipamento(10);
   //Agir
    boolean teste = nc.alterarContratoPJ(contratoPJ);
    //Avaliar   
    Assert.assertTrue(teste);
}

@Test(expected = RuntimeException.class)
public void alterarContratoPjTestDataFimNull() throws Exception{
    //Arrumar
   
    contratoPJ.setClientePJ(pj1);
    contratoPJ.setIdContrato(1);
    contratoPJ.setCobrePeca(true);
    contratoPJ.setInicioContrato(dataTeste1);
    contratoPJ.setFimContrato(null);
    contratoPJ.setValor((float) 1000.00);
    contratoPJ.setTotalEquipamento(10);
   //Agir
    boolean teste = nc.alterarContratoPJ(contratoPJ);
    //Avaliar   
    Assert.assertTrue(teste);
}

@Test(expected = RuntimeException.class)
public void alterarContratoPjTestDataInicioAfterFim() throws Exception{
    //Arrumar

    contratoPJ.setClientePJ(pj1);
    contratoPJ.setIdContrato(1);
    contratoPJ.setCobrePeca(true);
    contratoPJ.setInicioContrato(dataTeste3);
    contratoPJ.setFimContrato(dataTeste1);
    contratoPJ.setValor((float) 1000.00);
    contratoPJ.setTotalEquipamento(10);
   //Agir
    boolean teste = nc.alterarContratoPJ(contratoPJ);
    //Avaliar   
    Assert.assertTrue(teste);
}    

@Test(expected = RuntimeException.class)
public void alterarContratoPjTestDataInicioIgualFim() throws Exception{
    //Arrumar
 
    contratoPJ.setClientePJ(pj1);
    contratoPJ.setIdContrato(1);
    contratoPJ.setCobrePeca(true);
    contratoPJ.setInicioContrato(dataTeste2);
    contratoPJ.setFimContrato(dataTeste2);
    contratoPJ.setValor((float) 1000.00);
    contratoPJ.setTotalEquipamento(10);
   //Agir
    boolean teste = nc.alterarContratoPJ(contratoPJ);
    //Avaliar   
    Assert.assertTrue(teste);
}

@Test(expected = RuntimeException.class)
public void alterarContratoPjTestTotalEquipNegativo() throws Exception{
    //Arrumar
   
    contratoPJ.setClientePJ(pj1);
    contratoPJ.setIdContrato(1);
    contratoPJ.setCobrePeca(true);
    contratoPJ.setInicioContrato(dataTeste1);
    contratoPJ.setFimContrato(dataTeste3);
    contratoPJ.setValor((float) 1000.00);
    contratoPJ.setTotalEquipamento(-10);
   //Agir
    boolean teste = nc.alterarContratoPJ(contratoPJ);
    //Avaliar   
    Assert.assertTrue(teste);
}    
    
@Test(expected = RuntimeException.class)
public void alterarContratoPjTestTotalEquipZero() throws Exception{
    //Arrumar
     
    contratoPJ.setClientePJ(pj1);
    contratoPJ.setIdContrato(1);
    contratoPJ.setCobrePeca(true);
    contratoPJ.setInicioContrato(dataTeste1);
    contratoPJ.setFimContrato(dataTeste3);
    contratoPJ.setValor((float) 1000.00);
    contratoPJ.setTotalEquipamento(0);
   //Agir
    boolean teste = nc.alterarContratoPJ(contratoPJ);
    //Avaliar   
    Assert.assertTrue(teste);
} 

@Test(expected = RuntimeException.class)
public void alterarContratoPjTestValorContratoZero() throws Exception{
    //Arrumar

    contratoPJ.setClientePJ(pj1);
    contratoPJ.setIdContrato(1);
    contratoPJ.setCobrePeca(true);
    contratoPJ.setInicioContrato(dataTeste1);
    contratoPJ.setFimContrato(dataTeste3);
    contratoPJ.setValor((float) 0);
    contratoPJ.setTotalEquipamento(10);
   //Agir
    boolean teste = nc.alterarContratoPJ(contratoPJ);
    //Avaliar   
    Assert.assertTrue(teste);
} 

@Test(expected = RuntimeException.class)
public void alterarContratoPjTestValorContratoNegativo() throws Exception{
    //Arrumar
 
    contratoPJ.setClientePJ(pj1);
    contratoPJ.setIdContrato(1);
    contratoPJ.setCobrePeca(true);
    contratoPJ.setInicioContrato(dataTeste1);
    contratoPJ.setFimContrato(dataTeste3);
    contratoPJ.setValor((float) -1000.00);
    contratoPJ.setTotalEquipamento(10);
   //Agir
    boolean teste = nc.alterarContratoPJ(contratoPJ);
    //Avaliar   
    Assert.assertTrue(teste);
   
}   


//verificarDuplicidadeContrato
@Test(expected=RuntimeException.class)
public void verificarDuplicidadeContratoPfNulo() throws Exception{
   
  //arrumar
    ContratoPF cPF= new ContratoPF(null);
  //agir
    boolean teste =  nc.verificarDuplicidadeContratoPF(null);
  //avaliar
    Assert.assertTrue(teste);
}

@Test(expected=RuntimeException.class)
public void verificarDuplicidadeContratoPfDuplicado() throws Exception{
   //arrumar
    
  //agir
    boolean teste =  nc.verificarDuplicidadeContratoPF(contratoPF);
  //avaliar
    Assert.assertTrue(teste);
}

@Test(expected=RuntimeException.class)
public void verificarDuplicidadeContratoPfNovo() throws Exception{
  //arrumar
   
  //agir
    boolean teste =  nc.verificarDuplicidadeContratoPF(contratoPfNovo);
  //avaliar
    Assert.assertFalse(teste);
}


@Test(expected=RuntimeException.class)
public void verificarDuplicidadeContratoPjNull() throws Exception{
  //arrumar
    ContratoPJ cPj= new ContratoPJ(null); 
  //agir
    boolean teste =  nc.verificarDuplicidadeContratoPJ(cPj);
  //avaliar
    Assert.assertTrue(teste);
}

@Test(expected=RuntimeException.class)
public void verificarDuplicidadeContratoPjDuplicado() throws Exception{
 
  //agir
    boolean teste =  nc.verificarDuplicidadeContratoPJ(contratoPJ);
  //avaliar
    Assert.assertTrue(teste);
}

@Test(expected=RuntimeException.class)
public void verificarDuplicidadeContratoPjNovo() throws Exception{
    
  //agir
    boolean teste =  nc.verificarDuplicidadeContratoPJ(contratoPjNovo);
  //avaliar
    Assert.assertFalse(teste);
}

//verificarContrato
@Test(expected=RuntimeException.class)
public void verificarContratoPfNull() throws Exception{
    
  //arrumar
    contratoPF = null;
  //agir
    boolean teste =  nc.verificarContratoPF(null);
  //avaliar
    Assert.assertFalse(teste);
}

@Test(expected=RuntimeException.class)
public void verificarContratoPfExistente() throws Exception{
   
  //agir
    boolean teste =  nc.verificarContratoPF(contratoPF);
  //avaliar
    Assert.assertTrue(teste);
}

@Test(expected=RuntimeException.class)
public void verificarContratoPFInexistente() throws Exception{
    
  //agir
    boolean teste =  nc.verificarContratoPF(contratoPfNovo);
  //avaliar
    Assert.assertFalse(teste);
}

@Test(expected=RuntimeException.class)
public void verificarContratoPjNull() throws Exception{
   //arrumar 
    contratoPJ = null;
  //agir
    boolean teste =  nc.verificarContratoPJ(contratoPJ);
  //avaliar
    Assert.assertTrue(teste);
}

@Test(expected=RuntimeException.class)
public void verificarContratoPjExistente() throws Exception{
  
  //agir
    boolean teste =  nc.verificarContratoPJ(contratoPJ);
  //avaliar
    Assert.assertTrue(teste);
}

@Test(expected=RuntimeException.class)
public void verificarContratoPjInexistente() throws Exception{

  //agir
    boolean teste =  nc.verificarContratoPJ(contratoPjNovo);
  //avaliar
    Assert.assertFalse(teste);
}

//removerContratoPF
@Test(expected = RuntimeException.class)
public void removerContratoPFOk() throws Exception{
    
    contratoPF.setClientePF(pf1);
    contratoPF.setIdContrato(1);
    contratoPF.setCobrePeca(true);
    contratoPF.setInicioContrato(dataTeste1);
    contratoPF.setFimContrato(dataTeste3);
    contratoPF.setValor((float) 1000.00);
    contratoPF.setUmAtendimento(2);
    contratoPF.setFimAtendimento(7);
    contratoPF.setTotalEquipamento(10);
    
   //Agir
    boolean teste = nc.removerContratoPF(contratoPF);
    //Avaliar   
    Assert.assertTrue(teste);
}

@Test(expected = RuntimeException.class)
public void removerContratoPFInexistente() throws Exception{
    
   //Agir
    boolean teste = nc.removerContratoPF(contratoPF);
    //Avaliar   
    Assert.assertTrue(teste);
}

@Test(expected=RuntimeException.class)
public void removerContratoPFContratoNull() throws Exception{
    contratoPF = null;
   //Agir
    boolean teste = nc.removerContratoPF(contratoPF);
    //Avaliar   
    Assert.assertTrue(teste);
}

@Test(expected=RuntimeException.class)
public void removerContratoPFClienteNull() throws Exception{
    contratoPF.setClientePF(null);
   //Agir
    boolean teste = nc.removerContratoPF(contratoPF);
    //Avaliar   
    Assert.assertTrue(teste);
}

@Test(expected=RuntimeException.class)
public void removerContratoPFIdNegativo() throws Exception{
   
    contratoPF.setClientePF(pf1);
    contratoPF.setIdContrato(-1);
    contratoPF.setCobrePeca(true);
    contratoPF.setInicioContrato(dataTeste1);
    contratoPF.setFimContrato(dataTeste3);
    contratoPF.setValor((float) 1000.00);
    contratoPF.setUmAtendimento(2);
    contratoPF.setFimAtendimento(7);
    contratoPF.setTotalEquipamento(10);
   //Agir
    boolean teste = nc.removerContratoPF(contratoPF);
    //Avaliar   
    Assert.assertTrue(teste);
}

@Test(expected=RuntimeException.class)
public void removerContratoPFIdZero() throws Exception{
 
    contratoPF.setClientePF(pf1);
    contratoPF.setIdContrato(0);
    contratoPF.setCobrePeca(true);
    contratoPF.setInicioContrato(dataTeste1);
    contratoPF.setFimContrato(dataTeste3);
    contratoPF.setValor((float) 1000.00);
    contratoPF.setUmAtendimento(2);
    contratoPF.setFimAtendimento(7);
    contratoPF.setTotalEquipamento(10);
   //Agir
    boolean teste = nc.removerContratoPF(contratoPF);
    //Avaliar   
    Assert.assertTrue(teste);
}

@Test(expected = RuntimeException.class)
public void removerContratoPJOk() throws Exception{
   
    contratoPJ.setClientePJ(pj1);
    contratoPJ.setIdContrato(1);
    contratoPJ.setCobrePeca(true);
    contratoPJ.setInicioContrato(dataTeste1);
    contratoPJ.setFimContrato(dataTeste3);
    contratoPJ.setValor((float) 1000.00);
    contratoPJ.setUmAtendimento(2);
    contratoPJ.setFimAtendimento(7);
    contratoPJ.setTotalEquipamento(10);
    
   //Agir
    boolean teste = nc.removerContratoPJ(contratoPJ);
    //Avaliar   
    Assert.assertTrue(teste);
}

@Test(expected = RuntimeException.class)
public void removerContratoPJInexistente() throws Exception{
    
   //Agir
    boolean teste = nc.removerContratoPJ(contratoPjNovo);
    //Avaliar   
    Assert.assertTrue(teste);
}

@Test(expected=RuntimeException.class)
public void removerContratoPJContratoNull() throws Exception{
    contratoPJ = null;
   //Agir
    boolean teste = nc.removerContratoPJ(contratoPJ);
    //Avaliar   
    Assert.assertTrue(teste);
}

@Test(expected=RuntimeException.class)
public void removerContratoPJClienteNull() throws Exception{
    contratoPJ.setClientePJ(null);
   //Agir
    boolean teste = nc.removerContratoPJ(contratoPJ);
    //Avaliar   
    Assert.assertTrue(teste);
}

@Test(expected=RuntimeException.class)
public void removerContratoPJIdNegativo() throws Exception{
 
    contratoPJ.setClientePJ(pj1);
    contratoPJ.setIdContrato(-1);
    contratoPJ.setCobrePeca(true);
    contratoPJ.setInicioContrato(dataTeste1);
    contratoPJ.setFimContrato(dataTeste3);
    contratoPJ.setValor((float) 1000.00);
    contratoPJ.setUmAtendimento(2);
    contratoPJ.setFimAtendimento(7);
    contratoPJ.setTotalEquipamento(10);
   //Agir
    boolean teste = nc.removerContratoPJ(contratoPJ);
    //Avaliar   
    Assert.assertTrue(teste);
}

@Test(expected=RuntimeException.class)
public void removerContratoPJIdZero() throws Exception{
   
    contratoPJ.setClientePJ(pj1);
    contratoPJ.setIdContrato(0);
    contratoPJ.setCobrePeca(true);
    contratoPJ.setInicioContrato(dataTeste1);
    contratoPJ.setFimContrato(dataTeste3);
    contratoPJ.setValor((float) 1000.00);
    contratoPJ.setUmAtendimento(2);
    contratoPJ.setFimAtendimento(7);
    contratoPJ.setTotalEquipamento(10);
   //Agir
    boolean teste = nc.removerContratoPJ(contratoPJ);
    //Avaliar   
    Assert.assertTrue(teste);
}
}




    
    
    
    
    
    
    
    
    
    
    
    
    
