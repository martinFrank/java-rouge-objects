package com.github.martinfrank.javarouge.objects.dao;

import com.github.martinfrank.javarouge.objects.generated.Tables;
import com.github.martinfrank.javarouge.objects.generated.tables.daos.SkillDao;
import com.github.martinfrank.javarouge.objects.generated.tables.pojos.Skill;
import com.github.martinfrank.javarouge.objects.generated.tables.records.SkillRecord;
import org.jooq.Configuration;
import org.jooq.Result;
import org.jooq.impl.DSL;

import java.util.List;
import java.util.stream.Collectors;

public class SkillDaoExt extends SkillDao {

    public SkillDaoExt(Configuration configuration) {
        super(configuration);
    }

    public List<Skill> fetchAll() {
        Result<SkillRecord> result = DSL.using(configuration()).selectFrom(Tables.SKILL).fetch();
        return result.stream().map(r -> mapper().map(r)).collect(Collectors.toList());
    }
}
