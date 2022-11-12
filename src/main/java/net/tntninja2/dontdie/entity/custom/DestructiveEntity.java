package net.tntninja2.dontdie.entity.custom;

import com.google.common.base.Predicates;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.passive.BeeEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.tag.PointOfInterestTypeTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import net.minecraft.world.poi.PointOfInterest;
import net.minecraft.world.poi.PointOfInterestStorage;
import net.tntninja2.dontdie.block.ModBlocks;
import net.tntninja2.dontdie.block.custom.EnergyCoreBlock;
import net.tntninja2.dontdie.networking.packet.EnergyCoreUpgradeS2CPacket;
import net.tntninja2.dontdie.tag.ModPointOfInterestTypeTags;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DestructiveEntity extends HostileEntity {

    public BlockPos targetEnergyCore;
    protected DestructiveEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

//    public List<BlockPos> getNearbyEnergyCores() {
//        BlockPos blockPos = this.getBlockPos();
//        Box box = new Box(blockPos.getX() - 20, blockPos.getY() - 20, blockPos.getZ() - 20, blockPos.getX() + 20, blockPos.getY() + 20, blockPos.getZ() + 20)
//
//        List<BlockState> energyCores = this.world.getStatesInBox(box).filter(Predicate.isEqual(ModBlocks.ENERGY_CORE.getDefaultState())).toList();
//        for (BlockState energyCore: energyCores) {
//            energyCore.
//        }
//    }
}
