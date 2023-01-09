package shelf;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import shelfpackage.ConnectionProvider;

public class EntertainmentBooks extends javax.swing.JFrame {

    public static String userid;

    public EntertainmentBooks(String userid) {
        this.userid = userid;
        initComponents();
        try {
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            String sql = "select * from books where category='Entertainment';";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String id = String.valueOf(rs.getString("bookId"));
                String name = rs.getString("bookName");
                String author = rs.getString("author");
                String publisher = rs.getString("publisher");
                String avail = rs.getString("availability");
                String seller = rs.getString("seller_name");

                String tbdata[] = {id, name, author, publisher, avail, seller};
                DefaultTableModel tbmodel = (DefaultTableModel) entTable.getModel();
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
        entTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        bookField = new javax.swing.JTextField();
        confirmButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setText("Entertainment Books");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, 518, -1));

        entTable.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        entTable.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        entTable.setForeground(new java.awt.Color(0, 0, 0));
        entTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book ID", "Book Name", "Author", "Publisher", "Availability", "Owner"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        entTable.setRowHeight(30);
        jScrollPane1.setViewportView(entTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 1200, 420));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Enter the book id to confirm purchase");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 650, 330, 40));

        bookField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookFieldActionPerformed(evt);
            }
        });
        getContentPane().add(bookField, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 660, 230, 30));

        confirmButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        confirmButton.setText("Confirm");
        confirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmButtonActionPerformed(evt);
            }
        });
        getContentPane().add(confirmButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 650, 100, 40));

        setBounds(270, 150, 1350, 800);
    }// </editor-fold>//GEN-END:initComponents

    private void confirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmButtonActionPerformed
        // TODO add your handling code here:
        String bookId = bookField.getText();
        try {
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select userId,price from books where bookId='" + bookId + "' and availability='yes'");
            if (rs.next()) {
                String owner = rs.getString("userId");
                int price = Integer.parseInt(rs.getString("price"));
                System.out.println(price);
                st.executeUpdate("insert into orders values('" + userid + "','" + owner + "','" + bookId + "',curdate(),date_add(curdate(),interval 20 day),'Entertainment','" + price + "')");
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

    private void bookFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bookFieldActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EntertainmentBooks(userid).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bookField;
    private javax.swing.JButton confirmButton;
    private javax.swing.JTable entTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
