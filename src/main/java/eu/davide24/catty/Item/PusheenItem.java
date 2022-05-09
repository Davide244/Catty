package eu.davide24.catty.Item;

import eu.davide24.catty.Entity.PusheenProjectile;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.text.LiteralText;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class PusheenItem extends Item {
    public PusheenItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemstack = user.getStackInHand(hand);
        world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_CAT_AMBIENT, SoundCategory.NEUTRAL, 0.5F, 1.0F);

        if (!world.isClient) {
            PusheenProjectile projectile = new PusheenProjectile(world, user);
            projectile.setItem(itemstack);
            projectile.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 1.5F, 0.0F);

            world.spawnEntity(projectile);
        }

        user.incrementStat(Stats.USED.getOrCreateStat(this));
        if (!user.getAbilities().creativeMode) {
            itemstack.decrement(1);
        }
        return TypedActionResult.success(user.getStackInHand(hand));
    }
}
