package mod.yourmediocrepal.noel.blocks;


import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.particles.ParticleTypes;

public class BlockCandle extends TorchBlock {

    public BlockCandle() {
        super(Properties.create(Material.ORGANIC)
            .hardnessAndResistance(0.0f,0.0f)
            .sound(SoundType.NETHER_WART)
            .tickRandomly()
            .notSolid()
            .variableOpacity()
            .doesNotBlockMovement()
            .lightValue(10)
        );

    }

}
