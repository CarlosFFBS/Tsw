/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sla.clientes.forms;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Consultor SCA 02
 */
public class LayoutCadastrarPJ {

    JButton jb = new JButton("CADASTRAR");
    JLabel JLMensagemCadastro = new JLabel("CADASTRO DE CLIENTES- PESSOA JURÍDICA");
    // JLabel JLMensagemPreenchaCampos = new JLabel("PREENCHA OS CAMPOS ");
    JLabel JLrazaoSocial = new JLabel("RAZÃO SOCIAL");
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
    JLabel JLcnpj = new JLabel("CNPJ");
    //  JLabel JLsexoCliente = new JLabel("SEXO");

    JTextField JTnomeCliente = new JTextField();

    JTextField JTenderecoCliente = new JTextField();
    JTextField JTnumeroEndereco = new JTextField();
    JTextField JTcomplemento = new JTextField();
    JTextField JTbairro = new JTextField();
    JTextField JTcidade = new JTextField();
    JTextField JTuf = new JTextField();
    JTextField JTemail = new JTextField();

    JRadioButton JRsexoMasculino = new JRadioButton("MASCULINO");
    JRadioButton JRsexoFeminino = new JRadioButton("FEMININO");

    public LayoutCadastrarPJ(javax.swing.JFrame c) {

        try {
            c.setTitle("CADASTRO DE CLIENTES - PESSOA JURIDICA");
            JFormattedTextField JTtelefoneCliente = new JFormattedTextField(new MaskFormatter("(##)#.####-####"));
            JFormattedTextField JTcepCliente = new JFormattedTextField(new MaskFormatter("##.###-###"));
            JFormattedTextField JTcnpj = new JFormattedTextField(new MaskFormatter("##.###.###/####-##"));
            c.setLocationRelativeTo(null);
            c.setSize(700, 680);
            c.setTitle("CADASTRO DE CLIENTES - PESSOA JURÍDICA");
            c.getContentPane().setLayout(null);

            jb.setBounds(400, 521, 100, 66);
            // JRsexoMasculino.setBounds(111, 521, 92, 18);
            // JRsexoMasculino.setBounds(111, 581, 100, 66);
            //JRsexoFeminino.setBounds(237, 521, 79, 18);
            JLMensagemCadastro.setBounds(200, 21, 270, 47);
            //  JLMensagemPreenchaCampos.setBounds(6, 61, 156, 49);
            JLrazaoSocial.setBounds(6, 122, 100, 16);
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
            //  JLsexoCliente.setBounds(6, 521, 35, 16);
            JLcnpj.setBounds(6, 518, 50, 16);
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
            JTcnpj.setBounds(111, 518, 123, 28);
            // JLnomeCliente.setBounds(6, 122, 41, 16);
            c.add(JLMensagemCadastro);
            c.add(JLrazaoSocial);
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
            c.add(JLcnpj);
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
            c.add(JTcnpj);
            c.add(jb);
//        c.add(JLsexoCliente);
            c.add(JRsexoFeminino);
            c.add(JRsexoMasculino);

            jb.setVisible(true);
            JRsexoFeminino.setVisible(true);
            JRsexoMasculino.setVisible(true);
            JLMensagemCadastro.setVisible(true);
//        JLMensagemPreenchaCampos.setVisible(true);
            JLrazaoSocial.setVisible(true);
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
            // JLsexoCliente.setVisible(true);
            JLcnpj.setVisible(true);
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
            JTcnpj.setVisible(true);

        } catch (Exception e) {
        }

    }

   

}
