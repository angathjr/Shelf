
package shelf;


public class Home extends javax.swing.JFrame {
    
    
    public static String userName;

  
    public Home(String userName) {
        
        this.userName=userName;
        this.setExtendedState(MAXIMIZED_BOTH);
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        eduBooks = new javax.swing.JButton();
        libBooks = new javax.swing.JButton();
        sellBooks = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(66, 63, 65));
        setMinimumSize(new java.awt.Dimension(1400, 800));
        setPreferredSize(new java.awt.Dimension(1400, 800));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        eduBooks.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        eduBooks.setText("Educational books");
        eduBooks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eduBooksActionPerformed(evt);
            }
        });
        getContentPane().add(eduBooks, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 281, 150, 60));

        libBooks.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        libBooks.setText("Stories and novels");
        getContentPane().add(libBooks, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 380, 150, 50));

        sellBooks.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        sellBooks.setText("Sell Books");
        sellBooks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sellBooksActionPerformed(evt);
            }
        });
        getContentPane().add(sellBooks, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 473, 150, 50));

        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton5.setText("Rent Books");
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 566, 150, 50));

        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton6.setText("Orders");
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 659, 150, 50));

        logout.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        logout.setText("Log Out");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });
        getContentPane().add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 740, 150, 50));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel2.setText("Hello");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 140, 80));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText(userName);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 230, 30));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void eduBooksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eduBooksActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_eduBooksActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        
        this.setVisible(false);
        new login().setVisible(true);
    }//GEN-LAST:event_logoutActionPerformed

    private void sellBooksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sellBooksActionPerformed
        // TODO add your handling code here:
        new sellBook().setVisible(true);
    }//GEN-LAST:event_sellBooksActionPerformed

  
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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home(userName).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton eduBooks;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton libBooks;
    private javax.swing.JButton logout;
    private javax.swing.JButton sellBooks;
    // End of variables declaration//GEN-END:variables
}
