package net.kingka1sideas.registry;

import net.kingka1sideas.KingKa1sIdeasMod;
import net.kingka1sideas.items.tools.KingKa1sToolMaterial;
import net.kingka1sideas.items.weapons.SpeedBoostWeapon;
import net.kingka1sideas.items.weapons.StrengthBoostWeapon;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class KingKa1sWeapons {
    public static final Item WOOD_KATANA = new SwordItem(ToolMaterials.WOOD, 6, 1.0F, (new Item.Settings()).group(ItemGroup.COMBAT));
    public static final Item FlINT_KATANA = new SwordItem(KingKa1sToolMaterial.FLINT, 7, 1.0F, (new Item.Settings()).group(ItemGroup.COMBAT));
    public static final Item STONE_KATANA= new SwordItem(ToolMaterials.STONE, 7, 1.0F, (new Item.Settings()).group(ItemGroup.COMBAT));
    public static final Item COPPER_KATANA = new SwordItem(KingKa1sToolMaterial.COPPER, 8, 1.0F, (new Item.Settings()).group(ItemGroup.COMBAT));
    public static final Item IRON_KATANA = new SwordItem(ToolMaterials.IRON, 8, 1.0F, (new Item.Settings()).group(ItemGroup.COMBAT));
    public static final Item GOLD_KATANA = new SwordItem(ToolMaterials.GOLD, 7, 1.0F, (new Item.Settings()).group(ItemGroup.COMBAT));
    public static final Item DIAMOND_KATANA = new SwordItem(ToolMaterials.DIAMOND, 9, 1.0F, (new Item.Settings()).group(ItemGroup.COMBAT));
    public static final Item DIAMOND_SCYTHE = new SwordItem(ToolMaterials.DIAMOND, 9, -1.5F, (new Item.Settings()).group(ItemGroup.COMBAT));
    public static final Item AMETHYST_KATANA = new SwordItem(KingKa1sToolMaterial.AMETHYST, 9, 1.0F, (new Item.Settings()).group(ItemGroup.COMBAT));
    public static final Item EMERALD_KATANA = new SwordItem(KingKa1sToolMaterial.EMERALD, 9, 1.0F, (new Item.Settings()).group(ItemGroup.COMBAT));
    public static final Item OBSIDIAN_SWORD = new SwordItem(KingKa1sToolMaterial.OBSIDIAN, 9, 1.0F, (new Item.Settings()).group(ItemGroup.COMBAT).fireproof());
    public static final Item OBSIDIAN_AXE = new SwordItem(KingKa1sToolMaterial.OBSIDIAN, 8, -3.0F, (new Item.Settings()).group(ItemGroup.COMBAT).fireproof());
    public static final Item OBSIDIAN_KATANA = new SwordItem(KingKa1sToolMaterial.OBSIDIAN, 9, 1.0F, (new Item.Settings()).group(ItemGroup.COMBAT).fireproof());
    public static final Item NETHERITE_KATANA = new SwordItem(ToolMaterials.NETHERITE, 10, 1.0F, (new Item.Settings()).group(ItemGroup.COMBAT).fireproof());
    public static final Item NETHERITE_SCYTHE = new SwordItem(ToolMaterials.NETHERITE, 10, -1.5F, (new Item.Settings()).group(ItemGroup.COMBAT).fireproof());
    public static final Item SHADOW_KATANA = new SpeedBoostWeapon(KingKa1sToolMaterial.SHADOW, 11, 1.0F, (new Item.Settings()).group(ItemGroup.COMBAT).fireproof());
    public static final Item SHADOW_SCYTHE = new StrengthBoostWeapon(KingKa1sToolMaterial.SHADOW, 12, -1.0F, (new Item.Settings()).group(ItemGroup.COMBAT).fireproof());

    public KingKa1sWeapons() {
    }

    public static void load() {
        Registry.register(Registry.ITEM, new Identifier(KingKa1sIdeasMod.MODID, "obsidian_sword"), OBSIDIAN_SWORD);
        Registry.register(Registry.ITEM, new Identifier(KingKa1sIdeasMod.MODID, "obsidian_axe"), OBSIDIAN_AXE);
        Registry.register(Registry.ITEM, new Identifier(KingKa1sIdeasMod.MODID, "wood_katana"), WOOD_KATANA);
        Registry.register(Registry.ITEM, new Identifier(KingKa1sIdeasMod.MODID, "flint_katana"), FlINT_KATANA);
        Registry.register(Registry.ITEM, new Identifier(KingKa1sIdeasMod.MODID, "stone_katana"), STONE_KATANA);
        Registry.register(Registry.ITEM, new Identifier(KingKa1sIdeasMod.MODID, "copper_katana"), COPPER_KATANA);
        Registry.register(Registry.ITEM, new Identifier(KingKa1sIdeasMod.MODID, "iron_katana"), IRON_KATANA);
        Registry.register(Registry.ITEM, new Identifier(KingKa1sIdeasMod.MODID, "gold_katana"), GOLD_KATANA);
        Registry.register(Registry.ITEM, new Identifier(KingKa1sIdeasMod.MODID, "amethyst_katana"), AMETHYST_KATANA);
        Registry.register(Registry.ITEM, new Identifier(KingKa1sIdeasMod.MODID, "emerald_katana"), EMERALD_KATANA);
        Registry.register(Registry.ITEM, new Identifier(KingKa1sIdeasMod.MODID, "obsidian_katana"), OBSIDIAN_KATANA);
        Registry.register(Registry.ITEM, new Identifier(KingKa1sIdeasMod.MODID, "diamond_katana"), DIAMOND_KATANA);
        Registry.register(Registry.ITEM, new Identifier(KingKa1sIdeasMod.MODID, "netherite_katana"), NETHERITE_KATANA);
        Registry.register(Registry.ITEM, new Identifier(KingKa1sIdeasMod.MODID, "shadow_katana"), SHADOW_KATANA);
        Registry.register(Registry.ITEM, new Identifier(KingKa1sIdeasMod.MODID, "diamond_scythe"), DIAMOND_SCYTHE);
        Registry.register(Registry.ITEM, new Identifier(KingKa1sIdeasMod.MODID, "netherite_scythe"), NETHERITE_SCYTHE);
        Registry.register(Registry.ITEM, new Identifier(KingKa1sIdeasMod.MODID, "shadow_scythe"), SHADOW_SCYTHE);
    }
}
