package dev.ultreon.mods.redstone.datagen;

import dev.ultreon.mods.redstone.init.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

import static net.minecraft.advancements.triggers.InventoryChangeTrigger.TriggerInstance.hasItems;

public class RedstoneRecipeProvider extends FabricRecipeProvider {
    public RedstoneRecipeProvider(FabricPackOutput dataGenerator, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(dataGenerator, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        return new MyRecipeProvider(registries, output);
    }

    @Override
    public String getName() {
        return "Omnixerio Redstone Recipe Provider";
    }

    private static class MyRecipeProvider extends RecipeProvider {
        public MyRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
            super(registries, output);
        }

        @Override
        public void buildRecipes() {
            shaped(RecipeCategory.MISC, ModItems.TIMER.get(), 1)
                    .pattern("rcr")
                    .pattern("ppp")
                    .define('r', Items.REDSTONE)
                    .define('c', Items.CLOCK)
                    .define('p', Items.STONE)
                    .unlockedBy("has_clock", hasItems(Items.CLOCK))
                    .save(output);

            shaped(RecipeCategory.MISC, ModItems.SWITCH.get(), 1)
                    .pattern("rlr")
                    .pattern("ppp")
                    .define('r', Items.REDSTONE)
                    .define('l', Items.LEVER)
                    .define('p', Items.STONE)
                    .unlockedBy("has_lever", hasItems(Items.LEVER))
                    .save(output);

            shaped(RecipeCategory.MISC, ModItems.OR_GATE.get(), 1)
                    .pattern(" r ")
                    .pattern("rrr")
                    .pattern("ppp")
                    .define('r', Items.REDSTONE)
                    .define('p', Items.STONE)
                    .unlockedBy("has_redstone", hasItems(Items.REDSTONE))
                    .save(output);

            shaped(RecipeCategory.MISC, ModItems.AND_GATE.get(), 1)
                    .pattern(" t ")
                    .pattern("trt")
                    .pattern("ppp")
                    .define('r', Items.REDSTONE)
                    .define('t', Items.REDSTONE_TORCH)
                    .define('p', Items.STONE)
                    .unlockedBy("has_redstone", hasItems(Items.REDSTONE))
                    .save(output);

            shaped(RecipeCategory.MISC, ModItems.NAND_GATE.get(), 1)
                    .pattern(" t ")
                    .pattern("ttt")
                    .pattern("prp")
                    .define('r', Items.REDSTONE)
                    .define('t', Items.REDSTONE_TORCH)
                    .define('p', Items.STONE)
                    .unlockedBy("has_redstone", hasItems(Items.REDSTONE))
                    .save(output);

            shaped(RecipeCategory.MISC, ModItems.XOR_GATE.get(), 1)
                    .pattern(" r ")
                    .pattern("rrr")
                    .pattern("ptp")
                    .define('r', Items.REDSTONE)
                    .define('t', Items.REDSTONE_TORCH)
                    .define('p', Items.STONE)
                    .unlockedBy("has_redstone", hasItems(Items.REDSTONE))
                    .save(output);

            shaped(RecipeCategory.MISC, ModItems.XNOR_GATE.get(), 1)
                    .pattern(" r ")
                    .pattern("rtr")
                    .pattern("prp")
                    .define('r', Items.REDSTONE)
                    .define('t', Items.REDSTONE_TORCH)
                    .define('p', Items.STONE)
                    .unlockedBy("has_redstone", hasItems(Items.REDSTONE))
                    .save(output);

            shaped(RecipeCategory.MISC, ModItems.NOT_GATE.get(), 1)
                    .pattern(" r ")
                    .pattern(" t ")
                    .pattern("ppp")
                    .define('r', Items.REDSTONE)
                    .define('t', Items.REDSTONE_TORCH)
                    .define('p', Items.STONE)
                    .unlockedBy("has_redstone", hasItems(Items.REDSTONE))
                    .save(output);

            shaped(RecipeCategory.MISC, ModItems.NOR_GATE.get(), 1)
                    .pattern(" r ")
                    .pattern("rtr")
                    .pattern("ppp")
                    .define('r', Items.REDSTONE)
                    .define('t', Items.REDSTONE_TORCH)
                    .define('p', Items.STONE)
                    .unlockedBy("has_redstone", hasItems(Items.REDSTONE))
                    .save(output);

            shaped(RecipeCategory.MISC, ModItems.PULSE_EXTENDER.get(), 1)
                    .pattern(" r ")
                    .pattern(" c ")
                    .pattern("ppp")
                    .define('r', Items.REDSTONE)
                    .define('c', Items.COPPER_INGOT)
                    .define('p', Items.STONE)
                    .unlockedBy("has_redstone", hasItems(Items.REDSTONE))
                    .save(output);

            // Jungle
            shaped(RecipeCategory.MISC, ModItems.PULSE_GENERATOR.get(), 1)
                    .pattern(" r ")
                    .pattern(" g ")
                    .pattern("ppp")
                    .define('r', Items.REDSTONE)
                    .define('g', Items.GOLD_INGOT)
                    .define('p', Items.STONE)
                    .unlockedBy("has_stripped_jungle_log", hasItems(Items.STRIPPED_JUNGLE_LOG))
                    .save(output);

            shaped(RecipeCategory.MISC, ModItems.D_FLIP_FLOP.get(), 1)
                    .pattern("grg")
                    .pattern("ppp")
                    .define('r', Items.REDSTONE)
                    .define('g', Items.GOLD_INGOT)
                    .define('p', Items.STONE)
                    .unlockedBy("has_stripped_jungle_log", hasItems(Items.STRIPPED_JUNGLE_LOG))
                    .save(output);

            shaped(RecipeCategory.MISC, ModItems.JK_FLIP_FLOP.get(), 1)
                    .pattern(" g ")
                    .pattern("grg")
                    .pattern("ppp")
                    .define('r', Items.REDSTONE)
                    .define('g', Items.GOLD_INGOT)
                    .define('p', Items.STONE)
                    .unlockedBy("has_stripped_jungle_log", hasItems(Items.STRIPPED_JUNGLE_LOG))
                    .save(output);

            // Acacia
            shaped(RecipeCategory.MISC, ModItems.SR_LATCH.get(), 1)
                    .pattern("crc")
                    .pattern("ppp")
                    .define('r', Items.REDSTONE)
                    .define('c', Items.COPPER_INGOT)
                    .define('p', Items.STONE)
                    .unlockedBy("has_stripped_acacia_log", hasItems(Items.STRIPPED_ACACIA_LOG))
                    .save(output);

            shapeless(RecipeCategory.MISC, ModItems.WHITE_REDSTONE_LAMP.get(), 1)
                    .requires(Items.REDSTONE_LAMP)
                    .requires(Items.DYE.white())
                    .unlockedBy("has_redstone_lamp", hasItems(Items.REDSTONE_LAMP))
                    .save(output);

            shapeless(RecipeCategory.MISC, ModItems.ORANGE_REDSTONE_LAMP.get(), 1)
                    .requires(Items.REDSTONE_LAMP)
                    .requires(Items.DYE.orange())
                    .unlockedBy("has_redstone_lamp", hasItems(Items.REDSTONE_LAMP))
                    .save(output);

            shapeless(RecipeCategory.MISC, ModItems.MAGENTA_REDSTONE_LAMP.get(), 1)
                    .requires(Items.REDSTONE_LAMP)
                    .requires(Items.DYE.magenta())
                    .unlockedBy("has_redstone_lamp", hasItems(Items.REDSTONE_LAMP))
                    .save(output);

            shapeless(RecipeCategory.MISC, ModItems.LIGHT_BLUE_REDSTONE_LAMP.get(), 1)
                    .requires(Items.REDSTONE_LAMP)
                    .requires(Items.DYE.lightBlue())
                    .unlockedBy("has_redstone_lamp", hasItems(Items.REDSTONE_LAMP))
                    .save(output);

            shapeless(RecipeCategory.MISC, ModItems.YELLOW_REDSTONE_LAMP.get(), 1)
                    .requires(Items.REDSTONE_LAMP)
                    .requires(Items.DYE.yellow())
                    .unlockedBy("has_redstone_lamp", hasItems(Items.REDSTONE_LAMP))
                    .save(output);

            shapeless(RecipeCategory.MISC, ModItems.LIME_REDSTONE_LAMP.get(), 1)
                    .requires(Items.REDSTONE_LAMP)
                    .requires(Items.DYE.lime())
                    .unlockedBy("has_redstone_lamp", hasItems(Items.REDSTONE_LAMP))
                    .save(output);

            shapeless(RecipeCategory.MISC, ModItems.PINK_REDSTONE_LAMP.get(), 1)
                    .requires(Items.REDSTONE_LAMP)
                    .requires(Items.DYE.pink())
                    .unlockedBy("has_redstone_lamp", hasItems(Items.REDSTONE_LAMP))
                    .save(output);

            shapeless(RecipeCategory.MISC, ModItems.GRAY_REDSTONE_LAMP.get(), 1)
                    .requires(Items.REDSTONE_LAMP)
                    .requires(Items.DYE.gray())
                    .unlockedBy("has_redstone_lamp", hasItems(Items.REDSTONE_LAMP))
                    .save(output);

            shapeless(RecipeCategory.MISC, ModItems.LIGHT_GRAY_REDSTONE_LAMP.get(), 1)
                    .requires(Items.REDSTONE_LAMP)
                    .requires(Items.DYE.lightGray())
                    .unlockedBy("has_redstone_lamp", hasItems(Items.REDSTONE_LAMP))
                    .save(output);

            shapeless(RecipeCategory.MISC, ModItems.CYAN_REDSTONE_LAMP.get(), 1)
                    .requires(Items.REDSTONE_LAMP)
                    .requires(Items.DYE.cyan())
                    .unlockedBy("has_redstone_lamp", hasItems(Items.REDSTONE_LAMP))
                    .save(output);

            shapeless(RecipeCategory.MISC, ModItems.PURPLE_REDSTONE_LAMP.get(), 1)
                    .requires(Items.REDSTONE_LAMP)
                    .requires(Items.DYE.purple())
                    .unlockedBy("has_redstone_lamp", hasItems(Items.REDSTONE_LAMP))
                    .save(output);

            shapeless(RecipeCategory.MISC, ModItems.BLUE_REDSTONE_LAMP.get(), 1)
                    .requires(Items.REDSTONE_LAMP)
                    .requires(Items.DYE.blue())
                    .unlockedBy("has_redstone_lamp", hasItems(Items.REDSTONE_LAMP))
                    .save(output);

            shapeless(RecipeCategory.MISC, ModItems.BROWN_REDSTONE_LAMP.get(), 1)
                    .requires(Items.REDSTONE_LAMP)
                    .requires(Items.DYE.brown())
                    .unlockedBy("has_redstone_lamp", hasItems(Items.REDSTONE_LAMP))
                    .save(output);

            shapeless(RecipeCategory.MISC, ModItems.GREEN_REDSTONE_LAMP.get(), 1)
                    .requires(Items.REDSTONE_LAMP)
                    .requires(Items.DYE.green())
                    .unlockedBy("has_redstone_lamp", hasItems(Items.REDSTONE_LAMP))
                    .save(output);

            shapeless(RecipeCategory.MISC, ModItems.RED_REDSTONE_LAMP.get(), 1)
                    .requires(Items.REDSTONE_LAMP)
                    .requires(Items.DYE.red())
                    .unlockedBy("has_redstone_lamp", hasItems(Items.REDSTONE_LAMP))
                    .save(output);

            shapeless(RecipeCategory.MISC, ModItems.BLACK_REDSTONE_LAMP.get(), 1)
                    .requires(Items.REDSTONE_LAMP)
                    .requires(Items.DYE.black())
                    .unlockedBy("has_redstone_lamp", hasItems(Items.REDSTONE_LAMP))
                    .save(output);

    }
    }
}