package napakalaki;

public class Monster {
    private String name;
    private int combatLevel;
    private BadConsequence bc;
    private Prize price;

    public Monster(String name, int combatLevel, BadConsequence bc, Prize price) {
        this.name = name;
        this.combatLevel = combatLevel;
        this.bc = bc;
        this.price = price;
    }

    public int getCombatLevel() {
        return combatLevel;
    }

    public String getName() {
        return name;
    }

    public BadConsequence getBc() {
        return bc;
    }

    public Prize getPrice() {
        return price;
    }
    
    public int getLevelsGained(){
        return price.getLevel();
    }
    
    public int getTreasuresGained(){
        return price.getTreasures();
    }
    
    public boolean kills(){
        return bc.myBadConsequenceisDeath();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCombatLevel(int combatLevel) {
        this.combatLevel = combatLevel;
    }

    public void setBc(BadConsequence bc) {
        this.bc = bc;
    }

    public void setPrice(Prize price) {
        this.price = price;
    }
    
    public String toString() {
        return "Name = "+getName()+" combatLevel = "+Integer.toString(combatLevel) + "Bc = "+getBc().toString();
    }
    
    
}
