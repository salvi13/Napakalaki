# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

require_relative "player"
require_relative "card_dealer"
require_relative "card"

class CultistPlayer < Player
  
 
  attr_accessor :my_cultist_card
  @@total_cultist_players = 0
  
  def initialize(player,cultist)
     
      copy_player(player)

      @my_cultist_card = cultist
      @@total_cultist_players += 1

  end
  
  def self.total_cultist_players
    return @@total_cultist_players
  end
  
  def get_oponent_level(monster)
    return monster.get_special_value
  end
  
  #TODO no esta bien? al probarlo me petardea, pero tiene que ser super no?
  #Te comento, lo he puesto al princio como super.get_combat_level, pero dice que nanai, he mirado en internet y al parecer
  #con super + metodo es como si lo hiciera el super, pero me da un error en la pila que si consume mucho etc.. Mira a ver si te rula a ti.
  #
  #Solucionado?
  def get_combat_level
    
    sup = super
      
    #sup += get_combat_level
    
    return sup + @my_cultist_card.get_special_value
  end
  
  def should_convert
    return false
  end
    
  def compute_gold_coins_value(treasure)
    # Te lo he cambiado
    return super * 2
  end
end
