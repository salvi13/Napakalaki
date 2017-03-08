# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
# encoding: UTF-8

require_relative "napakalaki"
require_relative "monster"
require_relative "bad_consequence"
require_relative "combat_result"

class Player
    attr_accessor :name, :dead, :level, :visible_treasures, :hidden_treasures, :pending_bad_consequence, :dealer
  def initialize(name)
    @name = name
    @level = 1
    @visible_treasures = Array.new
    @hidden_treasures = Array.new
    @dead = true
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
      if treasure.type == TreasureKind::NECKLACE then
        has_necklace = true
      end
    end
    return has_necklace
  end
  def increment_levels(l)
    if (@level + l < 10)
      @level += l
    else
      @level = 10
    end
  end
  
  def decrement_levels(l)
    if (@level - l > 1)
      @level -= l
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
      
      if treasure.type == TreasureKind::NECKLACE
        
        #dealer = CardDealer.instance
        @dealer.give_treasure_back(treasure)
        @visible_treasures.delete(treasure)
        break

      end
      
    end
       
  end
    
   
  def die
    
    @levels = 1
    dealer = CardDealer.instance
    
    @visible_treasures.each do |vtreasure|
      
      dealer.give_treasure_back(vtreasure)
     
    end
    
      @visible_treasures.clear
    
    @hidden_treasures.each do |htreasure|

        dealer.give_treasure_back(htreasure)

      end
    @visible_treasures.clear
    
      die_if_no_treasures
    
  end
  def compute_gold_coins_value(treasure)
    
    coins = 0
    
    treasure.each do |i|
      
    coins += i.gold_coins 
      
    end
    
    
    return ((coins / 1000).round)
    
    
  end
  def can_i_buy_levels(l)
    return @level + l < 10
  end
  def apply_prize(current_monster)
    
    n_levels = current_monster.get_levels_gained
    increment_levels(n_levels)
    n_treasures = current_monster.get_treasures_gained
    
    if n_treasures > 0
      dealer = CardDealer.instance
      
      n_treasures.times do
        
        treasure = dealer.next_treasure
        @hidden_treasures << treasure
        
      end
    end
    
  end
  def apply_bad_consequence(bad)
    #TODO no estoy seguro de esto, deberia ser de bc?
    n_levels = @levels
    
    pending_bad = bad.adjust_to_fit_treasure_lists(@visible_treasures,@hidden_treasures)
    
    set_pending_bad_consequence(pending_bad)
    
  end
  def can_make_treasure_visible(treasure)
  
     count = 0;
     bothHand_inUse = false;
     
    if @visible_treasures.size >= 4
      return false;
    end
  
    
    @visible_treasures.each do |treasure_item|
      
      if treasure_item.type == TreasureKind::ONEHAND
        count += 1;
      elsif treasure_item.type == treasure.type
        return false
      elsif treasure_item.type == TreasureKind::BOTHHAND
        bothHand_inUse = true;
      end
      
    end
    if ((count >= 2 && treasure.type == TreasureKind::ONEHAND) && (treasure.type == TreasureKind::BOTHHAND && count != 0))
      return false;
    end
    
    if treasure.type == TreasureKind::ONEHAND && bothHand_inUse == true
      return false
    end
    
    return true
   
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
    return @hidden_treasures
  end
  def get_visible_treasures
    return @visible_treasures
  end
  def combat(monster)
    
    my_level = get_combat_level
    monster_level = monster.combat_level
    
    if my_level > monster_level
      
      apply_prize(monster)
            
      if @level >= 10
        combat_result = CombatResult::WINANDWINGAME
      else
        combat_result = CombatResult::WIN
      end
    else
      
      dice = Dice.instance
      escape = dice.next_number
      
      if escape < 5
        
        am_i_dead = monster.kill
        
        if am_i_dead
          
          die
          combat_result = CombatResult::LOSEANDDIE
        else
          
          bad = monster.bc
          
          combat_result = CombatResult::LOSE
          
          apply_bad_consequence(bad)
          
        end
        
      else
        
        
      combat_result = CombatResult::LOSEANDESCAPE
        
       
      end
      
      discard_necklace_if_visible
      
      return combat_result
      
    end
      
      
 
   
    
    
    
  end
  def make_treasure_visible(treasure)
    
    can_i = can_make_treasure_visible(treasure)
    
    if can_i 
      @visible_treasures << treasure
      @hidden_treasures.delete(treasure)
    end
    
  end
  def discard_visible_treasure(treasure)
    
    @visible_treasures.delete(treasure)
    
    if (@pending_bad_consequence != nil && (!@pending_bad_consequence.is_empty?))
      
       @pending_bad_consequence.substract_visible_treasure(treasure)
      
    end
 
    die_if_no_treasures
    
    
  end
  def discard_hidden_treasure(treasure)
    
    @hidden_treasures.delete(treasure)
    
    if (@pending_bad_consequence != nil && !@pending_bad_consequence.is_empty )
      
       @pending_bad_consequence.substract_hidden_treasure(treasure)
      
    end
   
    die_if_no_treasures
    
  end
  def buy_levels(visible, hidden)
    
    
    levels_may_bought = compute_gold_coins_value(visible)
    levels_may_bought += compute_gold_coins_value(hidden)
    
    can_i = can_i_buy_levels(levels_may_bought)
    
    if can_i
      increment_levels(levels_may_bought)
    end
    
  
    @hidden_treasures.delete(hidden)
    
    dealer = CardDealer.instance
    
    visible.each do |vtreasure|
        @visible_treasures.delete(vtreasure)
      dealer.give_treasure_back(vtreasure)
      
    end
    
    hidden.each do |htreasure|
      @hidden_treasures.delete(htreasure)
      dealer.give_treasure_back(htreasure)
      
    end
    
   
    
   
    
    return can_i
 
  end
  
  def valid_state
    return ((@pending_badConsequence == nil || @pending_badConsequence.is_empty)  && @hidden_treasures.size <= 4)
  end
  def init_treasures
    
    bring_to_life
    dealer = CardDealer.instance
    treasure = dealer.next_treasure
    @hidden_treasures = Array.new
    @hidden_treasures << treasure
    dice = Dice.instance
    number = dice.next_number
    number = 6
    
    if number > 1
      
      treasure = dealer.next_treasure
      @hidden_treasures << treasure
      
    end
    
     if number == 6
      
      treasure = dealer.next_treasure
      @hidden_treasures << treasure
      
     end
    
  end
  def has_visible_treasures
    return !@visible_treasures.empty? 
  end
  def get_levels
    return @level
  end
  
  
  def to_s
    "#{@name}, Nivel: #{@level} "
    
  end
  
end
