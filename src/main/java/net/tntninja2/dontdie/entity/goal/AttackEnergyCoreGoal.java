package net.tntninja2.dontdie.entity.goal;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.StepAndDestroyBlockGoal;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkSectionPos;
import net.minecraft.world.WorldView;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkStatus;
import net.tntninja2.dontdie.DontDie;
import net.tntninja2.dontdie.entity.custom.DestructiveEntity;


public class AttackEnergyCoreGoal extends StepAndDestroyBlockGoal {
    DestructiveEntity mob;
    Block targetBlock;

    public AttackEnergyCoreGoal(Block targetBlock, DestructiveEntity mob, double speed, int maxYDifference, float targetDifference) {
        super(targetBlock, mob, speed, maxYDifference);
        this.targetBlock = targetBlock;
        this.mob = mob;
    }

    @Override
    protected boolean isTargetPos(WorldView world, BlockPos pos) {
        Chunk chunk = world.getChunk(ChunkSectionPos.getSectionCoord(pos.getX()), ChunkSectionPos.getSectionCoord(pos.getZ()), ChunkStatus.FULL, false);
        if (chunk == null) {
            return false;
        } else {
            return chunk.getBlockState(pos).isOf(this.targetBlock) && chunk.getBlockState(pos.up()).isAir() && chunk.getBlockState(pos.up(2)).isAir();
        }
    }

    @Override
    public boolean canStart() {
        return super.canStart();
    }

    @Override
    public void start() {
        super.start();
    }
}
