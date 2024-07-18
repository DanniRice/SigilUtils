package net.vdelta.sigil_utils.item;

import net.vdelta.sigil_utils.SigilUtils;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.vdelta.sigil_utils.item.custom.FuelItem;
import net.vdelta.sigil_utils.item.custom.RingOfTransmutationItem;

public class SigilUtils_Items {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SigilUtils.MOD_ID);

    // progression
    public static final RegistryObject<Item> VARENTIUM = ITEMS.register("varentium", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> VARENTIUM_SHARD = ITEMS.register("varentium_shard", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CIRCADIUM_INGOT = ITEMS.register("circadium_ingot", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CIRCADIUM_BLEND = ITEMS.register("circadium_blend", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CIRCADIUM_PLATING = ITEMS.register("circadium_plating", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ORICHALCOM_ALLOY = ITEMS.register("orichalcom_alloy", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ORICHALCOM_INGOT = ITEMS.register("orichalcom_ingot", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ORICHALCOM_NUGGET = ITEMS.register("orichalcom_nugget", () -> new Item(new Item.Properties()));

    // rare items
    public static final RegistryObject<Item> RING_OF_TRANSMUTATION = ITEMS.register("ring_of_transmutation", () -> new RingOfTransmutationItem(new Item.Properties().stacksTo(1).fireResistant()));
    public static final RegistryObject<Item> RING_OF_HOLDING = ITEMS.register("ring_of_holding", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ORICHALCOM_EGG = ITEMS.register("orichalcom_egg", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ASTRAL_STAR = ITEMS.register("astral_star", () -> new Item(new Item.Properties()));

    // fuel
    public static final RegistryObject<Item> COAL_CHUNK = ITEMS.register("coal_chunk", () -> new FuelItem(new Item.Properties(), 200));
    public static final RegistryObject<Item> CHARCOAL_CHUNK = ITEMS.register("charcoal_chunk", () -> new FuelItem(new Item.Properties(), 200));

    // food
    public static final RegistryObject<Item> MOSS_BALL = ITEMS.register("moss_ball", () -> new Item(new Item.Properties().food(SigilUtils_Foods.MOSS_BALL)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
