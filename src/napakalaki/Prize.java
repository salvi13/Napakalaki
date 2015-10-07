package napakalaki;

public class Prize {

    private int treasures;
    private int level;

    public Prize(int treasures, int level) {
        this.treasures = treasures;
        this.level = level;
    }
    public int getTreasures() {
        return treasures;
    }

    public int getLevel() {
        return level;
    }

    public void setTreasures(int treasures) {
        this.treasures = treasures;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String toString() {
        return "Treasures = " + Integer.toString(treasures) + " levels = " + Integer.toString(level);
    }

}
