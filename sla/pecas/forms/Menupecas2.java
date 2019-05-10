/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sla.pecas.forms;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sla.operacoes.Operacao;
import sla.pecas.DadosPeca;
import sla.pecas.NegocioPeca;
import sla.pecas.Peca;

/**
 *
 * @author Consultor SCA 02
 */
public class Menupecas2 extends javax.swing.JFrame implements ActionListener {

    /**
     * Creates new form Menupecas2
     */
    public Menupecas2() {
        initComponents();
        setTitle("MENU PEÇAS");
        setLocationRelativeTo(null);
        jTextFieldCodPecaFiltro.setVisible(false);
        jTextFieldCodPecaOperacao.setVisible(false);
        jTextFieldNomePeca.setVisible(false);
        jTextFieldPrecoPeca.setVisible(false);
        jLabelNovoNomePeca.setVisible(false);
        jLabelNovoPrecoPeca.setVisible(false);
        jLabelCodPecaOperacao.setVisible(false);

        jTextFieldNovoNomePeca.setVisible(false);
        jTextFieldNovoPrecoPeca.setVisible(false);
        jButton4.setVisible(false);
        jButtonFiltroPeca.setVisible(false);
        jLabelCodPecaFiltro.setVisible(false);
        jLabelNomePeca.setVisible(false);
        jLabelPrecoPeca.setVisible(false);
        jRadioButtonCadastrarPeca.addActionListener(this);
        jRadioButtonAtualizarPeca.addActionListener(this);
        jRadioButtonRemoverPeca.addActionListener(this);

        DefaultTableModel model = (DefaultTableModel) jTableFiltroPeca.getModel();
        model.setColumnIdentifiers(new Object[]{"Pec_Codigo", "Descrição", "Preco"});

        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
        model.addRow(new Object[]{100, "Exemplo", 100});

        jTextFieldCodPecaFiltro.requestFocus();

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
        jLabel1 = new javax.swing.JLabel();
        jTextFieldCodPecaFiltro = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jRadioButtonAtualizarPeca = new javax.swing.JRadioButton();
        jLabelCodPecaFiltro = new javax.swing.JLabel();
        jTextFieldNomePeca = new javax.swing.JTextField();
        jTextFieldPrecoPeca = new javax.swing.JTextField();
        jLabelNomePeca = new javax.swing.JLabel();
        jLabelPrecoPeca = new javax.swing.JLabel();
        jButtonFiltroPeca = new javax.swing.JButton();
        jLabelNovoNomePeca = new javax.swing.JLabel();
        jLabelNovoPrecoPeca = new javax.swing.JLabel();
        jTextFieldNovoNomePeca = new javax.swing.JTextField();
        jTextFieldNovoPrecoPeca = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jTextFieldFiltroPeca = new javax.swing.JTextField();
        jRadioButtonCadastrarPeca = new javax.swing.JRadioButton();
        jRadioButtonRemoverPeca = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableFiltroPeca = new javax.swing.JTable();
        jLabelCodPecaOperacao = new javax.swing.JLabel();
        jTextFieldCodPecaOperacao = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("MENU PEÇAS");

        jButton1.setText("PESQUISAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButtonAtualizarPeca);
        jRadioButtonAtualizarPeca.setText("ATUALIZAR PEÇA");

        jLabelCodPecaFiltro.setText("COD PEÇA");

        jLabelNomePeca.setText("NOME DA PEÇA");

        jLabelPrecoPeca.setText("PREÇO DA PEÇA");

        jButtonFiltroPeca.setText("FILTRAR");
        jButtonFiltroPeca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFiltroPecaActionPerformed(evt);
            }
        });

        jLabelNovoNomePeca.setText("NOVO NOME DA PEÇA");

        jLabelNovoPrecoPeca.setText("NOVO PREÇO DA PEÇA");

        jButton4.setText("CADASTRAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButtonCadastrarPeca);
        jRadioButtonCadastrarPeca.setText("CADASTRAR PEÇA");

        buttonGroup1.add(jRadioButtonRemoverPeca);
        jRadioButtonRemoverPeca.setText("REMOVER PEÇA");

        jTableFiltroPeca.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableFiltroPeca);

        jLabelCodPecaOperacao.setText("COD PEÇA");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelCodPecaFiltro)
                            .addComponent(jTextFieldCodPecaFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButtonFiltroPeca))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jTextFieldCodPecaOperacao))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabelCodPecaOperacao)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNomePeca)
                            .addComponent(jTextFieldNomePeca, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldPrecoPeca, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelPrecoPeca))
                        .addGap(62, 62, 62)
                        .addComponent(jButton4))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNovoNomePeca)
                            .addComponent(jTextFieldNovoNomePeca, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldNovoPrecoPeca, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelNovoPrecoPeca))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jTextFieldFiltroPeca, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(30, 30, 30))
            .addGroup(layout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButtonAtualizarPeca)
                    .addComponent(jRadioButtonCadastrarPeca)
                    .addComponent(jRadioButtonRemoverPeca))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jTextFieldFiltroPeca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jRadioButtonCadastrarPeca)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButtonAtualizarPeca)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButtonRemoverPeca))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelPrecoPeca)
                    .addComponent(jLabelNomePeca)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelCodPecaFiltro)
                        .addComponent(jLabelCodPecaOperacao)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldPrecoPeca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldCodPecaFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton4)
                        .addComponent(jTextFieldNomePeca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldCodPecaOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonFiltroPeca)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelNovoNomePeca)
                            .addComponent(jLabelNovoPrecoPeca))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldNovoNomePeca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldNovoPrecoPeca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(111, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonFiltroPecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFiltroPecaActionPerformed
        try {
            if (jRadioButtonRemoverPeca.isSelected()) {

                jTextFieldNomePeca.setEnabled(false);
                jTextFieldPrecoPeca.setVisible(false);
                jTextFieldPrecoPeca.setEnabled(false);
                jTextFieldCodPecaOperacao.setEnabled(false);
                DadosPeca b = new DadosPeca();
                Peca pecaConsultada = new Peca();
                if (jTextFieldCodPecaFiltro.getText().trim().isEmpty() == false) {
                    pecaConsultada.setCodigo(Integer.parseInt(jTextFieldCodPecaFiltro.getText()));

                }
                ArrayList<Peca> lista = b.consultarPeca(pecaConsultada);

                jTextFieldNomePeca.setText(lista.get(0).getDescricao());
                jTextFieldPrecoPeca.setText(String.valueOf(lista.get(0).getPreco()));
                jTextFieldCodPecaOperacao.setText(String.valueOf(lista.get(0).getCodigo()));
                jTextFieldNomePeca.setVisible(true);
                jTextFieldPrecoPeca.setVisible(true);
                jTextFieldCodPecaOperacao.setVisible(true);
                jLabelNomePeca.setVisible(true);
                jLabelPrecoPeca.setVisible(true);
                jLabelCodPecaOperacao.setVisible(true);

                /*      if (listaPecas.contains(pecaConsultada.getCodigo())) {
                    b.alterarPeca(pecaConsultada);
                    jTextFieldNomePeca.setText(pecaConsultada.getDescricao());
                    jTextFieldPrecoPeca.setText(String.valueOf(pecaConsultada.getPreco()));
                    
                } */
                jButton4.setEnabled(true);
            }

            if (jRadioButtonAtualizarPeca.isSelected()) {

                DadosPeca b = new DadosPeca();
                Peca pecaConsultada = new Peca();
                if (jTextFieldCodPecaFiltro.getText().trim().isEmpty() == false) {
                    pecaConsultada.setCodigo(Integer.parseInt(jTextFieldCodPecaFiltro.getText()));

                }
                ArrayList<Peca> lista = b.consultarPeca(pecaConsultada);

                jTextFieldNomePeca.setText(lista.get(0).getDescricao());
                jTextFieldPrecoPeca.setText(String.valueOf(lista.get(0).getPreco()));
                jTextFieldCodPecaOperacao.setText(String.valueOf(lista.get(0).getCodigo()));
                jTextFieldNomePeca.setVisible(true);
                jTextFieldPrecoPeca.setVisible(true);
                jTextFieldCodPecaOperacao.setVisible(true);
                jTextFieldNovoNomePeca.setVisible(true);
                jTextFieldNovoPrecoPeca.setVisible(true);
                jLabelCodPecaOperacao.setVisible(true);
                jLabelNovoNomePeca.setVisible(true);
                jLabelNovoPrecoPeca.setVisible(true);
                jLabelNomePeca.setVisible(true);
                jLabelPrecoPeca.setVisible(true);
                jButton4.setEnabled(true);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        /*  jLabel5.setVisible(true);
        jLabel6.setVisible(true);
        jTextFieldNovoNomePeca.setVisible(true);
        jTextFieldNomePeca.setVisible(true);
        jTextFieldNovoPrecoPeca.setVisible(true);
        jButton3.setVisible(true);
        jRadioButtonCadastrarPeca.addActionListener(this);
        jRadioButtonAtualizarPeca.addActionListener(this);
        jRadioButtonRemoverPeca.addActionListener(this);*/

    }//GEN-LAST:event_jButtonFiltroPecaActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        try {
            if ((jRadioButtonCadastrarPeca.isSelected())) {
                jButtonFiltroPeca.setVisible(false);
                Peca peca = new Peca();
                NegocioPeca negocio = new NegocioPeca();
                peca.setDescricao(jTextFieldNomePeca.getText());
                String textoPreco = jTextFieldPrecoPeca.getText();
                Operacao a = new Operacao();
                Float preco = a.formatadorVirgulaParaPonto(textoPreco);
                peca.setPreco(preco);
                negocio.cadastrarPeca(peca);
                JOptionPane.showMessageDialog(null, "Peça cadastrada com sucesso");
                jTextFieldNomePeca.setText("");
                jTextFieldPrecoPeca.setText("");
            }

            if (jRadioButtonRemoverPeca.isSelected()) {

                Peca b = new Peca();
                DadosPeca a = new DadosPeca();
                b.setCodigo(Integer.parseInt(jTextFieldCodPecaOperacao.getText()));
                a.removerPecaCod(b);
                JOptionPane.showMessageDialog(null, "peça removida com sucesso.");
                jTextFieldCodPecaFiltro.setText("");
                jTextFieldNomePeca.setText("");
                jTextFieldPrecoPeca.setText("");
                jTextFieldCodPecaOperacao.setText("");

            }

            if (jRadioButtonAtualizarPeca.isSelected()) {
                Peca peca = new Peca();
                DadosPeca a = new DadosPeca();
                peca.setCodigo(Integer.parseInt(jTextFieldCodPecaOperacao.getText()));
                peca.setDescricao(jTextFieldNomePeca.getText());
                peca.setPreco(Float.parseFloat(jTextFieldPrecoPeca.getText()));
                if (jTextFieldNovoNomePeca.getText() != null && jTextFieldNovoNomePeca.getText().trim().isEmpty() == false) {
                    peca.setDescricao(jTextFieldNovoNomePeca.getText());
                }
                if (jTextFieldNovoPrecoPeca.getText() != null && jTextFieldNovoPrecoPeca.getText().trim().isEmpty() == false) {
                    peca.setPreco(Float.parseFloat(jTextFieldNovoPrecoPeca.getText()));
                }
                a.alterarPeca(peca);
                JOptionPane.showMessageDialog(null, "Peça atualizada com sucesso");
                jTextFieldNomePeca.setText(peca.getDescricao());
                jTextFieldPrecoPeca.setText(String.valueOf(peca.getPreco()));
                jTextFieldNovoNomePeca.setText("");
                jTextFieldNovoPrecoPeca.setText("");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try {
            DefaultTableModel A = (DefaultTableModel) jTableFiltroPeca.getModel();
            while (A.getRowCount() > 0) {
                A.removeRow(0);
            }

            DadosPeca b = new DadosPeca();
            Peca pecaConsultada = new Peca();
            pecaConsultada.setDescricao(jTextFieldFiltroPeca.getText());
            ArrayList<Peca> listaPecas = b.consultarPeca(pecaConsultada);
            for (Peca listaPeca : listaPecas) {
                A.addRow(new Object[]{listaPeca.getCodigo(), listaPeca.getDescricao(), listaPeca.getPreco()});

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Menupecas2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menupecas2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menupecas2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menupecas2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menupecas2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButtonFiltroPeca;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelCodPecaFiltro;
    private javax.swing.JLabel jLabelCodPecaOperacao;
    private javax.swing.JLabel jLabelNomePeca;
    private javax.swing.JLabel jLabelNovoNomePeca;
    private javax.swing.JLabel jLabelNovoPrecoPeca;
    private javax.swing.JLabel jLabelPrecoPeca;
    private javax.swing.JRadioButton jRadioButtonAtualizarPeca;
    private javax.swing.JRadioButton jRadioButtonCadastrarPeca;
    private javax.swing.JRadioButton jRadioButtonRemoverPeca;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableFiltroPeca;
    private javax.swing.JTextField jTextFieldCodPecaFiltro;
    private javax.swing.JTextField jTextFieldCodPecaOperacao;
    private javax.swing.JTextField jTextFieldFiltroPeca;
    private javax.swing.JTextField jTextFieldNomePeca;
    private javax.swing.JTextField jTextFieldNovoNomePeca;
    private javax.swing.JTextField jTextFieldNovoPrecoPeca;
    private javax.swing.JTextField jTextFieldPrecoPeca;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == jRadioButtonAtualizarPeca) {
            jTextFieldNomePeca.setText("");
            jTextFieldPrecoPeca.setText("");
            jTextFieldCodPecaOperacao.setText("");
            jLabelCodPecaFiltro.setVisible(true);
            jLabelCodPecaOperacao.setVisible(true);
            jLabelNomePeca.setVisible(true);
            jLabelPrecoPeca.setVisible(true);

            jLabelNovoNomePeca.setVisible(false);
            jLabelNovoPrecoPeca.setVisible(false);
            jTextFieldNovoNomePeca.setVisible(false);
            jTextFieldNovoPrecoPeca.setVisible(false);

            jTextFieldCodPecaFiltro.setVisible(true);
            jTextFieldCodPecaOperacao.setVisible(true);
            jTextFieldNomePeca.setVisible(true);
            jTextFieldPrecoPeca.setVisible(true);
            jTextFieldNomePeca.setEnabled(false);
            jTextFieldPrecoPeca.setEnabled(false);
            jTextFieldCodPecaOperacao.setEnabled(false);
            jButtonFiltroPeca.setVisible(true);
            jButton4.setText("ATUALIZAR");
            jButton4.setVisible(true);
            jButton4.setEnabled(false);
        }

        if (ae.getSource() == jRadioButtonCadastrarPeca) {
            jButton4.setText("CADASTRAR");
            jTextFieldNomePeca.setText("");
            jTextFieldPrecoPeca.setText("");
            jButton4.setEnabled(true);
            jButtonFiltroPeca.setVisible(false);
            jLabelCodPecaFiltro.setVisible(false);
            jLabelCodPecaOperacao.setVisible(false);
            jLabelNovoNomePeca.setVisible(false);
            jLabelNovoPrecoPeca.setVisible(false);
            jTextFieldNovoNomePeca.setVisible(false);
            jTextFieldNovoPrecoPeca.setVisible(false);
            jTextFieldCodPecaFiltro.setVisible(false);
            jTextFieldCodPecaOperacao.setVisible(false);
            jLabelNomePeca.setVisible(true);
            jLabelPrecoPeca.setVisible(true);
            jButton4.setVisible(true);
            jTextFieldNomePeca.setVisible(true);
            jTextFieldNomePeca.setEnabled(true);
            jTextFieldPrecoPeca.setVisible(true);
            jTextFieldPrecoPeca.setEnabled(true);

        }

        if (ae.getSource() == jRadioButtonRemoverPeca) {
            jTextFieldNomePeca.setText("");
            jTextFieldPrecoPeca.setText("");
            jTextFieldCodPecaFiltro.setText("");
            jTextFieldCodPecaOperacao.setText("");
            jButton4.setText("REMOVER");
            jButton4.setEnabled(false);
            jLabelCodPecaFiltro.setVisible(true);
            jLabelCodPecaOperacao.setVisible(true);
            jLabelNovoNomePeca.setVisible(false);
            jLabelNovoPrecoPeca.setVisible(false);
            jTextFieldNovoNomePeca.setVisible(false);
            jTextFieldNovoPrecoPeca.setVisible(false);
            jLabelPrecoPeca.setVisible(true);
            jButton4.setVisible(true);
            jTextFieldCodPecaFiltro.setVisible(true);
            jTextFieldCodPecaOperacao.setVisible(true);
            jTextFieldCodPecaOperacao.setEnabled(false);
            // jTextFieldNomePeca.setVisible(true);
            jButtonFiltroPeca.setVisible(true);
            jTextFieldNomePeca.setEnabled(false);
            jTextFieldPrecoPeca.setEnabled(false);

        }

    }
}
