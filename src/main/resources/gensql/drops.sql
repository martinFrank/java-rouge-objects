INSERT INTO Drops (monster, item, chance) VALUES (
    (SELECT monster.id FROM MonsterSample monster WHERE monster.name = 'Wasp'),
    (SELECT item.id FROM ItemSample item WHERE item.name = 'Honey pod'), 0.1);
