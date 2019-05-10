/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sla.Equipamento;

import java.util.ArrayList;

/**
 *
 * @author Fabiano
 */
public class NegocioEquipamento implements InterfaceEquipamento {

    @Override
    public void cadastrarEquipamento(Equipamento e) throws Exception {
        if (e == null) {
            throw new Exception("Objeto Equipamento Nulo");
        }

        if (e.getDescricao() == null) {
            throw new Exception("Nulo: Informar a descrição do equipamento");
        }
        if (e.getDescricao().trim().isEmpty()) {
            throw new Exception("Campo descrição vazio. Favor, informar a descrição do equipamento");
        }
        if (e.getDescricao().trim().length() > 50) {
            throw new Exception("A descrição do equipamento não pode ter mais de 50(cinquenta) caracteres");
        }
        if (e.getIdContrato() <= 0) {
            throw new Exception("Nulo: Informar o contrato do equipamento");
        }
        if (e.getSerial() == null) {
            throw new Exception("Nulo: Informar o serial do equipamento");
        }
        if (e.getSerial().trim().equals("") == true) {
            throw new Exception("Informar o Serial do equipamento");
        }
            if (e.getSerial().trim().isEmpty()) {
            throw new Exception("Campo Vazio. Favor, informar o Serial do equipamento");
        }
        if (e.getSerial().trim().length() > 25) {
            throw new Exception("O Serial do equipamento não pode ter mais de 25(vinte e cinco) caracteres");
        }
        DadosEquipamento d = new DadosEquipamento();
        boolean teste = d.verificarDuplicidadeEquipamento(e);
        if (teste) {
            throw new Exception("Já existe um equipamento cadastrado com a número de contrato e serial informados.");
        }
     
        
        d.cadastrarEquipamento(e);
    }

    @Override
    public void removerEquipamento(Equipamento e) throws Exception {
        if (e.getCodigo() < 0 || e.getCodigo() > Integer.MAX_VALUE) {
            throw new Exception("Código inválido. Informar um código entre 0 e 2147483647.");
        }
        /*if (Integer.toString(e.getCodigo())==""){
            throw new Exception("É necessário informar o código do equipamento para remoção.");  
        }*/
        if (verificarDuplicidadeEquipamento(e) == false) {
            throw new Exception("O equipamento informado não está cadastrado na base de dados.");
        }
        DadosEquipamento dados = new DadosEquipamento();
        dados.removerEquipamento(e);
    }

    @Override
    public void alterarEquipamento(Equipamento e) throws Exception {
        if (e == null) {
            throw new Exception("Objeto Equipamento Nulo");
        }

        if (e.getDescricao() == null) {
            throw new Exception("Nulo: Informar a descrição do equipamento");
        }
        if (e.getDescricao().trim().equals("") == true) {
            throw new Exception("Informar a descrição do equipamento");
        }

        if (e.getIdContrato() <= 0) {
            throw new Exception("Nulo: Informar o contrato do equipamento");
        }

        if (e.getDescricao().trim().length() > 50) {
            throw new Exception("A descrição do equipamento não pode ter mais de 50(cinquenta) caracteres");
        }

        if (e.getSerial() == null) {
            throw new Exception("Nulo: Informar o serial do equipamento");
        }
        if (e.getSerial().trim().equals("") == true) {
            throw new Exception("Informar o Serial do equipamento");
        }
        if (e.getSerial().trim().length() > 25) {
            throw new Exception("O Serial do equipamento não pode ter mais de 25(vinte e cinco) caracteres");
        }

        if (verificarDuplicidadeEquipamento(e)) {
            throw new Exception("Já existe um equipamento cadastrado com a serial e número de contrato informados.");
        }
        
        DadosEquipamento dados = new DadosEquipamento();
        dados.alterarEquipamento(e);
    }

    @Override
    public ArrayList<Equipamento> listarEquipamento(Equipamento filtro) throws Exception {
        if (filtro.getCodigo() < 0 || filtro.getCodigo() > Integer.MAX_VALUE) {
            throw new Exception("Código inválido. Informar um código entre 0 e 2147483647.");
        }
        DadosEquipamento dados = new DadosEquipamento();
        return dados.listarEquipamento(filtro);
    }

    @Override
    public Boolean verificarDuplicidadeEquipamento(Equipamento e) throws Exception {
        if (e == null) {
            throw new Exception("Objeto Equipamento Nulo");
        }
        DadosEquipamento dados = new DadosEquipamento();
        return dados.verificarDuplicidadeEquipamento(e);

    }

    @Override
    public ArrayList<Equipamento> consultarEquipamentoContrato(Equipamento filtro) throws Exception {
        if (filtro.getIdContrato() <= 0) {
            throw new Exception("Campo vazio. Informe o número do contrato.");
        }
        DadosEquipamento dados = new DadosEquipamento();
        return dados.consultarEquipamentoContrato(filtro);
    }

    @Override
    public ArrayList<Equipamento> consultarEquipamentoSerial(Equipamento filtro) throws Exception {
        if (filtro.getSerial().trim().isEmpty()) {
            throw new Exception("Campo vazio. Informe o número do contrato.");
        }
        DadosEquipamento dados = new DadosEquipamento();
        return dados.consultarEquipamentoSerial(filtro);
    }    
}
