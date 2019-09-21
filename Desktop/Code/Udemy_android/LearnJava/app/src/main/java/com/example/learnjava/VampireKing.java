package com.example.learnjava;

public class VampireKing extends Vampire
{
    public VampireKing(String name) {
        super(name);
        setHitPoints(140);
    }



    @Override
    public void takeDamage(int damage) {
        super.takeDamage(damage / 2);
    }


}
