package net.tntninja2.dontdie.item.custom;

import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.Vec3d;

public class MythrilIngotItem extends Item {


    public MythrilIngotItem(Settings settings) {
        super(settings);

    }

    public ActionResult useOnBlock(ItemUsageContext context) {
        Vec3d hitPos = context.getHitPos();
        Vec3d playerPos = context.getPlayer().getPos();
        Vec3d differenceVector = hitPos.subtract(playerPos);
        context.getPlayer().addVelocity(differenceVector.x, 0, differenceVector.z);
        return ActionResult.SUCCESS;
    }
}