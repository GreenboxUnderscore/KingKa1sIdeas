package net.kingka1sideas.procedures;

import net.kingka1sideas.KingKa1sIdeasMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

import java.util.Map;

public class InvisibilityProcedure {
    public InvisibilityProcedure() {
    }

    public static void execute(Map<String, Object> dependencies) {
        if (dependencies.get("entity") == null) {
            if (!dependencies.containsKey("entity")) {
                KingKa1sIdeasMod.LOGGER.warn("Failed to load dependency entity for procedure Haste!");
            }

        } else {
            Entity entity = (Entity)dependencies.get("entity");
            if (entity.isSneaking() && entity instanceof LivingEntity _entity) {
                _entity.addStatusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, 60, 1));
            }
        }
    }
}
