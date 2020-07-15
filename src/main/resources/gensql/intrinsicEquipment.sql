INSERT INTO IntrinsicEquipment (monster, item) VALUES (
    (SELECT monster.id FROM MonsterSample monster WHERE monster.name = 'Wasp'),
    (SELECT item.id FROM ItemSample item WHERE item.name = 'Wasp mandibles'));
INSERT INTO IntrinsicEquipment (monster, item) VALUES (
    (SELECT monster.id FROM MonsterSample monster WHERE monster.name = 'Wasp'),
    (SELECT item.id FROM ItemSample item WHERE item.name = 'Wasp stinger'));
