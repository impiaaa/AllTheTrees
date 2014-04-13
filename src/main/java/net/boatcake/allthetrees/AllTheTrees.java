package net.boatcake.allthetrees;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGeneratorBonusChest;
import biomesoplenty.api.BlockReferences;
import biomesoplenty.api.Blocks;
import biomesoplenty.worldgen.tree.WorldGenJacaranda;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import forestry.api.arboriculture.EnumTreeChromosome;
import forestry.api.genetics.AlleleManager;
import forestry.api.genetics.IAllele;
import forestry.api.genetics.IClassification;

@Mod(modid = "AllTheTrees", name = "All the Trees", version = "1.0", dependencies = "after:BiomesOPlenty; required-after:Forestry; required-after:Forge")
public class AllTheTrees {
	@EventHandler
	public void init(FMLInitializationEvent e) {
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {
		ModTreeSpecies j = new ModTreeSpecies();
		j.gen = WorldGenJacaranda.class;
		j.color = 0x725a95;
		j.binomial = "Mimosifolia";
		j.uid = "jacaranda";
		IClassification branch = AlleleManager.alleleRegistry
				.getClassification("genus." + j.uid);
		if (branch == null) {
			branch = AlleleManager.alleleRegistry
					.createAndRegisterClassification(
							IClassification.EnumClassLevel.GENUS, j.uid,
							"Jacaranda");
		}
		j.branch = branch;
		j.branch.addMemberSpecies(j);
		j.underlyingSapling = BlockReferences.getBlockItemStack("jacarandaSapling");
		j.underlyingLeaves = BlockReferences.getBlockItemStack("jacarandaLeaves");
		j.underlyingLog = BlockReferences.getBlockItemStack("jacarandaLog");
		AlleleManager.alleleRegistry.registerAllele(j);
		IAllele template[] = Util.getTreeRoot().getDefaultTemplate();
		template[EnumTreeChromosome.SPECIES.ordinal()] = j;
		Util.getTreeRoot().registerTemplate(template);
		AlleleManager.ersatzSpecimen.put(j.underlyingLeaves, Util.getTreeRoot().templateAsIndividual(template));
		AlleleManager.ersatzSaplings.put(j.underlyingSapling, Util.getTreeRoot().templateAsIndividual(template));
	}
}
