package com.github.martinfrank.javarouge.objects;

import com.github.martinfrank.javarouge.objects.dao.ItemtypeDaoExt;
import com.github.martinfrank.javarouge.objects.dao.SkillDaoExt;
import com.github.martinfrank.javarouge.objects.dao.StatDaoExt;
import com.github.martinfrank.javarouge.objects.generated.tables.pojos.Itemtype;
import com.github.martinfrank.javarouge.objects.generated.tables.pojos.Skill;
import com.github.martinfrank.javarouge.objects.generated.tables.pojos.Stat;

import java.util.List;

public class SystemData {

    //Systemdata
    private final List<Stat> stat;
    private final List<Skill> skill;
    private final List<Itemtype> itemTypes;

    public SystemData(ConfigurationProvider configurationProvider) {
        stat = new StatDaoExt(configurationProvider.getConfiguration()).fetchAll();
        skill = new SkillDaoExt(configurationProvider.getConfiguration()).fetchAll();
        itemTypes = new ItemtypeDaoExt(configurationProvider.getConfiguration()).fetchAll();
    }

    public Stat statById(long id) {
        return stat.stream().filter(s -> s.getId() == id).findAny().orElse(null);
    }

    public Skill skillById(long id) {
        return skill.stream().filter(s -> s.getId() == id).findAny().orElse(null);
    }

    public Itemtype getItemTypById(Long id) {
        return itemTypes.stream().filter(s -> s.getId() == id).findAny().orElse(null);
    }
}
