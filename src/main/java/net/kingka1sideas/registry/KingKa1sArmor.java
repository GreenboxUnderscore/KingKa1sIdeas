package net.kingka1sideas.registry;

import net.kingka1sideas.KingKa1sIdeasMod;
import net.kingka1sideas.armor.ElytraArmor;
import net.kingka1sideas.armor.KingKa1sArmorMaterials;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class KingKa1sArmor {

    public static final Item OBSIDIAN_HELMET;
    public static final Item OBSIDIAN_CHESTPLATE;
    public static final Item OBSIDIAN_LEGGINGS;
    public static final Item OBSIDIAN_BOOTS;

    public static final Item TRIMMED_DIAMOND_HELMET;
    public static final Item TRIMMED_DIAMOND_CHESTPLATE;
    public static final Item TRIMMED_DIAMOND_LEGGINGS;
    public static final Item TRIMMED_DIAMOND_BOOTS;

    public static final Item SHADOW_HOOD;

    public static final Item SHADOW_CLOAK;
    public KingKa1sArmor(){}

    public static void load(){
        Registry.register(Registry.ITEM,new Identifier(KingKa1sIdeasMod.MODID, "obsidian_helmet"), OBSIDIAN_HELMET);
        Registry.register(Registry.ITEM,new Identifier(KingKa1sIdeasMod.MODID, "obsidian_chestplate"), OBSIDIAN_CHESTPLATE);
        Registry.register(Registry.ITEM,new Identifier(KingKa1sIdeasMod.MODID, "obsidian_leggings"), OBSIDIAN_LEGGINGS);
        Registry.register(Registry.ITEM,new Identifier(KingKa1sIdeasMod.MODID, "obsidian_boots"), OBSIDIAN_BOOTS);
        Registry.register(Registry.ITEM,new Identifier(KingKa1sIdeasMod.MODID, "shadow_hood"), SHADOW_HOOD);
        Registry.register(Registry.ITEM,new Identifier(KingKa1sIdeasMod.MODID, "shadow_cloak"), SHADOW_CLOAK);
        Registry.register(Registry.ITEM,new Identifier(KingKa1sIdeasMod.MODID, "trimmed_diamond_helmet"), TRIMMED_DIAMOND_HELMET);
        Registry.register(Registry.ITEM,new Identifier(KingKa1sIdeasMod.MODID, "trimmed_diamond_chestplate"), TRIMMED_DIAMOND_CHESTPLATE);
        Registry.register(Registry.ITEM,new Identifier(KingKa1sIdeasMod.MODID, "trimmed_diamond_leggings"), TRIMMED_DIAMOND_LEGGINGS);
        Registry.register(Registry.ITEM,new Identifier(KingKa1sIdeasMod.MODID, "trimmed_diamond_boots"), TRIMMED_DIAMOND_BOOTS);
        Registry.register(Registry.ITEM,new Identifier(KingKa1sIdeasMod.MODID, "elytra_obsidian_chestplate"), new ElytraArmor(KingKa1sArmorMaterials.OBSIDIAN, EquipmentSlot.CHEST,(new Item.Settings()).group(ItemGroup.COMBAT).fireproof()));
        Registry.register(Registry.ITEM,new Identifier(KingKa1sIdeasMod.MODID, "elytra_trimmed_diamond_chestplate"), new ElytraArmor(KingKa1sArmorMaterials.OBSIDIAN, EquipmentSlot.CHEST,(new Item.Settings()).group(ItemGroup.COMBAT).fireproof()));
        Registry.register(Registry.ITEM,new Identifier(KingKa1sIdeasMod.MODID, "elytra_shadow_cloak"), new ElytraArmor(KingKa1sArmorMaterials.SHADOW, EquipmentSlot.CHEST,(new Item.Settings()).group(ItemGroup.COMBAT).fireproof()));
    }

    static{
        OBSIDIAN_HELMET = new ArmorItem(KingKa1sArmorMaterials.OBSIDIAN, EquipmentSlot.HEAD,(new Item.Settings()).group(ItemGroup.COMBAT).fireproof());
        OBSIDIAN_CHESTPLATE = new ArmorItem(KingKa1sArmorMaterials.OBSIDIAN, EquipmentSlot.CHEST,(new Item.Settings()).group(ItemGroup.COMBAT).fireproof());
        OBSIDIAN_LEGGINGS = new ArmorItem(KingKa1sArmorMaterials.OBSIDIAN, EquipmentSlot.CHEST,(new Item.Settings()).group(ItemGroup.COMBAT).fireproof());
        OBSIDIAN_BOOTS = new ArmorItem(KingKa1sArmorMaterials.OBSIDIAN, EquipmentSlot.CHEST,(new Item.Settings()).group(ItemGroup.COMBAT).fireproof());
        TRIMMED_DIAMOND_HELMET = new ArmorItem(KingKa1sArmorMaterials.OBSIDIAN, EquipmentSlot.HEAD,(new Item.Settings()).group(ItemGroup.COMBAT).fireproof());
        TRIMMED_DIAMOND_CHESTPLATE = new ArmorItem(KingKa1sArmorMaterials.OBSIDIAN, EquipmentSlot.CHEST,(new Item.Settings()).group(ItemGroup.COMBAT).fireproof());
        TRIMMED_DIAMOND_LEGGINGS = new ArmorItem(KingKa1sArmorMaterials.OBSIDIAN, EquipmentSlot.CHEST,(new Item.Settings()).group(ItemGroup.COMBAT).fireproof());
        TRIMMED_DIAMOND_BOOTS = new ArmorItem(KingKa1sArmorMaterials.OBSIDIAN, EquipmentSlot.CHEST,(new Item.Settings()).group(ItemGroup.COMBAT).fireproof());
        SHADOW_HOOD = new ArmorItem(KingKa1sArmorMaterials.SHADOW, EquipmentSlot.HEAD,(new Item.Settings().group(ItemGroup.COMBAT).fireproof()));
        SHADOW_CLOAK = new ArmorItem(KingKa1sArmorMaterials.SHADOW, EquipmentSlot.CHEST,(new Item.Settings().group(ItemGroup.COMBAT).fireproof()));
    }
}
