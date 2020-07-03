#No-Ref-Table
#create TABLE IF NOT EXISTS Monster (id INTEGER not NULL, name VARCHAR(255), difficulty DOUBLE, experience DOUBLE, PRIMARY KEY ( id ))

create TABLE IF NOT EXISTS Monster (id IDENTITY NOT NULL PRIMARY KEY, name VARCHAR(255), difficulty DOUBLE, experience DOUBLE)
create TABLE IF NOT EXISTS Stat (id IDENTITY not NULL, name VARCHAR(255), PRIMARY KEY ( id ))
create TABLE IF NOT EXISTS Skill (id IDENTITY not NULL, name VARCHAR(255), PRIMARY KEY ( id ))
create TABLE IF NOT EXISTS Item (id IDENTITY not NULL, name VARCHAR(255), worth DOUBLE, weight DOUBLE, PRIMARY KEY ( id ))
create TABLE IF NOT EXISTS ItemType (id IDENTITY not NULL, name VARCHAR(255), PRIMARY KEY ( id ))

#Ref-Tables
create TABLE IF NOT EXISTS Stats(id IDENTITY not NULL, foreign key (id) references monster(id), foreign key (id) references Stat(id))
create TABLE IF NOT EXISTS Skills(id IDENTITY not NULL, foreign key (id) references monster(id), foreign key (id) references Skill(id))
create TABLE IF NOT EXISTS StartEquipment(id IDENTITY not NULL, foreign key (id) references monster(id), foreign key (id) references Item(id))
create TABLE IF NOT EXISTS Drops(id IDENTITY not NULL, foreign key (id) references monster(id), foreign key (id) references Item(id))

create TABLE IF NOT EXISTS SkillRequirements(id IDENTITY not NULL, foreign key (id) references Skill(id), foreign key (id) references Stat(id))
create TABLE IF NOT EXISTS SkillModifer(id IDENTITY not NULL, foreign key (id) references Item(id), foreign key (id) references Skill(id))
create TABLE IF NOT EXISTS StatModifer(id IDENTITY not NULL, foreign key (id) references Item(id), foreign key (id) references Stat(id))

create TABLE IF NOT EXISTS ItemTypes(id IDENTITY not NULL, foreign key (id) references Item(id), foreign key (id) references ItemType(id))

