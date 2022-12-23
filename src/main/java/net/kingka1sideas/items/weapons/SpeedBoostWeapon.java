package net.kingka1sideas.items.weapons;

import com.google.common.collect.ImmutableMap;
import net.kingka1sideas.KingKa1sIdeasMod;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.world.World;

import java.util.List;

public class SpeedBoostWeapon extends SwordItem {


    public SpeedBoostWeapon(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add(Text.translatable("Press Shift for Speed"));
    }

    public static void execute(ImmutableMap<Object, Object> dependencies) {
        if (dependencies.get("entity") == null) {
            if (!dependencies.containsKey("entity")) {
                KingKa1sIdeasMod.LOGGER.warn("Failed to load dependency entity for procedure Haste!");
            }

        } else {
            Entity entity = (Entity)dependencies.get("entity");
            if (entity.isSneaking() && entity instanceof LivingEntity _entity) {
                _entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 100, 1));
            }
        }
    }

    public void inventoryTick(ItemStack itemstack, World world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(itemstack, world, entity, slot, selected);
        if (selected) {
            execute(ImmutableMap.builder().put("entity", entity).build());
        }
    }
}

