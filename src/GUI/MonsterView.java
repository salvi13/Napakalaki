/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import napakalaki.Monster;

/**
 *
 * @author Play
 */
public class MonsterView extends javax.swing.JPanel {
        Monster monsterModel;
        
    public void setMonster(Monster m){
        monsterModel = m;
        name.setText(monsterModel.getName());
        combatLevel.setText("Nivel: " + Integer.toString(monsterModel.getCombatLevel()));
        badConsequenceView1.setBadConsequence(monsterModel.getBc());
        prizeView1.setPrize(monsterModel.getPrice());
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

        name = new javax.swing.JLabel();
        combatLevel = new javax.swing.JLabel();
        badConsequenceView1 = new GUI.BadConsequenceView();
        prizeView1 = new GUI.PrizeView();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        name.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        name.setText("name");
        add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        combatLevel.setText("combatLevel");
        add(combatLevel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, -1, -1));
        add(badConsequenceView1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        prizeView1.setBorder(javax.swing.BorderFactory.createTitledBorder("Prize"));
        add(prizeView1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, 80, 60));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.BadConsequenceView badConsequenceView1;
    private javax.swing.JLabel combatLevel;
    private javax.swing.JLabel name;
    private GUI.PrizeView prizeView1;
    // End of variables declaration//GEN-END:variables
}
