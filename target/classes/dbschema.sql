#No-Ref-Table
#create TABLE IF NOT EXISTS Monster (id INTEGER not NULL, name VARCHAR(255), difficulty DOUBLE, experience DOUBLE, PRIMARY KEY ( id ))
create TABLE IF NOT EXISTS Monster (id IDENTITY NOT NULL PRIMARY KEY, name VARCHAR(255), difficulty DOUBLE, experience DOUBLE)


create TABLE IF NOT EXISTS Stat (id INTEGER not NULL, name VARCHAR(255), PRIMARY KEY ( id ))
create TABLE IF NOT EXISTS Skill (id INTEGER not NULL, name VARCHAR(255), PRIMARY KEY ( id ))
create TABLE IF NOT EXISTS Item (id INTEGER not NULL, name VARCHAR(255), type INTEGER, PRIMARY KEY ( id ))

#Ref-Tables
create TABLE IF NOT EXISTS Stats(id INTEGER not NULL, foreign key (id) references monster(id), foreign key (id) references Stat(id))
create TABLE IF NOT EXISTS Skills(id INTEGER not NULL, foreign key (id) references monster(id), foreign key (id) references Skill(id))
create TABLE IF NOT EXISTS StartEquipment(id INTEGER not NULL, foreign key (id) references monster(id), foreign key (id) references Item(id))
create TABLE IF NOT EXISTS Drops(id INTEGER not NULL, foreign key (id) references monster(id), foreign key (id) references Item(id))

create TABLE IF NOT EXISTS SkillRequirements(id INTEGER not NULL, foreign key (id) references Skill(id), foreign key (id) references Stat(id))
create TABLE IF NOT EXISTS SkillModifer(id INTEGER not NULL, foreign key (id) references Item(id), foreign key (id) references Skill(id))
create TABLE IF NOT EXISTS StatModifer(id INTEGER not NULL, foreign key (id) references Item(id), foreign key (id) references Stat(id))

