package com.github.martinfrank.javarouge.objects;

import com.github.martinfrank.javarouge.objects.generated.Tables;
import com.github.martinfrank.javarouge.objects.generated.tables.daos.*;
import com.github.martinfrank.javarouge.objects.generated.tables.pojos.Equipmentslottype;
import com.github.martinfrank.javarouge.objects.generated.tables.pojos.Itemsample;
import com.github.martinfrank.javarouge.objects.generated.tables.pojos.Skill;
import com.github.martinfrank.javarouge.objects.generated.tables.pojos.Stat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MonsterManager {

    private final ObjectConstants objectConstants;
    private final MonstersampleDao monsterDao;
    private final StatsDao statsDao;
    private final SkillsDao skillsDao;
    private final StartequipmentDao startequipmentDao;
    private final IntrinsicequipmentDao intrinsicequipmentDao;
    private final EquipmentslotsDao equipmentslotsDao;
    private final DropsDao dropsDao;
    private final ItemManager itemManager;


    public MonsterManager(ConfigurationProvider configurationProvider, ItemManager itemManager, ObjectConstants objectConstants) {
        this.objectConstants = objectConstants;
        this.itemManager = itemManager;
        monsterDao = new MonstersampleDao(configurationProvider.getConfiguration());
        statsDao = new StatsDao(configurationProvider.getConfiguration());
        skillsDao = new SkillsDao(configurationProvider.getConfiguration());
        startequipmentDao = new StartequipmentDao(configurationProvider.getConfiguration());
        dropsDao = new DropsDao(configurationProvider.getConfiguration());
        intrinsicequipmentDao = new IntrinsicequipmentDao(configurationProvider.getConfiguration());
        equipmentslotsDao = new EquipmentslotsDao(configurationProvider.getConfiguration());
    }

    public MonsterPrototype getMonster(String name) {
        //FIXME Lookup Table
        //FIXME invalid argument exception
        MonsterPrototype monsterPrototype = new MonsterPrototype(monsterDao.fetchOne(Tables.MONSTERSAMPLE.NAME, name));
        addStats(monsterPrototype);
        addSkills(monsterPrototype);
        addStartEquipment(monsterPrototype);
        addIntrinsicEquipment(monsterPrototype);
        addDrops(monsterPrototype);
        addEquipmentSlots(monsterPrototype);
        return monsterPrototype;
    }

    private void addEquipmentSlots(MonsterPrototype monsterPrototype) {
        List<Equipmentslottype> equipmentSlots = new ArrayList<>();
        equipmentslotsDao.fetchByMonster(monsterPrototype.getMonstersample().getId()).forEach(s -> equipmentSlots.add(objectConstants.getEquipmentTypeSlotById(s.getEquipmentslot())));
        monsterPrototype.setEquipmentSlots(equipmentSlots);
    }

    private void addDrops(MonsterPrototype monsterPrototype) {
        Map<Itemsample, Double> drops = new HashMap<>();
        dropsDao.fetchByMonster(monsterPrototype.getMonstersample().getId()).forEach(i -> drops.put(itemManager.getItemById(i.getItem()), i.getChance()));
        monsterPrototype.setDrops(drops);
    }

    private void addStartEquipment(MonsterPrototype monsterPrototype) {
        Map<Itemsample, Double> startEquipment = new HashMap<>();
        startequipmentDao.fetchByMonster(monsterPrototype.getMonstersample().getId()).forEach(i -> startEquipment.put(itemManager.getItemById(i.getItem()), i.getChance()));
        monsterPrototype.setStartEquipment(startEquipment);
    }

    private void addIntrinsicEquipment(MonsterPrototype monsterPrototype) {
        List<Itemsample> intrinsicEquipment = new ArrayList<>();
        intrinsicequipmentDao.fetchByMonster(monsterPrototype.getMonstersample().getId()).forEach(i -> intrinsicEquipment.add(itemManager.getItemById(i.getItem())));
        monsterPrototype.setIntrinsicEquipment(intrinsicEquipment);
    }

    private void addSkills(MonsterPrototype monsterPrototype) {
        final Map<Skill, Double> monsterSkill = new HashMap<>();
        skillsDao.fetchByMonster(monsterPrototype.getMonstersample().getId()).forEach(s -> monsterSkill.put(objectConstants.getSkillById(s.getSkill()), s.getValue()));
        monsterPrototype.setSkills(monsterSkill);
    }

    private void addStats(MonsterPrototype monsterPrototype) {
        final Map<Stat, Double> monsterStat = new HashMap<>();
        statsDao.fetchByMonster(monsterPrototype.getMonstersample().getId()).forEach(s -> monsterStat.put(objectConstants.getStatById(s.getStat()), s.getValue()));
        monsterPrototype.setStats(monsterStat);
    }


}
