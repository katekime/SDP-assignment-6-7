package Heroes;

import Strategy.Strategy;

public class Warrior extends Hero{
    public Warrior(String name, int level, int health, Strategy attackStrategy, int baseDamage) {
        super(name, level, health, attackStrategy,  baseDamage);
    }
}
