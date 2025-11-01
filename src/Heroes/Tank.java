package Heroes;

import Strategy.Strategy;

public class Tank extends Hero{
    public Tank(String name, int level, int health, Strategy attackStrategy, int baseDamage) {
        super(name, level, health, attackStrategy, baseDamage);
    }
}
