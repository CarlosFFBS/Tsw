/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexaojdbc2018.conexao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author professor
 */
public class Dados  {

    private Statement stmt;
    private Connection conn;
    
    //parâmetros de conexão
    private final String driverPostGres = "org.postgresql.Driver";
    private final String driverSqlServer = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private final String driverMySql = "com.mysql.jdbc.Driver";
    private final String local = "DESKTOP-S9JSJIA\\SQLEXPRESS";
    private final String banco = "SLA";
    private final String usuario = "sa";
    private final String senha = "Bernardo10";

    /*private Statement conectar() throws Exception {
        return this.conectarSqlServer();
    }*/

    public Connection conectarParametros() throws Exception {
        this.conectarSqlServer();
        return conn;
    }

    public void desconectar() throws SQLException {
        conn.close();
    }

    private Statement conectarPostGreSql() throws Exception {
        //string de conexão
        String url = "jdbc:postgresql://" + local + "/" + banco + "?charSet=LATIN1";
        //vínculo com o driver de conexão
        Class.forName(driverPostGres);
        //obtendo a conexão
        conn = DriverManager.getConnection(url, usuario, senha);
        return conn.createStatement();
        //return stmt;
    }

    private Statement conectarSqlServer() throws Exception {
        //string de conexão
    
        String url = "jdbc:sqlserver://" + local + ":1433;DatabaseName=" + banco;
        //vínculo com o driver de conexão
        Class.forName(driverSqlServer);
        conn = DriverManager.getConnection(url, usuario, senha);
        stmt = conn.createStatement();
        return stmt;
    }

    private Statement conectarMySql() throws Exception {
        //string de conexão
        String url = "jdbc:mysql://" + local + ":3306/"+ banco;
        Class.forName(driverMySql).newInstance();
        conn = (Connection) DriverManager.getConnection(url , usuario, senha);
        stmt = conn.createStatement();
        return stmt;
    }
}
