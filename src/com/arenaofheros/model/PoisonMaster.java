package com.arenaofheros.model;

public class PoisonMaster extends GameCharacter implements ISkill {

    public PoisonMaster(String name, int hp, int attackPower) {
        super(name, hp, attackPower);
    }

    @Override
    public void attack(GameCharacter target) {
        System.out.println("[PoisonMaster] " + name + " phóng độc!");
        target.takeDamage(attackPower);
        target.takeDamage(5);
    }

    @Override
    public void useUltimate(GameCharacter target) {
        System.out.println("[PoisonMaster] " + name + " dùng ĐỘC VƯƠNG!");
        target.takeDamage(attackPower * 2);
        target.takeDamage(10);
    }
}