package mod.yourmediocrepal.block;

import com.google.common.base.Suppliers;
import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import mod.yourmediocrepal.Noel;
import mod.yourmediocrepal.init.NoelBlocks;
import net.minecraft.block.*;
import net.minecraft.block.enums.BlockFace;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Property;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;
import org.slf4j.LoggerFactory;

import java.util.function.Supplier;

public class BlockCopperOrnament extends BlockOrnament implements Oxidizable {

    private final Oxidizable.OxidationLevel oxidationLevel;
    public BlockCopperOrnament(Oxidizable.OxidationLevel oxidationLevel, Settings settings) {
        super(settings.nonOpaque().notSolid().sounds(BlockSoundGroup.GLASS));
        setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH).with(FACE, BlockFace.WALL));
        this.oxidationLevel = oxidationLevel;
    }

    @Override
    protected boolean hasRandomTicks(BlockState state) {
        return Oxidizable.getIncreasedOxidationBlock(state.getBlock()).isPresent();
    }

    @Override
    protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        LoggerFactory.getLogger(Noel.MOD_ID).info("random tick");
        tickDegradation(state, world, pos, random);
    }

    @Override
    public void tickDegradation(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        Oxidizable.super.tickDegradation(state, world, pos, random);
    }


    public Oxidizable.OxidationLevel getDegradationLevel() {
        return this.oxidationLevel;
    }
}
