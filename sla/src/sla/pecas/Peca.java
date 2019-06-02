/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sla.pecas;



//Security home
public class Peca {

    private int codigo;
    private String descricao;
    private float preco;



    public Peca() {
        
    }

  
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int aCodigo) {
        codigo = aCodigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

}
