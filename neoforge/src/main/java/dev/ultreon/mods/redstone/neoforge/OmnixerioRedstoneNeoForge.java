package dev.ultreon.mods.redstone.neoforge;

import dev.ultreon.mods.redstone.OmnixerioRedstone;
import net.neoforged.fml.common.Mod;

@Mod(OmnixerioRedstone.MOD_ID)
public final class OmnixerioRedstoneNeoForge {
    public OmnixerioRedstoneNeoForge() {
        // Run our common setup.
        OmnixerioRedstone.init();
    }
}
