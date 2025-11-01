package Decorators;

import Heroes.Hero;

public class LevelUpDecorator extends HeroDecorator {
    private int bonusDamage;

    public LevelUpDecorator(Hero hero, int bonusDamage) {
        super(hero);
        this.bonusDamage = bonusDamage;
    }

    @Override
    public void attack(Hero target) {
//        decoratedHero.notifyObservers(decoratedHero.getName() + "user leveled up and beat with bonus damage " + bonusDamage);
        decoratedHero.attack(target);

//        target.attacked(bonusDamage);
//        decoratedHero.notifyObservers(decoratedHero.getName() + " has been attacked with " + bonusDamage);
    }
}
