package com.github.martinfrank.javarouge.objects.dao;

import com.github.martinfrank.javarouge.objects.generated.tables.daos.StatDao;
import org.jooq.Configuration;

public class StatDaoExt extends StatDao {

    public StatDaoExt(Configuration configuration) {
        super(configuration);
    }
}
