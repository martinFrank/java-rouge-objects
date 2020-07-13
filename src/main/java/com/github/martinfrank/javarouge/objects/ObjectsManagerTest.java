package com.github.martinfrank.javarouge.objects;

import java.io.IOException;
import java.sql.SQLException;

public class ObjectsManagerTest {

    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {

        ObjectsManager objectsManager = new ObjectsManager();

        MonsterPrototype wasp = objectsManager.getMonster("Wasp");
        System.out.println("wasp: " + wasp);

        MonsterPrototype goblin = objectsManager.getMonster("Goblin");
        System.out.println("goblin: " + goblin);

        ItemPrototype steelDagger = objectsManager.getItem("Steel dagger");
        System.out.println("steelDagger: " + steelDagger);

        ItemPrototype leatherBoots = objectsManager.getItem("Leather boots");
        System.out.println("leatherBoots: " + leatherBoots);

        ItemPrototype honeyPod = objectsManager.getItem("Honey pod");
        System.out.println("honeyPod: " + honeyPod);

        objectsManager.close();
    }
}
