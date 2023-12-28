/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package screens;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import dto.HistoriqueDto;
import projgl.db.dbControl;

//import screens.cl1;

/**
 *
 * @author HP
 */
public class Historique extends javax.swing.JFrame {

    /**
     * Creates new form Client2
     */
    public Historique(int idC) {
        initComponents();
        db = new dbControl();
        idCompte = idC;
        tableHist.setModel(model);
        model.addColumn("Num Operation");
        model.addColumn("Date");
        model.addColumn("Montant");
        model.addColumn("Debiter/Crediter");
        refresh();
    }

    dbControl db;
    DefaultTableModel model = new DefaultTableModel();
    final int idCompte;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scroll = new javax.swing.JScrollPane();
        tableHist = new javax.swing.JTable();
        btnReturn = new javax.swing.JButton();
        wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableHist.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Operation", "Date", "Montant"
            }
        ));
        scroll.setViewportView(tableHist);

        getContentPane().add(scroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 140, 350, 240));

        btnReturn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnReturn.setForeground(new java.awt.Color(0, 0, 102));
        btnReturn.setText("< Retourner");
        btnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnActionPerformed(evt);
            }
        });
        getContentPane().add(btnReturn, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        wallpaper.setIcon(new javax.swing.ImageIcon("C:\\Study\\L3\\GL\\Projet\\Code\\projGL\\src\\screens\\banka.jpg")); // NOI18N
        wallpaper.setText("jLabel1");
        getContentPane().add(wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1300, 630));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnReturnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnReturnActionPerformed
        // TODO add your handling code here:
        // cl1 a=new cl1();
        // a.show();
        dispose();
    }// GEN-LAST:event_btnReturnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Historique.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Historique.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Historique.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Historique.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // new Client2().setVisible(true);
            }
        });
    }

    private void refresh() {
        model.setRowCount(0);
        var list = db.findAllHistorique(idCompte);
        for (HistoriqueDto hist : list) {
            model.addRow(new Object[] { 
                hist.getIdHist(), 
                hist.getDate(), 
                Math.abs(hist.getMontant()),
                hist.getMontant() > 0 ? "Crediter" : "Debiter"
            });
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReturn;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTable tableHist;
    private javax.swing.JLabel wallpaper;
    // End of variables declaration//GEN-END:variables
}