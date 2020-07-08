package com.github.martinfrank.javarouge.objects;

import com.github.martinfrank.javarouge.objects.generated.tables.pojos.Equipmentslottype;
import com.github.martinfrank.javarouge.objects.generated.tables.pojos.Item;
import com.github.martinfrank.javarouge.objects.generated.tables.pojos.Skill;
import com.github.martinfrank.javarouge.objects.generated.tables.pojos.Stat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemPrototype {

    private final Item item;
    private Map<Skill, Modifier> skillModifier = new HashMap<>();
    private Map<Stat, Modifier> statModifier = new HashMap<>();
    private List<Equipmentslottype> suitableSlots = new ArrayList<>();
    private List<Skill> applicableSkills = new ArrayList<>();

    public ItemPrototype(Item item) {
        this.item = item;
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

    public List<Equipmentslottype> getSuitableSlots() {
        return suitableSlots;
    }

    public void setSuitableSlots(List<Equipmentslottype> suitableSlots) {
        this.suitableSlots = suitableSlots;
    }

    public List<Skill> getApplicableSkills() {
        return applicableSkills;
    }

    public void setApplicableSkills(List<Skill> applicableSkills) {
        this.applicableSkills = applicableSkills;
    }

    @Override
    public String toString() {
        return "ItemPrototype{" +
                "item=" + item +
                ", skillModifier=" + skillModifier +
                ", statModifier=" + statModifier +
                ", suitableSlots=" + suitableSlots +
                ", applicableSkills=" + applicableSkills +
                '}';
    }
}
