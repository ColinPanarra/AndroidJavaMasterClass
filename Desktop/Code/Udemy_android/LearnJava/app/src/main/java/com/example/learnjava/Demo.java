package com.example.learnjava;

import java.util.ArrayList;

public class Demo {

    public static void main(String[] args) {
//        Enemy enemy = new Enemy("test", 10, 3);
//        enemy.showInfo();
//        enemy.takeDamage(3);
//        enemy.showInfo();
//
//        enemy.takeDamage(12);
//        enemy.showInfo();

        Trolol trolol = new Trolol("UGLY TROLL");
        trolol.showInfo();
        trolol.takeDamage(30);

        Vampire Nosferatu = new VampireKing("Nosferatu");
        Nosferatu.takeDamage(10);
        Nosferatu.showInfo();


    }

}
