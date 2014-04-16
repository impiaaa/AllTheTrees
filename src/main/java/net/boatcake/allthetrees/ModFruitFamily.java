package net.boatcake.allthetrees;

import net.minecraft.item.ItemStack;
import forestry.api.genetics.IFruitFamily;

public class ModFruitFamily implements IFruitFamily {
	String uid;
	ItemStack underlying;
	String scientific;
	String description;
	public ModFruitFamily(String uid, ItemStack underlying, String scientific, String description) {
		this.uid = uid;
		this.underlying = underlying;
		this.scientific = scientific;
		this.description = description;
	}
	@Override
	public String getUID() {
		return uid;
	}

	@Override
	public String getName() {
		return underlying.getDisplayName();
	}

	@Override
	public String getScientific() {
		return scientific;
	}

	@Override
	public String getDescription() {
		return description;
	}
}
