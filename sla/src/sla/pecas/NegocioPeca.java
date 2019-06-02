/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sla.pecas;

import java.util.ArrayList;
import java.util.List;
import javax.management.RuntimeErrorException;

/**
 *
 * @author Consultor SCA 02
 */
public class NegocioPeca implements InterfacePecaSigns {

    public NegocioPeca() {

    }

    @Override
    public void cadastrarPeca(Peca peca) throws Exception {

        try {
            if (peca == null) {
                throw new RuntimeException("O objeto não foi instanciado");
            }
            if ((peca.getDescricao() == null) || (peca.getDescricao().trim().isEmpty())) {

                throw new RuntimeException("Informe o nome da peça");
            }
            if (peca.getDescricao().length() > 50) {
                throw new RuntimeException("Limite máximo de 50 caracteres para a descrição da peça");
            }

            if ((peca.getPreco() <= 0)) {
                throw new RuntimeException("Informe o Valor da peça. Somente valores acima de Zero são permitidos.");
            }

            if (verificaDuplicidadePeca(peca)) {
                throw new RuntimeException("Já existe uma peça para o nome informado.");
            }
            DadosPeca dados = new DadosPeca();
            dados.cadastrarPeca(peca);

        } catch (Exception e) {
            throw e;
        }

    }

    @Override
    public ArrayList<Peca> consultarPeca(Peca peca) throws Exception {
        try {
            if (peca == null) {
                throw new RuntimeException("O objeto deve ser instanciado.");
            }
            if (peca.getCodigo() <= 0) {
                if (((peca.getDescricao() == null) == false) && (peca.getDescricao().trim().isEmpty()) == false) {
                    if (peca.getDescricao().length() > 50) {
                        throw new RuntimeException("Limite máximo de 50 caracteres");
                    }

                } else {
                    throw new RuntimeException("Informe o nome da peça");

                }
            }
            if (peca.getDescricao() == null) {
                peca.setDescricao("");

            }
            if (peca.getDescricao().length() > 50) {
                throw new RuntimeException("Limite máximo de 50 caracteres");
            }
            DadosPeca a = new DadosPeca();
            ArrayList consultarPeca = a.consultarPeca(peca);
            return consultarPeca;
        } catch (Exception e) {
            throw e;
        }

    }

    @Override
    public void removerPecaCod(Peca peca) throws Exception {
        if (peca == null) {
            throw new RuntimeException("O objeto deve ser instanciado.");
        }
        if (peca.getCodigo() <= 0) {
            throw new RuntimeException("Peça não localizada para o código informado");
        }

        ArrayList<Peca> listaPecas = consultarPeca(peca);
        if (listaPecas.isEmpty()) {
            throw new RuntimeException("Peça não localizada");
        } else {
            peca = listaPecas.get(0);
            DadosPeca a = new DadosPeca();
            a.removerPecaCod(peca);
        }

    }

    @Override
    public void alterarPeca(Peca peca) throws Exception {
        if (peca == null) {
            throw new RuntimeException("O objeto não foi instanciado");
        }

        if ((peca.getDescricao() == null) || (peca.getDescricao().trim().isEmpty())) {
            throw new RuntimeException("Informe o nome da peça");
        }
        if (peca.getDescricao().length() > 50) {
            throw new RuntimeException("Limite máximo de 50 caracteres para a descrição da peça");
        }

        if ((peca.getPreco() <= 0)) {
            throw new RuntimeException("Informe o Valor da peça. Somente valores acima de Zero são permitidos.");
        }

        if (verificaDuplicidadePeca(peca)) {
            throw new RuntimeException("Já existe uma peça para o nome informado.");
        } else {
            DadosPeca a = new DadosPeca();
            a.alterarPeca(peca);
        }

    }

    @Override
    public boolean verificaDuplicidadePeca(Peca filtro) throws Exception {

        DadosPeca a = new DadosPeca();
        boolean duplicada = a.verificaDuplicidadePeca(filtro);
        return duplicada;

    }

    @Override
    public ArrayList<Peca> listarPeca(Peca filtro) throws Exception {

        ArrayList<Peca> listaPecas = new ArrayList();

        DadosPeca a = new DadosPeca();
        listaPecas = a.listarPeca(filtro);
        return listaPecas;

    }

}
