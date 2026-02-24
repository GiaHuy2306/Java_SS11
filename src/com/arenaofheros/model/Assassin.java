package com.arenaofheros.model;

import java.util.Random;

public class Assassin extends GameCharacter implements ISkill {

    private int energy;
    private Random random = new Random();

    public Assassin(String name, int hp, int attackPower, int energy) {
        super(name, hp, attackPower);
        this.energy = energy;
    }

    @Override
    public void attack(GameCharacter target) {

        int damage = attackPower;

        if (random.nextDouble() < 0.3) {
            damage *= 2;
            System.out.println("[Assassin] CHÍ MẠNG!");
        }

        System.out.println("[Assassin] " + name + " đâm lén!");
        target.takeDamage(damage);
    }

    @Override
    public void useUltimate(GameCharacter target) {

        if (energy < 30) {
            System.out.println(name + " không đủ năng lượng!");
            return;
        }

        energy -= 30;
        System.out.println("[Assassin] " + name + " dùng ÁM SÁT!");
        target.takeDamage(attackPower * 3);
    }

    @Override
    public void displayInfo() {
        System.out.println("Tên: " + name + " | HP: " + hp + " | Energy: " + energy);
    }
}