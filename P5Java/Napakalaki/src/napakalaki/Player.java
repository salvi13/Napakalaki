/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;

public class Player {

    private boolean dead = true;
    private boolean canEquip;
    private String name;
    private int level;
    private BadConsequence pendingBadConsequence = null;
    private ArrayList<Treasure> visibleTreasures = new ArrayList<>();
    private ArrayList<Treasure> hiddenTreasures = new ArrayList<>();
    private CombatResult result;

    public Player(String name) {
        this.name = name;
        this.level = 1;
    }
    
    public Player(Player p){
        this.name = p.name;
        this.level = p.level;
        this.visibleTreasures = (ArrayList) p.getVisibleTreasures().clone();
        this.hiddenTreasures = (ArrayList) p.getHiddenTreasures().clone();
        this.pendingBadConsequence = p.getPendingBadConsequence();
    }

    protected int getOponentLevel(Monster m){
        return m.getBasicValue();
    }
    protected boolean shouldConvert(){
     Dice dice = Dice.getInstance();
     int isSix = dice.nextNumber();
     //TODO guay no?
     return(isSix == 6);
    }
    
    
    
    private void bringToLife() {
        setDead(false);
    }

    protected int getCombatLevel() {
        int level_total = getLevel();
        boolean has_necklace = getNecklace();

        for (Treasure treasure : getVisibleTreasures()) {
            if (has_necklace) {
                level_total += treasure.getMaxBonus();
            } else {
                level_total += treasure.getMinBonus();
            }
        }
        return level_total;
    }

    private boolean getNecklace() {
        boolean has_necklace = false;
        for (Treasure treasure : getVisibleTreasures()) {
            if (treasure.getType().equals(TreasureKind.necklace)) {
                has_necklace = true;
            }
        }
        return has_necklace;
    }

    private void incrementLevel(int i) {
        if (getLevel() + i < 10) {
            setLevel(getLevel() + i);
        } else {
            setLevel(10);
        }
    }

    private void decrementLevel(int i) {
        if (getLevel() - i > 1) {
            setLevel(getLevel() - i);
        } else {
            setLevel(1);
        }
    }

    private void setPendingBadConsequence(BadConsequence b) {
        this.pendingBadConsequence = b;
    }

    private void dieIfNoTreasures() {
        if (getVisibleTreasures().isEmpty() && getHiddenTreasures().isEmpty()) {
            setDead(true);
        }
    }

    private void discardNecklaceIfVisible() {
        CardDealer dealer = CardDealer.getInstance();
        for (Treasure treasure : getVisibleTreasures()) {
            if (treasure.getType() == TreasureKind.necklace) {
                dealer.giveTreasureBack(treasure);
                visibleTreasures.remove(treasure);
                break;
            }
        }
    }

    private void die() {
        setLevel(1);
        CardDealer dealer = CardDealer.getInstance();
        for (Treasure treasure : visibleTreasures) {
            dealer.giveTreasureBack(treasure);
        }
        visibleTreasures.clear();
        for (Treasure treasure : hiddenTreasures) {
            dealer.giveTreasureBack(treasure);
        }
        hiddenTreasures.clear();
        dieIfNoTreasures();
    }

    protected float computeGoldCoinsValue(ArrayList<Treasure> t) {
        float total = 0;
        for (Treasure treasure : t) {
            total += treasure.getGoldCoins();
        }
        total = total / 1000;
        return total;
    }

    private boolean canIBuyLevels(int i) {
        return (getLevel() + i < 10);
    }

    private void applyPrize(Monster currentMonster) {
        CardDealer dealer = CardDealer.getInstance();
        int nLevels = currentMonster.getLevelsGained();
        incrementLevel(nLevels);
        int nTreasures = currentMonster.getTreasuresGained();
        if (nTreasures > 0) {
            for (int i = 0; i < nTreasures; i++) {
                Treasure treasure = dealer.nextTreasure();
                hiddenTreasures.add(treasure);
            }
        }
    }

    private void applyBadConsequence(BadConsequence bad) {
        int nLevels = bad.getLevels();
        decrementLevel(nLevels);
        BadConsequence pendingBad = bad;
        pendingBad = bad.adjustToFitTreasureLists(visibleTreasures, hiddenTreasures);
        if ((getVisibleTreasures().isEmpty()) && (pendingBad.getnVisibleTreasures() != 0)){
            pendingBad.setnVisibleTreasures(0);
        }else{
            if (bad.getnVisibleTreasures() > getVisibleTreasures().size()){
                pendingBad.setnVisibleTreasures(getVisibleTreasures().size());
            }else{
                pendingBad.setnVisibleTreasures(bad.getnVisibleTreasures());
            }
        }
        if ((getHiddenTreasures().isEmpty()) && (pendingBad.getnHiddenTreasures() != 0)){
            pendingBad.setnHiddenTreasures(0);
        }else{
            if (bad.getnHiddenTreasures() > getHiddenTreasures().size()){
                pendingBad.setnHiddenTreasures(getHiddenTreasures().size());
            }else{
                pendingBad.setnHiddenTreasures(bad.getnHiddenTreasures());
            }
        }
        setPendingBadConsequence(pendingBad);
    }

    private boolean canMakeTreasureVisible(Treasure t) {
        int count = 0;
        boolean bothHand = false;
        if (getVisibleTreasures().size() >= 4) {
            return false;
        }
        for (Treasure treasure : getVisibleTreasures()) {
            if ((treasure.getType() == TreasureKind.oneHand)) {
                count++;
            } else if (treasure.getType() == t.getType()) {
                return false;
            }else if (treasure.getType() == TreasureKind.bothHand){
                bothHand = true;
            }
        }
        if (((count >= 2) && (t.getType() == TreasureKind.oneHand)) || ((t.getType() == TreasureKind.bothHand) && (count != 0)) ){
            return false;
        }
        if ((t.getType() == TreasureKind.oneHand) && bothHand){
            return false;
        }
        
        return true;
    }

    private int howManyVisibleTreasures(TreasureKind tKind) {
        int contador = 0;
        for (Treasure treasure : getVisibleTreasures()) {
            if (treasure.getType().equals(tKind)) {
                contador++;
            }
        }
        return contador;
    }

    public ArrayList<Treasure> getHiddenTreasures() {
        return hiddenTreasures;
    }

    public ArrayList<Treasure> getVisibleTreasures() {
        return visibleTreasures;
    }

    public CombatResult combat(Monster m) {
        CombatResult combatResult;
        int myLevel = getCombatLevel();
        int monsterLevel = getOponentLevel(m);
        
        if (myLevel > monsterLevel) {
            applyPrize(m);
            if (getLevel() >= 10) {
                combatResult = CombatResult.WinAndWinGame;
            } else {
                combatResult = CombatResult.Win;
            }
        } else {
            Dice dice = Dice.getInstance();
            int escape = dice.nextNumber();
            if (escape < 5) {
                boolean amIDead = m.kills();
                if (amIDead) {
                    die();
                    combatResult = CombatResult.LoseAndDie;
                    
                }else if(shouldConvert()){
                        combatResult = CombatResult.LoseAndConvert;
                        
                }else {
                    BadConsequence bad = m.getBc();
                    applyBadConsequence(bad);              
                    combatResult = CombatResult.Lose;
                    
                    
                }
            } else {
                combatResult = CombatResult.LoseAndEscape;
            }
        }
        discardNecklaceIfVisible();
        return combatResult;
    }

    public void makeTreasureVisible(Treasure t) {
        boolean canI;
        canI = canMakeTreasureVisible(t);
        if (canI) {
            visibleTreasures.add(t);
            hiddenTreasures.remove(t);
        }
    }

    public void discardVisibleTreasure(Treasure t) {
        getVisibleTreasures().remove(t);
        if ((pendingBadConsequence != null) && (!pendingBadConsequence.isEmpty())) {
            pendingBadConsequence.substractVisibleTreasure(t);
        }
        dieIfNoTreasures();
    }

    public void discardHiddenTreasure(Treasure t) {
        getHiddenTreasures().remove(t);
        if ((pendingBadConsequence != null) && (!pendingBadConsequence.isEmpty())) {
            pendingBadConsequence.substractHiddenTreasure(t);
        }
        dieIfNoTreasures();
    }

    public boolean buyLevels(ArrayList<Treasure> visible, ArrayList<Treasure> hidden) {
        float levelsMayBought = computeGoldCoinsValue(visible);
        levelsMayBought += computeGoldCoinsValue(hidden);
        boolean canI;
        // CONVERTIR LEVELS MAY BOUGHT EN INT
        int levels =(int)levelsMayBought;
        canI = canIBuyLevels(levels);
        if (canI) {
            incrementLevel(levels);
        }

        visibleTreasures.removeAll(visible);
        hiddenTreasures.removeAll(hidden);
        CardDealer dealer = CardDealer.getInstance();
        for (Treasure treasure : visible) {
            dealer.giveTreasureBack(treasure);
        }
        for (Treasure treasure : hidden) {
            dealer.giveTreasureBack(treasure);
        }
        return canI;
    }

    public boolean validState() {
        return ((pendingBadConsequence == null || pendingBadConsequence.isEmpty()) && (getHiddenTreasures().size() <= 4));
    }

    public void initTreasures() {
        setCanEquip(true);
        bringToLife();
        CardDealer dealer = CardDealer.getInstance();
        Treasure treasure = dealer.nextTreasure();
        hiddenTreasures = new ArrayList<>();
        hiddenTreasures.add(treasure);
        Dice dice = Dice.getInstance();
        int number = dice.nextNumber();
        if (number > 1){
            treasure = dealer.nextTreasure();
            hiddenTreasures.add(treasure);
        }
        if (number == 6){
            treasure = dealer.nextTreasure();
            hiddenTreasures.add(treasure);
        }
    }

    public boolean hasVisibleTreasures() {
        return (!getVisibleTreasures().isEmpty());
    }

    public int getLevels() {
        return getLevel();
    }

    public CombatResult getResult() {
        return result;
    }

    public void setResult(CombatResult result) {
        this.result = result;
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public BadConsequence getPendingBadConsequence() {
        return pendingBadConsequence;
    }

    public boolean isCanEquip() {
        return canEquip;
    }
    
    public void setCanEquip(boolean canEquip) {
        this.canEquip = canEquip;
    }

    public String toString() {
        return name + " " + level;
    }

}
