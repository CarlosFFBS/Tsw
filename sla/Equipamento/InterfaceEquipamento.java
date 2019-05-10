/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sla.Equipamento;

import java.util.ArrayList;


public interface InterfaceEquipamento  {

     void cadastrarEquipamento(Equipamento e) throws Exception  ;

    void removerEquipamento(Equipamento e) throws Exception  ;

    void alterarEquipamento(Equipamento e) throws Exception  ;

    ArrayList<Equipamento> listarEquipamento()throws Exception  ;

    ArrayList<Equipamento> consultarEquipamentoContrato(Equipamento filtro)throws Exception  ;

    ArrayList<Equipamento> consultarEquipamentoSerial(Equipamento filtro)throws Exception  ;

    Boolean verificarDuplicidadeEquipamento(Equipamento e)throws Exception  ;

    
}
