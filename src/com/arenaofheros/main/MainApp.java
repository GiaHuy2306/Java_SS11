package com.arenaofheros.main;
import com.arenaofheros.model.*;

public class MainApp {

    public static void main(String[] args) {

        Warrior yasuo = new Warrior("Yasuo", 400, 50, 20);
        Mage veigar = new Mage("Veigar", 300, 50, 150);
        Assassin zed = new Assassin("Zed", 280, 40, 100);
        Archer ashe = new Archer("Ashe", 320, 45, 20);

        PoisonMaster twitch = new PoisonMaster("Twitch", 300, 35);

        GameCharacter goblin = new GameCharacter("Goblin", 100, 10) {
            @Override
            public void attack(GameCharacter target) {
                System.out.println("[Quái vật] Goblin cắn trộm...");
                target.takeDamage(10);
            }
        };

        GameCharacter[] characters = {
                yasuo, veigar, zed, ashe, twitch, goblin
        };

        System.out.println("=== ARENA OF HEROES ===");
        System.out.println("Tổng nhân vật: " + GameCharacter.getCount());

        showMatchStatistics(characters, "THÔNG SỐ TRƯỚC TRẬN");

        System.out.println("\n=== BẮT ĐẦU GIAO TRANH ===");

        yasuo.attack(goblin);
        veigar.useUltimate(yasuo);
        zed.useUltimate(veigar);
        ashe.attack(twitch);
        twitch.useUltimate(yasuo);
        goblin.attack(veigar);

        System.out.println("\n=== THÔNG SỐ SAU TRẬN ===");
        for (GameCharacter c : characters) {
            c.displayInfo();
        }
    }

    // Hiển thị thông số toàn bộ nhân vật
    static void showMatchStatistics(GameCharacter[] characters, String title) {
        System.out.println("\n========== " + title + " ==========");
        for (GameCharacter c : characters) {
            c.displayInfo();
        }
        System.out.println("======================================");
    }
}