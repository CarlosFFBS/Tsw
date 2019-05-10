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
    public void cadastrarContratoPF(ContratoPF contratopf) throws Exception {
        if (contratopf == null) {
            throw new Exception("O Contrato não foi instanciado");
        }

        if (contratopf.getClientePF() == null) {
            throw new Exception("O Cliente não foi instanciado.");
        }

        if (contratopf.getClientePF().getCli_Cpf().trim().isEmpty()) {
            throw new Exception("Informe o CPF do cliente");
        }

        if (contratopf.getClientePF().getCli_Codigo() <= 0) {
            throw new Exception("Informe o Código do cliente");
        }

        if (contratopf.getInicioContrato()==null) {
            throw new Exception("Campo data de inicio do contrato vazio, preencher data corretamente.");
        }

        if (contratopf.getFimContrato()==null) {
            throw new Exception("Campo data de conclusão do contrato vazio, preencher data corretamente.");
        }

        if (contratopf.getInicioContrato().after(contratopf.getFimContrato())) {
            throw new Exception("Data final anterior ao início do contrato, informar datas corretamente.");
        }

        if (contratopf.getFimContrato().before(contratopf.getInicioContrato())) {
            throw new Exception("Data final anterior ao início do contrato, informar datas corretamente.");
        }

        if (contratopf.getInicioContrato().toString().trim().isEmpty()) {
            throw new Exception("Informe a Data de início do contrato.");
        }
        if (contratopf.getFimContrato().toString().trim().isEmpty()) {
            throw new Exception("Informe a Data final do contrato.");
        }
/*
        if (contratopf.getTotalEquipamento() <= 0) {
            throw new Exception("Informe a quantidade de equipamentos");
        }*/

        if (contratopf.getValor() <= 0) {
            throw new Exception("Informe o valor do contrato");
        }
        if (verificarDuplicidadeContratoPF(contratopf)) {
            throw new Exception("Já existe um contrato cadastrado com esse código para este equipamento.");
        }
        DadosContrato d = new DadosContrato();
        d.cadastrarContratoPF(contratopf);

    }

    @Override
    public void cadastrarContratoPJ(ContratoPJ contratopj) throws Exception {
        if (contratopj == null) {
            throw new Exception("O Contrato não foi instanciado");
        }

        if (contratopj.getClientePJ() == null) {
            throw new Exception("O Cliente não foi instanciado.");
        }

        if (contratopj.getClientePJ().getCli_Cnpj().trim().isEmpty()) {
            throw new Exception("Informe o CPF do cliente");
        }

        if (contratopj.getClientePJ().getCli_Codigo() <= 0) {
            throw new Exception("Informe o Código do cliente");
        }

        if (contratopj.getInicioContrato().toString().trim().isEmpty()) {
            throw new Exception("Campo data de inicio do contrato vazio, preencher data corretamente.");
        }

        if (contratopj.getFimContrato().toString().trim().isEmpty()) {
            throw new Exception("Campo data de conclusão do contrato vazio, preencher data corretamente.");
        }

        if (contratopj.getInicioContrato().after(contratopj.getFimContrato())) {
            throw new Exception("Data final anterior ao início do contrato, informar datas corretamente.");
        }

        if (contratopj.getFimContrato().before(contratopj.getInicioContrato())) {
            throw new Exception("Data final anterior ao início do contrato, informar datas corretamente.");
        }

        if (contratopj.getInicioContrato().toString().trim().isEmpty()) {
            throw new Exception("Informe a Data de início do contrato.");
        }
        if (contratopj.getFimContrato().toString().trim().isEmpty()) {
            throw new Exception("Informe a Data final do contrato.");
        }

        if (contratopj.getTotalEquipamento() <= 0) {
            throw new Exception("Informe a quantidade de equipamentos");
        }

        if (contratopj.getValor() <= 0) {
            throw new Exception("Informe o valor do contrato");
        }
        if (verificarDuplicidadeContratoPJ(contratopj)) {
            throw new Exception("Já existe um contrato cadastrado com esse código para este equipamento.");
        }
        DadosContrato d = new DadosContrato();
        d.cadastrarContratoPJ(contratopj);

    }

    @Override
    public void removerContratoPF(ContratoPF contratopf) throws Exception {
        if (contratopf == null) {
            throw new Exception("O Contrato não foi instanciado");
        }

        if (contratopf.getClientePF() == null) {
            throw new Exception("O Cliente não foi instanciado.");
        }

        if (contratopf == null) {
            throw new Exception("O Contrato não foi instanciado");
        }

        if (contratopf.getIdContrato() <= 0) {
            throw new Exception("Número de contrato inválido. Favor informar o contrato corretamente.");
        }
        if (verificarDuplicidadeContratoPF(contratopf) == false) {
            throw new Exception("Não existe um contrato cadastrado com esse código.");
        }
        DadosContrato d = new DadosContrato();
        d.removerContratoPF(contratopf);
    }

    @Override
    public void removerContratoPJ(ContratoPJ contratopj) throws Exception {
        if (contratopj == null) {
            throw new Exception("O Contrato não foi instanciado");
        }

        if (contratopj.getClientePJ() == null) {
            throw new Exception("O Cliente não foi instanciado.");
        }

        if (contratopj == null) {
            throw new Exception("O Contrato não foi instanciado");
        }

        if (contratopj.getIdContrato() <= 0) {
            throw new Exception("Número de contrato inválido. Favor informar o contrato corretamente.");
        }
        if (verificarDuplicidadeContratoPJ(contratopj) == false) {
            throw new Exception("Não existe um contrato cadastrado com esse código.");
        }
        DadosContrato d = new DadosContrato();
        d.removerContratoPJ(contratopj);
    }

    @Override
    public void alterarContratoPF(ContratoPF contratopf) throws Exception {
        if (contratopf == null) {
            throw new Exception("O Contrato não foi instanciado");
        }

        if (contratopf.getClientePF() == null) {
            throw new Exception("O Cliente não foi instanciado.");
        }

        if (contratopf.getClientePF().getCli_Codigo() <= 0) {
            throw new Exception("Informe o Código do cliente");
        }

        if (contratopf.getInicioContrato().toString().trim().isEmpty()) {
            throw new Exception("Campo data de inicio do contrato vazio, preencher data corretamente.");
        }

        if (contratopf.getFimContrato().toString().trim().isEmpty()) {
            throw new Exception("Campo data de conclusão do contrato vazio, preencher data corretamente.");
        }

        if (contratopf.getInicioContrato().after(contratopf.getFimContrato())) {
            throw new Exception("Data final anterior ao início do contrato, informar datas corretamente.");
        }
        if (contratopf.getInicioContrato().toString().trim().isEmpty()) {
            throw new Exception("Informe a Data de início do contrato.");
        }
        if (contratopf.getFimContrato().toString().trim().isEmpty()) {
            throw new Exception("Informe a Data final do contrato.");
        }
        if (contratopf.getFimContrato().before(contratopf.getInicioContrato())) {
            throw new Exception("Data final anterior ao início do contrato, informar datas corretamente.");
        }
        if (contratopf.getTotalEquipamento() <= 0) {
            throw new Exception("Informe a quantidade de equipamentos");
        }
        if (contratopf.getValor() <= 0) {
            throw new Exception("Informe o valor do contrato");
        }
        if (verificarDuplicidadeContratoPF(contratopf)) {
            throw new Exception("Já existe um contrato cadastrado com esse código para este equipamento.");
        }
        DadosContrato d = new DadosContrato();
        d.cadastrarContratoPF(contratopf);
    }

    @Override
    public void alterarContratoPJ(ContratoPJ contratopj) throws Exception {
        if (contratopj == null) {
            throw new Exception("O Contrato não foi instanciado");
        }

        if (contratopj.getClientePJ() == null) {
            throw new Exception("O Cliente não foi instanciado.");
        }

        if (contratopj.getClientePJ().getCli_Cnpj().trim().isEmpty()) {
            throw new Exception("Informe o CPF do cliente");
        }

        if (contratopj.getClientePJ().getCli_Codigo() <= 0) {
            throw new Exception("Informe o Código do cliente");
        }

        if (contratopj.getInicioContrato().toString().trim().isEmpty()) {
            throw new Exception("Campo data de inicio do contrato vazio, preencher data corretamente.");
        }

        if (contratopj.getFimContrato().toString().trim().isEmpty()) {
            throw new Exception("Campo data de conclusão do contrato vazio, preencher data corretamente.");
        }

        if (contratopj.getInicioContrato().after(contratopj.getFimContrato())) {
            throw new Exception("Data final anterior ao início do contrato, informar datas corretamente.");
        }

        if (contratopj.getFimContrato().before(contratopj.getInicioContrato())) {
            throw new Exception("Data final anterior ao início do contrato, informar datas corretamente.");
        }

        if (contratopj.getInicioContrato().toString().trim().isEmpty()) {
            throw new Exception("Informe a Data de início do contrato.");
        }
        if (contratopj.getFimContrato().toString().trim().isEmpty()) {
            throw new Exception("Informe a Data final do contrato.");
        }

        if (contratopj.getTotalEquipamento() <= 0) {
            throw new Exception("Informe a quantidade de equipamentos");
        }

        if (contratopj.getValor() <= 0) {
            throw new Exception("Informe o valor do contrato");
        }
        if (verificarDuplicidadeContratoPJ(contratopj)) {
            throw new Exception("Já existe um contrato cadastrado com esse código para este equipamento.");
        }
        DadosContrato d = new DadosContrato();
        d.cadastrarContratoPJ(contratopj);
    }

    @Override
    public ArrayList<ContratoPF> consultarPFContrato(ContratoPF contratopf) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ContratoPJ> consultarPJContrato(ContratoPJ contratopj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        DadosContrato d = new DadosContrato();
        return d.verificarDuplicidadeContratoPF(filtroPF);
    }

    @Override
    public Boolean verificarDuplicidadeContratoPJ(ContratoPJ filtroPJ) throws Exception {
        DadosContrato d = new DadosContrato();
        return d.verificarDuplicidadeContratoPJ(filtroPJ);
    }

    @Override
    public Boolean verificarContratoPF(ContratoPF filtroPF) throws Exception {
        DadosContrato d = new DadosContrato();
        return d.verificarContratoPF(filtroPF);

    }

    @Override
    public Boolean verificarContratoPJ(ContratoPJ filtroPJ) throws Exception {
        DadosContrato d = new DadosContrato();
        return d.verificarDuplicidadeContratoPJ(filtroPJ);
    }
}
