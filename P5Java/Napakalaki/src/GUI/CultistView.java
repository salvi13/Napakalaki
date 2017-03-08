/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import napakalaki.Cultist;
import napakalaki.CultistPlayer;
import napakalaki.Player;

/**
 *
 * @author Play
 */
public class CultistView extends javax.swing.JPanel {
        Cultist cultistModel;
        boolean selected;
    /**
     * Creates new form CultistView
     */
    public CultistView() {
        initComponents();
    }
    
    
    public void setCultist (Player p) {
        
        if(p instanceof CultistPlayer){
            CultistPlayer cp = (CultistPlayer) p;
            labelName.setText(cp.getMyCultistCard().getName());
            PlusLess.setText("+" + Integer.toString(cp.getMyCultistCard().getSpecialValue()) +" niveles.");
            this.setVisible(true);
             
         }else{
                setVisible(false);
            }
        
        repaint();
    }
    
     public Cultist getCultist() {
        return cultistModel;
    } 

     public boolean isSelected(){
         return selected;
     }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PlusLess = new javax.swing.JLabel();
        labelName = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PlusLess.setText("+/-");
        add(PlusLess, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        labelName.setText("Sectario");
        add(labelName, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel PlusLess;
    private javax.swing.JLabel labelName;
    // End of variables declaration//GEN-END:variables
}