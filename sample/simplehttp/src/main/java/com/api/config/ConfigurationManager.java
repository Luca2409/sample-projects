package com.api.config;

import com.api.util.Json;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class ConfigurationManager {

    private static ConfigurationManager myConfigurationManager;
    private static Config myCurrentConfig;

    public ConfigurationManager() {
    }

    public static ConfigurationManager getInstance() {
        if (myConfigurationManager == null) {
            myConfigurationManager = new ConfigurationManager();
        }
        return myConfigurationManager;
    }

    public void loadConfigurationFile(String filePath) {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(filePath);
        } catch (FileNotFoundException e) {

                throw new HttpConfigException(e);
        }
        StringBuffer sb = new StringBuffer();
        int i;
        try {
            while ((i = fileReader.read()) != -1) {
                sb.append((char) i);
            }
        } catch (IOException e) {
            throw new HttpConfigException(e);
        }
        JsonNode config = null;
        try {
            config = Json.parse(sb.toString());
        } catch (JsonProcessingException e) {
            throw new HttpConfigException(e);
        }
        try {
            myCurrentConfig = Json.fromJson(config, Config.class);
        } catch (JsonProcessingException e) {
            throw new HttpConfigException(e);
        }

    }

    public Config getCurrentConfigurationFile() throws Exception {
        if (myCurrentConfig == null) {
            throw new HttpConfigException("No current configuration set.");
        }
        return myCurrentConfig;
    }
}
