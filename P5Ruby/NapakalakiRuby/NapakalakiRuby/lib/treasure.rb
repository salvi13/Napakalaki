# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

class Treasure
  attr_accessor :name,:gold_coins,:min_bonus,:max_bonus,:type
  def initialize(name, min, max, treasure, type)
    @name = name
    @min_bonus = min
    @max_bonus = max
    @treasure = treasure
    @type = type
  end
end
