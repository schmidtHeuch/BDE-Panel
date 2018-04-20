/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BDE_Panel;
import GUI.BDE_MainFrame;

/**
 *
 * @author schmidtu
 */
public class BDEPanel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BDE_MainFrame bde_MainFrame = new BDE_MainFrame();
        bde_MainFrame.setTitle("BDE-Panel");
        bde_MainFrame.setSize(1400, 900);
        bde_MainFrame.setResizable(true);
        bde_MainFrame.setLocation(50, 50);
        bde_MainFrame.setVisible(true);
    }
    
}
