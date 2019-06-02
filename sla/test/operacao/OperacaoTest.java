/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operacao;

import java.util.Date;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;
import sla.clientes.Cliente;
import sla.clientes.ClientePessoaFisica;
import sla.operacoes.Operacao;

/**
 *
 * @author badop
 */
public class OperacaoTest {

    Operacao op;

    @Before
    public void setUp() {
        //Instanciando objeto a ser utilizado nos testes.. 
        op = new Operacao();
    }

    //Testando fluxo do método formatando preço com virgula para ponto
    @Test
    public void formatadorVirgulaPontoPrecoTest() throws Exception {
        String var = "10,0";
        float result = op.formatadorVirgulaParaPonto(var);
        assertEquals(10.0, result);
    }

    //testando método passando preço com 2 vírgulas
    @Test(expected = NumberFormatException.class)
    public void formatadorVirgulaPontoPrecoInvalido() throws Exception {
        String var = "10,,0";
        op.formatadorVirgulaParaPonto(var);
        fail();
    }

    //testando método passando cep com 5 caracteres
    @Test(expected = RuntimeException.class)
    public void formataCepInvalido() throws Exception {
        String cep = "54";
        op.formataCEP(cep);
        fail();
    }

    //testando fluxo método recebendo cep com 8 caracteres
    @Test
    public void formataCepTest() throws Exception {
        String var = "54410010";
        var = op.formataCEP(var);
        assertEquals(new String("54.410-010"), var);
    }
    
    //testando parsing de data util.Date para data sql.Date
    @Test
    public void formataUtilTest() throws Exception {
        java.util.Date date1 ;
        java.sql.Date date2= new java.sql.Date(2019, 4, 11);
        date1 = op.dataSqlJava(date2);
        assertEquals(new java.util.Date(2019, 4, 11), date1);
    }
    
     //testando parsing de datasql.Date  para data util.Date
    @Test
    public void formataSqlTest() throws Exception {
        java.util.Date date1= new java.util.Date(2019, 4, 11);
        java.sql.Date date2 ;
        date2 = op.dataJavaSql(date1);
        assertEquals(new java.sql.Date(2019, 4, 11), date2);
    }

}
