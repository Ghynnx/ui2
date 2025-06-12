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

public class Skills implements Serializable {
    public String name, description;
    public int manaCost;
    public boolean isPassive;

    public Skills(String name, String description, int manaCost) {
        this(name, description, manaCost, false);
    }

    public Skills(String name, String description, int manaCost, boolean isPassive) {
        this.name = name;
        this.description = description;
        this.manaCost = manaCost;
        this.isPassive = isPassive;
    }
}
