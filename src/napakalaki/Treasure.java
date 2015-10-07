/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package napakalaki;

public class Treasure {
    private String name;
    private int goldCoins;
    private int minBonus;
    private int maxBonus;
    private TreasureKind type;

    public Treasure(String name, int goldCoins, int minBonus, int maxBonus, TreasureKind type) {
        this.name = name;
        this.goldCoins = goldCoins;
        this.minBonus = minBonus;
        this.maxBonus = maxBonus;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public int getGoldCoins() {
        return goldCoins;
    }

    public void setGoldCoins(int goldCoins) {
        this.goldCoins = goldCoins;
    }
    
    public int getMinBonus() {
        return minBonus;
    }

    public void setMinBonus(int minBonus) {
        this.minBonus = minBonus;
    }

    public int getMaxBonus() {
        return maxBonus;
    }

    public void setMaxBonus(int maxBonus) {
        this.maxBonus = maxBonus;
    }

    public void setType(TreasureKind type) {
        this.type = type;
    }
    
    public TreasureKind getType() {
        return type;
    }

    public String toString() {
        return "name=" + name + ", goldCoins=" + goldCoins + ", minBonus=" + minBonus + ", maxBonus=" + maxBonus + ", type=" + type;
    }
    
    
}
