

insert into ApplicableSkills (item, skill) values ( (select item.id from Item item where item.name = 'Leather boots'), (select skill.id from Skill skill where skill.name = 'Sneaking'))


