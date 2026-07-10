package dev.ultreon.mods.redstone.datagen;

import dev.ultreon.mods.redstone.OmnixerioRedstone;
import dev.ultreon.mods.redstone.init.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.triggers.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class RedstoneAdvancementsProvider extends FabricAdvancementProvider {
    protected RedstoneAdvancementsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(output, registryLookup);
    }

    @Override
    public void generateAdvancement(HolderLookup.@NonNull Provider registryLookup, @NonNull Consumer<AdvancementHolder> consumer) {
        AdvancementHolder root = Advancement.Builder.advancement()
                .display(
                        Items.REDSTONE, // The display icon
                        Component.literal("Omnixerio Redstone"), // The title
                        Component.literal("Install Omnixerio Redstone"), // The description
                        OmnixerioRedstone.id("gui/advancement_background"), // Background image for the tab in the advancements page, if this is a root advancement (has no parent)
                        AdvancementType.TASK, // TASK, CHALLENGE, or GOAL
                        false, // Show the toast when completing it
                        false, // Announce it to chat
                        false // Hide it in the advancement tab until it's achieved
                )
                .addCriterion("has_crafting_table", InventoryChangeTrigger.TriggerInstance.hasItems(Items.CRAFTING_TABLE))
                .save(consumer, OmnixerioRedstone.id("redstone/root"));

        Advancement.Builder.advancement()
                .display(
                        ModItems.SWITCH.get(), // The display icon
                        Component.literal("Switcheroo"), // The title
                        Component.literal("Create a switch"), // The description
                        OmnixerioRedstone.id("gui/advancement_background"), // Background image for the tab in the advancements page, if this is a root advancement (has no parent)
                        AdvancementType.TASK, // TASK, CHALLENGE, or GOAL
                        true, // Show the toast when completing it
                        true, // Announce it to chat
                        false // Hide it in the advancement tab until it's achieved
                )
                .addCriterion("got_switch", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SWITCH.get()))
                .parent(root)
                .save(consumer, OmnixerioRedstone.id("redstone/get_switch"));

        Advancement.Builder.advancement()
                .display(
                        ModItems.TIMER.get(), // The display icon
                        Component.literal("Timing!"), // The title
                        Component.literal("Create a Timer"), // The description
                        OmnixerioRedstone.id("gui/advancement_background"), // Background image for the tab in the advancements page, if this is a root advancement (has no parent)
                        AdvancementType.TASK, // TASK, CHALLENGE, or GOAL
                        true, // Show the toast when completing it
                        true, // Announce it to chat
                        false // Hide it in the advancement tab until it's achieved
                )
                .addCriterion("got_timer", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.TIMER.get()))
                .parent(root)
                .save(consumer, OmnixerioRedstone.id("redstone/get_trash_can"));

        HolderLookup.RegistryLookup<Item> items = registryLookup.lookup(Registries.ITEM).get();
        Advancement.Builder.advancement()
                .display(
                        ModItems.NOT_GATE.get(), // The display icon
                        Component.literal("Not?"), // The title
                        Component.literal("Create a NOT Gate"), // The description
                        OmnixerioRedstone.id("gui/advancement_background"), // Background image for the tab in the advancements page, if this is a root advancement (has no parent)
                        AdvancementType.TASK, // TASK, CHALLENGE, or GOAL
                        true, // Show the toast when completing it
                        true, // Announce it to chat
                        false // Hide it in the advancement tab until it's achieved
                )
                .addCriterion("got_not_gate", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NOT_GATE.get()))
                .parent(root)
                .save(consumer, OmnixerioRedstone.id("redstone/get_table"));
        Advancement.Builder.advancement()
                .display(
                        ModItems.OR_GATE.get(), // The display icon
                        Component.literal("This Or That"), // The title
                        Component.literal("Create an OR Gate"), // The description
                        OmnixerioRedstone.id("gui/advancement_background"), // Background image for the tab in the advancements page, if this is a root advancement (has no parent)
                        AdvancementType.TASK, // TASK, CHALLENGE, or GOAL
                        true, // Show the toast when completing it
                        true, // Announce it to chat
                        false // Hide it in the advancement tab until it's achieved
                )
                .addCriterion("got_or_gate", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.OR_GATE.get()))
                .parent(root)
                .save(consumer, OmnixerioRedstone.id("redstone/get_or_gate"));
        Advancement.Builder.advancement()
                .display(
                        ModItems.OR_GATE.get(), // The display icon
                        Component.literal("This And That"), // The title
                        Component.literal("Create an AND Gate"), // The description
                        OmnixerioRedstone.id("gui/advancement_background"), // Background image for the tab in the advancements page, if this is a root advancement (has no parent)
                        AdvancementType.TASK, // TASK, CHALLENGE, or GOAL
                        true, // Show the toast when completing it
                        true, // Announce it to chat
                        false // Hide it in the advancement tab until it's achieved
                )
                .addCriterion("got_and_gate", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.AND_GATE.get()))
                .parent(root)
                .save(consumer, OmnixerioRedstone.id("redstone/get_and_gate"));
    }
}