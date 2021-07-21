package dev.breadpudding.altoidstin;

import net.fabricmc.api.ModInitializer;

public class AltoidsTin implements ModInitializer {
    public static final String MOD_ID = "altoidstin";

    @Override
    public void onInitialize() {
        HashBrown.register();
        // ...
    }
}