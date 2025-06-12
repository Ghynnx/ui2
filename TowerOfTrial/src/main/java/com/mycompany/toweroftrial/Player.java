/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.toweroftrial;

/**
 *
 * @author User
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Player implements Serializable {
    public String name, playerClass;
    public int level = 1, exp = 0, expToNext = 30;
    public int hp, maxHp, mp, maxMp, gold = 0;
    public HashMap<String, Integer> items = new HashMap<>();
    public ArrayList<Skills> skills = new ArrayList<>();
    public String equippedItem = null;

    public Player(String name, String playerClass) {
        this.name = name;
        this.playerClass = playerClass;
        switch (playerClass) {
            case "Warrior": maxHp=120; maxMp=30; break;
            case "Assassin": maxHp=90; maxMp=40; break;
            case "Mage": maxHp=80; maxMp=70; break;
            case "Archer": maxHp=100; maxMp=50; break;
        }
        hp = maxHp; mp = maxMp;
        skills.add(getBasicSkill());
    }

    public Skills getBasicSkill() {
        switch (playerClass) {
            case "Warrior": return new Skills("Power Strike", "Deal heavy physical damage to one enemy.", 15);
            case "Assassin": return new Skills("Backstab", "Deal critical damage to one enemy.", 15);
            case "Mage": return new Skills("Fireball", "Deal fire magic damage to one enemy.", 15);
            case "Archer": return new Skills("Piercing Arrow", "Deal ranged damage that ignores some defense.", 15);
        }
        return new Skills("Unknown", "No description.", 0);
    }
}