package com.github.martinfrank.javarouge.objects.dao;

import com.github.martinfrank.javarouge.objects.generated.Tables;
import com.github.martinfrank.javarouge.objects.generated.tables.daos.StatDao;
import com.github.martinfrank.javarouge.objects.generated.tables.pojos.Stat;
import com.github.martinfrank.javarouge.objects.generated.tables.records.StatRecord;
import org.jooq.Configuration;
import org.jooq.Result;
import org.jooq.impl.DSL;

import java.util.List;
import java.util.stream.Collectors;

public class StatDaoExt extends StatDao {

    public StatDaoExt(Configuration configuration) {
        super(configuration);
    }

    public List<Stat> fetchAll() {
        Result<StatRecord> result = DSL.using(configuration()).selectFrom(Tables.STAT).fetch();
        return result.stream().map(r -> mapper().map(r)).collect(Collectors.toList());
    }
}
