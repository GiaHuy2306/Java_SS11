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

        if (!super.check(target)) return;

        int damage = super.getAttackPower();
        int oldHp = target.getHp();

        if (Math.random() < 0.3) {
            damage *= 2;
        }

        target.takeDamage(damage);

        int realDamage = oldHp - target.getHp();

        System.out.printf("[Sát Thủ] %s đâm lén %s!\n",
                super.getName(), target.getName());

        System.out.printf("-> %s mất %d máu, HP còn: %d\n",
                target.getName(), realDamage, target.getHp());
    }

    @Override
    public void useUltimate(GameCharacter target) {

        if (!super.check(target)) return;

        int damage = super.getAttackPower() * 3;
        int oldHp = target.getHp();

        target.takeDamage(damage);

        int realDamage = oldHp - target.getHp();

        System.out.printf("[Sát Thủ] %s dùng ÁM SÁT lên %s!\n",
                super.getName(), target.getName());

        System.out.printf("-> %s mất %d máu, HP còn: %d\n",
                target.getName(), realDamage, target.getHp());
    }

    @Override
    public void displayInfo() {
        System.out.println("Tên: " + name + " | HP: " + hp + " | Energy: " + energy);
    }
}