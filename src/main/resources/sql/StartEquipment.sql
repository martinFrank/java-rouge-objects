

#INSERT INTO StartEquipment (monster, item, chance) VALUES ( (SELECT monster.id FROM Monster monster WHERE monster.name = 'GridBug'), (SELECT item.id FROM Item item WHERE item.name = 'Bug mandibles'), 1)
#INSERT INTO StartEquipment (monster, item, chance) VALUES ( (SELECT monster.id FROM Monster monster WHERE monster.name = 'LadyBug'), (SELECT item.id FROM Item item WHERE item.name = 'Bug mandibles'), 1)
#INSERT INTO StartEquipment (monster, item, chance) VALUES ( (SELECT monster.id FROM Monster monster WHERE monster.name = 'Wasp'), (SELECT item.id FROM Item item WHERE item.name = 'Bug mandibles'), 1)
#INSERT INTO StartEquipment (monster, item, chance) VALUES ( (SELECT monster.id FROM Monster monster WHERE monster.name = 'Wasp'), (SELECT item.id FROM Item item WHERE item.name = 'Wasp stinger'), 1)
INSERT INTO StartEquipment (monster, item, chance) VALUES ( (SELECT monster.id FROM Monster monster WHERE monster.name = 'Goblin'), (SELECT item.id FROM Item item WHERE item.name = 'Leather helmet'), 0.7)


