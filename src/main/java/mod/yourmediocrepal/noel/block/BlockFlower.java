package mod.yourmediocrepal.noel.block;

import net.minecraft.block.FlowerBlock;
import net.minecraft.entity.effect.StatusEffect;

public class BlockFlower extends FlowerBlock {

    public BlockFlower(StatusEffect suspiciousStewEffect, int effectDuration, Settings settings) {
        super(suspiciousStewEffect, effectDuration, settings);
    }

}
