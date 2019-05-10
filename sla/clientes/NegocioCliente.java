package sla.clientes;

import java.util.ArrayList;

public class NegocioCliente implements InterfaceClienteSigns {

    @Override
    public void cadastrarClientePF(ClientePessoaFisica clientePF) throws Exception {
        if (clientePF == null) {
            throw new Exception("O objeto não foi instanciado");
        }
        if (clientePF.getCli_Cpf() == null || clientePF.getCli_Cpf().trim().isEmpty()) {
            throw new Exception("Informe o CPF");
        }
        if (clientePF.getCli_Cpf().length() != 14) {
            throw new Exception("Erro ao cadastrar o CPF. Verifique a quantidade de dígitos e tente novamente.");
        }

        if (clientePF.getNome() == null || clientePF.getNome().trim().isEmpty()) {
            throw new Exception("Informe o nome do cliente");
        }
        if (clientePF.getNome().length() > 100) {
            throw new Exception("Limite máximo de 100 caracteres para o nome do cliente.");
        }
        if (clientePF.getTelefone() == null || clientePF.getTelefone().trim().isEmpty() || clientePF.getTelefone().charAt(1) == ' ') {
            throw new Exception("Informe o telefone");
        }

        if (clientePF.getCep() == null || clientePF.getCep().charAt(0) == '.') {
            throw new Exception("Informe o cep");

        }
        if (clientePF.getCep().length() != 10) {
            throw new Exception("Erro ao cadastrar cep. Verifique a quantidade de dígitos e tente novamente.");
        }

        if (clientePF.getLogradouro() == null || clientePF.getLogradouro().trim().isEmpty()) {
            throw new Exception("Informe o endereço");
        }
        if (clientePF.getLogradouro().length() > 60) {
            throw new Exception("Limite máximo de 60 caracteres para o endereço do cliente.");
        }

        if (clientePF.getNumeroLogradouro() == null || clientePF.getNumeroLogradouro().trim().isEmpty()) {
            throw new Exception("Informe o número do endereço");
        }
        if (clientePF.getNumeroLogradouro().length() > 20) {
            throw new Exception("Limite máximo de 20 caracteres para número do endereço do cliente.");
        }
        if (clientePF.getComplemento() != null && clientePF.getComplemento().length() > 20) {
            throw new Exception("Limite máximo de 20 caracteres para o complemento.");
        }
        if (clientePF.getBairro() == null || clientePF.getBairro().trim().isEmpty()) {
            throw new Exception("Informe o bairro");
        }
        if (clientePF.getBairro().length() > 20) {
            throw new Exception("Limite máximo de 20 caracteres para o bairro.");
        }

        if (clientePF.getCidade() == null || clientePF.getCidade().trim().isEmpty()) {
            throw new Exception("Informe a cidade");
        }
        if (clientePF.getCidade().length() > 20) {
            throw new Exception("Limite máximo de 20 caracteres para a cidade.");
        }

        if (clientePF.getEstado() == null || clientePF.getEstado().trim().isEmpty()) {
            throw new Exception("Informe o estado");
        }
        if (clientePF.getEstado().length() != 2) {
            throw new Exception("Limite máximo de 2 caracteres para o estado.");
        }

        if (clientePF.getEmail() == null || clientePF.getEmail().trim().isEmpty()) {
            throw new Exception("Informe o email");
        }
        if (clientePF.getEmail().length() > 50) {
            throw new Exception("Limite máximo de 50 caracteres para o email.");
        }
        if (clientePF.getSexo() == null || clientePF.getSexo().trim().isEmpty()) {
            throw new Exception("Informe o sexo");
        }
        if (clientePF.getSexo().length() != 1) {
            throw new Exception("Limite de 1 caractere para o sexo.");
        }

        boolean teste = verificaDuplicidadeClientePF(clientePF);

        if (teste) {
            throw new Exception("Já existe um cliente para os dados informados");
        }
        DadosCliente a = new DadosCliente();
        a.cadastrarClientePF(clientePF);

    }

    @Override
    public void cadastrarClientePJ(ClientePessoaJuridica clientePJ) throws Exception {
        if (clientePJ == null) {
            throw new Exception("O objeto não foi instanciado");
        }
        if (clientePJ.getCli_Cnpj() == null || clientePJ.getCli_Cnpj().trim().isEmpty()) {
            throw new Exception("Informe o CNPJ");
        }

        if (clientePJ.getRazaoSocial() == null || clientePJ.getRazaoSocial().trim().isEmpty()) {
            throw new Exception("Informe a razão social.");
        }
        if (clientePJ.getRazaoSocial().length() > 60) {
            throw new Exception("Limite máximo de 60 caracteres para a razão social.");
        }
        if (clientePJ.getTelefone() == null || clientePJ.getTelefone().trim().isEmpty() || clientePJ.getTelefone().charAt(1) == ' ') {
            throw new Exception("Informe o telefone");
        }

        if (clientePJ.getCep() == null || clientePJ.getCep().charAt(0) == '.') {
            throw new Exception("Informe o cep");

        }
        if (clientePJ.getCep().length() != 10) {
            throw new Exception("Erro ao cadastrar cep. Verifique a quantidade de dígitos e tente novamente.");
        }

        if (clientePJ.getLogradouro() == null || clientePJ.getLogradouro().trim().isEmpty()) {
            throw new Exception("Informe o endereço");
        }
        if (clientePJ.getLogradouro().length() > 60) {
            throw new Exception("Limite máximo de 60 caracteres para o endereço do cliente.");
        }

        if (clientePJ.getNumeroLogradouro() == null || clientePJ.getNumeroLogradouro().trim().isEmpty()) {
            throw new Exception("Informe o número do endereço");
        }
        if (clientePJ.getNumeroLogradouro().length() > 20) {
            throw new Exception("Limite máximo de 20 caracteres para número do endereço do cliente.");
        }
        if (clientePJ.getComplemento() != null && clientePJ.getComplemento().length() > 20) {
            throw new Exception("Limite máximo de 20 caracteres para o complemento.");
        }
        if (clientePJ.getBairro() == null || clientePJ.getBairro().trim().isEmpty()) {
            throw new Exception("Informe o bairro");
        }
        if (clientePJ.getBairro().length() > 20) {
            throw new Exception("Limite máximo de 20 caracteres para o bairro.");
        }

        if (clientePJ.getCidade() == null || clientePJ.getCidade().trim().isEmpty()) {
            throw new Exception("Informe a cidade");
        }
        if (clientePJ.getCidade().length() > 20) {
            throw new Exception("Limite máximo de 20 caracteres para a cidade.");
        }

        if (clientePJ.getEstado() == null || clientePJ.getEstado().trim().isEmpty()) {
            throw new Exception("Informe o estado");
        }
        if (clientePJ.getEstado().length() != 2) {
            throw new Exception("Erro ao cadastrar o estado.Verifique a quantidade de digitos e tente novamente. Limite de 2 caracteres"
                    + " para a o estado Ex: SP . ");
        }

        if (clientePJ.getEmail() == null || clientePJ.getEmail().trim().isEmpty()) {
            throw new Exception("Informe o email");
        }
        if (clientePJ.getEmail().length() > 50) {
            throw new Exception("Limite máximo de 50 caracteres para o email.");
        }

        boolean teste = verificaDuplicidadeClientePJ(clientePJ);
        if (teste) {
            throw new Exception("Já existe um cliente para os dados informados");
        }
        DadosCliente a = new DadosCliente();
        a.cadastrarClientePJ(clientePJ);
    }

    @Override
    public int consultaCodClientePF(ClientePessoaFisica clientePF) throws Exception {
        DadosCliente a = new DadosCliente();
        int consulta = a.consultaCodClientePF(clientePF);
        return consulta;
    }

    @Override
    public int consultaCodClientePJ(ClientePessoaJuridica clientePJ) throws Exception {
        DadosCliente a = new DadosCliente();
        int consulta = a.consultaCodClientePJ(clientePJ);
        return consulta;
    }

    @Override
    public ArrayList<ClientePessoaFisica> consultarClientePF(ClientePessoaFisica clientePF) throws Exception {
        if (clientePF == null) {
            throw new Exception("O objeto deve ser instanciado.");
        }
        boolean teste1 = false;
        if (clientePF.getCli_Codigo() == null || clientePF.getCli_Codigo() <= 0) {
            clientePF.setCli_Codigo(0);
            teste1 = true;
        }
        boolean teste2 = false;
        if (clientePF.getCli_Cpf() == null || clientePF.getCli_Cpf().equals(".   .   -")) {
            clientePF.setCli_Cpf(" ");
            teste2 = true;
        }

        boolean teste3 = false;
        if (clientePF.getNome() == null || clientePF.getNome().trim().isEmpty() || clientePF.getNome().length() > 50) {
            clientePF.setNome(" ");
            teste3 = true;
        }
        if (teste1 && teste2 && teste3) {
            throw new Exception(" Cliente não localizado para os dados informados");
        }

        ArrayList<ClientePessoaFisica> consulta = new ArrayList<>();
        DadosCliente a = new DadosCliente();
        consulta = a.consultarClientePF(clientePF);
        if (consulta.isEmpty()) {
            throw new Exception("Cliente não localizado");
        }
        return consulta;

    }

    @Override
    public ArrayList<ClientePessoaJuridica> consultarClientePJ(ClientePessoaJuridica clientePJ) throws Exception {
        if (clientePJ == null) {
            throw new Exception("O objeto deve ser instanciado.");
        }
        if (clientePJ.getCli_Codigo() == null || clientePJ.getCli_Codigo() <= 0) {
            clientePJ.setCli_Codigo(0);
        }

        if (clientePJ.getCli_Cnpj() == null || clientePJ.getCli_Cnpj().equals("  .   .   /    -  ")) {
            throw new Exception("Informe o CNPJ.");
        }

        ArrayList<ClientePessoaJuridica> consulta = new ArrayList<>();
        DadosCliente a = new DadosCliente();
        consulta = a.consultarClientePJ(clientePJ);
        if (consulta.isEmpty()) {
            throw new Exception("Cliente não localizado");
        }
        return consulta;
    }

    @Override
    public void removerClientePFCod(ClientePessoaFisica cliente) throws Exception {
        if (cliente == null) {
            throw new Exception(" O objeto deve ser instanciado");
        }
        if (cliente.getCli_Codigo() <= 0) {
            throw new Exception(" Não existe um cliente para os dados informados.");
        }
        DadosCliente a = new DadosCliente();
        a.removerClientePFCod(cliente);

    }

    @Override
    public void removerClientePJCod(ClientePessoaJuridica cliente) throws Exception {
        if (cliente == null) {
            throw new Exception(" O objeto deve ser instanciado");
        }

        if (cliente.getCli_Codigo() <= 0) {
            throw new Exception(" Não existe um cliente para os dados informados.");
        }
        DadosCliente a = new DadosCliente();
        a.removerClientePJCod(cliente);
    }

    @Override
    public void alterarClientePF(ClientePessoaFisica clientePF) throws Exception {
        if (clientePF == null) {
            throw new Exception("O objeto não foi instanciado");
        }
        if (clientePF.getCli_Cpf() == null || clientePF.getCli_Cpf().trim().isEmpty()) {
            throw new Exception("Informe o CPF");
        }
        if (clientePF.getCli_Cpf().length() != 14) {
            throw new Exception("Erro ao cadastrar o CPF. Verifique a quantidade de dígitos e tente novamente.");
        }

        if (clientePF.getNome() == null || clientePF.getNome().trim().isEmpty()) {
            throw new Exception("Informe o nome do cliente");
        }
        if (clientePF.getNome().length() > 100) {
            throw new Exception("Limite máximo de 100 caracteres para o nome do cliente.");
        }
        if (clientePF.getTelefone() == null || clientePF.getTelefone().trim().isEmpty() || clientePF.getTelefone().charAt(1) == ' ') {
            throw new Exception("Informe o telefone");
        }

        if (clientePF.getCep() == null || clientePF.getCep().charAt(0) == '.') {
            throw new Exception("Informe o cep");

        }
        if (clientePF.getCep().length() != 10) {
            throw new Exception("Erro ao cadastrar cep. Verifique a quantidade de dígitos e tente novamente.");
        }

        if (clientePF.getLogradouro() == null || clientePF.getLogradouro().trim().isEmpty()) {
            throw new Exception("Informe o endereço");
        }
        if (clientePF.getLogradouro().length() > 60) {
            throw new Exception("Limite máximo de 60 caracteres para o endereço do cliente.");
        }

        if (clientePF.getNumeroLogradouro() == null || clientePF.getNumeroLogradouro().trim().isEmpty()) {
            throw new Exception("Informe o número do endereço");
        }
        if (clientePF.getNumeroLogradouro().length() > 20) {
            throw new Exception("Limite máximo de 20 caracteres para número do endereço do cliente.");
        }
        if (clientePF.getComplemento() != null && clientePF.getComplemento().length() > 20) {
            throw new Exception("Limite máximo de 20 caracteres para o complemento.");
        }
        if (clientePF.getBairro() == null || clientePF.getBairro().trim().isEmpty()) {
            throw new Exception("Informe o bairro");
        }
        if (clientePF.getBairro().length() > 20) {
            throw new Exception("Limite máximo de 20 caracteres para o bairro.");
        }

        if (clientePF.getCidade() == null || clientePF.getCidade().trim().isEmpty()) {
            throw new Exception("Informe a cidade");
        }
        if (clientePF.getCidade().length() > 20) {
            throw new Exception("Limite máximo de 20 caracteres para a cidade.");
        }

        if (clientePF.getEstado() == null || clientePF.getEstado().trim().isEmpty()) {
            throw new Exception("Informe o estado");
        }
        if (clientePF.getEstado().length() != 2) {
            throw new Exception("Limite máximo de 2 caracteres para o estado.");
        }

        if (clientePF.getEmail() == null || clientePF.getEmail().trim().isEmpty()) {
            throw new Exception("Informe o email");
        }
        if (clientePF.getEmail().length() > 50) {
            throw new Exception("Limite máximo de 50 caracteres para o email.");
        }
        if (clientePF.getSexo() == null || clientePF.getSexo().trim().isEmpty()) {
            throw new Exception("Informe o sexo");
        }
        if (clientePF.getSexo().length() != 1) {
            throw new Exception("Limite de 1 caractere para o sexo.");
        }

        boolean teste = verificaDuplicidadeClientePF(clientePF);

        if (teste) {
            throw new Exception("Já existe um cliente para os dados informados");
        }
        DadosCliente a = new DadosCliente();
        a.alterarClientePF(clientePF);

    }

    @Override
    public void alterarClientePJ(ClientePessoaJuridica clientePJ) throws Exception {
        if (clientePJ == null) {
            throw new Exception("O objeto não foi instanciado");
        }
        if (clientePJ.getCli_Cnpj() == null || clientePJ.getCli_Cnpj().trim().isEmpty()) {
            throw new Exception("Informe o CNPJ");
        }
        if (clientePJ.getCli_Cnpj().length() != 18) {
            throw new Exception("Erro ao atualizar CNPJ. Verifique a quantidade de dígitos e tente novamente.");
        }

        if (clientePJ.getRazaoSocial() == null || clientePJ.getRazaoSocial().trim().isEmpty()) {
            throw new Exception("Informe a razão social.");
        }
        if (clientePJ.getRazaoSocial().length() > 60) {
            throw new Exception("Limite máximo de 60 caracteres para a razão social.");
        }
        if (clientePJ.getTelefone() == null || clientePJ.getTelefone().trim().isEmpty() || clientePJ.getTelefone().charAt(1) == ' ') {
            throw new Exception("Informe o telefone");
        }

        if (clientePJ.getCep() == null || clientePJ.getCep().charAt(0) == '.') {
            throw new Exception("Informe o cep");

        }
        if (clientePJ.getCep().length() != 10) {
            throw new Exception("Erro ao cadastrar cep. Verifique a quantidade de dígitos e tente novamente.");
        }

        if (clientePJ.getLogradouro() == null || clientePJ.getLogradouro().trim().isEmpty()) {
            throw new Exception("Informe o endereço");
        }
        if (clientePJ.getLogradouro().length() > 60) {
            throw new Exception("Limite máximo de 60 caracteres para o endereço do cliente.");
        }

        if (clientePJ.getNumeroLogradouro() == null || clientePJ.getNumeroLogradouro().trim().isEmpty()) {
            throw new Exception("Informe o número do endereço");
        }
        if (clientePJ.getNumeroLogradouro().length() > 20) {
            throw new Exception("Limite máximo de 20 caracteres para número do endereço do cliente.");
        }
        if (clientePJ.getComplemento() != null && clientePJ.getComplemento().length() > 20) {
            throw new Exception("Limite máximo de 20 caracteres para o complemento.");
        }
        if (clientePJ.getBairro() == null || clientePJ.getBairro().trim().isEmpty()) {
            throw new Exception("Informe o bairro");
        }
        if (clientePJ.getBairro().length() > 20) {
            throw new Exception("Limite máximo de 20 caracteres para o bairro.");
        }

        if (clientePJ.getCidade() == null || clientePJ.getCidade().trim().isEmpty()) {
            throw new Exception("Informe a cidade");
        }
        if (clientePJ.getCidade().length() > 20) {
            throw new Exception("Limite máximo de 20 caracteres para a cidade.");
        }

        if (clientePJ.getEstado() == null || clientePJ.getEstado().trim().isEmpty()) {
            throw new Exception("Informe o estado");
        }
        if (clientePJ.getEstado().length() != 2) {
            throw new Exception("Erro ao cadastrar o estado.Verifique a quantidade de digitos e tente novamente. Limite de 2 caracteres"
                    + " para a o estado Ex: SP . ");
        }

        if (clientePJ.getEmail() == null || clientePJ.getEmail().trim().isEmpty()) {
            throw new Exception("Informe o email");
        }
        if (clientePJ.getEmail().length() > 50) {
            throw new Exception("Limite máximo de 50 caracteres para o email.");
        }

        boolean teste = verificaDuplicidadeClientePJ(clientePJ);
        if (teste) {
            throw new Exception("Já existe um cliente para os dados informados");
        }
        DadosCliente a = new DadosCliente();
        a.alterarClientePJ(clientePJ);
    }

    @Override
    public boolean verificaDuplicidadeClientePF(ClientePessoaFisica filtroPF) throws Exception {
        if (filtroPF == null) {
            throw new Exception("O objeto deve ser instanciado");
        }

        if ((filtroPF.getCli_Cpf() == null || filtroPF.getCli_Cpf().trim().isEmpty())) {
            throw new Exception("Informe o cpf do cliente");

        }

        DadosCliente a = new DadosCliente();
        boolean duplicada = a.verificaDuplicidadeClientePF(filtroPF);
        return duplicada;
    }

    @Override
    public boolean verificaDuplicidadeClientePJ(ClientePessoaJuridica filtroPJ) throws Exception {

        if (filtroPJ == null) {
            throw new Exception("O objeto deve ser instanciado");
        }
        if (filtroPJ.getCli_Cnpj() == null || filtroPJ.getCli_Cnpj().trim().isEmpty()) {
            throw new Exception("Informe o cnpj do cliente");
        }

        DadosCliente a = new DadosCliente();
        boolean duplicada = a.verificaDuplicidadeClientePJ(filtroPJ);
        return duplicada;

    }

    @Override
    public ArrayList<ClientePessoaFisica> listarClientePF() throws Exception {
        DadosCliente a = new DadosCliente();
        ArrayList<ClientePessoaFisica> lista = a.listarClientePF();
        return lista;

    }

    @Override
    public ArrayList<ClientePessoaJuridica> listarClientePJ() throws Exception {
        DadosCliente a = new DadosCliente();
        ArrayList<ClientePessoaJuridica> lista = a.listarClientePJ();
        return lista;
    }

}
