
package shelf;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import shelfpackage.ConnectionProvider;

public class EduBooks extends javax.swing.JFrame {

    
    public EduBooks() {
        initComponents();
        try{
         Connection con = ConnectionProvider.getCon();
         Statement st = con.createStatement();
         String sql ="select * from books where category='Educational';";
         ResultSet rs=st.executeQuery(sql);
         while(rs.next()){
             String id=String.valueOf(rs.getString("bookId"));
             String name=rs.getString("bookName");
             String author=rs.getString("author");
             String publisher=rs.getString("publisher");
             String edition=String.valueOf(rs.getString("edition"));
             String avail=rs.getString("availability");
             String price=rs.getString("price");
             String seller=rs.getString("seller");
                          
             String tbdata[]={id,name,author,publisher,edition,avail,seller,price};
             DefaultTableModel tbmodel=(DefaultTableModel)eduTable.getModel();
             tbmodel.addRow(tbdata);
         }
        }catch(Exception e){
            System.out.println(e);
        }
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        eduTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(255, 204, 204));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setText("Educational Books");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(418, 40, -1, -1));

        eduTable.setForeground(new java.awt.Color(0, 0, 0));
        eduTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null}
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
        jScrollPane1.setViewportView(eduTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 1270, 540));

        setBounds(270, 150, 1350, 793);
    }// </editor-fold>//GEN-END:initComponents

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
                new EduBooks().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable eduTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
