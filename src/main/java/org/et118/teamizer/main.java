package org.et118.teamizer;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.MinecraftClientGame;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class main implements ClientModInitializer {

    public static Logger LOGGER = LogManager.getLogger();

    public static final String MOD_ID = "teamizer";
    public static final String MOD_NAME = "Teamizer";
    public final MinecraftClient MC = MinecraftClient.getInstance();

    public FileManager fileManager;

    @Override
    public void onInitializeClient() {
        log(Level.INFO, "Initializing Teamizer");

        fileManager = new FileManager(MC);
        fileManager.initializeFiles();

    }

    public static void log(Level level, String message){
        LOGGER.log(level, "["+MOD_NAME+"] " + message);
    }

}