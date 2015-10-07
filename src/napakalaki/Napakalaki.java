/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package napakalaki;

import java.util.ArrayList;
import java.util.Random;

public class Napakalaki {
    private Player currentPlayer;
    private ArrayList<Player> players;
    private CardDealer dealer = CardDealer.getInstance();
    private Monster currentMonster;
    private CombatResult result;
            
    private Napakalaki() {
    }
    
    public static Napakalaki getInstance() {
        return NapakalakiHolder.INSTANCE;
    }
    
    private static class NapakalakiHolder {

        private static final Napakalaki INSTANCE = new Napakalaki();
    }
    
    private void initPlayers(ArrayList<String> names){
        players = new ArrayList<>();
        for (String name : names) {
            players.add(new Player(name));
        }
    }
    
    private Player nextPlayer(){ 
        if (currentPlayer == null){
            Random rnd = new Random();
            currentPlayer = players.get(rnd.nextInt(players.size()));
        }else{
            if (currentPlayer == players.get(players.size()-1)){
                currentPlayer = players.get(0);
            }else{
                currentPlayer = players.get(players.indexOf(currentPlayer)+1);
            }
        }
        return currentPlayer;
    }
    
    private boolean nextTurnAllowed(){
        return currentPlayer == null || currentPlayer.validState();
    }
    
    public CombatResult developCombat(){
        CombatResult combat;
        combat = currentPlayer.combat(currentMonster);
        dealer.giveMonsterBack(currentMonster);
        return combat;
    }
    
    public void discardVisibleTreasures(ArrayList<Treasure> treasures){
        for (Treasure treasure : treasures){
            currentPlayer.discardVisibleTreasure(treasure);
            dealer.giveTreasureBack(treasure);
        }
    }
    
    public void discardHiddenTreasures(ArrayList<Treasure> treasures){
        for (Treasure treasure : treasures){
            currentPlayer.discardHiddenTreasure(treasure);
            dealer.giveTreasureBack(treasure);
        }
    }
    
    public void makeTreasuresVisibles(ArrayList<Treasure> treasures){
        for (Treasure t: treasures){
            currentPlayer.makeTreasureVisible(t);
        }
    }
    
    public boolean buyLevels(ArrayList<Treasure> visible, ArrayList<Treasure> hidden){
        boolean canI;
        canI = currentPlayer.buyLevels(visible, hidden);
        return canI;
    }
    
    public void initGame(ArrayList<String> players){
        initPlayers(players);
        dealer.initCards();
        nextTurn();
    }
    
    public Player getCurrentPlayer(){
        return currentPlayer;
    }
    
    public Monster getCurrentMonster(){
        return currentMonster;
    }
    
    public boolean nextTurn(){
        boolean stateOK;
        stateOK = nextTurnAllowed();
        if (stateOK) {
            currentMonster = dealer.nextMonsters();
            currentPlayer = nextPlayer();
            boolean dead = currentPlayer.isDead();
            if (dead){
                currentPlayer.initTreasures();
            }
        }
        return stateOK;
    }
    
    public boolean endOfGame(CombatResult result){
        return (result == CombatResult.WinAndWinGame);
    }
}
