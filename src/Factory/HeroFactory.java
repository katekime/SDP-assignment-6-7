package Factory;

import Heroes.Hero;
import Heroes.*;
import attack.*;
import Strategy.*;

public class HeroFactory {
    public static Hero createHero(String type, String name) {
        Hero newHero;
        switch (type) {
            case "Warrior":
                newHero = new Warrior(name, 1, 120, new PhysicalAttack(), 15);
                return newHero;
            case "Mage":
                newHero = new Mage(name, 1, 100, new MagicAttack(),20);
                return newHero;
            case "Support":
                newHero = new Support(name, 1, 90, new TrueDamageAttack(),5);
                return newHero;
            case "Tank":
                newHero = new Tank(name, 1, 150, new PhysicalAttack(),5);
                return newHero;
            case "Archer":
                newHero = new Archer(name, 1, 100, new PhysicalAttack(),30);
                return newHero;
            default: throw new  IllegalArgumentException("Invalid type");
        }
    }
}
