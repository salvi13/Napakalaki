#encoding: utf-8

class BadConsequence
  
  attr_accessor :text, :some_levels, :some_visible_treasures, :some_hidden_treasures, :death, :some_specific_visible_treasures, :some_specific_hidden_treasures, :monster
  
  private
  def initialize(text, some_levels, some_visible_treasures, some_hidden_treasures, death, some_specific_visible_treasures, some_specific_hidden_treasures,monster)
    @text = text
    @some_levels = some_levels
    @some_visible_treasures = some_visible_treasures
    @some_hidden_treasures = some_hidden_treasures
    @death = death
    @some_specific_visible_treasures = some_specific_visible_treasures
    @some_specific_hidden_treasures = some_specific_hidden_treasures
    @monster = monster
  end
  public
  def self.new_level_number_of_treasures(text, some_levels, some_visible_treasures, some_hidden_treasures)
    new(text,some_levels,some_visible_treasures,some_hidden_treasures,false,nil,nil)
  end

  def self.new_death(text)
    new(text,nil,nil,nil,true,nil,nil)
  end

  def self.new_level_specific_treasures(text,some_levels, some_specific_visible_treasures, some_specific_hidden_treasures)
    new(text,some_levels,nil,nil,false,some_specific_visible_treasures, some_specific_hidden_treasures)
  end
  # SI LOS SOME_SPECIFIC SON ARRAYS HABRIA QUE INICIALIZARLO
  def is_empty
    return (@some_levels == 0 && @some_visible_treasures == 0 && @some_hidden_treasures == 0 && @death == false && @some_specific_visible_treasures.empty? && @some_specific_hidden_treasures.empty? && @monster == nil)
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
     Monster: #{@monster} \n
     Estas muerto: #{@death}"
    
  end
  
  private_class_method :new
end
