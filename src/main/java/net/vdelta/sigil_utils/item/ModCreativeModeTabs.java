package net.vdelta.sigil_utils.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.vdelta.sigil_utils.SigilUtils;
import net.vdelta.sigil_utils.block.ModBlocks;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SigilUtils.MOD_ID);

    public static final RegistryObject<CreativeModeTab> SIGIL_UTILS_TAB = CREATIVE_MODE_TABS.register("sigil_utils_tab", () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.RING_OF_TRANSMUTATION.get()))
            .title(Component.translatable("creativetab.sigil_utils_tab"))
            .displayItems((pParameters, pOutput) -> {
                pOutput.accept(ModItems.VARENTIUM.get());
                pOutput.accept(ModItems.VARENTIUM_SHARD.get());
                pOutput.accept(ModBlocks.VARENTIUM_BLOCK.get());
                pOutput.accept(ModBlocks.VARENTIUM_ORE.get());
                pOutput.accept(ModBlocks.DEEPSLATE_VARENTIUM_ORE.get());

                pOutput.accept(ModItems.CIRCADIUM_INGOT.get());
                pOutput.accept(ModItems.CIRCADIUM_BLEND.get());
                pOutput.accept(ModItems.CIRCADIUM_PLATING.get());
                pOutput.accept(ModBlocks.CIRCADIUM_BLOCK.get());

                pOutput.accept(ModItems.ORICHALCOM_ALLOY.get());
                pOutput.accept(ModItems.ORICHALCOM_INGOT.get());
                pOutput.accept(ModItems.ORICHALCOM_NUGGET.get());
                pOutput.accept(ModBlocks.ORICHALCOM_BLOCK.get());

                pOutput.accept(ModItems.RING_OF_TRANSMUTATION.get());
                pOutput.accept(ModItems.RING_OF_HOLDING.get());
                pOutput.accept(ModItems.ORICHALCOM_EGG.get());
                pOutput.accept(ModItems.ASTRAL_STAR.get());

                pOutput.accept(ModItems.COAL_CHUNK.get());
                pOutput.accept(ModItems.CHARCOAL_CHUNK.get());

                pOutput.accept(ModItems.MOSS_BALL.get());

                pOutput.accept(ModBlocks.BLACK_REGLAZED_TERRACOTTA.get());
                pOutput.accept(ModBlocks.BLUE_REGLAZED_TERRACOTTA.get());
                pOutput.accept(ModBlocks.BROWN_REGLAZED_TERRACOTTA.get());
                pOutput.accept(ModBlocks.CYAN_REGLAZED_TERRACOTTA.get());
                pOutput.accept(ModBlocks.GRAY_REGLAZED_TERRACOTTA.get());
                pOutput.accept(ModBlocks.GREEN_REGLAZED_TERRACOTTA.get());
                pOutput.accept(ModBlocks.LIGHT_BLUE_REGLAZED_TERRACOTTA.get());
                pOutput.accept(ModBlocks.LIGHT_GRAY_REGLAZED_TERRACOTTA.get());
                pOutput.accept(ModBlocks.LIME_REGLAZED_TERRACOTTA.get());
                pOutput.accept(ModBlocks.MAGENTA_REGLAZED_TERRACOTTA.get());
                pOutput.accept(ModBlocks.ORANGE_REGLAZED_TERRACOTTA.get());
                pOutput.accept(ModBlocks.PINK_REGLAZED_TERRACOTTA.get());
                pOutput.accept(ModBlocks.PURPLE_REGLAZED_TERRACOTTA.get());
                pOutput.accept(ModBlocks.RED_REGLAZED_TERRACOTTA.get());
                pOutput.accept(ModBlocks.WHITE_REGLAZED_TERRACOTTA.get());
                pOutput.accept(ModBlocks.YELLOW_REGLAZED_TERRACOTTA.get());
                pOutput.accept(ModBlocks.CHISELED_OBSIDIAN.get());
            })
            .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
