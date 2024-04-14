package net.thevaliantsquidward.rainbowreef.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LanternBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BasePufferLanternBlock extends LanternBlock {
    protected static final VoxelShape AABB = Shapes.or(Block.box(3.0D, 0.0D, 3.0D, 13.0D, 12.0D, 13.0D));
    protected static final VoxelShape HANGING_AABB = Shapes.or(Block.box(3.0D, 2.0D, 3.0D, 13.0D, 14.0D, 13.0D));

    public BasePufferLanternBlock(Properties p_153465_) {
        super(p_153465_);
    }


    public VoxelShape getShape(BlockState p_153474_, BlockGetter p_153475_, BlockPos p_153476_, CollisionContext p_153477_) {
        return p_153474_.getValue(HANGING) ? HANGING_AABB : AABB;
    }
}
