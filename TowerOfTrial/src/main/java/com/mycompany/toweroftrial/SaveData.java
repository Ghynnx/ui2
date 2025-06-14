package com.mycompany.toweroftrial;

import java.util.Stack;
import java.util.ArrayList;
import java.io.*;

public class SaveData {
    private static final String SAVE_FILE = "savegame.dat";
    Stack<Player> saves = new Stack<>();

    public void save(Player p) {
        Player copy = clonePlayer(p);
        saves.push(copy);
        writeToFile(copy); // Save to disk
    }

    public Player load() {
        Player loaded = readFromFile();
        if (loaded != null) {
            return loaded;
        }
        if (saves.isEmpty()) {
            return null;
        }
        return clonePlayer(saves.peek());
    }

    private Player clonePlayer(Player p) {
        Player cp = new Player(p.name, p.playerClass);
        cp.level = p.level; cp.exp = p.exp; cp.expToNext = p.expToNext;
        cp.hp = p.hp; cp.maxHp = p.maxHp; cp.mp = p.mp; cp.maxMp = p.maxMp;
        cp.skills = new ArrayList<>(p.skills);
        return cp;
    }

    private void writeToFile(Player p) {
        try (FileOutputStream fos = new FileOutputStream(SAVE_FILE);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(p);
        } catch (Exception e) { /* handle error */ }
    }

    private Player readFromFile() {
        try (FileInputStream fis = new FileInputStream(SAVE_FILE);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            Object obj = ois.readObject();
            if (obj instanceof Player) {
                return (Player) obj;
            }
        } catch (Exception e) { }
        return null;
    }
}