
class Dice
  @@instance = nil
  
  def self.instance
    @@instance ||= new
  end
  def next_number
    return rand(1..6)
  end
  
  private :new
end
