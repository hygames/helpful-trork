package co.hygames.helpfultrork;

import discord4j.core.DiscordClient;
import discord4j.core.DiscordClientBuilder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Trork {
    private static String token;
    static Trork instance;

    public static void main(String [] arguments) {
        instance = new Trork();
        loadConfig();
        DiscordClient client = new DiscordClientBuilder(token).build();
        new ReadyListener(instance, client);
        new Ping(client);
        new RoleAssignment(instance, client);
        client.login().block();
    }

    private static void loadConfig() {
        try {
            Properties properties = new Properties();
            File config = new File("config.properties");
            if (!config.exists()) {
                config.createNewFile();
                FileOutputStream fos = new FileOutputStream("config.properties");
                properties.put("token", "");
                properties.store(fos, " Your bot token");
                fos.flush();
                fos.close();
            }
            FileInputStream input = new FileInputStream("config.properties");
            properties.load(input);
            token = properties.getProperty("token");
            if (token == null || token.isEmpty()) {
                System.out.println("Please set a token in config.properties");
                System.exit(1);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    void loggedIn() {
        // ToDo
    }
}
