package net.kingka1sideas.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.kingka1sideas.world.feature.KingKa1sPlacedFeatures;
import net.minecraft.world.gen.GenerationStep;

public class KingKa1sOreGenerate {
    public KingKa1sOreGenerate() {
    }

    public static void load() {
        BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(), GenerationStep.Feature.UNDERGROUND_ORES, KingKa1sPlacedFeatures.SHADOW_GEM_PLACE.getKey().get());
    }
}
