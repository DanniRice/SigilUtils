package net.vdelta.sigil_utils.datagen.loot;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;
import net.vdelta.sigil_utils.block.SigilUtils_Blocks;
import net.vdelta.sigil_utils.item.SigilUtils_Items;

import java.util.Set;

public class SigilUtils_BlockLootTables extends BlockLootSubProvider {
    public SigilUtils_BlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(SigilUtils_Blocks.VARENTIUM_BLOCK.get());
        this.dropSelf(SigilUtils_Blocks.CIRCADIUM_BLOCK.get());
        this.dropSelf(SigilUtils_Blocks.ORICHALCOM_BLOCK.get());
        this.dropSelf(SigilUtils_Blocks.BLACK_REGLAZED_TERRACOTTA.get());
        this.dropSelf(SigilUtils_Blocks.BLUE_REGLAZED_TERRACOTTA.get());
        this.dropSelf(SigilUtils_Blocks.BROWN_REGLAZED_TERRACOTTA.get());
        this.dropSelf(SigilUtils_Blocks.CYAN_REGLAZED_TERRACOTTA.get());
        this.dropSelf(SigilUtils_Blocks.GRAY_REGLAZED_TERRACOTTA.get());
        this.dropSelf(SigilUtils_Blocks.GREEN_REGLAZED_TERRACOTTA.get());
        this.dropSelf(SigilUtils_Blocks.LIGHT_BLUE_REGLAZED_TERRACOTTA.get());
        this.dropSelf(SigilUtils_Blocks.LIGHT_GRAY_REGLAZED_TERRACOTTA.get());
        this.dropSelf(SigilUtils_Blocks.LIME_REGLAZED_TERRACOTTA.get());
        this.dropSelf(SigilUtils_Blocks.MAGENTA_REGLAZED_TERRACOTTA.get());
        this.dropSelf(SigilUtils_Blocks.ORANGE_REGLAZED_TERRACOTTA.get());
        this.dropSelf(SigilUtils_Blocks.PINK_REGLAZED_TERRACOTTA.get());
        this.dropSelf(SigilUtils_Blocks.PURPLE_REGLAZED_TERRACOTTA.get());
        this.dropSelf(SigilUtils_Blocks.RED_REGLAZED_TERRACOTTA.get());
        this.dropSelf(SigilUtils_Blocks.WHITE_REGLAZED_TERRACOTTA.get());
        this.dropSelf(SigilUtils_Blocks.YELLOW_REGLAZED_TERRACOTTA.get());
        this.dropSelf(SigilUtils_Blocks.CHISELED_OBSIDIAN.get());

        this.add(SigilUtils_Blocks.VARENTIUM_ORE.get(),
                block -> createVarentiumOreDrops(SigilUtils_Blocks.VARENTIUM_ORE.get(), SigilUtils_Items.VARENTIUM.get()));
        this.add(SigilUtils_Blocks.DEEPSLATE_VARENTIUM_ORE.get(),
                block -> createVarentiumOreDrops(SigilUtils_Blocks.DEEPSLATE_VARENTIUM_ORE.get(), SigilUtils_Items.VARENTIUM.get()));
    }

    protected LootTable.Builder createVarentiumOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 4.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return SigilUtils_Blocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
