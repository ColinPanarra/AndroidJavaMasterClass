package com.example.learnjava;

public class HelloWorld {
    public static void main(String[] args) {
        int lives = 0;
        boolean gameOver = (lives<1);

        if(gameOver){
            System.out.println("G A M E O V E R");
        } else{
            System.out.println("you're still alive ya goon");
        }
    }

}
