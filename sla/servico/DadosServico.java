/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sla.servico;

import conexaojdbc2018.conexao.Dados;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;




/**
 *
 * @author Consultor SCA 02
 */
public class DadosServico extends Dados implements InterfaceServico {

    @Override
    public void cadastrarServico(Servico servico) throws Exception {
        /*
        String aux = servico.getDescricao().trim();
        aux = aux.substring(0, 1).toUpperCase() + aux.substring(1).toLowerCase();
        servico.setDescricao(aux);
        String sql = " INSERT INTO SERVICO ( Descricao, Preco) ";
        sql += " VALUES (?,?) ";
        PreparedStatement preparedStatement = super.conectarParametros().prepareStatement(sql);
        preparedStatement.setString(1, servico.getDescricao());
        preparedStatement.setFloat(2, servico.getPreco());
        preparedStatement.executeUpdate();
        super.desconectar(); */

        String aux = servico.getDescricao().trim();
        aux = aux.substring(0, 1).toUpperCase() + aux.substring(1).toLowerCase();
        servico.setDescricao(aux);

        String sql = "EXEC CADASTRARSERVICO ?,? ; ";
        PreparedStatement stmt = super.conectarParametros().prepareStatement(sql);
        stmt.setString(1, servico.getDescricao());
        stmt.setFloat(2, servico.getPreco());
        stmt.executeUpdate();
        super.desconectar();

    }

    @Override
    public ArrayList<Servico> consultarServico(Servico servico) throws Exception {
        /*  String sql = " SELECT Ser_Codigo, Descricao, Preco ";
        sql += " FROM SERVICO WHERE  ";
        if (servico.getCodServico() > 0) {
            sql += " Ser_Codigo = " + servico.getCodServico();
        } else {
            sql += "  Descricao  LIKE '%" + servico.getDescricao() + "%' ";
        }  */

        String sql = " EXEC CONSULTARSERVICO ?,? ";

        PreparedStatement stmt = super.conectarParametros().prepareStatement(sql);
        stmt.setString(1, servico.getDescricao());
        stmt.setInt(2, servico.getCodServico());

        ResultSet rs = stmt.executeQuery();
        ArrayList<Servico> servicosConsultados = new ArrayList<>();

        while (rs.next()) {

            Servico servicoConsultado = new Servico();
            servicoConsultado.setCodServico(rs.getInt("Ser_Codigo"));
            servicoConsultado.setDescricao(rs.getString("Descricao"));
            servicoConsultado.setPreco(rs.getFloat("Preco"));

            servicosConsultados.add(servicoConsultado);

        }
        super.desconectar();
        return servicosConsultados;
    }

    @Override
    public void removerServicoCod(Servico servico) throws Exception {
        /* String sql = " DELETE FROM SERVICO WHERE ";
        sql += " Ser_Codigo =  " + servico.getCodServico();  */

        String sql = " EXEC REMOVERSERVICO ? ; ";
        PreparedStatement stmt = super.conectarParametros().prepareStatement(sql);
        stmt.setInt(1, servico.getCodServico());
        stmt.executeUpdate();
        super.desconectar();
    }

    @Override
    public void alterarServico(Servico servico) throws Exception {
        String aux = servico.getDescricao();
        aux = aux.substring(0, 1).toUpperCase() + aux.substring(1).toLowerCase();
        servico.setDescricao(aux);
        /*
        String sql = " UPDATE SERVICO SET  ";
        sql += " Descricao = ?, ";
        sql += " Preco = ? ";
        sql += "WHERE Ser_codigo = ? "; */ 
        String sql = " EXEC ALTERARSERVICO ?,?,? ;";

        PreparedStatement stmt = super.conectarParametros().prepareStatement(sql);
        stmt.setString(1, servico.getDescricao());
        stmt.setFloat(2, servico.getPreco());
        stmt.setInt(3, servico.getCodServico());
        stmt.executeUpdate();
        super.desconectar();

    }

    @Override
    public boolean verificaDuplicidadeServico(Servico filtro) throws Exception {
        boolean retorno = false;
        String sql = " SELECT  Ser_Codigo ";
        sql += " FROM SERVICO ";
        sql += " WHERE Descricao = ? ";
        sql += " AND Preco = ? ";

        PreparedStatement stmt = super.conectarParametros().prepareStatement(sql);
        stmt.setString(1, filtro.getDescricao().trim());
        stmt.setFloat(2, filtro.getPreco());
     

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            //   if ((rs.getString("Descricao").equalsIgnoreCase(filtro.getDescricao())) && (rs.getFloat("Preco") == filtro.getPreco())) {
            //     retorno = true;

            // }
            retorno = true;
            break;
        }
        super.desconectar();
        return retorno;

    }

    @Override
    public ArrayList<Servico> listarServico() throws Exception {
        ArrayList<Servico> lista = new ArrayList<>();
        /*
        String sql = " SELECT Ser_Codigo,Descricao,Preco ";
        sql += " FROM SERVICO ";
        sql += " WHERE Ser_Codigo >= 0 ";
        if (filtro.getCodServico() > 0) {
            sql += " and Ser_Codigo = ?";
        }  */

        String sql = " EXEC LISTARSERVICO ;";

        // Preparando instrução
        PreparedStatement stmt = super.conectarParametros().prepareStatement(sql);

        //executando a consulta e recebendo retorno do BD
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Servico servico = new Servico();
            servico.setCodServico(rs.getInt("Ser_Codigo"));
            servico.setDescricao(rs.getString("Descricao"));
            servico.setPreco(rs.getFloat("Preco"));
            lista.add(servico);
        }
        super.desconectar();
        return lista;

    }

}
