package com.api;

import com.api.config.Config;
import com.api.config.ConfigurationManager;
import com.api.core.ServerListenerThread;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.logging.Logger;

public class HttpServer {

    private static final Logger logger = Logger.getLogger(HttpServer.class.getName());

    public static void main( String[] args ) throws Exception {

        logger.info("Server started...");
        ConfigurationManager.getInstance().loadConfigurationFile("src/main/resources/portconfig.json");
        Config config = ConfigurationManager.getInstance().getCurrentConfigurationFile();

        logger.info("Using Port: " + config.getPort());
        logger.info("Using Webroot: " + config.getWebroot());

        try {
            ServerListenerThread serverListenerThread = new ServerListenerThread(config.getPort(), config.getWebroot());
            serverListenerThread.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
