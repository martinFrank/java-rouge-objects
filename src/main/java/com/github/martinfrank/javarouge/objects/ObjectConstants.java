package com.github.martinfrank.javarouge.objects;

import com.github.martinfrank.javarouge.objects.dao.EquipmentslottypeDaoExt;
import com.github.martinfrank.javarouge.objects.dao.SkillDaoExt;
import com.github.martinfrank.javarouge.objects.dao.StatDaoExt;
import com.github.martinfrank.javarouge.objects.generated.tables.pojos.Equipmentslottype;
import com.github.martinfrank.javarouge.objects.generated.tables.pojos.Skill;
import com.github.martinfrank.javarouge.objects.generated.tables.pojos.Stat;

import java.util.List;

public class ObjectConstants {

    //Systemdata
    private final List<Stat> stat;
    private final List<Skill> skill;
    private final List<Equipmentslottype> slotType;

    public ObjectConstants(ConfigurationProvider configurationProvider) {
        //LOGGER.
        stat = new StatDaoExt(configurationProvider.getConfiguration()).fetchAll();
        skill = new SkillDaoExt(configurationProvider.getConfiguration()).fetchAll();
        slotType = new EquipmentslottypeDaoExt(configurationProvider.getConfiguration()).fetchAll();
    }

    public Equipmentslottype getEquipmentTypeSlotById(long id) {
        return slotType.stream().filter(s -> s.getId() == id).findAny().orElse(null);
    }

    public Stat getStatById(long id) {
        return stat.stream().filter(s -> s.getId() == id).findAny().orElse(null);
    }

    public Skill getSkillById(long id) {
        return skill.stream().filter(s -> s.getId() == id).findAny().orElse(null);
    }

}
