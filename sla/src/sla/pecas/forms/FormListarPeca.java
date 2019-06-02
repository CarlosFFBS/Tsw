/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sla.pecas.forms;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sla.pecas.DadosPeca;
import sla.pecas.NegocioPeca;
import sla.pecas.Peca;
import sla.pecas.forms.FormAlterarPeca;

/**
 *
 * @author Consultor SCA 02
 */
public class FormListarPeca extends javax.swing.JFrame {

    FormAlterarPeca enviaTexto;

    ArrayList<Peca> listaPecas;

    /**
     * Creates new form FormListarPeca
     */
    public FormListarPeca() {

        initComponents();
        setTitle("LISTA DE PEÇAS");
        setLocationRelativeTo(null);
        DefaultTableModel model = (DefaultTableModel) jTableListaPecas.getModel();
        //renomeando os títulos das colunas
        model.setColumnIdentifiers(new Object[]{"Pec_Codigo", "Descrição", "Preco"});
        //eliminando as linhas da tabela existente
        DefaultTableModel modelo = (DefaultTableModel) jTableListaPecas.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        try {
            Peca peca = new Peca();
            NegocioPeca b = new NegocioPeca();
            peca.setDescricao("");
            ArrayList<Peca> listaTotal = b.listarPeca(peca);
            for (Peca listaPeca : listaTotal) {
                model.addRow(new Object[]{listaPeca.getCodigo(), listaPeca.getDescricao(), listaPeca.getPreco()});

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jRadioButtonAlterarPeca = new javax.swing.JRadioButton();
        jRadioButtonRemoverPeca = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jTextFieldFiltroPeca = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableListaPecas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("LISTA DE PEÇAS");

        jButton1.setText("CONFIRMAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButtonAlterarPeca);
        jRadioButtonAlterarPeca.setText("ALTERAR PEÇA");

        buttonGroup1.add(jRadioButtonRemoverPeca);
        jRadioButtonRemoverPeca.setText("REMOVER PEÇA");

        jLabel2.setText("Selecione a peça e em seguida, informe a ação");

        jButton2.setText("PESQUISAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTableListaPecas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableListaPecas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(209, 209, 209)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButtonAlterarPeca)
                    .addComponent(jRadioButtonRemoverPeca))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(134, 134, 134))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextFieldFiltroPeca, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(44, 44, 44))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addComponent(jLabel2)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFieldFiltroPeca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jRadioButtonAlterarPeca)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addComponent(jRadioButtonRemoverPeca)
                        .addGap(37, 37, 37))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
//        int index = jComboBox1.getSelectedIndex();
        //      JOptionPane.showMessageDialog(this, "Index combo " + index + " index tabela " + jTable1.getSelectedRow());
        //    Peca p = this.listaPecas.get(index);
        //  JOptionPane.showMessageDialog(this, p.toString());
        try {
            if (jRadioButtonAlterarPeca.isSelected()) {
                FormAlterarPeca EnviaTexto = new FormAlterarPeca();
                EnviaTexto.setVisible(true);
                Integer pecaSelecionada = (Integer) jTableListaPecas.getValueAt(jTableListaPecas.getSelectedRow(), 0);
                EnviaTexto.RecebeJtable(pecaSelecionada);

            }
            if (jRadioButtonRemoverPeca.isSelected()) {
                Peca b = new Peca();
                NegocioPeca a = new NegocioPeca();
                Integer pecaSelecionada = (Integer) jTableListaPecas.getValueAt(jTableListaPecas.getSelectedRow(), 0);
                b.setCodigo(pecaSelecionada);
                a.removerPecaCod(b);

                JOptionPane.showMessageDialog(null, " Peca removida com sucesso.");
                jTextFieldFiltroPeca.setText("");
                DefaultTableModel modelo = (DefaultTableModel) jTableListaPecas.getModel();

                while (modelo.getRowCount() > 0) {
                    modelo.removeRow(0);
                }

                Peca peca = new Peca();

                peca.setDescricao("");
                ArrayList<Peca> listaTotal = a.listarPeca(peca);
                for (Peca listaPeca : listaTotal) {
                    modelo.addRow(new Object[]{listaPeca.getCodigo(), listaPeca.getDescricao(), listaPeca.getPreco()});

                }

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        try {
            //recebendo o modelo existente na jTable
            DefaultTableModel model = (DefaultTableModel) jTableListaPecas.getModel();
            //renomeando os títulos das colunas
            model.setColumnIdentifiers(new Object[]{"Pec_Codigo", "Descrição", "Preco"});
            //Zerando as linhas existentes na tabela padrão
            while (model.getRowCount() > 0) {
                model.removeRow(0);
            }
            NegocioPeca b = new NegocioPeca();
            Peca pecaConsultada = new Peca();
            pecaConsultada.setDescricao(jTextFieldFiltroPeca.getText());
            ArrayList<Peca> listaPecas = b.consultarPeca(pecaConsultada);
            pecaConsultada = listaPecas.get(0);
            jTextFieldFiltroPeca.setText(String.valueOf(pecaConsultada.getCodigo()));
            for (Peca listaPeca : listaPecas) {
                model.addRow(new Object[]{listaPeca.getCodigo(), listaPeca.getDescricao(), listaPeca.getPreco()});

            }

        } catch (Exception e) {
            try {
                JOptionPane.showMessageDialog(null, e.getMessage());
                //Preenchendo a lista..
                Peca peca = new Peca();
                NegocioPeca b = new NegocioPeca();
                DefaultTableModel modelo = (DefaultTableModel) jTableListaPecas.getModel();

                peca.setDescricao("");
                ArrayList<Peca> listaTotal = b.listarPeca(peca);

                for (Peca listaPeca : listaTotal) {
                    modelo.addRow(new Object[]{listaPeca.getCodigo(), listaPeca.getDescricao(), listaPeca.getPreco()});
                }

            } catch (Exception ez) {

                JOptionPane.showMessageDialog(null, e.getMessage());
                jTextFieldFiltroPeca.setText("");
                jTextFieldFiltroPeca.requestFocus();

            }

        }


    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(FormListarPeca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormListarPeca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormListarPeca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormListarPeca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormListarPeca().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JRadioButton jRadioButtonAlterarPeca;
    private javax.swing.JRadioButton jRadioButtonRemoverPeca;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableListaPecas;
    private javax.swing.JTextField jTextFieldFiltroPeca;
    // End of variables declaration//GEN-END:variables
}
