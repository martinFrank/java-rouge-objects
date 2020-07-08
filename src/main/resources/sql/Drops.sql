

INSERT INTO Drops (monster, item, chance) VALUES ( (SELECT monster.id FROM Monster monster WHERE monster.name = 'Wasp'), (SELECT item.id FROM Item item WHERE item.name = 'Honey pod'), 0.1)


