package attack;

import Heroes.*;
import Strategy.Strategy;

public class MagicAttack implements Strategy {
    @Override
    public void attack(Hero attacker, Hero target) {
        int damage = attacker.getBaseDamage();
        target.attacked(damage);
        attacker.notifyObservers("LOG  |  ATTACK  |  " + attacker.getName() + " cast a spell at " + target.getName() + " for " + damage + " damage.");
        int expGained = damage / 2;
        attacker.earnExp(expGained);
    }
}
