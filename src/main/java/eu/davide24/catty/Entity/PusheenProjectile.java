package eu.davide24.catty.Entity;

import eu.davide24.catty.Catty;
import eu.davide24.catty.client.CattyClient;
import eu.davide24.catty.client.EntitySpawnPacket;
import eu.davide24.catty.init.ItemInit;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.network.Packet;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

public class PusheenProjectile extends ThrownItemEntity {

    public PusheenProjectile(EntityType<? extends ThrownItemEntity> type, World world) {
        super(type, world);
    }
    public PusheenProjectile(World world, LivingEntity owner) {
        super(Catty.PUSHEEN_PROJECTILE, owner, world); // null will be changed later
    }

    public PusheenProjectile(World world, double x, double y, double z) {
        super(Catty.PUSHEEN_PROJECTILE, x, y, z, world); // null will be changed later
    }

    @Override
    protected Item getDefaultItem() {
        return ItemInit.PUSHEEN.asItem();
    }

    //@Override
    //public Packet createSpawnPacket() {
    //    return EntitySpawnPacket.create(this, CattyClient.PacketID);
    //}

    protected void onCollision(HitResult hitResult) { // called on collision with a block
        super.onCollision(hitResult);
        if (!this.world.isClient) { // checks if the world is client
            this.world.sendEntityStatus(this, (byte)3); // particle?
            world.createExplosion(this, this.getX(), this.getY(), this.getZ(), 3.0F, Explosion.DestructionType.BREAK); // explosion
            this.kill(); // kills the projectile
        }

    }
}
