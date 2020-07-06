package com.github.martinfrank.javarouge.objects.dao;

import com.github.martinfrank.javarouge.objects.generated.Tables;
import com.github.martinfrank.javarouge.objects.generated.tables.daos.ItemtypeDao;
import com.github.martinfrank.javarouge.objects.generated.tables.pojos.Itemtype;
import com.github.martinfrank.javarouge.objects.generated.tables.records.ItemtypeRecord;
import org.jooq.Configuration;
import org.jooq.Result;
import org.jooq.impl.DSL;

import java.util.List;
import java.util.stream.Collectors;

public class ItemtypeDaoExt extends ItemtypeDao {

    public ItemtypeDaoExt(Configuration configuration) {
        super(configuration);
    }

    public List<Itemtype> fetchAll() {
        Result<ItemtypeRecord> result = DSL.using(configuration()).selectFrom(Tables.ITEMTYPE).fetch();
        return result.stream().map(r -> mapper().map(r)).collect(Collectors.toList());
    }
}
