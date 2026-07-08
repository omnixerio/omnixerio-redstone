package dev.ultreon.mods.redstone;

import dev.architectury.utils.Env;
import dev.architectury.utils.EnvExecutor;
import dev.ultreon.mods.redstone.client.OmnixerioRedstoneClient;
import dev.ultreon.mods.redstone.init.ModBlockEntityTypes;
import dev.ultreon.mods.redstone.init.ModBlocks;
import dev.ultreon.mods.redstone.init.ModCreativeTabs;
import dev.ultreon.mods.redstone.init.ModItems;
import net.minecraft.resources.Identifier;

public final class OmnixerioRedstone {
    public static final String MOD_ID = "omnixerio-redstone";

    public static void init() {
        // Write common init code here.

        // Register our blocks and items.
        ModBlocks.init();
        ModBlockEntityTypes.init();
        ModItems.init();
        ModCreativeTabs.init();

        EnvExecutor.runInEnv(Env.CLIENT, () -> () -> OmnixerioRedstoneClient.init());
    }

    public static Identifier id(String path) {
        return Identifier.fromNamespaceAndPath(MOD_ID, path);
    }
}
