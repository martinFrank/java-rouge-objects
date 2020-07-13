INSERT INTO Skills (monster, skill, value) VALUES (
    (SELECT monster.id FROM Monster monster WHERE monster.name = 'GridBug'),
    (SELECT skill.id FROM Skill skill WHERE skill.name = 'Bite'), 7.8);
INSERT INTO Skills (monster, skill, value) VALUES (
    (SELECT monster.id FROM Monster monster WHERE monster.name = 'LadyBug'),
    (SELECT skill.id FROM Skill skill WHERE skill.name = 'Bite'), 9.4);
INSERT INTO Skills (monster, skill, value) VALUES (
    (SELECT monster.id FROM Monster monster WHERE monster.name = 'Wasp'),
    (SELECT skill.id FROM Skill skill WHERE skill.name = 'Bite'), 9.2);
INSERT INTO Skills (monster, skill, value) VALUES (
    (SELECT monster.id FROM Monster monster WHERE monster.name = 'Wasp'),
    (SELECT skill.id FROM Skill skill WHERE skill.name = 'Sting'), 7.4);
