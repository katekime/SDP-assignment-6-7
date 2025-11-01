package Heroes;

import Strategy.Strategy;

public class Mage extends Hero{
    public Mage(String name, int level, int health, Strategy attackStrategy, int baseDamage) {
        super(name, level, health, attackStrategy, baseDamage);
    }
}
