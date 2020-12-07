package mod.yourmediocrepal.noel.init;

import mod.yourmediocrepal.noel.Noel;
import mod.yourmediocrepal.noel.entities.ElfEntity;
import mod.yourmediocrepal.noel.entities.GingerBreadEntity;
import mod.yourmediocrepal.noel.entities.SugarPlumFairyEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class NoelEntityTypes {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, Noel.MOD_ID);

    public static final RegistryObject<EntityType<ElfEntity>> ELF = ENTITY_TYPES.register("elf", () -> EntityType.Builder.create(ElfEntity::new, EntityClassification.CREATURE).size(0.5f, 1.5f).build(new ResourceLocation(Noel.MOD_ID, "elf").toString()));

    public static final RegistryObject<EntityType<SugarPlumFairyEntity>> SUGAR_PLUM_FAIRY = ENTITY_TYPES.register("sugar_plum_fairy", () -> EntityType.Builder.create(SugarPlumFairyEntity::new, EntityClassification.CREATURE).size(0.5f, 0.8f).build(new ResourceLocation(Noel.MOD_ID, "sugar_plum_fairy").toString()));

    public static final RegistryObject<EntityType<GingerBreadEntity>> GINGER_BREAD_MAN = ENTITY_TYPES.register("ginger_bread_man", () -> EntityType.Builder.create(GingerBreadEntity::new, EntityClassification.CREATURE).size(0.5f, 0.8f).build(new ResourceLocation(Noel.MOD_ID, "ginger_bread_man").toString()));

}
