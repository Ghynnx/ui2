/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.toweroftrial;

/**
 *
 * @author User
 */


public class GameLogic {
    private final String playerName;
    private final String playerClass;
    private final GameGUI gui;

    // Add more fields as needed (Player, Shop, Tower, etc.)

    public GameLogic(String playerName, String playerClass, GameGUI gui) {
        this.playerName = playerName;
        this.playerClass = playerClass;
        this.gui = gui;
    }

    public void start() {
        gui.showMessage("Welcome, " + playerName + " the " + playerClass + "!");
        // Initialize player, shop, tower, etc.
        gui.showGameMenu();
    }

    public void showStatus() {
        gui.showMessage("Status for " + playerName + " the " + playerClass + "\n(Implement details here)");
    }


    public void enterTower() {
        gui.showMessage("Tower climbing not yet implemented.");
    }

    public void save() {
        gui.showMessage("Game saved! (Not actually implemented yet)");
    }
}
