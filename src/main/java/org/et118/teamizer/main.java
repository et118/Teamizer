package org.et118.teamizer;

import net.fabricmc.api.ClientModInitializer;

import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.et118.teamizer.GUI.MenuScreen;

public class main implements ClientModInitializer {

    public static Logger LOGGER = LogManager.getLogger();

    public static final String MOD_ID = "teamizer";
    public static final String MOD_NAME = "Teamizer";

    public static final MinecraftClient MC = MinecraftClient.getInstance();
    public static final MenuScreen menuScreen = new MenuScreen(Text.of("Menu"),MC);
    public FileManager fileManager;
    public KeypressManager keypressManager;

    @Override
    public void onInitializeClient() {
        log(Level.INFO, "Initializing Teamizer");

        fileManager = new FileManager(MC);
        fileManager.initializeFiles();
        keypressManager = new KeypressManager(MC);
    }

    public static void log(Level level, String message){
        LOGGER.log(level, "["+MOD_NAME+"] " + message);
    }

}