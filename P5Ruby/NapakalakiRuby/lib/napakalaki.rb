# encoding: UTF-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

require "singleton"
require_relative "player"
require_relative "card_dealer"
require_relative "treasure_kind"

class Napakalaki
  attr_accessor :current_player, :players, :dealer, :current_monster, :result
  
  include Singleton
  def initialize
    
  end
  private
  def init_players(names)
    
    @players = Array.new
    
    names.each do |i|   
       @players << Player.new(i)
    end
    
    
  end
  def next_player
    
    if(@current_player == nil)
      @current_player = @players.at(rand(@players.size))
    else
      
      if(@current_player  == @players.at(@players.size - 1))
        @current_player = @players.at(0);
      else
       @current_player = @players.at(@players.index(@current_player)+1) 
      end
       
    end 
  
  return @current_player
    
  end
  def next_turn_allowed
    
    if  @current_player == nil 
      return true
    else
      return @current_player.valid_state
    end
    
  end
  public
  def develop_combat
    
    monster = @current_monster
    
    combat_result = @current_player.combat(monster)
      
    @dealer.give_monster_back(@current_monster)
    
    
    #TODO miralo, aunque creo que esta bien
    if combat_result == CombatResult::LOSEANDCONVERT
      cult = @dealer.next_cultist
      
      new_cultist_player = CultistPlayer.new(@current_player, cult)
      
      
      index = @players.index(@current_player)
      
      @players.delete(@current_player) 
      @players.insert(index, new_cultist_player)
     
      @current_player = new_cultist_player
    end
     
    return combat_result
  end
  
  def discard_visible_treasures(treasures)
    
    treasures.each do |tr|
      
       @current_player.discard_visible_treasure(tr)
       @current_player.give_treasure_back(tr)
      
    end
   
   
    
  end
  def discard_hidden_treasures(treasures)
    
    treasures.each do |tr|
      
       @current_player.discard_hidden_treasure(tr)
       @current_player.give_treasure_back(tr)
      
    end
   
  end
  def make_treasures_visible(treasures)
    
    treasures.each do |treasure|
      
      @current_player.make_treasure_visible(treasure)
      
      
    end
    
    
    
    
  end
  def buy_levels(visible, hidden)
    
    return @current_player.buy_levels(visible, hidden)
    
    
    
  end
  def init_game(players)
   
    @dealer = CardDealer.instance
    init_players(players)
    @dealer.init_cards 
    next_turn
    
    
   
  end
  def get_current_player
    return @current_player
  end
  def get_current_monster
    return @current_monster
  end
  
  def next_turn
    
    stateOK = next_turn_allowed
    
    if stateOK
      
      @current_monster = @dealer.next_monster
      @current_player = next_player
      dead = @current_player.is_dead
      
      if dead
        
        @current_player.init_treasures
        
        
      end
      
      
    end
    
    return stateOK
          
  end
  
  
  def end_of_game(result)
    return(result == CombatResult::WINANDWINGAME)
  end
end
