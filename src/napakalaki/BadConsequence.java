package napakalaki;

import java.util.ArrayList;

public class BadConsequence {
    private String text;
    private int levels = 0;
    private int nVisibleTreasures = 0;
    private int nHiddenTreasures = 0;
    private boolean death;
    private ArrayList<TreasureKind> specificHiddenTreasures = new ArrayList();
    private ArrayList<TreasureKind> specificVisibleTreasures = new ArrayList();


    public BadConsequence(String text, int levels, int nVisibleTreasures, int nHiddenTreasures) {
        this.text = text;
        this.levels = levels;
        this.nVisibleTreasures = nVisibleTreasures;
        this.nHiddenTreasures = nHiddenTreasures;
    }

    public BadConsequence(String text, boolean death) {
        this.text = text;
        this.death = death;
    }

    public BadConsequence(String text, int levels, ArrayList<TreasureKind> tVisible,
    ArrayList<TreasureKind> tHidden){
        this.text = text;
        this.levels = levels;
        this.specificHiddenTreasures = tHidden;
        this.specificVisibleTreasures = tVisible;
    }

    public boolean isEmpty(){
        return ((getLevels()==0) && (getnHiddenTreasures() == 0) && (getnVisibleTreasures() == 0)
                && getSpecificHiddenTreasures().isEmpty() && getSpecificVisibleTreasures().isEmpty()
                && !isDeath());
    }
    
    public String getText() {
        return text;
    }

    public int getLevels() {
        return levels;
    }

    public int getnVisibleTreasures() {
        return nVisibleTreasures;
    }

    public int getnHiddenTreasures() {
        return nHiddenTreasures;
    }

    public boolean isDeath() {
        return death;
    }

    public ArrayList<TreasureKind> getSpecificVisibleTreasures() {
        return specificVisibleTreasures;
    }

    public ArrayList<TreasureKind> getSpecificHiddenTreasures() {
        return specificHiddenTreasures;
    }
    
    public void substractVisibleTreasure(Treasure t){
        if (getnVisibleTreasures() > 0){
            setnVisibleTreasures(getnVisibleTreasures()-1);
        }else{
            getSpecificVisibleTreasures().remove(t.getType());
        }
    }
    
    public void substractHiddenTreasure(Treasure t){
        if (getnHiddenTreasures() > 0){
            setnHiddenTreasures(getnHiddenTreasures()-1);
        }else{
            getSpecificHiddenTreasures().remove(t.getType());
        }
    }
    
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h){
        ArrayList<TreasureKind> tVisible = new ArrayList<>();
        ArrayList<TreasureKind> tHidden = new ArrayList<>();
        
        for (Treasure treasure : v){
            if (getSpecificVisibleTreasures().contains(treasure.getType()) && !tVisible.contains(treasure.getType())){
                tVisible.add(treasure.getType());
            }
        }
        
        for (Treasure treasure : h){
            if (getSpecificHiddenTreasures().contains(treasure.getType()) && !tHidden.contains(treasure.getType())){
                tHidden.add(treasure.getType());
            }
        }
        
        BadConsequence bc = new BadConsequence(getText(), 0, tVisible, tHidden);
        return bc;
    }

    public boolean myBadConsequenceisDeath(){
        return isDeath();
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setLevels(int levels) {
        this.levels = levels;
    }

    public void setnVisibleTreasures(int nVisibleTreasures) {
        this.nVisibleTreasures = nVisibleTreasures;
    }

    public void setnHiddenTreasures(int nHiddenTreasures) {
        this.nHiddenTreasures = nHiddenTreasures;
    }

    public void setDeath(boolean death) {
        this.death = death;
    }

    public void setSpecificHiddenTreasures(ArrayList<TreasureKind> specificHiddenTreasures) {
        this.specificHiddenTreasures = specificHiddenTreasures;
    }

    public void setSpecificVisibleTreasures(ArrayList<TreasureKind> specificVisibleTreasures) {
        this.specificVisibleTreasures = specificVisibleTreasures;
    }
    
    
    
    public String toString() {
        return "text=" + text + ", levels=" + levels + ", nVisibleTreasures=" + nVisibleTreasures + ", nHiddenTreasures=" + nHiddenTreasures + ", death=" + death + ", specificHiddenTreasures=" + specificHiddenTreasures + ", specificVisibleTreasures=" + specificVisibleTreasures;
    }
    
    
    
}
