package GUI;

import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JPanel;
import napakalaki.Napakalaki;
import napakalaki.Player;
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
public class PlayerView extends javax.swing.JPanel {
    private Napakalaki napakalakiModel;
    Player playerModel;
    /**
     * Creates new form PlayerView
     */
    public PlayerView() {
        initComponents();
    }
    
    public void fillTreasurePanel (JPanel aPanel, ArrayList<Treasure> aList) {
        // Se elimina la información antigua
        aPanel.removeAll();
        // Se recorre la lista de tesoros construyendo y añadiendo sus vistas
        // al panel
        for (Treasure t : aList) {
            TreasureView aTreasureView = new TreasureView();
            aTreasureView.setTreasure (t);
            aTreasureView.setToolTipText("<html> <body ><a style='color: #ff8000!important;'><strong>" + t.getName() + "</strong></a>    <a style='color: #036323!important;'>" + "+" + t.getMinBonus() + "/+" + t.getMaxBonus() + "</a><br><a style='color: #4e24b9!important;'>Piezas de Oro " + t.getGoldCoins() + "</a><br><br><div style='text-align: right'>" + t.getType() + "</div></html>");
            aTreasureView.setVisible (true);
            aPanel.add (aTreasureView);
        }
        // Se fuerza la actualización visual del panel
        aPanel.repaint();
        aPanel.revalidate();
    }

    public void setNapakalaki(Napakalaki n){
        this.napakalakiModel = n;
    }
    
    public Napakalaki getNapakalaki(){
        return napakalakiModel;
    }
    
    
    public void setPlayer (Player p) {
        playerModel = p;
        PlayerName.setText(playerModel.getName());
        PlayerLevel.setText("Nivel: " + Integer.toString(playerModel.getLevel()));        
        fillTreasurePanel(hiddenTreasures, playerModel.getHiddenTreasures());
        fillTreasurePanel(visibleTreasures, playerModel.getVisibleTreasures());
        //TODO la llamada al otro.
        if (playerModel.isCanEquip()){
            MakeVisibleButton.setEnabled(true);
            playerModel.setCanEquip(false);
        }
        cultistView1.setCultist(playerModel);
        repaint();
        revalidate();
    }

    public void enableBuy(boolean b){
        BuyButton.setEnabled(b);
    }

    public void enableMake(boolean b){
        MakeVisibleButton.setEnabled(b);
    }
    
    public ArrayList<Treasure> getSelectedTreasures(JPanel aPanel) {
        // Se recorren los tesoros que contiene el panel,
        // almacenando en un vector aquellos que están seleccionados.
        // Finalmente se devuelve dicho vector.
        TreasureView tv;
        ArrayList<Treasure> output = new ArrayList();
        for (Component c : aPanel.getComponents()) {
            tv = (TreasureView) c;
            if (tv.isSelected()) {
                output.add(tv.getTreasure());
            }
        }
        return output;
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PlayerName = new javax.swing.JLabel();
        PlayerLevel = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        BuyButton = new javax.swing.JButton();
        MakeVisibleButton = new javax.swing.JButton();
        DiscardTreasureButton = new javax.swing.JButton();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10), new java.awt.Dimension(32767, 10));
        visibleTreasures = new javax.swing.JPanel();
        hiddenTreasures = new javax.swing.JPanel();
        cultistView1 = new GUI.CultistView();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PlayerName.setText("Nombre");
        add(PlayerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        PlayerLevel.setText("Nivel");
        add(PlayerLevel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));
        add(filler1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 10, 20));

        BuyButton.setText("BuyLevels");
        BuyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuyButtonActionPerformed(evt);
            }
        });
        add(BuyButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, -1, -1));

        MakeVisibleButton.setText("Make Visible");
        MakeVisibleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MakeVisibleButtonActionPerformed(evt);
            }
        });
        add(MakeVisibleButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, -1, -1));

        DiscardTreasureButton.setText("Discard Treasures");
        DiscardTreasureButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DiscardTreasureButtonActionPerformed(evt);
            }
        });
        add(DiscardTreasureButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 310, 160, -1));
        add(filler2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 290, -1, 10));

        visibleTreasures.setBorder(javax.swing.BorderFactory.createTitledBorder("Tesoros Visibles"));
        add(visibleTreasures, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 400, 120));

        hiddenTreasures.setBorder(javax.swing.BorderFactory.createTitledBorder("Tesoros Ocultos"));
        add(hiddenTreasures, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 400, 110));
        add(cultistView1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void MakeVisibleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MakeVisibleButtonActionPerformed
       // TODO add your handling code here:
        ArrayList<Treasure> selHidden = getSelectedTreasures(hiddenTreasures);
        napakalakiModel.makeTreasuresVisibles(selHidden);
        setPlayer(napakalakiModel.getCurrentPlayer());
        
    }//GEN-LAST:event_MakeVisibleButtonActionPerformed

    private void DiscardTreasureButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DiscardTreasureButtonActionPerformed
        
        ArrayList<Treasure> selHidden = getSelectedTreasures(hiddenTreasures);
        napakalakiModel.discardHiddenTreasures(selHidden);
        ArrayList<Treasure> selVisible = getSelectedTreasures(visibleTreasures);
        napakalakiModel.discardVisibleTreasures(selVisible);
        setPlayer(napakalakiModel.getCurrentPlayer());
    }//GEN-LAST:event_DiscardTreasureButtonActionPerformed

    private void BuyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuyButtonActionPerformed
           
        ArrayList<Treasure> selHidden = getSelectedTreasures(hiddenTreasures);
        ArrayList<Treasure> selVisible = getSelectedTreasures(visibleTreasures);           
        napakalakiModel.getCurrentPlayer().buyLevels(selVisible, selHidden);  
        setPlayer(napakalakiModel.getCurrentPlayer());
    }//GEN-LAST:event_BuyButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BuyButton;
    private javax.swing.JButton DiscardTreasureButton;
    private javax.swing.JButton MakeVisibleButton;
    private javax.swing.JLabel PlayerLevel;
    private javax.swing.JLabel PlayerName;
    private GUI.CultistView cultistView1;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.JPanel hiddenTreasures;
    private javax.swing.JPanel visibleTreasures;
    // End of variables declaration//GEN-END:variables
}
