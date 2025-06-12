package com.mycompany.toweroftrial;

import java.io.Serializable;

public class Skill implements Serializable {
    public String name;
    public String description;
    public int manaCost;
    public boolean isPassive;

    public Skill(String name, String description, int manaCost) {
        this(name, description, manaCost, false);
    }

    public Skill(String name, String description, int manaCost, boolean isPassive) {
        this.name = name;
        this.description = description + " (Mana Cost: " + manaCost + ")" + (isPassive ? " [Passive]" : "");
        this.manaCost = manaCost;
        this.isPassive = isPassive;
    }
}