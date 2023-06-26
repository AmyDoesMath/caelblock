package io.amydoesmaths.item;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.logging.Logger;

public class InfiniDirt extends Item {
    public InfiniDirt(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        Direction side = context.getSide();
        Vec3d pos = context.getBlockPos().add(side.getVector()).toCenterPos();
        if(!context.getPlayer().getBoundingBox().intersects(pos.add(new Vec3d(-0.5,-0.5,-0.5)), pos.add(new Vec3d(0.5,0.5,0.5)))) {
            if(context.getWorld().getBlockState(context.getBlockPos()) != Blocks.GRASS.getDefaultState() && context.getWorld().getBlockState(context.getBlockPos()) != Blocks.FERN.getDefaultState() && context.getWorld().getBlockState(context.getBlockPos()) != Blocks.TALL_GRASS.getDefaultState()) {
                context.getWorld().setBlockState(context.getBlockPos().add(side.getVector()), Blocks.DIRT.getDefaultState());
                context.getPlayer().playSound(Blocks.DIRT.getSoundGroup(Blocks.DIRT.getDefaultState()).getPlaceSound(), 1.0F, 1.0F);

                return ActionResult.SUCCESS;
            } else {
                context.getWorld().setBlockState(context.getBlockPos(), Blocks.DIRT.getDefaultState());
                context.getPlayer().playSound(Blocks.DIRT.getSoundGroup(Blocks.DIRT.getDefaultState()).getPlaceSound(), 1.0F, 1.0F);

                return ActionResult.SUCCESS;
            }
        }
        return super.useOnBlock(context);
    }
}
