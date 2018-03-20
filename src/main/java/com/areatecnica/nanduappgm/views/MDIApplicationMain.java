/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.areatecnica.nanduappgm.views;

import com.areatecnica.nanduappgm.controllers.InformeCrosstabController;
import com.areatecnica.nanduappgm.controllers.InformeMinutosFechaController;
import com.areatecnica.nanduappgm.controllers.InformeMinutosPagadosFlotaController;
import com.areatecnica.nanduappgm.controllers.InformeMinutosPendientesPagarController;
import com.areatecnica.nanduappgm.controllers.RegistroMinutoController;
import com.areatecnica.nanduappgm.helpers.ButtonTabComponent;
import com.areatecnica.nanduappgm.helpers.SystemTrayIcon;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author ianfrancoconcha
 */
public class MDIApplicationMain extends javax.swing.JFrame {

    /**
     * Creates new form MDIApplicationMain
     */
    public MDIApplicationMain() {
        initComponents();
        icon = new SystemTrayIcon();
        //java.awt.SystemTray.getSystemTray().add(new java.awt.TrayIcon(java.awt.Toolkit.getDefaultToolkit().getImage("foo.png")));
        
        //icon.addInfoMessage("Bienvenido", "Sistema de Registro de Minutos");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabbedPane = new javax.swing.JTabbedPane();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        exitMenuItem = new javax.swing.JMenuItem();
        actionMenu = new javax.swing.JMenu();
        registroMinutosMenuItem = new javax.swing.JMenuItem();
        repotMenu = new javax.swing.JMenu();
        minutosRecaudarMenuItem = new javax.swing.JMenuItem();
        minutosFechaMenuItem = new javax.swing.JMenuItem();
        minutosPagarFlotaMenuItem = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        crossTabMinutosMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        contentMenuItem = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Gestión de Minutos");
        setIgnoreRepaint(true);
        setLocationByPlatform(true);

        fileMenu.setMnemonic('f');
        fileMenu.setText("Archivo");

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Salir");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        actionMenu.setMnemonic('e');
        actionMenu.setText("Acciones");

        registroMinutosMenuItem.setMnemonic('t');
        registroMinutosMenuItem.setText("Registro");
        registroMinutosMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registroMinutosMenuItemActionPerformed(evt);
            }
        });
        actionMenu.add(registroMinutosMenuItem);

        menuBar.add(actionMenu);

        repotMenu.setText("Informes");

        minutosRecaudarMenuItem.setText("Minutos x Recaudar");
        minutosRecaudarMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minutosRecaudarMenuItemActionPerformed(evt);
            }
        });
        repotMenu.add(minutosRecaudarMenuItem);

        minutosFechaMenuItem.setText("Minutos x Fecha");
        minutosFechaMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minutosFechaMenuItemActionPerformed(evt);
            }
        });
        repotMenu.add(minutosFechaMenuItem);

        minutosPagarFlotaMenuItem.setText("Resumen Minutos x Flota");
        minutosPagarFlotaMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minutosPagarFlotaMenuItemActionPerformed(evt);
            }
        });
        repotMenu.add(minutosPagarFlotaMenuItem);

        jMenuItem10.setText("Resumen Minutos Recibidos x Flota");
        repotMenu.add(jMenuItem10);

        jMenuItem11.setText("Minutos Pagados x Bus");
        repotMenu.add(jMenuItem11);

        jMenuItem12.setText("Minutos Recibidos x Bus");
        repotMenu.add(jMenuItem12);

        jMenuItem6.setText("Minutos x Mes");
        repotMenu.add(jMenuItem6);

        crossTabMinutosMenuItem.setText("Crosstab Minutos");
        crossTabMinutosMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crossTabMinutosMenuItemActionPerformed(evt);
            }
        });
        repotMenu.add(crossTabMinutosMenuItem);

        menuBar.add(repotMenu);

        helpMenu.setMnemonic('h');
        helpMenu.setText("Ayuda");

        contentMenuItem.setMnemonic('c');
        contentMenuItem.setText("Contenido");
        helpMenu.add(contentMenuItem);

        aboutMenuItem.setMnemonic('a');
        aboutMenuItem.setText("Acerca de.. ");
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 715, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void registroMinutosMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registroMinutosMenuItemActionPerformed
        if (minutoView == null) {
            minutoView = new RegistroMinutoView();
            RegistroMinutoController controller = new RegistroMinutoController(this, minutoView);
            setNewTab(minutoView, "Registro de Minutos");
        }else{
            System.err.println("No es null");
        }
    }//GEN-LAST:event_registroMinutosMenuItemActionPerformed

    private void crossTabMinutosMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crossTabMinutosMenuItemActionPerformed
        reporteMes = new ReporteMesView();
        InformeCrosstabController controller = new InformeCrosstabController(reporteMes);
        setNewTab(reporteMes, "Crostab Minutos/Mes");
    }//GEN-LAST:event_crossTabMinutosMenuItemActionPerformed

    private void minutosRecaudarMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minutosRecaudarMenuItemActionPerformed
        reporteMes = new ReporteMesView();
        InformeMinutosPendientesPagarController controller = new InformeMinutosPendientesPagarController(reporteMes); 
        setNewTab(reporteMes, "Minutos x Recaudar");
    }//GEN-LAST:event_minutosRecaudarMenuItemActionPerformed

    private void minutosFechaMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minutosFechaMenuItemActionPerformed
        reporteFecha = new ReporteFechaView();
        InformeMinutosFechaController controller = new InformeMinutosFechaController(reporteFecha);
        setNewTab(reporteFecha, "Minutos x Fecha");
    }//GEN-LAST:event_minutosFechaMenuItemActionPerformed

    private void minutosPagarFlotaMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minutosPagarFlotaMenuItemActionPerformed
        reporteMesFlota = new ReporteMesFlotaView();
        InformeMinutosPagadosFlotaController controller = new InformeMinutosPagadosFlotaController(reporteMesFlota);
        setNewTab(reporteMesFlota, "Resumen Minutos Pagados x Flota"); 
    }//GEN-LAST:event_minutosPagarFlotaMenuItemActionPerformed

    private void setNewTab(JPanel panel, String title) {
        this.tabbedPane.add(title, panel);
        this.tabbedPane.setSelectedComponent(panel);
        this.tabbedPane.setTabComponentAt(this.tabbedPane.getSelectedIndex(), new ButtonTabComponent(this.tabbedPane));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            /* Set the Nimbus look and feel */
            //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
            /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
            * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
             */
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            //</editor-fold>

            /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    MDIApplicationMain m = new MDIApplicationMain();
                    m.setVisible(true);
                    m.setExtendedState(JFrame.MAXIMIZED_BOTH);
                }
            });
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MDIApplicationMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(MDIApplicationMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(MDIApplicationMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(MDIApplicationMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenu actionMenu;
    private javax.swing.JMenuItem contentMenuItem;
    private javax.swing.JMenuItem crossTabMinutosMenuItem;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem minutosFechaMenuItem;
    private javax.swing.JMenuItem minutosPagarFlotaMenuItem;
    private javax.swing.JMenuItem minutosRecaudarMenuItem;
    private javax.swing.JMenuItem registroMinutosMenuItem;
    private javax.swing.JMenu repotMenu;
    private javax.swing.JTabbedPane tabbedPane;
    // End of variables declaration//GEN-END:variables
    private final SystemTrayIcon icon;
    private static RegistroMinutoView minutoView;
    private ReporteMesView reporteMes;
    private ReporteFechaView reporteFecha;
    private ReporteMesFlotaView reporteMesFlota;

}
