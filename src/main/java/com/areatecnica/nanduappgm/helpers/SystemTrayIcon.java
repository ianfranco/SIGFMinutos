/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.areatecnica.nanduappgm.helpers;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Administrador
 */
public class SystemTrayIcon {

    private TrayIcon iconoSystemTray;
    private SystemTray tray;

    public SystemTrayIcon() {
        start();
    }

    private boolean start() {
        if (SystemTray.isSupported()) {
            tray = SystemTray.getSystemTray();

            InputStream input = getClass().getResourceAsStream("/androidBus.png");

            Image imagenIcono;
            try {
                imagenIcono = ImageIO.read(input); //Toolkit.getDefaultToolkit().getImage(getClass().getResourceAsStream("/androidBus.png"));
                iconoSystemTray = new TrayIcon(imagenIcono, "Prueba System Tray");
                iconoSystemTray.setImageAutoSize(true);
                
                tray.add(iconoSystemTray);
                
            } catch (IOException | AWTException ex) {
                Logger.getLogger(SystemTrayIcon.class.getName()).log(Level.SEVERE, null, ex);
            }

            
            return true;
        }
        return false;
    }

    public void addErrorMessage(String title, String message) {
        iconoSystemTray.displayMessage(title, message, TrayIcon.MessageType.ERROR);
    }

    public void addWarningMessage(String title, String message) {
        iconoSystemTray.displayMessage(title, message, TrayIcon.MessageType.WARNING);
    }

    public void addInfoMessage(String title, String message) {
        iconoSystemTray.displayMessage(title, message, TrayIcon.MessageType.INFO);
    }

}
