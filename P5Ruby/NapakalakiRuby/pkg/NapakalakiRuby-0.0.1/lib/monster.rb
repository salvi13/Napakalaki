#encoding: utf-8

class Monster
  
  attr_accessor :name, :combat_level, :prize, :bc
  
  def initialize(name,combat_level, prize, bc)
    @name = name
    @combat_level = combat_level
    @prize = prize
    @bc = bc
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
  
  public
  def to_s
    "Monstruo: #{@name}, Mal rollo: #{@bc}"
    
  end
end
