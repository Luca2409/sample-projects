package config;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


public class WebConfigManager {

    public static final ObjectMapper mapper = new ObjectMapper();


    private int port;
    private String webroot;

    public void loadWebConfigJson(String path) throws JsonProcessingException {
        JsonNode webConfigJson = mapper.readTree(path);
    }




    public WebConfigManager(){}

    public WebConfigManager(int port, String webroot) {
        this.port = port;
        this.webroot = webroot;
    }

    public int getPort() {
        return this.port;
    }

    public String getWebRoot() {
        return this.webroot;
    }

    public void setConfiguration() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please configure Port:");
        this.port = scanner.nextInt(); 
        System.out.println("Port: " + this.port + " in use.");

        System.out.println("Please configure webroot. To skip, type 1 else type 2: ");
        int s = scanner.nextInt();
        scanner.nextLine();

        if (s == 1) {

            this.webroot = "";
        } else if (s == 2) {

            
            System.out.println("Specify webroot: ");
            this.webroot = scanner.nextLine();
            System.out.println("Webroot specified to: " + this.webroot);

        }

        scanner.close();
    }


    public Map<String, Object> getConfiguration() {

        Map<String, Object> config = new HashMap<>();

        config.put("Port", port);
        config.put("Webroot", webroot);

        return config;
    }


    
}
