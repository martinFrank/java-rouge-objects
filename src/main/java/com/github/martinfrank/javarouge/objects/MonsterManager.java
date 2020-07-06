package com.github.martinfrank.javarouge.objects;

import com.github.martinfrank.javarouge.objects.generated.Tables;
import com.github.martinfrank.javarouge.objects.generated.tables.daos.MonsterDao;
import com.github.martinfrank.javarouge.objects.generated.tables.daos.SkillsDao;
import com.github.martinfrank.javarouge.objects.generated.tables.daos.StatsDao;
import com.github.martinfrank.javarouge.objects.generated.tables.pojos.Skill;
import com.github.martinfrank.javarouge.objects.generated.tables.pojos.Stat;

import java.util.HashMap;
import java.util.Map;

public class MonsterManager {

    private final SystemData systemData;
    private final MonsterDao monsterDao;
    private final StatsDao statsDao;
    private final SkillsDao skillsDao;


    public MonsterManager(ConfigurationProvider configurationProvider, SystemData systemData) {
        this.systemData = systemData;
        monsterDao = new MonsterDao(configurationProvider.getConfiguration());
        statsDao = new StatsDao(configurationProvider.getConfiguration());
        skillsDao = new SkillsDao(configurationProvider.getConfiguration());
    }

    public MonsterPrototype getMonster(String name) {
        MonsterPrototype monsterPrototype = new MonsterPrototype(monsterDao.fetchOne(Tables.MONSTER.NAME, name));
        addStats(monsterPrototype);
        addSkills(monsterPrototype);
        return monsterPrototype;
    }

    private void addSkills(MonsterPrototype monsterPrototype) {
        final Map<Skill, Double> monsterSkill = new HashMap<>();
        skillsDao.fetchByMonster(monsterPrototype.getMonster().getId()).forEach(s -> monsterSkill.put(systemData.skillById(s.getSkill()), s.getValue()));
        monsterPrototype.setSkills(monsterSkill);
    }

    private void addStats(MonsterPrototype monsterPrototype) {
        final Map<Stat, Double> monsterStat = new HashMap<>();
        statsDao.fetchByMonster(monsterPrototype.getMonster().getId()).forEach(s -> monsterStat.put(systemData.statById(s.getStat()), s.getValue()));
        monsterPrototype.setStats(monsterStat);
    }


}
