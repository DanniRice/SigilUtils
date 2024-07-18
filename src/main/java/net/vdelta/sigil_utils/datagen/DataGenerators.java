package net.vdelta.sigil_utils.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.vdelta.sigil_utils.SigilUtils;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = SigilUtils.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(event.includeServer(), new SigilUtils_RecipeProvider(packOutput));
        generator.addProvider(event.includeServer(), SigilUtils_LootTableProvider.create(packOutput));

        generator.addProvider(event.includeClient(), new SigilUtils_BlockStateProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new SigilUtils_ItemModelProvider(packOutput, existingFileHelper));

        SigilUtils_BlockTagGenerator blockTagGenerator = generator.addProvider(event.includeServer(), new SigilUtils_BlockTagGenerator(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(event.includeServer(), new SigilUtils_ItemTagGenerator(packOutput, lookupProvider, blockTagGenerator.contentsGetter(), existingFileHelper));
    }
}
