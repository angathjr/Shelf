package shelf;


import java.sql.*;
import javax.swing.JOptionPane;
import shelf.login;
import shelfpackage.ConnectionProvider;

public class SignUp extends javax.swing.JFrame {

    public SignUp() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        userNameField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        yearField = new javax.swing.JComboBox<>();
        deptField = new javax.swing.JComboBox<>();
        phoneNoField = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        signupbutton = new javax.swing.JButton();
        batchField = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        admNoField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setText("Sign Up");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(388, 38, -1, -1));

        emailField.setToolTipText("Email");
        getContentPane().add(emailField, new org.netbeans.lib.awtextra.AbsoluteConstraints(388, 138, 250, 36));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Admission No.");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(275, 200, -1, -1));

        userNameField.setToolTipText("Email");
        userNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userNameFieldActionPerformed(evt);
            }
        });
        getContentPane().add(userNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(388, 247, 250, 36));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Batch");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(687, 367, 60, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Year");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(275, 310, 43, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Department");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(275, 367, 87, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("phone number");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(275, 429, 100, -1));

        yearField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1st year", "2nd year", "3rd year", "4th year" }));
        yearField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearFieldActionPerformed(evt);
            }
        });
        getContentPane().add(yearField, new org.netbeans.lib.awtextra.AbsoluteConstraints(388, 303, 250, 36));

        deptField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CSE", "MECH", "CIVIL", "EEE", "ECE", "CHEMICAL", "ARCH", " " }));
        deptField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deptFieldActionPerformed(evt);
            }
        });
        getContentPane().add(deptField, new org.netbeans.lib.awtextra.AbsoluteConstraints(388, 360, 250, 36));

        phoneNoField.setToolTipText("Email");
        phoneNoField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneNoFieldActionPerformed(evt);
            }
        });
        getContentPane().add(phoneNoField, new org.netbeans.lib.awtextra.AbsoluteConstraints(387, 422, 250, 36));
        getContentPane().add(passwordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(387, 476, 250, 36));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Password");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(275, 483, 100, -1));

        signupbutton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        signupbutton.setText("Sign Up");
        signupbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupbuttonActionPerformed(evt);
            }
        });
        getContentPane().add(signupbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(454, 548, 88, -1));

        batchField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Batch A", "Batch B", "Batch C", "Batch D" }));
        batchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batchFieldActionPerformed(evt);
            }
        });
        getContentPane().add(batchField, new org.netbeans.lib.awtextra.AbsoluteConstraints(765, 360, 117, 36));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("User Name");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(275, 254, -1, -1));

        admNoField.setToolTipText("Email");
        getContentPane().add(admNoField, new org.netbeans.lib.awtextra.AbsoluteConstraints(388, 193, 250, 36));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Email ID");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(275, 145, -1, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/shelf/4.png"))); // NOI18N
        jLabel10.setText("jLabel10");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(-300, -40, 1300, 700));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void userNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userNameFieldActionPerformed

    private void yearFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_yearFieldActionPerformed

    private void deptFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deptFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deptFieldActionPerformed

    private void phoneNoFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneNoFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phoneNoFieldActionPerformed

    private void signupbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signupbuttonActionPerformed
        // TODO add your handling code here:
        String email = emailField.getText();
        String name = userNameField.getText();
        String password = passwordField.getText();
        String adm_no = admNoField.getText();
        String year = (String) yearField.getSelectedItem();
        String dept = (String) deptField.getSelectedItem();
        String batch = (String) batchField.getSelectedItem();
        String ph_no = phoneNoField.getText();

        try {
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            if (email.equals("") || name.equals("") || password.equals("") || adm_no.equals("") || year.equals("") || dept.equals("") || batch.equals("") || ph_no.equals("")) {
                JOptionPane.showMessageDialog(null, "No field can't be empty");
            } else {
                st.executeUpdate("insert into users values('" + adm_no + "','" + email + "','" + name + "','" + year + "','" + dept + "','" + batch + "','" + ph_no + "','" + password + "')");
                this.setVisible(false);
                new login().setVisible(true);
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "User already exists");
        }
    }//GEN-LAST:event_signupbuttonActionPerformed

    private void batchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_batchFieldActionPerformed

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
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignUp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField admNoField;
    private javax.swing.JComboBox<String> batchField;
    private javax.swing.JComboBox<String> deptField;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JTextField phoneNoField;
    private javax.swing.JButton signupbutton;
    private javax.swing.JTextField userNameField;
    private javax.swing.JComboBox<String> yearField;
    // End of variables declaration//GEN-END:variables
}
