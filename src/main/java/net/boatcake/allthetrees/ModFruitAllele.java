package net.boatcake.allthetrees;

import net.minecraft.item.ItemStack;
import forestry.api.arboriculture.IAlleleFruit;
import forestry.api.arboriculture.IFruitProvider;

public class ModFruitAllele implements IAlleleFruit {
	ItemStack underlying;
	String uid;
	IFruitProvider provider;
	
	public ModFruitAllele(ItemStack underlying, String uid, IFruitProvider provider) {
		this.underlying = underlying;
		this.uid = uid;
		this.provider = provider;
	}

	@Override
	public String getUID() {
		return uid;
	}

	@Override
	public boolean isDominant() {
		return true;
	}

	@Override
	public String getName() {
		return underlying.getDisplayName();
	}

	@Override
	public IFruitProvider getProvider() {
		return provider;
	}

}
