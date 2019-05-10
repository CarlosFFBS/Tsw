package sla.contrato;

import conexaojdbc2018.conexao.Dados;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import sla.operacoes.Operacao;

public class DadosContrato extends Dados implements InterfaceContrato {

    @Override
    public void cadastrarContratoPF(ContratoPF contratopf) throws Exception {
        String sql = "INSERT INTO contrato (inicioContrato,fimContrato,umAtendimento,fimAtendimento,totalEquipamento,valor,cobrepeca,cli_Codigo)  ";
        sql += "  VALUES(?,?,?,?,?,?,?,?); ";

        //preparando a instrução
        PreparedStatement stmt = super.conectarParametros().prepareStatement(sql);
        //passando os valores para os parametros
        Operacao op = new Operacao();
        java.sql.Date dataInicioSQL = op.dataJavaSql(contratopf.getInicioContrato());
        java.sql.Date dataFimSql = op.dataJavaSql(contratopf.getFimContrato());

        stmt.setDate(1, dataInicioSQL);
        stmt.setDate(2, dataFimSql);
        stmt.setInt(3, contratopf.getUmAtendimento());
        stmt.setInt(4, contratopf.getFimAtendimento());
        stmt.setInt(5, contratopf.getTotalEquipamento());
        stmt.setFloat(6, contratopf.getValor());
        stmt.setBoolean(7, contratopf.isCobrePeca());
        stmt.setInt(8, contratopf.getClientePF().getCli_Codigo());

        // execute insert SQL stetement
        stmt.executeUpdate();
        //fechando a conexão com o banco de dados
        super.desconectar();
    }

    @Override
    public void cadastrarContratoPJ(ContratoPJ contratopj) throws Exception {
        String sql = "INSERT INTO contrato (inicioContrato,fimContrato,umAtendimento,fimAtendimento,totalEquipamento,valor,cobrepeca,cli_Codigo)  ";
        sql += "  VALUES(?,?,?,?,?,?,?,?); ";

        //preparando a instrução
        PreparedStatement stmt = super.conectarParametros().prepareStatement(sql);
        //passando os valores para os parametros
        Operacao op = new Operacao();
        java.sql.Date dataInicioSQL = op.dataJavaSql(contratopj.getInicioContrato());
        java.sql.Date dataFimSql = op.dataJavaSql(contratopj.getFimContrato());

        stmt.setDate(1, dataInicioSQL);
        stmt.setDate(2, dataFimSql);
        stmt.setInt(3, contratopj.getUmAtendimento());
        stmt.setInt(4, contratopj.getFimAtendimento());
        stmt.setInt(5, contratopj.getTotalEquipamento());
        stmt.setFloat(6, contratopj.getValor());
        stmt.setBoolean(7, contratopj.isCobrePeca());
        stmt.setInt(8, contratopj.getClientePJ().getCli_Codigo());

        // execute insert SQL stetement
        stmt.executeUpdate();
        //fechando a conexão com o banco de dados
        super.desconectar();
    }

    @Override
    public void removerContratoPF(ContratoPF contratopf) throws Exception {
        String sql = " DELETE FROM CONTRATO AS C WHERE ";
        sql += " C.idContrato =  ? ";
        PreparedStatement stmt = super.conectarParametros().prepareStatement(sql);
        stmt.setInt(1, contratopf.getIdContrato());
        stmt.executeUpdate();
        super.desconectar();
    }

    @Override
    public void removerContratoPJ(ContratoPJ contratopj) throws Exception {
        String sql = " DELETE FROM CONTRATO AS C WHERE ";
        sql += " C.idContrato =  ? ";
        PreparedStatement stmt = super.conectarParametros().prepareStatement(sql);
        stmt.setInt(1, contratopj.getIdContrato());
        stmt.executeUpdate();
        super.desconectar();
    }

    @Override
    public void alterarContratoPF(ContratoPF contratopf) throws Exception {
        Operacao op = new Operacao();
        java.sql.Date dataInicioSQL = op.dataJavaSql(contratopf.getInicioContrato());
        java.sql.Date dataFimSql = op.dataJavaSql(contratopf.getFimContrato());

        String sql = " UPDATE contrato SET  ";
        sql += " inicioContrato = ?, ";
        sql += " fimContrato = ?, ";
        sql += " umAtendimento = ?, ";
        sql += " fimAtendimento = ?, ";
        sql += " totalEquipamento = ?, ";
        sql += " valor = ?, ";
        sql += " cobrePeca = ?, ";
        sql += " WHERE idContrato = ? ; ";

        PreparedStatement stmt = super.conectarParametros().prepareStatement(sql);
        stmt.setDate(1, dataInicioSQL);
        stmt.setDate(2, dataFimSql);
        stmt.setInt(3, contratopf.getUmAtendimento());
        stmt.setInt(4, contratopf.getFimAtendimento());
        stmt.setInt(5, contratopf.getTotalEquipamento());
        stmt.setFloat(6, contratopf.getValor());
        stmt.setBoolean(7, contratopf.isCobrePeca());
        stmt.setInt(8, contratopf.getClientePF().getCli_Codigo());
        stmt.executeUpdate();

        super.desconectar();
    }

    @Override
    public void alterarContratoPJ(ContratoPJ contratopj) throws Exception {
        Operacao op = new Operacao();
        java.sql.Date dataInicioSQL = op.dataJavaSql(contratopj.getInicioContrato());
        java.sql.Date dataFimSql = op.dataJavaSql(contratopj.getFimContrato());

        String sql = " UPDATE contrato SET  ";
        sql += " inicioContrato = ?, ";
        sql += " fimContrato = ?, ";
        sql += " umAtendimento = ?, ";
        sql += " fimAtendimento = ?, ";
        sql += " totalEquipamento = ?, ";
        sql += " valor = ?, ";
        sql += " cobrePeca = ?, ";
        sql += " WHERE idContrato = ? ; ";

        PreparedStatement stmt = super.conectarParametros().prepareStatement(sql);
        stmt.setDate(1, dataInicioSQL);
        stmt.setDate(2, dataFimSql);
        stmt.setInt(3, contratopj.getUmAtendimento());
        stmt.setInt(4, contratopj.getFimAtendimento());
        stmt.setInt(5, contratopj.getTotalEquipamento());
        stmt.setFloat(6, contratopj.getValor());
        stmt.setBoolean(7, contratopj.isCobrePeca());
        stmt.setInt(8, contratopj.getClientePJ().getCli_Codigo());
        stmt.executeUpdate();

        super.desconectar();
    }

    @Override
    public ArrayList<ContratoPF> consultarPFContrato(ContratoPF contratopf) throws Exception {
        ArrayList<ContratoPF> lista = new ArrayList<>();
        //    ClientePessoaFisica clientePF = new ClientePessoaFisica();

        String sql = " SELECT C.idContrato, PF.cli_Cpf, PF.nome, C.inicioContrato, C.fimContrato, C.totalEquipamento, C.valor  ";
        sql += " FROM contrato AS C ";
        sql += " INNER JOIN CLIENTE AS cli ON cli.cli_Codigo = C.cli_Codigo ";
        sql += " INNER JOIN PF ON cli.Cli_Codigo = PF.cli_Codigo  ";
        sql += " WHERE PF.cli_Cpf = ? ";

        // Preparando instrução
        PreparedStatement stmt = super.conectarParametros().prepareStatement(sql);
        stmt.setString(1, contratopf.getClientePF().getCli_Cpf());
        //executando a consulta e recebendo retorno do BD
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            ContratoPF pf = new ContratoPF();
            pf.setIdContrato(rs.getInt("idContrato"));
            pf.getClientePF().setCli_Cpf(rs.getString("cli_Cpf"));
            pf.getClientePF().setNome(rs.getString("nome"));
            pf.setInicioContrato(rs.getDate("inicioContrato"));
            pf.setFimContrato(rs.getDate("fimContrato"));
            pf.setTotalEquipamento(rs.getInt("totalEquipamento"));
            pf.setValor(rs.getFloat("valor"));
            lista.add(pf);
        }
        super.desconectar();
        return lista;
    }

    @Override
    public ArrayList<ContratoPJ> consultarPJContrato(ContratoPJ contratopj) throws Exception {
        ArrayList<ContratoPJ> lista = new ArrayList<>();
        //  ClientePessoaJuridica clientePJ = new ClientePessoaJuridica();

        String sql = " SELECT C.idContrato, PJ.cli_Cnpj, PJ.razaoSocial, C.inicioContrato, C.fimContrato,C.umAtendimento, C.fimAtendimento, C.totalEquipamento, C.valor  ";
        sql += " FROM contrato AS C ";
        sql += " INNER JOIN CLIENTE AS CLI ON CLI.cli_Codigo = C.cli_Codigo ";
        sql += " INNER JOIN PJ ON CLI.cli_Codigo = PJ.cli_Codigo ";
        sql += " WHERE PJ.cli_Cnpj = ? ";

        // Preparando instrução
        PreparedStatement stmt = super.conectarParametros().prepareStatement(sql);
        stmt.setString(1, contratopj.getClientePJ().getCli_Cnpj());
        //executando a consulta e recebendo retorno do BD
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            ContratoPJ pj = new ContratoPJ();
            pj.setIdContrato(rs.getInt("idContrato"));
            pj.getClientePJ().setCli_Cnpj(rs.getString("cli_Cnpj"));
            pj.getClientePJ().setRazaoSocial(rs.getString("razaoSocial"));
            pj.setInicioContrato(rs.getDate("inicioContrato"));
            pj.setFimContrato(rs.getDate("fimContrato"));
            pj.setUmAtendimento(rs.getInt("umAtendimento"));
            pj.setFimAtendimento(rs.getInt("fimAtendimento"));
            pj.setTotalEquipamento(rs.getInt("totalEquipamento"));
            pj.setValor(rs.getFloat("valor"));
            lista.add(pj);
        }
        super.desconectar();
        return lista;
    }

    @Override
    public ArrayList<ContratoPF> listarContratoPF() throws Exception {
        ArrayList<ContratoPF> lista = new ArrayList<>();
        // ClientePessoaFisica clientePF = new ClientePessoaFisica();

        String sql = " SELECT C.idContrato, PF.cli_Cpf, PF.nome, C.inicioContrato, C.fimContrato, C.umAtendimento, C.fimAtendimento, C.totalEquipamento, C.valor  ";
        sql += " FROM contrato AS C ";
        sql += " INNER JOIN CLIENTE AS cli ON cli.cli_Codigo = C.cli_Codigo ";
        sql += " INNER JOIN PF ON cli.Cli_Codigo = PF.cli_Codigo  ";
        sql += " WHERE C.idContrato > 0 ";

        // Preparando instrução
        PreparedStatement stmt = super.conectarParametros().prepareStatement(sql);

        //executando a consulta e recebendo retorno do BD
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            ContratoPF pf = new ContratoPF();
            pf.setIdContrato(rs.getInt("idContrato"));
            pf.getClientePF().setCli_Cpf(rs.getString("cli_CPF"));
            pf.getClientePF().setNome(rs.getString("NOME"));
            pf.setInicioContrato(rs.getDate("inicioContrato"));
            pf.setFimContrato(rs.getDate("fimContrato"));
            pf.setUmAtendimento(rs.getInt("umAtendimento"));
            pf.setFimAtendimento(rs.getInt("fimAtendimento"));
            pf.setTotalEquipamento(rs.getInt("totalEquipamento"));
            pf.setValor(rs.getFloat("valor"));
            lista.add(pf);
        }
        super.desconectar();
        return lista;
    }

    @Override
    public ArrayList<ContratoPJ> listarContratoPJ() throws Exception {
        ArrayList<ContratoPJ> lista = new ArrayList<>();
        //    ClientePessoaJuridica clientePJ = new ClientePessoaJuridica();

        String sql = " SELECT C.idContrato, PJ.cli_Cnpj, PJ.razaoSocial, C.inicioContrato, C.fimContrato,C.umAtendimento, C.fimAtendimento, C.totalEquipamento, C.valor  ";
        sql += " FROM contrato AS C ";
        sql += " INNER JOIN CLIENTE AS cli ON cli.cli_Codigo = C.cli_Codigo ";
        sql += " INNER JOIN PJ ON C.idContrato = PJ.idContrato ";
        sql += " WHERE C.idContrato > 0 ";

        // Preparando instrução
        PreparedStatement stmt = super.conectarParametros().prepareStatement(sql);

        //executando a consulta e recebendo retorno do BD
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            ContratoPJ pj = new ContratoPJ();
            pj.setIdContrato(rs.getInt("idContrato"));
            pj.getClientePJ().setCli_Cnpj(rs.getString("cli_Cnpj"));
            pj.getClientePJ().setRazaoSocial(rs.getString("razaoSocial"));
            pj.setInicioContrato(rs.getDate("inicioContrato"));
            pj.setFimContrato(rs.getDate("fimContrato"));
            pj.setUmAtendimento(rs.getInt("umAtendimento"));
            pj.setFimAtendimento(rs.getInt("fimAtendimento"));
            pj.setTotalEquipamento(rs.getInt("totalEquipamento"));
            pj.setValor(rs.getFloat("valor"));
            lista.add(pj);
        }
        super.desconectar();
        return lista;
    }

    @Override
    public Boolean verificarDuplicidadeContratoPF(ContratoPF filtroPF) throws Exception {
        boolean retorno = false;
        String sql = " SELECT  C.idContrato  ";
        sql += " FROM CONTRATO AS C ";
        sql += " INNER JOIN CLIENTE ON CLIENTE.cli_Codigo = C.cli_Codigo  ";
        sql += " WHERE C.inicioContrato = ?  AND C.fimContrato = ?  AND C.valor = ?   ";
        sql += " AND C.cli_Codigo = ? ";
        PreparedStatement stmt = super.conectarParametros().prepareStatement(sql);
        Operacao op = new Operacao();
        java.sql.Date dataInicioSQL = op.dataJavaSql(filtroPF.getInicioContrato());
        java.sql.Date dataFimSql = op.dataJavaSql(filtroPF.getFimContrato());

        stmt.setDate(1, dataInicioSQL);
        stmt.setDate(2, dataFimSql);
        stmt.setFloat(3, filtroPF.getValor());
        stmt.setInt(4, filtroPF.getClientePF().getCli_Codigo());
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            retorno = true;
            break;
        }
        return retorno;
    }

    @Override
    public Boolean verificarDuplicidadeContratoPJ(ContratoPJ filtroPJ) throws Exception {
        boolean retorno = false;
        String sql = " SELECT  C.idContrato  ";
        sql += " FROM CONTRATO AS C ";
        sql += " INNER JOIN CLIENTE ON CLIENTE.cli_Codigo = C.cli_Codigo  ";
        sql += " WHERE C.inicioContrato = ?  AND C.fimContrato = ?  AND C.valor = ?   ";
        sql += " AND C.cli_Codigo = ? ";
        PreparedStatement stmt = super.conectarParametros().prepareStatement(sql);
        Operacao op = new Operacao();
        java.sql.Date dataInicioSQL = op.dataJavaSql(filtroPJ.getInicioContrato());
        java.sql.Date dataFimSql = op.dataJavaSql(filtroPJ.getFimContrato());

        stmt.setDate(1, dataInicioSQL);
        stmt.setDate(2, dataFimSql);
        stmt.setFloat(3, filtroPJ.getValor());
        stmt.setInt(4, filtroPJ.getClientePJ().getCli_Codigo());
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            retorno = true;
            break;
        }
        return retorno;
    }

    @Override
    public Boolean verificarContratoPF(ContratoPF filtroPF) throws Exception {
        boolean retorno = false;
        String sql = " SELECT  C.idContrato ";
        sql += " FROM CONTRATO AS C ";
        //sql += " INNER JOIN contratoPF ON C.Cli_Codigo = contratoPF.Cli_Codigo  ";
        sql += " WHERE c.idContrato = ? ";

        PreparedStatement stmt = super.conectarParametros().prepareStatement(sql);

        stmt.setInt(1, filtroPF.getIdContrato());
        // stmt.setString(4, filtro.getClientePessoaFisica().getCli_cpf);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            retorno = true;
            break;
        }
        return retorno;
    }

    @Override
    public Boolean verificarContratoPJ(ContratoPJ filtroPJ) throws Exception {
        boolean retorno = false;
        String sql = " SELECT  C.idContrato ";
        sql += " FROM CONTRATO AS C ";
        //sql += " INNER JOIN contratoPF ON C.Cli_Codigo = contratoPF.Cli_Codigo  ";
        sql += " WHERE c.idContrato = ? ";

        PreparedStatement stmt = super.conectarParametros().prepareStatement(sql);

        stmt.setInt(1, filtroPJ.getIdContrato());
        // stmt.setString(4, filtro.getClientePessoaFisica().getCli_cpf);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            retorno = true;
            break;
        }
        return retorno;
    }

}
