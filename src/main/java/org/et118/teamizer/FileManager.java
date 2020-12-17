package org.et118.teamizer;

import net.minecraft.client.MinecraftClient;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileManager {

    private MinecraftClient MC;
    private SettingsManager settingsManager;

    private Path minecraftFolder;
    private Path teamizerFolder;


    public FileManager(MinecraftClient MC, SettingsManager settingsManager) {
        this.MC = MC;
        this.settingsManager = settingsManager;
    }

    private boolean fileExists(String file) {
        return teamizerFolder.resolve(file).toFile().exists();
    }

    private void createFolders(Path path) throws IOException{
        Files.createDirectories(path);
    }

    public void initializeFiles() {
        minecraftFolder = MC.runDirectory.toPath().normalize();
        teamizerFolder = minecraftFolder.resolve("teamizer");
        try {
            createFolders(teamizerFolder);

            if(!fileExists("settings.json")) {
                settingsManager.restoreSettings(this);
            } else {
                settingsManager.loadSettings(this);
            }
        } catch(IOException e) {
            throw new RuntimeException("Could not create file or folder",e);
        }
    }

    public void saveJSON(String name, JSONArray json) {
        Path filePath = teamizerFolder.resolve(name);
        try {
            Files.createDirectories(filePath.getParent());
        } catch(IOException e) {
            e.printStackTrace();
        }

        try(FileWriter file = new FileWriter(filePath.toFile())) {

            file.write(json.toJSONString());
            file.flush();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public JSONArray loadJSON(String name) {
        JSONArray array = null;
        Path filePath = teamizerFolder.resolve(name);
        JSONParser parser = new JSONParser();
        try(FileReader reader = new FileReader(filePath.toFile())) {
            Object obj = parser.parse(reader);
            array = (JSONArray) obj;
        } catch(IOException | ParseException e) {
            e.printStackTrace();
        }
        return array;
    }


}
