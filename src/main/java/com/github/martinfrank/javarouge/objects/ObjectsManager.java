package com.github.martinfrank.javarouge.objects;

import com.github.martinfrank.javarouge.objects.dao.MonsterDaoExt;
import com.github.martinfrank.javarouge.objects.dao.StatDaoExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Closeable;
import java.io.IOException;
import java.sql.SQLException;

public class ObjectsManager implements Closeable {

    private static final Logger LOGGER = LoggerFactory.getLogger(ObjectsManager.class);

    private final ConfigurationProvider configurationProvider;
    private final MonsterDaoExt monsterDaoExt;
    private final StatDaoExt statDaoExt;

    public ObjectsManager() throws IOException, ClassNotFoundException, SQLException {
        configurationProvider = new H2ConfigurationProvider();
        monsterDaoExt = new MonsterDaoExt(configurationProvider.getConfiguration());
        statDaoExt = new StatDaoExt(configurationProvider.getConfiguration());
    }

    @Override
    public void close() throws IOException {
        configurationProvider.close();
    }

    public MonsterDaoExt getMonsterDao() {
        return monsterDaoExt;
    }

    public StatDaoExt getStatDao() {
        return statDaoExt;
    }
}
