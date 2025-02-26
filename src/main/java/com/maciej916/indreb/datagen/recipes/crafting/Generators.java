package com.maciej916.indreb.datagen.recipes.crafting;

import com.maciej916.indreb.common.registries.ModBlocks;
import com.maciej916.indreb.common.registries.ModItems;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;

import java.util.function.Consumer;

import static com.maciej916.indreb.IndReb.MODID;

public class Generators extends RecipeProvider {

    public Generators(DataGenerator generatorIn) {
        super(generatorIn);
    }

    private ResourceLocation saveResource(String name) {
        return new ResourceLocation(MODID, "generators/" + name);
    }
    
    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {

        ShapedRecipeBuilder.shaped(ModBlocks.GENERATOR.get())
                .pattern("R")
                .pattern("M")
                .pattern("f")
                .define('f', Blocks.FURNACE)
                .define('M', ModBlocks.BASIC_MACHINE_CASING.get())
                .define('R', ModItems.BATTERY.get())
                .group(MODID)
                .unlockedBy("item", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.FURNACE))
                .save(consumer, saveResource("generator_one"));

        ShapedRecipeBuilder.shaped(ModBlocks.GENERATOR.get())
                .pattern(" R ")
                .pattern("PPP")
                .pattern(" F ")
                .define('F', ModBlocks.IRON_FURNACE.get())
                .define('P', ItemTags.create(new ResourceLocation("forge", "plates/iron")))
                .define('R', ModItems.BATTERY.get())
                .group(MODID)
                .unlockedBy("item", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.FURNACE))
                .save(consumer, saveResource("generator_two"));

        ShapedRecipeBuilder.shaped(ModBlocks.GEO_GENERATOR.get())
                .pattern("gCg")
                .pattern("gCg")
                .pattern("PGP")
                .define('g', Blocks.GLASS)
                .define('C', ModItems.FLUID_CELL.get())
                .define('P', ItemTags.create(new ResourceLocation("forge", "plates/iron")))
                .define('G', ModBlocks.GENERATOR.get())
                .group(MODID)
                .unlockedBy("item", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.GENERATOR.get()))
                .save(consumer, saveResource("geo_generator"));

        ShapedRecipeBuilder.shaped(ModBlocks.SOLAR_GENERATOR.get(), 2)
                .pattern("CgC")
                .pattern("glg")
                .pattern("EGE")
                .define('C', ItemTags.create(new ResourceLocation("forge", "dusts/coal")))
                .define('l', Items.LAPIS_LAZULI)
                .define('g', Items.GLASS)
                .define('E', ModItems.ELECTRONIC_CIRCUIT.get())
                .define('G', ModBlocks.GENERATOR.get())
                .group(MODID)
                .unlockedBy("item", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.GENERATOR.get()))
                .save(consumer, saveResource("solar_generator"));


        ShapedRecipeBuilder.shaped(ModBlocks.ADVANCED_SOLAR_GENERATOR.get(), 1)
                .pattern("ggg")
                .pattern("asa")
                .pattern("cmc")
                .define('g', ModBlocks.REINFORCED_GLASS.get())
                .define('a', ModItems.ADVANCED_ALLOY.get())
                .define('s', ModBlocks.SOLAR_GENERATOR.get())
                .define('c', ModItems.ADVANCED_CIRCUIT.get())
                .define('m', ModBlocks.ADVANCED_MACHINE_CASING.get())
                .group(MODID)
                .unlockedBy("reinforced_glass", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.REINFORCED_GLASS.get()))
                .unlockedBy("advanced_alloy", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ADVANCED_ALLOY.get()))
                .unlockedBy("solar_generator", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.SOLAR_GENERATOR.get()))
                .unlockedBy("advanced_circuit", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ADVANCED_CIRCUIT.get()))
                .unlockedBy("advanced_machine_casing", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.ADVANCED_MACHINE_CASING.get()))
                .save(consumer, saveResource("advanced_solar_generator"));


        ShapedRecipeBuilder.shaped(ModBlocks.HYBRID_SOLAR_GENERATOR.get(), 1)
                .pattern("ala")
                .pattern("psp")
                .pattern("cec")
                .define('a', ModItems.CARBON_PLATE.get())
                .define('l', Items.LAPIS_BLOCK)
                .define('s', ModBlocks.ADVANCED_SOLAR_GENERATOR.get())
                .define('p', ModItems.IRIDIUM_PLATE.get())
                .define('c', ModItems.ADVANCED_CIRCUIT.get())
                .define('e', ModItems.ENERGY_CRYSTAL.get())
                .group(MODID)
                .unlockedBy("carbon_plate", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.CARBON_PLATE.get()))
                .unlockedBy("lapis_block", InventoryChangeTrigger.TriggerInstance.hasItems(Items.LAPIS_BLOCK))
                .unlockedBy("advanced_solar_generator", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.ADVANCED_SOLAR_GENERATOR.get()))
                .unlockedBy("iridium_plate", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRIDIUM_PLATE.get()))
                .unlockedBy("advanced_circuit", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ADVANCED_CIRCUIT.get()))
                .unlockedBy("energy_crystal", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ENERGY_CRYSTAL.get()))
                .save(consumer, saveResource("hybrid_solar_generator"));


        ShapedRecipeBuilder.shaped(ModBlocks.SEMIFLUID_GENERATOR.get())
                .pattern("pcp")
                .pattern("cgc")
                .pattern("pcp")
                .define('p', ItemTags.create(new ResourceLocation("forge", "plates/iron")))
                .define('c', ModItems.FLUID_CELL.get())
                .define('g', ModBlocks.GEO_GENERATOR.get())
                .group(MODID)
                .unlockedBy("geo_generator", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.GEO_GENERATOR.get()))
                .unlockedBy("fluid_cell", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.FLUID_CELL.get()))
                .unlockedBy("iron_plate", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_PLATE.get()))
                .save(consumer, saveResource("semifluid_generator"));
    }

}