import Thread.ServerListenerThread;
import config.WebConfigManager;

public class Main {
    public static void main(String[] args) {

        // Could be static!
        WebConfigManager config = new WebConfigManager();
        config.setConfiguration();

        try {
            ServerListenerThread serverListenerThread = new ServerListenerThread(config);
            serverListenerThread.start();
        } catch (Exception e) {
            System.out.println("Failed.");
        }
    }
}