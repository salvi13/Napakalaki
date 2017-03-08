#encoding: utf-8

require_relative "card"
class Monster < Card
  
  attr_accessor :name, :combat_level, :prize, :bc, :level_change_against_cultist_player
  
  def initialize(name,combat_level, prize, bc,lcacp)
    @name = name
    @combat_level = combat_level
    @prize = prize
    @bc = bc
    @level_change_against_cultist_player = lcacp
  end
  
  def get_levels_gained
    return @prize.level
  end
  
  def get_treasures_gained
    return @prize.treasures
  end
  
  def kill
    return @bc.my_bad_consequence_is_death
  end
  
  def get_basic_value
    return @combat_level
  end
  
  def get_special_value
    return @combat_level + @level_change_against_cultist_player
  end
  public
  def to_s
    "Monstruo: #{@name}, Mal rollo: #{@bc}"
    
  end
end
