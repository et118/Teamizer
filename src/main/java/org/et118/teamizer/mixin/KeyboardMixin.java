package org.et118.teamizer.mixin;

import net.minecraft.client.Keyboard;
import net.minecraft.client.MinecraftClient;
import org.et118.teamizer.KeypressManager;
import org.et118.teamizer.main;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Keyboard.class)
public class KeyboardMixin {
    @Inject(at = @At("HEAD"), method = "onKey(JIIII)V")
    private void onKey(long window, int key, int scancode, int inputType, int shiftControl, CallbackInfo ci) {
        if((Long)window != null || MinecraftClient.getInstance() != null) {
            if(window == main.MC.getWindow().getHandle()) {
                KeypressManager.keypress(key,inputType,shiftControl);
            }

        }
    }
}
