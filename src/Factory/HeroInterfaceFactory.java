package Factory;

import Heroes.Hero;

public interface HeroInterfaceFactory {
    void attacked(int damage);
    void attack(Hero target);
    boolean isAlive();
    String getName();
    int getHealth();
}
