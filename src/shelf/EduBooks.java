package shelf;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import shelfpackage.ConnectionProvider;

public class EduBooks extends javax.swing.JFrame {

    public static String userid;

    public EduBooks(String userid) {
        this.userid = userid;
        initComponents();
        try {
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            String sql = "select * from books where category='Educational';";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                String id = String.valueOf(rs.getString("bookId"));
                String name = rs.getString("bookName");
                String author = rs.getString("author");
                String publisher = rs.getString("publisher");
                String edition = String.valueOf(rs.getString("edition"));
                String avail = rs.getString("availability");
                String price = rs.getString("price");
                String seller = rs.getString("seller_name");

                String tbdata[] = {id, name, author, publisher, edition, avail, seller, price};
                DefaultTableModel tbmodel = (DefaultTableModel) eduTable.getModel();
                tbmodel.addRow(tbdata);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        eduTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        bookField = new javax.swing.JTextField();
        confirmButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 204, 204));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setText("Educational Books");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(418, 40, -1, -1));

        eduTable.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        eduTable.setForeground(new java.awt.Color(0, 0, 0));
        eduTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book Id", "Book Name", "Author", "Publisher", "Edition", "Availability", "Seller", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        eduTable.setRowHeight(30);
        jScrollPane1.setViewportView(eduTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 1270, 370));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Enter the book id to confirm purchase");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 650, 330, 40));
        getContentPane().add(bookField, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 660, 230, 30));

        confirmButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        confirmButton.setText("Confirm");
        confirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmButtonActionPerformed(evt);
            }
        });
        getContentPane().add(confirmButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 660, 100, 40));

        setBounds(270, 150, 1350, 793);
    }// </editor-fold>//GEN-END:initComponents

    private void confirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmButtonActionPerformed
        // TODO add your handling code here:
        String bookId = bookField.getText();
        try {
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select userId,category,price from books where bookId='" + bookId + "' and availability='yes'");
            if (rs.next()) {
                String owner = rs.getString("userId");
                String category = rs.getString("category");
                String price = rs.getString("price");
                st.executeUpdate("insert into orders values('" + userid + "','" + owner + "','" + bookId + "',curdate(),date_add(curdate(),interval 20 day),'" + category + "','" + price + "')");
                st.executeUpdate("update books set availability='No' where bookId='" + bookId + "'");
                bookField.setText(" ");
                JOptionPane.showMessageDialog(null, "Book Orderd");
            } else {
                JOptionPane.showMessageDialog(null, "Book Not available");

            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_confirmButtonActionPerformed

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
            java.util.logging.Logger.getLogger(EduBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EduBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EduBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EduBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EduBooks(userid).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bookField;
    private javax.swing.JButton confirmButton;
    private javax.swing.JTable eduTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
