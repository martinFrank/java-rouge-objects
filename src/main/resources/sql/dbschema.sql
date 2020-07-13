
create TABLE IF NOT EXISTS Stat (id IDENTITY NOT NULL, name VARCHAR(255), PRIMARY KEY ( id ))
create TABLE IF NOT EXISTS Skill (id IDENTITY NOT NULL, name VARCHAR(255), PRIMARY KEY ( id ))
create TABLE IF NOT EXISTS EquipmentSlotType (id IDENTITY NOT NULL, name VARCHAR(255), PRIMARY KEY ( id ))

create TABLE IF NOT EXISTS Monster (id IDENTITY NOT NULL PRIMARY KEY, name VARCHAR(255), difficulty DOUBLE, experience DOUBLE)
create TABLE IF NOT EXISTS Item (id IDENTITY NOT NULL, name VARCHAR(255), worth DOUBLE, weight DOUBLE, PRIMARY KEY (id))

#monster
create TABLE IF NOT EXISTS Stats(id IDENTITY NOT NULL, monster LONG NOT NULL, stat LONG NOT NULL, value DOUBLE, FOREIGN KEY (monster) REFERENCES Monster(id) , FOREIGN KEY (stat) REFERENCES Stat(id) )
create TABLE IF NOT EXISTS Skills(id IDENTITY NOT NULL, monster LONG NOT NULL, skill LONG NOT NULL, value DOUBLE, FOREIGN KEY (monster) REFERENCES monster(id), FOREIGN KEY (skill) REFERENCES Skill(id))
create TABLE IF NOT EXISTS EquipmentSlots(id IDENTITY NOT NULL, monster LONG NOT NULL, equipmentSlot LONG NOT NULL, FOREIGN KEY (monster) REFERENCES monster(id), FOREIGN KEY (equipmentSlot) REFERENCES EquipmentSlotType(id))
create TABLE IF NOT EXISTS StartEquipment(id IDENTITY NOT NULL, monster LONG NOT NULL, item LONG NOT NULL, chance DOUBLE, FOREIGN KEY (monster) REFERENCES monster(id), FOREIGN KEY (item) REFERENCES Item(id))
create TABLE IF NOT EXISTS Drops(id IDENTITY NOT NULL, monster LONG NOT NULL, item LONG NOT NULL, chance DOUBLE, FOREIGN KEY (monster) REFERENCES monster(id), FOREIGN KEY (item) REFERENCES Item(id))
create TABLE IF NOT EXISTS IntrinsicEquipment(id IDENTITY NOT NULL, monster LONG NOT NULL, item LONG NOT NULL, FOREIGN KEY (monster) REFERENCES monster(id), FOREIGN KEY (item) REFERENCES Item(id))

#item
create TABLE IF NOT EXISTS SkillModifer(id IDENTITY NOT NULL, item LONG NOT NULL, skill LONG NOT NULL, operator VARCHAR(255), value DOUBLE, FOREIGN KEY (item) REFERENCES Item(id), FOREIGN KEY (skill) REFERENCES Skill(id))
create TABLE IF NOT EXISTS StatModifer(id IDENTITY NOT NULL, item LONG NOT NULL, stat LONG NOT NULL, operator VARCHAR(255), value DOUBLE, FOREIGN KEY (item) REFERENCES Item(id), FOREIGN KEY (stat) REFERENCES Stat(id))
create TABLE IF NOT EXISTS ApplicableSkills(id IDENTITY NOT NULL, item LONG NOT NULL, skill LONG NOT NULL, FOREIGN KEY (item) REFERENCES Item(id), FOREIGN KEY (skill) REFERENCES Skill(id))
create TABLE IF NOT EXISTS SuitableSlots(id IDENTITY NOT NULL, item LONG NOT NULL, equipmentSlot LONG NOT NULL, FOREIGN KEY (item) REFERENCES Item(id), FOREIGN KEY (equipmentSlot) REFERENCES EquipmentSlotType(id))





