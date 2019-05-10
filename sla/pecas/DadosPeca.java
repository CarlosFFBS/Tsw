/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sla.pecas;

import conexaojdbc2018.conexao.Dados;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Consultor SCA 02
 */
public class DadosPeca extends Dados implements InterfacePecaSigns {

    @Override
    public void cadastrarPeca(Peca peca) throws Exception {
        String aux = peca.getDescricao().trim();
        aux = aux.substring(0, 1).toUpperCase() + aux.substring(1).toLowerCase();
        peca.setDescricao(aux);
        String sql = " EXEC CADASTRARPECA ?,? ; ";

        PreparedStatement stmt = super.conectarParametros().prepareStatement(sql);
        stmt.setString(1, peca.getDescricao());
        stmt.setFloat(2, peca.getPreco());

        stmt.executeUpdate();
        super.desconectar();

    }

    @Override
    public ArrayList<Peca> consultarPeca(Peca peca) throws Exception {

        String sql = " EXEC CONSULTARPECA ?,? ;";

        PreparedStatement stmt = super.conectarParametros().prepareStatement(sql);

        stmt.setString(1, peca.getDescricao().trim());
        stmt.setInt(2, peca.getCodigo());

        ResultSet rs = stmt.executeQuery();
        ArrayList<Peca> pecasConsultadas = new ArrayList<>();

        while (rs.next()) {

            Peca pecaConsultada = new Peca();
            pecaConsultada.setCodigo(rs.getInt("Pec_Codigo"));
            pecaConsultada.setDescricao(rs.getString("Descricao"));
            pecaConsultada.setPreco(rs.getFloat("Preco"));

            pecasConsultadas.add(pecaConsultada);

        }
        super.desconectar();
        return pecasConsultadas;

    }

    @Override
    public void alterarPeca(Peca peca) throws Exception {


        String aux = peca.getDescricao().trim();
        aux = aux.substring(0, 1).toUpperCase() + aux.substring(1).toLowerCase();
        peca.setDescricao(aux);
        String sql = " EXEC ALTERARPECA ?,?,? ;";
        PreparedStatement stmt = super.conectarParametros().prepareStatement(sql);
        stmt.setString(1, peca.getDescricao());
        stmt.setFloat(2, peca.getPreco());
        stmt.setInt(3, peca.getCodigo());
        stmt.executeUpdate();
        super.desconectar();

    }

    @Override
    public boolean verificaDuplicidadePeca(Peca filtro) throws Exception {

        boolean retorno = false;
        String sql = " SELECT  Descricao,Preco ";
        sql += " FROM PECA ";
        sql += " WHERE Descricao = ? ";
        sql += " AND Preco = ? ";// +  + "'";

        PreparedStatement stmt = super.conectarParametros().prepareStatement(sql);
        stmt.setString(1, filtro.getDescricao().trim());
        stmt.setFloat(2, filtro.getPreco());

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
     
            retorno = true;
            break;
        }
        super.desconectar();
        return retorno;

    }

    @Override
    public ArrayList<Peca> listarPeca(Peca filtro) throws Exception {

        ArrayList<Peca> lista = new ArrayList<>();
        String sql = " EXEC LISTARPECA;";

        // Preparando instrução
        PreparedStatement stmt = super.conectarParametros().prepareStatement(sql);

        //executando a consulta e recebendo retorno do BD
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Peca peca = new Peca();
            peca.setCodigo(rs.getInt("Pec_Codigo"));
            peca.setDescricao(rs.getString("Descricao"));
            peca.setPreco(rs.getFloat("Preco"));
            lista.add(peca);
        }
        super.desconectar();
        return lista;

    }

    @Override
    public void removerPecaCod(Peca peca) throws Exception {

        String sql = " EXEC REMOVERPECA ? ;";
        PreparedStatement stmt = super.conectarParametros().prepareStatement(sql);
        stmt.setInt(1, peca.getCodigo());
        stmt.executeUpdate();
        super.desconectar();

    }

}
