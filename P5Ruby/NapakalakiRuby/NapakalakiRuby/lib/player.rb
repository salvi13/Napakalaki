# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

class Player
    attr_accessor :name, :dead, :level, :visible_treasures, :hidden_treasures, :pending_bad_consequence, :dealer
  def initialize(name)
    @name = name
  end
  private
  def bring_to_life
    @dead = false
  end
  def get_combat_level
    level_total = @level   
    has_necklace = get_necklace
    
    @visible_treasures.each do |treasure|
      if has_necklace then
        level_total += treasure.max_bonus
      else
        level_total += treasure.min_bonus
      end    
    end
    
    return level_total
  end
  
  def get_necklace
    has_necklace = false
    @visible_treasures.each do |treasure|
      if treasure.type == NECKLACE then
        has_necklace = true
      end
    end
    return has_necklace
  end
  def increment_levels(l)
    if (@level + i < 10)
      @level += i
    else
      @level = 10
    end
  end
  def decrement_levels(l)
    if (@level - i > 1)
      @level -= i
    else
      @level = 1
    end
  end
  def set_pending_bad_consequence(bad)
    @pending_bad_consequence = bad
  end

  def die_if_no_treasures
    if(@visible_treasures.empty? && @hidden_treasures.empty? )
      @dead = true
    end
  end
  
  #preguntar salva
  def discard_necklace_if_visible
     
    @visible_treasures.each do |treasure|
      
      if treasure.type == NECKLACE
        
        #dealer = CardDealer.instance
        @dealer.give_treasure_back(treasure)
        @visible_treasures.delete(treasure)

      end
      
    end
       
  end
    
   
  def die
    
  end
  def compute_gold_coins_value(treasure)
    
    coins = 0
    
    treasure.each do |i|
      
    coins += i.gold_coins 
      
    end
    
    
    return ((coins / 1000).round)
    
    
  end
  def can_i_buy_levels(l)
    return @level + i < 10
  end
  def apply_prize(current_monster)
    
  end
  def apply_bad_consequence(bad)
    
  end
  def can_make_trasure_visible(treasure)
    
  if @visible_treasures.size < 4
      
    contador = 0;
    cont_onehand = 0
    
    @visible_treasures.each do |treasure_item|
      
      if treasure_item.type == treasure 
        contador += 1
        
        if treasure_item.type == ONEHAND 
          cont_onehand +=1
        end 
        
      end
    end
  end 
    
    return( contador == 0 || contador == 1 && cont_onehand == 1 )
   
  end
  def how_many_visible_treasures(t_kind)
    contador = 0
   @visible_treasures.each do |treasure|
      if treasure.type == t_kind then
        contador += 1
      end
    end
    return contador
  end
  
  public
  def is_dead
    return @dead
  end
  def get_hidden_treasures
    
  end
  def get_visible_treasures
    
  end
  def combat(monster)
    
    my_level = @current_player.combat_level
    monster_level = monster.combat_level
    
    if my_level > monster_level
      
      apply_prize(@current_monster)
      
      
      if @current_player.level >= 10
        combat_result = WINANDWINGAME
      else
        combat_result = WIN
      end
      
      
      
    end
   
    
    
    
  end
  def make_treasure_visible(treasure)
    
  end
  def discard_visible_treasure(treasure)
    
    @visible_treasures.delete(treasure)
    
    if (@pending_bad_consequence != nil && (!@pending_bad_consequence.empty?))
      
       @pending_bad_consequence.substract_visible_treasure(treasure)
      
    end
   
    die_if_no_treasures
    
    
  end
  def discard_hidden_treasure(treasure)
    
    @hidden_treasures.delete(treasure)
    
    if (@pending_bad_consequence != nil && (!@pending_bad_consequence.empty?))
      
       @pending_bad_consequence.substract_hidden_treasure(treasure)
      
    end
   
    die_if_no_treasures
    
  end
  def buy_levels(visible, hidden)
    
  end
  def valid_state
    return @pending_badConsequence.is_empty && @hidden_treasures.size <= 4 
  end
  def init_treasures
    
  end
  def has_visible_treasures
    return !@visible_treasures.empty? 
  end
  def get_levels
    return @level
  end
end
