/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import napakalaki.BadConsequence;

/**
 *
 * @author Play
 */
public class BadConsequenceView extends javax.swing.JPanel {
    BadConsequence badConsequenceModel;
            
            
    public void setBadConsequence(BadConsequence bc){    
        
        badConsequenceModel = bc;
   
        text.setText("<html><div style=' text-align: justify; color: #778899; ' >" + badConsequenceModel.getText() + "</div></html>");
        
        //No le veo sentido ponerlo, si lo explica en el texto.
       // levels.setText(Integer.toString(badConsequenceModel.getLevels()));
       // nVisibleTreasures.setText(Integer.toString(bc.getnVisibleTreasures()));
       // nHiddenTreasures.setText(Integer.toString(bc.getnHiddenTreasures()));
       // death.setText(Boolean.toString(bc.isDeath()));
       // specificVisibleTreasures.setText(bc.getSpecificVisibleTreasures().toString());
       // specificHiddenTreasures.setText(bc.getSpecificHiddenTreasures().toString());
        repaint();    
    }
            
    /**
     * Creates new form BadConsequenceView
     */
    public BadConsequenceView() {
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

        text = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        text.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        text.setText("Texto");
        text.setBorder(javax.swing.BorderFactory.createTitledBorder("Mal Rollo"));
        add(text, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 60));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel text;
    // End of variables declaration//GEN-END:variables
}