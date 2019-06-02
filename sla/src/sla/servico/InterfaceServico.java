/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sla.servico;

import java.util.ArrayList;
import sla.pecas.Peca;

/**
 *
 * @author Fabiano
 */
public interface InterfaceServico {

    void cadastrarServico(Servico servico) throws Exception;

    ArrayList<Servico> consultarServico(Servico servico) throws Exception;

    void removerServicoCod(Servico servico) throws Exception;

    void alterarServico(Servico servico) throws Exception;

    boolean verificaDuplicidadeServico(Servico filtro) throws Exception;

    ArrayList<Servico> listarServico() throws Exception;

}
