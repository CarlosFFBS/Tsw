/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sla.pecas.forms;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import javax.swing.JOptionPane;
import sla.operacoes.Operacao;
import sla.pecas.DadosPeca;
import sla.pecas.NegocioPeca;
import sla.pecas.Peca;

/**
 *
 * @author Consultor SCA 02
 */
public class FormCadastrarPeca extends javax.swing.JFrame {

    /**
     * Creates new form FormCadastrarPeca
     */
    public FormCadastrarPeca() {
        initComponents();
        setTitle("CADASTRO DE PEÇAS");
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldnomePeca = new javax.swing.JTextField();
        jTextFieldprecoPeca = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("NOME DA PEÇA");

        jLabel2.setText("CADASTRO DE PEÇAS");

        jLabel4.setText("VALOR DA PEÇA");

        jButton1.setText("CADASTRAR PEÇA");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jTextFieldnomePeca, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jLabel1)))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jTextFieldprecoPeca, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jButton1)))
                .addContainerGap(109, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel2)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldnomePeca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldprecoPeca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addComponent(jButton1)
                .addGap(71, 71, 71))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {

            Peca peca = new Peca();
            NegocioPeca negocio = new NegocioPeca();
            peca.setDescricao(jTextFieldnomePeca.getText());
            String textoPreco = jTextFieldprecoPeca.getText();
            Operacao a = new Operacao();
            Float preco = a.formatadorVirgulaParaPonto(textoPreco);
            peca.setPreco(preco);
            negocio.cadastrarPeca(peca);
            JOptionPane.showMessageDialog(null, "Peça cadastrada com sucesso");
            jTextFieldnomePeca.setText("");
            jTextFieldprecoPeca.setText("");

        } catch (SQLServerException e) {
            //Validação para quando o usuário digitar um número que estoure a capacidade de armazenamento da variável.
            JOptionPane.showMessageDialog(null, "O número informado estoura a capacidade de armazenamento, Verifique o valor e tente novamente.");
            jTextFieldprecoPeca.setText("");
            jTextFieldprecoPeca.requestFocus();

        } catch (NumberFormatException e) {
            // Validação de NumberFormat quando o usuário deixar os 2 campos em branco. 
            // Ele vai entrar no catch por não conseguir converter a variável preço com o método formatadorVirgulaParaPonto, que retorna uma conversão de tipos.
            if (jTextFieldnomePeca.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Informe o nome da peça.");
                jTextFieldnomePeca.requestFocus();

            } else {
                try {
                    Peca peca = new Peca();
                    peca.setDescricao(jTextFieldnomePeca.getText());
                    NegocioPeca validaPeca = new NegocioPeca();
                    validaPeca.cadastrarPeca(peca);

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                    jTextFieldprecoPeca.setText("");
                    jTextFieldprecoPeca.requestFocus();
                }

            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage());
            jTextFieldprecoPeca.setText("");
            jTextFieldprecoPeca.requestFocus();
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
            java.util.logging.Logger.getLogger(FormCadastrarPeca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormCadastrarPeca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormCadastrarPeca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormCadastrarPeca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormCadastrarPeca().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTextFieldnomePeca;
    private javax.swing.JTextField jTextFieldprecoPeca;
    // End of variables declaration//GEN-END:variables
}
