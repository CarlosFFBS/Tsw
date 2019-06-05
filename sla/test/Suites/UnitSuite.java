/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Suites;

import cliente.ClienteUnitTest;
import contrato.NegocioContratoTeste;
import operacao.OperacaoTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import peca.PecaFormTest;
import peca.PecaUnitTest;
import servico.ServicoUnitTest;

/**
 *
 * @author cffbs
 */
@RunWith(Suite.class)
@SuiteClasses({NegocioContratoTeste.class, ClienteUnitTest.class, OperacaoTest.class, PecaFormTest.class, PecaUnitTest.class, ServicoUnitTest.class})
public class UnitSuite {
    
}
