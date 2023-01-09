package shelf;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import shelfpackage.ConnectionProvider;

public class sellBook extends javax.swing.JFrame {

    public static String userid, username;

    public sellBook(String userid, String username) {
        this.userid = userid;
        this.username = username;
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        authorField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        pubField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        editionField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        comboField = new javax.swing.JComboBox<>();
        submitField = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        priceField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setForeground(java.awt.Color.darkGray);
        setLocation(new java.awt.Point(0, 0));
        setUndecorated(true);
        setSize(new java.awt.Dimension(1000, 600));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setText("jButton1");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 1522, 75, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Book Name");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(324, 194, 95, -1));
        getContentPane().add(nameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(492, 188, 374, 34));
        getContentPane().add(authorField, new org.netbeans.lib.awtextra.AbsoluteConstraints(492, 265, 374, 34));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Author");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(324, 271, 95, -1));
        getContentPane().add(pubField, new org.netbeans.lib.awtextra.AbsoluteConstraints(492, 342, 374, 34));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("publisher");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(324, 348, 95, -1));
        getContentPane().add(editionField, new org.netbeans.lib.awtextra.AbsoluteConstraints(492, 419, 374, 34));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Edition");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(324, 425, 95, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Category");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(324, 502, 95, -1));

        comboField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Educational", "Entertainment" }));
        comboField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboFieldActionPerformed(evt);
            }
        });
        getContentPane().add(comboField, new org.netbeans.lib.awtextra.AbsoluteConstraints(492, 496, 374, 34));

        submitField.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        submitField.setText("SUBMIT");
        submitField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitFieldActionPerformed(evt);
            }
        });
        getContentPane().add(submitField, new org.netbeans.lib.awtextra.AbsoluteConstraints(565, 677, 145, 49));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Price");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(324, 579, 95, -1));
        getContentPane().add(priceField, new org.netbeans.lib.awtextra.AbsoluteConstraints(492, 573, 374, 34));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel7.setText("Add Your Books here");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, 570, 100));

        setBounds(270, 150, 1350, 800);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void submitFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitFieldActionPerformed
        // TODO add your handling code here:
        int id = Integer.parseInt(userid);
        String name = nameField.getText();
        String author = authorField.getText();
        String publisher = pubField.getText();
        String edition = editionField.getText();
        String category = (String) comboField.getSelectedItem();
        String price = priceField.getText();

        try {
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            if (category.equals("Entertainment")) {
                priceField.setVisible(false);
                jLabel6.setVisible(false);
                price = "0";
            }
            st.executeUpdate("insert into books (userId,bookName,author,publisher,edition,availability,category,seller_name,price) values('" + id + "','" + name + "','" + author + "','" + publisher + "','" + edition + "','yes','" + category + "','" + username + "','" + price + "')");
            nameField.setText("");
            priceField.setText("");
            authorField.setText("");
            pubField.setText("");
            editionField.setText("");
            JOptionPane.showMessageDialog(null, "Sucessfully added");

        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "fiedls can't be empty");

        }

    }//GEN-LAST:event_submitFieldActionPerformed

    private void comboFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboFieldActionPerformed
        // TODO add your handling code here:
        String category = (String) comboField.getSelectedItem();

        if (category.equals("Entertainment")) {
            priceField.setVisible(false);
            jLabel6.setVisible(false);

        }
        if (category.equals("Educational")) {
            priceField.setVisible(true);
            jLabel6.setVisible(true);

        }
    }//GEN-LAST:event_comboFieldActionPerformed

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
            java.util.logging.Logger.getLogger(sellBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(sellBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(sellBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(sellBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new sellBook(userid, username).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField authorField;
    private javax.swing.JComboBox<String> comboField;
    private javax.swing.JTextField editionField;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField nameField;
    private javax.swing.JTextField priceField;
    private javax.swing.JTextField pubField;
    private javax.swing.JButton submitField;
    // End of variables declaration//GEN-END:variables
}
