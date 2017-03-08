#encoding: utf-8

require_relative "prize"
require_relative "bad_consequence"
require_relative "monster"
require_relative "treasure_kind"

monsters = Array.new

price = Prize.new(2,1)
bc = BadConsequence.new_level_specific_treasures('Pierdes tu armadura visible y otra oculta',
  0, [TreasureKind::ARMOR], [TreasureKind::ARMOR])
monsters << Monster.new('3 Byakhees de bonanza',8, price,bc)

price = Prize.new(1,1)
bc = BadConsequence.new_level_specific_treasures('Embobados con el lindo primigenio te descartas de tu casco visible',
  0, [TreasureKind::HELMET], nil)
monsters << Monster.new('Chibithulhu',2, price,bc)

price = Prize.new(1,1)
bc = BadConsequence.new_level_specific_treasures('El primordial bostezo contagioso. Pierdes el calzado visible',
  0, [TreasureKind::SHOE], nil)
monsters << Monster.new('El sopor de Dunwich',2, price,bc)

price = Prize.new(4,1)
bc = BadConsequence.new_level_specific_treasures('Te atrapan para llevarte de fiesta y te dejan caer en mitad de vuelo. Descarta 1 mano visible y 1 mano oculta',
  0,[TreasureKind::ONEHAND],[TreasureKind::ONEHAND])
monsters << Monster.new('Angeles de la noche ibicenca', 14, price,bc)

price = Prize.new(3,1)
bc = BadConsequence.new_level_number_of_treasures('Pierdes todos tus tesoros visibles',0 , 6, 0)
monsters << Monster.new('El gorron en el umbral',10, price,bc)

price = Prize.new(2,1)
bc = BadConsequence.new_level_specific_treasures('Pierdes la armadura visible', 0, [TreasureKind::ARMOR], nil)
monsters << Monster.new('H.P. Munchcraft',6, price,bc)

price = Prize.new(1,1)
bc = BadConsequence.new_level_specific_treasures('Sientes bichos bajo la ropa. Descarta la armadura visible',
  0, [TreasureKind::ARMOR], nil)
monsters << Monster.new('Bichgooth',2, price,bc)

price = Prize.new(4,2)
bc = BadConsequence.new_level_number_of_treasures('Pierdes 5 niveles y 3 tesoros visibles',5 , 3, 0)
monsters << Monster.new('El rey de rosa',13, price,bc)

price = Prize.new(1,1)
bc = BadConsequence.new_level_number_of_treasures('Toses los pulmones y pierdes 2 niveles.',2 , 0, 0)
monsters << Monster.new('La que redacta en las tinieblas',2, price,bc)

price = Prize.new(2,1)
bc = BadConsequence.new_death('Estos monstruos resultan bastante superficiales y te aburren mortalmente. Estas muerto')
monsters << Monster.new('Los hondos',8, price,bc)

price = Prize.new(2,1)
bc = BadConsequence.new_level_number_of_treasures('Pierdes 2 niveles y 2 tesoros ocultos.', 2,0,2)
monsters << Monster.new('Semillas Cthulhu',4, price,bc)

price = Prize.new(2,1)
bc = BadConsequence.new_level_specific_treasures('Te intentas escaquear. Pierdes una mano visible.', 0, [TreasureKind::ONEHAND], nil)
monsters << Monster.new('Dameargo',1, price,bc)

price = Prize.new(1,1)
bc = BadConsequence.new_level_number_of_treasures('Da mucho asquito. Pierdes 3 niveles.',3, 0, 0)
monsters << Monster.new('Pollipolipo volante',3, price,bc)

price = Prize.new(3,1)
bc = BadConsequence.new_death('No le hace gracia que pronuncien mal su nombre. Estas muerto')
monsters << Monster.new('YskhtihyssgGoth',12, price,bc)

price = Prize.new(4,1)
bc = BadConsequence.new_death('La familia te atrapa. Estas muerto.')
monsters << Monster.new('Familia feliz',1, price,bc)

price = Prize.new(2,1)
bc = BadConsequence.new_level_specific_treasures('La quinta directiva primaria  te obliga a perder 2 niveles y un tesoro 2 manos visible',
  2, [TreasureKind::BOTHHAND], nil)
monsters << Monster.new('Roboggoth',8, price,bc)

price = Prize.new(1,1)
bc = BadConsequence.new_level_specific_treasures('Te asusta en la noche. Pierdes un casco visible.', 0, [TreasureKind::HELMET], nil)
monsters << Monster.new('El espia',5, price,bc)

price = Prize.new(1,1)
bc = BadConsequence.new_level_number_of_treasures('Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles.',2 , 5, 0)
monsters << Monster.new('El Lenguas',20, price,bc)

price = Prize.new(1,1)
bc = BadConsequence.new_level_specific_treasures('Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos.',
  3, [TreasureKind::BOTHHAND], nil)
monsters << Monster.new('Bicefalo',20, price,bc)


#puts monsters
puts "Monstruos con nivel 10 o superior: \n"
for monstruo in monsters
  if monstruo.combat_level > 10 then
    puts monstruo
  end
end
puts "Monstruos con mal rollo que solo quita niveles: \n"
for monstruo in monsters
  badc = monstruo.bc
  if badc.some_levels != 0 && (badc.some_hidden_treasures == nil || badc.some_hidden_treasures == 0 ) && (badc.some_visible_treasures == nil || badc.some_visible_treasures == 0 ) && badc.some_specific_hidden_treasures == nil && badc.some_specific_visible_treasures == nil && badc.death == nil then
      puts monstruo  
  end
end
puts "Monstruos con buen rollo que da mas de 1 nivel: \n"
for monstruo in monsters
  pr = monstruo.prize
  if pr.level > 1 then
      puts monstruo  
  end
end
puts "Monstruos con mal rollo que quita tesoros: \n"
for monstruo in monsters
  badc = monstruo.bc
  if badc.some_specific_hidden_treasures != nil || badc.some_specific_visible_treasures != nil then
      puts monstruo  
  end
end


