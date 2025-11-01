package ObserverImplementations;
import Observer.*;

public class HealthMonitoring implements Observer{
    @Override
    public void update(String message) {
        String[] data = message.split("\\|");
        if (data[0].trim().equals("ATTACKED")) {
            String heroName = data[1].trim();
            int currentHealth = Integer.parseInt(data[3].trim());
        }
    }
}
