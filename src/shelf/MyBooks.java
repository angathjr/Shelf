package shelf;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import shelfpackage.ConnectionProvider;

public class MyBooks extends javax.swing.JFrame {

    public static String userid;

    public MyBooks(String userid) {
        this.userid = userid;
        initComponents();
        try {
            DefaultTableModel tbmodel = (DefaultTableModel) bookstable.getModel();
            if (tbmodel != null) {
                tbmodel.getDataVector().removeAllElements();
                tbmodel.fireTableDataChanged();
            }
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            ResultSet d = st.executeQuery("select * from orders natural join books where category='Entertainment' and seller='" + userid + "'");

            while (d.next()) {
                String bid = String.valueOf(d.getString("bookId"));
                String name = d.getString("bookName");
                String buyerid = String.valueOf(d.getString("buyer"));
                String pdate = d.getString("purchased_date");
                String ddate = d.getString("due_date");
                String avail = d.getString("availability");

                String tbdata[] = {bid, name, buyerid, pdate, ddate, avail};
                tbmodel.addRow(tbdata);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        bookstable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        buyeridField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        searchTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        updateFiled = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bookstable.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        bookstable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bookstable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book id", "Book Name", "Buyer id", "purchased date", "Due date", "Availability"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        bookstable.setRowHeight(30);
        jScrollPane1.setViewportView(bookstable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 820, 490));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setText("My Books");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(516, 28, 260, 73));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Get Buyer Details");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 170, 230, 70));

        buyeridField.setToolTipText("Enter buyer id");
        buyeridField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buyeridFieldActionPerformed(evt);
            }
        });
        getContentPane().add(buyeridField, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 270, 170, 30));

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 270, -1, 30));

        searchTable.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        searchTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        searchTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fields", "Details"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        searchTable.setRowHeight(30);
        jScrollPane2.setViewportView(searchTable);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 340, 440, 320));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Buyer id :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 270, 90, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel4.setText("Update  book  status");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 720, 210, 40));

        updateFiled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateFiledActionPerformed(evt);
            }
        });
        getContentPane().add(updateFiled, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 720, 170, 40));

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 730, -1, -1));

        setBounds(270, 150, 1350, 800);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            DefaultTableModel tbmodel2 = (DefaultTableModel) searchTable.getModel();
            if (tbmodel2 != null) {
                tbmodel2.getDataVector().removeAllElements();
                tbmodel2.fireTableDataChanged();
            }
            int i = 0;
            String[] fields = {"Buyer Name", "Email id", "Phone Number", "year", "department", "batch"};
            String buyer_id = buyeridField.getText();
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("select userid from users where userid in (select buyer from orders natural join books where category='Entertainment' and seller='" + userid + "')");
            if (rs.next()) {
                rs.close();

                ResultSet d = st.executeQuery("select * from users where userid='" + buyer_id + "'");
                d.next();
                String username = d.getString("userName");
                String email = d.getString("emailId");
                String ph = String.valueOf(d.getString("phoneNumber"));
                String year = d.getString("year");
                String dept = d.getString("department");
                String batch = d.getString("batch");
                String[] values = {username, email, ph, year, dept, batch};

                d.close();
                while (i < 6) {
                    String tbdata[] = {fields[i], values[i]};
//                    DefaultTableModel tbmodel2 = (DefaultTableModel) searchTable.getModel();
                    tbmodel2.addRow(tbdata);
                    i++;
                }
            }

        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "User doesnot exists");

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void buyeridFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buyeridFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buyeridFieldActionPerformed

    private void updateFiledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateFiledActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateFiledActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String id = updateFiled.getText();
        try {
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            String sql = "update books set availability='yes'  where bookid='" + id + "' ";
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Sucessfully updated");
            updateFiled.setText(" ");

        } catch (Exception e) {
            System.out.println(e);
        }

    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(MyBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MyBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MyBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MyBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MyBooks(userid).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable bookstable;
    private javax.swing.JTextField buyeridField;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable searchTable;
    private javax.swing.JTextField updateFiled;
    // End of variables declaration//GEN-END:variables
}
