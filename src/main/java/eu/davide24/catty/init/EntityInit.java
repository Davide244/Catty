package eu.davide24.catty.init;

import eu.davide24.catty.Entity.PusheenProjectile;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static eu.davide24.catty.Catty.MOD_ID;

public class EntityInit {
    public static final EntityType<PusheenProjectile> PUSHEEN_PROJECTILE = Registry.register(Registry.ENTITY_TYPE, new Identifier(MOD_ID, "pusheen_projectile"), FabricEntityTypeBuilder.<PusheenProjectile>create(SpawnGroup.MISC, PusheenProjectile::new).dimensions(EntityDimensions.fixed(0.25F, 0.25F)).build());
}
