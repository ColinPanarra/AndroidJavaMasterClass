package com.example.learnjava;

import java.util.ArrayList;

public class Demo {

    public static void main(String[] args) {
        Player Colin = new Player();
        Colin.setHandelName("Colin");
        System.out.println(Colin.getHandelName());

        Player john = new Player();
        john.setNameAndLevel("john", 2);
        Weapon ultimate = new Weapon("ULTIMA", 9999, 999999);
        Colin.setWeapon(ultimate);
//        System.out.println(john.getHandelName() + "\n" + john.getLevel());
//        System.out.println(Colin.getWeapon().getName().toUpperCase());

        Loot redPotion = new Loot("Red Potion", LootType.POTION, 7);
        Colin.pickUpLoot(redPotion);
        Colin.pickUpLoot(new Loot("Chest armor", LootType.ARMOR, 43));
        Colin.showInventory();
        Colin.pickUpLoot(new Loot("Ring of Protection", LootType.RING, 65));
        Colin.pickUpLoot(new Loot("Invisibility Potion", LootType.POTION, 265));
        
        boolean wasDeleted = Colin.dropLoot(redPotion);
        System.out.println(wasDeleted);
        Colin.showInventory();

    }
}
