package net.kingka1sideas.items.weapons;

import com.google.common.collect.ImmutableMap;
import net.kingka1sideas.procedures.StrengthProcedure;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.world.World;

import java.util.List;

public class StrengthBoostWeapon extends SwordItem {


    public StrengthBoostWeapon(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add(Text.translatable("Press Shift for Strength"));
    }

    public void inventoryTick(ItemStack itemstack, World world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(itemstack, world, entity, slot, selected);
        if (selected) {
            StrengthProcedure.execute(ImmutableMap.builder().put("entity", entity).build());
        }
    }
}

