package me.saber.tools.utils;

import itemnbtapi.NBTItem;
import me.saber.tools.SaberTools;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ItemCreation {
    public static Set<String> pickaxe_blocks = Stream.of(new String[]{
            "ACTIVATOR_RAIL", "ANDESITE", "ANDESITE_STAIRS", "ANDESITE_SLAB", "ANDESITE_STAIRS", "ANDESITE_WALL", "ANVIL", "BEACON", "BELL", "BLACK_CONCRETE",
            "BLACK_GLAZED_TERRACOTTA", "BLACK_SHULKER_BOX", "BLACK_TERRACOTTA", "BLAST_FURNACE", "BLUE_CONCRETE", "BLUE_GLAZED_TERRACOTTA", "BLUE_ICE", "BLUE_SHULKER_BOX", "BLUE_TERRACOTTA", "BONE_BLOCK",
            "BRAIN_CORAL_BLOCK", "BREWING_STAND", "BRICKS", "BRICK_SLAB", "BRICK_WALL", "BRICK_STAIRS", "BROWN_CONCRETE", "BROWN_GLAZED_TERRACOTTA", "BROWN_SHULKER_BOX", "BROWN_TERRACOTTA",
            "BUBBLE_CORAL_BLOCK", "CAULDRON", "CHIPPED_ANVIL", "CHISELED_QUARTZ_BLOCK", "CHISELED_RED_SANDSTONE", "CHISELED_SANDSTONE", "CHISELED_STONE_BRICKS", "COAL_BLOCK", "COAL_ORE", "COBBLESTONE",
            "COBBLESTONE_SLAB", "COBBLESTONE_STAIRS", "COBBLESTONE_WALL", "CONDUIT", "CRACKED_STONE_BRICKS", "CUT_RED_SANDSTONE", "CUT_RED_SANDSTONE_SLAB", "CUT_SANDSTONE", "CUT_SANDSTONE_SLAB", "CYAN_CONCRETE",
            "CYAN_GLAZED_TERRACOTTA", "CYAN_SHULKER_BOX", "CYAN_TERRACOTTA", "DAMAGED_ANVIL", "DARK_PRISMARINE", "DARK_PRISMARINE_SLAB", "DARK_PRISMARINE_STAIRS", "DEAD_BRAIN_CORAL_BLOCK", "DEAD_BUBBLE_CORAL_BLOCK", "DEAD_FIRE_CORAL_BLOCK",
            "DEAD_HORN_CORAL_BLOCK", "DEAD_TUBE_CORAL_BLOCK", "DETECTOR_RAIL", "DIAMOND_BLOCK", "DIAMOND_ORE", "DIORITE", "DIORITE_STAIRS", "DIORITE_WALL", "DISPENSER", "DROPPER",
            "EMERALD_BLOCK", "EMERALD_ORE", "ENCHANTING_TABLE", "ENDER_CHEST", "END_STONE", "END_STONE_BRICKS", "END_STONE_BRICK_SLAB", "END_STONE_BRICK_STAIRS", "END_STONE_BRICK_WALL", "FIRE_CORAL_BLOCK",
            "FURNACE", "GOLD_BLOCK", "GOLD_ORE", "GRANITE", "GRANITE_STAIRS", "GRANITE_WALL", "GRAY_CONCRETE", "GRAY_GLAZED_TERRACOTTA", "GRAY_SHULKER_BOX", "GRAY_TERRACOTTA",
            "GREEN_CONCRETE", "GREEN_GLAZED_TERRACOTTA", "GREEN_SHULKER_BOX", "GREEN_TERRACOTTA", "GRINDSTONE", "HEAVY_WEIGHTED_PRESSURE_PLATE", "HOPPER", "HORN_CORAL_BLOCK", "ICE", "IRON_BARS",
            "IRON_BLOCK", "IRON_DOOR", "IRON_ORE", "IRON_TRAPDOOR", "LANTERN", "LAPIS_BLOCK", "LAPIS_ORE", "LIGHT_BLUE_CONCRETE", "LIGHT_BLUE_GLAZED_TERRACOTTA", "LIGHT_BLUE_SHULKER_BOX",
            "LIGHT_BLUE_TERRACOTTA", "LIGHT_GRAY_CONCRETE", "LIGHT_GRAY_GLAZED_TERRACOTTA", "LIGHT_GRAY_SHULKER_BOX", "LIGHT_GRAY_TERRACOTTA", "LIGHT_WEIGHTED_PRESSURE_PLATE", "LIME_CONCRETE", "LIME_GLAZED_TERRACOTTA", "LIME_SHULKER_BOX", "LIME_TERRACOTTA",
            "MAGENTA_CONCRETE", "MAGENTA_GLAZED_TERRACOTTA", "MAGENTA_SHULKER_BOX", "MAGENTA_TERRACOTTA", "MAGMA_BLOCK", "MOSSY_COBBLESTONE", "MOSSY_COBBLESTONE_SLAB", "MOSSY_COBBLESTONE_STAIRS", "MOSSY_COBBLESTONE_WALL", "MOSSY_STONE_BRICKS",
            "MOSSY_STONE_BRICK_SLAB", "MOSSY_STONE_BRICK_STAIRS", "MOSSY_STONE_BRICK_WALL", "NETHERRACK", "NETHER_BRICKS", "NETHER_BRICK_FENCE", "NETHER_BRICK_SLAB", "NETHER_BRICK_STAIRS", "NETHER_BRICK_WALL", "NETHER_QUARTZ_ORE",
            "OBSERVER", "OBSIDIAN", "ORANGE_CONCRETE", "ORANGE_GLAZED_TERRACOTTA", "ORANGE_SHULKER_BOX", "ORANGE_TERRACOTTA", "PACKED_ICE", "PINK_CONCRETE", "PINK_GLAZED_TERRACOTTA", "PINK_SHULKER_BOX",
            "PINK_TERRACOTTA", "POLISHED_ANDESITE", "POLISHED_ANDESITE_SLAB", "POLISHED_ANDESITE_STAIRS", "POLISHED_DIORITE", "POLISHED_DIORITE_SLAB", "POLISHED_DIORITE_STAIRS", "POLISHED_GRANITE", "POLISHED_GRANITE_SLAB", "POLISHED_GRANITE_STAIRS",
            "POWERED_RAIL", "PRISMARINE", "PRISMARINE_BRICKS", "PRISMARINE_BRICK_SLAB", "PRISMARINE_BRICK_STAIRS", "PRISMARINE_SLAB", "PRISMARINE_STAIRS", "PRISMARINE_WALL", "PURPLE_CONCRETE", "PURPLE_GLAZED_TERRACOTTA",
            "PURPLE_SHULKER_BOX", "PURPLE_TERRACOTTA", "PURPUR_BLOCK", "PURPUR_PILLAR", "PURPUR_SLAB", "PURPUR_STAIRS", "QUARTZ_BLOCK", "QUARTZ_PILLAR", "QUARTZ_SLAB", "QUARTZ_STAIRS",
            "RAIL", "REDSTONE_BLOCK", "REDSTONE_ORE", "RED_CONCRETE", "RED_GLAZED_TERRACOTTA", "RED_NETHER_BRICKS", "RED_NETHER_BRICK_SLAB", "RED_NETHER_BRICK_STAIRS", "RED_NETHER_BRICK_WALL", "RED_SANDSTONE",
            "RED_SANDSTONE_SLAB", "RED_SANDSTONE_STAIRS", "RED_SANDSTONE_WALL", "RED_SHULKER_BOX", "RED_TERRACOTTA", "SANDSTONE", "SANDSTONE_SLAB", "SANDSTONE_STAIRS", "SANDSTONE_WALL", "SHULKER_BOX",
            "SMOOTH_QUARTZ", "SMOOTH_QUARTZ_SLAB", "SMOOTH_QUARTZ_STAIRS", "SMOOTH_RED_SANDSTONE", "SMOOTH_RED_SANDSTONE_SLAB", "SMOOTH_RED_SANDSTONE_STAIRS", "SMOOTH_SANDSTONE", "SMOOTH_SANDSTONE_SLAB", "SMOOTH_SANDSTONE_STAIRS", "SMOOTH_STONE",
            "SMOOTH_STONE_SLAB", "SPAWNER", "STONE", "STONECUTTER", "STONE_BRICKS", "STONE_BRICK_SLAB", "STONE_BRICK_STAIRS", "STONE_BRICK_WALL", "STONE_BUTTON", "STONE_PRESSURE_PLATE",
            "STONE_SLAB", "STONE_STAIRS", "TERRACOTTA", "TUBE_CORAL_BLOCK", "WHITE_CONCRETE", "WHITE_GLAZED_TERRACOTTA", "WHITE_SHULKER_BOX", "WHITE_TERRACOTTA", "YELLOW_CONCRETE", "YELLOW_GLAZED_TERRACOTTA",
            "YELLOW_SHULKER_BOX", "YELLOW_TERRACOTTA"}).collect(Collectors.toSet());

    public static Set<String> axe_blocks = Stream.of(new String[]{
            "LOG", "ACACIA_BUTTON", "ACACIA_DOOR", "ACACIA_FENCE", "ACACIA_FENCE_GATE", "ACACIA_LOG", "ACACIA_PLANKS", "ACACIA_PRESSURE_PLATE", "ACACIA_SIGN", "ACACIA_SLAB",
            "ACACIA_STAIRS", "ACACIA_TRAPDOOR", "ACACIA_WALL_SIGN", "ACACIA_WOOD", "BARREL", "BIRCH_BUTTON", "BIRCH_DOOR", "BIRCH_FENCE", "BIRCH_FENCE_GATE", "BIRCH_LOG",
            "BIRCH_PLANKS", "BIRCH_PRESSURE_PLATE", "BIRCH_SIGN", "BIRCH_SLAB", "BIRCH_STAIRS", "BIRCH_TRAPDOOR", "BIRCH_WALL_SIGN", "BIRCH_WOOD", "BLACK_BANNER", "BLACK_WALL_BANNER",
            "BLUE_BANNER", "BLUE_WALL_BANNER", "BOOKSHELF", "BROWN_BANNER", "BROWN_MUSHROOM_BLOCK", "BROWN_WALL_BANNER", "CAMPFIRE", "CARTOGRAPHY_TABLE", "CARVED_PUMPKIN", "CHEST",
            "CHORUS_PLANT", "COCOA", "COMPOSTER", "CRAFTING_TABLE", "CYAN_BANNER", "CYAN_WALL_BANNER", "DARK_OAK_BUTTON", "DARK_OAK_DOOR", "DARK_OAK_FENCE", "DARK_OAK_FENCE_GATE",
            "DARK_OAK_LOG", "DARK_OAK_PLANKS", "DARK_OAK_PRESSURE_PLATE", "DARK_OAK_SIGN", "DARK_OAK_SLAB", "DARK_OAK_STAIRS", "DARK_OAK_TRAPDOOR", "DARK_OAK_WALL_SIGN", "DARK_OAK_WOOD", "DAYLIGHT_DETECTOR",
            "FLETCHING_TABLE", "GRAY_BANNER", "GRAY_WALL_BANNER", "GREEN_BANNER", "GREEN_WALL_BANNER", "JACK_O_LANTERN", "JUKEBOX", "JUNGLE_BUTTON", "JUNGLE_DOOR", "JUNGLE_FENCE",
            "JUNGLE_FENCE_GATE", "JUNGLE_LOG", "JUNGLE_PLANKS", "JUNGLE_PRESSURE_PLATE", "JUNGLE_SIGN", "JUNGLE_SLAB", "JUNGLE_STAIRS", "JUNGLE_TRAPDOOR", "JUNGLE_WALL_SIGN", "JUNGLE_WOOD",
            "LADDER", "LECTERN", "LOOM", "MAGENTA_BANNER", "MAGENTA_WALL_BANNER", "MELON", "NOTE_BLOCK", "OAK_BUTTON", "OAK_DOOR", "OAK_FENCE",
            "OAK_FENCE_GATE", "OAK_LOG", "OAK_PLANKS", "OAK_PRESSURE_PLATE", "OAK_SIGN", "OAK_SLAB", "OAK_STAIRS", "OAK_TRAPDOOR", "OAK_WALL_SIGN", "OAK_WOOD",
            "PINK_BANNER", "PINK_WALL_BANNER", "PUMPKIN", "PURPLE_BANNER", "PURPLE_WALL_BANNER", "RED_BANNER", "RED_MUSHROOM_BLOCK", "RED_WALL_BANNER", "SMITHING_TABLE", "SMOKER",
            "SPRUCE_BUTTON", "SPRUCE_DOOR", "SPRUCE_FENCE", "SPRUCE_FENCE_GATE", "SPRUCE_LOG", "SPRUCE_PLANKS", "SPRUCE_PRESSURE_PLATE", "SPRUCE_SIGN", "SPRUCE_SLAB", "SPRUCE_STAIRS",
            "SPRUCE_TRAPDOOR", "SPRUCE_TRAPDOOR", "SPRUCE_WALL_SIGN", "SPRUCE_WOOD", "STRIPPED_ACACIA_LOG", "STRIPPED_ACACIA_WOOD", "STRIPPED_BIRCH_LOG", "STRIPPED_BIRCH_WOOD", "STRIPPED_DARK_OAK_LOG", "STRIPPED_DARK_OAK_WOOD",
            "STRIPPED_JUNGLE_LOG", "STRIPPED_JUNGLE_WOOD", "STRIPPED_OAK_LOG", "STRIPPED_OAK_WOOD", "STRIPPED_SPRUCE_LOG", "STRIPPED_SPRUCE_WOOD", "TRAPPED_CHEST", "WALL_SIGN", "WHITE_BANNER", "WHITE_WALL_BANNER",
            "YELLOW_BANNER", "YELLOW_WALL_BANNER"}).collect(Collectors.toSet());

    public static Set<String> shovel_blocks = Stream.of(new String[]{
            "MYCEL", "GRASS", "BLACK_CONCRETE_POWDER", "BLUE_CONCRETE_POWDER", "BROWN_CONCRETE_POWDER", "CLAY", "COARSE_DIRT", "CYAN_CONCRETE_POWDER", "DIRT", "FARMLAND",
            "GRASS_BLOCK", "GRASS_PATH", "GRAVEL", "GRAY_CONCRETE_POWDER", "GREEN_CONCRETE_POWDER", "LIGHT_BLUE_CONCRETE_POWDER", "LIGHT_GRAY_CONCRETE_POWDER", "LIME_CONCRETE_POWDER", "MAGENTA_CONCRETE_POWDER", "MYCELIUM",
            "ORANGE_CONCRETE_POWDER", "PINK_CONCRETE_POWDER", "PODZOL", "PURPLE_CONCRETE_POWDER", "RED_CONCRETE_POWDER", "RED_SAND", "SAND", "SNOW", "SNOW_BLOCK", "SOUL_SAND",
            "WHITE_CONCRETE_POWDER", "YELLOW_CONCRETE_POWDER"}).collect(Collectors.toSet());

    public static void giveItem(Player p, int radius) {
        p.getInventory().addItem(getItem(Types.Pickaxe, radius));
    }

    public static int getRadius(ItemStack itemStack) {
        NBTItem nbtItem = new NBTItem(itemStack);
        return nbtItem.getInteger("Radius");
    }

    public static Enchantment getEnchantmentByName(String name) {
        for (Enchantment enchantment : Enchantment.values()) {
            if (enchantment != null &&
                    enchantment.getName() != null &&
                    enchantment.getName().equalsIgnoreCase(name))
                return enchantment;
        }
        return null;
    }

    public static ItemStack getItem(Enum itemType, int radius) {
        NBTItem item = null;
        for (Enum e : Types.values()) {
            if (itemType.name().equalsIgnoreCase(e.name())) {
                String typeName = itemType.name();
                ItemStack tool = new ItemStack(XMaterial.parseMaterial(SaberTools.getInstance().getFileManager().getConfig().fetchString("SaberTools." + typeName + ".item-type"), (byte) 0));
                ItemMeta meta = tool.getItemMeta();
                meta.setDisplayName(Util.color(SaberTools.getInstance().getFileManager().getConfig().fetchString("SaberTools." + typeName + ".item-name")));
                List<String> lore = new ArrayList<>();
                for (String s : SaberTools.getInstance().getFileManager().getConfig().fetchStringList("SaberTools." + typeName + ".item-lore"))
                    lore.add(Util.color(s).replace("{radius}", radius + ""));
                meta.setLore(lore);
                tool.setItemMeta(meta);
                for (String enchants : SaberTools.getInstance().getFileManager().getConfig().fetchStringList("SaberTools." + typeName + ".enchantments")) {
                    String[] split = enchants.split(":");
                    String ench = split[0];
                    int value = Integer.parseInt(split[1]);
                    Enchantment enchantment = getEnchantmentByName(ench);
                    if (enchantment == null)
                        continue;
                    tool.addUnsafeEnchantment(enchantment, value);
                }
                NBTItem nbti = new NBTItem(tool);
                nbti.setBoolean("SaberTool", Boolean.TRUE);
                if (radius != 0)
                    nbti.setInteger("Radius", radius);
                item = nbti;
            }
        }
        if (item != null)
            return item.getItem();
        Logger.print("You have a nullpointer in your config.yml!", Logger.PrefixType.FAILED);
        return null;
    }
}
