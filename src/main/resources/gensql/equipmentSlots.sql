INSERT INTO EquipmentSlots (monster, equipmentSlot) VALUES (
    (SELECT monster.id FROM MonsterSample monster WHERE monster.name = 'Goblin'),
    (SELECT slot.id FROM Equipmentslottype slot WHERE slot.name = 'Primary hand'));



