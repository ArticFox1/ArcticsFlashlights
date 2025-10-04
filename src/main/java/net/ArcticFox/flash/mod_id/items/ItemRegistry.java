package net.ArcticFox.flash.mod_id.items;

import net.ArcticFox.flash.mod_id.Main;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ItemRegistry {
    public static Item FLASHLIGHT = initItem("flashlight",new Item(new FabricItemSettings()));

    private static void addToTab(FabricItemGroupEntries entries) {
        entries.add(FLASHLIGHT);
    }

    private static Item initItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Main.MOD_ID,name),item);
    }

    public static void RegisterItems() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS);
    }
}
