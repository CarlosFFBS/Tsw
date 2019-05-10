/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sla.clientes;

import java.util.ArrayList;

/**
 *
 * @author Consultor SCA 02
 */
public interface InterfaceClienteSigns {

    void cadastrarClientePF(ClientePessoaFisica clientePF) throws Exception;

    void cadastrarClientePJ(ClientePessoaJuridica clientePJ) throws Exception;

    int consultaCodClientePF(ClientePessoaFisica clientePF) throws Exception;

    int consultaCodClientePJ(ClientePessoaJuridica clientePJ) throws Exception;

    ArrayList<ClientePessoaFisica> consultarClientePF(ClientePessoaFisica cliente) throws Exception;

    ArrayList<ClientePessoaJuridica> consultarClientePJ(ClientePessoaJuridica cliente) throws Exception;

    ArrayList<ClientePessoaFisica> listarClientePF() throws Exception;

    ArrayList<ClientePessoaJuridica> listarClientePJ() throws Exception;

    void removerClientePFCod(ClientePessoaFisica cliente) throws Exception;

    void removerClientePJCod(ClientePessoaJuridica cliente) throws Exception;

    void alterarClientePF(ClientePessoaFisica cliente) throws Exception;

    void alterarClientePJ(ClientePessoaJuridica cliente) throws Exception;

    boolean verificaDuplicidadeClientePF(ClientePessoaFisica filtroPF) throws Exception;

    boolean verificaDuplicidadeClientePJ(ClientePessoaJuridica filtroPJ) throws Exception;

}
