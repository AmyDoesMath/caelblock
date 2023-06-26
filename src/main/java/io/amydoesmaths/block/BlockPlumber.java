package io.amydoesmaths.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class BlockPlumber extends Block {
    public BlockPlumber(Settings settings) {
        super(settings);
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        int i = 0;
        drainWater(world, pos, 30);
        super.onPlaced(world, pos, state, placer, itemStack);
    }

    public void drainWater(World world, BlockPos pos, int i) {
        if(i != 0) {
            if (world.getBlockState(pos).isLiquid()) {
                world.setBlockState(pos, Blocks.AIR.getDefaultState());
            }
            if (world.getBlockState(pos).getProperties().contains(Properties.WATERLOGGED)) {
                if (world.getBlockState(pos).get(Properties.WATERLOGGED)) {
                    world.setBlockState(pos, world.getBlockState(pos).with(Properties.WATERLOGGED, false));
                }
            }
            if(world.getBlockState(pos.add(1,0,0)).isLiquid() || (world.getBlockState(pos).getProperties().contains(Properties.WATERLOGGED) && world.getBlockState(pos).get(Properties.WATERLOGGED))) {
                drainWater(world, pos.add(1,0,0), i-1);
            }
            if(world.getBlockState(pos.add(0,1,0)).isLiquid() || (world.getBlockState(pos).getProperties().contains(Properties.WATERLOGGED) && world.getBlockState(pos).get(Properties.WATERLOGGED))) {
                drainWater(world, pos.add(0,1,0), i-1);
            }
            if(world.getBlockState(pos.add(0,0,1)).isLiquid() || (world.getBlockState(pos).getProperties().contains(Properties.WATERLOGGED) && world.getBlockState(pos).get(Properties.WATERLOGGED))) {
                drainWater(world, pos.add(0,0,1), i-1);
            }
            if(world.getBlockState(pos.add(-1,0,0)).isLiquid() || (world.getBlockState(pos).getProperties().contains(Properties.WATERLOGGED) && world.getBlockState(pos).get(Properties.WATERLOGGED))) {
                drainWater(world, pos.add(-1,0,0), i-1);
            }
            if(world.getBlockState(pos.add(0,-1,0)).isLiquid() || (world.getBlockState(pos).getProperties().contains(Properties.WATERLOGGED) && world.getBlockState(pos).get(Properties.WATERLOGGED))) {
                drainWater(world, pos.add(0,-1,0), i-1);
            }
            if(world.getBlockState(pos.add(0,0,-1)).isLiquid() || (world.getBlockState(pos).getProperties().contains(Properties.WATERLOGGED) && world.getBlockState(pos).get(Properties.WATERLOGGED))) {
                drainWater(world, pos.add(0,0,-1), i-1);
            }
        }
    }
}
