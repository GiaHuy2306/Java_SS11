package com.arenaofheros.model;

public abstract class GameCharacter {
    protected String name;
    protected int hp;
    protected int attackPower;
    protected static int count = 0;

    public GameCharacter(String name, int hp, int attackPower) {
        this.name = name;
        this.hp = hp;
        this.attackPower = attackPower;
        count++;
    }

    public abstract void attack(GameCharacter target);

    public void takeDamage(int amount) {
        hp -= amount;
        if (hp <= 0) {
            this.hp = 0;
            System.out.println(name + "đã bị hạ gục");
        }else {
            System.out.println(name + " mất " +amount + " máu, còn " +hp + " hp");
        }
    }

    public void displayInfo() {
        System.out.println("Name: " + name + " | " + "HP: " + hp);
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public String getName() {
        return name;
    }
    public int getHp() {
        return hp;
    }

    public static   int getCount() {
        return count;
    }
}
