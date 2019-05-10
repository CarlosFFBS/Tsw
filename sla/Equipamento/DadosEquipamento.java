/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sla.Equipamento;

import conexaojdbc2018.conexao.Dados;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Fabiano
 */
public class DadosEquipamento extends Dados implements InterfaceEquipamento {

    @Override
    public void cadastrarEquipamento(Equipamento e) throws Exception {
        String sql = "INSERT INTO Equipamento (descricao, serial, idContrato) ";
        sql += " VALUES (?,?,?)";
        //preparando a instrução
        PreparedStatement stmt = super.conectarParametros().prepareStatement(sql);
        //passando os valores para os parametros
        stmt.setString(1, e.getDescricao().trim());
        stmt.setString(2, e.getSerial().trim());
        stmt.setInt(3, e.getContrato().getIdContrato());
        // execute insert SQL stetement
        stmt.executeUpdate();
        //fechando a conexão com o banco de dados
        super.desconectar();
    }

    @Override
    public void removerEquipamento(Equipamento e) throws Exception {
        String sql = "DELETE FROM equipamento WHERE codigo = ? ";

        //preparando a instrução
        PreparedStatement stmt = super.conectarParametros().prepareStatement(sql);
        //passando os valores para os parametros
        stmt.setInt(1, e.getCodigo());
        // execute insert SQL stetement
        stmt.executeUpdate();
        //fechando a conexão com o banco de dados
        super.desconectar();
    }

    @Override
    public void alterarEquipamento(Equipamento e) throws Exception {
        String sql = "update Equipamento set ";
        sql += " Descricao = ?, serial = ?, idContrato = ? ";
        sql += " WHERE codigo = ? ";
        //preparando a instrução
        PreparedStatement stmt = super.conectarParametros().prepareStatement(sql);
        //passando os valores para os parametros
        stmt.setString(1, e.getDescricao().trim());
        stmt.setString(2, e.getSerial().trim());
        stmt.setInt(3, e.getContrato().getIdContrato());
        stmt.setInt(4, e.getCodigo());
        // execute insert SQL stetement
        stmt.executeUpdate();
        //fechando a conexão com o banco de dados
        super.desconectar();
    }

    @Override
    public ArrayList<Equipamento> listarEquipamento() throws Exception {
        ArrayList<Equipamento> lista = new ArrayList<>();

        //instrução sql correspondente a projeção dos registros do aluno
        String sql = " select e.codigo, e.descricao, e.serial, e.idContrato ";
        sql += " from equipamento as e ";
        sql += " where codigo > 0 ";

        //preparando a instrução
        PreparedStatement stmt = super.conectarParametros().prepareStatement(sql);
        ResultSet leitor = stmt.executeQuery();
        //lendo os resultados
        while (leitor.next()) {
            Equipamento e = new Equipamento();
            e.setCodigo(leitor.getInt("Código"));
            e.setDescricao(leitor.getString("Descrição"));
            e.setSerial(leitor.getString("Serial"));
            e.getContrato().setIdContrato(leitor.getInt("Contrato"));
            lista.add(e);
        }
        //fechando a conexão com o banco de dados
        super.desconectar();
        return lista;
    }

    @Override
    public ArrayList<Equipamento> consultarEquipamentoContrato(Equipamento filtro) throws Exception {
        ArrayList<Equipamento> lista = new ArrayList<>();

        //instrução sql correspondente a projeção dos registros do aluno
        String sql = " select e.codigo, e.descricao, e.serial, e.idContrato ";
        sql += " from equipamento as e ";
        sql += " where codigo > 0 ";

        if (filtro.getCodigo() > 0) {
            sql += " and idContrato = ? ";
        }
        //preparando a instrução
        PreparedStatement stmt = super.conectarParametros().prepareStatement(sql);

        if (filtro.getCodigo() > 0) {
            stmt.setInt(1, filtro.getContrato().getIdContrato());
        }
        //executando a instrução sql
        ResultSet leitor = stmt.executeQuery();
        //lendo os resultados
        while (leitor.next()) {
            Equipamento e = new Equipamento();
            e.setCodigo(leitor.getInt("Código"));
            e.setDescricao(leitor.getString("Descrição"));
            e.setSerial(leitor.getString("Serial"));
            e.getContrato().setIdContrato((leitor.getInt("Contrato")));
            lista.add(e);
        }
        //fechando a conexão com o banco de dados
        super.desconectar();
        return lista;
    }

    @Override
    public ArrayList<Equipamento> consultarEquipamentoSerial(Equipamento filtro) throws Exception {
        ArrayList<Equipamento> lista = new ArrayList<>();

        //instrução sql correspondente a projeção dos registros do aluno
        String sql = " select e.codigo, e.descricao, e.serial, e.idContrato ";
        sql += " from equipamento as e ";
        sql += " where codigo > 0 ";

        if (filtro.getCodigo() > 0) {
            sql += " and Serial = ? ";
        }
        //preparando a instrução
        PreparedStatement stmt = super.conectarParametros().prepareStatement(sql);

        if (filtro.getCodigo() > 0) {
            stmt.setString(1, filtro.getSerial().trim());
        }
        //executando a instrução sql
        ResultSet leitor = stmt.executeQuery();
        //lendo os resultados
        while (leitor.next()) {
            Equipamento e = new Equipamento();
            e.setCodigo(leitor.getInt("Código"));
            e.setDescricao(leitor.getString("Descrição"));
            e.setSerial(leitor.getString("Serial"));
            e.getContrato().setIdContrato(leitor.getInt("Contrato"));
            lista.add(e);
        }
        //fechando a conexão com o banco de dados
        super.desconectar();
        return lista;
    }

    @Override
    public Boolean verificarDuplicidadeEquipamento(Equipamento e) throws Exception {
        boolean teste = false;
        String sql = " SELECT Codigo,Descricao,Serial,idContrato ";
        sql += " FROM Equipamento as E ";
        sql += " WHERE e.idContrato = ? and e.Serial = ? ";// +  + "'";

        PreparedStatement stmt = super.conectarParametros().prepareStatement(sql);
        stmt.setInt(1, e.getContrato().getIdContrato());
        stmt.setString(2, e.getSerial().trim());

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            teste = true;
            break;
        }
        return teste;
    }
}
