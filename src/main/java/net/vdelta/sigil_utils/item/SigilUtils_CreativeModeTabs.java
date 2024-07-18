package net.vdelta.sigil_utils.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.vdelta.sigil_utils.SigilUtils;
import net.vdelta.sigil_utils.block.SigilUtils_Blocks;

public class SigilUtils_CreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SigilUtils.MOD_ID);

    public static final RegistryObject<CreativeModeTab> SIGIL_UTILS_TAB = CREATIVE_MODE_TABS.register("sigil_utils_tab", () -> CreativeModeTab.builder().icon(() -> new ItemStack(SigilUtils_Items.RING_OF_TRANSMUTATION.get()))
            .title(Component.translatable("creativetab.sigil_utils_tab"))
            .displayItems((pParameters, pOutput) -> {
                pOutput.accept(SigilUtils_Items.VARENTIUM.get());
                pOutput.accept(SigilUtils_Items.VARENTIUM_SHARD.get());
                pOutput.accept(SigilUtils_Blocks.VARENTIUM_BLOCK.get());
                pOutput.accept(SigilUtils_Blocks.VARENTIUM_ORE.get());
                pOutput.accept(SigilUtils_Blocks.DEEPSLATE_VARENTIUM_ORE.get());

                pOutput.accept(SigilUtils_Items.CIRCADIUM_INGOT.get());
                pOutput.accept(SigilUtils_Items.CIRCADIUM_BLEND.get());
                pOutput.accept(SigilUtils_Items.CIRCADIUM_PLATING.get());
                pOutput.accept(SigilUtils_Blocks.CIRCADIUM_BLOCK.get());

                pOutput.accept(SigilUtils_Items.ORICHALCOM_ALLOY.get());
                pOutput.accept(SigilUtils_Items.ORICHALCOM_INGOT.get());
                pOutput.accept(SigilUtils_Items.ORICHALCOM_NUGGET.get());
                pOutput.accept(SigilUtils_Blocks.ORICHALCOM_BLOCK.get());

                pOutput.accept(SigilUtils_Items.RING_OF_TRANSMUTATION.get());
                pOutput.accept(SigilUtils_Items.RING_OF_HOLDING.get());
                pOutput.accept(SigilUtils_Items.ORICHALCOM_EGG.get());
                pOutput.accept(SigilUtils_Items.ASTRAL_STAR.get());

                pOutput.accept(SigilUtils_Items.COAL_CHUNK.get());
                pOutput.accept(SigilUtils_Items.CHARCOAL_CHUNK.get());

                pOutput.accept(SigilUtils_Items.MOSS_BALL.get());

                pOutput.accept(SigilUtils_Blocks.BLACK_REGLAZED_TERRACOTTA.get());
                pOutput.accept(SigilUtils_Blocks.BLUE_REGLAZED_TERRACOTTA.get());
                pOutput.accept(SigilUtils_Blocks.BROWN_REGLAZED_TERRACOTTA.get());
                pOutput.accept(SigilUtils_Blocks.CYAN_REGLAZED_TERRACOTTA.get());
                pOutput.accept(SigilUtils_Blocks.GRAY_REGLAZED_TERRACOTTA.get());
                pOutput.accept(SigilUtils_Blocks.GREEN_REGLAZED_TERRACOTTA.get());
                pOutput.accept(SigilUtils_Blocks.LIGHT_BLUE_REGLAZED_TERRACOTTA.get());
                pOutput.accept(SigilUtils_Blocks.LIGHT_GRAY_REGLAZED_TERRACOTTA.get());
                pOutput.accept(SigilUtils_Blocks.LIME_REGLAZED_TERRACOTTA.get());
                pOutput.accept(SigilUtils_Blocks.MAGENTA_REGLAZED_TERRACOTTA.get());
                pOutput.accept(SigilUtils_Blocks.ORANGE_REGLAZED_TERRACOTTA.get());
                pOutput.accept(SigilUtils_Blocks.PINK_REGLAZED_TERRACOTTA.get());
                pOutput.accept(SigilUtils_Blocks.PURPLE_REGLAZED_TERRACOTTA.get());
                pOutput.accept(SigilUtils_Blocks.RED_REGLAZED_TERRACOTTA.get());
                pOutput.accept(SigilUtils_Blocks.WHITE_REGLAZED_TERRACOTTA.get());
                pOutput.accept(SigilUtils_Blocks.YELLOW_REGLAZED_TERRACOTTA.get());
                pOutput.accept(SigilUtils_Blocks.CHISELED_OBSIDIAN.get());
            })
            .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
