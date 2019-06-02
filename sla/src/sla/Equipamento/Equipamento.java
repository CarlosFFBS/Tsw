/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sla.Equipamento;

import sla.contrato.Contrato;


/**
 *
 * @author Fabiano
 */
public class Equipamento {

    private String serial;
    private String descricao;
    private int codigo;
    private Contrato contrato;

  
    public String getSerial() {
        return serial;
    }


    public void setSerial(String serial) {
        this.serial = serial;
    }


    public String getDescricao() {
        return descricao;
    }

  
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

 
    public Contrato getContrato() {
        return contrato;
    }

 
    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

  

}
