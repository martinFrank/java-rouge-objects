insert into ApplicableSkills (item, skill) values (
    (select item.id from ItemSample item where item.name = 'Leather boots'),
    (select skill.id from Skill skill where skill.name = 'Sneaking'));
insert into ApplicableSkills (item, skill) values (
    (select item.id from ItemSample item where item.name = 'Steel dagger'),
    (select skill.id from Skill skill where skill.name = 'Short blade'));
