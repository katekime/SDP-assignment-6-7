package ObserverImplementations;

import Observer.Observer;

public class BattleLogger implements Observer {
    @Override
    public void update(String message) {
        if (message.startsWith("LOG  |  ") || message.startsWith("EXP  |  ") || message.startsWith("DEFEAT  |  ")) {
            System.out.println("BAttleLOGGER: " + message);
        }
    }
}
