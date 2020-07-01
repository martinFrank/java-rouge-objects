package com.github.martinfrank.javarouge.objects.dao;

import com.github.martinfrank.javarouge.objects.generated.Tables;
import com.github.martinfrank.javarouge.objects.generated.tables.daos.MonstermodelDao;
import com.github.martinfrank.javarouge.objects.generated.tables.pojos.Monstermodel;
import com.github.martinfrank.javarouge.objects.generated.tables.records.MonstermodelRecord;
import org.jooq.Configuration;
import org.jooq.Result;
import org.jooq.impl.DSL;

import java.util.List;
import java.util.stream.Collectors;

public class MonstermodelDaoExt extends MonstermodelDao {

    public MonstermodelDaoExt(Configuration configuration) {
        super(configuration);
    }

    public List<Monstermodel> fetchAll() {
        Result<MonstermodelRecord> result = DSL.using(configuration()).selectFrom(Tables.MONSTERMODEL).fetch();
        return result.stream().map(r -> mapper().map(r)).collect(Collectors.toList());
    }

}
