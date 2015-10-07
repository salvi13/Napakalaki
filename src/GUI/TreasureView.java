package GUI;

import java.awt.Color;
import napakalaki.Treasure;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Play
 */
public class TreasureView extends javax.swing.JPanel {
        Treasure treasureModel;
         boolean selected;
    /**
     * Creates new form TreasureView
     */
    public TreasureView() {
        initComponents();
    }
    
    

    public void setTreasure (Treasure t) {
        treasureModel = t;
        Poro.setText(Integer.toString(treasureModel.getGoldCoins()));
        BonusMaximo.setText(Integer.toString(treasureModel.getMaxBonus()));
        BonusMinimo.setText(Integer.toString(treasureModel.getMinBonus()));
        TipoTreasure.setText(treasureModel.getType().toString());
        NombreTreasure.setText((treasureModel.getName()));
        repaint();
    }

    public Treasure getTreasure() {
        return treasureModel;
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

        NombreTreasure = new javax.swing.JLabel();
        BonusMinimo = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        BonusMaximo = new javax.swing.JLabel();
        Poro = new javax.swing.JLabel();
        TipoTreasure = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));

        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        NombreTreasure.setText("Nombre");
        add(NombreTreasure);

        BonusMinimo.setText("BM");
        add(BonusMinimo);

        jLabel4.setText("/");
        add(jLabel4);

        BonusMaximo.setText("BMax");
        add(BonusMaximo);

        Poro.setText("Oro");
        add(Poro);

        TipoTreasure.setText("Tipo");
        add(TipoTreasure);
        add(filler1);
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
    
        if(selected){
            selected = false;
        }else if(!selected){
            selected = true;
        }
        
        setBackground(Color.red);
        setOpaque(selected);
        repaint();
        
    }//GEN-LAST:event_formMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BonusMaximo;
    private javax.swing.JLabel BonusMinimo;
    private javax.swing.JLabel NombreTreasure;
    private javax.swing.JLabel Poro;
    private javax.swing.JLabel TipoTreasure;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
