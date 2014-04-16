package net.boatcake.allthetrees;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenWrapper extends WorldGenerator {
	private WorldGenerator base;
	
	public WorldGenWrapper(WorldGenerator base) {
		this.base = base;
	}

	@Override
	public boolean generate(World world, Random random, int x, int y, int z) {
		int blockID = world.getBlockId(x, y, z);
		world.setBlockToAir(x, y, z);

		if (base.generate(world, random, x, y, z)) {
			return true;
		}
		else {
			int meta = world.getBlockMetadata(x, y, z);
			world.setBlock(x, y, z, blockID, meta, 2);
			return false;
		}
	}

}
