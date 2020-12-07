package mod.yourmediocrepal.noel.items;

import mod.yourmediocrepal.noel.Noel;
import mod.yourmediocrepal.noel.init.NoelBlocks;
import mod.yourmediocrepal.noel.init.NoelItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.world.IWorldReader;

import javax.annotation.Nullable;
import java.util.Map;

public class ItemWallOrFloor extends BlockItem {

    protected final Block wallBlock;

    public ItemWallOrFloor() {
        super(NoelBlocks.CANDLE.get(), new Item.Properties().group(Noel.TAB));
        this.wallBlock = NoelBlocks.WALL_CANDLE.get();
    }

    @Nullable
    protected BlockState getStateForPlacement(BlockItemUseContext context) {
        BlockState blockstate = this.wallBlock.getStateForPlacement(context);
        BlockState blockstate1 = null;
        IWorldReader iworldreader = context.getWorld();
        BlockPos blockpos = context.getPos();

        for(Direction direction : context.getNearestLookingDirections()) {
            if (direction != Direction.UP) {
                BlockState blockstate2 = direction == Direction.DOWN ? this.getBlock().getStateForPlacement(context) : blockstate;
                if (blockstate2 != null && blockstate2.isValidPosition(iworldreader, blockpos)) {
                    blockstate1 = blockstate2;
                    break;
                }
            }
        }

        return blockstate1 != null && iworldreader.placedBlockCollides(blockstate1, blockpos, ISelectionContext.dummy()) ? blockstate1 : null;
    }

    public void addToBlockToItemMap(Map<Block, Item> blockToItemMap, Item itemIn) {
        super.addToBlockToItemMap(blockToItemMap, itemIn);
        blockToItemMap.put(this.wallBlock, itemIn);
    }

    public void removeFromBlockToItemMap(Map<Block, Item> blockToItemMap, Item itemIn) {
        super.removeFromBlockToItemMap(blockToItemMap, itemIn);
        blockToItemMap.remove(this.wallBlock);
    }
}
