/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sla.clientes.forms;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import jdk.nashorn.internal.ir.TryNode;
import sla.clientes.ClientePessoaFisica;
import sla.clientes.NegocioCliente;

/**
 *
 * @author Consultor SCA 02
 */
public class LayoutCadastrarPF extends JFrame implements ActionListener {

    String textoTelefone;
    String textoCPF;
    JButton jb = new JButton("CADASTRAR");
    JLabel JLMensagemCadastro = new JLabel("CADASTRO DE CLIENTES");
    JLabel JLMensagemPreenchaCampos = new JLabel("PREENCHA OS CAMPOS ");
    JLabel JLnomeCliente = new JLabel("NOME");
    JLabel JLtelefoneCliente = new JLabel("TELEFONE");
    JLabel JLcepCliente = new JLabel("CEP");
    JLabel JLenderecoCliente = new JLabel("ENDEREÇO");
    JLabel JLnumeroEndereco = new JLabel("N°");
    JLabel JLcomplemento = new JLabel("COMPLEMENTO");
    JLabel JLbairro = new JLabel("BAIRRO");
    JLabel JLcidade = new JLabel("CIDADE");
    JLabel JLuf = new JLabel("UF");
    JLabel JLufex = new JLabel("Ex: SP");
    JLabel JLemail = new JLabel("EMAIL");
    JLabel JLcpf = new JLabel("CPF");
    JLabel JLsexoCliente = new JLabel("SEXO");
    JTextField JTnomeCliente = new JTextField();
    //   JFormattedTextField JTtelefoneCliente = new JFormattedTextField();
    JFormattedTextField JTcepCliente = new JFormattedTextField();
    JTextField JTenderecoCliente = new JTextField();
    JTextField JTnumeroEndereco = new JTextField();
    JTextField JTcomplemento = new JTextField();
    JTextField JTbairro = new JTextField();
    JTextField JTcidade = new JTextField();
    JTextField JTuf = new JTextField();
    JTextField JTemail = new JTextField();
    // JFormattedTextField JTcpf = new JFormattedTextField();
    JRadioButton JRsexoMasculino = new JRadioButton("MASCULINO");
    JRadioButton JRsexoFeminino = new JRadioButton("FEMININO");

    public LayoutCadastrarPF(javax.swing.JFrame c) {
        try {
            
            c.setTitle("CADASTRO DE CLIENTES - PESSOA FÍSICA");
            c.setLocationRelativeTo(null);
            JFormattedTextField JTcpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
            JFormattedTextField JTtelefoneCliente = new JFormattedTextField(new MaskFormatter("(##)#.####-####"));

            setLocationRelativeTo(null);
            setSize(700, 680);
            c.setTitle("CADASTRO DE CLIENTES - PESSOA FÍSICA");
            c.getContentPane().setLayout(null);

            jb.setBounds(400, 542, 100, 66);
            JRsexoMasculino.setBounds(111, 521, 92, 18);
            JRsexoFeminino.setBounds(237, 521, 79, 18);
            JLMensagemCadastro.setBounds(265, 21, 147, 47);
            JLnomeCliente.setBounds(6, 122, 41, 16);
            JLtelefoneCliente.setBounds(6, 162, 63, 16);
            JLcepCliente.setBounds(6, 196, 28, 16);
            JLenderecoCliente.setBounds(6, 232, 69, 16);
            JLnumeroEndereco.setBounds(6, 272, 70, 16);
            JLcomplemento.setBounds(6, 312, 92, 16);
            JLbairro.setBounds(6, 352, 45, 16);
            JLcidade.setBounds(6, 392, 45, 16);
            JLuf.setBounds(6, 438, 16, 16);
            JLufex.setBounds(167, 438, 35, 16);
            JLemail.setBounds(6, 478, 34, 16);
            JLsexoCliente.setBounds(6, 521, 35, 16);
            JLcpf.setBounds(6, 565, 24, 16);
            JTnomeCliente.setBounds(111, 122, 450, 28);
            JTtelefoneCliente.setBounds(111, 156, 108, 28);
            JTcepCliente.setBounds(111, 190, 81, 28);
            JTenderecoCliente.setBounds(111, 226, 301, 28);
            JTnumeroEndereco.setBounds(111, 266, 76, 28);
            JTcomplemento.setBounds(111, 306, 76, 28);
            JTbairro.setBounds(111, 346, 200, 28);
            JTcidade.setBounds(111, 386, 200, 28);
            JTuf.setBounds(111, 432, 38, 28);
            JTemail.setBounds(111, 472, 301, 28);
            JTcpf.setBounds(111, 559, 106, 28);
            // JLnomeCliente.setBounds(6, 122, 41, 16);
            c.add(JLMensagemCadastro);

            c.add(JLnomeCliente);
            c.add(JLtelefoneCliente);
            c.add(JLcepCliente);
            c.add(JLenderecoCliente);
            c.add(JLnumeroEndereco);
            c.add(JLcomplemento);
            c.add(JLbairro);
            c.add(JLcidade);
            c.add(JLuf);
            c.add(JLufex);
            c.add(JLemail);
            c.add(JLcpf);
            c.add(JTnomeCliente);
            c.add(JTtelefoneCliente);
            c.add(JTcepCliente);
            c.add(JTenderecoCliente);
            c.add(JTnumeroEndereco);
            c.add(JTcomplemento);
            c.add(JTbairro);
            c.add(JTcidade);
            c.add(JTuf);
            c.add(JTemail);
            c.add(JTcpf);
            c.add(jb);
            c.add(JLsexoCliente);
            c.add(JRsexoFeminino);
            c.add(JRsexoMasculino);

            jb.setVisible(true);
            JRsexoFeminino.setVisible(true);
            JRsexoMasculino.setVisible(true);
            JLMensagemCadastro.setVisible(true);
            JLMensagemPreenchaCampos.setVisible(true);
            JLnomeCliente.setVisible(true);
            JLtelefoneCliente.setVisible(true);
            JLcepCliente.setVisible(true);
            JLenderecoCliente.setVisible(true);
            JLnumeroEndereco.setVisible(true);
            JLcomplemento.setVisible(true);
            JLbairro.setVisible(true);
            JLcidade.setVisible(true);
            JLuf.setVisible(true);
            JLufex.setVisible(true);
            JLemail.setVisible(true);
            JLsexoCliente.setVisible(true);
            JLcpf.setVisible(true);
            JTnomeCliente.setVisible(true);
            JTtelefoneCliente.setVisible(true);
            JTcepCliente.setVisible(true);
            JTenderecoCliente.setVisible(true);
            JTnumeroEndereco.setVisible(true);
            JTcomplemento.setVisible(true);
            JTbairro.setVisible(true);
            JTcidade.setVisible(true);
            JTuf.setVisible(true);
            JTemail.setVisible(true);
            JTcpf.setVisible(true);
            textoTelefone = JTtelefoneCliente.getText();
            textoCPF = JTcpf.getText();
            jb.addActionListener(this);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    public void teste() {

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == jb) {
            try {
                ClientePessoaFisica clientePF = new ClientePessoaFisica();
                NegocioCliente cliente = new NegocioCliente();
                clientePF.setLogradouro(JTenderecoCliente.getText());
                clientePF.setTelefone(textoTelefone);
                clientePF.setCep(JTcepCliente.getText());
                clientePF.setLogradouro(JTenderecoCliente.getText());
                clientePF.setNumeroLogradouro(JTnumeroEndereco.getText());
                clientePF.setComplemento(JTcomplemento.getText());
                clientePF.setBairro(JTbairro.getText());
                clientePF.setCidade(JTcidade.getText());
                clientePF.setEstado(JTuf.getText());
                clientePF.setEmail(JTemail.getText());
                clientePF.setCli_Cpf(textoCPF);
                if (JRsexoMasculino.isSelected()) {
                    clientePF.setSexo("M");
                }
                if (JRsexoFeminino.isSelected()) {
                    clientePF.setSexo("F");
                }
                cliente.cadastrarClientePF(clientePF);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }

        }
        
        

    }
}
