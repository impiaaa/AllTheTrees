package net.boatcake.allthetrees;

import net.boatcake.allthetrees.plugins.IPlugin;
import net.boatcake.allthetrees.plugins.PluginBOP;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;

@Mod(modid = "AllTheTrees", name = "All the Trees!", version = "1.0", dependencies = "after:BiomesOPlenty; required-after:Forestry; required-after:Forge")
public class AllTheTrees {
	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {
		registerPlugins();
	}
	private void registerPlugins() {
		if (Loader.isModLoaded(PluginBOP.MODID)) {
			new PluginBOP().register();
		}
	}
}
