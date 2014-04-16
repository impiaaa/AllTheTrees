package net.boatcake.allthetrees.plugins;

import forestry.api.arboriculture.EnumTreeChromosome;
import forestry.api.genetics.AlleleManager;
import forestry.api.genetics.IAllele;
import net.boatcake.allthetrees.ModFruitAllele;
import net.boatcake.allthetrees.ModFruitFamily;
import net.boatcake.allthetrees.ModFruitProvider;
import net.boatcake.allthetrees.ModTreeSpecies;
import net.boatcake.allthetrees.Util;
import net.boatcake.allthetrees.WorldGenWrapper;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import biomesoplenty.api.BlockReferences;
import biomesoplenty.api.Items;
import biomesoplenty.worldgen.WorldGenNetherBush;
import biomesoplenty.worldgen.tree.*;

public class PluginBOP implements IPlugin {
	public void register() {
		ModTreeSpecies acacia = new ModTreeSpecies(new WorldGenWrapper(new WorldGenAcacia(false)), /*0xE1E1E1*/0x42572C,
				new String[] {"Acacia", "aneura"},
				"bop.acacia",
				BlockReferences.getBlockItemStack("acaciaSapling"),
				BlockReferences.getBlockItemStack("acaciaLeaves"),
				BlockReferences.getBlockItemStack("acaciaLog"));
		acacia.template[EnumTreeChromosome.HEIGHT.ordinal()] = AlleleManager.alleleRegistry.getAllele("forestry.heightMax10");
		acacia.register();
		
		ModTreeSpecies apple = new ModTreeSpecies(new WorldGenWrapper(new WorldGenApple(false)), 0xA6BB30,
				new String[] {"Rosaceae", "Amygdaloideae", "Maleae", "Malus", "domestica"},
				"bop.apple",
				BlockReferences.getBlockItemStack("appleSapling"),
				BlockReferences.getBlockItemStack("appleLeaves"),
				new ItemStack(Block.wood));
		apple.template[EnumTreeChromosome.FRUITS.ordinal()] = AlleleManager.alleleRegistry.getAllele("forestry.fruitApple");
		apple.register();
		
		ModTreeSpecies bamboo = new ModTreeSpecies(new WorldGenWrapper(new WorldGenBambooTree(false)), 0xB5E03D,
				new String[] {"Monocots", "Poales", "Poaceae", "Bambusoideae", "Bambuseae", "Phyllostachys", "pubescens"},
				"bop.bamboo",
				BlockReferences.getBlockItemStack("bambooSapling"),
				BlockReferences.getBlockItemStack("bambooLeaves"),
				BlockReferences.getBlockItemStack("bamboo"));
		bamboo.template[EnumTreeChromosome.HEIGHT.ordinal()] = AlleleManager.alleleRegistry.getAllele("forestry.heightMax10");
		bamboo.register();
		
		ModTreeSpecies dark = new ModTreeSpecies(new WorldGenWrapper(new WorldGenOminous2()), 0x393D4B,
				new String[] {"Commenticius", "tenebrae"},
				"bop.dark",
				BlockReferences.getBlockItemStack("darkSapling"),
				BlockReferences.getBlockItemStack("darkLeaves"),
				BlockReferences.getBlockItemStack("darkLog"));
		dark.register();
		
		ModTreeSpecies dead = new ModTreeSpecies(new WorldGenWrapper(new WorldGenDeadTree2(false)), 0x8A6D3B,
				new String[] {"Commenticius", "mortuus"},
				"bop.dead",
				BlockReferences.getBlockItemStack("deadSapling"),
				BlockReferences.getBlockItemStack("deadLeaves"),
				BlockReferences.getBlockItemStack("deadLog"));
		dead.register();
		
		ModTreeSpecies fir = new ModTreeSpecies(new WorldGenWrapper(new WorldGenTaiga9(false)), 0x64A172,
				new String[] {"Pinaceae", null, null, "Abies", "fabri"},
				"bop.fir",
				BlockReferences.getBlockItemStack("firSapling"),
				BlockReferences.getBlockItemStack("firLeaves"),
				BlockReferences.getBlockItemStack("firLog"));
		fir.register();
		
		ModTreeSpecies hellBark = new ModTreeSpecies(new WorldGenWrapper(new WorldGenNetherBush()), 0x80781F,
				new String[] {"Commenticius", "infernum"},
				"bop.hellBark",
				BlockReferences.getBlockItemStack("hellBarkSapling"),
				BlockReferences.getBlockItemStack("hellBarkLeaves"),
				BlockReferences.getBlockItemStack("hellBarkLog"));
		hellBark.register();
		
		ModTreeSpecies holy = new ModTreeSpecies(new WorldGenWrapper(new WorldGenPromisedTree(false)), 0xF3FCC4,
				new String[] {"Commenticius", "sanctus"},
				"bop.holy",
				BlockReferences.getBlockItemStack("holySapling"),
				BlockReferences.getBlockItemStack("holyLeaves"),
				BlockReferences.getBlockItemStack("holyLog"));
		holy.register();
		
		ModTreeSpecies jacaranda = new ModTreeSpecies(new WorldGenWrapper(new WorldGenJacaranda(false)), 0x765D9A,
				new String[] {"Asterids", "Lamiales", "Bignoniaceae", null, "Tecomeae", "Jacaranda", "mimosifolia"},
				"bop.jacaranda",
				BlockReferences.getBlockItemStack("jacarandaSapling"),
				BlockReferences.getBlockItemStack("jacarandaLeaves"),
				BlockReferences.getBlockItemStack("jacarandaLog"));
		jacaranda.register();
		
		ModTreeSpecies magic = new ModTreeSpecies(new WorldGenWrapper(new WorldGenMystic2(false)), 0xAECDE3,
				new String[] {"Commenticius", "magus"},
				"bop.magic",
				BlockReferences.getBlockItemStack("magicSapling"),
				BlockReferences.getBlockItemStack("magicLeaves"),
				BlockReferences.getBlockItemStack("magicLog"));
		magic.register();
		
		ModTreeSpecies mangrove = new ModTreeSpecies(new WorldGenWrapper(new WorldGenMangrove(false)), /*0x9A9A9A*/0x20520A,
				new String[] {"Rosids", "Myrtales", "Combretaceae", null, null, "Conocarpus", "erectus"},
				"bop.mangrove",
				BlockReferences.getBlockItemStack("mangroveSapling"),
				BlockReferences.getBlockItemStack("mangroveLeaves"),
				BlockReferences.getBlockItemStack("mangroveLog"));
		mangrove.register();
		
		ModTreeSpecies maple = new ModTreeSpecies(new WorldGenWrapper(new WorldGenMaple(false)), 0x833434,
				new String[] {"Acer", "rubrum"},
				"bop.maple",
				BlockReferences.getBlockItemStack("mapleSapling"),
				BlockReferences.getBlockItemStack("mapleLeaves"),
				new ItemStack(Block.wood));
		maple.register();
		
		ModTreeSpecies orangeAutumn = new ModTreeSpecies(new WorldGenWrapper(new WorldGenAutumn2(false)), 0x96502B,
				new String[] {"Commenticius", "luteus"},
				"bop.orangeAutumn",
				BlockReferences.getBlockItemStack("orangeAutumnSapling"),
				BlockReferences.getBlockItemStack("orangeAutumnLeaves"),
				new ItemStack(Block.wood));
		orangeAutumn.register();
		
		ModTreeSpecies origin = new ModTreeSpecies(new WorldGenWrapper(new WorldGenOriginTree(false)), 0x63FF43,
				new String[] {"Commenticius", "origo"},
				"bop.origin",
				BlockReferences.getBlockItemStack("originSapling"),
				BlockReferences.getBlockItemStack("originLeaves"),
				new ItemStack(Block.wood));
		origin.register();
		
		ModTreeSpecies palm = new ModTreeSpecies(new WorldGenWrapper(new WorldGenPalmTree1()), /*0xBEBEBE*/0x23580B,
				new String[] {"Angiosperms", "Monocots", "Arecales", "Arecaceae", "Arecoideae", "Cocoeae", "Cocos", "nucifera"},
				"bop.palm",
				BlockReferences.getBlockItemStack("palmSapling"),
				BlockReferences.getBlockItemStack("palmLeaves"),
				BlockReferences.getBlockItemStack("palmLog"));
		palm.register();
		
		ModFruitFamily fruitFamily = new ModFruitFamily("bop.persimmon", new ItemStack(Items.food.get(), 1, 8), "Diospyros", "");
		AlleleManager.alleleRegistry.registerFruitFamily(fruitFamily);
		ModFruitProvider fruitProvider = new ModFruitProvider(new ItemStack(Items.food.get(), 1, 8), BlockReferences.getBlockItemStack("persimmonLeaves"), "", fruitFamily);
		ModFruitAllele fruitAllele = new ModFruitAllele(new ItemStack(Items.food.get(), 1, 8), "bop.fuitPersimmon", fruitProvider);
		AlleleManager.alleleRegistry.registerAllele(fruitAllele);
		
		ModTreeSpecies persimmon = new ModTreeSpecies(new WorldGenWrapper(new WorldGenPersimmon(false)), 0x787237,
				new String[] {"ebony", "kaki"},
				"bop.persimmon",
				BlockReferences.getBlockItemStack("persimmonSapling"),
				BlockReferences.getBlockItemStack("persimmonLeaves"),
				new ItemStack(Block.wood));
		persimmon.template[EnumTreeChromosome.FRUITS.ordinal()] = fruitAllele;
		persimmon.register();
		
		ModTreeSpecies pine = new ModTreeSpecies(new WorldGenWrapper(new WorldGenPineTree()), /*0xA7A7A7*/0x1E4C0A,
				new String[] {"Pinus", "ponderosa"},
				"bop.pine",
				BlockReferences.getBlockItemStack("pineSapling"),
				BlockReferences.getBlockItemStack("pineLeaves"),
				BlockReferences.getBlockItemStack("pineLog"));
		pine.register();
		
		ModTreeSpecies pinkCherry = new ModTreeSpecies(new WorldGenWrapper(new WorldGenCherry1(false)), 0xE89FC3,
				new String[] {"Prunus", "serrulata"},
				"bop.pinkCherry",
				BlockReferences.getBlockItemStack("pinkCherrySapling"),
				BlockReferences.getBlockItemStack("pinkCherryLeaves"),
				BlockReferences.getBlockItemStack("cherryLog"));
		pinkCherry.register();
		
		ModTreeSpecies redwood = new ModTreeSpecies(new WorldGenWrapper(new WorldGenRedwoodTree2(false)), /*0xBABABA*/0x2E492E,
				new String[] {"Sequoiadendron", "giganteum"},
				"bop.redwood",
				BlockReferences.getBlockItemStack("redwoodSapling"),
				BlockReferences.getBlockItemStack("redwoodLeaves"),
				BlockReferences.getBlockItemStack("redwoodLog"));
		redwood.register();
		
		ModTreeSpecies sacredoak = new ModTreeSpecies(new WorldGenWrapper(new WorldGenMassiveTree(false)), 0x48B518,
				new String[] {"Commenticius", "sacer"},
				"bop.sacredoak",
				BlockReferences.getBlockItemStack("sacredoakSapling"),
				new ItemStack(Block.leaves),
				new ItemStack(Block.wood));
		sacredoak.register();
		
		ModTreeSpecies whiteCherry = new ModTreeSpecies(new WorldGenWrapper(new WorldGenCherry2(false)), 0xDBC3D1,
				new String[] {"Prunus", "speciosa"},
				"bop.whiteCherry",
				BlockReferences.getBlockItemStack("whiteCherrySapling"),
				BlockReferences.getBlockItemStack("whiteCherryLeaves"),
				BlockReferences.getBlockItemStack("cherryLog"));
		whiteCherry.register();
		
		ModTreeSpecies willow = new ModTreeSpecies(new WorldGenWrapper(new WorldGenWillow()), /*0x9D9D9D*/0x3A4B26,
				new String[] {"Salix", "alba"},
				"bop.willow",
				BlockReferences.getBlockItemStack("willowSapling"),
				BlockReferences.getBlockItemStack("willowLeaves"),
				BlockReferences.getBlockItemStack("willowLog"));
		willow.register();
		
		ModTreeSpecies yellowAutumn = new ModTreeSpecies(new WorldGenWrapper(new WorldGenAutumn(false)), 0xB78E28,
				new String[] {"Commenticius", "flavus"},
				"bop.yellowAutumn",
				BlockReferences.getBlockItemStack("yellowAutumnSapling"),
				BlockReferences.getBlockItemStack("yellowAutumnLeaves"),
				new ItemStack(Block.wood));
		yellowAutumn.register();
	}

	public static String MODID = "BiomesOPlenty";
}
