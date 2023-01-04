
package shelf;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import shelfpackage.ConnectionProvider;


public class Orders extends javax.swing.JFrame {

    public static String userid;

    public Orders(String userid) {
        this.userid = userid;
        initComponents();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        orderTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        comboField = new javax.swing.JComboBox<>();
        searchButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setText("Orders");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 50, 180, 62));

        orderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Book Id", "Seller Id", "Seller Name", "Seller email", "phone No", "date of purchase", "Due date", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(orderTable);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 238, 1280, 530));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Category");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 170, 120, 30));

        comboField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Educational", "Entertainment" }));
        getContentPane().add(comboField, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 170, 160, 30));

        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });
        getContentPane().add(searchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 170, 80, 30));

        setBounds(270, 150, 1350, 800);
    }// </editor-fold>//GEN-END:initComponents

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        // TODO add your handling code here:
        String category = (String) comboField.getSelectedItem();
        if (category.equals("Educational")) {
            try {
                Connection con = ConnectionProvider.getCon();
                Statement st = con.createStatement();
//                String sql = "select * from orders where buyer = '" + userid + "'";
//                ResultSet rs = st.executeQuery(sql);
                ResultSet d = st.executeQuery("select phoneNumber,emailId,username,bookid,price,purchased_date,due_date,seller from users,orders where userid in (select seller from orders where buyer ='"+userid+"')");

                while ( d.next()) {
                    String seller = d.getString("seller");
                    
                    String ph_no=d.getString("phonenumber");
                    String name=d.getString("userName");
                    String email=d.getString("emailId");
                    String bookid = String.valueOf(d.getString("bookId"));
                    String p_date = String.valueOf(d.getString("purchased_date"));
                    String d_date = "null";
                    String price = d.getString("price");

                    String tbdata[] = {bookid,seller,name,email,ph_no,p_date,d_date,price};
                    DefaultTableModel tbmodel = (DefaultTableModel) orderTable.getModel();
                    tbmodel.addRow(tbdata);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }else{
            try {
                Connection con = ConnectionProvider.getCon();
                Statement st = con.createStatement();
//                String sql = "select * from orders where buyer = '" + userid + "'";
//                ResultSet rs = st.executeQuery(sql);
                ResultSet d = st.executeQuery("select phoneNumber,emailId,username,bookid,price,purchased_date,due_date,seller from users,orders where userid in (select seller from orders where buyer ='"+userid+"')");

                while ( d.next()) {
                    String seller = d.getString("seller");
                    
                    String ph_no=d.getString("phonenumber");
                    String name=d.getString("userName");
                    String email=d.getString("emailId");
                    String bookid = String.valueOf(d.getString("bookId"));
                    String p_date = String.valueOf(d.getString("purchased_date"));
                    String d_date =String.valueOf(d.getString("due_date"));
                    String price = "null";

                    String tbdata[] = {bookid,seller,name,email,ph_no,p_date,d_date,price};
                    DefaultTableModel tbmodel = (DefaultTableModel) orderTable.getModel();
                    tbmodel.addRow(tbdata);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
            
        }
    }//GEN-LAST:event_searchButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Orders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Orders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Orders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Orders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Orders(userid).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable orderTable;
    private javax.swing.JButton searchButton;
    // End of variables declaration//GEN-END:variables
}
