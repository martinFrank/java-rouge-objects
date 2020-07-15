INSERT INTO StartEquipment (monster, item, chance) VALUES (
    (SELECT monster.id FROM MonsterSample monster WHERE monster.name = 'Goblin'),
    (SELECT item.id FROM ItemSample item WHERE item.name = 'Leather helmet'), 0.7);



