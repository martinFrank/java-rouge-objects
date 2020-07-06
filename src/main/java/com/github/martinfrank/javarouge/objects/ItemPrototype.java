package com.github.martinfrank.javarouge.objects;

import com.github.martinfrank.javarouge.objects.generated.tables.pojos.Item;
import com.github.martinfrank.javarouge.objects.generated.tables.pojos.Itemtype;
import com.github.martinfrank.javarouge.objects.generated.tables.pojos.Skill;
import com.github.martinfrank.javarouge.objects.generated.tables.pojos.Stat;

import java.util.HashMap;
import java.util.Map;

public class ItemPrototype {

    private final Item item;
    private final Itemtype itemtype;
    private Map<Skill, Modifier> skillModifier = new HashMap<>();
    private Map<Stat, Modifier> statModifier = new HashMap<>();

    public ItemPrototype(Item item, Itemtype itemtype) {
        this.item = item;
        this.itemtype = itemtype;
    }

    public Item getItem() {
        return item;
    }

    public Map<Skill, Modifier> getSkillModifier() {
        return skillModifier;
    }

    public void setSkillModifier(Map<Skill, Modifier> skillModifier) {
        this.skillModifier = skillModifier;
    }

    public Map<Stat, Modifier> getStatModifier() {
        return statModifier;
    }

    public void setStatModifier(Map<Stat, Modifier> statModifier) {
        this.statModifier = statModifier;
    }

    @Override
    public String toString() {
        return "ItemPrototype{" +
                "item=" + item +
                ", itemtype=" + itemtype +
                ", skillModifier=" + skillModifier +
                ", statModifier=" + statModifier +
                '}';
    }
}
