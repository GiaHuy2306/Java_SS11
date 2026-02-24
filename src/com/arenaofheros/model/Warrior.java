package com.arenaofheros.model;

public class Warrior extends GameCharacter implements ISkill {

    private int armor;

    public Warrior(String name, int hp, int attackPower, int armor) {
        super(name, hp, attackPower);
        this.armor = armor;
    }

    @Override
    public void attack(GameCharacter target) {

        if (!super.check(target)) return;

        int oldHp = target.getHp();
        int damage = super.getAttackPower();

        target.takeDamage(damage);

        int realDamage = oldHp - target.getHp();

        System.out.printf("[Chiến Binh] %s tấn công %s!\n",
                super.getName(), target.getName());

        System.out.printf("-> %s mất %d máu, HP còn: %d\n",
                target.getName(), realDamage, target.getHp());
    }

    @Override
    public void useUltimate(GameCharacter target) {

        if (!super.check(target)) return;

        int damage = super.getAttackPower() * 2;
        int oldHp = target.getHp();

        target.takeDamage(damage);

        int realDamage = oldHp - target.getHp();

        System.out.printf("[Chiến Binh] %s dùng ĐẤM NGÀN CÂN lên %s!\n",
                super.getName(), target.getName());

        System.out.printf("-> %s mất %d máu, HP còn: %d\n",
                target.getName(), realDamage, target.getHp());
    }

    @Override
    public void displayInfo() {
        System.out.println("Tên: " + name + " | HP: " + hp + " | Giáp: " + armor);
    }
}