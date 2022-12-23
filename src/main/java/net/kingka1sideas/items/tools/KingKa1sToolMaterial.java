package net.kingka1sideas.items.tools;

import net.kingka1sideas.registry.KingKa1sItems;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.tag.ItemTags;
import net.minecraft.util.Lazy;

import java.util.function.Supplier;

public enum KingKa1sToolMaterial implements ToolMaterial {
    WOOD(0, 59, 2.0F, 0.0F, 15, () -> {
        return Ingredient.fromTag(ItemTags.PLANKS);
    }),
    FLINT(1, 131, 4.0F, 1.0F, 5, () -> {
        return Ingredient.ofItems(Items.FLINT);
    }),
    STONE(1, 131, 4.0F, 1.0F, 5, () -> {
        return Ingredient.fromTag(ItemTags.STONE_TOOL_MATERIALS);
    }),
    IRON(2, 250, 6.0F, 2.0F, 14, () -> {
        return Ingredient.ofItems(Items.IRON_INGOT);
    }),
    COPPER(2, 250, 6.0F, 2.0F, 14, () -> {
        return Ingredient.ofItems(Items.COPPER_INGOT);
    }),
    DIAMOND(3, 1561, 8.0F, 3.0F, 10, () -> {
        return Ingredient.ofItems(Items.DIAMOND);
    }),
    AMETHYST(3, 1561, 8.0F, 3.0F, 10, () -> {
        return Ingredient.ofItems(Items.AMETHYST_SHARD);
    }),
    EMERALD(3, 1561, 8.0F, 3.0F, 10, () -> {
        return Ingredient.ofItems(Items.EMERALD);
    }),
    GOLD(0, 32, 12.0F, 0.0F, 22, () -> {
        return Ingredient.ofItems(Items.GOLD_INGOT);
    }),
    OBSIDIAN(3, 2031, 12.0F, 4.0F, 30, () -> {
        return Ingredient.ofItems(Items.OBSIDIAN);
    }),
    NETHERITE(4, 2031, 9.0F, 4.0F, 15, () -> {
        return Ingredient.ofItems(Items.NETHERITE_INGOT);
    }),
    SHADOW(4, 4062, 12.0F, 4.0F, 30, () -> {
        return Ingredient.ofItems(KingKa1sItems.SHADOW_INGOT);
    });

    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Lazy<Ingredient> repairIngredient;

    KingKa1sToolMaterial(int miningLevel, int itemDurability, float miningSpeed, float attackDamage, int enchantability, Supplier repairIngredient) {
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = new Lazy(repairIngredient);
    }

    public int getDurability() {
        return this.itemDurability;
    }

    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    public float getAttackDamage() {
        return this.attackDamage;
    }

    public int getMiningLevel() {
        return this.miningLevel;
    }

    public int getEnchantability() {
        return this.enchantability;
    }

    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}
