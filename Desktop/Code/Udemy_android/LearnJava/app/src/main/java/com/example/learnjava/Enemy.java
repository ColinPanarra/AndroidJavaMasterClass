package com.example.learnjava;

public class Enemy {
    private String name;
    private int hitPoints;
    private int lives;

    public Enemy(String name, int hitPoints, int lives) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.lives = lives;
    }
    public void takeDamage(int damage){

        int remainingHitPoints = hitPoints - damage;
        if(remainingHitPoints > 0 ){
            setHitPoints(remainingHitPoints);
            System.out.println("\nI took " + damage + " damage points and have " + remainingHitPoints + " health left" );
        }
        else{
            this.lives--;
            if(lives>0) {
                System.out.println("oof ouch my life");
            }
            else{
                System.out.println("OOF OUCH MY LIVES *DIES*");
            }
        }
    }

    public void showInfo(){
        System.out.println("======================================");
        System.out.println("Name: " + this.name + "\n\nHitpoints: " + this.hitPoints + " \nLives: " + this.lives);
        System.out.println("======================================");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }
}
