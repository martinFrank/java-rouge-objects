package com.github.martinfrank.javarouge.objects;

import java.io.IOException;
import java.sql.SQLException;

public class ObjectsManagerTest {

    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {

        ObjectsManager objectsManager = new ObjectsManager();

        MonsterPrototype wasp = objectsManager.getMonster("Wasp");
        System.out.println("monster: " + wasp);

        MonsterPrototype goblin = objectsManager.getMonster("Goblin");
        System.out.println("monster: " + goblin);

        ItemPrototype item = objectsManager.getItem("Steel dagger");
        System.out.println("item: " + item);

        ItemPrototype honeyPod = objectsManager.getItem("Honey pod");
        System.out.println("honeyPod: " + honeyPod);

        objectsManager.close();
    }
}
