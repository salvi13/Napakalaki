#encoding: utf-8

class BadConsequence
  
  attr_accessor :text, :some_levels, :some_visible_treasures, :some_hidden_treasures, :death, :some_specific_visible_treasures, :some_specific_hidden_treasures
  
  private
  def initialize(text, some_levels, some_visible_treasures, some_hidden_treasures, death, some_specific_visible_treasures, some_specific_hidden_treasures)
    @text = text
    @some_levels = some_levels
    @some_visible_treasures = some_visible_treasures
    @some_hidden_treasures = some_hidden_treasures
    @death = death
    @some_specific_visible_treasures = some_specific_visible_treasures
    @some_specific_hidden_treasures = some_specific_hidden_treasures
  end
  public
  def self.new_level_number_of_treasures(text, some_levels, some_visible_treasures, some_hidden_treasures)
    new(text,some_levels,some_visible_treasures,some_hidden_treasures,false,Array.new, Array.new)
  end

  def self.new_death(text)
    new(text,nil,0,0,true,Array.new,Array.new)
  end

  def self.new_level_specific_treasures(text,some_levels, some_specific_visible_treasures, some_specific_hidden_treasures)
    new(text,some_levels,0,0,false,some_specific_visible_treasures, some_specific_hidden_treasures)
  end
  # SI LOS SOME_SPECIFIC SON ARRAYS HABRIA QUE INICIALIZARLO
  def is_empty
    return (@some_levels == 0 && @some_visible_treasures == 0 && @some_hidden_treasures == 0 && @death == false && @some_specific_visible_treasures.empty? && @some_specific_hidden_treasures.empty?)
  end
  
  def substract_visible_treasure(treasure)
    
    if @some_visible_treasures > 0
      @some_visible_treasures = @some_visible_treasures -1
    else
      @some_specific_visible_treasures.delete(treasure.type)
     
    end
  end
  
  def substract_hidden_treasure(treasure)
    
    if @some_hidden_treasures > 0
      @some_hidden_treasures = @some_hidden_treasures -1
    else
      @some_specific_hidden_treasures.delete(treasure.type)
     
    end
  end
  
  def adjust_to_fit_treasure_lists(visible, hidden)
    
    treasure_visible = Array.new
    treasure_hidden = Array.new
    
    visible.each do |treasure|
      if (treasure_visible.index(treasure.type) == nil && @some_specific_visible_treasures.index(treasure.type) != nil)
        treasure_visible << treasure.type
      end
    end
    hidden.each do |treasureH|
      if (treasure_hidden.index(treasureH.type) == nil  && @some_specific_hidden_treasures.index(treasureH.type) != nil)
        treasure_hidden << treasureH.type
      end
    end
    
    bc = BadConsequence.new_level_specific_treasures(@text, 0 ,treasure_visible, treasure_hidden)
    return bc
  end
  
  def my_bad_consequence_is_death
    return @death
  end
  
  def to_s
    "Mal rollo: #{@text} \n
     Niveles perdidos: #{@some_levels}\n
     Tesosoros visibles perdidos: #{@some_visible_treasures} \n
     Tesosoros invisibles perdidos: #{@some_hidden_treasures} \n
     Tesoros especificos visibles perdidos: #{@some_specific_visible_treasures} \n
     Tesoros especificos invisibles perdidos: #{@some_specific_hidden_treasures} \n
     Estas muerto: #{@death}"
    
  end
  #TODO descomentar?
 # private_class_method :new
end
