package com.example.learnjava;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Player {
    private String handelName;
    private int lives;
    private int level;
    private int score;
    private Weapon weapon;
    private ArrayList<Loot> inventory;


    public Player() {
        this("unknown Player");
    }

    public Player(String handelName, int level) {
        this.handelName = handelName;
        this.level = level;
        this.lives = 3;
        this.score = 0;
        inventory = new ArrayList<>(5);

    }

    public Player(String handelName) {
        this(handelName, 1);
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public void setNameAndLevel(String name, int level) {
        if (name.length() < 3) {
            System.out.println("name must be more than 3 characters");
            return;
        }
        this.handelName = name;
        this.level = level;
        setDefaultWeapon();

    }

    private void setDefaultWeapon() {
        this.weapon = new Weapon("sword", 10, 20);
    }

    public Weapon getWeapon() {
        return this.weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;

    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getHandelName() {
        return handelName;
    }

    public void setHandelName(String handelName) {
        if (handelName.length() < 3) {
            return;
        }
        this.handelName = handelName;
    }

    public ArrayList<Loot> getInventory() {
        return inventory;
    }

    public void setIntentory(ArrayList<Loot> inventory) {
        this.inventory = inventory;
    }

    public void pickUpLoot(Loot newLoot){
        inventory.add(newLoot);
    }

    public boolean dropLoot(Loot loot){
        if(this.inventory.contains(loot)){
            inventory.remove(loot);
            return true;
        }
        return false;
    }
    public void showInventory(){
        for (Loot item : inventory) {
            System.out.println(item.getName());
        }
        System.out.println("====================================");
    }
}
