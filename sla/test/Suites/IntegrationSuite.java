/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Suites;

import cliente.ClienteIntTest;
import contrato.ContratoIntegrationTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import peca.PecaIntTest;
import servico.ServicoIntTest;

/**
 *
 * @author cffbs
 */
@RunWith(Suite.class)
@SuiteClasses({ContratoIntegrationTest.class, ClienteIntTest.class, PecaIntTest.class, ServicoIntTest.class})
public class IntegrationSuite {
    
}
