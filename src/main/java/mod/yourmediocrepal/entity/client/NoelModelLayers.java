package mod.yourmediocrepal.entity.client;

import mod.yourmediocrepal.Noel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class NoelModelLayers {

    public static final EntityModelLayer SANTA =
            new EntityModelLayer(Identifier.of(Noel.MOD_ID, "santa"), "main");

    public static final EntityModelLayer SUGAR_PLUM_FAIRY =
            new EntityModelLayer(Identifier.of(Noel.MOD_ID, "sugar_plum_fairy"), "main");

    public static final EntityModelLayer GINGER_BREAD =
            new EntityModelLayer(Identifier.of(Noel.MOD_ID, "ginger_bread"), "main");

}
