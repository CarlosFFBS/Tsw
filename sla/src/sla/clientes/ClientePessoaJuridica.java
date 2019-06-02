/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sla.clientes;

/**
 *
 * @author Consultor SCA 02
 */
public class ClientePessoaJuridica extends Cliente {

    private String cli_Cnpj;
    private String razaoSocial;

    public ClientePessoaJuridica() {
    }

    public String getCli_Cnpj() {
        return cli_Cnpj;
    }

    public void setCli_Cnpj(String cli_Cnpj) {
        this.cli_Cnpj = cli_Cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

}
