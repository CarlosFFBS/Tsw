/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sla.pecas;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Consultor SCA 02
 */
public interface InterfacePecaSigns {

    void cadastrarPeca(Peca peca) throws Exception;

    ArrayList<Peca> consultarPeca(Peca peca) throws Exception;

    void removerPecaCod(Peca peca) throws Exception;

    void alterarPeca(Peca peca) throws Exception;

    boolean verificaDuplicidadePeca(Peca filtro) throws Exception;

    ArrayList<Peca> listarPeca(Peca filtro) throws Exception;
}
