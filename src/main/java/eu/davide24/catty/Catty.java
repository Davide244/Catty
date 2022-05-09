package eu.davide24.catty;

import eu.davide24.catty.Entity.PusheenProjectile;
import eu.davide24.catty.init.ItemInit;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Catty implements ModInitializer {

	public static final String MOD_ID = "catty";
	public static final Logger LOGGER = LoggerFactory.getLogger("Catty");

	public static final ItemGroup CATTY_ITEMS = FabricItemGroupBuilder.build(
			new Identifier(MOD_ID, "catty_items"),
			() -> new ItemStack(ItemInit.PUSHEEN));

	public static final EntityType<PusheenProjectile> PUSHEEN_PROJECTILE = Registry.register(Registry.ENTITY_TYPE, new Identifier(MOD_ID, "pusheen_projectile"), FabricEntityTypeBuilder.<PusheenProjectile>create(SpawnGroup.MISC, PusheenProjectile::new).dimensions(EntityDimensions.fixed(0.25F, 0.25F)).trackRangeBlocks(4).trackedUpdateRate(10).build());

	@Override
	public void onInitialize() {

		// Call InitItems() from ItemInit
		ItemInit.InitItems();

		LOGGER.info("Catty has successfully loaded!");
		LOGGER.info("Thanks for using Catty!");
	}
}
