package net.kingka1sideas.registry;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class KingKa1sItems {
    public static final Item KATANA_HANDLE = new Item((new FabricItemSettings()).group(ItemGroup.MISC));
    public static final Item SHADOW_INGOT = new Item((new FabricItemSettings()).fireproof().group(ItemGroup.MATERIALS));
    public static final Item SHADOW_GEM = new Item((new FabricItemSettings()).fireproof().group(ItemGroup.MATERIALS));
    public static final Item LEATHER_HANDLE = new Item((new FabricItemSettings()).group(ItemGroup.MATERIALS));
    public static final Item GOLDEN_BAKED_POTATO = new Item((new FabricItemSettings()).group(ItemGroup.FOOD).food((new FoodComponent.Builder().hunger(8).saturationModifier(8.0F).alwaysEdible().statusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 2), 1.0F).build())));

    public KingKa1sItems() {
    }

    public static void load() {
        Registry.register(Registry.ITEM, new Identifier("kingka1sideas", "katana_handle"), KATANA_HANDLE);
        Registry.register(Registry.ITEM, new Identifier("kingka1sideas", "leather_handle"), LEATHER_HANDLE);
        Registry.register(Registry.ITEM, new Identifier("kingka1sideas", "golden_baked_potato"), GOLDEN_BAKED_POTATO);
        Registry.register(Registry.ITEM, new Identifier("kingka1sideas", "shadow_gem"), SHADOW_GEM);
        Registry.register(Registry.ITEM, new Identifier("kingka1sideas", "shadow_ingot"), SHADOW_INGOT);
        }
}