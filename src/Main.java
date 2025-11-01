import Factory.HeroFactory;
import Heroes.Hero;
import ObserverImplementations.BattleLogger;
import ObserverImplementations.GameAnnouncer;
import ObserverImplementations.HealthMonitoring;
import Strategy.Strategy;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hero hero1 = setupHero(scanner, "Hero 1");
        Hero hero2 = setupHero(scanner, "Hero 2");
        addObservers(hero1);
        addObservers(hero2);

        System.out.println("Battle: " + hero1.getName() + " vs. " + hero2.getName());

        int round = 1;
        while (hero1.isAlive() && hero2.isAlive()) {
            System.out.println("ROUND " + round);
            displayStatus(hero1, hero2);

            if (hero1.isAlive()) {
                selectAction(scanner, hero1, hero2);
            }

            if (hero2.isAlive()) {
                selectAction(scanner, hero2, hero1);
            }

            round++;
            if (round > 50) {
                System.out.println("Very long battle!");
                break;
            }
        }

        System.out.println("Battle is over");
        if (hero1.isAlive()) {
            System.out.printf("Winner ", hero1.getName(), hero1.getLevel());
        } else if (hero2.isAlive()) {
            System.out.printf("Winner ", hero2.getName(), hero2.getLevel());
        } else {
            System.out.println("Draw!");
        }

        scanner.close();
    }


    private static Hero setupHero(Scanner scanner, String heroNumber) {
        String type;
        boolean isValid = false;
        String[] validTypes = {"Warrior", "Mage", "Support", "Tank", "Archer"};
        System.out.println("----------------------------------------");
        System.out.println("Creating " + heroNumber);
        System.out.println("----------------------------------------");

        do {
            System.out.print("Enter the type (Warrior, Mage, Support, Tank, Archer): ");
            type = scanner.nextLine().trim();
            for (String validType : validTypes) {
                if (validType.equalsIgnoreCase(type)) {
                    type = validType;
                    isValid = true;
                    break;
                }
            }
            if (!isValid) {
                System.out.println("Invalid type!Rewrite please");
            }
        } while (!isValid);

        System.out.print("Enter the nickname of hero: ");
        String name = scanner.nextLine();

        return HeroFactory.createHero(type, name);
    }

    private static void addObservers(Hero hero) {
        hero.addObserver(new BattleLogger());
        hero.addObserver(new GameAnnouncer());
        hero.addObserver(new HealthMonitoring());
    }

    private static void displayStatus(Hero hero1, Hero hero2) {
        System.out.println("STATUS OF THE BATTLE HEROES: ");
        System.out.println("----------------------------------------");
        System.out.println(hero1.getName() + ": Lvl " + hero1.getLevel() +
                " | HP " + hero1.getHealth() + " | DMG " + hero1.getBaseDamage());
        System.out.println(hero2.getName() + ": Lvl " + hero2.getLevel() +
                " | HP " + hero2.getHealth() + " | DMG " + hero2.getBaseDamage());
        System.out.println("----------------------------------------");
    }

    private static void selectAction(Scanner scanner, Hero currentHero, Hero targetHero) {
        String choice;
        boolean actionTaken = false;

        System.out.println("Attack " + currentHero.getName() + ":");
        System.out.print("Enter the number 1 for attack: ");

        while (!actionTaken) {
            choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    currentHero.attack(targetHero);
                    actionTaken = true;
                    System.out.println("----------------------------------------");
                    break;
                default:
                    System.out.print("Invalid choice! Please try again!");
                    break;
            }
        }
    }
}