package com.github.martinfrank.javarouge.objects;

import com.github.martinfrank.javarouge.objects.generated.Tables;
import com.github.martinfrank.javarouge.objects.generated.tables.daos.*;
import com.github.martinfrank.javarouge.objects.generated.tables.pojos.Equipmentslottype;
import com.github.martinfrank.javarouge.objects.generated.tables.pojos.Item;
import com.github.martinfrank.javarouge.objects.generated.tables.pojos.Skill;
import com.github.martinfrank.javarouge.objects.generated.tables.pojos.Stat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemManager {

    private final ObjectConstants objectConstants;
    private final SkillmodiferDao skillModifierDao;
    private final StatmodiferDao statModifierDao;
    private final ItemDao itemDao;
    private final SuitableslotsDao suitableslotsDao;
    private final ApplicableskillsDao applicableskillsDao;

    public ItemManager(ConfigurationProvider configurationProvider, ObjectConstants objectConstants) {
        this.objectConstants = objectConstants;
        itemDao = new ItemDao(configurationProvider.getConfiguration());
        skillModifierDao = new SkillmodiferDao(configurationProvider.getConfiguration());
        statModifierDao = new StatmodiferDao(configurationProvider.getConfiguration());
        suitableslotsDao = new SuitableslotsDao(configurationProvider.getConfiguration());
        applicableskillsDao = new ApplicableskillsDao(configurationProvider.getConfiguration());
    }

    public ItemPrototype getItem(String name) {
        //FIXME Lookup Table
        Item item = itemDao.fetchOne(Tables.ITEM.NAME, name);
        ItemPrototype itemPrototype = new ItemPrototype(item);
        addStatModifier(itemPrototype);
        addSkillModifier(itemPrototype);
        addSuitableSlots(itemPrototype);
        addApplicableSkills(itemPrototype);
        return itemPrototype;
    }

    private void addSuitableSlots(ItemPrototype itemPrototype) {
        List<Equipmentslottype> equipmentSlots = new ArrayList<>();
        suitableslotsDao.fetchByItem(itemPrototype.getItem().getId()).forEach(s -> equipmentSlots.add(objectConstants.getEquipmentTypeSlotById(s.getEquipmentslot())));
        itemPrototype.setSuitableSlots(equipmentSlots);
    }

    private void addApplicableSkills(ItemPrototype itemPrototype) {
        List<Skill> applicableSkills = new ArrayList<>();
        applicableskillsDao.fetchByItem(itemPrototype.getItem().getId()).forEach(s -> applicableSkills.add(objectConstants.getSkillById(s.getSkill())));
        itemPrototype.setApplicableSkills(applicableSkills);
    }

    private void addSkillModifier(ItemPrototype itemPrototype) {
        final Map<Skill, Modifier> skillModifier = new HashMap<>();
        skillModifierDao.fetchByItem(itemPrototype.getItem().getId()).forEach(
                s -> skillModifier.put(objectConstants.getSkillById(s.getSkill()), new Modifier(s.getOperator(), s.getValue())));
        itemPrototype.setSkillModifier(skillModifier);
    }

    private void addStatModifier(ItemPrototype itemPrototype) {
        final Map<Stat, Modifier> statModifier = new HashMap<>();
        statModifierDao.fetchByItem(itemPrototype.getItem().getId()).forEach(
                s -> statModifier.put(objectConstants.getStatById(s.getStat()), new Modifier(s.getOperator(), s.getValue())));
        itemPrototype.setStatModifier(statModifier);
    }

    public Item getItemById(Long id) {
        //FIXME Lookup Table
        return itemDao.fetchOne(Tables.ITEM.ID, id);
    }
}
