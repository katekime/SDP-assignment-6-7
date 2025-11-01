package Heroes;

import Strategy.Strategy;

public class Support extends Hero{
    public Support(String name, int level, int health, Strategy attackStrategy, int baseDamage) {
        super(name, level, health, attackStrategy, baseDamage);
    }
}
