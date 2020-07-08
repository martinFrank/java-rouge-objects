package com.github.martinfrank.javarouge.objects.dao;

import com.github.martinfrank.javarouge.objects.generated.Tables;
import com.github.martinfrank.javarouge.objects.generated.tables.daos.EquipmentslottypeDao;
import com.github.martinfrank.javarouge.objects.generated.tables.pojos.Equipmentslottype;
import com.github.martinfrank.javarouge.objects.generated.tables.records.EquipmentslottypeRecord;
import org.jooq.Configuration;
import org.jooq.Result;
import org.jooq.impl.DSL;

import java.util.List;
import java.util.stream.Collectors;

public class EquipmentslottypeDaoExt extends EquipmentslottypeDao {

    public EquipmentslottypeDaoExt(Configuration configuration) {
        super(configuration);
    }

    public List<Equipmentslottype> fetchAll() {
        Result<EquipmentslottypeRecord> result = DSL.using(configuration()).selectFrom(Tables.EQUIPMENTSLOTTYPE).fetch();
        return result.stream().map(r -> mapper().map(r)).collect(Collectors.toList());
    }
}
