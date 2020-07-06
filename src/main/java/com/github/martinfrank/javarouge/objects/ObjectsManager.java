package com.github.martinfrank.javarouge.objects;

import com.github.martinfrank.javarouge.objects.dao.MonsterDaoExt;
import com.github.martinfrank.javarouge.objects.dao.SkillDaoExt;
import com.github.martinfrank.javarouge.objects.dao.StatDaoExt;
import com.github.martinfrank.javarouge.objects.generated.Tables;
import com.github.martinfrank.javarouge.objects.generated.tables.daos.SkillsDao;
import com.github.martinfrank.javarouge.objects.generated.tables.daos.StatsDao;
import com.github.martinfrank.javarouge.objects.generated.tables.pojos.Skill;
import com.github.martinfrank.javarouge.objects.generated.tables.pojos.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Closeable;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ObjectsManager implements Closeable {

    private static final Logger LOGGER = LoggerFactory.getLogger(ObjectsManager.class);

    private final ConfigurationProvider configurationProvider;
    private final MonsterDaoExt monsterDaoExt;
    private final StatsDao statsDao;
    private final SkillsDao skillsDao;
    private final StatDaoExt statDaoExt;
    private final SkillDaoExt skillDaoExt;
    //Systemdata
    private final List<Stat> stat;
    private final List<Skill> skill;

    public ObjectsManager() throws IOException, ClassNotFoundException, SQLException {
        configurationProvider = new H2ConfigurationProvider();
        monsterDaoExt = new MonsterDaoExt(configurationProvider.getConfiguration());
        statsDao = new StatsDao(configurationProvider.getConfiguration());
        skillsDao = new SkillsDao(configurationProvider.getConfiguration());
        statDaoExt = new StatDaoExt(configurationProvider.getConfiguration());
        skillDaoExt = new SkillDaoExt(configurationProvider.getConfiguration());
        stat = statDaoExt.fetchAll();
        skill = skillDaoExt.fetchAll();
    }

    @Override
    public void close() throws IOException {
        configurationProvider.close();
    }

    public MonsterPrototype getMonster(String name) {
        MonsterPrototype monsterPrototype = new MonsterPrototype(monsterDaoExt.fetchOne(Tables.MONSTER.NAME, name));

        final Map<Stat, Double> monsterStat = new HashMap<>();
        statsDao.fetchByMonster(monsterPrototype.getMonster().getId()).forEach(s -> monsterStat.put(statById(s.getStat()), s.getValue()));
        monsterPrototype.setStats(monsterStat);

        final Map<Skill, Double> monsterSkill = new HashMap<>();
        skillsDao.fetchByMonster(monsterPrototype.getMonster().getId()).forEach(s -> monsterSkill.put(skillById(s.getSkill()), s.getValue()));
        monsterPrototype.setSkills(monsterSkill);
        return monsterPrototype;
    }

    private Stat statById(long id) {
        return stat.stream().filter(s -> s.getId() == id).findAny().orElse(null);
    }

    private Skill skillById(long id) {
        return skill.stream().filter(s -> s.getId() == id).findAny().orElse(null);
    }
}
