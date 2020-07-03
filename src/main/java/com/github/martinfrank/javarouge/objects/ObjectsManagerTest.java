package com.github.martinfrank.javarouge.objects;

import com.github.martinfrank.javarouge.objects.dao.MonsterDaoExt;
import com.github.martinfrank.javarouge.objects.generated.tables.daos.StatDao;
import com.github.martinfrank.javarouge.objects.generated.tables.pojos.Monster;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ObjectsManagerTest {

    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {

        ObjectsManager objectsManager = new ObjectsManager();
        MonsterDaoExt monsterDaoExt = objectsManager.getMonsterDao();
        StatDao statsmodelDao = objectsManager.getStatDao();

//        Monster monster = new Monster();
//        monster.setId(2);
//        monster.setName("ladybug");
//        monsterDaoExt.insert(monster);

        List<Monster> monsters = monsterDaoExt.fetchAll();
        for (Monster monster : monsters) {
            System.out.println(monster);
        }

        Monster model = monsters.get(0);

        objectsManager.close();
    }
}
