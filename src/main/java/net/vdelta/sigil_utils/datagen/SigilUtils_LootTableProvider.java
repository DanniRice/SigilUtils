package net.vdelta.sigil_utils.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.vdelta.sigil_utils.datagen.loot.SigilUtils_BlockLootTables;

import java.util.List;
import java.util.Set;

public class SigilUtils_LootTableProvider {
    public static LootTableProvider create(PackOutput output) {
        return new LootTableProvider(output, Set.of(), List.of(
                new LootTableProvider.SubProviderEntry(SigilUtils_BlockLootTables::new, LootContextParamSets.BLOCK)
        ));
    }
}
