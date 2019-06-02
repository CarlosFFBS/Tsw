/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sla.contrato;

import sla.clientes.ClientePessoaJuridica;

/**
 *
 * @author Fabiano
 */
public class ContratoPJ extends Contrato{
     private ClientePessoaJuridica clientePJ;

     
     
    public ContratoPJ(ClientePessoaJuridica clientePJ) {
        this.clientePJ = clientePJ;
    }

    public ContratoPJ() {
    }

    /**
     * @return the clientePJ
     */
    public ClientePessoaJuridica getClientePJ() {
        return clientePJ;
    }

    /**
     * @param clientePJ the clientePJ to set
     */
    public void setClientePJ(ClientePessoaJuridica clientePJ) {
        this.clientePJ = clientePJ;
    }
}
