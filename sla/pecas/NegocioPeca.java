/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sla.pecas;

import java.util.ArrayList;

/**
 *
 * @author Consultor SCA 02
 */
public class NegocioPeca implements InterfacePecaSigns {

    @Override
    public void cadastrarPeca(Peca peca) throws Exception {

        if (peca == null) {
            throw new Exception("O objeto não foi instanciado");
        }
        if ((peca.getDescricao() == null) || (peca.getDescricao().trim().isEmpty())) {
            throw new Exception("Informe o nome da peça");
        }
        if (peca.getDescricao().length() > 50) {
            throw new Exception("Limite máximo de 50 caracteres para a descrição do serviço");
        }

        if ((peca.getPreco() <= 0) || ((peca.getPreco() > Float.MAX_VALUE))) {
            if (peca.getPreco() > Float.MAX_VALUE) {
                throw new Exception("O número informado estoura a capacidade de armazenamento, Verifique o valor e tente novamente.");
            } else {
                throw new Exception("Informe o Valor da peça. Somente valores acima de Zero são permitidos.");
            }

        }

        if (verificaDuplicidadePeca(peca)) {
            throw new Exception("Já existe uma peça para o nome informado.");
        }
        DadosPeca dados = new DadosPeca();
        dados.cadastrarPeca(peca);

    }

    @Override
    public ArrayList<Peca> consultarPeca(Peca peca) throws Exception {
        if (peca == null) {
            throw new Exception("O objeto deve ser instanciado.");
        }
        if (peca.getCodigo() <= 0) {
            
            if (((peca.getDescricao() == null) == false) && (peca.getDescricao().trim().isEmpty()) == false) {
                DadosPeca a = new DadosPeca();
                ArrayList consultarPeca = a.consultarPeca(peca);
                return consultarPeca;

            } else {
                throw new Exception("Informe o nome da peça");

            }
        }
        if (peca.getDescricao() == null) {
            peca.setDescricao("");

        }
  
        DadosPeca a = new DadosPeca();
        ArrayList consultarPeca = a.consultarPeca(peca);

        return consultarPeca;

    }

    @Override
    public void removerPecaCod(Peca peca) throws Exception {

        if (peca == null) {
            throw new Exception("O objeto deve ser instanciado.");
        }
        if (peca.getCodigo() <= 0) {
            throw new Exception("Peça não localizada para o código informado");
        }

        ArrayList<Peca> listaPecas = consultarPeca(peca);
        if (listaPecas.isEmpty()) {
            throw new Exception("Peça não localizada");
        }
        if (listaPecas.size() == 1) {
            DadosPeca a = new DadosPeca();
            a.removerPecaCod(peca);
        }

    }

    @Override
    public void alterarPeca(Peca peca) throws Exception {
        if (peca == null) {
            throw new Exception("O objeto não foi instanciado");
        }

        if ((peca.getDescricao() == null) || (peca.getDescricao().trim().isEmpty())) {
            throw new Exception("Informe o nome da peça");
        }
        if (peca.getDescricao().length() > 50) {
            throw new Exception("Limite máximo de 50 caracteres para a descrição da peça");
        }

        if ((peca.getPreco() <= 0) || ((peca.getPreco() > Float.MAX_VALUE))) {
            if (peca.getPreco() > Float.MAX_VALUE) {
                throw new Exception("O número informado estoura a capacidade de armazenamento, Verifique o valor e tente novamente.");
            } else {
                throw new Exception("Informe o Valor da peça. Somente valores acima de Zero são permitidos.");
            }

        }

        if (verificaDuplicidadePeca(peca)) {
            throw new Exception("Já existe uma peça para o nome informado.");
        }

        DadosPeca a = new DadosPeca();
        a.alterarPeca(peca);

    }

    @Override
    public boolean verificaDuplicidadePeca(Peca filtro) throws Exception {
        if (filtro == null) {
            throw new Exception("O objeto deve ser instanciado");
        }
        if (filtro.getDescricao().trim().isEmpty()) {
            throw new Exception("Informe o nome do objeto");

        }

        if (filtro.getDescricao().length() > 50) {
            throw new Exception("Limite máximo de 50 caracteres para a descrição da peca");
        }
        DadosPeca a = new DadosPeca();
        boolean duplicada = a.verificaDuplicidadePeca(filtro);
        return duplicada;

    }

    @Override
    public ArrayList<Peca> listarPeca(Peca filtro) throws Exception {
        /*
        if (filtro == null) {
            throw new Exception("O objeto deve ser instanciado");
        }  */
 /*   if (filtro.getDescricao().trim().isEmpty()) {
            throw new Exception("Informe o nome da peça");

         }       */

        if (filtro.getDescricao().length() > 50) {
            throw new Exception("Limite máximo de 50 caracteres para a descrição da peça");
        }
        DadosPeca a = new DadosPeca();
        ArrayList<Peca> listaPecas = a.listarPeca(filtro);
        return listaPecas;

    }

}
