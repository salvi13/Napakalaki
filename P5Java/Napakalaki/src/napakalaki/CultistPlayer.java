/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;

/**
 *
 * @author Play
 */
public class CultistPlayer extends Player{
    
    private static int totalCultistPlayers = 0;
    private Cultist myCultistCard;
    
    public CultistPlayer(Player p,Cultist c) {
        super(p);
        this.myCultistCard = c;
        totalCultistPlayers++;
        
    }

    public static int getTotalCultistPlayers(){
        return totalCultistPlayers;
    }
    
    public Cultist getMyCultistCard() {
        return myCultistCard;
    }
        
    @Override
    protected int getCombatLevel() {
        return super.getCombatLevel() + myCultistCard.getSpecialValue();
    }

    @Override
    protected int getOponentLevel(Monster m) {
        return m.getSpecialValue(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected boolean shouldConvert() {
        return false;
    }


    @Override
    protected float computeGoldCoinsValue(ArrayList<Treasure> t) {
        return super.computeGoldCoinsValue(t) * 2; //To change body of generated methods, choose Tools | Templates.
    }


    
    
    
}
