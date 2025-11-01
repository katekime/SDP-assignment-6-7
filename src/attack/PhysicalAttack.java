package attack;

import Heroes.*;
import Strategy.Strategy;

public class PhysicalAttack implements Strategy {
    public void attack(Hero attacker, Hero target) {
        int damage = attacker.getBaseDamage();
        target.attacked(damage);
        attacker.notifyObservers("LOG  |  ATTACK  |  " + attacker.getName() + " beat a " + target.getName() + " for " + damage + " damage.");
        int expGained = damage / 2;
        attacker.earnExp(expGained);
    }
}
