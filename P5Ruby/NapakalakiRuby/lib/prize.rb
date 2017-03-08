#encoding: utf-8

class Prize
  
  attr_accessor :treasures, :level
  
  private
  def initialize(treasures, level)
    @treasures = treasures
    @level = level
  end
  
  def to_s
    "Tesoros ganados: #{@treasures} \n
     Niveles ganados: #{@level}"
  end
end

