package net.vdelta.sigil_utils.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.vdelta.sigil_utils.SigilUtils;
import net.vdelta.sigil_utils.item.SigilUtils_Items;

public class SigilUtils_ItemModelProvider extends ItemModelProvider {
    public SigilUtils_ItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, SigilUtils.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(SigilUtils_Items.VARENTIUM);
        simpleItem(SigilUtils_Items.VARENTIUM_SHARD);
        simpleItem(SigilUtils_Items.CIRCADIUM_INGOT);
        simpleItem(SigilUtils_Items.CIRCADIUM_BLEND);
        simpleItem(SigilUtils_Items.CIRCADIUM_PLATING);
        simpleItem(SigilUtils_Items.ORICHALCOM_ALLOY);
        simpleItem(SigilUtils_Items.ORICHALCOM_INGOT);
        simpleItem(SigilUtils_Items.ORICHALCOM_NUGGET);

        simpleItem(SigilUtils_Items.RING_OF_TRANSMUTATION);
        simpleItem(SigilUtils_Items.RING_OF_HOLDING);
        simpleItem(SigilUtils_Items.ORICHALCOM_EGG);
        simpleItem(SigilUtils_Items.ASTRAL_STAR);

        simpleItem(SigilUtils_Items.COAL_CHUNK);
        simpleItem(SigilUtils_Items.CHARCOAL_CHUNK);

        simpleItem(SigilUtils_Items.MOSS_BALL);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(SigilUtils.MOD_ID, "item/" + item.getId().getPath()));
    }
}
