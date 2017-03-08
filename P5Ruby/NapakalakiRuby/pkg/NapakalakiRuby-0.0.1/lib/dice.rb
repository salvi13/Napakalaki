# encoding: UTF-8
class Dice
  @@instance = nil
  
  def self.instance
    @@instance ||= new
  end
  def next_number
    return rand(1..6)
  end
  #TODO creo que es asi
  #private :new
end
