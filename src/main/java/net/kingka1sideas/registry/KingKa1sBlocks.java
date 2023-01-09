package net.kingka1sideas.registry;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.kingka1sideas.KingKa1sIdeasMod;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class KingKa1sBlocks {
    public static final Block END_SHADOW_GEM_BLOCK= new Block(FabricBlockSettings.of(Material.METAL).requiresTool().nonOpaque().strength(30.0F, 1200.0F).sounds(BlockSoundGroup.ANCIENT_DEBRIS));
    public KingKa1sBlocks() {
    }

    public static void load() {
        Registry.register(Registry.BLOCK, new Identifier(KingKa1sIdeasMod.MODID, "end_shadow_gem_block"), END_SHADOW_GEM_BLOCK);
        Registry.register(Registry.ITEM, new Identifier(KingKa1sIdeasMod.MODID, "end_shadow_gem_block"), new BlockItem(END_SHADOW_GEM_BLOCK, (new FabricItemSettings()).group(ItemGroup.MATERIALS)));
    }
}

