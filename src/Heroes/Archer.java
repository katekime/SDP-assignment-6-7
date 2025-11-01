package Heroes;

import Strategy.Strategy;

public class Archer extends Hero{
    public Archer(String name, int level, int health, Strategy attackStrategy, int baseDamage) {
        super(name, level, health, attackStrategy, baseDamage);
    }

}
