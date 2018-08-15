/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DBTools.DB_ConnectionManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author schmidtu
 */
public class BDE_EmployeeDialog extends javax.swing.JDialog {

    /**
     * Creates new form BDE_EmployeeDialog
     * @param parent
     * @param modal
     */
    public BDE_EmployeeDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        btn_accept.setEnabled(false);
    }
    
    public BDE_EmployeeDialog(java.awt.Frame parent, boolean modal, String aSign, String anUnterabteilung) {
        super(parent, modal);
        TheSign = aSign;
        Unterabteilung = anUnterabteilung;
        initComponents();
        btn_accept.setEnabled(false);
    }
    
    boolean myAnswerIfConnected;
    Connection myConnection;
    DefaultTableModel myTableModel; 
    TableRowSorter<DefaultTableModel> mySorter;
    DB_ConnectionManager MY_DBCM;
    String [] EmployeeData = new String[4];
    String TheSign;
    String Unterabteilung;

    private void do_preBuild() { 
        myTableModel = (DefaultTableModel) jTable_dbData.getModel();    
        createRowSorter(myTableModel); 
        if (TheSign.equals("SIGN_ON")) {
            getDBConnection();
            get_DBTableData(); 
        } 
        if (TheSign.equals("SIGN_OFF")) {
            // ergänzen
            //Informationen kommen aus der neuen Tabelle des MainFrame
        }
        lbl_rowCount.setText(String.valueOf(mySorter.getViewRowCount()) + " von " + String.valueOf(myTableModel.getRowCount()));
    } 
    
    private void do_postBuild() {                
        jTable_dbData.getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
            if (jTable_dbData.getSelectedRow() != -1) {
                btn_accept.setEnabled(true);
            }
            else {btn_accept.setEnabled(false);}
        });
    }
    private void createRowSorter(DefaultTableModel aModel) {
        mySorter = new TableRowSorter<>(aModel);
        jTable_dbData.setRowSorter(mySorter);
    }
    
    private void search() {
        String searchTerm = jTextField_searchValue.getText();
        mySorter.setRowFilter(RowFilter.regexFilter(searchTerm));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_base = new javax.swing.JPanel();
        jPanel_table = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_dbData = new javax.swing.JTable();
        lbl_rowCount = new javax.swing.JLabel();
        lbl_search = new javax.swing.JLabel();
        jTextField_searchValue = new javax.swing.JTextField();
        btn_deleteSearchValue = new javax.swing.JButton();
        btn_getCurrentDBData = new javax.swing.JButton();
        jPanel_foot = new javax.swing.JPanel();
        btn_accept = new javax.swing.JButton();
        btn_cancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 204));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel_base.setBackground(new java.awt.Color(204, 255, 204));

        jPanel_table.setBackground(new java.awt.Color(204, 255, 204));
        jPanel_table.setOpaque(false);

        jTable_dbData.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jTable_dbData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Personal-Nr.", "Name", "Vorname", "Unter-Abteilung", "Abteilung"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_dbData.setRowHeight(28);
        jTable_dbData.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jTable_dbData);
        if (jTable_dbData.getColumnModel().getColumnCount() > 0) {
            jTable_dbData.getColumnModel().getColumn(0).setPreferredWidth(50);
        }

        lbl_rowCount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_rowCount.setPreferredSize(new java.awt.Dimension(300, 14));

        lbl_search.setText("Suchen");

        jTextField_searchValue.setPreferredSize(new java.awt.Dimension(120, 20));
        jTextField_searchValue.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_searchValueKeyReleased(evt);
            }
        });

        btn_deleteSearchValue.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Löschen.png"))); // NOI18N
        btn_deleteSearchValue.setPreferredSize(new java.awt.Dimension(23, 23));
        btn_deleteSearchValue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteSearchValueActionPerformed(evt);
            }
        });

        btn_getCurrentDBData.setText("Aktualisieren");
        btn_getCurrentDBData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_getCurrentDBDataActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_tableLayout = new javax.swing.GroupLayout(jPanel_table);
        jPanel_table.setLayout(jPanel_tableLayout);
        jPanel_tableLayout.setHorizontalGroup(
            jPanel_tableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_tableLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_tableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_tableLayout.createSequentialGroup()
                        .addComponent(lbl_search)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 398, Short.MAX_VALUE)
                        .addComponent(lbl_rowCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 733, Short.MAX_VALUE)
                    .addGroup(jPanel_tableLayout.createSequentialGroup()
                        .addComponent(jTextField_searchValue, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_deleteSearchValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_getCurrentDBData)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel_tableLayout.setVerticalGroup(
            jPanel_tableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_tableLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel_tableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_rowCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel_tableLayout.createSequentialGroup()
                        .addComponent(lbl_search)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel_tableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel_tableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btn_deleteSearchValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btn_getCurrentDBData))
                            .addComponent(jTextField_searchValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel_foot.setBackground(new java.awt.Color(204, 255, 204));
        jPanel_foot.setOpaque(false);

        btn_accept.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_accept.setText("Übernehmen");
        btn_accept.setPreferredSize(new java.awt.Dimension(150, 60));
        btn_accept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_acceptActionPerformed(evt);
            }
        });

        btn_cancel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_cancel.setText("Abbrechen");
        btn_cancel.setPreferredSize(new java.awt.Dimension(150, 60));
        btn_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_footLayout = new javax.swing.GroupLayout(jPanel_foot);
        jPanel_foot.setLayout(jPanel_footLayout);
        jPanel_footLayout.setHorizontalGroup(
            jPanel_footLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_footLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_accept, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_footLayout.setVerticalGroup(
            jPanel_footLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_footLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel_footLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_accept, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel_baseLayout = new javax.swing.GroupLayout(jPanel_base);
        jPanel_base.setLayout(jPanel_baseLayout);
        jPanel_baseLayout.setHorizontalGroup(
            jPanel_baseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_table, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel_foot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel_baseLayout.setVerticalGroup(
            jPanel_baseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_baseLayout.createSequentialGroup()
                .addComponent(jPanel_table, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel_foot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_base, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_base, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void getDBConnection() { 
        MY_DBCM = new DB_ConnectionManager("jdbc:sqlserver://HV-ABAS-SQL;databaseName=DiafBDE;integratedSecurity=true", "CONNECT");
        if (!MY_DBCM.isConnnected()) {
            JOptionPane.showMessageDialog(null,
                    "Der Verbindungs-Aufbau zur Datenbank ist gescheitert. Bitte wenden Sie sich an den Entwickler.",
                    "Fehler",
                    JOptionPane.ERROR_MESSAGE);
        }        
    }
    private void get_DBTableData() {        
        try
        {
            MY_DBCM.setConnection_CLOSED("jdbc:sqlserver://HV-ABAS-SQL;databaseName=DiafBDE;integratedSecurity=true", "DISCONNECT");
//            MY_DBCM = new DB_ConnectionManager("jdbc:sqlserver://HV-ABAS-SQL;databaseName=DiafBDE;integratedSecurity=true", "CONNECT");
            getDBConnection();
            myConnection = MY_DBCM.getConnection();
            Statement myStatement = myConnection.createStatement();
            String mySQL = "SELECT * FROM DiafBDE.dbo.V_Mitarbeiter WHERE V_Mitarbeiter.tma_uabt = '" + Unterabteilung + "' ORDER BY V_Mitarbeiter.tma_psid"; // WHERE tma_abt='Technik'";
            ResultSet myResultSet = myStatement.executeQuery(mySQL); 
            int myColumns = myResultSet.getMetaData().getColumnCount();
            int allOldRows = myTableModel.getRowCount();
            if (allOldRows > 0) {
                myTableModel.setRowCount(0);
            }
            while (myResultSet.next()) {
                            
                String[] myValue = new String[myColumns];
                
                for (int i = 1; i <= myColumns; i++) {
                          
                    String myDataSet = myResultSet.getString(i);
                    myValue[i-1] = myDataSet.trim();
                }  
                myTableModel.addRow(myValue);
            }
            if (!myResultSet.next()) {
            }   
        }
        catch (SQLException myException ) {
            System.out.println(myException);
        }
        finally {
            try {
                if (myConnection != null && !myConnection.isClosed()) {
                    myConnection.close();
                }
            } catch (SQLException myException) {
                System.out.println(myException);
            }
        } 
    }
    
    private void btn_acceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_acceptActionPerformed
        // TODO add your handling code here:
        //        Wert an jTable_employeesSignedOn zurückgeben
        int myRow = jTable_dbData.getSelectedRow();
        if (myRow != -1) {
            this.EmployeeData[0] = myTableModel.getValueAt(myRow, 1).toString().trim();
            this.EmployeeData[1] = myTableModel.getValueAt(myRow, 2).toString().trim();
            this.EmployeeData[2] = myTableModel.getValueAt(myRow, 3).toString().trim();
            this.EmployeeData[3] = myTableModel.getValueAt(myRow, 0).toString().trim();
            this.dispose();
        }
    }//GEN-LAST:event_btn_acceptActionPerformed

    
    public String[] getEmployeeDataAsArray() {
        return this.EmployeeData; 
    }
    
    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
        // TODO add your handling code here:
        EmployeeData[0] = "";
        EmployeeData[1] = "";
        EmployeeData[2] = "";
        EmployeeData[3] = "";
        this.dispose();
    }//GEN-LAST:event_btn_cancelActionPerformed

    private void jTextField_searchValueKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_searchValueKeyReleased
        // TODO add your handling code here:
        search();
        lbl_rowCount.setText(String.valueOf(mySorter.getViewRowCount()) + " von " + String.valueOf(myTableModel.getRowCount()));
    }//GEN-LAST:event_jTextField_searchValueKeyReleased

    private void btn_deleteSearchValueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteSearchValueActionPerformed
        // TODO add your handling code here:
        jTextField_searchValue.setText("");
        search();
        lbl_rowCount.setText(String.valueOf(mySorter.getViewRowCount()) + " von " + String.valueOf(myTableModel.getRowCount()));
    }//GEN-LAST:event_btn_deleteSearchValueActionPerformed

    private void btn_getCurrentDBDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_getCurrentDBDataActionPerformed
        // TODO add your handling code here:
        get_DBTableData();
        btn_accept.setEnabled(false);
        //        set_textFieldsEmpty();
    }//GEN-LAST:event_btn_getCurrentDBDataActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        do_preBuild();
        do_postBuild();
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(BDE_EmployeeDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BDE_EmployeeDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BDE_EmployeeDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BDE_EmployeeDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            BDE_EmployeeDialog dialog = new BDE_EmployeeDialog(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_accept;
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_deleteSearchValue;
    private javax.swing.JButton btn_getCurrentDBData;
    private javax.swing.JPanel jPanel_base;
    private javax.swing.JPanel jPanel_foot;
    private javax.swing.JPanel jPanel_table;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_dbData;
    private javax.swing.JTextField jTextField_searchValue;
    private javax.swing.JLabel lbl_rowCount;
    private javax.swing.JLabel lbl_search;
    // End of variables declaration//GEN-END:variables
}
