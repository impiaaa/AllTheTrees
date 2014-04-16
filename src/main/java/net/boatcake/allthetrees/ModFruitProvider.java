package net.boatcake.allthetrees;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import forestry.api.arboriculture.IFruitProvider;
import forestry.api.arboriculture.ITreeGenome;
import forestry.api.genetics.IFruitFamily;

public class ModFruitProvider implements IFruitProvider {
	ItemStack underlyingFruit;
	ItemStack underlyingLeaves;
	String description;
	IFruitFamily family;
	
	public ModFruitProvider(ItemStack underlyingFruit, ItemStack underlyingLeaves, String description, IFruitFamily family) {
		this.underlyingFruit = underlyingFruit;
		this.underlyingLeaves = underlyingLeaves;
		this.description = description;
		this.family = family;
	}

	@Override
	public IFruitFamily getFamily() {
		return family;
	}

	@Override
	public int getColour(ITreeGenome genome, IBlockAccess world, int x, int y,
			int z, int ripeningTime) {
		return 0xFFFFFF;
	}

	@Override
	public boolean markAsFruitLeaf(ITreeGenome genome, World world, int x,
			int y, int z) {
		return false;
	}

	@Override
	public int getRipeningPeriod() {
		return 0;
	}

	@Override
	public ItemStack[] getProducts() {
		return new ItemStack[] { underlyingFruit };
	}

	@Override
	public ItemStack[] getSpecialty() {
		return new ItemStack[0];
	}

	@Override
	public ItemStack[] getFruits(ITreeGenome genome, World world, int x, int y,
			int z, int ripeningTime) {
		return new ItemStack[] { underlyingFruit };
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public short getIconIndex(ITreeGenome genome, IBlockAccess world, int x,
			int y, int z, int ripeningTime, boolean fancy) {
		return 0;
	}

	@Override
	public boolean requiresFruitBlocks() {
		return false;
	}

	@Override
	public boolean trySpawnFruitBlock(ITreeGenome genome, World world, int x,
			int y, int z) {
		return world.setBlockMetadataWithNotify(x, y, z, underlyingLeaves.itemID, underlyingLeaves.getItemDamage());
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register) {
	}

}
