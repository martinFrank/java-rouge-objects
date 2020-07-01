package com.github.martinfrank.javarouge.objects;

import com.github.martinfrank.javarouge.objects.dao.MonstermodelDaoExt;
import com.github.martinfrank.javarouge.objects.dao.StatsmodelDaoExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Closeable;
import java.io.IOException;
import java.sql.SQLException;

public class ObjectsManager implements Closeable {

    private static final Logger LOGGER = LoggerFactory.getLogger(ObjectsManager.class);

    private final ConfigurationProvider configurationProvider;
    private final MonstermodelDaoExt monstermodelDaoExt;
    private final StatsmodelDaoExt statsmodelDaoExt;

    public ObjectsManager() throws IOException, ClassNotFoundException, SQLException {
        configurationProvider = new H2ConfigurationProvider();
        monstermodelDaoExt = new MonstermodelDaoExt(configurationProvider.getConfiguration());
        statsmodelDaoExt = new StatsmodelDaoExt(configurationProvider.getConfiguration());
    }

    @Override
    public void close() throws IOException {
        configurationProvider.close();
    }

    public MonstermodelDaoExt getMonstermodelDao() {
        return monstermodelDaoExt;
    }

    public StatsmodelDaoExt getStatsmodelDao() {
        return statsmodelDaoExt;
    }
}
