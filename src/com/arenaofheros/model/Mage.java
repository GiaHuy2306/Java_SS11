package com.arenaofheros.model;

public class Mage extends GameCharacter implements ISkill {

    private int mana;

    public Mage(String name, int hp, int attackPower, int mana) {
        super(name, hp, attackPower);
        this.mana = mana;
    }

    @Override
    public void attack(GameCharacter target) {

        if (mana >= 5) {
            mana -= 5;
            System.out.println("[Pháp sư] " + name + " tung phép!");
            target.takeDamage(attackPower);
        } else {
            System.out.println(name + " hết mana, đánh yếu!");
            target.takeDamage(attackPower / 2);
        }
    }

    @Override
    public void useUltimate(GameCharacter target) {

        if (mana < 50) {
            System.out.println(name + " không đủ mana!");
            return;
        }

        mana -= 50;
        System.out.println("[Pháp sư] " + name + " dùng HỎA CẦU!");
        target.takeDamage(attackPower * 2);
    }

    @Override
    public void displayInfo() {
        System.out.println("Tên: " + name + " | HP: " + hp + " | Mana: " + mana);
    }
}