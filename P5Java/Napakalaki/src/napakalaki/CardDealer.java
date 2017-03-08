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
    private ArrayList<Cultist> unusedCultists;
    
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
        unusedTreasures.add(new Treasure("¡Si mi amo!", 0, 4, 7, TreasureKind.helmet,"h1.png"));
        unusedTreasures.add(new Treasure("Botas de investigación", 600, 3, 4, TreasureKind.shoe,"b1.png"));
        unusedTreasures.add(new Treasure("Capucha de Cthulhu", 500, 3, 5, TreasureKind.helmet,"h2.png"));
        unusedTreasures.add(new Treasure("A prueba de babas", 400, 2, 5, TreasureKind.armor,"a1.png"));
        unusedTreasures.add(new Treasure("Botas de lluvia ácida", 800, 1, 1, TreasureKind.bothHand,"hh1.png"));
        unusedTreasures.add(new Treasure("Casco minero", 400, 2, 4, TreasureKind.helmet,"h6.png"));
        unusedTreasures.add(new Treasure("Ametralladora Thompson", 600, 4, 8, TreasureKind.bothHand,"hh2.png"));
        unusedTreasures.add(new Treasure("Camiseta de la UGR", 100, 1, 7, TreasureKind.armor,"a2.png"));
        unusedTreasures.add(new Treasure("Clavo de rail ferroviario", 400, 3, 6, TreasureKind.oneHand,"s1.png"));
        unusedTreasures.add(new Treasure("Cuchillo de sushi arcano", 300, 2, 3, TreasureKind.oneHand,"s2.png"));
        unusedTreasures.add(new Treasure("Fez alópodo", 700, 3, 5, TreasureKind.helmet,"h3.png"));
        unusedTreasures.add(new Treasure("Hacha prehistórica", 500, 2, 5, TreasureKind.oneHand,"s3.png"));
        unusedTreasures.add(new Treasure("El aparato del Pr. Tesla", 900, 4, 8, TreasureKind.armor,"a3.png"));
        unusedTreasures.add(new Treasure("Gaita", 500, 4, 5, TreasureKind.bothHand,"hh3.png"));
        unusedTreasures.add(new Treasure("Insecticida", 300, 2, 3, TreasureKind.oneHand,"s4.png"));
        unusedTreasures.add(new Treasure("Escopeta de 3 cañones", 700, 4, 6, TreasureKind.bothHand,"hh4.png"));
        unusedTreasures.add(new Treasure("Garabato Mistico", 300, 2, 2, TreasureKind.oneHand,"s5.png"));
        unusedTreasures.add(new Treasure("La fuerza de Mr. T", 1000, 0, 0, TreasureKind.necklace,"n1.png"));
        unusedTreasures.add(new Treasure("La rebeca metálica", 400, 2, 3, TreasureKind.armor,"a4.png"));
        unusedTreasures.add(new Treasure("Mazo de los antiguos", 200, 3, 4, TreasureKind.oneHand,"s6.png"));
        unusedTreasures.add(new Treasure("Necro-playboycon", 300, 3, 5, TreasureKind.oneHand,"s7.png"));
        unusedTreasures.add(new Treasure("Lanzallamas", 800, 4, 8, TreasureKind.bothHand,"hh5.png"));
        unusedTreasures.add(new Treasure("Necro-comicón", 100, 1, 1, TreasureKind.oneHand,"s8.png"));
        unusedTreasures.add(new Treasure("Necronomicón", 800, 5, 7, TreasureKind.bothHand,"hh6.png"));
        unusedTreasures.add(new Treasure("Linterna a 2 manos", 400, 3, 6, TreasureKind.bothHand,"hh7.png"));
        unusedTreasures.add(new Treasure("Necro-gnomicón", 200, 2, 4, TreasureKind.oneHand,"s9.png"));
        unusedTreasures.add(new Treasure("Necrotelecom", 300, 2, 3, TreasureKind.helmet,"h4.png"));
        unusedTreasures.add(new Treasure("Porra preternatural", 200, 2, 3, TreasureKind.oneHand,"s10.png"));
        unusedTreasures.add(new Treasure("Tentácula de pega", 200, 0, 1, TreasureKind.helmet,"h5.png"));
        unusedTreasures.add(new Treasure("Zapato deja-amigos", 500, 0, 1, TreasureKind.shoe,"b2.png"));
        unusedTreasures.add(new Treasure("Shogulador", 600, 1, 1, TreasureKind.bothHand,"hh8.png"));
        unusedTreasures.add(new Treasure("Varita de atizamiento", 400, 3, 4, TreasureKind.oneHand,"s11.png"));
        shuffleTreasures();
    }
    
    private void initMonsterCardDeck(){
        unusedMonsters = new ArrayList<>();
        usedMonsters = new ArrayList<>();

        BadConsequence bc = new BadConsequence("Pierdes tu armadura visible y otra oculta", 0, new ArrayList(Arrays.asList(TreasureKind.armor)), new ArrayList(Arrays.asList(TreasureKind.armor)));
        Prize price = new Prize(2, 1);
        Monster monster = new Monster("3 Byakhees de bonanza", 8, bc, price, "1.png");
        unusedMonsters.add(monster);
       
        bc = new BadConsequence("Embobados con el lindo primigenio te descartas de tu casco visible", 0, new ArrayList(Arrays.asList(TreasureKind.helmet)), new ArrayList());
        price = new Prize(1, 1);
        monster = new Monster("Chibithulhu", 2, bc, price, "2.png");
        unusedMonsters.add(monster);
        
        bc = new BadConsequence("El primordial bostezo contagioso. Pierdes el calzado visible", 0, new ArrayList(Arrays.asList(TreasureKind.shoe)), new ArrayList());
        price = new Prize(1, 1);
        monster = new Monster("El sopor de Dunwich", 2, bc, price, "3.png");
        unusedMonsters.add(monster);
        
        bc = new BadConsequence("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. Descarta 1 mano visible y 1 mano oculta",
                0, new ArrayList(Arrays.asList(TreasureKind.oneHand)), new ArrayList(Arrays.asList(TreasureKind.oneHand)));
        price = new Prize(4, 1);
        monster = new Monster("Angeles de la noche ibicenca", 14, bc, price, "4.png");
        unusedMonsters.add(monster);
        
        bc = new BadConsequence("Pierdes todos tus tesoros visibles", 0, 6, 0);
        price = new Prize(3, 1);
        monster = new Monster("El gorron en el umbral", 10, bc, price, "5.png");
        unusedMonsters.add(monster);
        
        bc = new BadConsequence("Pierdes la armadura visible", 0, new ArrayList(Arrays.asList(TreasureKind.armor)), new ArrayList());
        price = new Prize(2, 1);
        monster = new Monster("H.P. Munchcraft", 6, bc, price, "6.png");
        unusedMonsters.add(monster);
        
        bc = new BadConsequence("Sientes bichos bajo la ropa. Descarta la armadura visible", 0, new ArrayList(Arrays.asList(TreasureKind.armor)), new ArrayList());
        price = new Prize(1, 1);
        monster = new Monster("Bichgooth", 2, bc, price, "7.png");
        unusedMonsters.add(monster);
        
        bc = new BadConsequence("Pierdes 5 niveles y 3 tesoros visibles.", 5, 3, 0);
        price = new Prize(4, 2);
        monster = new Monster("El rey de rosa", 13, bc, price, "8.png");
        unusedMonsters.add(monster);
        
        bc = new BadConsequence("Toses los pulmones y pierdes 2 niveles.", 2, 0, 0);
        price = new Prize(1, 1);
        monster = new Monster("La que redacta en las tinieblas", 2, bc, price, "9.png");
        unusedMonsters.add(monster);
        
        bc = new BadConsequence("Estos monstruos resultan bastante superficiales y te aburren mortalmente. Estas muerto", true);
        price = new Prize(2, 1);
        monster = new Monster("Los hondos", 8, bc, price, "10.png");
        unusedMonsters.add(monster);
        
        bc = new BadConsequence("Pierdes 2 niveles y 2 tesoros ocultos.", 2, 0, 2);
        price = new Prize(2, 1);
        monster = new Monster("Semillas Cthulhu", 4, bc, price, "11.png");
        unusedMonsters.add(monster);
        
        bc = new BadConsequence("Te intentas escaquear. Pierdes una mano visible.", 0, new ArrayList(Arrays.asList(TreasureKind.oneHand)), new ArrayList());
        price = new Prize(2, 1);
        monster = new Monster("Dameargo", 1, bc, price, "12.png");
        unusedMonsters.add(monster);
        
        bc = new BadConsequence("Da mucho asquito. Pierdes 3 niveles.", 3, 0, 0);
        price = new Prize(1, 1);
        monster = new Monster("Pollipolipo volante", 4, bc, price, "13.png");
        unusedMonsters.add(monster);
        
        bc = new BadConsequence("No le hace gracia que pronuncien mal su nombre. Estas muerto", true);
        price = new Prize(3, 1);
        monster = new Monster("Yskhtihyssg-Goth", 12, bc, price, "14.png");
        unusedMonsters.add(monster);
        
        bc = new BadConsequence("La familia te atrapa. Estas muerto.", true);
        price = new Prize(4, 1);
        monster = new Monster("Familia feliz", 1, bc, price, "15.png");
        unusedMonsters.add(monster);
        
        bc = new BadConsequence("La quinta directiva primaria te obliga a perder 2 niveles y un tesoro 2 manos visible.", 2,
                new ArrayList(Arrays.asList(TreasureKind.bothHand)) , new ArrayList());
        price = new Prize(2, 1);
        monster = new Monster("Roboggoth", 8, bc, price, "16.png");
        unusedMonsters.add(monster);
        
        bc = new BadConsequence("Te asusta en la noche. Pierdes un casco visible.", 0, new ArrayList(Arrays.asList(TreasureKind.helmet)),new ArrayList());
        price = new Prize(1, 1);
        monster = new Monster("El espia", 5, bc, price, "17.png");
        unusedMonsters.add(monster);
        
        bc = new BadConsequence("Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles.", 2, 5, 0);
        price = new Prize(1, 1);
        monster = new Monster("El lenguas", 20, bc, price, "18.png");
        unusedMonsters.add(monster);
        
        bc = new BadConsequence("Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos.", 3, new ArrayList(Arrays.asList(TreasureKind.bothHand)),new ArrayList());
        price = new Prize(1, 1);
        monster = new Monster("Bicefalo", 20, bc, price, "19.png");
        unusedMonsters.add(monster);
        
        //con sectario
        bc = new BadConsequence("Pierdes una mano visible", 0, new ArrayList(Arrays.asList(TreasureKind.oneHand)), new ArrayList());
        price = new Prize(3,1);
        monster = new Monster("El mal indecible imponunciable",10,bc,price, "20.png",-2);
        unusedMonsters.add(monster);
        
        bc = new BadConsequence("Pierdes tus tesoros visibles. Jajaja.",0,6,0);
        price = new Prize(2,1);
        monster = new Monster("Testigos Oculares",6,bc,price, "21.png", +2);
        unusedMonsters.add(monster);
        
        bc = new BadConsequence("Hoy no es tu dia de suerte.Mueres",true);
        price = new Prize(2,5);
        monster = new Monster("El gran Cthulhu",20,bc,price, "22.png",+4);
        unusedMonsters.add(monster);
       
        bc = new BadConsequence("Tu gobierno te recorta 2 niveles",2,0,0);
        price = new Prize(2,1);
        monster = new Monster("Serpiente Politico",8,bc,price, "23.png",-2);
        unusedMonsters.add(monster);
          
        //TODO cuidado no esto, no hemos hecho ninguno que te quite 2 tipos diferentes en el mismo tipo(visible o invisible), asi que he hecho un array para meter las 2.
        //Comprobar que funciona correctamente, ya que no estoy muy seguro. 
        ArrayList<TreasureKind> perdidasvisibles = new ArrayList<>();
        perdidasvisibles.add(TreasureKind.helmet);
        perdidasvisibles.add(TreasureKind.armor);
        
        ArrayList<TreasureKind> perdidasocultas = new ArrayList<>();
        perdidasocultas.add(TreasureKind.bothHand);
        perdidasocultas.add(TreasureKind.oneHand);
        perdidasocultas.add(TreasureKind.oneHand);


        bc = new BadConsequence("Pierdes tu casco y tu armadura visible. Pierdes tus manos ocultas",0,perdidasvisibles,perdidasocultas);
        price = new Prize(1,1);
        monster = new Monster("Felpuggoth",2,bc,price, "24.png",+5);
        unusedMonsters.add(monster);
        //------------------------------------------------------Fin TODO//
        
        bc = new BadConsequence("Pierdes 2 niveles",2,0,0);
        price = new Prize(4,2);
        monster = new Monster("Shoggoth",16,bc,price, "25.png",-4);
        unusedMonsters.add(monster);
        
        bc = new BadConsequence("Pintalabios negro. Pierdes 2 niveles",2,0,0);
        price = new Prize(1,1);
        monster = new Monster("Lolitagooth",2,bc,price, "26.png",+3);
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
            unusedTreasures = (ArrayList) usedTreasures.clone();
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
            unusedMonsters = (ArrayList) usedMonsters.clone();
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
        initCultistCardDeck();
    }
    
    private void shuffleCultists(){
        Collections.shuffle(unusedCultists);
    }
    private void initCultistCardDeck(){
        
        unusedCultists = new ArrayList<>();


        unusedCultists.add(new Cultist("Sectario",1));
        unusedCultists.add(new Cultist("Sectario",2));
        unusedCultists.add(new Cultist("Sectario",1));
        unusedCultists.add(new Cultist("Sectario",2));
        unusedCultists.add(new Cultist("Sectario",1));
        unusedCultists.add(new Cultist("Sectario",1));
        
      
        
    }

    public Cultist nextCultist(){
       
        //TODO no estoy muy seguro de esto, pero en el UML no pone nada de usedCultist ni nada, asi que supongo que será asi.
        Cultist cult;
        
        if (unusedCultists.isEmpty()){
            initCultistCardDeck();  
            shuffleCultists();
        }
            
        cult = unusedCultists.get(0);
        unusedCultists.remove(cult);
        
        
        return cult;
        
    }
}
