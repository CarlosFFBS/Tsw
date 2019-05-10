/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sla.contrato;

import sla.clientes.ClientePessoaFisica;

/**
 *
 * @author Fabiano
 */
public class ContratoPF extends Contrato {

    private ClientePessoaFisica clientePF;

    public ContratoPF() {
    }

    public ContratoPF(ClientePessoaFisica clientePF) {
        this.clientePF = clientePF;
    }

    /**
     * @return the clientePF
     */
    public ClientePessoaFisica getClientePF() {
        return clientePF;
    }

    /**
     * @param clientePF the clientePF to set
     */
    public void setClientePF(ClientePessoaFisica clientePF) {
        this.clientePF = clientePF;
    }
}
