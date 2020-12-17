package org.et118.teamizer;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.lwjgl.system.CallbackI;

import java.io.File;
import java.util.Iterator;

public class SettingsManager {
    private JSONArray settings;
    public SettingsManager() {
        this.settings = null;
    }

    private JSONArray getDefaultSettings() {
        JSONArray settings = new JSONArray();

        JSONObject test1Setting = new JSONObject();
        test1Setting.put("Name","Test1");
        test1Setting.put("Why","yes");
        test1Setting.put(1,"das");
        settings.add(test1Setting);

        JSONObject test2Setting = new JSONObject();
        test2Setting.put("Name","Test2");
        test2Setting.put("White","255 255 255");
        settings.add(test2Setting);

        return settings;
    }

    public void loadSettings(FileManager fileManager) {
        settings = fileManager.loadJSON("settings.json");
    }

    public void saveSettings(FileManager fileManager) {
        fileManager.saveJSON("settings.json",settings);
    }

    public void restoreSettings(FileManager fileManager) {
        settings = getDefaultSettings();
        fileManager.saveJSON("settings.json",settings);
    }

    public Object getSetting(String parentSetting,String settingName) {
        Object value = null;
        Iterator iter = settings.iterator();
        while(iter.hasNext()) {
            JSONObject setting = (JSONObject) iter.next();
            if(setting.get("Name").toString().equals(parentSetting)) {
                value = setting.get(settingName);
                break;
            }
        }
        return value;
    }

    public void setSetting(String parentSetting,String settingName, String value) {
        Iterator iter = settings.iterator();
        while (iter.hasNext()) {
            JSONObject setting = (JSONObject) iter.next();
            if(setting.get("Name").toString().equals(parentSetting)) {
                setting.replace(settingName,value);
                break;
            }
        }
    }
}
