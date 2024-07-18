package net.vdelta.sigil_utils.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.vdelta.sigil_utils.SigilUtils;
import net.vdelta.sigil_utils.block.SigilUtils_Blocks;
import net.vdelta.sigil_utils.util.SigilUtils_Tags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class SigilUtils_BlockTagGenerator extends BlockTagsProvider {
    public SigilUtils_BlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, SigilUtils.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(SigilUtils_Tags.Blocks.REGLAZED_TERRACOTTA)
                .add(SigilUtils_Blocks.BLACK_REGLAZED_TERRACOTTA.get(),
                        SigilUtils_Blocks.BLUE_REGLAZED_TERRACOTTA.get(),
                        SigilUtils_Blocks.BLUE_REGLAZED_TERRACOTTA.get(),
                        SigilUtils_Blocks.BROWN_REGLAZED_TERRACOTTA.get(),
                        SigilUtils_Blocks.CYAN_REGLAZED_TERRACOTTA.get(),
                        SigilUtils_Blocks.GRAY_REGLAZED_TERRACOTTA.get(),
                        SigilUtils_Blocks.GREEN_REGLAZED_TERRACOTTA.get(),
                        SigilUtils_Blocks.LIGHT_BLUE_REGLAZED_TERRACOTTA.get(),
                        SigilUtils_Blocks.LIGHT_GRAY_REGLAZED_TERRACOTTA.get(),
                        SigilUtils_Blocks.LIME_REGLAZED_TERRACOTTA.get(),
                        SigilUtils_Blocks.MAGENTA_REGLAZED_TERRACOTTA.get(),
                        SigilUtils_Blocks.ORANGE_REGLAZED_TERRACOTTA.get(),
                        SigilUtils_Blocks.PINK_REGLAZED_TERRACOTTA.get(),
                        SigilUtils_Blocks.PURPLE_REGLAZED_TERRACOTTA.get(),
                        SigilUtils_Blocks.RED_REGLAZED_TERRACOTTA.get(),
                        SigilUtils_Blocks.WHITE_REGLAZED_TERRACOTTA.get(),
                        SigilUtils_Blocks.YELLOW_REGLAZED_TERRACOTTA.get());

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(SigilUtils_Blocks.VARENTIUM_BLOCK.get(),
                        SigilUtils_Blocks.VARENTIUM_ORE.get(),
                        SigilUtils_Blocks.DEEPSLATE_VARENTIUM_ORE.get(),
                        SigilUtils_Blocks.CIRCADIUM_BLOCK.get(),
                        SigilUtils_Blocks.ORICHALCOM_BLOCK.get(),
                        SigilUtils_Blocks.BLACK_REGLAZED_TERRACOTTA.get(),
                        SigilUtils_Blocks.BLUE_REGLAZED_TERRACOTTA.get(),
                        SigilUtils_Blocks.BLUE_REGLAZED_TERRACOTTA.get(),
                        SigilUtils_Blocks.BROWN_REGLAZED_TERRACOTTA.get(),
                        SigilUtils_Blocks.CYAN_REGLAZED_TERRACOTTA.get(),
                        SigilUtils_Blocks.GRAY_REGLAZED_TERRACOTTA.get(),
                        SigilUtils_Blocks.GREEN_REGLAZED_TERRACOTTA.get(),
                        SigilUtils_Blocks.LIGHT_BLUE_REGLAZED_TERRACOTTA.get(),
                        SigilUtils_Blocks.LIGHT_GRAY_REGLAZED_TERRACOTTA.get(),
                        SigilUtils_Blocks.LIME_REGLAZED_TERRACOTTA.get(),
                        SigilUtils_Blocks.MAGENTA_REGLAZED_TERRACOTTA.get(),
                        SigilUtils_Blocks.ORANGE_REGLAZED_TERRACOTTA.get(),
                        SigilUtils_Blocks.PINK_REGLAZED_TERRACOTTA.get(),
                        SigilUtils_Blocks.PURPLE_REGLAZED_TERRACOTTA.get(),
                        SigilUtils_Blocks.RED_REGLAZED_TERRACOTTA.get(),
                        SigilUtils_Blocks.WHITE_REGLAZED_TERRACOTTA.get(),
                        SigilUtils_Blocks.YELLOW_REGLAZED_TERRACOTTA.get(),
                        SigilUtils_Blocks.CHISELED_OBSIDIAN.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(SigilUtils_Blocks.VARENTIUM_BLOCK.get(),
                        SigilUtils_Blocks.VARENTIUM_ORE.get(),
                        SigilUtils_Blocks.DEEPSLATE_VARENTIUM_ORE.get(),
                        SigilUtils_Blocks.CIRCADIUM_BLOCK.get());

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(SigilUtils_Blocks.ORICHALCOM_BLOCK.get(),
                        SigilUtils_Blocks.CHISELED_OBSIDIAN.get());

        this.tag(BlockTags.NEEDS_STONE_TOOL);
    }
}
