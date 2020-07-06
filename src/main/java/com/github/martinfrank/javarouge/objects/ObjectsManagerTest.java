package com.github.martinfrank.javarouge.objects;

import java.io.IOException;
import java.sql.SQLException;

public class ObjectsManagerTest {

    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {

        ObjectsManager objectsManager = new ObjectsManager();

        MonsterPrototype monster = objectsManager.getMonster("Wasp");
        System.out.println("monster: " + monster);

        objectsManager.close();
    }
}
