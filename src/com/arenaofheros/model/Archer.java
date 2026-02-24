package com.arenaofheros.model;

public class Archer extends GameCharacter implements ISkill {

    private int arrows;

    public Archer(String name, int hp, int attackPower, int arrows) {
        super(name, hp, attackPower);
        this.arrows = arrows;
    }

    @Override
    public void attack(GameCharacter target) {

        if (arrows <= 0) {
            System.out.println(name + " hết tên!");
            return;
        }

        arrows--;
        System.out.println("[Archer] " + name + " bắn tên!");
        target.takeDamage((int)(attackPower * 1.2));
    }

    @Override
    public void useUltimate(GameCharacter target) {

        if (arrows < 5) {
            System.out.println(name + " không đủ tên!");
            return;
        }

        arrows -= 5;
        System.out.println("[Archer] " + name + " dùng MƯA TÊN!");
        target.takeDamage(attackPower * 2);
    }

    @Override
    public void displayInfo() {
        System.out.println("Tên: " + name + " | HP: " + hp + " | Mũi tên: " + arrows);
    }
}