/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.toweroftrial;

/**
 *
 * @author User
 */
import java.util.ArrayList;
import java.util.Random;

public class Monster {
    public String name;
    public int hp, maxHp, mp, maxMp, attack, goldReward, expReward;
    public boolean isBoss;
    public ArrayList<Skills> activeSkills = new ArrayList<>();
    public ArrayList<Skills> passiveSkills = new ArrayList<>();
    Random rand = new Random();

    public Monster(String name, int hp, int mp, int atk, int gold, int exp, boolean boss) {
        this.name = name;
        this.maxHp = hp; this.hp = hp;
        this.maxMp = mp; this.mp = mp;
        this.attack = atk;
        this.goldReward = gold;
        this.expReward = exp;
        this.isBoss = boss;
        assignSkills();
    }

    private void assignSkills() {
        if (!isBoss) {
            activeSkills.add(new Skills("Savage Bite", "A ferocious bite that deals extra damage", 10));
        } else {
            passiveSkills.add(new Skills("Thick Hide", "Reduces all damage taken by 5", 0, true));
            activeSkills.add(new Skills("Roar", "Decreases player's attack for 2 turns", 15));
            activeSkills.add(new Skills("Mega Slam", "Deals massive damage, but costs a lot of MP", 30));
        }
    }

    public int applyPassive(int dmg) {
        if (isBoss && !passiveSkills.isEmpty()) {
            for (Skills s : passiveSkills) {
                if (s.name.equals("Thick Hide")) {
                    dmg -= 5;
                }
            }
        }
        return Math.max(dmg, 0);
    }
}