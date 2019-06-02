package sla.clientes.forms;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import sla.clientes.ClientePessoaFisica;
import sla.clientes.ClientePessoaJuridica;
import sla.clientes.NegocioCliente;

public class FormListarCliente extends javax.swing.JFrame implements ActionListener {

    MaskFormatter mascaraCPF;
    MaskFormatter mascaraCNPJ;
    DefaultTableModel model;
    ArrayList<ClientePessoaFisica> listaPF;
    ArrayList<ClientePessoaJuridica> listaPJ;

    public FormListarCliente() {
        initComponents();
        setTitle("ATUALIZAÇÃO DE CLIENTES");
        setLocationRelativeTo(null);

        jRadioButtonPessoaFisica.addActionListener(this);
        jRadioButtonPessoaJuridica.addActionListener(this);
        jRadioButtonfiltroCPF.addActionListener(this);
        jRadioButtonfiltroNome.addActionListener(this);

        jButtonFiltro.setVisible(false);
        jLabelNome.setVisible(false);
        jTextFieldNomeFiltro.setVisible(false);
        jLabelCpfCnpjFiltro.setVisible(false);
        jFormattedTextFieldCpfCnpjFiltro.setVisible(false);
        model = (DefaultTableModel) jTableListaCliente.getModel();
        model.setColumnIdentifiers(new Object[]{"COD", "CPF", "Nome", "Endereço", "Numero", "Comp", "Bairro",
            "CEP", "Cidade", "UF", "Email", "Telefone",});
        jRadioButtonPessoaFisica.setSelected(true);
        jRadioButtonAlterarCliente.setSelected(true);
        try {
            mascaraCPF = new MaskFormatter("###.###.###-##");
            mascaraCNPJ = new MaskFormatter("##.###.###/####-##");
            this.mascaraCPF.install(jFormattedTextFieldCpfCnpjFiltro);
            this.listarDadosCliente();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    private void listarDadosCliente() {
        try {
            NegocioCliente b = new NegocioCliente();

            if (jRadioButtonPessoaFisica.isSelected()) {
                model.setColumnIdentifiers(new Object[]{"COD", "CPF", "Nome", "Endereço", "Numero", "Comp", "Bairro",
                    "CEP", "Cidade", "UF", "Email", "Telefone",});

                ClientePessoaFisica pfConsultado = new ClientePessoaFisica();
                pfConsultado.setCli_Cpf(jFormattedTextFieldCpfCnpjFiltro.getText().trim());
                pfConsultado.setNome(jTextFieldNomeFiltro.getText());
                ArrayList<ClientePessoaFisica> listaPF = b.listarClientePF();
                //Zerando as linhas existentes na tabela atual
                while (model.getRowCount() > 0) {
                    model.removeRow(0);
                }
                for (ClientePessoaFisica clientePF : listaPF) {
                    model.addRow(new Object[]{clientePF.getCli_Codigo(), clientePF.getCli_Cpf(), clientePF.getNome(), clientePF.getLogradouro(),
                        clientePF.getNumeroLogradouro(), clientePF.getComplemento(), clientePF.getBairro(),
                        clientePF.getCep(), clientePF.getCidade(), clientePF.getEstado(), clientePF.getEmail(), clientePF.getTelefone()}
                    );
                }
                jFormattedTextFieldCpfCnpjFiltro.setText("");
                jTextFieldNomeFiltro.setText("");
            }
            if (jRadioButtonPessoaJuridica.isSelected()) {
                model.setColumnIdentifiers(new Object[]{"CD_Cliente", "CNPJ", "Razão Social", "Endereço", "Numero", "Complemento", "Bairro",
                    "CEP", "Cidade", "UF", "Email", "Telefone",});
                ClientePessoaJuridica pjConsultado = new ClientePessoaJuridica();
                pjConsultado.setCli_Cnpj(jFormattedTextFieldCpfCnpjFiltro.getText());
                ArrayList<ClientePessoaJuridica> listaPJ = b.listarClientePJ();
//Zerando as linhas existentes na tabela atual
                while (model.getRowCount() > 0) {
                    model.removeRow(0);
                }
                for (ClientePessoaJuridica clientePJ : listaPJ) {
                    model.addRow(new Object[]{clientePJ.getCli_Codigo(), clientePJ.getCli_Cnpj(), clientePJ.getRazaoSocial(), clientePJ.getLogradouro(),
                        clientePJ.getNumeroLogradouro(), clientePJ.getComplemento(), clientePJ.getBairro(),
                        clientePJ.getCep(), clientePJ.getCidade(), clientePJ.getEstado(), clientePJ.getEmail(), clientePJ.getTelefone()}
                    );
                    jFormattedTextFieldCpfCnpjFiltro.setText("");
                }
            }

        } catch (Exception e) {
            try {//
                JOptionPane.showMessageDialog(null, e.getMessage());
                while (model.getRowCount() > 0) {
                    model.removeRow(0);
                }
                if (jRadioButtonPessoaFisica.isSelected()) {
                    for (ClientePessoaFisica clientePF : listaPF) {
                        model.addRow(new Object[]{clientePF.getCli_Codigo(), clientePF.getCli_Cpf(), clientePF.getNome(), clientePF.getLogradouro(),
                            clientePF.getNumeroLogradouro(), clientePF.getComplemento(), clientePF.getBairro(),
                            clientePF.getCep(), clientePF.getCidade(), clientePF.getEstado(), clientePF.getEmail(), clientePF.getTelefone()}
                        );
                    }
                    jFormattedTextFieldCpfCnpjFiltro.setText("");
                    jTextFieldNomeFiltro.setText("");
                }
                if (jRadioButtonPessoaJuridica.isSelected()) {
                    for (ClientePessoaJuridica clientePJ : listaPJ) {
                        model.addRow(new Object[]{clientePJ.getCli_Codigo(), clientePJ.getCli_Cnpj(), clientePJ.getRazaoSocial(), clientePJ.getLogradouro(),
                            clientePJ.getNumeroLogradouro(), clientePJ.getComplemento(), clientePJ.getBairro(),
                            clientePJ.getCep(), clientePJ.getCidade(), clientePJ.getEstado(), clientePJ.getEmail(), clientePJ.getTelefone()}
                        );
                        jFormattedTextFieldCpfCnpjFiltro.setText("");
                    }

                }

            } catch (Exception ez) {

                JOptionPane.showMessageDialog(null, e.getMessage());

            }

        }
    }

    private void consultarDadosCliente() {
        try {
            NegocioCliente a = new NegocioCliente();
            if (jRadioButtonPessoaFisica.isSelected()) {
                ClientePessoaFisica pf = new ClientePessoaFisica();
                if (jRadioButtonfiltroCPF.isSelected()) {
                    pf.setCli_Cpf(jFormattedTextFieldCpfCnpjFiltro.getText());
                }
                if (jRadioButtonfiltroNome.isSelected()) {
                    pf.setNome(jTextFieldNomeFiltro.getText());
                }
                listaPF = a.consultarClientePF(pf);
                while (model.getRowCount() > 0) {
                    model.removeRow(0);
                }
                for (ClientePessoaFisica clientePF : listaPF) {
                    model.addRow(new Object[]{clientePF.getCli_Codigo(), clientePF.getCli_Cpf(), clientePF.getNome(), clientePF.getLogradouro(),
                        clientePF.getNumeroLogradouro(), clientePF.getComplemento(), clientePF.getBairro(),
                        clientePF.getCep(), clientePF.getCidade(), clientePF.getEstado(), clientePF.getEmail(), clientePF.getTelefone()}
                    );
                }
            } else if (jRadioButtonPessoaJuridica.isSelected()) {
                ClientePessoaJuridica pj = new ClientePessoaJuridica();
                pj.setCli_Cnpj(jFormattedTextFieldCpfCnpjFiltro.getText());

                ArrayList<ClientePessoaJuridica> listaPJ = a.consultarClientePJ(pj);
//Zerando as linhas existentes na tabela atual
                while (model.getRowCount() > 0) {
                    model.removeRow(0);
                }
                for (ClientePessoaJuridica clientePJ : listaPJ) {
                    model.addRow(new Object[]{clientePJ.getCli_Codigo(), clientePJ.getCli_Cnpj(), clientePJ.getRazaoSocial(), clientePJ.getLogradouro(),
                        clientePJ.getNumeroLogradouro(), clientePJ.getComplemento(), clientePJ.getBairro(),
                        clientePJ.getCep(), clientePJ.getCidade(), clientePJ.getEstado(), clientePJ.getEmail(), clientePJ.getTelefone()}
                    );
                    jFormattedTextFieldCpfCnpjFiltro.setText("");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            jFormattedTextFieldCpfCnpjFiltro.setText("");
            jTextFieldNomeFiltro.setText("");
        }

    }

    ;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jButtonConfirmar = new javax.swing.JButton();
        jRadioButtonAlterarCliente = new javax.swing.JRadioButton();
        jRadioButtonRemoverCliente = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jButtonFiltro = new javax.swing.JButton();
        jTextFieldNomeFiltro = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableListaCliente = new javax.swing.JTable();
        jRadioButtonPessoaFisica = new javax.swing.JRadioButton();
        jRadioButtonPessoaJuridica = new javax.swing.JRadioButton();
        jLabelCpfCnpjFiltro = new javax.swing.JLabel();
        jFormattedTextFieldCpfCnpjFiltro = new javax.swing.JFormattedTextField();
        jLabelNome = new javax.swing.JLabel();
        jLabelMensagemTipoFiltro = new javax.swing.JLabel();
        jRadioButtonfiltroCPF = new javax.swing.JRadioButton();
        jRadioButtonfiltroNome = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("ATUALIZAÇÃO DE CLIENTES");

        jButtonConfirmar.setText("CONFIRMAR");
        jButtonConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmarActionPerformed(evt);
            }
        });

        buttonGroup2.add(jRadioButtonAlterarCliente);
        jRadioButtonAlterarCliente.setText("ALTERAR CLIENTE");

        buttonGroup2.add(jRadioButtonRemoverCliente);
        jRadioButtonRemoverCliente.setText("REMOVER CLIENTE");

        jLabel2.setText("SELECIONE O TIPO DO CLIENTE");

        jButtonFiltro.setText("PESQUISAR");
        jButtonFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFiltroActionPerformed(evt);
            }
        });

        jTableListaCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Título 5", "Título 6", "Título 7", "Título 8", "Título 9", "Título 10", "Título 11"
            }
        ));
        jScrollPane1.setViewportView(jTableListaCliente);

        buttonGroup1.add(jRadioButtonPessoaFisica);
        jRadioButtonPessoaFisica.setText("PESSOA FISICA");

        buttonGroup1.add(jRadioButtonPessoaJuridica);
        jRadioButtonPessoaJuridica.setText("PESSOA JURIDICA");
        jRadioButtonPessoaJuridica.setActionCommand("");

        jLabelCpfCnpjFiltro.setText("CPF");

        jFormattedTextFieldCpfCnpjFiltro.setText("   ");

        jLabelNome.setText("NOME");

        jLabelMensagemTipoFiltro.setText("SELECIONE O TIPO DE FILTRO");

        buttonGroup3.add(jRadioButtonfiltroCPF);
        jRadioButtonfiltroCPF.setText("CPF");

        buttonGroup3.add(jRadioButtonfiltroNome);
        jRadioButtonfiltroNome.setText("NOME");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButtonAlterarCliente)
                    .addComponent(jRadioButtonRemoverCliente))
                .addGap(131, 131, 131)
                .addComponent(jButtonConfirmar))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelCpfCnpjFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextFieldCpfCnpjFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldNomeFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNome)))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonFiltro))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1030, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(251, 251, 251)
                .addComponent(jLabel1))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRadioButtonPessoaFisica))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRadioButtonPessoaJuridica))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRadioButtonfiltroCPF)
                .addGap(34, 34, 34)
                .addComponent(jRadioButtonfiltroNome))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelMensagemTipoFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(12, 12, 12)
                .addComponent(jRadioButtonPessoaFisica)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButtonPessoaJuridica)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelMensagemTipoFiltro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonfiltroCPF)
                    .addComponent(jRadioButtonfiltroNome))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabelNome))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelCpfCnpjFiltro)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFormattedTextFieldCpfCnpjFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNomeFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonFiltro)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jRadioButtonAlterarCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButtonRemoverCliente))
                    .addComponent(jButtonConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmarActionPerformed
        if (jTableListaCliente.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, "Por favor selecione uma linha e indique a ação.");
            return;
        }
        try {

            if (jRadioButtonAlterarCliente.isSelected()) {
                if (jRadioButtonPessoaFisica.isSelected()) {
                    FormAlterarCliente EnviaTextoPF = new FormAlterarCliente();
                    EnviaTextoPF.setVisible(true);
                    Integer pfSelecionado = (Integer) jTableListaCliente.getValueAt(jTableListaCliente.getSelectedRow(), 0);
                    EnviaTextoPF.RecebeJtablePF(pfSelecionado);
                }
                if (jRadioButtonPessoaJuridica.isSelected()) {
                    FormAlterarCliente EnviaTextoPJ = new FormAlterarCliente();
                    EnviaTextoPJ.setVisible(true);
                    Integer pjSelecionado = (Integer) jTableListaCliente.getValueAt(jTableListaCliente.getSelectedRow(), 0);
                    EnviaTextoPJ.RecebeJtablePJ(pjSelecionado);
                }

            }
            if (jRadioButtonRemoverCliente.isSelected()) {
                if (jRadioButtonPessoaFisica.isSelected()) {
                    ClientePessoaFisica b = new ClientePessoaFisica();
                    NegocioCliente a = new NegocioCliente();
                    Integer pfSelecionado = (Integer) jTableListaCliente.getValueAt(jTableListaCliente.getSelectedRow(), 0);
                    b.setCli_Codigo(pfSelecionado);
                    a.removerClientePFCod(b);
                    JOptionPane.showMessageDialog(null, " Cliente removido com sucesso..");
                    jTextFieldNomeFiltro.setText("");
                    listaPF = a.listarClientePF();
                    while (model.getRowCount() > 0) {
                        model.removeRow(0);
                    }
                    this.listarDadosCliente();
                }
                if (jRadioButtonPessoaJuridica.isSelected()) {
                    ClientePessoaJuridica b = new ClientePessoaJuridica();
                    NegocioCliente a = new NegocioCliente();
                    Integer pjSelecionado = (Integer) jTableListaCliente.getValueAt(jTableListaCliente.getSelectedRow(), 0);
                    b.setCli_Codigo(pjSelecionado);
                    a.removerClientePJCod(b);
                    JOptionPane.showMessageDialog(null, " Cliente removido com sucesso..");
                    jTextFieldNomeFiltro.setText("");
                    listaPJ = a.listarClientePJ();
                    while (model.getRowCount() > 0) {
                        model.removeRow(0);
                    }
                    listaPJ = a.listarClientePJ();
                    this.listarDadosCliente();

                }

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        }

    }//GEN-LAST:event_jButtonConfirmarActionPerformed

    private void jButtonFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFiltroActionPerformed

        this.consultarDadosCliente();


    }//GEN-LAST:event_jButtonFiltroActionPerformed

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
            java.util.logging.Logger.getLogger(FormListarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormListarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormListarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormListarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormListarCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JButton jButtonConfirmar;
    private javax.swing.JButton jButtonFiltro;
    private javax.swing.JFormattedTextField jFormattedTextFieldCpfCnpjFiltro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelCpfCnpjFiltro;
    private javax.swing.JLabel jLabelMensagemTipoFiltro;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JRadioButton jRadioButtonAlterarCliente;
    private javax.swing.JRadioButton jRadioButtonPessoaFisica;
    private javax.swing.JRadioButton jRadioButtonPessoaJuridica;
    private javax.swing.JRadioButton jRadioButtonRemoverCliente;
    private javax.swing.JRadioButton jRadioButtonfiltroCPF;
    private javax.swing.JRadioButton jRadioButtonfiltroNome;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableListaCliente;
    private javax.swing.JTextField jTextFieldNomeFiltro;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == jRadioButtonPessoaFisica) {

            try {

                model.setColumnIdentifiers(new Object[]{"COD", "CPF", "Nome", "Endereço", "Numero", "Comp", "Bairro",
                    "CEP", "Cidade", "UF", "Email", "Telefone",});

                jLabelMensagemTipoFiltro.setVisible(true);
                jRadioButtonfiltroCPF.setVisible(true);
                jRadioButtonfiltroNome.setVisible(true);
                jButtonFiltro.setVisible(false);
                jLabelNome.setVisible(false);
                jTextFieldNomeFiltro.setVisible(false);
                jLabelCpfCnpjFiltro.setVisible(false);
                jFormattedTextFieldCpfCnpjFiltro.setVisible(false);
                jLabelCpfCnpjFiltro.setText("CPF");
                while (model.getRowCount() > 0) {
                    model.removeRow(0);
                }
                this.listarDadosCliente();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }

        }
        if (ae.getSource() == jRadioButtonPessoaJuridica) {
            model.setColumnIdentifiers(new Object[]{"CD_Cliente", "CNPJ", "Razão Social", "Endereço", "Numero", "Complemento", "Bairro",
                "CEP", "Cidade", "UF", "Email", "Telefone",});
            jLabelNome.setVisible(false);
            jLabelMensagemTipoFiltro.setVisible(false);
            jRadioButtonfiltroCPF.setVisible(false);
            jRadioButtonfiltroNome.setVisible(false);
            jButtonFiltro.setVisible(true);
            jTextFieldNomeFiltro.setVisible(false);
            mascaraCPF.uninstall();
            mascaraCNPJ.install(jFormattedTextFieldCpfCnpjFiltro);
            jLabelCpfCnpjFiltro.setText("CNPJ");
            jLabelCpfCnpjFiltro.setVisible(true);
            jFormattedTextFieldCpfCnpjFiltro.setVisible(true);

            while (model.getRowCount() > 0) {
                model.removeRow(0);
            }
            this.listarDadosCliente();

        }
        if (ae.getSource() == jRadioButtonfiltroCPF) {
            jButtonFiltro.setVisible(true);
            jLabelNome.setVisible(false);
            jTextFieldNomeFiltro.setVisible(false);
            jLabelCpfCnpjFiltro.setVisible(true);
            jFormattedTextFieldCpfCnpjFiltro.setVisible(true);
            mascaraCNPJ.uninstall();
            mascaraCPF.install(jFormattedTextFieldCpfCnpjFiltro);
        }
        if (ae.getSource() == jRadioButtonfiltroNome) {
            jButtonFiltro.setVisible(true);
            jLabelNome.setVisible(true);
            jTextFieldNomeFiltro.setVisible(true);
            jLabelCpfCnpjFiltro.setVisible(false);
            jFormattedTextFieldCpfCnpjFiltro.setVisible(false);
        }
    }

}
