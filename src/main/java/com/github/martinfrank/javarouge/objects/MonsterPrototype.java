package com.github.martinfrank.javarouge.objects;

import com.github.martinfrank.javarouge.objects.generated.tables.pojos.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MonsterPrototype {

    private final Monster monster;
    private Map<Stat, Double> stats = new HashMap<>();
    private Map<Skill, Double> skills = new HashMap<>();
    private Map<Item, Double> drops = new HashMap<>();
    private Map<Item, Double> startEquipment = new HashMap<>();
    private List<Item> intrinsicEquipment = new ArrayList<>();


    private List<Equipmentslottype> equipmentSlots = new ArrayList<>();

    public MonsterPrototype(Monster monster) {
        this.monster = monster;
    }

    public Monster getMonster() {
        return monster;
    }

    public Map<Stat, Double> getStats() {
        return stats;
    }

    public void setStats(Map<Stat, Double> stats) {
        this.stats = stats;
    }

    public Map<Skill, Double> getSkills() {
        return skills;
    }

    public void setSkills(Map<Skill, Double> skills) {
        this.skills = skills;
    }

    public Map<Item, Double> getDrops() {
        return drops;
    }

    public void setDrops(Map<Item, Double> drops) {
        this.drops = drops;
    }

    public Map<Item, Double> getStartEquipment() {
        return startEquipment;
    }

    public void setStartEquipment(Map<Item, Double> startEquipment) {
        this.startEquipment = startEquipment;
    }

    public List<Item> getIntrinsicEquipment() {
        return intrinsicEquipment;
    }

    public void setIntrinsicEquipment(List<Item> intrinsicEquipment) {
        this.intrinsicEquipment = intrinsicEquipment;
    }

    public List<Equipmentslottype> getEquipmentSlots() {
        return equipmentSlots;
    }

    public void setEquipmentSlots(List<Equipmentslottype> equipmentSlots) {
        this.equipmentSlots = equipmentSlots;
    }

    @Override
    public String toString() {
        return "MonsterPrototype{" +
                "monster=" + monster +
                ", stats=" + stats +
                ", skills=" + skills +
                ", drops=" + drops +
                ", startEquipment=" + startEquipment +
                ", intrinsicEquipment=" + intrinsicEquipment +
                ", equipmentSlots=" + equipmentSlots +
                '}';
    }
}
