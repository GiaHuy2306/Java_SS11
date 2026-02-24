package com.arenaofheros.model;

public class Mage extends GameCharacter implements ISkill {

    private int mana;

    public Mage(String name, int hp, int attackPower, int mana) {
        super(name, hp, attackPower);
        this.mana = mana;
    }

    @Override
    public void attack(GameCharacter target) {

        if (!super.check(target)) return;

        int damage;
        int oldHp = target.getHp();

        if (mana >= 5) {
            damage = super.getAttackPower();
            mana -= 5;
        } else {
            damage = super.getAttackPower() / 2;
        }

        target.takeDamage(damage);

        int realDamage = oldHp - target.getHp();

        System.out.printf("[Pháp Sư] %s tấn công %s!\n",
                super.getName(), target.getName());

        System.out.printf("-> %s mất %d máu, HP còn: %d\n",
                target.getName(), realDamage, target.getHp());
    }

    @Override
    public void useUltimate(GameCharacter target) {

        if (!super.check(target)) return;

        if (mana < 50) {
            System.out.printf("%s không đủ mana!\n", super.getName());
            return;
        }

        mana -= 50;

        int damage = super.getAttackPower() * 2;
        int oldHp = target.getHp();

        target.takeDamage(damage);

        int realDamage = oldHp - target.getHp();

        System.out.printf("[Pháp Sư] %s dùng HỎA CẦU lên %s!\n",
                super.getName(), target.getName());

        System.out.printf("-> %s mất %d máu, HP còn: %d\n",
                target.getName(), realDamage, target.getHp());
    }

    @Override
    public void displayInfo() {
        System.out.println("Tên: " + name + " | HP: " + hp + " | Mana: " + mana);
    }
}