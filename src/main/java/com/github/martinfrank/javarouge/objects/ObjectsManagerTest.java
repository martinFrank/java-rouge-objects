package com.github.martinfrank.javarouge.objects;

import com.github.martinfrank.javarouge.objects.dao.MonstermodelDaoExt;
import com.github.martinfrank.javarouge.objects.generated.tables.Statsmodel;
import com.github.martinfrank.javarouge.objects.generated.tables.daos.StatsmodelDao;
import com.github.martinfrank.javarouge.objects.generated.tables.pojos.Monstermodel;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ObjectsManagerTest {

    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {

        ObjectsManager objectsManager = new ObjectsManager();
        MonstermodelDaoExt monsterDaoExt = objectsManager.getMonstermodelDao();
        StatsmodelDao statsmodelDao = objectsManager.getStatsmodelDao();

//        Monster monster = new Monster();
//        monster.setId(2);
//        monster.setName("ladybug");
//        monsterDaoExt.insert(monster);

        List<Monstermodel> monsters = monsterDaoExt.fetchAll();
        for (Monstermodel monster : monsters) {
            System.out.println(monster);
        }

        Monstermodel model = monsters.get(0);
        Statsmodel statsmodel = statsmodelDao.fe

        objectsManager.close();
    }
}
