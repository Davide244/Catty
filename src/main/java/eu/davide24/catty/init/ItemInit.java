package eu.davide24.catty.init;

import eu.davide24.catty.Item.PusheenItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

import static eu.davide24.catty.Catty.CATTY_ITEMS;
import static eu.davide24.catty.Catty.MOD_ID;

public class ItemInit {

    public static final Item PUSHEEN = new PusheenItem(new FabricItemSettings().group(CATTY_ITEMS).maxCount(16).rarity(Rarity.UNCOMMON));

    public static void InitItems() {
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "pusheen"), PUSHEEN);
    }
}
