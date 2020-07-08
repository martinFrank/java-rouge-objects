

INSERT INTO SkillModifer (item, skill, operator, value) VALUES ( (SELECT item.id FROM Item item WHERE item.name = 'Leather boots'), (SELECT skill.id FROM Skill skill WHERE skill.name = 'Sneaking'), 'Minus', 1.2)


