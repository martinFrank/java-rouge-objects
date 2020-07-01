create TABLE IF NOT EXISTS MonsterPrototype (id INTEGER not NULL, name VARCHAR(255), PRIMARY KEY ( id ))
create TABLE IF NOT EXISTS MonsterStats (id INTEGER not NULL, name VARCHAR(255), PRIMARY KEY ( id ))
create TABLE IF NOT EXISTS MONSTERSTATS (id INTEGER not NULL, foreign key (id) references MONSTERMODEL(id), foreign key (id) references STATSMODEL(id))
