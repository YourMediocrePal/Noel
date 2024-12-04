package mod.yourmediocrepal.init;

import mod.yourmediocrepal.Noel;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class NoelArmorMaterials {

    public static void initialize() {


    }

    public static RegistryEntry<ArmorMaterial> registerMaterial(String id, Map<ArmorItem.Type, Integer> defensePoints, int enchantability, RegistryEntry<SoundEvent> equipSound, Supplier<Ingredient> repairIngredientSupplier, float toughness, float knockbackResistance, boolean dyeable) {
        // Get the supported layers for the armor material
        List<ArmorMaterial.Layer> layers = List.of(
                // The ID of the texture layer, the suffix, and whether the layer is dyeable.
                // We can just pass the armor material ID as the texture layer ID.
                // We have no need for a suffix, so we'll pass an empty string.
                // We'll pass the dyeable boolean we received as the dyeable parameter.
                new ArmorMaterial.Layer(Identifier.of(Noel.MOD_ID, id), "", dyeable)
        );

        ArmorMaterial material = new ArmorMaterial(defensePoints, enchantability, equipSound, repairIngredientSupplier, layers, toughness, knockbackResistance);
        // Register the material within the ArmorMaterials registry.
        material = Registry.register(Registries.ARMOR_MATERIAL, Identifier.of(Noel.MOD_ID, id), material);

        // The majority of the time, you'll want the RegistryEntry of the material - especially for the ArmorItem constructor.
        return RegistryEntry.of(material);
    }

    // PEPPERMINT //
    public static final int PEPPERMINT_DURABILITY_MULTIPLIER = 15;
    public static final RegistryEntry<ArmorMaterial> PEPPERMINT = registerMaterial("peppermint",
            Map.of(
                    ArmorItem.Type.BOOTS, 1,
                    ArmorItem.Type.LEGGINGS, 2,
                    ArmorItem.Type.CHESTPLATE, 3,
                    ArmorItem.Type.HELMET, 1
            ), 15, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, () -> Ingredient.ofItems(NoelItems.PEPPERMINT_CANDY), 0.0f, 0.0f, false);

    // PEPPERMINT //
    public static final int SANTA_DURABILITY_MULTIPLIER = 15;
    public static final RegistryEntry<ArmorMaterial> SANTA = registerMaterial("santa",
            Map.of(
                    ArmorItem.Type.BOOTS, 1,
                    ArmorItem.Type.LEGGINGS, 2,
                    ArmorItem.Type.CHESTPLATE, 3,
                    ArmorItem.Type.HELMET, 1
            ), 15, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, () -> Ingredient.ofItems(Items.RED_WOOL), 0.0f, 0.0f, false);

}
