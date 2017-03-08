# encoding: UTF-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

require "singleton"
require_relative "treasure"
require_relative "treasure_kind"
require_relative "prize"
require_relative "bad_consequence"
require_relative "dice"
require_relative "monster"
require_relative "player"
require_relative "cultist"
require_relative "cultist_player"

class CardDealer
  include Singleton
  
  attr_accessor :unused_treasures,:unused_monsters,:used_treasures,:used_monsters,:unused_cultist
  def initialize
    
  end
  
  def next_cultist
    if @unused_cultist.empty?
      init_cultist_card_deck
      shuffle_cultists
      
    end
    
    cultist = @unused_cultist.at(0)
    return cultist
  end
  
  private
  def init_treasure_card_deck
    @unused_treasures = Array.new
    @used_treasures = Array.new
    
    @unused_treasures << Treasure.new("¡Si mi amo!", 0, 4, 7,TreasureKind::HELMET)
    @unused_treasures << Treasure.new("Botas de investigacion", 600, 3, 4, TreasureKind::SHOE)
    @unused_treasures << Treasure.new("Capucha de Cthulhu", 500, 3, 5, TreasureKind::HELMET)
    @unused_treasures << Treasure.new("A prueba de babas", 400, 2, 5, TreasureKind::ARMOR)
    @unused_treasures << Treasure.new("Botas de lluvia ácida", 800, 1, 1, TreasureKind::BOTHHAND)
    @unused_treasures << Treasure.new("Casco minero", 400, 2, 4, TreasureKind::HELMET)
    @unused_treasures << Treasure.new("Ametralladora Thompson", 600, 4, 8, TreasureKind::BOTHHAND)
    @unused_treasures << Treasure.new("Camiseta de la UGR", 100, 1, 7, TreasureKind::ARMOR)
    @unused_treasures << Treasure.new("Clavo de rail ferroviario", 400, 3, 6, TreasureKind::ONEHAND)
    @unused_treasures << Treasure.new("Cuchillo de sushi arcano", 300, 2, 3, TreasureKind::ONEHAND)
    @unused_treasures << Treasure.new("Feliz alópodo", 700, 3, 5, TreasureKind::HELMET)
    @unused_treasures << Treasure.new("Hacha prehistórica", 500, 2, 5, TreasureKind::ONEHAND)
    @unused_treasures << Treasure.new("El aparato del Pr. Tesla", 900, 4, 8, TreasureKind::ARMOR)
    @unused_treasures << Treasure.new("Gaita", 500, 4, 5, TreasureKind::BOTHHAND)
    @unused_treasures << Treasure.new("Insecticida", 300, 2, 3, TreasureKind::ONEHAND)
    @unused_treasures << Treasure.new("Escopeta de 3 cañones", 700, 4, 6, TreasureKind::BOTHHAND)
    @unused_treasures << Treasure.new("Garabato místico", 300, 2, 2, TreasureKind::ONEHAND)
    @unused_treasures << Treasure.new("La fuerza de Mr.T", 1000, 0, 0, TreasureKind::NECKLACE)
    @unused_treasures << Treasure.new("La rebeca metálica", 400, 2, 3, TreasureKind::ARMOR)
    @unused_treasures << Treasure.new("Mazo de los antiguos", 200, 3, 4, TreasureKind::ONEHAND)
    @unused_treasures << Treasure.new("Necro-playboycón", 300, 3, 5, TreasureKind::ONEHAND)
    @unused_treasures << Treasure.new("Lanzallamas", 800, 4, 8, TreasureKind::BOTHHAND)
    @unused_treasures << Treasure.new("Necro-comicón", 100, 1, 1, TreasureKind::ONEHAND)
    @unused_treasures << Treasure.new("Necronomicón", 800, 5, 7, TreasureKind::BOTHHAND)
    @unused_treasures << Treasure.new("Linerna a 2 manos", 400, 3, 6, TreasureKind::BOTHHAND)
    @unused_treasures << Treasure.new("Necro-gnomicón", 200, 2, 4, TreasureKind::ONEHAND)
    @unused_treasures << Treasure.new("Necrotelecom", 300, 2, 3, TreasureKind::HELMET)
    @unused_treasures << Treasure.new("Porra preternatural", 200, 2, 3, TreasureKind::ONEHAND)
    @unused_treasures << Treasure.new("Tentáculo de pega", 200, 0, 1, TreasureKind::HELMET)
    @unused_treasures << Treasure.new("Zapato deja-amigos", 500, 0, 1, TreasureKind::SHOE)
    @unused_treasures << Treasure.new("Shogulador", 600, 1, 1, TreasureKind::BOTHHAND)
    @unused_treasures << Treasure.new("Varita de atizamiento", 400, 3, 4, TreasureKind::ONEHAND)
    shuffle_treasures
  end
  
  def init_monster_card_deck
    @unused_monsters = Array.new
    @used_monsters = Array.new
    

    
    price = Prize.new(1,1)
    bc = BadConsequence.new_level_specific_treasures('Embobados con el lindo primigenio te descartas de tu casco visible',
    0, [TreasureKind::HELMET], [])
    @unused_monsters << Monster.new('Chibithulhu',2, price,bc,0)

    price = Prize.new(2,1)
    bc = BadConsequence.new_level_specific_treasures('Pierdes tu armadura visible y otra oculta',
      0, [TreasureKind::ARMOR], [TreasureKind::ARMOR])
    @unused_monsters << Monster.new('3 Byakhees de bonanza',8, price,bc,0)

    price = Prize.new(1,1)
    bc = BadConsequence.new_level_specific_treasures('El primordial bostezo contagioso. Pierdes el calzado visible',
      0, [TreasureKind::SHOE], [])
    @unused_monsters << Monster.new('El sopor de Dunwich',2, price,bc,0)

    price = Prize.new(4,1)
    bc = BadConsequence.new_level_specific_treasures('Te atrapan para llevarte de fiesta y te dejan caer en mitad de vuelo. Descarta 1 mano visible y 1 mano oculta',
      0,[TreasureKind::ONEHAND],[TreasureKind::ONEHAND])
    @unused_monsters << Monster.new('Angeles de la noche ibicenca', 14, price,bc,0)

    price = Prize.new(3,1)
    bc = BadConsequence.new_level_number_of_treasures('Pierdes todos tus tesoros visibles',0 , 6, 0)
    @unused_monsters << Monster.new('El gorron en el umbral',10, price,bc,0)

    price = Prize.new(2,1)
    bc = BadConsequence.new_level_specific_treasures('Pierdes la armadura visible', 0, [TreasureKind::ARMOR], [])
    @unused_monsters << Monster.new('H.P. Munchcraft',6, price,bc,0)

    price = Prize.new(1,1)
    bc = BadConsequence.new_level_specific_treasures('Sientes bichos bajo la ropa. Descarta la armadura visible',
      0, [TreasureKind::ARMOR], [])
    @unused_monsters << Monster.new('Bichgooth',2, price,bc,0)

    price = Prize.new(4,2)
    bc = BadConsequence.new_level_number_of_treasures('Pierdes 5 niveles y 3 tesoros visibles',5 , 3, 0)
    @unused_monsters << Monster.new('El rey de rosa',13, price,bc,0)

    price = Prize.new(1,1)
    bc = BadConsequence.new_level_number_of_treasures('Toses los pulmones y pierdes 2 niveles.',2 , 0, 0)
    @unused_monsters << Monster.new('La que redacta en las tinieblas',2, price,bc,0)

    price = Prize.new(2,1)
    bc = BadConsequence.new_death('Estos monstruos resultan bastante superficiales y te aburren mortalmente. Estas muerto')
    @unused_monsters << Monster.new('Los hondos',8, price,bc,0)

    price = Prize.new(2,1)
    bc = BadConsequence.new_level_number_of_treasures('Pierdes 2 niveles y 2 tesoros ocultos.', 2,0,2)
    @unused_monsters << Monster.new('Semillas Cthulhu',4, price,bc,0)

    price = Prize.new(2,1)
    bc = BadConsequence.new_level_specific_treasures('Te intentas escaquear. Pierdes una mano visible.', 0, [TreasureKind::ONEHAND], [])
    @unused_monsters << Monster.new('Dameargo',1, price,bc,0)

    price = Prize.new(1,1)
    bc = BadConsequence.new_level_number_of_treasures('Da mucho asquito. Pierdes 3 niveles.',3, 0, 0)
    @unused_monsters << Monster.new('Pollipolipo volante',3, price,bc,0)

    price = Prize.new(3,1)
    bc = BadConsequence.new_death('No le hace gracia que pronuncien mal su nombre. Estas muerto')
    @unused_monsters << Monster.new('YskhtihyssgGoth',12, price,bc,0)

    price = Prize.new(4,1)
    bc = BadConsequence.new_death('La familia te atrapa. Estas muerto.')
    @unused_monsters << Monster.new('Familia feliz',1, price,bc,0)

    price = Prize.new(2,1)
    bc = BadConsequence.new_level_specific_treasures('La quinta directiva primaria  te obliga a perder 2 niveles y un tesoro 2 manos visible',
      2, [TreasureKind::BOTHHAND], [])
    @unused_monsters << Monster.new('Roboggoth',8, price,bc,0)

    price = Prize.new(1,1)
    bc = BadConsequence.new_level_specific_treasures('Te asusta en la noche. Pierdes un casco visible.', 0, [TreasureKind::HELMET], [])
    @unused_monsters << Monster.new('El espia',5, price,bc,0)

    price = Prize.new(1,1)
    bc = BadConsequence.new_level_number_of_treasures('Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles.',2 , 5, 0)
    @unused_monsters << Monster.new('El Lenguas',20, price,bc,0)

    price = Prize.new(1,1)
    bc = BadConsequence.new_level_specific_treasures('Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos.',
      3, [TreasureKind::BOTHHAND], [])
    @unused_monsters << Monster.new('Bicefalo',20, price,bc,0)
    
    price = Prize.new(3,1)
    bc = BadConsequence.new_level_specific_treasures('Pierdes 1 mano visible', 0, [TreasureKind::ONEHAND], [])
    @unused_monsters << Monster.new('El mal indecible impronunciable',10, price,bc,-2)
    
    price = Prize.new(2,1)
    bc = BadConsequence.new_level_number_of_treasures('Pierdes todos tus tesoros visibles. Jajaja',0 , 6, 0)
    @unused_monsters << Monster.new('Testigos Oculares',6, price,bc,+2)
    
    price = Prize.new(2,5)
    bc = BadConsequence.new_death('Hoy no es tu dia de suerte. Mueres')
    @unused_monsters << Monster.new('El gran cthulhu',20,price,bc,+4)
     
    price = Prize.new(2,1)
    bc = BadConsequence.new_level_number_of_treasures('Tu gobierno te recorta 2 niveles',2 , 0, 0)
    @unused_monsters << Monster.new('Serpiente Politico',8, price,bc,-2)
    
    
    #TODO revisar, esto no se si va.
    visible_t = Array.new
    hidden_t = Array.new
    visible_t << [TreasureKind::HELMET]
    visible_t << [TreasureKind::ARMOR]
    
    hidden_t << [TreasureKind::BOTHHAND]
    hidden_t << [TreasureKind::ONEHAND]
    hidden_t << [TreasureKind::ONEHAND]
   
    
    price = Prize.new(1,1)
    bc = BadConsequence.new_level_specific_treasures('Pierdes tu casco y tu armadura visible. Pierdes tus manos ocultas',0,visible_t,hidden_t)
    @unused_monsters << Monster.new('Felpuggoth',2, price,bc,+5)
  
    price = Prize.new(4,2)
    bc = BadConsequence.new_level_number_of_treasures('Pierdes 2 niveles',2 , 0, 0)
    @unused_monsters << Monster.new('Shoggoth',16, price,bc,-4)
    
    price = Prize.new(1,1)
    bc = BadConsequence.new_level_number_of_treasures('Pintalabios negro. Pierdes 2 niveles',2 , 0, 0)
    @unused_monsters << Monster.new('Lolitagooth',2, price,bc,+3)
     

    shuffle_monsters
  end
  def shuffle_treasures
    @unused_treasures = @unused_treasures.shuffle
  end
  def shuffle_monsters
    @unused_monsters = @unused_monsters.shuffle
  end
  
  def shuffle_cultists
     @unused_cultist = @unused_cultist.shuffle
  end
  
  public
  def next_treasure
    
    if @unused_treasures.empty?
      
      @used_treasures.each do |i|
        
        @unused_treasures << i
         
      end    
      
      
      @unused_treasures.shuffle
    end
    
    treasure = @unused_treasures.first
    
    @used_treasures << treasure
    @unused_treasures.delete(treasure)
    
    return treasure
    
  end
  def next_monster
    
    if @unused_monsters.empty?
      
      @used_monsters.each do |i|
        
        @unused_monsters << i
         
      end    
      
      
      @unused_monsters.shuffle
    end
    
    monster = @unused_monsters.first
    
    @used_monsters << monster
    @unused_monsters.delete(monster)
    
    return monster
  end
  def give_treasure_back(treasure)
    @used_treasures << treasure
  end
  def give_monster_back(monster)
    @used_monsters << monster
  end
  
  def init_cards
    
    init_treasure_card_deck
    init_monster_card_deck
    init_cultist_card_deck
    
  end
  
  def init_cultist_card_deck
    
      @unused_cultist = Array.new
      
      name = "Sectario"
      @unused_cultist << Cultist.new(name,1)
      @unused_cultist << Cultist.new(name,2)
      @unused_cultist << Cultist.new(name,1)
      @unused_cultist << Cultist.new(name,2)
      @unused_cultist << Cultist.new(name,1)
      @unused_cultist << Cultist.new(name,1)
    
    
  end
 
  

end
