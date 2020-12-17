package org.et118.teamizer;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import org.et118.teamizer.GUI.MenuScreen;


public class KeypressManager {
    private MinecraftClient MC;

    public KeypressManager(MinecraftClient MC) {
        this.MC = MC;
    }

    public static void keypress(int key, int inputType, int shiftControl) {
        //Inputtype 0 = Keyup, 1 = keydown, 2 = hold key
        //shiftControl 0 = nothing, 1 = shift, 2 = control
        if(main.MC.currentScreen == null) {
            if(inputType == 0 && (char)key == 'H') {
                main.MC.openScreen(main.menuScreen);
            }

        } else if(main.MC.currentScreen instanceof MenuScreen) {
            if(inputType == 0 && (char)key == 'H') {
                main.MC.openScreen((Screen) null);
            }
        }

    }
}
