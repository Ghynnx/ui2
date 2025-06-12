package com.mycompany.toweroftrial;

import java.util.ArrayList;
import java.util.Random;

public class Monster {
    String name;
    int hp, maxHp, mp, maxMp, attack, expReward;
    boolean isBoss;
    ArrayList<Skill> activeSkills = new ArrayList<>();
    ArrayList<Skill> passiveSkills = new ArrayList<>();
    Random rand = new Random();

    public Monster(String name, int hp, int mp, int atk, int exp, boolean boss) {
        this.name = name;
        this.maxHp = hp; this.hp = hp;
        this.maxMp = mp; this.mp = mp;
        this.attack = atk;
        this.expReward = exp;
        this.isBoss = boss;
        assignSkills();
    }

    private void assignSkills() {
        if (!isBoss) {
            activeSkills.add(new Skill("Savage Bite", "A ferocious bite that deals extra damage", 10));
        } else {
            passiveSkills.add(new Skill("Thick Hide", "Reduces all damage taken by 5", 0, true));
            activeSkills.add(new Skill("Roar", "Decreases player's attack for 2 turns", 15));
            activeSkills.add(new Skill("Mega Slam", "Deals massive damage, but costs a lot of MP", 30));
        }
    }

    public boolean hasEnoughMp(Skill skill) {
        return mp >= skill.manaCost;
    }

    public Skill chooseSkill() {
        int choice = rand.nextInt(activeSkills.size() + 1);
        if (choice == 0) return null; // basic attack
        Skill skill = activeSkills.get(choice - 1);
        if (hasEnoughMp(skill)) {
            return skill;
        }
        return null; // fallback to basic attack if not enough MP
    }

    public int applyPassive(int dmg) {
        if (isBoss && !passiveSkills.isEmpty()) {
            for (Skill s : passiveSkills) {
                if (s.name.equals("Thick Hide")) {
                    dmg -= 5;
                }
            }
        }
        return Math.max(dmg, 0);
    }

    public String getPassiveDesc() {
        if (!passiveSkills.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (Skill s : passiveSkills) sb.append(s.name).append(": ").append(s.description).append("\n");
            return sb.toString();
        }
        return "";
    }
}