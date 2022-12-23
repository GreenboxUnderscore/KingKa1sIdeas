package net.kingka1sideas.registry;

import net.kingka1sideas.KingKa1sIdeasMod;
import net.kingka1sideas.items.tools.KingKa1sToolMaterial;
import net.kingka1sideas.items.tools.MultiTool;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.PickaxeItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class KingKa1sTools {
    public static final Item OBSIDIAN_PICKAXE = new PickaxeItem(KingKa1sToolMaterial.OBSIDIAN, 4, -3.0f, (new Item.Settings()).group(ItemGroup.COMBAT).fireproof());
    public static final Item SHADOW_PICKAXE = new MultiTool((KingKa1sToolMaterial.SHADOW), 9, -3.0f, (new Item.Settings()).group(ItemGroup.TOOLS).fireproof());
    public KingKa1sTools() {
    }

    public static void load() {
        Registry.register(Registry.ITEM, new Identifier(KingKa1sIdeasMod.MODID, "obsidian_pickaxe"), OBSIDIAN_PICKAXE);
        Registry.register(Registry.ITEM, new Identifier(KingKa1sIdeasMod.MODID, "shadow_pickaxe"), SHADOW_PICKAXE);
    }
}
