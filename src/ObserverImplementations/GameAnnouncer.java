package ObserverImplementations;

import Observer.Observer;
public class GameAnnouncer implements Observer{
    @Override
    public void update(String message) {
        String[] data = message.split("\\|");
        String type = data[0].trim();

        switch(type) {
            case "LEVELUP":
                System.out.println("Announcer: CONGRATULATIONS! " + data[1].trim() + " reached level: " + data[2].trim() + "!");
                System.out.println("   New characteristics: HP: " + data[3].trim() + ", Damage: " + data[4].trim() +
                        ". Next lvl after: " + data[6].trim() + " EXP.");
                break;
            case "DEFEAT":
                System.out.println("Announcer: Oh no! " + data[1] + " was fallen in the battle");
                break;
            case "EXP":
                System.out.println("Announcer: " + data[1] + " get " + data[2] + " exp. Total: " + data[3]);
                break;
            case "LOG":
                System.out.println("Announcer: " + data[2]);
                break;
        }
    }
}
