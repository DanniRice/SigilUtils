package net.vdelta.sigil_utils.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.vdelta.sigil_utils.SigilUtils;
import net.vdelta.sigil_utils.block.SigilUtils_Blocks;
import net.vdelta.sigil_utils.item.SigilUtils_Items;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Consumer;

public class SigilUtils_RecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> VARENTIUM_SMELTABLES = List.of(SigilUtils_Blocks.VARENTIUM_ORE.get(), SigilUtils_Blocks.DEEPSLATE_VARENTIUM_ORE.get());

    public SigilUtils_RecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        // varentium - temp recipe, until i get ore generation sorted
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, SigilUtils_Items.VARENTIUM.get())
                .pattern("RL")
                .pattern("LR")
                .define('R', Items.REDSTONE)
                .define('L', Items.LAPIS_LAZULI)
                .unlockedBy(getHasName(SigilUtils_Items.VARENTIUM.get()), has(SigilUtils_Items.VARENTIUM.get()))
                .save(pWriter, "varentium");

        // cooking varentium ores into varentium
        oreSmelting(pWriter, VARENTIUM_SMELTABLES, RecipeCategory.MISC, SigilUtils_Items.VARENTIUM.get(), 0.7f, 200, "varentium");
        oreBlasting(pWriter, VARENTIUM_SMELTABLES, RecipeCategory.MISC, SigilUtils_Items.VARENTIUM.get(), 0.7f, 100, "varentium");

        // varentium block
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, SigilUtils_Blocks.VARENTIUM_BLOCK.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', SigilUtils_Items.VARENTIUM.get())
                .unlockedBy(getHasName(SigilUtils_Items.VARENTIUM.get()), has(SigilUtils_Items.VARENTIUM.get()))
                .save(pWriter, "varentium_block");

        // varentium from block
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, SigilUtils_Items.VARENTIUM.get(), 9)
                .requires(SigilUtils_Blocks.VARENTIUM_BLOCK.get())
                .unlockedBy(getHasName(SigilUtils_Blocks.VARENTIUM_BLOCK.get()), has(SigilUtils_Blocks.VARENTIUM_BLOCK.get()))
                .save(pWriter, "varentium_from_block");

        // varentium shards
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, SigilUtils_Items.VARENTIUM_SHARD.get(), 9)
                .requires(SigilUtils_Items.VARENTIUM.get())
                .unlockedBy(getHasName(SigilUtils_Items.VARENTIUM_SHARD.get()), has(SigilUtils_Items.VARENTIUM.get()))
                .save(pWriter, "varentium_shard");

        // varentium from shards
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, SigilUtils_Items.VARENTIUM.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', SigilUtils_Items.VARENTIUM_SHARD.get())
                .unlockedBy(getHasName(SigilUtils_Items.VARENTIUM_SHARD.get()), has(SigilUtils_Items.VARENTIUM_SHARD.get()))
                .save(pWriter, "varentium_from_shards");

        // circadium ingots
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, SigilUtils_Items.CIRCADIUM_INGOT.get(), 2)
                .requires(SigilUtils_Items.RING_OF_TRANSMUTATION.get())
                .requires(Items.AMETHYST_SHARD).requires(Items.AMETHYST_SHARD)
                .requires(Items.BLAZE_POWDER).requires(Items.BLAZE_POWDER)
                .unlockedBy(getHasName(SigilUtils_Items.RING_OF_TRANSMUTATION.get()), has(SigilUtils_Items.RING_OF_TRANSMUTATION.get()))
                .save(pWriter, "circadium_ingot");

        // circadium blend
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, SigilUtils_Items.CIRCADIUM_BLEND.get(), 4)
                .requires(SigilUtils_Items.CIRCADIUM_INGOT.get())
                .unlockedBy(getHasName(SigilUtils_Items.CIRCADIUM_INGOT.get()), has(SigilUtils_Items.CIRCADIUM_INGOT.get()))
                .save(pWriter, "circadium_blend");

        // circadium plating
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, SigilUtils_Items.CIRCADIUM_PLATING.get())
                .pattern("CC")
                .pattern("CC")
                .define('C', SigilUtils_Items.CIRCADIUM_INGOT.get())
                .unlockedBy(getHasName(SigilUtils_Items.CIRCADIUM_INGOT.get()), has(SigilUtils_Items.CIRCADIUM_INGOT.get()))
                .save(pWriter, "circadium_plating");

        // circadium block
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, SigilUtils_Blocks.CIRCADIUM_BLOCK.get())
                .pattern("CC")
                .pattern("CC")
                .define('C', SigilUtils_Items.CIRCADIUM_PLATING.get())
                .unlockedBy(getHasName(SigilUtils_Items.CIRCADIUM_PLATING.get()), has(SigilUtils_Items.CIRCADIUM_PLATING.get()))
                .save(pWriter, "circadium_block");

        // circadium ingots from block
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, SigilUtils_Items.CIRCADIUM_INGOT.get(), 16)
                .requires(SigilUtils_Blocks.CIRCADIUM_BLOCK.get())
                .unlockedBy(getHasName(SigilUtils_Blocks.CIRCADIUM_BLOCK.get()), has(SigilUtils_Blocks.CIRCADIUM_BLOCK.get()))
                .save(pWriter, "circadium_ingots_from_block");

        // orichalcom alloy
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, SigilUtils_Items.ORICHALCOM_ALLOY.get())
                .pattern("CVC")
                .pattern("VRV")
                .pattern("CVC")
                .define('C', SigilUtils_Items.CIRCADIUM_BLEND.get())
                .define('V', SigilUtils_Items.VARENTIUM.get())
                .define('R', SigilUtils_Items.RING_OF_TRANSMUTATION.get())
                .unlockedBy(getHasName(SigilUtils_Items.CIRCADIUM_BLEND.get()), has(SigilUtils_Items.CIRCADIUM_BLEND.get()))
                .save(pWriter, "orichalcom_alloy");

        // cooking orichalcom alloy into an orichalcom ingot
        oreSmelting(pWriter, List.of(SigilUtils_Items.ORICHALCOM_ALLOY.get()), RecipeCategory.MISC, SigilUtils_Items.ORICHALCOM_INGOT.get(), 0.7f, 200, "orichalcom");
        oreBlasting(pWriter, List.of(SigilUtils_Items.ORICHALCOM_ALLOY.get()), RecipeCategory.MISC, SigilUtils_Items.ORICHALCOM_INGOT.get(), 0.7f, 100, "orichalcom");

        // orichalcom block
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, SigilUtils_Blocks.ORICHALCOM_BLOCK.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', SigilUtils_Items.ORICHALCOM_INGOT.get())
                .unlockedBy(getHasName(SigilUtils_Items.ORICHALCOM_INGOT.get()), has(SigilUtils_Items.ORICHALCOM_INGOT.get()))
                .save(pWriter, "orichalcom_block");

        // orichalcom from block
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, SigilUtils_Items.ORICHALCOM_INGOT.get(), 9)
                .requires(SigilUtils_Blocks.ORICHALCOM_BLOCK.get())
                .unlockedBy(getHasName(SigilUtils_Blocks.ORICHALCOM_BLOCK.get()), has(SigilUtils_Blocks.ORICHALCOM_BLOCK.get()))
                .save(pWriter, "orichalcom_ingots_from_block");

        // orichalcom nuggets
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, SigilUtils_Items.ORICHALCOM_NUGGET.get(), 9)
                .requires(SigilUtils_Items.ORICHALCOM_INGOT.get())
                .unlockedBy(getHasName(SigilUtils_Items.ORICHALCOM_NUGGET.get()), has(SigilUtils_Items.ORICHALCOM_INGOT.get()))
                .save(pWriter, "orichalcom_nugget");

        // orichalcom from nuggets
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, SigilUtils_Items.ORICHALCOM_INGOT.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', SigilUtils_Items.ORICHALCOM_NUGGET.get())
                .unlockedBy(getHasName(SigilUtils_Items.ORICHALCOM_NUGGET.get()), has(SigilUtils_Items.ORICHALCOM_NUGGET.get()))
                .save(pWriter, "orichalcom_ingot_from_nuggets");

        // astral star
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, SigilUtils_Items.ASTRAL_STAR.get())
                .pattern("OVO")
                .pattern("VNV")
                .pattern("OVO")
                .define('O', SigilUtils_Items.ORICHALCOM_INGOT.get())
                .define('V', SigilUtils_Items.VARENTIUM.get())
                .define('N', Items.NETHER_STAR)
                .unlockedBy(getHasName(Items.NETHER_STAR), has(Items.NETHER_STAR))
                .save(pWriter, "astral_star");

        // reglazed terracottas
        reglazedTerracottaRecipe(Items.BLACK_GLAZED_TERRACOTTA, SigilUtils_Blocks.BLACK_REGLAZED_TERRACOTTA.get(), pWriter, "black_reglazed_terracotta");
        reglazedTerracottaRecipe(Items.BLUE_GLAZED_TERRACOTTA, SigilUtils_Blocks.BLUE_REGLAZED_TERRACOTTA.get(), pWriter, "blue_reglazed_terracotta");
        reglazedTerracottaRecipe(Items.BROWN_GLAZED_TERRACOTTA, SigilUtils_Blocks.BROWN_REGLAZED_TERRACOTTA.get(), pWriter, "brown_reglazed_terracotta");
        reglazedTerracottaRecipe(Items.CYAN_GLAZED_TERRACOTTA, SigilUtils_Blocks.CYAN_REGLAZED_TERRACOTTA.get(), pWriter, "cyan_reglazed_terracotta");
        reglazedTerracottaRecipe(Items.GRAY_GLAZED_TERRACOTTA, SigilUtils_Blocks.GRAY_REGLAZED_TERRACOTTA.get(), pWriter, "gray_reglazed_terracotta");
        reglazedTerracottaRecipe(Items.GREEN_GLAZED_TERRACOTTA, SigilUtils_Blocks.GREEN_REGLAZED_TERRACOTTA.get(), pWriter, "green_reglazed_terracotta");
        reglazedTerracottaRecipe(Items.LIGHT_BLUE_GLAZED_TERRACOTTA, SigilUtils_Blocks.LIGHT_BLUE_REGLAZED_TERRACOTTA.get(), pWriter, "light_blue_reglazed_terracotta");
        reglazedTerracottaRecipe(Items.LIGHT_GRAY_GLAZED_TERRACOTTA, SigilUtils_Blocks.LIGHT_GRAY_REGLAZED_TERRACOTTA.get(), pWriter, "light_gray_reglazed_terracotta");
        reglazedTerracottaRecipe(Items.LIME_GLAZED_TERRACOTTA, SigilUtils_Blocks.LIME_REGLAZED_TERRACOTTA.get(), pWriter, "lime_reglazed_terracotta");
        reglazedTerracottaRecipe(Items.MAGENTA_GLAZED_TERRACOTTA, SigilUtils_Blocks.MAGENTA_REGLAZED_TERRACOTTA.get(), pWriter, "magenta_reglazed_terracotta");
        reglazedTerracottaRecipe(Items.ORANGE_GLAZED_TERRACOTTA, SigilUtils_Blocks.ORANGE_REGLAZED_TERRACOTTA.get(), pWriter, "orange_reglazed_terracotta");
        reglazedTerracottaRecipe(Items.PINK_GLAZED_TERRACOTTA, SigilUtils_Blocks.PINK_REGLAZED_TERRACOTTA.get(), pWriter, "pink_reglazed_terracotta");
        reglazedTerracottaRecipe(Items.PURPLE_GLAZED_TERRACOTTA, SigilUtils_Blocks.PURPLE_REGLAZED_TERRACOTTA.get(), pWriter, "purple_reglazed_terracotta");
        reglazedTerracottaRecipe(Items.RED_GLAZED_TERRACOTTA, SigilUtils_Blocks.RED_REGLAZED_TERRACOTTA.get(), pWriter, "red_reglazed_terracotta");
        reglazedTerracottaRecipe(Items.WHITE_GLAZED_TERRACOTTA, SigilUtils_Blocks.WHITE_REGLAZED_TERRACOTTA.get(), pWriter, "white_reglazed_terracotta");
        reglazedTerracottaRecipe(Items.YELLOW_GLAZED_TERRACOTTA, SigilUtils_Blocks.YELLOW_REGLAZED_TERRACOTTA.get(), pWriter, "yellow_reglazed_terracotta");

        // chiseled obsidian
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Items.OBSIDIAN), RecipeCategory.BUILDING_BLOCKS, SigilUtils_Blocks.CHISELED_OBSIDIAN.get());

        // coal chunks
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, SigilUtils_Items.COAL_CHUNK.get(), 8)
                .requires(Items.COAL)
                .unlockedBy(getHasName(Items.COAL), has(Items.COAL))
                .save(pWriter);

        // coal from chunks
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.COAL)
                .requires(SigilUtils_Items.COAL_CHUNK.get()).requires(SigilUtils_Items.COAL_CHUNK.get()).requires(SigilUtils_Items.COAL_CHUNK.get()).requires(SigilUtils_Items.COAL_CHUNK.get()).requires(SigilUtils_Items.COAL_CHUNK.get()).requires(SigilUtils_Items.COAL_CHUNK.get()).requires(SigilUtils_Items.COAL_CHUNK.get()).requires(SigilUtils_Items.COAL_CHUNK.get())
                .unlockedBy(getHasName(SigilUtils_Items.COAL_CHUNK.get()), has(SigilUtils_Items.COAL_CHUNK.get()))
                .save(pWriter);

        // charcoal chunks
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, SigilUtils_Items.CHARCOAL_CHUNK.get(), 8)
                .requires(Items.CHARCOAL)
                .unlockedBy(getHasName(Items.CHARCOAL), has(Items.CHARCOAL))
                .save(pWriter);

        // charcoal from chunks
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.CHARCOAL)
                .requires(SigilUtils_Items.CHARCOAL_CHUNK.get()).requires(SigilUtils_Items.CHARCOAL_CHUNK.get()).requires(SigilUtils_Items.CHARCOAL_CHUNK.get()).requires(SigilUtils_Items.CHARCOAL_CHUNK.get()).requires(SigilUtils_Items.CHARCOAL_CHUNK.get()).requires(SigilUtils_Items.CHARCOAL_CHUNK.get()).requires(SigilUtils_Items.CHARCOAL_CHUNK.get()).requires(SigilUtils_Items.CHARCOAL_CHUNK.get())
                .unlockedBy(getHasName(SigilUtils_Items.CHARCOAL_CHUNK.get()), has(SigilUtils_Items.CHARCOAL_CHUNK.get()))
                .save(pWriter);

        // moss balls
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, SigilUtils_Items.MOSS_BALL.get(), 4)
                .requires(Items.MOSS_BLOCK)
                .unlockedBy(getHasName(Items.MOSS_BLOCK), has(Items.MOSS_BLOCK))
                .save(pWriter);

        // ring of transmutation
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, SigilUtils_Items.RING_OF_TRANSMUTATION.get())
                .pattern(" V ")
                .pattern("VNV")
                .pattern(" V ")
                .define('V', SigilUtils_Items.VARENTIUM.get())
                .define('N', Items.NETHERITE_INGOT)
                .unlockedBy(getHasName(Items.NETHERITE_INGOT), has(Items.NETHERITE_INGOT))
                .save(pWriter);

        // transmutation recipes
        oneToOneTransmutationRecipe(Items.COAL, Items.CHARCOAL, pWriter, "coal_to_charcoal", "charcoal_to_coal");
        oneToOneTransmutationRecipe(Items.AMETHYST_SHARD, Items.QUARTZ, pWriter, "amethyst_to_quartz", "quartz_to_amethyst");
        oneToOneTransmutationRecipe(Items.SAND, Items.GRAVEL, pWriter, "sand_to_gravel", "gravel_to_sand");
        oneToOneTransmutationRecipe(Items.REDSTONE, Items.GLOWSTONE_DUST, pWriter, "redstone_to_glowstone", "glowstone_to_redstone");
        oneToOneTransmutationRecipe(Items.RED_MUSHROOM, Items.BROWN_MUSHROOM, pWriter, "red_mushroom_to_brown_mushroom", "brown_mushroom_to_red_mushroom");
        oneToOneTransmutationRecipe(Items.RED_MUSHROOM_BLOCK, Items.BROWN_MUSHROOM_BLOCK, pWriter, "red_mushroom_block_to_brown_mushroom_block", "brown_mushroom_block_to_red_mushroom_block");
        twoToOneTransmutationRecipe(Items.BLAZE_ROD, Items.PRISMARINE_SHARD, pWriter, "blaze_to_prismarine", "prismarine_to_blaze");
        fourToOneTransmutationRecipe(Items.GOLD_INGOT, Items.IRON_INGOT, pWriter, "gold_to_iron", "iron_to_gold");
        fourToOneTransmutationRecipe(Items.DIAMOND, Items.GOLD_INGOT, pWriter, "diamond_to_gold", "gold_to_diamond");
        eightToOneTransmutationRecipe(Items.IRON_INGOT, Items.COPPER_INGOT, pWriter, "iron_to_copper", "copper_to_iron");
        eightToOneTransmutationRecipe(Items.DIAMOND, Items.EMERALD, pWriter, "diamond_to_emerald", "emerald_to_diamond");

        // blackstone
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Items.BLACKSTONE)
                .pattern("BC")
                .pattern("CB")
                .define('B', Items.BASALT)
                .define('C', Items.COAL)
                .unlockedBy(getHasName(Items.BLACKSTONE), has(Items.BLACKSTONE))
                .save(pWriter);

        // bread
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.BREAD)
                .requires(Items.WHEAT).requires(Items.WHEAT).requires(Items.WHEAT)
                .unlockedBy(getHasName(Items.WHEAT), has(Items.WHEAT))
                .save(pWriter, "bread_shapeless");

        // bundle
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.BUNDLE)
                .pattern("SRS")
                .pattern("R R")
                .pattern("RRR")
                .define('R', Items.RABBIT_HIDE)
                .define('S', Items.STRING)
                .unlockedBy(getHasName(Items.RABBIT_HIDE), has(Items.RABBIT_HIDE))
                .save(pWriter);

        // gravel from flint
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Items.GRAVEL)
                .pattern("FF")
                .pattern("FF")
                .define('F', Items.FLINT)
                .unlockedBy(getHasName(Items.FLINT), has(Items.FLINT))
                .save(pWriter, "gravel_from_flint");

        // name tag
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.NAME_TAG)
                .pattern(" IS")
                .pattern(" PI")
                .pattern("P  ")
                .define('I', Items.IRON_NUGGET)
                .define('S', Items.STRING)
                .define('P', Items.PAPER)
                .unlockedBy(getHasName(Items.PAPER), has(Items.PAPER))
                .save(pWriter);

        // paper
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.PAPER)
                .requires(Items.SUGAR_CANE).requires(Items.SUGAR_CANE).requires(Items.SUGAR_CANE)
                .unlockedBy(getHasName(Items.SUGAR_CANE), has(Items.SUGAR_CANE))
                .save(pWriter, "paper_shapeless");

        // shulker box
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.SHULKER_BOX)
                .requires(Items.SHULKER_SHELL)
                .requires(Items.CHEST)
                .requires(Items.SHULKER_SHELL)
                .unlockedBy(getHasName(Items.SHULKER_SHELL), has(Items.SHULKER_SHELL))
                .save(pWriter, "shulker_box_shapeless");

        // raw metal blocks → metal blocks
        oreBlasting(pWriter, List.of(Items.RAW_COPPER_BLOCK), RecipeCategory.MISC, Items.COPPER_BLOCK, 1f, 400, "copper");
        oreBlasting(pWriter, List.of(Items.RAW_GOLD_BLOCK), RecipeCategory.MISC, Items.GOLD_BLOCK, 1f, 400, "gold");
        oreBlasting(pWriter, List.of(Items.RAW_IRON_BLOCK), RecipeCategory.MISC, Items.IRON_BLOCK, 1f, 400, "iron");

        // spawn eggs
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, SigilUtils_Items.ORICHALCOM_EGG.get(), 4)
                .pattern(" O ")
                .pattern("OEO")
                .pattern(" O ")
                .define('O', SigilUtils_Items.ORICHALCOM_INGOT.get())
                .define('E', Items.EGG)
                .unlockedBy(getHasName(SigilUtils_Items.ORICHALCOM_INGOT.get()), has(SigilUtils_Items.ORICHALCOM_INGOT.get()))
                .save(pWriter, "orichalcom_egg");

        spawnEggRecipe(SigilUtils_Items.ORICHALCOM_EGG.get(), Items.COOKED_BEEF, Items.LEATHER, Items.COW_SPAWN_EGG, pWriter);
        spawnEggRecipe(SigilUtils_Items.ORICHALCOM_EGG.get(), Items.COOKED_CHICKEN, Items.FEATHER, Items.CHICKEN_SPAWN_EGG, pWriter);
        spawnEggRecipe(SigilUtils_Items.ORICHALCOM_EGG.get(), Items.COOKED_PORKCHOP, Items.COOKED_PORKCHOP, Items.PIG_SPAWN_EGG, pWriter);

        // thank you sheep for being complicated
        TagKey<Item> wool = ItemTags.create(new ResourceLocation("minecraft", "wool"));
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.SHEEP_SPAWN_EGG)
                .pattern(" M ")
                .pattern("WOW")
                .pattern(" M ")
                .define('O', SigilUtils_Items.ORICHALCOM_EGG.get())
                .define('M', Items.COOKED_MUTTON)
                .define('W', Ingredient.of(wool))
                .unlockedBy(getHasName(SigilUtils_Items.ORICHALCOM_EGG.get()), has(SigilUtils_Items.ORICHALCOM_EGG.get()))
                .save(pWriter);

        spawnEggRecipe(SigilUtils_Items.ORICHALCOM_EGG.get(), Items.EMERALD, Items.EMERALD, Items.VILLAGER_SPAWN_EGG, pWriter);
        spawnEggRecipe(SigilUtils_Items.ORICHALCOM_EGG.get(), Items.ROTTEN_FLESH, Items.ROTTEN_FLESH, Items.ZOMBIE_SPAWN_EGG, pWriter);
        spawnEggRecipe(SigilUtils_Items.ORICHALCOM_EGG.get(), Items.BONE, Items.ARROW, Items.SKELETON_SPAWN_EGG, pWriter);
        spawnEggRecipe(SigilUtils_Items.ORICHALCOM_EGG.get(), Items.GUNPOWDER, Items.GUNPOWDER, Items.CREEPER_SPAWN_EGG, pWriter);
        spawnEggRecipe(SigilUtils_Items.ORICHALCOM_EGG.get(), Items.STRING, Items.SPIDER_EYE, Items.SPIDER_SPAWN_EGG, pWriter);
        spawnEggRecipe(SigilUtils_Items.ORICHALCOM_EGG.get(), Items.ENDER_PEARL, Items.ENDER_PEARL, Items.ENDERMAN_SPAWN_EGG, pWriter);
        spawnEggRecipe(SigilUtils_Items.ORICHALCOM_EGG.get(), Items.BLAZE_ROD, Items.BLAZE_ROD, Items.BLAZE_SPAWN_EGG, pWriter);
        spawnEggRecipe(SigilUtils_Items.ORICHALCOM_EGG.get(), Items.GHAST_TEAR, Items.GUNPOWDER, Items.GHAST_SPAWN_EGG, pWriter);
        spawnEggRecipe(SigilUtils_Items.ORICHALCOM_EGG.get(), Items.SHULKER_SHELL, Items.SHULKER_SHELL, Items.SHULKER_SPAWN_EGG, pWriter);

        // some of these are transmutation recipes
        spawnEggTransmutationRecipe(Items.COW_SPAWN_EGG, Items.LEATHER_HORSE_ARMOR, Items.HORSE_SPAWN_EGG, pWriter);
        spawnEggTransmutationRecipe(Items.ZOMBIE_SPAWN_EGG, Items.NAUTILUS_SHELL, Items.DROWNED_SPAWN_EGG, pWriter);
        spawnEggTransmutationRecipe(Items.SKELETON_SPAWN_EGG, Items.BLUE_ICE, Items.STRAY_SPAWN_EGG, pWriter);
        spawnEggTransmutationRecipe(Items.VILLAGER_SPAWN_EGG, Items.CROSSBOW, Items.PILLAGER_SPAWN_EGG, pWriter);
        spawnEggTransmutationRecipe(Items.VILLAGER_SPAWN_EGG, Items.SPLASH_POTION, Items.WITCH_SPAWN_EGG, pWriter);
        spawnEggTransmutationRecipe(Items.VILLAGER_SPAWN_EGG, Items.IRON_AXE, Items.VINDICATOR_SPAWN_EGG, pWriter);
        spawnEggTransmutationRecipe(Items.VILLAGER_SPAWN_EGG, Items.TOTEM_OF_UNDYING, Items.EVOKER_SPAWN_EGG, pWriter);
        spawnEggTransmutationRecipe(Items.SKELETON_SPAWN_EGG, Items.WITHER_SKELETON_SKULL, Items.WITHER_SKELETON_SPAWN_EGG, pWriter);
        spawnEggTransmutationRecipe(Items.VILLAGER_SPAWN_EGG, Items.GOLD_INGOT, Items.PIGLIN_SPAWN_EGG, pWriter);
        spawnEggTransmutationRecipe(Items.ZOMBIE_SPAWN_EGG, Items.PORKCHOP, Items.ZOMBIFIED_PIGLIN_SPAWN_EGG, pWriter);

        // budding amethyst
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.BUDDING_AMETHYST)
                .pattern("BSB")
                .pattern("SAS")
                .pattern("BSB")
                .define('B', Items.AMETHYST_BLOCK)
                .define('S', Items.AMETHYST_SHARD)
                .define('A', SigilUtils_Items.ASTRAL_STAR.get())
                .unlockedBy(getHasName(SigilUtils_Items.ASTRAL_STAR.get()), has(SigilUtils_Items.ASTRAL_STAR.get()))
                .save(pWriter);

        // dragon egg
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.DRAGON_EGG)
                .pattern("BHB")
                .pattern("HAH")
                .pattern("BHB")
                .define('B', Items.DRAGON_BREATH)
                .define('H', Items.DRAGON_HEAD)
                .define('A', SigilUtils_Items.ASTRAL_STAR.get())
                .unlockedBy(getHasName(SigilUtils_Items.ASTRAL_STAR.get()), has(SigilUtils_Items.ASTRAL_STAR.get()))
                .save(pWriter);

        // elytra
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.ELYTRA)
                .pattern("PEP")
                .pattern("EAE")
                .pattern("PEP")
                .define('P', Items.PURPUR_BLOCK)
                .define('E', Items.ENDER_PEARL)
                .define('A', SigilUtils_Items.ASTRAL_STAR.get())
                .unlockedBy(getHasName(SigilUtils_Items.ASTRAL_STAR.get()), has(SigilUtils_Items.ASTRAL_STAR.get()))
                .save(pWriter);

        // enchanted golden apple
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.ENCHANTED_GOLDEN_APPLE)
                .pattern("BIB")
                .pattern("IAI")
                .pattern("BIB")
                .define('B', Items.GOLD_BLOCK)
                .define('I', Items.GOLD_INGOT)
                .define('A', SigilUtils_Items.ASTRAL_STAR.get())
                .unlockedBy(getHasName(SigilUtils_Items.ASTRAL_STAR.get()), has(SigilUtils_Items.ASTRAL_STAR.get()))
                .save(pWriter);

        // nether star
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.NETHER_STAR)
                .requires(SigilUtils_Items.RING_OF_TRANSMUTATION.get())
                .requires(Items.WITHER_SKELETON_SKULL).requires(Items.WITHER_SKELETON_SKULL).requires(Items.WITHER_SKELETON_SKULL)
                .requires(Items.SOUL_SAND).requires(Items.SOUL_SAND).requires(Items.SOUL_SAND).requires(Items.SOUL_SAND)
                .requires(SigilUtils_Items.ORICHALCOM_INGOT.get())
                .unlockedBy(getHasName(SigilUtils_Items.ORICHALCOM_INGOT.get()), has(SigilUtils_Items.ORICHALCOM_INGOT.get()))
                .save(pWriter);

        // spawner
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.SPAWNER)
                .pattern("MHM")
                .pattern("CAL")
                .pattern("MBM")
                .define('M', Items.MOSSY_COBBLESTONE)
                .define('H', Items.CHAINMAIL_HELMET)
                .define('C', Items.CHAINMAIL_CHESTPLATE)
                .define('A', SigilUtils_Items.ASTRAL_STAR.get())
                .define('L', Items.CHAINMAIL_LEGGINGS)
                .define('B', Items.CHAINMAIL_BOOTS)
                .unlockedBy(getHasName(SigilUtils_Items.ASTRAL_STAR.get()), has(SigilUtils_Items.ASTRAL_STAR.get()))
                .save(pWriter);

        // totem of undying
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.TOTEM_OF_UNDYING)
                .pattern("GEG")
                .pattern("EAE")
                .pattern("GEG")
                .define('G', Items.GOLDEN_APPLE)
                .define('E', Items.EMERALD_BLOCK)
                .define('A', SigilUtils_Items.ASTRAL_STAR.get())
                .unlockedBy(getHasName(SigilUtils_Items.ASTRAL_STAR.get()), has(SigilUtils_Items.ASTRAL_STAR.get()))
                .save(pWriter);

        // trident
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.TRIDENT)
                .pattern("PNP")
                .pattern("NAN")
                .pattern("PNP")
                .define('P', Items.PRISMARINE_SHARD)
                .define('N', Items.NAUTILUS_SHELL)
                .define('A', SigilUtils_Items.ASTRAL_STAR.get())
                .unlockedBy(getHasName(SigilUtils_Items.ASTRAL_STAR.get()), has(SigilUtils_Items.ASTRAL_STAR.get()))
                .save(pWriter);
    }

    // function to make the recipes for converting glazed terracotta into reglazed terracotta and vice versa
    public static void reglazedTerracottaRecipe(ItemLike glazed, ItemLike reglazed, Consumer<FinishedRecipe> pWriter, String recipe_name) {
        // glazed → reglazed
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, reglazed)
                .pattern("TT")
                .pattern("TT")
                .define('T', glazed)
                .unlockedBy(getHasName(glazed), has(glazed))
                .save(pWriter, recipe_name);
        // reglazed → glazed
        stonecutterResultFromBase(pWriter, RecipeCategory.MISC, glazed, reglazed, 1);
    }

    // 1:1 recipes using the ring of transmutation
    public static void oneToOneTransmutationRecipe(ItemLike input, ItemLike output, Consumer<FinishedRecipe> pWriter, String recipeNameA, String recipeNameB) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, output)
                .requires(SigilUtils_Items.RING_OF_TRANSMUTATION.get())
                .requires(input)
                .unlockedBy(getHasName(SigilUtils_Items.RING_OF_TRANSMUTATION.get()), has(SigilUtils_Items.RING_OF_TRANSMUTATION.get()))
                .save(pWriter, recipeNameA);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, input)
                .requires(SigilUtils_Items.RING_OF_TRANSMUTATION.get())
                .requires(output)
                .unlockedBy(getHasName(SigilUtils_Items.RING_OF_TRANSMUTATION.get()), has(SigilUtils_Items.RING_OF_TRANSMUTATION.get()))
                .save(pWriter, recipeNameB);
    }

    // 2:1 recipes using the ring of transmutation
    public static void twoToOneTransmutationRecipe(ItemLike one, ItemLike two, Consumer<FinishedRecipe> pWriter, String recipeNameA, String recipeNameB) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, two, 2)
                .requires(SigilUtils_Items.RING_OF_TRANSMUTATION.get())
                .requires(one)
                .unlockedBy(getHasName(SigilUtils_Items.RING_OF_TRANSMUTATION.get()), has(SigilUtils_Items.RING_OF_TRANSMUTATION.get()))
                .save(pWriter, recipeNameA);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, one)
                .requires(SigilUtils_Items.RING_OF_TRANSMUTATION.get())
                .requires(two).requires(two)
                .unlockedBy(getHasName(SigilUtils_Items.RING_OF_TRANSMUTATION.get()), has(SigilUtils_Items.RING_OF_TRANSMUTATION.get()))
                .save(pWriter, recipeNameB);
    }

    // 4:1 recipes using the ring of transmutation
    public static void fourToOneTransmutationRecipe(ItemLike one, ItemLike four, Consumer<FinishedRecipe> pWriter, String recipeNameA, String recipeNameB) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, four, 4)
                .requires(SigilUtils_Items.RING_OF_TRANSMUTATION.get())
                .requires(one)
                .unlockedBy(getHasName(SigilUtils_Items.RING_OF_TRANSMUTATION.get()), has(SigilUtils_Items.RING_OF_TRANSMUTATION.get()))
                .save(pWriter, recipeNameA);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, one)
                .requires(SigilUtils_Items.RING_OF_TRANSMUTATION.get())
                .requires(four).requires(four).requires(four).requires(four)
                .unlockedBy(getHasName(SigilUtils_Items.RING_OF_TRANSMUTATION.get()), has(SigilUtils_Items.RING_OF_TRANSMUTATION.get()))
                .save(pWriter, recipeNameB);
    }

    // 8:1 recipes using the ring of transmutation
    public static void eightToOneTransmutationRecipe(ItemLike one, ItemLike eight, Consumer<FinishedRecipe> pWriter, String recipeNameA, String recipeNameB) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, eight, 8)
                .requires(SigilUtils_Items.RING_OF_TRANSMUTATION.get())
                .requires(one)
                .unlockedBy(getHasName(SigilUtils_Items.RING_OF_TRANSMUTATION.get()), has(SigilUtils_Items.RING_OF_TRANSMUTATION.get()))
                .save(pWriter, recipeNameA);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, one)
                .requires(SigilUtils_Items.RING_OF_TRANSMUTATION.get())
                .requires(eight).requires(eight).requires(eight).requires(eight).requires(eight).requires(eight).requires(eight).requires(eight)
                .unlockedBy(getHasName(SigilUtils_Items.RING_OF_TRANSMUTATION.get()), has(SigilUtils_Items.RING_OF_TRANSMUTATION.get()))
                .save(pWriter, recipeNameB);
    }

    // recipe for spawn eggs, since they mostly kinda follow a similar format
    public static void spawnEggRecipe(ItemLike egg, ItemLike catalystA, ItemLike catalystB, ItemLike result, Consumer<FinishedRecipe> pWriter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, result)
                .pattern(" A ")
                .pattern("BEB")
                .pattern(" A ")
                .define('A', catalystA)
                .define('B', catalystB)
                .define('E', egg)
                .unlockedBy(getHasName(SigilUtils_Items.ORICHALCOM_EGG.get()), has(SigilUtils_Items.ORICHALCOM_EGG.get()))
                .save(pWriter);
    }
    public static void spawnEggTransmutationRecipe(ItemLike base, ItemLike catalyst, ItemLike result, Consumer<FinishedRecipe> pWriter) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, result)
                .requires(SigilUtils_Items.RING_OF_TRANSMUTATION.get())
                .requires(base)
                .requires(catalyst)
                .unlockedBy(getHasName(SigilUtils_Items.ORICHALCOM_EGG.get()), has(SigilUtils_Items.ORICHALCOM_EGG.get()))
                .save(pWriter);
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, SigilUtils.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }
}
