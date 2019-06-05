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

        try {
            if (servico == null) {
                throw new RuntimeException("O servico não foi instanciado");
            }

            if ((servico.getDescricao() == null) || (servico.getDescricao().trim().isEmpty())) {
                throw new RuntimeException("Informe o nome do servico");
            }

            if (servico.getDescricao().length() > 50) {
                throw new RuntimeException("Limite máximo de 50 caracteres para a descrição do serviço");
            }

            if ((servico.getPreco() <= 0)) {
                throw new RuntimeException("Informe o Valor do servico. Somente valores acima de Zero são permitidos.");
            }

            if (verificaDuplicidadeServico(servico)) {
                throw new RuntimeException("Já existe um serviço cadastrado para os dados informados.");
            }
            DadosServico dados = new DadosServico();
            dados.cadastrarServico(servico);

        } catch (Exception e) {
            throw e;
        }

    }

    @Override
    public ArrayList<Servico> consultarServico(Servico servico) throws Exception {

        try {
            if (servico == null) {
                throw new RuntimeException("O objeto deve ser instanciado.");
            }
            if (servico.getCodServico() <= 0) {
                if (((servico.getDescricao() == null) == false) && (servico.getDescricao().trim().isEmpty()) == false) {
                    if (servico.getDescricao().length() > 50) {
                        throw new RuntimeException("Limite máximo de 50 caracteres");
                    }

                } else {
                    throw new RuntimeException("Informe o nome do serviço");

                }
            }
            if (servico.getDescricao() == null) {
                servico.setDescricao("");
            }
            if (servico.getDescricao().length() > 50) {
                throw new RuntimeException("Limite máximo de 50 caracteres para a descrição do serviço");
            }
            DadosServico a = new DadosServico();
            ArrayList<Servico> consultarServico = a.consultarServico(servico);
            return consultarServico;
        } catch (Exception e) {
            throw e;
        }

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

        try {
            if (servico == null) {
                throw new RuntimeException("O objeto deve ser instanciado.");
            }
            if (servico.getCodServico() <= 0) {
                throw new RuntimeException("Servico não localizado para o código informado");
            }

            ArrayList<Servico> listaServico = consultarServico(servico);
            if (listaServico.isEmpty()) {
                throw new RuntimeException("Serviço não localizado");
            } else {
                DadosServico a = new DadosServico();
                a.removerServicoCod(servico);
            }

        } catch (Exception e) {
            throw e;
        }

    }

    @Override
    public void alterarServico(Servico servico) throws Exception {
        if (servico == null) {
            throw new RuntimeException("O objeto não foi instanciado");
        }
        if ((servico.getDescricao() == null) || (servico.getDescricao().trim().isEmpty())) {
            throw new RuntimeException("Informe o nome do serviço");
        }
        if (servico.getDescricao().length() > 50) {
            throw new RuntimeException("Limite máximo de 50 caracteres para a descrição da peça");
        }
        if ((servico.getPreco() <= 0)) {
            throw new RuntimeException("Informe o Valor da peça. Somente valores acima de Zero são permitidos.");
        }
        if (verificaDuplicidadeServico(servico)) {
            throw new RuntimeException("Já existe um serviço para o nome informado.");
        } else {
            DadosServico a = new DadosServico();
            a.alterarServico(servico);
        }

    }

    @Override
    public boolean verificaDuplicidadeServico(Servico filtro) throws Exception {
        DadosServico a = new DadosServico();
        boolean duplicada = a.verificaDuplicidadeServico(filtro);
        return duplicada;
    }

    @Override
    public ArrayList<Servico> listarServico() throws Exception {
        DadosServico a = new DadosServico();
        ArrayList<Servico> listaServicos = a.listarServico();
        return listaServicos;
    }

}
