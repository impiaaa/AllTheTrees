package net.boatcake.allthetrees;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import biomesoplenty.api.BlockReferences;
import biomesoplenty.worldgen.WorldGenNetherBush;
import biomesoplenty.worldgen.tree.*;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;

@Mod(modid = "AllTheTrees", name = "All the Trees", version = "1.0", dependencies = "after:BiomesOPlenty; required-after:Forestry; required-after:Forge")
public class AllTheTrees {
	@EventHandler
	public void init(FMLInitializationEvent e) {
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {
		//new ModTreeSpecies(WorldGenPromisedTree.class, 0x000000, "bop.holy", BlockReferences.getBlockItemStack("holySapling"),BlockReferences.getBlockItemStack("holyLeaves"),BlockReferences.getBlockItemStack("holyLog")).register();
		//new ModTreeSpecies(WorldGenMystic2.class, 0x000000, "bop.magic", BlockReferences.getBlockItemStack("magicSapling"),BlockReferences.getBlockItemStack("magicLeaves"),BlockReferences.getBlockItemStack("magicLog")).register();
		//new ModTreeSpecies(WorldGenOminous2.class, 0x000000, "bop.dark", BlockReferences.getBlockItemStack("darkSapling"),BlockReferences.getBlockItemStack("darkLeaves"),BlockReferences.getBlockItemStack("darkLog")).register();
		//new ModTreeSpecies(WorldGenDeadTree2.class, 0x000000, "bop.dead", BlockReferences.getBlockItemStack("deadSapling"),BlockReferences.getBlockItemStack("deadLeaves"),BlockReferences.getBlockItemStack("deadLog")).register();
		new ModTreeSpecies(WorldGenAcacia.class, 0x000000, new String[] {"Acacia", "aneura"}, "bop.acacia",
				BlockReferences.getBlockItemStack("acaciaSapling"),
				BlockReferences.getBlockItemStack("acaciaLeaves"),
				BlockReferences.getBlockItemStack("acaciaLog")).register();
		new ModTreeSpecies(WorldGenTaiga9.class, 0x000000, new String[] {"Abies", "fabri"}, "bop.fir",
				BlockReferences.getBlockItemStack("firSapling"),
				BlockReferences.getBlockItemStack("firLeaves"),
				BlockReferences.getBlockItemStack("firLog")).register();
		new ModTreeSpecies(WorldGenMangrove.class, 0x000000, new String[] {"Conocarpus", "erectus"}, "bop.mangrove",
				BlockReferences.getBlockItemStack("mangroveSapling"),
				BlockReferences.getBlockItemStack("mangroveLeaves"),
				BlockReferences.getBlockItemStack("mangroveLog")).register();
		new ModTreeSpecies(WorldGenPalmTree1.class, 0x000000, new String[] {"Cocos", "nucifera"}, "bop.palm",
				BlockReferences.getBlockItemStack("palmSapling"),
				BlockReferences.getBlockItemStack("palmLeaves"),
				BlockReferences.getBlockItemStack("palmLog")).register();
		new ModTreeSpecies(WorldGenRedwoodTree2.class, 0x000000, new String[] {"Sequoiadendron", "giganteum"}, "bop.redwood",
				BlockReferences.getBlockItemStack("redwoodSapling"),
				BlockReferences.getBlockItemStack("redwoodLeaves"),
				BlockReferences.getBlockItemStack("redwoodLog")).register();
		new ModTreeSpecies(WorldGenWillow.class, 0x000000, new String[] {"Salix", "alba"}, "bop.willow",
				BlockReferences.getBlockItemStack("willowSapling"),
				BlockReferences.getBlockItemStack("willowLeaves"),
				BlockReferences.getBlockItemStack("willowLog")).register();
		new ModTreeSpecies(WorldGenPineTree.class, 0x000000, new String[] {"Pinus", "ponderosa"}, "bop.pine",
				BlockReferences.getBlockItemStack("pineSapling"),
				BlockReferences.getBlockItemStack("pineLeaves"),
				BlockReferences.getBlockItemStack("pineLog")).register();
		//new ModTreeSpecies(WorldGenMassiveTree.class, 0x000000, "bop.sacredoak",BlockReferences.getBlockItemStack("sacredoakSapling"),BlockReferences.getBlockItemStack("sacredoakLeaves"),BlockReferences.getBlockItemStack("sacredoakLog")).register();
		new ModTreeSpecies(WorldGenMaple.class, 0x000000, new String[] {"Acer", "rubrum"}, "bop.maple",
				BlockReferences.getBlockItemStack("mapleSapling"),
				BlockReferences.getBlockItemStack("mapleLeaves"),
				new ItemStack(Block.wood)).register();
		//new ModTreeSpecies(WorldGenAutumn2.class, 0x000000, "bop.orangeAutumn",BlockReferences.getBlockItemStack("orangeAutumnSapling"),BlockReferences.getBlockItemStack("orangeAutumnLeaves"),BlockReferences.getBlockItemStack("orangeAutumnLog")).register();
		new ModTreeSpecies(WorldGenCherry1.class, 0x000000, new String[] {"Prunus", "serrulata"}, "bop.pinkCherry",
				BlockReferences.getBlockItemStack("pinkCherrySapling"),
				BlockReferences.getBlockItemStack("pinkCherryLeaves"),
				BlockReferences.getBlockItemStack("cherryLog")).register();
		new ModTreeSpecies(WorldGenCherry2.class, 0x000000, new String[] {"Prunus", "speciosa"}, "bop.whiteCherry",
				BlockReferences.getBlockItemStack("whiteCherrySapling"),
				BlockReferences.getBlockItemStack("whiteCherryLeaves"),
				BlockReferences.getBlockItemStack("cherryLog")).register();
		//new ModTreeSpecies(WorldGenNetherBush.class, 0x000000, "bop.hellBark",BlockReferences.getBlockItemStack("hellBarkSapling"),BlockReferences.getBlockItemStack("hellBarkLeaves"),BlockReferences.getBlockItemStack("hellBarkLog")).register();
		new ModTreeSpecies(WorldGenJacaranda.class, 0x725a95, new String[] {"Jacaranda", "mimosifolia"}, "bop.jacaranda",
				BlockReferences.getBlockItemStack("jacarandaSapling"),
				BlockReferences.getBlockItemStack("jacarandaLeaves"),
				BlockReferences.getBlockItemStack("jacarandaLog")).register();
		new ModTreeSpecies(WorldGenApple.class, 0x000000, new String[] {"Malus", "domestica"}, "bop.apple",
				BlockReferences.getBlockItemStack("appleSapling"),
				BlockReferences.getBlockItemStack("appleLeaves"),
				new ItemStack(Block.wood)).register();
		//new ModTreeSpecies(WorldGenOriginTree.class, 0x000000, "bop.origin",BlockReferences.getBlockItemStack("originSapling"),BlockReferences.getBlockItemStack("originLeaves"),BlockReferences.getBlockItemStack("originLog")).register();
		//new ModTreeSpecies(WorldGenAutumn.class, 0x000000, "bop.yellowAutumn",BlockReferences.getBlockItemStack("yellowAutumnSapling"),BlockReferences.getBlockItemStack("yellowAutumnLeaves"),BlockReferences.getBlockItemStack("yellowAutumnLog")).register();
		new ModTreeSpecies(WorldGenBambooTree.class, 0x000000, new String[] {"Phyllostachys", "pubescens"}, "bop.bamboo",
				BlockReferences.getBlockItemStack("bambooSapling"),
				BlockReferences.getBlockItemStack("bambooLeaves"),
				BlockReferences.getBlockItemStack("bamboo")).register();
		new ModTreeSpecies(WorldGenPersimmon.class, 0x000000, new String[] {"Diospyros", "kaki"}, "bop.persimmon",
				BlockReferences.getBlockItemStack("persimmonSapling"),
				BlockReferences.getBlockItemStack("persimmonLeaves"),
				new ItemStack(Block.wood)).register();
	}
}
