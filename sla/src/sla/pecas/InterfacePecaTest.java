/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sla.pecas;

import java.util.ArrayList;

/**
 *
 * @author badop
 */
public interface InterfacePecaTest {
    
    boolean cadastrarPeca(Peca peca) throws Exception;

    ArrayList<Peca> consultarPeca(Peca peca) throws Exception;

    boolean removerPecaCod(Peca peca) throws Exception;

    boolean alterarPeca(Peca peca) throws Exception;

    boolean verificaDuplicidadePeca(Peca filtro) throws Exception;

    ArrayList<Peca> listarPeca(Peca filtro) throws Exception;
    
}
