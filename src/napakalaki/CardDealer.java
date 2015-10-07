/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package napakalaki;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CardDealer {
    private ArrayList<Treasure> unusedTreasures;
    private ArrayList<Treasure> usedTreasures;
    private ArrayList<Monster> unusedMonsters;
    private ArrayList<Monster> usedMonsters;
    
    private CardDealer() {
    }
    
    public static CardDealer getInstance() {
        return CardDealerHolder.INSTANCE;
    }
    
    private static class CardDealerHolder {

        private static final CardDealer INSTANCE = new CardDealer();
    }
    
    private void initTreasureCardDeck() {
        unusedTreasures = new ArrayList<>();
        usedTreasures = new ArrayList<>();
        unusedTreasures.add(new Treasure("¡Si mi amo!", 0, 4, 7, TreasureKind.helmet));
        unusedTreasures.add(new Treasure("Botas de investigación", 600, 3, 4, TreasureKind.shoe));
        unusedTreasures.add(new Treasure("Capucha de Cthulhu", 500, 3, 5, TreasureKind.helmet));
        unusedTreasures.add(new Treasure("A prueba de babas", 400, 2, 5, TreasureKind.armor));
        unusedTreasures.add(new Treasure("Botas de lluvia ácida", 800, 1, 1, TreasureKind.bothHand));
        unusedTreasures.add(new Treasure("Casco minero", 400, 2, 4, TreasureKind.helmet));
        unusedTreasures.add(new Treasure("Ametralladora Thompson", 600, 4, 8, TreasureKind.bothHand));
        unusedTreasures.add(new Treasure("Camiseta de la UGR", 100, 1, 7, TreasureKind.armor));
        unusedTreasures.add(new Treasure("Clavo de rail ferroviario", 400, 3, 6, TreasureKind.oneHand));
        unusedTreasures.add(new Treasure("Cuchillo de sushi arcano", 300, 2, 3, TreasureKind.oneHand));
        unusedTreasures.add(new Treasure("Fez alópodo", 700, 3, 5, TreasureKind.helmet));
        unusedTreasures.add(new Treasure("Hacha prehistórica", 500, 2, 5, TreasureKind.oneHand));
        unusedTreasures.add(new Treasure("El aparato del Pr. Tesla", 900, 4, 8, TreasureKind.armor));
        unusedTreasures.add(new Treasure("Gaita", 500, 4, 5, TreasureKind.bothHand));
        unusedTreasures.add(new Treasure("Insecticida", 300, 2, 3, TreasureKind.oneHand));
        unusedTreasures.add(new Treasure("Escopeta de 3 cañones", 700, 4, 6, TreasureKind.bothHand));
        unusedTreasures.add(new Treasure("Garabato Mistico", 300, 2, 2, TreasureKind.oneHand));
        unusedTreasures.add(new Treasure("La fuerza de Mr. T", 1000, 0, 0, TreasureKind.necklace));
        unusedTreasures.add(new Treasure("La rebeca metálica", 400, 2, 3, TreasureKind.armor));
        unusedTreasures.add(new Treasure("Mazo de los antiguos", 200, 3, 4, TreasureKind.oneHand));
        unusedTreasures.add(new Treasure("Necro-playboycon", 300, 3, 5, TreasureKind.oneHand));
        unusedTreasures.add(new Treasure("Lanzallamas", 800, 4, 8, TreasureKind.bothHand));
        unusedTreasures.add(new Treasure("Necro-comicón", 100, 1, 1, TreasureKind.oneHand));
        unusedTreasures.add(new Treasure("Necronomicón", 800, 5, 7, TreasureKind.bothHand));
        unusedTreasures.add(new Treasure("Linterna a 2 manos", 400, 3, 6, TreasureKind.bothHand));
        unusedTreasures.add(new Treasure("Necro-gnomicón", 200, 2, 4, TreasureKind.oneHand));
        unusedTreasures.add(new Treasure("Necrotelecom", 300, 2, 3, TreasureKind.helmet));
        unusedTreasures.add(new Treasure("Porra preternatural", 200, 2, 3, TreasureKind.oneHand));
        unusedTreasures.add(new Treasure("Tentácula de pega", 200, 0, 1, TreasureKind.helmet));
        unusedTreasures.add(new Treasure("Zapato deja-amigos", 500, 0, 1, TreasureKind.shoe));
        unusedTreasures.add(new Treasure("Shogulador", 600, 1, 1, TreasureKind.bothHand));
        unusedTreasures.add(new Treasure("Varita de atizamiento", 400, 3, 4, TreasureKind.oneHand));
        shuffleTreasures();
    }
    
    private void initMonsterCardDeck(){
        unusedMonsters = new ArrayList<>();
        usedMonsters = new ArrayList<>();

        BadConsequence bc = new BadConsequence("Pierdes tu armadura visible y otra oculta", 0, new ArrayList(Arrays.asList(TreasureKind.armor)), new ArrayList(Arrays.asList(TreasureKind.armor)));
        Prize price = new Prize(2, 1);
        Monster monster = new Monster("3 Byakhees de bonanza", 8, bc, price);
        unusedMonsters.add(monster);
       
        bc = new BadConsequence("Embobados con el lindo primigenio te descartas de tu casco visible", 0, new ArrayList(Arrays.asList(TreasureKind.helmet)), new ArrayList());
        price = new Prize(1, 1);
        monster = new Monster("Chibithulhu", 2, bc, price);
        unusedMonsters.add(monster);
        
        bc = new BadConsequence("El primordial bostezo contagioso. Pierdes el calzado visible", 0, new ArrayList(Arrays.asList(TreasureKind.shoe)), new ArrayList());
        price = new Prize(1, 1);
        monster = new Monster("El sopor de Dunwich", 2, bc, price);
        unusedMonsters.add(monster);
        
        bc = new BadConsequence("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. Descarta 1 mano visible y 1 mano oculta",
                0, new ArrayList(Arrays.asList(TreasureKind.oneHand)), new ArrayList(Arrays.asList(TreasureKind.oneHand)));
        price = new Prize(4, 1);
        monster = new Monster("Angeles de la noche ibicenca", 14, bc, price);
        unusedMonsters.add(monster);
        
        bc = new BadConsequence("Pierdes todos tus tesoros visibles", 0, 6, 0);
        price = new Prize(3, 1);
        monster = new Monster("El gorron en el umbral", 10, bc, price);
        unusedMonsters.add(monster);
        
        bc = new BadConsequence("Pierdes la armadura visible", 0, new ArrayList(Arrays.asList(TreasureKind.armor)), new ArrayList());
        price = new Prize(2, 1);
        monster = new Monster("H.P. Munchcraft", 6, bc, price);
        unusedMonsters.add(monster);
        
        bc = new BadConsequence("Sientes bichos bajo la ropa. Descarta la armadura visible", 0, new ArrayList(Arrays.asList(TreasureKind.armor)), new ArrayList());
        price = new Prize(1, 1);
        monster = new Monster("Bichgooth", 2, bc, price);
        unusedMonsters.add(monster);
        
        bc = new BadConsequence("Pierdes 5 niveles y 3 tesoros visibles.", 5, 3, 0);
        price = new Prize(4, 2);
        monster = new Monster("El rey de rosa", 13, bc, price);
        unusedMonsters.add(monster);
        
        bc = new BadConsequence("Toses los pulmones y pierdes 2 niveles.", 2, 0, 0);
        price = new Prize(1, 1);
        monster = new Monster("La que redacta en las tinieblas", 2, bc, price);
        unusedMonsters.add(monster);
        
        bc = new BadConsequence("Estos monstruos resultan bastante superficiales y te aburren mortalmente. Estas muerto", true);
        price = new Prize(2, 1);
        monster = new Monster("Los hondos", 8, bc, price);
        unusedMonsters.add(monster);
        
        bc = new BadConsequence("Pierdes 2 niveles y 2 tesoros ocultos.", 2, 0, 2);
        price = new Prize(2, 1);
        monster = new Monster("Semillas Cthulhu", 4, bc, price);
        unusedMonsters.add(monster);
        
        bc = new BadConsequence("Te intentas escaquear. Pierdes una mano visible.", 0, new ArrayList(Arrays.asList(TreasureKind.oneHand)), new ArrayList());
        price = new Prize(2, 1);
        monster = new Monster("Dameargo", 1, bc, price);
        unusedMonsters.add(monster);
        
        bc = new BadConsequence("Da mucho asquito. Pierdes 3 niveles.", 3, 0, 0);
        price = new Prize(1, 1);
        monster = new Monster("Pollipolipo volante", 4, bc, price);
        unusedMonsters.add(monster);
        
        bc = new BadConsequence("No le hace gracia que pronuncien mal su nombre. Estas muerto", true);
        price = new Prize(3, 1);
        monster = new Monster("Yskhtihyssg-Goth", 12, bc, price);
        unusedMonsters.add(monster);
        
        bc = new BadConsequence("La familia te atrapa. Estas muerto.", true);
        price = new Prize(4, 1);
        monster = new Monster("Familia feliz", 1, bc, price);
        unusedMonsters.add(monster);
        
        bc = new BadConsequence("La quinta directiva primaria te obliga a perder 2 niveles y un tesoro 2 manos visible.", 2,
                new ArrayList(Arrays.asList(TreasureKind.bothHand)) , new ArrayList());
        price = new Prize(2, 1);
        monster = new Monster("Roboggoth", 8, bc, price);
        unusedMonsters.add(monster);
        
        bc = new BadConsequence("Te asusta en la noche. Pierdes un casco visible.", 0, new ArrayList(Arrays.asList(TreasureKind.helmet)),new ArrayList());
        price = new Prize(1, 1);
        monster = new Monster("El espia", 5, bc, price);
        unusedMonsters.add(monster);
        
        bc = new BadConsequence("Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles.", 2, 5, 0);
        price = new Prize(1, 1);
        monster = new Monster("El lenguas", 20, bc, price);
        unusedMonsters.add(monster);
        
        bc = new BadConsequence("Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos.", 3, new ArrayList(Arrays.asList(TreasureKind.bothHand)),new ArrayList());
        price = new Prize(1, 1);
        monster = new Monster("Bicefalo", 20, bc, price);
        unusedMonsters.add(monster);
        shuffleMonsters();
    }        

    
    private void shuffleTreasures(){
        Collections.shuffle(unusedTreasures);
    }
    
    private void shuffleMonsters(){
        Collections.shuffle(unusedMonsters);
    }
    
    public Treasure nextTreasure(){
        Treasure treasure;
        if (unusedTreasures.isEmpty()){
            unusedTreasures = usedTreasures;
            usedTreasures.clear();
            treasure = unusedTreasures.get(0);
            unusedTreasures.remove(treasure);
        }else{
            treasure = unusedTreasures.get(0);
            unusedTreasures.remove(treasure);
        }
        return treasure;
    }
    
    public Monster nextMonsters(){
        Monster monster;
        if (unusedMonsters.isEmpty()){
            unusedMonsters = usedMonsters;
            usedMonsters.clear();
            monster = unusedMonsters.get(0);
            unusedMonsters.remove(monster);
        }else{
            monster = unusedMonsters.get(0);
            unusedMonsters.remove(monster);
        }
        return monster;
    }
    
    public void giveTreasureBack(Treasure t){
        usedTreasures.add(t);
    }
    
    public void giveMonsterBack(Monster m){
        usedMonsters.add(m);
    }
    
    public void initCards(){
        initTreasureCardDeck();
        initMonsterCardDeck();
    }
    
}
