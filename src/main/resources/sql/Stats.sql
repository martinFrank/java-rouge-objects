

#INSERT INTO Stats (monster, stat, value) VALUES ( (SELECT monster.id FROM Monster monster WHERE monster.name = 'GridBug'), (SELECT stat.id FROM Stat stat WHERE stat.name = 'Health'), 10)
#INSERT INTO Stats (monster, stat, value) VALUES ( (SELECT monster.id FROM Monster monster WHERE monster.name = 'GridBug'), (SELECT stat.id FROM Stat stat WHERE stat.name = 'Stamina'), 10)

#INSERT INTO Stats (monster, stat, value) VALUES ( (SELECT monster.id FROM Monster monster WHERE monster.name = 'LadyBug'), (SELECT stat.id FROM Stat stat WHERE stat.name = 'Health'), 10)
#INSERT INTO Stats (monster, stat, value) VALUES ( (SELECT monster.id FROM Monster monster WHERE monster.name = 'LadyBug'), (SELECT stat.id FROM Stat stat WHERE stat.name = 'Stamina'), 10)

INSERT INTO Stats (monster, stat, value) VALUES ( (SELECT monster.id FROM Monster monster WHERE monster.name = 'Wasp'), (SELECT stat.id FROM Stat stat WHERE stat.name = 'Health'), 12)
INSERT INTO Stats (monster, stat, value) VALUES ( (SELECT monster.id FROM Monster monster WHERE monster.name = 'Wasp'), (SELECT stat.id FROM Stat stat WHERE stat.name = 'Stamina'), 12)

#INSERT INTO Stats (monster, stat, value) VALUES ( (SELECT monster.id FROM Monster monster WHERE monster.name = 'Dog'), (SELECT stat.id FROM Stat stat WHERE stat.name = 'Health'), 21)
#INSERT INTO Stats (monster, stat, value) VALUES ( (SELECT monster.id FROM Monster monster WHERE monster.name = 'Dog'), (SELECT stat.id FROM Stat stat WHERE stat.name = 'Stamina'), 21)

INSERT INTO Stats (monster, stat, value) VALUES ( (SELECT monster.id FROM Monster monster WHERE monster.name = 'Goblin'), (SELECT stat.id FROM Stat stat WHERE stat.name = 'Health'), 33)
INSERT INTO Stats (monster, stat, value) VALUES ( (SELECT monster.id FROM Monster monster WHERE monster.name = 'Goblin'), (SELECT stat.id FROM Stat stat WHERE stat.name = 'Stamina'), 33)



