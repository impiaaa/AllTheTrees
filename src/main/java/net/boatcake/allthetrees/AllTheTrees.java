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
		//new ModTreeSpecies(WorldGenPromisedTree.class, 0x000000, "", "holy", "holy",BlockReferences.getBlockItemStack("holySapling"),BlockReferences.getBlockItemStack("holyLeaves"),BlockReferences.getBlockItemStack("holyLog")).register();
		//new ModTreeSpecies(WorldGenMystic2.class, 0x000000, "", "magic", "magic",BlockReferences.getBlockItemStack("magicSapling"),BlockReferences.getBlockItemStack("magicLeaves"),BlockReferences.getBlockItemStack("magicLog")).register();
		//new ModTreeSpecies(WorldGenOminous2.class, 0x000000, "", "dark", "dark",BlockReferences.getBlockItemStack("darkSapling"),BlockReferences.getBlockItemStack("darkLeaves"),BlockReferences.getBlockItemStack("darkLog")).register();
		//new ModTreeSpecies(WorldGenDeadTree2.class, 0x000000, "", "dead", "dead",BlockReferences.getBlockItemStack("deadSapling"),BlockReferences.getBlockItemStack("deadLeaves"),BlockReferences.getBlockItemStack("deadLog")).register();
		new ModTreeSpecies(WorldGenAcacia.class, 0x000000, "aneura", "acacia",
				"Acacia", BlockReferences.getBlockItemStack("acaciaSapling"),
				BlockReferences.getBlockItemStack("acaciaLeaves"),
				BlockReferences.getBlockItemStack("acaciaLog")).register();
		new ModTreeSpecies(WorldGenTaiga9.class, 0x000000, "fabri", "abies",
				"Abies", BlockReferences.getBlockItemStack("firSapling"),
				BlockReferences.getBlockItemStack("firLeaves"),
				BlockReferences.getBlockItemStack("firLog")).register();
		new ModTreeSpecies(WorldGenMangrove.class, 0x000000, "erectus",
				"conocarpus", "Conocarpus",
				BlockReferences.getBlockItemStack("mangroveSapling"),
				BlockReferences.getBlockItemStack("mangroveLeaves"),
				BlockReferences.getBlockItemStack("mangroveLog")).register();
		new ModTreeSpecies(WorldGenPalmTree1.class, 0x000000, "nucifera",
				"cocos", "Cocos",
				BlockReferences.getBlockItemStack("palmSapling"),
				BlockReferences.getBlockItemStack("palmLeaves"),
				BlockReferences.getBlockItemStack("palmLog")).register();
		new ModTreeSpecies(WorldGenRedwoodTree2.class, 0x000000, "giganteum",
				"sequoiadendron", "Sequoiadendron",
				BlockReferences.getBlockItemStack("redwoodSapling"),
				BlockReferences.getBlockItemStack("redwoodLeaves"),
				BlockReferences.getBlockItemStack("redwoodLog")).register();
		new ModTreeSpecies(WorldGenWillow.class, 0x000000, "alba", "salix",
				"Salix", BlockReferences.getBlockItemStack("willowSapling"),
				BlockReferences.getBlockItemStack("willowLeaves"),
				BlockReferences.getBlockItemStack("willowLog")).register();
		new ModTreeSpecies(WorldGenPineTree.class, 0x000000, "ponderosa",
				"pinus", "Pinus",
				BlockReferences.getBlockItemStack("pineSapling"),
				BlockReferences.getBlockItemStack("pineLeaves"),
				BlockReferences.getBlockItemStack("pineLog")).register();
		//new ModTreeSpecies(WorldGenMassiveTree.class, 0x000000, "", "sacredoak", "sacredoak",BlockReferences.getBlockItemStack("sacredoakSapling"),BlockReferences.getBlockItemStack("sacredoakLeaves"),BlockReferences.getBlockItemStack("sacredoakLog")).register();
		new ModTreeSpecies(WorldGenMaple.class, 0x000000, "rubrum", "acer",
				"Acer", BlockReferences.getBlockItemStack("mapleSapling"),
				BlockReferences.getBlockItemStack("mapleLeaves"),
				new ItemStack(Block.wood)).register();
		//new ModTreeSpecies(WorldGenAutumn2.class, 0x000000, "", "orangeAutumn", "orangeAutumn",BlockReferences.getBlockItemStack("orangeAutumnSapling"),BlockReferences.getBlockItemStack("orangeAutumnLeaves"),BlockReferences.getBlockItemStack("orangeAutumnLog")).register();
		new ModTreeSpecies(WorldGenCherry1.class, 0x000000, "serrulata",
				"prunusserrulata", "Prunus",
				BlockReferences.getBlockItemStack("pinkCherrySapling"),
				BlockReferences.getBlockItemStack("pinkCherryLeaves"),
				BlockReferences.getBlockItemStack("cherryLog")).register();
		new ModTreeSpecies(WorldGenCherry2.class, 0x000000, "speciosa",
				"prunusspeciosa", "Prunus",
				BlockReferences.getBlockItemStack("whiteCherrySapling"),
				BlockReferences.getBlockItemStack("whiteCherryLeaves"),
				BlockReferences.getBlockItemStack("cherryLog")).register();
		//new ModTreeSpecies(WorldGenNetherBush.class, 0x000000, "", "hellBark", "hellBark",BlockReferences.getBlockItemStack("hellBarkSapling"),BlockReferences.getBlockItemStack("hellBarkLeaves"),BlockReferences.getBlockItemStack("hellBarkLog")).register();
		new ModTreeSpecies(WorldGenJacaranda.class, 0x725a95, "mimosifolia",
				"jacaranda", "Jacaranda",
				BlockReferences.getBlockItemStack("jacarandaSapling"),
				BlockReferences.getBlockItemStack("jacarandaLeaves"),
				BlockReferences.getBlockItemStack("jacarandaLog")).register();
		new ModTreeSpecies(WorldGenApple.class, 0x000000, "domestica", "malus",
				"Malus", BlockReferences.getBlockItemStack("appleSapling"),
				BlockReferences.getBlockItemStack("appleLeaves"),
				new ItemStack(Block.wood)).register();
		//new ModTreeSpecies(WorldGenOriginTree.class, 0x000000, "", "origin", "origin",BlockReferences.getBlockItemStack("originSapling"),BlockReferences.getBlockItemStack("originLeaves"),BlockReferences.getBlockItemStack("originLog")).register();
		//new ModTreeSpecies(WorldGenAutumn.class, 0x000000, "", "yellowAutumn", "yellowAutumn",BlockReferences.getBlockItemStack("yellowAutumnSapling"),BlockReferences.getBlockItemStack("yellowAutumnLeaves"),BlockReferences.getBlockItemStack("yellowAutumnLog")).register();
		new ModTreeSpecies(WorldGenBambooTree.class, 0x000000, "pubescens",
				"phyllostachys", "Phyllostachys",
				BlockReferences.getBlockItemStack("bambooSapling"),
				BlockReferences.getBlockItemStack("bambooLeaves"),
				BlockReferences.getBlockItemStack("bamboo")).register();
		new ModTreeSpecies(WorldGenPersimmon.class, 0x000000, "kaki",
				"diospyros", "Diospyros",
				BlockReferences.getBlockItemStack("persimmonSapling"),
				BlockReferences.getBlockItemStack("persimmonLeaves"),
				new ItemStack(Block.wood)).register();
	}
}
