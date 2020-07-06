package com.github.martinfrank.javarouge.objects;

import com.github.martinfrank.javarouge.objects.generated.Tables;
import com.github.martinfrank.javarouge.objects.generated.tables.daos.ItemDao;
import com.github.martinfrank.javarouge.objects.generated.tables.daos.SkillmodiferDao;
import com.github.martinfrank.javarouge.objects.generated.tables.daos.StatmodiferDao;
import com.github.martinfrank.javarouge.objects.generated.tables.pojos.Item;
import com.github.martinfrank.javarouge.objects.generated.tables.pojos.Itemtype;
import com.github.martinfrank.javarouge.objects.generated.tables.pojos.Skill;
import com.github.martinfrank.javarouge.objects.generated.tables.pojos.Stat;

import java.util.HashMap;
import java.util.Map;

public class ItemManager {

    private final SystemData systemData;
    private final SkillmodiferDao skillModifierDao;
    private final StatmodiferDao statModifierDao;
    private final ItemDao itemDao;

    public ItemManager(ConfigurationProvider configurationProvider, SystemData systemData) {
        this.systemData = systemData;
        itemDao = new ItemDao(configurationProvider.getConfiguration());
        skillModifierDao = new SkillmodiferDao(configurationProvider.getConfiguration());
        statModifierDao = new StatmodiferDao(configurationProvider.getConfiguration());
    }

    public ItemPrototype getItem(String name) {
        Item item = itemDao.fetchOne(Tables.ITEM.NAME, name);
        Itemtype itemtype = systemData.getItemTypById(item.getItemtype());
        ItemPrototype itemPrototype = new ItemPrototype(item, itemtype);
        addStatModifier(itemPrototype);
        addSkillModifier(itemPrototype);
        return itemPrototype;
    }

    private void addSkillModifier(ItemPrototype itemPrototype) {
        final Map<Skill, Modifier> skillModifier = new HashMap<>();
        skillModifierDao.fetchByItem(itemPrototype.getItem().getId()).forEach(
                s -> skillModifier.put(systemData.skillById(s.getSkill()), new Modifier(s.getOperator(), s.getValue())));
        itemPrototype.setSkillModifier(skillModifier);
    }

    private void addStatModifier(ItemPrototype itemPrototype) {
        final Map<Stat, Modifier> statModifier = new HashMap<>();
        statModifierDao.fetchByItem(itemPrototype.getItem().getId()).forEach(
                s -> statModifier.put(systemData.statById(s.getStat()), new Modifier(s.getOperator(), s.getValue())));
        itemPrototype.setStatModifier(statModifier);
    }
}
