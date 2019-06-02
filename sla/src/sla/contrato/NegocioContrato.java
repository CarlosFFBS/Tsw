/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sla.contrato;

import java.util.ArrayList;

/**
 *
 * @author Fabiano
 */
public class NegocioContrato implements InterfaceContrato {

    @Override
    public boolean cadastrarContratoPF(ContratoPF contratopf) throws Exception {
        if (contratopf == null) {
            throw new RuntimeException("O Contrato não foi instanciado");
        }

        if (contratopf.getClientePF() == null) {
            throw new RuntimeException("O Cliente não foi instanciado.");
        }

        if (contratopf.getInicioContrato()==null) {
            throw new RuntimeException("Campo data de inicio do contrato vazio, preencher data corretamente.");
        }

        if (contratopf.getFimContrato()==null) {
            throw new RuntimeException("Campo data de conclusão do contrato vazio, preencher data corretamente.");
        }

        if (contratopf.getInicioContrato().after(contratopf.getFimContrato())) {
            throw new RuntimeException("Data final anterior ao início do contrato, informar datas corretamente.");
        }
        
        if (contratopf.getInicioContrato().equals(contratopf.getFimContrato())) {
            throw new RuntimeException("Data final igual ao início do contrato, informar datas corretamente.");
        }

        if (contratopf.getInicioContrato().toString().trim().isEmpty()||contratopf.getInicioContrato().toString().trim()==null) {
            throw new RuntimeException("Informe a Data de início do contrato.");
        }
        if (contratopf.getFimContrato().toString().trim().isEmpty()) {
            throw new RuntimeException("Informe a Data final do contrato.");
        }

        if (contratopf.getTotalEquipamento() <= 0) {
            throw new RuntimeException("Informe a quantidade de equipamentos");
        }

        if (contratopf.getValor() <= 0) {
            throw new RuntimeException("Informe o valor do contrato");
        }
       if (verificarDuplicidadeContratoPF(contratopf)) {
            throw new RuntimeException("Já existe um contrato cadastrado com esse código para este equipamento.");
        }
       DadosContrato d = new DadosContrato();
       d.cadastrarContratoPF(contratopf);
        return true;
    }

    @Override
    public boolean cadastrarContratoPJ(ContratoPJ contratopj) throws Exception {
        if (contratopj == null) {
            throw new RuntimeException("O Contrato não foi instanciado");
        }

        if (contratopj.getClientePJ() == null) {
            throw new RuntimeException("O Cliente não foi instanciado.");
        }

        if (contratopj.getInicioContrato().toString().trim().isEmpty()) {
            throw new RuntimeException("Campo data de inicio do contrato vazio, preencher data corretamente.");
        }

        if (contratopj.getFimContrato().toString().trim().isEmpty()) {
            throw new RuntimeException("Campo data de conclusão do contrato vazio, preencher data corretamente.");
        }

        if (contratopj.getInicioContrato().after(contratopj.getFimContrato())) {
            throw new RuntimeException("Data final anterior ao início do contrato, informar datas corretamente.");
        }

        if (contratopj.getFimContrato().equals(contratopj.getInicioContrato())) {
            throw new RuntimeException("Data final anterior ao início do contrato, informar datas corretamente.");
        }

        if (contratopj.getTotalEquipamento() <= 0) {
            throw new RuntimeException("Informe a quantidade de equipamentos");
        }

        if (contratopj.getValor() <= 0) {
            throw new RuntimeException("Informe o valor do contrato");
        }/*
        if (verificarDuplicidadeContratoPJ(contratopj)) {
            throw new RuntimeException("Já existe um contrato cadastrado com esse código para este equipamento.");
        }*/
        //DadosContrato d = new DadosContrato();
        //d.cadastrarContratoPJ(contratopj);
        return true;
    }

    @Override
    public boolean removerContratoPF(ContratoPF contratopf) throws Exception {
        if (contratopf == null) {
            throw new RuntimeException("O Contrato não foi instanciado");
        }

        if (contratopf.getClientePF() == null) {
            throw new RuntimeException("O Cliente não foi instanciado.");
        }

        if (contratopf.getIdContrato() <= 0) {
            throw new RuntimeException("Número de contrato inválido. Favor informar o contrato corretamente.");
        }
        if (verificarDuplicidadeContratoPF(contratopf) == false) {
            throw new RuntimeException("Não existe um contrato cadastrado com esse código.");
        }
        DadosContrato d = new DadosContrato();
        d.removerContratoPF(contratopf);
        return true;
    }

    @Override
    public boolean removerContratoPJ(ContratoPJ contratopj) throws Exception {
        if (contratopj == null) {
            throw new RuntimeException("O Contrato não foi instanciado");
        }

        if (contratopj.getClientePJ() == null) {
            throw new RuntimeException("O Cliente não foi instanciado.");
        }

        if (contratopj.getIdContrato() <= 0) {
            throw new RuntimeException("Número de contrato inválido. Favor informar o contrato corretamente.");
        }
       if (!verificarDuplicidadeContratoPJ(contratopj)) {
            throw new RuntimeException("Não existe um contrato cadastrado com esse código.");
        }
        DadosContrato d = new DadosContrato();
        d.removerContratoPJ(contratopj);
        return true;
    }

    @Override
    public boolean alterarContratoPF(ContratoPF contratopf) throws Exception {
        if (contratopf == null) {
            throw new RuntimeException("O Contrato não foi instanciado");
        }

        if (contratopf.getClientePF() == null) {
            throw new RuntimeException("O Cliente não foi instanciado.");
        }

        if (contratopf.getInicioContrato().toString().trim().isEmpty()) {
            throw new RuntimeException("Campo data de inicio do contrato vazio, preencher data corretamente.");
        }

        if (contratopf.getFimContrato().toString().trim().isEmpty()) {
            throw new RuntimeException("Campo data de conclusão do contrato vazio, preencher data corretamente.");
        }

        if (contratopf.getInicioContrato().after(contratopf.getFimContrato())) {
            throw new RuntimeException("Data final anterior ao início do contrato, informar datas corretamente.");
        }
         if (contratopf.getInicioContrato().equals(contratopf.getFimContrato())) {
            throw new RuntimeException("Data final igual ao início do contrato, informar datas corretamente.");
        }
        if (contratopf.getInicioContrato().toString().trim().isEmpty()) {
            throw new RuntimeException("Informe a Data de início do contrato.");
        }
        if (contratopf.getFimContrato().toString().trim().isEmpty()) {
            throw new RuntimeException("Informe a Data final do contrato.");
        }

        if (contratopf.getTotalEquipamento() <= 0) {
            throw new RuntimeException("Informe a quantidade de equipamentos");
        }
        if (contratopf.getValor() <= 0) {
            throw new RuntimeException("Informe o valor do contrato");
        }
        if (verificarDuplicidadeContratoPF(contratopf)) {
            throw new RuntimeException("Já existe um contrato cadastrado com esse código para este equipamento.");
        }
        DadosContrato d = new DadosContrato();
        d.alterarContratoPF(contratopf);
        return true;
    }

    @Override
    public boolean alterarContratoPJ(ContratoPJ contratopj) throws Exception {
        if (contratopj == null) {
            throw new RuntimeException("O Contrato não foi instanciado");
        }

        if (contratopj.getClientePJ() == null) {
            throw new RuntimeException("O Cliente não foi instanciado.");
        }

        if (contratopj.getInicioContrato().toString().trim().isEmpty()) {
            throw new RuntimeException("Campo data de inicio do contrato vazio, preencher data corretamente.");
        }

        if (contratopj.getFimContrato().toString().trim().isEmpty()) {
            throw new RuntimeException("Campo data de conclusão do contrato vazio, preencher data corretamente.");
        }

        if (contratopj.getInicioContrato().after(contratopj.getFimContrato())) {
            throw new RuntimeException("Data final anterior ao início do contrato, informar datas corretamente.");
        }

          if (contratopj.getInicioContrato().equals(contratopj.getFimContrato())) {
            throw new RuntimeException("Data final igual ao início do contrato, informar datas corretamente.");
        }

        if (contratopj.getInicioContrato().toString().trim().isEmpty()) {
            throw new RuntimeException("Informe a Data de início do contrato.");
        }
        
        if (contratopj.getFimContrato().toString().trim().isEmpty()) {
            throw new RuntimeException("Informe a Data final do contrato.");
        }

        if (contratopj.getTotalEquipamento() <= 0) {
            throw new RuntimeException("Informe a quantidade de equipamentos");
        }

        if (contratopj.getValor() <= 0) {
            throw new RuntimeException("Informe o valor do contrato");
        }
       
        if (verificarDuplicidadeContratoPJ(contratopj)) {
            throw new RuntimeException("Já existe um contrato cadastrado com esse código para este equipamento.");
        } 
        DadosContrato d = new DadosContrato();
        d.alterarContratoPJ(contratopj);
        return true;
    }

    @Override
    public ArrayList<ContratoPF> consultarPFContrato(ContratoPF contratopf) throws Exception {
        ArrayList<ContratoPF> lista;
        
        if(contratopf == null){
           throw new RuntimeException("Informe o contrato");
        }
        DadosContrato dao = new DadosContrato();
        lista= dao.consultarPFContrato(contratopf);
        return lista;
    }

    @Override
    public ArrayList<ContratoPJ> consultarPJContrato(ContratoPJ contratopj) throws Exception {
          ArrayList<ContratoPJ> lista;
        
        if(contratopj == null){
           throw new RuntimeException("Informe o contrato");
        }
        DadosContrato dao = new DadosContrato();
        lista= dao.consultarPJContrato(contratopj);
        return lista;
    }

    @Override
    public ArrayList<ContratoPF> listarContratoPF() throws Exception {
        DadosContrato d = new DadosContrato();
        ArrayList<ContratoPF> lista = d.listarContratoPF();
        return lista;
    }

    @Override
    public ArrayList<ContratoPJ> listarContratoPJ() throws Exception {
        DadosContrato d = new DadosContrato();
        ArrayList<ContratoPJ> lista = d.listarContratoPJ();
        return lista;
    }

    @Override
    public Boolean verificarDuplicidadeContratoPF(ContratoPF filtroPF) throws Exception {
       boolean teste = false;
       DadosContrato d = new DadosContrato();
        if(filtroPF == null){
           throw new RuntimeException("Informe o contrato");
        }else if (d.verificarDuplicidadeContratoPF(filtroPF)){
           teste = true;
     }
        return teste;
    
    }

    @Override
    public Boolean verificarDuplicidadeContratoPJ(ContratoPJ filtroPJ) throws Exception {
        if(filtroPJ == null){
           throw new RuntimeException("Informe o contrato");
        }
        DadosContrato d = new DadosContrato();
        boolean teste =  d.verificarDuplicidadeContratoPJ(filtroPJ);
        return teste;
    }

    @Override
    public Boolean verificarContratoPF(ContratoPF filtroPF) throws Exception {
        if(filtroPF == null){
           throw new RuntimeException("Informe o contrato");
        }
        DadosContrato d = new DadosContrato();
        boolean teste =  d.verificarContratoPF(filtroPF);
        return teste;
    }

    @Override
    public Boolean verificarContratoPJ(ContratoPJ filtroPJ) throws Exception {
        if(filtroPJ == null){
           throw new RuntimeException("Informe o contrato");
        }
        DadosContrato d = new DadosContrato();
        boolean teste =  d.verificarContratoPJ(filtroPJ);
        return teste;
    }
}
