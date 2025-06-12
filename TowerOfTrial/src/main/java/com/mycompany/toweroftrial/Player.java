package com.mycompany.toweroftrial;

import java.io.Serializable;
import java.util.ArrayList;

public class Player implements Serializable {
    String name, playerClass;
    int level = 1, exp = 0, expToNext = 30;
    int hp, maxHp, mp, maxMp;
    ArrayList<Skill> skills = new ArrayList<>();

    public Player(String name, String playerClass) {
        this.name = name;
        this.playerClass = playerClass;
        switch (playerClass) {
            case "Warrior": maxHp = 120; maxMp = 30; break;
            case "Assassin": maxHp = 90; maxMp = 40; break;
            case "Mage": maxHp = 80; maxMp = 70; break;
            case "Archer": maxHp = 100; maxMp = 50; break;
            default: maxHp = 100; maxMp = 30; break;
        }
        hp = maxHp; mp = maxMp;
        skills.add(getBasicSkill());
    }

    public Skill getBasicSkill() {
        switch (playerClass) {
            case "Warrior": return new Skill("Power Strike", "Deal heavy physical damage to one enemy.", 15);
            case "Assassin": return new Skill("Backstab", "Deal critical damage to one enemy.", 15);
            case "Mage": return new Skill("Fireball", "Deal fire magic damage to one enemy.", 15);
            case "Archer": return new Skill("Piercing Arrow", "Deal ranged damage that ignores some defense.", 15);
        }
        return new Skill("Unknown", "No description.", 0);
    }

    // Call this to only give exp and handle level up (but NOT unlock skill automatically)
    public void gainExp(int expAmt) {
        exp += expAmt;
        while (exp >= expToNext) {
            exp -= expToNext;
            level++;
            expToNext += 15;
            maxHp += 15;
            maxMp += 10;
            hp = maxHp; mp = maxMp;
        }
    }

    // Call this separately to unlock skill after defeating the final boss (if not yet unlocked)
    public void unlockSkill() {
        if (level >= 2 && skills.size() < 2) {
            Skill newSkill = null;
            switch (playerClass) {
                case "Warrior": newSkill = new Skill("Shield Bash", "Stun an enemy and deal moderate damage.", 20); break;
                case "Assassin": newSkill = new Skill("Poison Blade", "Attack that poisons the enemy over time.", 20); break;
                case "Mage": newSkill = new Skill("Ice Spike", "Deal ice magic damage and slow the enemy.", 20); break;
                case "Archer": newSkill = new Skill("Double Shot", "Shoot two arrows, each dealing 80% damage.", 20); break;
            }
            if (newSkill != null) {
                skills.add(newSkill);
            }
        }
    }
}