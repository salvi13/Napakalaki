# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

require_relative "card"
class Cultist < Card
  
  attr_accessor :name,:gained_levels
  
  def initialize(name,gainedl)
    @name = name
    @gained_levels = gainedl
  end
  
  def get_basic_value
    return @gained_levels
  end
  
  #TODO no estoy yo muy seguro de esto
  #Solucionado
  def get_special_value
    return get_basic_value * CultistPlayer.total_cultist_players
  end
end
