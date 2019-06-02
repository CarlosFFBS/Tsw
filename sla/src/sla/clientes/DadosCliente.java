/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sla.clientes;

import conexaojdbc2018.conexao.Dados;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Consultor SCA 02
 */
public class DadosCliente extends Dados implements InterfaceClienteSigns {

    @Override
    public void removerClientePFCod(ClientePessoaFisica cliente) throws Exception {

        String sql = " EXEC REMOVERCLIENTE ? ";

        PreparedStatement stmt = super.conectarParametros().prepareStatement(sql);
        stmt.setInt(1, cliente.getCli_Codigo());
        stmt.executeUpdate();
        super.desconectar();

    }

    @Override
    public void removerClientePJCod(ClientePessoaJuridica cliente) throws Exception {

        String sql = " EXEC REMOVERCLIENTE ? ";

        PreparedStatement stmt = super.conectarParametros().prepareStatement(sql);
        stmt.setInt(1, cliente.getCli_Codigo());
        stmt.executeUpdate();
        super.desconectar();

    }

    @Override
    public boolean verificaDuplicidadeClientePF(ClientePessoaFisica clientePF) throws Exception {

        boolean retorno = false;
        String sql = " EXEC VERIFICADUPLICIDADEPF ?,?,?,?,?,?,?,?,?,?,?,? ";

        PreparedStatement stmt = super.conectarParametros().prepareStatement(sql);

        stmt.setString(1, clientePF.getLogradouro());
        stmt.setString(2, clientePF.getNumeroLogradouro());
        stmt.setString(3, clientePF.getComplemento());
        stmt.setString(4, clientePF.getBairro());
        stmt.setString(5, clientePF.getCep());
        stmt.setString(6, clientePF.getEstado());
        stmt.setString(7, clientePF.getCidade());
        stmt.setString(8, clientePF.getEmail());
        stmt.setString(9, clientePF.getTelefone());
        stmt.setString(10, clientePF.getCli_Cpf());
        stmt.setString(11, clientePF.getNome());
        stmt.setString(12, clientePF.getSexo());
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            retorno = true;
            break;
        }
        return retorno;

    }

    @Override
    public ArrayList<ClientePessoaFisica> listarClientePF() throws Exception {

        //Código, CPF , nome, endereço, e-mail, telefone
        ArrayList<ClientePessoaFisica> lista = new ArrayList<>();
        String sql = " EXEC LISTARCLIENTEPF ";

        // Preparando instrução
        PreparedStatement stmt = super.conectarParametros().prepareStatement(sql);

        //executando a consulta e recebendo retorno do BD
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            ClientePessoaFisica pf = new ClientePessoaFisica();
            pf.setCli_Codigo(rs.getInt("Cli_Codigo"));
            pf.setCli_Cpf(rs.getString("cli_Cpf"));
            pf.setNome(rs.getString("Nome"));
            pf.setLogradouro(rs.getString("Logradouro"));
            pf.setNumeroLogradouro(rs.getString("NumeroLogradouro"));
            pf.setComplemento(rs.getString("complemento"));
            pf.setBairro(rs.getString("bairro"));
            pf.setCep(rs.getString("cep"));
            pf.setCidade(rs.getString("cidade"));
            pf.setEstado(rs.getString("estado"));
            pf.setEmail(rs.getString("email"));
            pf.setTelefone(rs.getString("telefone"));

            lista.add(pf);
        }
        super.desconectar();
        return lista;

    }

    @Override
    public void cadastrarClientePF(ClientePessoaFisica clientePF) throws Exception {

        String sql = " EXEC CADASTRARCLIENTEPF ?,?,?,?,?,?,?,?,?,?,?,? ";

        PreparedStatement stmt = super.conectarParametros().prepareStatement(sql);
        stmt.setString(1, clientePF.getLogradouro());
        stmt.setString(2, clientePF.getNumeroLogradouro());
        stmt.setString(3, clientePF.getComplemento());
        stmt.setString(4, clientePF.getBairro());
        stmt.setString(5, clientePF.getCep());
        stmt.setString(6, clientePF.getEstado());
        stmt.setString(7, clientePF.getCidade());
        stmt.setString(8, clientePF.getEmail());
        stmt.setString(9, clientePF.getTelefone());
        stmt.setString(10, clientePF.getCli_Cpf());
        stmt.setString(11, clientePF.getNome());
        stmt.setString(12, clientePF.getSexo());
        stmt.executeUpdate();
        super.desconectar();

    }

    @Override
    public void cadastrarClientePJ(ClientePessoaJuridica clientePJ) throws Exception {

        String sql = "EXEC CADASTRARCLIENTEPJ ?,?,?,?,?,?,?,?,?,?,?  ";

        PreparedStatement stmt = super.conectarParametros().prepareStatement(sql);
        stmt.setString(1, clientePJ.getLogradouro());
        stmt.setString(2, clientePJ.getNumeroLogradouro());
        stmt.setString(3, clientePJ.getComplemento());
        stmt.setString(4, clientePJ.getBairro());
        stmt.setString(5, clientePJ.getCep());
        stmt.setString(6, clientePJ.getEstado());
        stmt.setString(7, clientePJ.getCidade());
        stmt.setString(8, clientePJ.getEmail());
        stmt.setString(9, clientePJ.getTelefone());
        stmt.setString(10, clientePJ.getCli_Cnpj());
        stmt.setString(11, clientePJ.getRazaoSocial());
        stmt.executeUpdate();
        super.desconectar();

    }

    @Override
    public boolean verificaDuplicidadeClientePJ(ClientePessoaJuridica clientePJ) throws Exception {

        boolean retorno = false;
        String sql = " EXEC VERIFICADUPLICIDADEPJ ?,?,?,?,?,?,?,?,?,?,? ";

        PreparedStatement stmt = super.conectarParametros().prepareStatement(sql);
        stmt.setString(1, clientePJ.getLogradouro());
        stmt.setString(2, clientePJ.getNumeroLogradouro());
        stmt.setString(3, clientePJ.getComplemento());
        stmt.setString(4, clientePJ.getBairro());
        stmt.setString(5, clientePJ.getCep());
        stmt.setString(6, clientePJ.getEstado());
        stmt.setString(7, clientePJ.getCidade());
        stmt.setString(8, clientePJ.getEmail());
        stmt.setString(9, clientePJ.getTelefone());
        stmt.setString(10, clientePJ.getCli_Cnpj());
        stmt.setString(11, clientePJ.getRazaoSocial());

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            retorno = true;
            break;
        }
        return retorno;

    }

    @Override
    public ArrayList<ClientePessoaJuridica> listarClientePJ() throws Exception {

        //PJ - código, razão, endereço, e-mail, telefone
        ArrayList<ClientePessoaJuridica> lista = new ArrayList<>();
        String sql = " EXEC LISTARCLIENTEPJ ";

        // Preparando instrução
        PreparedStatement stmt = super.conectarParametros().prepareStatement(sql);

//executando a consulta e recebendo retorno do BD
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            ClientePessoaJuridica pj = new ClientePessoaJuridica();
            pj.setCli_Codigo(rs.getInt("Cli_Codigo"));
            pj.setCli_Cnpj(rs.getString("cli_Cnpj"));
            pj.setRazaoSocial(rs.getString("razaoSocial"));
            pj.setLogradouro(rs.getString("Logradouro"));
            pj.setNumeroLogradouro(rs.getString("NumeroLogradouro"));
            pj.setComplemento(rs.getString("complemento"));
            pj.setBairro(rs.getString("bairro"));
            pj.setCep(rs.getString("cep"));
            pj.setCidade(rs.getString("cidade"));
            pj.setEstado(rs.getString("estado"));
            pj.setEmail(rs.getString("email"));
            pj.setTelefone(rs.getString("telefone"));
            lista.add(pj);
        }
        super.desconectar();
        return lista;

    }

    @Override
    public ArrayList<ClientePessoaJuridica> consultarClientePJ(ClientePessoaJuridica cliente) throws Exception {

        ArrayList<ClientePessoaJuridica> lista = new ArrayList<>();
        String sql = "EXEC CONSULTARCLIENTEPJ ?,? ";

        // Preparando instrução
        PreparedStatement stmt = super.conectarParametros().prepareStatement(sql);
        stmt.setInt(1, cliente.getCli_Codigo());
        stmt.setString(2, cliente.getCli_Cnpj());

        //executando a consulta e recebendo retorno do BD
        ResultSet rs = stmt.executeQuery();
        //Finalizando o método caso não volte elementos na consulta

        while (rs.next()) {
            ClientePessoaJuridica pj = new ClientePessoaJuridica();
            pj.setCli_Codigo(rs.getInt("Cli_Codigo"));
            pj.setCli_Cnpj(rs.getString("cli_Cnpj"));
            pj.setRazaoSocial(rs.getString("razaoSocial"));
            pj.setLogradouro(rs.getString("Logradouro"));
            pj.setNumeroLogradouro(rs.getString("NumeroLogradouro"));
            pj.setComplemento(rs.getString("complemento"));
            pj.setBairro(rs.getString("bairro"));
            pj.setCep(rs.getString("cep"));
            pj.setCidade(rs.getString("cidade"));
            pj.setEstado(rs.getString("estado"));
            pj.setEmail(rs.getString("email"));
            pj.setTelefone(rs.getString("telefone"));

            lista.add(pj);
        }
        super.desconectar();
        return lista;

    }

    @Override
    public ArrayList<ClientePessoaFisica> consultarClientePF(ClientePessoaFisica cliente) throws Exception {
      
            ArrayList<ClientePessoaFisica> lista = new ArrayList<>();
            String sql = "EXEC CONSULTARCLIENTEPF ? , ?, ? ";

            // Preparando instrução
            PreparedStatement stmt = super.conectarParametros().prepareStatement(sql);

            stmt.setInt(1, cliente.getCli_Codigo());
            stmt.setString(2, cliente.getCli_Cpf());
            stmt.setString(3, cliente.getNome());

            //executando a consulta e recebendo retorno do BD
            ResultSet rs = stmt.executeQuery();
            //Finalizando o método caso não volte elementos na consulta

            while (rs.next()) {
                ClientePessoaFisica pf = new ClientePessoaFisica();
                pf.setCli_Codigo(rs.getInt("Cli_Codigo"));
                pf.setCli_Cpf(rs.getString("cli_Cpf"));
                pf.setNome(rs.getString("Nome"));
                pf.setLogradouro(rs.getString("Logradouro"));
                pf.setNumeroLogradouro(rs.getString("NumeroLogradouro"));
                pf.setComplemento(rs.getString("complemento"));
                pf.setBairro(rs.getString("bairro"));
                pf.setCep(rs.getString("cep"));
                pf.setCidade(rs.getString("cidade"));
                pf.setEstado(rs.getString("estado"));
                pf.setEmail(rs.getString("email"));
                pf.setTelefone(rs.getString("telefone"));
                pf.setSexo(rs.getString("sexo"));

                lista.add(pf);
            }

            super.desconectar();
            return lista;
        

    }

    @Override
    public void alterarClientePF(ClientePessoaFisica cliente) throws Exception {
        try {
            String aux = cliente.getNome();
            aux = aux.substring(0, 1).toUpperCase() + aux.substring(1).toLowerCase();
            cliente.setNome(aux);

            String sql = " EXEC ALTERARCLIENTEPF ?,?,?,?,?,?,?,?,?,?,?,?,?  ";

            PreparedStatement stmt = super.conectarParametros().prepareStatement(sql);
            stmt.setString(1, cliente.getLogradouro());
            stmt.setString(2, cliente.getNumeroLogradouro());
            stmt.setString(3, cliente.getComplemento());
            stmt.setString(4, cliente.getBairro());
            stmt.setString(5, cliente.getCep());
            stmt.setString(6, cliente.getEstado());
            stmt.setString(7, cliente.getCidade());
            stmt.setString(8, cliente.getEmail());
            stmt.setString(9, cliente.getTelefone());
            stmt.setInt(10, cliente.getCli_Codigo());
            stmt.setString(11, cliente.getCli_Cpf());
            stmt.setString(12, cliente.getNome());
            stmt.setString(13, cliente.getSexo());

            stmt.executeUpdate();

            super.desconectar();
        } catch (Exception e) {
            throw e;
        }

    }

    @Override
    public void alterarClientePJ(ClientePessoaJuridica cliente) throws Exception {
        try {
            String aux = cliente.getRazaoSocial();
            aux = aux.substring(0, 1).toUpperCase() + aux.substring(1).toLowerCase();
            cliente.setRazaoSocial(aux);

            String sql = " EXEC  ALTERARCLIENTEPJ ?,?,?,?,?,?,?,?,?,?,?,? ";

            PreparedStatement stmt = super.conectarParametros().prepareStatement(sql);
            stmt.setString(1, cliente.getLogradouro());
            stmt.setString(2, cliente.getNumeroLogradouro());
            stmt.setString(3, cliente.getComplemento());
            stmt.setString(4, cliente.getBairro());
            stmt.setString(5, cliente.getCep());
            stmt.setString(6, cliente.getEstado());
            stmt.setString(7, cliente.getCidade());
            stmt.setString(8, cliente.getEmail());
            stmt.setString(9, cliente.getTelefone());
            stmt.setInt(10, cliente.getCli_Codigo());
            stmt.setString(11, cliente.getCli_Cnpj());
            stmt.setString(12, cliente.getRazaoSocial());

            stmt.executeUpdate();
            super.desconectar();
        } catch (Exception e) {
            throw e;
        }

    }

}
