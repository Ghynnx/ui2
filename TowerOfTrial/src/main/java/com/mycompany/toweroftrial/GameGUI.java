/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.toweroftrial;

/**
 *
 * @author User
 */


import javax.swing.*;

public class GameGUI {
    private GameLogic game;
    private JFrame parent;

    public GameGUI(JFrame parent) {
        this.parent = parent;
    }

    public void startNewGame() {
        String playerName = JOptionPane.showInputDialog(parent, "Enter your name:");
        if (playerName == null || playerName.trim().isEmpty()) {
            JOptionPane.showMessageDialog(parent, "Name cannot be empty.");
            return;
        }
        String[] classes = {"Warrior", "Assassin", "Mage", "Archer"};
        String playerClass = (String) JOptionPane.showInputDialog(parent, "Choose your class:", "Class Selection",
                JOptionPane.QUESTION_MESSAGE, null, classes, classes[0]);
        if (playerClass == null) return;

        game = new GameLogic(playerName, playerClass, this);
        game.start();
    }

    public void loadGame() {
        // Simplified: just start new for demo
        JOptionPane.showMessageDialog(parent, "Loading game is not implemented—starting a new game instead.");
        startNewGame();
    }

    public void showGameMenu() {
        String[] options = {"Status", "Inventory", "Shop", "Enter Tower", "Save", "Exit"};
        while (true) {
            int choice = JOptionPane.showOptionDialog(parent, "Choose an action:", "Main Menu",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
            if (choice == 0) game.showStatus();
            else if (choice == 3) game.enterTower();
            else if (choice == 4) game.save();
            else if (choice == 5 || choice == JOptionPane.CLOSED_OPTION) break;
        }
        JOptionPane.showMessageDialog(parent, "Goodbye Hero!");
        parent.setVisible(true);
    }

    // Helper methods for UI display
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(parent, message);
    }
    public String promptInput(String message) {
        return JOptionPane.showInputDialog(parent, message);
    }
    public int promptOption(String message, String[] options) {
        return JOptionPane.showOptionDialog(parent, message, "Choose", JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
    }
}