INSERT INTO StartEquipment (monster, item, chance) VALUES (
    (SELECT monster.id FROM Monster monster WHERE monster.name = 'Goblin'),
    (SELECT item.id FROM Item item WHERE item.name = 'Leather helmet'), 0.7);



