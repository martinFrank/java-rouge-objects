package com.github.martinfrank.javarouge.objects.dao;

import com.github.martinfrank.javarouge.objects.generated.Tables;
import com.github.martinfrank.javarouge.objects.generated.tables.daos.MonsterDao;
import com.github.martinfrank.javarouge.objects.generated.tables.pojos.Monster;
import com.github.martinfrank.javarouge.objects.generated.tables.records.MonsterRecord;
import org.jooq.Configuration;
import org.jooq.Result;
import org.jooq.impl.DSL;

import java.util.List;
import java.util.stream.Collectors;

public class MonsterDaoExt extends MonsterDao {

    public MonsterDaoExt(Configuration configuration) {
        super(configuration);
    }

    public List<Monster> fetchAll() {
        Result<MonsterRecord> result = DSL.using(configuration()).selectFrom(Tables.MONSTER).fetch();
        return result.stream().map(r -> mapper().map(r)).collect(Collectors.toList());
    }

}
