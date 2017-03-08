package napakalaki;

public class Monster implements Card{
    private String name;
    private int combatLevel;
    private BadConsequence bc;
    private Prize price;
    private String icon;
    private int levelChangeAgainstCultistPlayer;

    
    public Monster(String name, int combatLevel, BadConsequence bc, Prize price, String icon) {
        this.name = name;
        this.combatLevel = combatLevel;
        this.bc = bc;
        this.price = price;
        this.icon = icon;
    }
    //TODO he creado otro constructor, porque si no peta en los no cultists
    public Monster(String name, int combatLevel, BadConsequence bc, Prize price, String icon, int levelChangeACultistPlayer) {
        this.name = name;
        this.combatLevel = combatLevel;
        this.bc = bc;
        this.price = price;
        this.icon = icon;
        this.levelChangeAgainstCultistPlayer = levelChangeACultistPlayer;
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

    public String getIcon() {
        return icon;
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

    public void setIcon(String icon) {
        this.icon = icon;
    }
    
    
    public String toString() {
        return "Name = "+getName()+" combatLevel = "+Integer.toString(combatLevel) + "Bc = "+getBc().toString();
    }

    @Override
    public int getBasicValue() {
        return this.getCombatLevel();
    }

    @Override
    public int getSpecialValue() {
        return this.getCombatLevel() + this.levelChangeAgainstCultistPlayer;
    }
    
    
}
