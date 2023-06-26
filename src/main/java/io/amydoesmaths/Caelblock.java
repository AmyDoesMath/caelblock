package io.amydoesmaths;

import io.amydoesmaths.block.BlockPlumber;
import io.amydoesmaths.item.InfiniDirt;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Caelblock implements ModInitializer {
    // This logger is used to write text to the console and the log file.
    // It is considered best practice to use your mod id as the logger's name.
    // That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("modid");

    // Item
    public static final InfiniDirt INFINI_DIRT = new InfiniDirt(new Item.Settings().maxCount(1));
    // Block
    public static final BlockPlumber PLUMBER_SPONGE = new BlockPlumber(FabricBlockSettings.create().strength(0.6F).sounds(BlockSoundGroup.GRASS).mapColor(MapColor.YELLOW));

    @Override
    public void onInitialize() {
        LOGGER.info("Hello Fabric world!");

        Registry.register(Registries.ITEM, new Identifier("caelblock","infinidirt"), INFINI_DIRT);
        Registry.register(Registries.ITEM, new Identifier("tutorial", "example_block"), new BlockItem(PLUMBER_SPONGE, new FabricItemSettings()));
        Registry.register(Registries.BLOCK, new Identifier("tutorial", "example_block"), PLUMBER_SPONGE);
    }
}