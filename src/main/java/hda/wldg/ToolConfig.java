/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hda.wldg;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author daan
 */
public class ToolConfig {

    private static Properties prop = null;

    private static String defaultUsername;
    private static String defaultPassword;

    static {
        init();
    }

    static void init() {
        prop = new Properties();
        try {
            prop.load(ToolConfig.class.getResourceAsStream("/config.properties"));
//            prop.load(new FileInputStream("/config.properties"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ToolConfig.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ToolConfig.class.getName()).log(Level.SEVERE, null, ex);
        }
        defaultUsername = prop.getProperty("default.username");
        defaultPassword = prop.getProperty("default.password");
    }

    public static String[] getDomainList() {

        String domainList = prop.getProperty("domainList");

        return domainList.split(",");
    }

    public static String getAdminUrl(String name) {
        return prop.getProperty(name + ".adminurl");
    }

    public static String getUsername(String name) {
        return prop.getProperty(name + ".username", defaultUsername);
    }

    public static String getPassword(String name) {
        return prop.getProperty(name + ".password", defaultPassword);
    }

    public static String getName(String name) {
        return prop.getProperty(name + ".name", name);
    }

    public static String getTargets(String name) {
        return prop.getProperty(name + ".targets");
    }

    public static String getWeblogicJarLocation() {
        return prop.getProperty("weblogic.jar");
    }
}
