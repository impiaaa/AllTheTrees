package net.boatcake.allthetrees;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.ModContainer;

import forestry.api.arboriculture.ITreeRoot;
import forestry.api.genetics.AlleleManager;

public class Util {
	public static HashMap<String, ModContainer> modSourceMap;

	public static ITreeRoot getTreeRoot() {
		return (ITreeRoot) AlleleManager.alleleRegistry
				.getSpeciesRoot("rootTrees");
	}

	public static void initModList() {
		modSourceMap = new HashMap<String, ModContainer>();
		for (ModContainer mod : Loader.instance().getModList()) {
			modSourceMap.put(mod.getSource().getName(), mod);
		}
	}
	
	public static ModContainer getModFromObject(Object o) {
		String objPath = o.getClass().getProtectionDomain().getCodeSource()
				.getLocation().toString();
		try {
			objPath = URLDecoder.decode(objPath, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		if (modSourceMap == null) {
			initModList();
		}
		for (String s : modSourceMap.keySet()) {
			if (objPath.contains(s)) {
				return modSourceMap.get(s);
			}
		}
		return null;
	}
}
