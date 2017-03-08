# encoding: UTF-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
# encoding: UTF-8
class Treasure
  attr_accessor :name,:gold_coins,:min_bonus,:max_bonus,:type
  def initialize(name,gold_coin, min, max, type)
    @name = name
    @min_bonus = min
    @max_bonus = max
    @type = type
    @gold_coins = gold_coin
  end
  
    
  def to_s
    "#{@name}, Oros #{@gold_coins}, tipo: #{@type} "
    
  end
  
end
