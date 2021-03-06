/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sla.gui;

import java.text.ParseException;
import sla.clientes.ClientePessoaFisica;
import sla.clientes.ClientePessoaJuridica;
import sla.clientes.NegocioCliente;
import sla.contrato.ContratoPF;
import sla.contrato.NegocioContrato;
import java.util.Date;
//import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;
import sla.contrato.ContratoPJ;
import sla.operacoes.Operacao;

/**
 *
 * @author Fabiano
 */
public class NewJFrame_Cadastro_Contratos extends javax.swing.JFrame {

    MaskFormatter cpf;
    MaskFormatter cnpj;

    /**
     * Creates new form NewJFrame_Cadastro_Contratos
     */
    public NewJFrame_Cadastro_Contratos() {
        initComponents();
        jTextField_doc_cli.requestFocus(true);
        jRadioButtonPF.setSelected(true);
        try {
            cpf = new MaskFormatter("###.###.###-##");
            cnpj = new MaskFormatter("##.###.###/####-##");
            cpf.install(jTextField_doc_cli);
            jTextField_cod_cli.setEnabled(false);
            jTextField_nome_razao_cli.setEnabled(false);
            jTextField_mail_cli.setEnabled(false);
            jTextField_fone_cli.setEnabled(false);

        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField_cod_cli = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField_nome_razao_cli = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField_mail_cli = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField_fone_cli = new javax.swing.JTextField();
        jTextField_doc_cli = new javax.swing.JFormattedTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jFormattedTextField_data_inicio = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        jFormattedTextField_data_fim = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField_um_atendimento = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextField_fim_atendimento = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextField_quantidade = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextField_valor = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jButtonCadastrar = new javax.swing.JButton();
        jRadioButtonPF = new javax.swing.JRadioButton();
        jRadioButtonPJ = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CADASTRO DE CONTRATOS");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Cliente"));

        jLabel1.setText("CPF");

        jLabel2.setText("CÓDIGO");

        jLabel3.setText("Nome");

        jLabel4.setText("E-mail");

        jLabel5.setText("Fone");

        jTextField_doc_cli.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_doc_cliFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextField_doc_cli, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField_cod_cli, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextField_nome_razao_cli, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                    .addComponent(jTextField_mail_cli)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextField_fone_cli, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jTextField_cod_cli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_doc_cli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField_nome_razao_cli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField_mail_cli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField_fone_cli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Contrato"));

        jLabel6.setText("Data início");

        try {
            jFormattedTextField_data_inicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextField_data_inicio.setToolTipText("IInforme a data no formato dd/mm/yyyy");

        jLabel7.setText("Data Fim");

        try {
            jFormattedTextField_data_fim.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextField_data_fim.setToolTipText("Informe a data no formato dd/mm/yyyy");

        jLabel8.setText("1º Serviço");

        jLabel9.setText("Conclusão");

        jLabel10.setText("Quantidade");

        jTextField_quantidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_quantidadeKeyTyped(evt);
            }
        });

        jLabel11.setText("Valor");

        jCheckBox1.setText("Contempla Peças");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jFormattedTextField_data_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_um_atendimento, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jFormattedTextField_data_fim, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField_fim_atendimento, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                                    .addComponent(jTextField_valor)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jCheckBox1))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jFormattedTextField_data_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jFormattedTextField_data_fim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextField_um_atendimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jTextField_fim_atendimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTextField_quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jTextField_valor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jCheckBox1))
        );

        jButtonCadastrar.setText("Cadastrar");
        jButtonCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButtonPF);
        jRadioButtonPF.setText("Pessoa Física");
        jRadioButtonPF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jRadioButtonPFFocusGained(evt);
            }
        });
        jRadioButtonPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonPFActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButtonPJ);
        jRadioButtonPJ.setText("Pessoa Jurídica");
        jRadioButtonPJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonPJActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(jRadioButtonPF)
                        .addGap(73, 73, 73)
                        .addComponent(jRadioButtonPJ)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(209, 209, 209)
                .addComponent(jButtonCadastrar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonPF)
                    .addComponent(jRadioButtonPJ))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonCadastrar)
                .addGap(5, 5, 5))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButtonPFFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jRadioButtonPFFocusGained

    }//GEN-LAST:event_jRadioButtonPFFocusGained

    private void jRadioButtonPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonPFActionPerformed
        jLabel1.setText("CPF");
        jLabel3.setText("NOME");
        jTextField_doc_cli.requestFocus(true);
        cnpj.uninstall();
        cpf.install(jTextField_doc_cli);
        jTextField_doc_cli.setText("");
        jTextField_cod_cli.setText("");
        jTextField_nome_razao_cli.setText("");
        jTextField_mail_cli.setText("");
        jTextField_fone_cli.setText("");

    }//GEN-LAST:event_jRadioButtonPFActionPerformed

    private void jRadioButtonPJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonPJActionPerformed
        jLabel1.setText("CNPJ");
        jLabel3.setText("RAZÃO SOCIAL");
        jTextField_doc_cli.requestFocus(true);
        jTextField_doc_cli.setText("");
        jTextField_cod_cli.setText("");
        jTextField_nome_razao_cli.setText("");
        jTextField_mail_cli.setText("");
        jTextField_fone_cli.setText("");
        cpf.uninstall();
        cnpj.install(jTextField_doc_cli);
    }//GEN-LAST:event_jRadioButtonPJActionPerformed

    private void jButtonCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastrarActionPerformed
        NegocioContrato nc = new NegocioContrato();
        if (jRadioButtonPF.isSelected()) {
            ClientePessoaFisica pf = new ClientePessoaFisica();
            pf.setCli_Codigo(Integer.parseInt(jTextField_cod_cli.getText()));
            pf.setCli_Cpf(jTextField_doc_cli.getText());
            pf.setNome(jTextField_nome_razao_cli.getText());

            SimpleDateFormat c = new SimpleDateFormat("dd/MM/yyyy");
            ContratoPF contratoPF = new ContratoPF();
            Date dataInicio;
            Date dataFim;

            contratoPF.setClientePF(pf);
            try {
                if (jRadioButtonPF.isSelected()) {

                } else if (jRadioButtonPJ.isSelected()) {

                }
                if (jFormattedTextField_data_inicio.getText().isEmpty() == false) {
                    dataInicio = c.parse(jFormattedTextField_data_inicio.getText());
                    contratoPF.setInicioContrato(dataInicio);
                }
                if (jFormattedTextField_data_fim.getText().isEmpty() == false) {
                    dataFim = c.parse(jFormattedTextField_data_fim.getText());
                    contratoPF.setFimContrato(dataFim);
                }
                contratoPF.setTotalEquipamento(Integer.parseInt(jTextField_quantidade.getText()));
                contratoPF.setUmAtendimento(Integer.parseInt(jTextField_um_atendimento.getText()));
                contratoPF.setFimAtendimento(Integer.parseInt(jTextField_fim_atendimento.getText()));
                contratoPF.setValor(Float.parseFloat(jTextField_valor.getText()));
                contratoPF.getClientePF().setCli_Codigo(Integer.parseInt(jTextField_cod_cli.getText()));
                if (jCheckBox1.isSelected()) {
                    contratoPF.setCobrePeca(true);
                } else {
                    contratoPF.setCobrePeca(false);
                }

                nc.cadastrarContratoPF(contratoPF);
                JOptionPane.showMessageDialog(null, "Contrato cadastrado com sucesso.");
                jFormattedTextField_data_inicio.setText("");
                jFormattedTextField_data_fim.setText("");
                jTextField_um_atendimento.setText("");
                jTextField_fim_atendimento.setText("");
                jTextField_quantidade.setText("");
                jTextField_valor.setText("");
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
            /*        INSERINDO CADASTRO PJ             */
        } else if (jRadioButtonPJ.isSelected()) {
            ClientePessoaJuridica pj = new ClientePessoaJuridica();
            pj.setCli_Codigo(Integer.parseInt(jTextField_cod_cli.getText()));
            pj.setCli_Cnpj(jTextField_doc_cli.getText());
            pj.setRazaoSocial(jTextField_nome_razao_cli.getText());

            SimpleDateFormat c = new SimpleDateFormat("dd/MM/yyyy");
            ContratoPJ contratoPJ = new ContratoPJ();
            Date dataInicio;
            Date dataFim;

            contratoPJ.setClientePJ(pj);
            try {

                if (jFormattedTextField_data_inicio.getText().isEmpty() == false) {
                    dataInicio = c.parse(jFormattedTextField_data_inicio.getText());
                    contratoPJ.setInicioContrato(dataInicio);
                }
                if (jFormattedTextField_data_fim.getText().isEmpty() == false) {
                    dataFim = c.parse(jFormattedTextField_data_fim.getText());
                    contratoPJ.setFimContrato(dataFim);
                }
                contratoPJ.setTotalEquipamento(Integer.parseInt(jTextField_quantidade.getText()));
                contratoPJ.setUmAtendimento(Integer.parseInt(jTextField_um_atendimento.getText()));
                contratoPJ.setFimAtendimento(Integer.parseInt(jTextField_fim_atendimento.getText()));
                contratoPJ.setValor(Float.parseFloat(jTextField_valor.getText()));
                contratoPJ.getClientePJ().setCli_Codigo(Integer.parseInt(jTextField_cod_cli.getText()));
                if (jCheckBox1.isSelected()) {
                    contratoPJ.setCobrePeca(true);
                } else {
                    contratoPJ.setCobrePeca(false);
                }

                //  JOptionPane.showMessageDialog(null, dataSQL);
                nc.cadastrarContratoPJ(contratoPJ);
                JOptionPane.showMessageDialog(null, "Contrato cadastrado com sucesso.");
                jFormattedTextField_data_inicio.setText("");
                jFormattedTextField_data_fim.setText("");
                jTextField_um_atendimento.setText("");
                jTextField_fim_atendimento.setText("");
                jTextField_quantidade.setText("");
                jTextField_valor.setText("");
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }


    }//GEN-LAST:event_jButtonCadastrarActionPerformed

    private void jTextField_doc_cliFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_doc_cliFocusLost
        if (jRadioButtonPF.isSelected()) {
            try {
                //LIBERANDO PARA CONSULTAS APENAS QUANDO OS 14 DÍGITOS ESTIVEREM PREENCHIDOS
                //PARA O CAMPO DO CPF
                Operacao op = new Operacao();
                boolean cpf = op.validaCPF(jTextField_doc_cli.getText());
                if (cpf == false) {
                    return;

                }

                ClientePessoaFisica pf = new ClientePessoaFisica();
                NegocioCliente c = new NegocioCliente();
                pf.setCli_Cpf(jTextField_doc_cli.getText());
                ArrayList<ClientePessoaFisica> lista = c.consultarClientePF(pf);
                pf = lista.get(0);
                jTextField_doc_cli.setText(pf.getCli_Cpf());
                jTextField_nome_razao_cli.setText(pf.getNome());
                jTextField_mail_cli.setText(pf.getEmail());
                jTextField_cod_cli.setText(String.valueOf(pf.getCli_Codigo()));
                jTextField_fone_cli.setText(pf.getTelefone());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } else {
            /* ADAPTANDO CAMPOS PARA TIPO PJ*/
            if (jRadioButtonPJ.isSelected()) {
                //LIBERANDO PARA CONSULTAS APENAS QUANDO OS 18 DÍGITOS ESTIVEREM PREENCHIDOS
                //PARA O CAMPO DO CNPJ
                try {
                    Operacao op = new Operacao();
                    boolean cnpj = op.validaCNPJ(jTextField_doc_cli.getText());
                    if (cnpj == false) {
                        return;

                    }
                    ClientePessoaJuridica pj = new ClientePessoaJuridica();
                    NegocioCliente c = new NegocioCliente();
                    pj.setCli_Cnpj(jTextField_doc_cli.getText());
                    ArrayList<ClientePessoaJuridica> lista = c.consultarClientePJ(pj);
                    pj = lista.get(0);
                    jTextField_nome_razao_cli.setText(pj.getRazaoSocial());
                    jTextField_mail_cli.setText(pj.getEmail());
                    jTextField_cod_cli.setText(String.valueOf(pj.getCli_Codigo()));
                    jTextField_fone_cli.setText(pj.getTelefone());
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, e.getMessage());
                }
            }
        }
    }//GEN-LAST:event_jTextField_doc_cliFocusLost

    private void jTextField_quantidadeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_quantidadeKeyTyped
        char c = evt.getKeyChar();

        if (Character.isDigit(c) == false) {
            evt.consume();
        }
        int tamanhoString = 5;
        if (jTextField_quantidade.getText().length() >= tamanhoString) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField_quantidadeKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame_Cadastro_Contratos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame_Cadastro_Contratos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame_Cadastro_Contratos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame_Cadastro_Contratos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame_Cadastro_Contratos().setVisible(true);
            }
        });
    }

    /* private Calendar inicioConvertida(ContratoPF contratoPF) {
        String x = jFormattedTextField_data_inicio.getText();
               
        contratoPF.getInicioContrato().set(Calendar.DAY_OF_MONTH, Integer.parseInt(x.substring(0, 2)));
        contratoPF.getInicioContrato().set(Calendar.MONTH, Integer.parseInt(x.substring(3, 5)));
        contratoPF.getInicioContrato().set(Calendar.YEAR, Integer.parseInt(x.substring(6, 10)));
        

        return contratoPF.getInicioContrato();

    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButtonCadastrar;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JFormattedTextField jFormattedTextField_data_fim;
    private javax.swing.JFormattedTextField jFormattedTextField_data_inicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButtonPF;
    private javax.swing.JRadioButton jRadioButtonPJ;
    private javax.swing.JTextField jTextField_cod_cli;
    private javax.swing.JFormattedTextField jTextField_doc_cli;
    private javax.swing.JTextField jTextField_fim_atendimento;
    private javax.swing.JTextField jTextField_fone_cli;
    private javax.swing.JTextField jTextField_mail_cli;
    private javax.swing.JTextField jTextField_nome_razao_cli;
    private javax.swing.JTextField jTextField_quantidade;
    private javax.swing.JTextField jTextField_um_atendimento;
    private javax.swing.JTextField jTextField_valor;
    // End of variables declaration//GEN-END:variables
}
