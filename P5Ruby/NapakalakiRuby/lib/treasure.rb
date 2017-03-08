# encoding: UTF-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
# encoding: UTF-8
class Treasure < Card
  attr_accessor :name,:gold_coins,:min_bonus,:max_bonus,:type
  
  def initialize(name,gold_coin, min, max, type)
    @name = name
    @min_bonus = min
    @max_bonus = max
    @type = type
    @gold_coins = gold_coin
  end
  
  
  def get_basic_value
    return @min_bonus
  end
 
  def get_special_value
    return @max_bonus
  end
  
  
  
  def to_s
    "#{@name}, Oros #{@gold_coins}, tipo: #{@type} "
    
  end
  
end
