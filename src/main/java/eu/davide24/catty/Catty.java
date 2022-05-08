package eu.davide24.catty;

import eu.davide24.catty.init.ItemInit;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Catty implements ModInitializer {

	public static final String MOD_ID = "catty";
	public static final Logger LOGGER = LoggerFactory.getLogger("Catty");

	public static final ItemGroup CATTY_ITEMS = FabricItemGroupBuilder.build(
			new Identifier(MOD_ID, "catty_items"),
			() -> new ItemStack(ItemInit.PUSHEEN));

	@Override
	public void onInitialize() {

		// Call InitItems() from ItemInit
		ItemInit.InitItems();

		LOGGER.info("Catty has successfully loaded!");
		LOGGER.info("Thanks for using Catty!");
	}
}
