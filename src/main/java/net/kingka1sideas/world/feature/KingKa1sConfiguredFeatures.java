package net.kingka1sideas.world.feature;

import net.kingka1sideas.registry.KingKa1sBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import java.util.List;

public class KingKa1sConfiguredFeatures {
    public static final List<OreFeatureConfig.Target> END_SHADOW_BLOCK;
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> SHADOW_GEM;

    public KingKa1sConfiguredFeatures() {
    }

    static {
        END_SHADOW_BLOCK = List.of(OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.END_STONE), KingKa1sBlocks.END_SHADOW_GEM_BLOCK.getDefaultState()));
        SHADOW_GEM = ConfiguredFeatures.register("shadow_gem", Feature.ORE, new OreFeatureConfig(END_SHADOW_BLOCK, 4));
    }
}
