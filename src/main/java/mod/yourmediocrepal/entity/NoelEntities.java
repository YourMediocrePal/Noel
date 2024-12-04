package mod.yourmediocrepal.entity;

import mod.yourmediocrepal.Noel;
import mod.yourmediocrepal.entity.custom.GingerBreadEntity;
import mod.yourmediocrepal.entity.custom.SantaEntity;
import mod.yourmediocrepal.entity.custom.SugarPlumFairyEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

public class NoelEntities {

    public static final EntityType<SantaEntity> SANTA = Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of(Noel.MOD_ID, "santa"),
            FabricEntityTypeBuilder.createMob()
                    .entityFactory(SantaEntity::new)
                    .spawnGroup(SpawnGroup.CREATURE)
                    .dimensions(EntityDimensions.fixed(0.75f, 2f))
                    .defaultAttributes(SantaEntity::createSantaAttributes)
                    .build()
    );

    public static final EntityType<SugarPlumFairyEntity> SUGAR_PLUM_FAIRY = Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of(Noel.MOD_ID, "sugar_plum_fairy"),
            FabricEntityTypeBuilder.createMob()
                    .entityFactory(SugarPlumFairyEntity::new)
                    .spawnGroup(SpawnGroup.CREATURE)
                    .dimensions(EntityDimensions.fixed(0.75f, 0.75f))
                    .defaultAttributes(SugarPlumFairyEntity::createSugarPlumFairyAttributes)
                    .build()
    );

    public static final EntityType<GingerBreadEntity> GINGER_BREAD = Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of(Noel.MOD_ID, "ginger_bread"),
            FabricEntityTypeBuilder.createMob()
                    .entityFactory(GingerBreadEntity::new)
                    .spawnGroup(SpawnGroup.CREATURE)
                    .dimensions(EntityDimensions.fixed(0.75f, 0.75f))
                    .defaultAttributes(GingerBreadEntity::createGingerAttributes)
                    .build()
    );

    public void onInitialize() {

    }
}
