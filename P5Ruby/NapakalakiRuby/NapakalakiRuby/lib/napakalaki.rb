# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

class Napakalaki
   attr_accesor :current_player, :players, :dealer, :current_monster, :result
  include Singleton
  def initialize
    
  end
  private
  def init_players(names)
    @players = Array.new
    
    names.each { |i|   
       @players << player.new(i)
     
    }
    
  end
  def next_player
    
    if(@current_player == nil)
      @current_player = @players.get(rand(@players.size))
    else
      
      if(@current_player  == @players.get(@players.size))
        @current_player = @players.get(0);
      else
          
       @current_player = @players.get(@players.index(@current_player)+1)  
        
      end
       
    end 
      
  return @current_player
    
  end
  def next_turn_allowed
    return @current_player.valid_state
  end
  public
  def develop_combat
    
    monster = @current_monster
    
    @current_player.combat(monster)
    
      
      
      
      
      
      
      
      
      
      
    end
    
    
    
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
    
  end
  def buy_levels(visible, hidden)
    
  end
  def init_game(players)
    
    @dealer.init_players(players)
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
      
      @current_monster = dealer.next_monster
      @current_player = next_player
      dead = @current_player.is_dead
      
      if dead
        
        @current_player.init_treasures
        
        
      end
      
      
    end
          
    
  end
  
  
  def end_of_game(result)
    return(result == CombatResult::WINANDWINGAME)
  end
end
