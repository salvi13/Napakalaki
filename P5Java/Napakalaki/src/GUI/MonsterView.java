/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import napakalaki.Monster;

/**
 *
 * @author Play
 */
public class MonsterView extends javax.swing.JPanel {
        Monster monsterModel;
        
    public void setMonster(Monster m){
        monsterModel = m;
        ImageIcon foto;
        if (monsterModel == null){
            foto = new ImageIcon(getClass().getResource("/images/Cartas/cardback.png"));
        }else{
            foto = new ImageIcon(getClass().getResource("/images/Cartas/" + m.getIcon()));
        }
        Icon icono = new ImageIcon(foto.getImage().getScaledInstance(carta.getWidth(), carta.getHeight(), Image.SCALE_DEFAULT));
        carta.setIcon(icono);
        repaint();
    }
    
        
    /**
     * Creates new form MonsterView
     */
    public MonsterView() {
        initComponents();
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        carta = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(320, 340));
        setPreferredSize(new java.awt.Dimension(320, 340));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        carta.setText("jLabel1");
        add(carta, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 320, 340));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel carta;
    // End of variables declaration//GEN-END:variables
}
