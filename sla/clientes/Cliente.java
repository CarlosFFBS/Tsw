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
public abstract class Cliente {

    private Integer cli_Codigo;
    private String logradouro;
    private String numeroLogradouro;
    private String complemento;
    private String bairro;
    private String cep;
    private String cidade;
    private String estado;
    private String email;
    private String telefone;

    public Cliente() {
    }

    public Integer getCli_Codigo() {
        return cli_Codigo;
    }

    public void setCli_Codigo(Integer cli_Codigo) {
        this.cli_Codigo = cli_Codigo;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumeroLogradouro() {
        return numeroLogradouro;
    }

    public void setNumeroLogradouro(String numeroLogradouro) {
        this.numeroLogradouro = numeroLogradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    /*
    public ClientePessoaFisica getClientePF() {
        return clientePF;
    }

    public void setClientePF(ClientePessoaFisica clientePF) {
        this.clientePF = clientePF;
    }

    public ClientePessoaJuridica getClientePJ() {
        return clientePJ;
    }

    public void setClientePJ(ClientePessoaJuridica clientePJ) {
        this.clientePJ = clientePJ;

    }
     */
}
