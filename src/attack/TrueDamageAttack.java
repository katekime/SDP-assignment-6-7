package attack;

import Heroes.*;
import Strategy.Strategy;

public class TrueDamageAttack implements Strategy {
    public void attack(Hero attacker, Hero target) {
        int damage = attacker.getBaseDamage();
        target.attacked(damage);
        attacker.notifyObservers("LOG  |  ATTACK  |  " + attacker.getName() + " punched with true damage a " + target.getName() + " for " + damage + " damage.");
        int expGained = damage / 2;
        attacker.earnExp(expGained);
    }
}
