package com.arenaofheros.model;

public class Warrior extends GameCharacter implements ISkill {

    private int armor;

    public Warrior(String name, int hp, int attackPower, int armor) {
        super(name, hp, attackPower);
        this.armor = armor;
    }

    @Override
    public void attack(GameCharacter target) {
        System.out.println("[Chiến binh] " + name + " tấn công!");
        target.takeDamage(attackPower);
    }

    @Override
    public void useUltimate(GameCharacter target) {
        System.out.println("[Chiến binh] " + name + " dùng ĐẤM NGÀN CÂN!");
        target.takeDamage(attackPower * 2);

        int selfDamage = (int)(hp * 0.1);
        hp -= selfDamage;
        System.out.println(name + " mất " + selfDamage + " HP do gắng sức!");
    }

    @Override
    public void takeDamage(int amount) {
        int reduced = amount - armor;
        if (reduced < 0) reduced = 0;
        super.takeDamage(reduced);
    }

    @Override
    public void displayInfo() {
        System.out.println("Tên: " + name + " | HP: " + hp + " | Giáp: " + armor);
    }
}