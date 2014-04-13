package net.boatcake.allthetrees;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenWrapper extends WorldGenerator {
	private WorldGenerator base;
	
	public WorldGenWrapper(Class <? extends WorldGenerator> baseClass) throws Exception {
		base = (WorldGenerator) baseClass.getConstructor(
				new Class[] { boolean.class }).newInstance(
				new Object[] { false });
	}

	@Override
	public boolean generate(World world, Random random, int x, int y, int z) {
		world.setBlockToAir(x, y, z);
		return base.generate(world, random, x, y, z);
	}

}
