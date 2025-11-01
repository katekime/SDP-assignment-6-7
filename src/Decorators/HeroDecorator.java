package Decorators;

import Heroes.Hero;
import Strategy.Strategy;

public abstract class HeroDecorator extends Hero {
    protected Hero decoratedHero;
    public HeroDecorator(Hero hero) {
        super(hero.getName(), hero.getLevel(), hero.getHealth(), hero.getAttackStrategy(),hero.getBaseDamage());
        this.decoratedHero = hero;
    }

    @Override
    public void attacked(int damage) {
        decoratedHero.attacked(damage);
    }
    @Override
    public void attack(Hero target) {
        decoratedHero.attack(target);
    }
    @Override
    public void addObserver(Observer.Observer observer) {
        decoratedHero.addObserver(observer);
    }
    @Override
    public void notifyObservers(String message) {
        decoratedHero.notifyObservers(message);
    }
    @Override
    public boolean isAlive() {
        return decoratedHero.isAlive();
    }
    @Override
    public int getHealth() {
        return decoratedHero.getHealth();
    }

    @Override
    public Strategy getAttackStrategy() {
        return decoratedHero.getAttackStrategy();
    }
}
