package eu.davide24.catty.Entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

public class PusheenProjectile extends ThrownItemEntity {

    public PusheenProjectile(EntityType<? extends ThrownItemEntity> type, World world) {
        super(type, world);
    }
    public PusheenProjectile(World world, LivingEntity owner) {
        super(null, owner, world); // null will be changed later
    }

    public PusheenProjectile(World world, double x, double y, double z) {
        super(null, x, y, z, world); // null will be changed later
    }

    @Override
    protected Item getDefaultItem() {
        return null;
    }

    protected void onCollision(HitResult hitResult) { // called on collision with a block
        super.onCollision(hitResult);
        if (!this.world.isClient) { // checks if the world is client
            this.world.sendEntityStatus(this, (byte)3); // particle?
            world.createExplosion(this.getOwner(), this.getX(), this.getY(), this.getZ(), 1.0F, Explosion.DestructionType.NONE); // explosion
            this.kill(); // kills the projectile
        }

    }
}
