package Heroes;

import Factory.HeroInterfaceFactory;
import Observer.Observer;
import Strategy.Strategy;

import java.util.ArrayList;
import java.util.List;

public abstract class Hero{
    private String name;
    private int level;
    private int baseDamage;
    private int health;
    private int exp;
    private int needExpToNextLevel;
    private Strategy attackStrategy;
    private List<Observer> observers = new ArrayList<>();

    public Hero(String name, int level, int health, Strategy attackStrategy, int baseDamage) {
        this.name = name;
        this.level = level;
        this.health = health;
        this.attackStrategy = attackStrategy;
        this.baseDamage = baseDamage;
        this.exp = 0;
        this.needExpToNextLevel = 10 * level;
    }
    public void earnExp(int amount) {
        this.exp += amount;

        notifyObservers("EXP  |  " + name  + " | EXP: " + exp + " | need EXP to next lvl: " + needExpToNextLevel);

        while(exp >= needExpToNextLevel) {
            levelUp();
        }
    }
    public int getBaseDamage() {
        return baseDamage;
    }
    public void setBaseDamage(int baseDamage) {
        this.baseDamage = baseDamage;
    }
    public void levelUp() {
        this.level += 1;
        this.health += 20;
        this.baseDamage += 10;

        int oldNeedExp = this.needExpToNextLevel;
        this.needExpToNextLevel = 10 * this.level;
        this.exp -= oldNeedExp;
        notifyObservers("LEVELUP | " + name + "|" + level + "|" + health + "|" + baseDamage + "|" + exp + "|" + needExpToNextLevel);
    }
    public String getName() {
        return name;
    }
    public boolean isAlive() {
        return health > 0;
    }

    public int getLevel() {
        return level;
    }

    public void attacked(int damage) {
        health = health - damage;
         if(health < 0) {
             health = 0;
         }
        notifyObservers("ATTACKED  |  " + name + "|" + damage + "|" + health);

         if(health == 0) {
             notifyObservers("DEFEAT  |  " + name);
         }
    }

    public void addObserver(Observer news) {
        observers.add(news);
    }

    public void notifyObservers(String message) {
        for(int i = 0; i< observers.size(); i++) {
            Observer news = observers.get(i);
            news.update(message);
        }
    }
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Strategy getAttackStrategy() {
        return attackStrategy;
    }

    public void setAttackStrategy(Strategy attackStrategy) {
        this.attackStrategy = attackStrategy;
    }

    public void attack(Hero target) {
        if(isAlive()) {
            attackStrategy.attack(this, target);
        }
    }

}
