package com.github.martinfrank.javarouge.objects.dao;

import com.github.martinfrank.javarouge.objects.generated.Tables;
import com.github.martinfrank.javarouge.objects.generated.tables.daos.RegistrationDao;
import com.github.martinfrank.javarouge.objects.generated.tables.pojos.Registration;
import com.github.martinfrank.javarouge.objects.generated.tables.records.RegistrationRecord;
import org.jooq.Configuration;
import org.jooq.Result;
import org.jooq.impl.DSL;

import java.util.List;
import java.util.stream.Collectors;

public class RegistrationDaoExt extends RegistrationDao {

    public RegistrationDaoExt() {
    }

    public RegistrationDaoExt(Configuration configuration) {
        super(configuration);
    }

    public List<Registration> fetchAll() {
        Result<RegistrationRecord> result = DSL.using(configuration()).selectFrom(Tables.REGISTRATION).fetch();
        return result.stream().map(r -> mapper().map(r)).collect(Collectors.toList());
    }
}
