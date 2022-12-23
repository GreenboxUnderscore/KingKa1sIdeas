package net.kingka1sideas.world.feature;

import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class KingKa1sPlacedFeatures {
    public static final RegistryEntry<PlacedFeature> SHADOW_GEM_PLACE = PlacedFeatures.register("shadow_gem_placed", KingKa1sConfiguredFeatures.SHADOW_GEM, modifiersWithCount(7, HeightRangePlacementModifier.uniform(YOffset.aboveBottom(-80), YOffset.aboveBottom(80))));

    public KingKa1sPlacedFeatures() {
    }

    private static List<PlacementModifier> modifiers(PlacementModifier countModifier, PlacementModifier heightModifier) {
        return List.of(countModifier, SquarePlacementModifier.of(), heightModifier, BiomePlacementModifier.of());
    }

    private static List<PlacementModifier> modifiersWithCount(int count, PlacementModifier heightModifier) {
        return modifiers(CountPlacementModifier.of(count), heightModifier);
    }

    private static List<PlacementModifier> modifiersWithRarity(int chance, PlacementModifier heightModifier) {
        return modifiers(RarityFilterPlacementModifier.of(chance), heightModifier);
    }
}

