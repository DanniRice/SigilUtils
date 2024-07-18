package net.vdelta.sigil_utils.item.custom;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class RingOfTransmutationItem extends Item {
    public RingOfTransmutationItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public ItemStack getCraftingRemainingItem(ItemStack itemStack) {
        return itemStack.copy();
    }

    @Override
    public boolean hasCraftingRemainingItem(ItemStack stack) {
        return true;
    }
}
