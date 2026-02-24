package com.arenaofheros.model;

public class Archer extends GameCharacter implements ISkill {

    private int arrows;

    public Archer(String name, int hp, int attackPower, int arrows) {
        super(name, hp, attackPower);
        this.arrows = arrows;
    }

    @Override
    public void attack(GameCharacter target) {

        if (!super.check(target)) return;

        int damage = (int)(super.getAttackPower() * 1.2);
        int oldHp = target.getHp();

        target.takeDamage(damage);

        int realDamage = oldHp - target.getHp();

        System.out.printf("[Xạ Thủ] %s bắn %s!\n",
                super.getName(), target.getName());

        System.out.printf("-> %s mất %d máu, HP còn: %d\n",
                target.getName(), realDamage, target.getHp());
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