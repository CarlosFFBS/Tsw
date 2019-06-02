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
public class ClientePessoaFisica extends Cliente {

    private String cli_Cpf;
    private String nome;
    private String Sexo;

    public ClientePessoaFisica() {

    }

    public String getCli_Cpf() {
        return cli_Cpf;
    }

    public void setCli_Cpf(String cli_Cpf) {
      this.cli_Cpf = cli_Cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }

}
