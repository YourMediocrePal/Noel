package mod.yourmediocrepal.noel.init;

import mod.yourmediocrepal.noel.Noel;
import mod.yourmediocrepal.noel.entities.ElfEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class NoelEntityTypes {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.ENTITIES, Noel.MOD_ID);

    public static final RegistryObject<EntityType<ElfEntity>> ELF = ENTITY_TYPES.register("elf", () -> EntityType.Builder.create(ElfEntity::new, EntityClassification.CREATURE).size(0.5f, 1.5f).build(new ResourceLocation(Noel.MOD_ID, "elf").toString()));
    
}
