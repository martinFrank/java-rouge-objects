package com.github.martinfrank.javarouge.objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Closeable;
import java.io.IOException;
import java.sql.SQLException;

public class ObjectsManager implements Closeable {

    private static final Logger LOGGER = LoggerFactory.getLogger(ObjectsManager.class);

    private final ConfigurationProvider configurationProvider;

    private final MonsterManager monsterManager;
    private final ItemManager itemManager;

    public ObjectsManager() throws IOException, ClassNotFoundException, SQLException {
        configurationProvider = new H2ConfigurationProvider();
        final ObjectConstants objectConstants = new ObjectConstants(configurationProvider);
        itemManager = new ItemManager(configurationProvider, objectConstants);
        monsterManager = new MonsterManager(configurationProvider, itemManager, objectConstants);
    }

    @Override
    public void close() throws IOException {
        configurationProvider.close();
    }

    public MonsterPrototype getMonster(String name) {
        return monsterManager.getMonster(name);
    }

    public ItemPrototype getItem(String name) {
        return itemManager.getItem(name);
    }

}
