package org.et118.teamizer.GUI;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;

import java.awt.*;

public class MenuScreen extends Screen {
    private MinecraftClient MC;

    public MenuScreen(Text title, MinecraftClient MC) {
        super(title);
        this.MC = MC;
        //this.BackgroundImage = new Identifier(main.MOD_ID + ":icon.png");
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        //Background
        int ARGB = new Color(0, 0, 0, 191).getRGB();
        this.fillGradient(matrices, 10, 10, this.width-10, this.height-10, ARGB, ARGB);

        //Draw Tabs
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
