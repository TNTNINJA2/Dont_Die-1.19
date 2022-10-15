package net.tntninja2.dontdie.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MythrilBlock extends Block {
    public MythrilBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        Vec3d rotation = entity.getRotationVector();
        rotation = rotation.multiply(0.1);
        entity.addVelocity(rotation.x, 0, rotation.z);

        super.onSteppedOn(world, pos, state, entity);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipContext options) {
        if(Screen.hasShiftDown()) {
           tooltip.add(Text.literal("Walk on to move forward faster").formatted(Formatting.YELLOW));
        } else {
            tooltip.add(Text.literal("Press shift for more info").formatted(Formatting.YELLOW));

        }

        super.appendTooltip(stack, world, tooltip, options);
    }
}
