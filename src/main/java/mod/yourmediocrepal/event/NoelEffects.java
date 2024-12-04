package mod.yourmediocrepal.event;

import mod.yourmediocrepal.Noel;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class NoelEffects {

    public static final RegistryEntry<StatusEffect> FESTIVE = registerStatusEffect("festive", new FestiveEffect(StatusEffectCategory.NEUTRAL, 0xf44336)
            .addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED, Identifier.of(Noel.MOD_ID, "festive"), 0.75f, EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));
    private static RegistryEntry<StatusEffect> registerStatusEffect(String name, StatusEffect statusEffect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(Noel.MOD_ID, name), statusEffect);
    }
    public static void initilize() {

    }
}
