package com.github.martinfrank.javarouge.objects;

import com.github.martinfrank.javarouge.objects.generated.tables.pojos.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MonsterPrototype {

    private final Monstersample monstersample;
    private Map<Stat, Double> stats = new HashMap<>();
    private Map<Skill, Double> skills = new HashMap<>();
    private Map<Itemsample, Double> drops = new HashMap<>();
    private Map<Itemsample, Double> startEquipment = new HashMap<>();
    private List<Itemsample> intrinsicEquipment = new ArrayList<>();


    private List<Equipmentslottype> equipmentSlots = new ArrayList<>();

    public MonsterPrototype(Monstersample monster) {
        this.monstersample = monster;
    }

    public Monstersample getMonstersample() {
        return monstersample;
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

    public Map<Itemsample, Double> getDrops() {
        return drops;
    }

    public void setDrops(Map<Itemsample, Double> drops) {
        this.drops = drops;
    }

    public Map<Itemsample, Double> getStartEquipment() {
        return startEquipment;
    }

    public void setStartEquipment(Map<Itemsample, Double> startEquipment) {
        this.startEquipment = startEquipment;
    }

    public List<Itemsample> getIntrinsicEquipment() {
        return intrinsicEquipment;
    }

    public void setIntrinsicEquipment(List<Itemsample> intrinsicEquipment) {
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
                "monster=" + monstersample +
                ", stats=" + stats +
                ", skills=" + skills +
                ", drops=" + drops +
                ", startEquipment=" + startEquipment +
                ", intrinsicEquipment=" + intrinsicEquipment +
                ", equipmentSlots=" + equipmentSlots +
                '}';
    }
}
