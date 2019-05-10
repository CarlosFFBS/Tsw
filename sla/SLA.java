/*

     @Override
    public void cadastrarEquipamento(Equipamento e)  throws Exception {
        String sql = "INSERT INTO Equipamento (descricao, serial, idContrato) ";
        sql += " VALUES (?,?,?)";
        //preparando a instrução
        PreparedStatement stmt = super.conectarParametros().prepareStatement(sql);
        //passando os valores para os parametros
        stmt.setString(1, e.getDescricao().trim());
        stmt.setString(2, e.getSerial().trim());
        stmt.setInt(3, e.getIdContrato());
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
        stmt.setInt(3, e.getIdContrato());
         stmt.setInt(4, e.getCodigo());
        // execute insert SQL stetement
        stmt.executeUpdate();
        //fechando a conexão com o banco de dados
        super.desconectar();
    }

    @Override
    public ArrayList<Equipamento> listarEquipamento(Equipamento filtro) throws Exception {
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
            stmt.setInt(1, filtro.getIdContrato());
        }
        //executando a instrução sql
        ResultSet leitor = stmt.executeQuery();
        //lendo os resultados
        while (leitor.next()) {
            Equipamento e = new Equipamento();
            e.setCodigo(leitor.getInt("Código"));
            e.setDescricao(leitor.getString("Descrição"));
            e.setSerial(leitor.getString("Serial"));
            e.setIdContrato(leitor.getInt("Contrato"));
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
            stmt.setInt(1, filtro.getIdContrato());
        }
        //executando a instrução sql
        ResultSet leitor = stmt.executeQuery();
        //lendo os resultados
        while (leitor.next()) {
            Equipamento e = new Equipamento();
            e.setCodigo(leitor.getInt("Código"));
            e.setDescricao(leitor.getString("Descrição"));
            e.setSerial(leitor.getString("Serial"));
            e.setIdContrato(leitor.getInt("Contrato"));
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
            e.setIdContrato(leitor.getInt("Contrato"));
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
        stmt.setInt(1, e.getIdContrato());
        stmt.setString(2, e.getSerial().trim());

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            teste = true;
            break;
        }
        return teste;
    }
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sla;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import sla.clientes.ClientePessoaFisica;
import sla.clientes.DadosCliente;
import sla.clientes.NegocioCliente;
import sla.clientes.forms.LayoutCadastrarPF;
import sla.contrato.Contrato;
import sla.contrato.ContratoPF;
import sla.operacoes.Operacao;
import sla.pecas.DadosPeca;
import sla.pecas.NegocioPeca;
import sla.pecas.Peca;
import sla.servico.DadosServico;
import sla.servico.Servico;

/*   if (jRadioButtonAlterarPeca.isSelected()) {
                FormAlterarPeca enviaTexto = new FormAlterarPeca();
                enviaTexto.setVisible(true);
                Integer servicoSelecionado = (Integer) jTableListaPecas.getValueAt(jTableListaPecas.getSelectedRow(), 0);
                enviaTexto.RecebejTable(servicoSelecionado);

            }

            if (jRadioButtonRemoverServico.isSelected()) {
                Servico b = new Servico();
                DadosServico a = new DadosServico();
                Integer servicoSelecionado = (Integer) jTableListaServicos.getValueAt(jTableListaServicos.getSelectedRow(), 0);
                b.setCodServico(servicoSelecionado);
                a.removerServicoCod(b);

                JOptionPane.showMessageDialog(null, " Serviço removido com sucesso.");
                jTextFieldFiltroServico.setText("");
                DefaultTableModel model = (DefaultTableModel) jTableListaServicos.getModel();

                while (model.getRowCount() > 0) {
                    model.removeRow(0);
                }

            }


      if ((servico.getDescricao() == null) && (servico.getPreco()<=0 )) {
            
            throw new Exception("Preencha os campos");
        }

        if (servico.getDescricao().trim().isEmpty()) {
            throw new Exception("Informe o nome do servico");
        }

        if (servico.getPreco() <= 0) {
            throw new Exception("Informe o Valor do servico. Somente valores acima de Zero são permitidos.");
        }


        DadosServico dados = new DadosServico();
        boolean servicoDuplicado = dados.verificaDuplicidadeServico(servico);
        if (servicoDuplicado){
        throw new Exception("Já existe um serviço para o nome informado.");
        }
        
    dados.cadastrarServico(servico) ;







 (jRadioButtonRemoverPeca.isSelected()) {
                Peca b = new Peca();
                DadosPeca a = new DadosPeca();
                Integer pecaSelecionada = (Integer) jTableListaPecas.getValueAt(jTableListaPecas.getSelectedRow(), 0);
                b.setCodigo(pecaSelecionada);
                a.removerPecaCod(b);

                JOptionPane.showMessageDialog(null, " Peca removido com sucesso.");
                jTextFieldFiltroPeca.setText("");
                DefaultTableModel model = (DefaultTableModel) jTableListaServicos.getModel();

                while (model.getRowCount() > 0) {
                    model.removeRow(0);
                }

            }
 */
public class SLA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
      
        
            
            /*    NegocioPeca a = new NegocioPeca();
            Peca chave = new Peca();
            //    chave.setPreco((float) );
            JOptionPane.showMessageDialog(null, chave.getPreco());
            chave.setDescricao("dfsfsdfdsfs");
            chave.setCodigo(-1);
            a.consultarPeca(chave);
            JOptionPane.showMessageDialog(null, "Peça cadastrada com sucesso.");
             */
      Operacao op = new Operacao();
            ClientePessoaFisica clientePF = new ClientePessoaFisica();
        /*   
            clientePF.setLogradouro("Avenida Boa viagem");
            clientePF.setNumeroLogradouro("5555");
            clientePF.setComplemento("555");
            clientePF.setBairro("Imbiribeira");
            clientePF.setCep("54410000");
            clientePF.setCidade("Recife");
            clientePF.setEstado("PE");
            clientePF.setEmail("autonunes@unibratec.com");
            clientePF.setTelefone("81992654823");
              

            clientePF.setCli_Cpf(op.formataCPF("48337694488"));
            clientePF.setNome("BERNARDO PRADO SILVAa");
            clientePF.setSexo("F"); 
            
            NegocioCliente cliente = new NegocioCliente();
            cliente.cadastrarClientePF(clientePF);*/
        
        clientePF.setComplemento(null);
        if(clientePF.getComplemento().length()>20)
                System.out.println("Limite máximo de 20 caracteres para o complemento.");
            System.out.println("não deu exception");
           //         ArrayList<ClientePessoaFisica> lista =  cliente.listarClientePF();
                    
          //  ArrayList<ClientePessoaFisica> lista = cliente.listarClientePF();
          //  for (ClientePessoaFisica elemento : lista) {
            //    System.out.println("Código: " + elemento.getCli_Codigo() + "\n"
             //           + "Nome: " + elemento.getNome());
            //} 

//            chave.setPreco(20);
//            a.alterarPeca(chave);
//            chave.setDescricao("Borracha");
//            a.removerPecaNome(chave);
//            JOptionPane.showMessageDialog(null, "A peça foi removida.");

            /* String sql = "DELETE FROM SERVICO WHERE ";
        sql += " Descricao = ?";
        PreparedStatement stmt = super.conectarParametros().prepareStatement(sql);
        stmt.setString(1, servico.getDescricao());
        stmt.executeUpdate();
        super.desconectar(); 
            Servico servico = new Servico();
            DadosServico a = new DadosServico();
            servico.setDescricao("teste");
            servico.setPreco(1000);
            // a.cadastrarServico(servico);
            System.out.println(servico.getDescricao() + " será removido...");
            a.removerServicoNome(servico);
            System.out.println("Serviço removido com sucesso.");
             */
//            LayoutCadastrarPF layout = new LayoutCadastrarPF();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        }

    }

}
