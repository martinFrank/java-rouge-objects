INSERT INTO IntrinsicEquipment (monster, item) VALUES (
    (SELECT monster.id FROM Monster monster WHERE monster.name = 'Wasp'),
    (SELECT item.id FROM Item item WHERE item.name = 'Wasp mandibles'));
INSERT INTO IntrinsicEquipment (monster, item) VALUES (
    (SELECT monster.id FROM Monster monster WHERE monster.name = 'Wasp'),
    (SELECT item.id FROM Item item WHERE item.name = 'Wasp stinger'));
