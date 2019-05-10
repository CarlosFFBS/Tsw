/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sla.operacoes;

public class Operacao {

    public float formatadorVirgulaParaPonto(String preco) throws Exception {
        String precoConvertido = "";
        int tamanhoString = preco.length();
        for (int i = 0; i < tamanhoString; i++) {
            if (preco.charAt(i) == ',') {
                precoConvertido += '.';
            } else {
                precoConvertido += preco.charAt(i);
            }
        }
        return Float.parseFloat(precoConvertido);

    }

    public java.sql.Date dataJavaSql(java.util.Date a) {
        java.sql.Date dataSQL = new java.sql.Date(a.getTime());
        return dataSQL;

    }

    public java.util.Date dataSqlJava(java.sql.Date a) {
        java.util.Date dataJAVA = new java.util.Date(a.getTime());
        return dataJAVA;

    }

    public String formataCPF(String cpf) throws Exception {

        try {
            String limparCPF = cpf.trim();
            String cpfFormatado;
            // Loop para validar dígitos do CPF 
            for (int i = 0; i < limparCPF.length(); i++) {
                int aux = Integer.parseInt(String.valueOf(cpf.charAt(i)));
            }
            cpfFormatado = limparCPF.substring(0, 3) + ".";
            cpfFormatado += limparCPF.substring(3, 6) + ".";
            cpfFormatado += limparCPF.substring(6, 9) + "-";
            cpfFormatado += limparCPF.substring(9, 11);
            return cpfFormatado;
        } catch (Exception e) {
            throw new Exception("Apenas números são permitidos para o cpf");
        }

    }

    public boolean validaCPF(String cpf) {
        boolean validaCPF = true;
        for (int i = 0; i < cpf.length(); i++) {
            if ((i == 3) || (i == 7) || (i == 11)) {
                break;
            }
            try {
                int aux = Integer.parseInt(String.valueOf(cpf.charAt(i)));
            } catch (Exception e) {
                validaCPF = false;
            }

        }

        return validaCPF;

    }
        public boolean validaCNPJ(String cnpj) {
        boolean validaCNPJ = true;
        for (int i = 0; i < cnpj.length(); i++) {
            if ((i == 2) || (i == 6) || (i == 10)||(i == 15)) {
                break;
            }
            try {
                int aux = Integer.parseInt(String.valueOf(cnpj.charAt(i)));
            } catch (Exception e) {
                validaCNPJ = false;
            }

        }

        return validaCNPJ;

    }

    public String formataCEP(String cep) throws Exception {

        try {

            String limparCEP = cep.trim();
            String cepFormatado;
            // Loop para validar dígitos do CPF 
            cepFormatado = limparCEP.substring(0, 2) + ".";
            cepFormatado += limparCEP.substring(2, 5) + "-";
            cepFormatado += limparCEP.substring(5, 8);

            return cepFormatado;
        } catch (StringIndexOutOfBoundsException e) {
            throw new Exception("Preencha todos os números do CEP");
        }

    }

    public String formataCNPJ(String cnpj) throws Exception {

        try {
            String limparCNPJ = cnpj.trim();
            String cnpjFormatado;
            for (int i = 0; i < limparCNPJ.length(); i++) {
                int aux = Integer.parseInt(String.valueOf(cnpj.charAt(i)));
            }
            cnpjFormatado = limparCNPJ.substring(0, 2) + ".";
            cnpjFormatado += limparCNPJ.substring(2, 5) + ".";
            cnpjFormatado += limparCNPJ.substring(5, 8) + "/";
            cnpjFormatado += limparCNPJ.substring(8, 12) + "-";
            cnpjFormatado += limparCNPJ.substring(12, 14);
            return cnpjFormatado;

        } catch (NullPointerException e) {
            throw new Exception("O CNPJ não pode ter valor nulo.");
        } catch (NumberFormatException e) {
            throw new Exception("Apenas números são permitidos para o CNPJ");
        } catch (StringIndexOutOfBoundsException e) {
            throw new Exception("Preencha todos os números do CNPJ");
        }

    }

    public String formataTelefone(String telefone) throws Exception {

        try {
            String limparTelefone = telefone.trim();
            String telefoneFormatado;
            for (int i = 0; i < limparTelefone.length(); i++) {
                int aux = Integer.parseInt(String.valueOf(telefone.charAt(i)));
            }
            telefoneFormatado = "(" + limparTelefone.substring(0, 2) + ")";
            telefoneFormatado += limparTelefone.substring(2, 3) + ".";
            telefoneFormatado += limparTelefone.substring(3, 7) + "-";
            telefoneFormatado += limparTelefone.substring(7, 11);
            return telefoneFormatado;

        } catch (NullPointerException e) {
            throw new Exception("O telefone não pode ter valor nulo.");
        } catch (NumberFormatException e) {
            throw new Exception("Apenas números são permitidos para o telefone");
        } catch (StringIndexOutOfBoundsException e) {
            throw new Exception("Preencha todos os números do telefone");
        }

    }

}
