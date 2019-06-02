/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sla.servico;

import java.util.ArrayList;

public class NegocioServico implements InterfaceServico {

    @Override
    public void cadastrarServico(Servico servico) throws Exception {

        if (servico == null) {
            throw new Exception("O servico não foi instanciado");
        }

        if ((servico.getDescricao() == null) || (servico.getDescricao().trim().isEmpty())) {
            throw new Exception("Informe o nome do servico");
        }

        if (servico.getDescricao().length() > 50) {
            throw new Exception("Limite máximo de 50 caracteres para a descrição do serviço");
        }

        if ((servico.getPreco() <= 0) || ((servico.getPreco() > Float.MAX_VALUE))) {
            if (servico.getPreco() > Float.MAX_VALUE) {
                throw new Exception("O número informado estoura a capacidade de armazenamento, Verifique o valor e tente novamente.");
            } else {
                throw new Exception("Informe o Valor do servico. Somente valores acima de Zero são permitidos.");
            }

        }

        if (verificaDuplicidadeServico(servico)) {
            throw new Exception("Já existe uma peça para o nome informado.");
        }
        DadosServico dados = new DadosServico();
        dados.cadastrarServico(servico);
    }

    @Override
    public ArrayList<Servico> consultarServico(Servico servico) throws Exception {
        if (servico == null) {
            throw new Exception("O objeto deve ser instanciado.");
        }
        if (servico.getCodServico() <= 0) {
            if (((servico.getDescricao() == null) == false) && (servico.getDescricao().trim().isEmpty()) == false) {
                DadosServico a = new DadosServico();
                ArrayList consultarServico = a.consultarServico(servico);

                return consultarServico;

            } else {
                throw new Exception("Informe o nome do serviço");

            }
        }
        if (servico.getDescricao() == null) {
            DadosServico a = new DadosServico();
            ArrayList consultarServico = a.consultarServico(servico);

            return consultarServico;
        }
        if (servico.getDescricao().length() > 50) {
            throw new Exception("Limite máximo de 50 caracteres para a descrição do serviço");
        }
        DadosServico a = new DadosServico();
        ArrayList<Servico> consultarServico = a.consultarServico(servico);

        return consultarServico;
    }

    /*
    public void removerServicoNome(Servico servico) throws Exception {
              if (servico == null) {
            throw new Exception("O serviço deve ser instanciado");
        }
        if (servico.getDescricao().trim().isEmpty()) {
            throw new Exception("Informe o nome do serviço");
        }
        if (servico.getPreco() <= 0) {
            throw new Exception("Informe o Valor do servico. Somente valores acima de Zero são permitidos.");
        }

        DadosServico dados = new DadosServico();
        boolean servicoDuplicado = dados.verificaDuplicidadeServico(servico);
        if (servicoDuplicado) {
            throw new Exception("Já existe um serviço para o nome informado.");
        }
    }
     */
    @Override
    public void removerServicoCod(Servico servico) throws Exception {
        /* 
        if (servico == null) {
            throw new Exception("O serviço deve ser instanciado");
        }
        if (servico.getDescricao().trim().isEmpty()) {
            throw new Exception("Informe o nome do serviço");
        }
        if (servico.getPreco() <= 0) {
            throw new Exception("Informe o Valor do servico. Somente valores acima de Zero são permitidos.");
        }

        DadosServico dados = new DadosServico();
        boolean servicoDuplicado = dados.verificaDuplicidadeServico(servico);
        if (servicoDuplicado) {
            throw new Exception("Já existe um serviço para o nome informado.");
        }
         */

        if (servico == null) {
            throw new Exception("O objeto deve ser instanciado.");
        }
        if (servico.getCodServico() <= 0) {
            throw new Exception("Servico não localizado para o código informado");
        }

        ArrayList<Servico> listaServico = consultarServico(servico);
        if (listaServico.isEmpty()) {
            throw new Exception("Serviço não localizado");
        }
        if (listaServico.size() == 1) {
            DadosServico a = new DadosServico();
            a.removerServicoCod(servico);
        }

    }

    @Override
    public void alterarServico(Servico servico) throws Exception {
        if (servico == null) {
            throw new Exception("O objeto não foi instanciado");
        }

        if ((servico.getDescricao() == null) || (servico.getDescricao().trim().isEmpty())) {
            throw new Exception("Informe o nome do serviço");
        }
        if (servico.getDescricao().length() > 50) {
            throw new Exception("Limite máximo de 50 caracteres para a descrição da peça");
        }

        if ((servico.getPreco() <= 0) || ((servico.getPreco() > Float.MAX_VALUE))) {
            if (servico.getPreco() > Float.MAX_VALUE) {
                throw new Exception("O número informado estoura a capacidade de armazenamento, Verifique o valor e tente novamente.");
            } else {
                throw new Exception("Informe o Valor da peça. Somente valores acima de Zero são permitidos.");
            }

        }

        if (verificaDuplicidadeServico(servico)) {
            throw new Exception("Já existe um serviço para o nome informado.");
        }

        DadosServico a = new DadosServico();
        a.alterarServico(servico);
    }

    @Override
    public boolean verificaDuplicidadeServico(Servico filtro) throws Exception {

        if (filtro == null) {
            throw new Exception("O objeto deve ser instanciado");
        }
        if (filtro.getDescricao().trim().isEmpty()) {
            throw new Exception("Informe o nome do serviço");

        }

        DadosServico a = new DadosServico();
        boolean duplicada = a.verificaDuplicidadeServico(filtro);
        return duplicada;

    }

    @Override
    public ArrayList<Servico> listarServico() throws Exception {

        /*
        if (filtro.getDescricao().trim().isEmpty()) {
            throw new Exception("Informe o nome do serviço");

        }   */
        DadosServico a = new DadosServico();
        ArrayList<Servico> listaServicos = a.listarServico();
        return listaServicos;
    }

}
