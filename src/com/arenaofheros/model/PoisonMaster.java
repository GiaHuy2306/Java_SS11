package com.arenaofheros.model;

public class PoisonMaster extends GameCharacter implements ISkill {

    public PoisonMaster(String name, int hp, int attackPower) {
        super(name, hp, attackPower);
    }

    @Override
    public void attack(GameCharacter target) {

        if (!super.check(target)) return;

        int damage = super.getAttackPower();
        int oldHp = target.getHp();

        target.takeDamage(damage);
        target.takeDamage(5);

        int realDamage = oldHp - target.getHp();

        System.out.printf("[Độc Sư] %s phóng độc vào %s!\n",
                super.getName(), target.getName());

        System.out.printf("-> %s mất %d máu (kèm độc), HP còn: %d\n",
                target.getName(), realDamage, target.getHp());
    }

    @Override
    public void useUltimate(GameCharacter target) {
        System.out.println("[PoisonMaster] " + name + " dùng ĐỘC VƯƠNG!");
        target.takeDamage(attackPower * 2);
        target.takeDamage(10);
    }
}