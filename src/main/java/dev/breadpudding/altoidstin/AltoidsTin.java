package dev.breadpudding.altoidstin;

import dev.breadpudding.altoidstin.entities.penguin.Penguin;
import dev.breadpudding.altoidstin.items.HashBrown;
import dev.breadpudding.altoidstin.items.PotatoShreds;
import dev.breadpudding.altoidstin.items.TrappedOres;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerWorldEvents;

/**
 * An Altoids tin filled with insanity
 * 
 * @author Alexander Hill
 */
public class AltoidsTin implements ModInitializer {
    /**
     * The ID used to separate our stuff from the rest of the game
     * 
     * Example: altoidstin:hash_brown
     * 
     * @author Alexander Hill
     */
    public static final String MOD_ID = "altoidstin";

    /**
     * Initializes the mod and registers components with the modloader
     */
    @Override
    public void onInitialize() {
        HashBrown.register();
        PotatoShreds.register();
        TrappedOres.register();

        // Entities
        Penguin.register();
        // ...
    }
}