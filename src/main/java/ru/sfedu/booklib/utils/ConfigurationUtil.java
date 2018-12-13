/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sfedu.booklib.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 *
 * @author BBJ
 */
public class ConfigurationUtil {
    private String defaultConfigPath;

    private Properties configuration = new Properties();

    /**
     * Hides default constructor
     */
    public ConfigurationUtil(String configPath) throws IllegalArgumentException {
        if (configPath == null) {
            throw new IllegalArgumentException("configPath cannot be NULL");
        }
        this.defaultConfigPath = configPath;
    }


    private Properties getConfiguration() throws IOException {
        if (configuration.isEmpty()) {
            loadConfiguration();
        }
        return configuration;
    }

    /**
     * Loads configuration from <code>defaultConfigPath</code>
     */
    private void loadConfiguration() {
        try (InputStream in = ConfigurationUtil.class.getResourceAsStream(defaultConfigPath)) {
            configuration.load(new InputStreamReader(in, "UTF-8"));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * Gets configuration entry value
     *
     * @param key Entry key
     * @return Entry value by key
     */
    public String readConfig(String key) {
        try {
            return getConfiguration().getProperty(key);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
