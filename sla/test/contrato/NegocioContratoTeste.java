package contrato;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import sla.clientes.ClientePessoaFisica;
import sla.clientes.ClientePessoaJuridica;
import sla.contrato.ContratoPF;
import sla.contrato.ContratoPJ;
import sla.contrato.DadosContrato;
import sla.contrato.NegocioContrato;

    


/**
 *
 * @author cffbs
 */
public class NegocioContratoTeste {
    NegocioContrato nc;
    ContratoPF contratoPF;
    ContratoPF contratoPfNovo;
    ContratoPJ contratoPjNovo;
    ContratoPJ contratoPJ;
    ClientePessoaFisica pf;
    ClientePessoaJuridica pj;
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
        pf = new ClientePessoaFisica();
        pj = new ClientePessoaJuridica();
        
        nc = new NegocioContrato();
       
        sdf = new SimpleDateFormat("dd/MM/yyyy");
        dataTeste1 = sdf.parse("01/01/2018");
        dataTeste2 = sdf.parse("01/01/2019");
        dataTeste3 = sdf.parse("01/01/2020");
      }
    
     //Classes equivalencias CadastrarContrato:
    
//Caminho feliz
@Test(expected = RuntimeException.class)
public void CadastrarContratoPfTestOk() throws Exception{
    //Arrumar
    
    contratoPF.setClientePF(pf);
    contratoPF.setIdContrato(1);
    contratoPF.setCobrePeca(true);
    contratoPF.setInicioContrato(dataTeste1);
    contratoPF.setFimContrato(dataTeste3);
    contratoPF.setValor((float) 1000.00);
    contratoPF.setUmAtendimento(2);
    contratoPF.setFimAtendimento(7);
    contratoPF.setTotalEquipamento(10);
    DadosContrato dao = mock(DadosContrato.class);
    when(dao.verificarDuplicidadeContratoPF(contratoPF)).thenReturn(Boolean.FALSE);
    when(dao.cadastrarContratoPF(contratoPF)).thenReturn(Boolean.TRUE);
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
    contratoPF.setClientePF(null);
    //Agir
    boolean teste = nc.cadastrarContratoPF(contratoPF);
    //Avaliar
    Assert.assertTrue(teste);
}

@Test(expected = RuntimeException.class)
public void CadastrarContratoPfTestDataInicioNull() throws Exception{
    //Arrumar
    Date data = sdf.parse(null);
    contratoPF.setClientePF(pf);
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
    contratoPF.setClientePF(pf);
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
    contratoPF.setClientePF(pf);
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
    contratoPF.setClientePF(pf);
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
    contratoPF.setClientePF(pf);
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
    contratoPF.setClientePF(pf);
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
    contratoPF.setClientePF(pf);
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
    contratoPF.setClientePF(pf);
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
    contratoPF.setClientePF(pf);
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
    contratoPF.setClientePF(pf);
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

@Test(expected = RuntimeException.class)
public void CadastrarContratoPjTestOk() throws Exception{
    //Arrumar
    contratoPJ.setClientePJ(pj);
    contratoPJ.setIdContrato(1);
    contratoPJ.setCobrePeca(true);
    contratoPJ.setInicioContrato(dataTeste1);
    contratoPJ.setFimContrato(dataTeste3);
    contratoPJ.setUmAtendimento(2);
    contratoPJ.setFimAtendimento(7);
    contratoPJ.setValor((float) 1000.00);
    contratoPJ.setTotalEquipamento(10);
    DadosContrato dao = mock(DadosContrato.class);
    when(dao.verificarDuplicidadeContratoPJ(contratoPJ)).thenReturn(Boolean.FALSE);
    when(dao.cadastrarContratoPJ(contratoPJ)).thenReturn(Boolean.TRUE);
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
    contratoPJ.setClientePJ(null);
    //Agir
    boolean teste = nc.cadastrarContratoPJ(contratoPJ);
    //Avaliar
    Assert.assertTrue(teste);
}

@Test(expected = RuntimeException.class)
public void CadastrarContratoPjTestDataInicioNull() throws Exception{
    //Arrumar
    contratoPJ.setClientePJ(pj);
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
     
    contratoPJ.setClientePJ(pj);
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

    contratoPJ.setClientePJ(pj);
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
 
    contratoPJ.setClientePJ(pj);
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

    contratoPJ.setClientePJ(pj);
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
     
    contratoPJ.setClientePJ(pj);
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
  
    contratoPJ.setClientePJ(pj);
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

    contratoPJ.setClientePJ(pj);
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
 
    contratoPF.setClientePF(pf);
    contratoPF.setIdContrato(1);
    contratoPF.setCobrePeca(true);
    contratoPF.setInicioContrato(dataTeste1);
    contratoPF.setFimContrato(dataTeste3);
    contratoPF.setValor((float) 1000.00);
    contratoPF.setUmAtendimento(2);
    contratoPF.setFimAtendimento(7);
    contratoPF.setTotalEquipamento(10);
    DadosContrato dao = mock(DadosContrato.class);
    when(dao.verificarDuplicidadeContratoPF(contratoPF)).thenReturn(Boolean.FALSE);
    when(dao.alterarContratoPF(contratoPF)).thenReturn(Boolean.TRUE);
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
    contratoPF.setClientePF(pf);
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
    contratoPF.setClientePF(pf);
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
    contratoPF.setClientePF(pf);
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
    contratoPF.setClientePF(pf);
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
   
    contratoPF.setClientePF(pf);
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

    contratoPF.setClientePF(pf);
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

    contratoPF.setClientePF(pf);
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
   
    contratoPF.setClientePF(pf);
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
  
    contratoPF.setClientePF(pf);
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

    contratoPF.setClientePF(pf);
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
    
    contratoPJ.setClientePJ(pj);
    contratoPJ.setIdContrato(1);
    contratoPJ.setCobrePeca(true);
    contratoPJ.setInicioContrato(dataTeste1);
    contratoPJ.setFimContrato(dataTeste3);
    contratoPJ.setUmAtendimento(2);
    contratoPJ.setFimAtendimento(7);
    contratoPJ.setValor((float) 1000.00);
    contratoPJ.setTotalEquipamento(10);
    DadosContrato dao = mock(DadosContrato.class);
    when(dao.verificarDuplicidadeContratoPJ(contratoPJ)).thenReturn(Boolean.FALSE);
    when(dao.alterarContratoPJ(contratoPJ)).thenReturn(Boolean.TRUE);
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

    contratoPJ.setClientePJ(pj);
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
   
    contratoPJ.setClientePJ(pj);
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

    contratoPJ.setClientePJ(pj);
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
 
    contratoPJ.setClientePJ(pj);
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
   
    contratoPJ.setClientePJ(pj);
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
     
    contratoPJ.setClientePJ(pj);
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

    contratoPJ.setClientePJ(pj);
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
 
    contratoPJ.setClientePJ(pj);
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
    ContratoPF cPF= new ContratoPF(null);
  //arrumar
    DadosContrato dc = mock(DadosContrato.class);
    when(dc.verificarDuplicidadeContratoPF(cPF)).thenThrow(RuntimeException.class);
  //agir
    boolean teste =  nc.verificarDuplicidadeContratoPF(null);
  //avaliar
    Assert.assertTrue(teste);
}

@Test(expected=RuntimeException.class)
public void verificarDuplicidadeContratoPfDuplicado() throws Exception{
    //arrumar
    DadosContrato dc = mock(DadosContrato.class);
    when(dc.verificarDuplicidadeContratoPF(contratoPF)).thenReturn(Boolean.TRUE);
  //agir
    boolean teste =  nc.verificarDuplicidadeContratoPF(contratoPF);
  //avaliar
    Assert.assertTrue(teste);
}

@Test(expected=RuntimeException.class)
public void verificarDuplicidadeContratoPfNovo() throws Exception{
  //arrumar
    DadosContrato dc = mock(DadosContrato.class);
    when(dc.verificarDuplicidadeContratoPF(contratoPfNovo)).thenReturn(Boolean.FALSE);
  //agir
    boolean teste =  nc.verificarDuplicidadeContratoPF(contratoPfNovo);
  //avaliar
    Assert.assertFalse(teste);
}


@Test(expected=RuntimeException.class)
public void verificarDuplicidadeContratoPjNull() throws Exception{
    ContratoPJ cPj= new ContratoPJ(null);
    
    DadosContrato dc = mock(DadosContrato.class);
    when(dc.verificarDuplicidadeContratoPJ(null)).thenThrow(RuntimeException.class);
    
  //agir
    boolean teste =  nc.verificarDuplicidadeContratoPJ(cPj);
  //avaliar
    Assert.assertTrue(teste);
}

@Test(expected=RuntimeException.class)
public void verificarDuplicidadeContratoPjDuplicado() throws Exception{
    DadosContrato dc = mock(DadosContrato.class);
    when(dc.verificarDuplicidadeContratoPJ(contratoPJ)).thenReturn(Boolean.TRUE);
  //agir
    boolean teste =  nc.verificarDuplicidadeContratoPJ(contratoPJ);
  //avaliar
    Assert.assertTrue(teste);
}

@Test(expected=RuntimeException.class)
public void verificarDuplicidadeContratoPjNovo() throws Exception{
    DadosContrato dc = mock(DadosContrato.class);
    when(dc.verificarDuplicidadeContratoPJ(contratoPjNovo)).thenReturn(Boolean.FALSE);
  //agir
    boolean teste =  nc.verificarDuplicidadeContratoPJ(contratoPjNovo);
  //avaliar
    Assert.assertFalse(teste);
}

//verificarContrato
@Test(expected=RuntimeException.class)
public void verificarContratoPfNull() throws Exception{
    contratoPF = null;
  //arrumar
    DadosContrato dc = mock(DadosContrato.class);
    when(dc.verificarContratoPF(contratoPF)).thenThrow(RuntimeException.class);
  //agir
    boolean teste =  nc.verificarContratoPF(null);
  //avaliar
    Assert.assertFalse(teste);
}

@Test(expected=RuntimeException.class)
public void verificarContratoPfExistente() throws Exception{
    DadosContrato dc = mock(DadosContrato.class);
    when(dc.verificarContratoPF(contratoPF)).thenReturn(Boolean.TRUE);
  //agir
    boolean teste =  nc.verificarContratoPF(contratoPF);
  //avaliar
    Assert.assertTrue(teste);
}

@Test(expected=RuntimeException.class)
public void verificarContratoPFInexistente() throws Exception{
    DadosContrato dc = mock(DadosContrato.class);
    when(dc.verificarDuplicidadeContratoPF(contratoPfNovo)).thenReturn(Boolean.FALSE);
  //agir
    boolean teste =  nc.verificarContratoPF(contratoPfNovo);
  //avaliar
    Assert.assertFalse(teste);
}

@Test(expected=RuntimeException.class)
public void verificarContratoPjNull() throws Exception{
    contratoPJ = null;
    DadosContrato dc = mock(DadosContrato.class);
    when(dc.verificarContratoPJ(contratoPJ)).thenThrow(RuntimeException.class);
  //agir
    boolean teste =  nc.verificarContratoPJ(contratoPJ);
  //avaliar
    Assert.assertTrue(teste);
}

@Test(expected=RuntimeException.class)
public void verificarContratoPjExistente() throws Exception{
    DadosContrato dc = mock(DadosContrato.class);
    when(dc.verificarContratoPJ(contratoPJ)).thenReturn(Boolean.TRUE);
  //agir
    boolean teste =  nc.verificarContratoPJ(contratoPJ);
  //avaliar
    Assert.assertTrue(teste);
}

@Test(expected=RuntimeException.class)
public void verificarContratoPjInexistente() throws Exception{
    DadosContrato dc = mock(DadosContrato.class);
    when(dc.verificarDuplicidadeContratoPJ(contratoPjNovo)).thenReturn(Boolean.FALSE);
  //agir
    boolean teste =  nc.verificarContratoPJ(contratoPjNovo);
  //avaliar
    Assert.assertFalse(teste);
}

//removerContratoPF
@Test(expected = RuntimeException.class)
public void removerContratoPFOk() throws Exception{
    
    contratoPF.setClientePF(pf);
    contratoPF.setIdContrato(1);
    contratoPF.setCobrePeca(true);
    contratoPF.setInicioContrato(dataTeste1);
    contratoPF.setFimContrato(dataTeste3);
    contratoPF.setValor((float) 1000.00);
    contratoPF.setUmAtendimento(2);
    contratoPF.setFimAtendimento(7);
    contratoPF.setTotalEquipamento(10);
    DadosContrato dao = mock(DadosContrato.class);
    when(dao.verificarDuplicidadeContratoPF(contratoPF)).thenReturn(Boolean.TRUE);
    when(dao.removerContratoPF(contratoPF)).thenReturn(Boolean.TRUE);
    
   //Agir
    boolean teste = nc.removerContratoPF(contratoPF);
    //Avaliar   
    Assert.assertTrue(teste);
}

@Test(expected = RuntimeException.class)
public void removerContratoPFInexistente() throws Exception{
    DadosContrato dao = mock(DadosContrato.class);
    when(dao.verificarDuplicidadeContratoPF(contratoPfNovo)).thenReturn(Boolean.FALSE);
    when(dao.removerContratoPF(contratoPF)).thenReturn(Boolean.TRUE);
    
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
   
    contratoPF.setClientePF(pf);
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
 
    contratoPF.setClientePF(pf);
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
   
    contratoPJ.setClientePJ(pj);
    contratoPJ.setIdContrato(1);
    contratoPJ.setCobrePeca(true);
    contratoPJ.setInicioContrato(dataTeste1);
    contratoPJ.setFimContrato(dataTeste3);
    contratoPJ.setValor((float) 1000.00);
    contratoPJ.setUmAtendimento(2);
    contratoPJ.setFimAtendimento(7);
    contratoPJ.setTotalEquipamento(10);
    DadosContrato dao = mock(DadosContrato.class);
    when(dao.verificarDuplicidadeContratoPJ(contratoPJ)).thenReturn(Boolean.FALSE);
    when(dao.removerContratoPJ(contratoPJ)).thenReturn(Boolean.TRUE);
   //Agir
    boolean teste = nc.removerContratoPJ(contratoPJ);
    //Avaliar   
    Assert.assertTrue(teste);
}

@Test(expected = RuntimeException.class)
public void removerContratoPJInexistente() throws Exception{
    DadosContrato dao = mock(DadosContrato.class);
    when(dao.verificarDuplicidadeContratoPJ(contratoPjNovo)).thenReturn(Boolean.FALSE);
    when(dao.removerContratoPJ(contratoPjNovo)).thenReturn(Boolean.TRUE);
    
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
 
    contratoPJ.setClientePJ(pj);
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
   
    contratoPJ.setClientePJ(pj);
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


@Test(expected=RuntimeException.class)
public void consultarContratoPJContratoNull() throws Exception{
    contratoPJ = null;
    boolean teste;
    DadosContrato dc = mock(DadosContrato.class);
    when(dc.consultarPJContrato(contratoPJ)).thenThrow(RuntimeException.class);
  //agir
    ArrayList<ContratoPJ> lista = new ArrayList<>();
    lista =  nc.consultarPJContrato(contratoPJ);
    if(lista.isEmpty()){
        teste = false;
    }else{
        teste = true;
    }
  //avaliar
    Assert.assertTrue(teste);
}

@Test(expected=RuntimeException.class)
public void consultarContratoPjExistente() throws Exception{
    boolean teste2;
    ArrayList<ContratoPJ> lista = new ArrayList<>();
    lista.add(contratoPJ);
    DadosContrato dc = mock(DadosContrato.class);
    when(dc.consultarPJContrato(contratoPJ)).thenReturn(lista);
  //agir
  if(lista.isEmpty()){
        teste2 = false;
    }else{
        teste2 = true;
    }
  //avaliar
    Assert.assertTrue(teste2);
}

@Test(expected=RuntimeException.class)
public void ConsultarContratoPjInexistente() throws Exception{
    boolean teste3;
    ArrayList<ContratoPJ> lista = new ArrayList<>();
    DadosContrato dc = mock(DadosContrato.class);
    when(dc.consultarPJContrato(contratoPjNovo)).thenReturn(lista);
  //agir
    if(lista.isEmpty()){
        teste3 = true;
    }else{
        teste3 = false;
    }
  //avaliar
    Assert.assertTrue(teste3);
}

   
}
