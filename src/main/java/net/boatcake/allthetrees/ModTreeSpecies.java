package net.boatcake.allthetrees;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.EnumPlantType;

import org.apache.commons.lang3.StringUtils;

import cpw.mods.fml.common.ModContainer;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import forestry.api.arboriculture.EnumGermlingType;
import forestry.api.arboriculture.EnumTreeChromosome;
import forestry.api.arboriculture.IAlleleTreeSpecies;
import forestry.api.arboriculture.ITree;
import forestry.api.arboriculture.ITreeRoot;
import forestry.api.core.EnumHumidity;
import forestry.api.core.EnumTemperature;
import forestry.api.core.IIconProvider;
import forestry.api.genetics.AlleleManager;
import forestry.api.genetics.IAllele;
import forestry.api.genetics.IClassification;
import forestry.api.genetics.IClassification.EnumClassLevel;
import forestry.api.genetics.IFruitFamily;
import forestry.api.genetics.IIndividual;
import forestry.api.genetics.IMutation;

public class ModTreeSpecies implements IIconProvider, IAlleleTreeSpecies {
	public WorldGenerator gen;
	public int color;
	public String species;
	public String uid;
	public IClassification branch;
	public String description;
	public ItemStack underlyingSapling;
	public ItemStack underlyingLeaves;
	public ItemStack underlyingLog;
	public IAllele template[];

	public ModTreeSpecies(WorldGenerator gen, IAllele template[], int color,
			String species, String uid, String description,
			ItemStack underlyingSapling, ItemStack underlyingLeaves,
			ItemStack underlyingLog) {
		super();
		this.gen = gen;
		this.color = color;
		this.species = species;
		this.uid = uid;
		this.description = description;
		this.underlyingSapling = underlyingSapling;
		this.underlyingLeaves = underlyingLeaves;
		this.underlyingLog = underlyingLog;
		this.template = template;
	}

	public ModTreeSpecies(WorldGenerator gen, int color, String species,
			String uid, IClassification branch, String description,
			ItemStack underlyingSapling, ItemStack underlyingLeaves,
			ItemStack underlyingLog) {
		this(gen, Util.getTreeRoot().getDefaultTemplate(), color, species, uid,
				description, underlyingSapling, underlyingLeaves, underlyingLog);
		this.branch = branch;
		this.branch.addMemberSpecies(this);
	}

	private enum ClassificationLevel {
		DOMAIN(EnumClassLevel.DOMAIN, 0, "domain"), KINGDOM(
				EnumClassLevel.KINGDOM, 1, "kingdom"), PHYLUM(
				EnumClassLevel.PHYLUM, 2, "phylum"), DIVISION(
				EnumClassLevel.DIVISION, 3, "division"), CLASS(
				EnumClassLevel.CLASS, 4, "class"), ORDER(EnumClassLevel.ORDER,
				5, "order"), FAMILY(EnumClassLevel.FAMILY, 6, "family"), SUBFAMILY(
				EnumClassLevel.SUBFAMILY, 7, "subfamily"), TRIBE(
				EnumClassLevel.TRIBE, 8, "tribe"), GENUS(EnumClassLevel.GENUS,
				9, "genus"), SPECIES(null, 10, null);

		public EnumClassLevel level;
		public int number;
		public String name;

		ClassificationLevel(EnumClassLevel level, int number, String name) {
			this.level = level;
			this.number = number;
			this.name = name;
		}

		public static ClassificationLevel get(int n) {
			for (ClassificationLevel l : ClassificationLevel.values()) {
				if (l.number == n) {
					return l;
				}
			}
			return null;
		}
	}

	public ModTreeSpecies(WorldGenerator gen, int color,
			String[] classification, String uid, ItemStack underlyingSapling,
			ItemStack underlyingLeaves, ItemStack underlyingLog) {
		this(gen, Util.getTreeRoot().getDefaultTemplate(), color,
				classification[classification.length - 1], uid, null,
				underlyingSapling, underlyingLeaves, underlyingLog);
		IClassification branch = null;
		IClassification child = null;
		boolean newChild = false;
		boolean newBranch = false;
		for (int i = classification.length - 2; i >= 0; i--) {
			if (classification[i] == null) {
				continue;
			}
			ClassificationLevel level = ClassificationLevel.get(i
					+ (ClassificationLevel.SPECIES.number
							- classification.length + 1));
			String classLower = (level == ClassificationLevel.GENUS) ? ("trees." + classification[i]
					.toLowerCase()) : (classification[i].toLowerCase());
			branch = AlleleManager.alleleRegistry.getClassification(level.name
					+ "." + classLower);
			if (branch == null) {
				branch = AlleleManager.alleleRegistry
						.createAndRegisterClassification(level.level,
								classLower, classification[i]);
				System.out.println("Registering " + level.name + " "
						+ classification[i]);
				newBranch = true;
			} else {
				newBranch = false;
			}
			if (child != null && newChild) {
				branch.addMemberGroup(child);
				System.out.println("Adding child " + child.getName() + " to "
						+ branch.getName());
			}
			if (level == ClassificationLevel.GENUS) {
				this.branch = branch;
			}
			child = branch;
			newChild = newBranch;
		}
		this.branch.addMemberSpecies(this);
	}

	public void register() {
		AlleleManager.alleleRegistry.registerAllele(this);
		
		template[EnumTreeChromosome.SPECIES.ordinal()] = this;
		Util.getTreeRoot().registerTemplate(template);
		
		AlleleManager.ersatzSpecimen.put(this.underlyingLeaves.copy(), Util
				.getTreeRoot().templateAsIndividual(template));
		AlleleManager.ersatzSaplings.put(this.underlyingSapling.copy(), Util
				.getTreeRoot().templateAsIndividual(template));
	}

	public enum IconType {
		Sapling, LeavesPlain, LeavesChanged, LeavesFancy, LogSide, LogInside;
		public static IconType get(int ord) {
			for (IconType o : IconType.values()) {
				if (o.ordinal() == ord) {
					return o;
				}
			}
			return null;
		}
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public String getBinomial() {
		return species;
	}

	@Override
	public String getAuthority() {
		ModContainer mod = Util.getModFromObject(underlyingSapling.getItem());
		ModMetadata meta = mod.getMetadata();
		List<String> authors = meta.authorList;
		return StringUtils.join(authors, ", ");
	}

	@Override
	public IClassification getBranch() {
		return branch;
	}

	@Override
	public int getComplexity() {
		return 1 + getGeneticAdvancement(this, new ArrayList());
	}

	private int getGeneticAdvancement(IAllele species,
			ArrayList<IAllele> exclude) {
		int own = 1;
		int highest = 0;
		exclude.add(species);

		for (IMutation mutation : getRoot().getPaths(species,
				EnumTreeChromosome.SPECIES.ordinal())) {
			if (!exclude.contains(mutation.getAllele0())) {
				int otherAdvance = getGeneticAdvancement(mutation.getAllele0(),
						exclude);
				if (otherAdvance > highest)
					highest = otherAdvance;
			}
			if (!exclude.contains(mutation.getAllele1())) {
				int otherAdvance = getGeneticAdvancement(mutation.getAllele1(),
						exclude);
				if (otherAdvance > highest) {
					highest = otherAdvance;
				}
			}
		}
		return own + (highest < 0 ? 0 : highest);
	}

	@Override
	public float getResearchSuitability(ItemStack itemstack) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ItemStack[] getResearchBounty(World world, String researcher,
			IIndividual individual, int bountyLevel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EnumTemperature getTemperature() {
		return EnumTemperature.NORMAL;
	}

	@Override
	public EnumHumidity getHumidity() {
		return EnumHumidity.NORMAL;
	}

	@Override
	public boolean hasEffect() {
		return false;
	}

	@Override
	public boolean isSecret() {
		return false;
	}

	@Override
	public boolean isCounted() {
		return true;
	}

	@Override
	public int getIconColour(int renderPass) {
		return renderPass == 0 ? this.color : 0x9F784D;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIconProvider getIconProvider() {
		return this;
	}

	@Override
	public String getUID() {
		return "net.boatcake.species." + uid;
	}

	@Override
	public boolean isDominant() {
		return true;
	}

	@Override
	public String getName() {
		return underlyingSapling.getDisplayName().replaceFirst(
				" " + EnumGermlingType.SAPLING.getName(), "");
	}

	@Override
	public ITreeRoot getRoot() {
		return Util.getTreeRoot();
	}

	@Override
	public EnumPlantType getPlantType() {
		return EnumPlantType.Plains;
	}

	@Override
	public Collection<IFruitFamily> getSuitableFruit() {
		ArrayList list = new ArrayList();
		list.addAll(AlleleManager.alleleRegistry.getRegisteredFruitFamilies()
				.values());
		return list;
	}

	@Override
	@Deprecated
	public int getGirth() {
		return 0;
	}

	@Override
	public WorldGenerator getGenerator(ITree tree, World world, int x, int y,
			int z) {
		return this.gen;
	}

	@Override
	public Class<? extends WorldGenerator>[] getGeneratorClasses() {
		// I have no idea what this is for.
		// Object[] result = {this.gen};
		// return (Class<? extends WorldGenerator>[]) result;
		return null;
	}

	@Override
	public int getLeafColour(ITree tree) {
		return color;
	}

	@Override
	public short getLeafIconIndex(ITree tree, boolean fancy) {
		if (!fancy) {
			return (short) IconType.LeavesPlain.ordinal();
		}
		if (tree.getMate() != null) {
			return (short) IconType.LeavesChanged.ordinal();
		}
		return (short) IconType.LeavesFancy.ordinal();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Icon getGermlingIcon(EnumGermlingType type, int renderPass) {
		if (type == EnumGermlingType.POLLEN) {
			return GameRegistry.findItem("Forestry", "pollen")
					.getIconFromDamageForRenderPass(0, renderPass);
		}

		return this.underlyingSapling.getIconIndex();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getGermlingColour(EnumGermlingType type, int renderPass) {
		return (type == EnumGermlingType.SAPLING) ? 0xFFFFFF : this.color;
	}

	@Override
	public ItemStack[] getLogStacks() {
		if (underlyingLog == null) {
			return new ItemStack[0];
		}
		return new ItemStack[] { underlyingLog };
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(short texUID) {
		switch (IconType.get(texUID)) {
		case LeavesChanged:
			return underlyingLeaves.getIconIndex();
		case LeavesFancy:
			return underlyingLeaves.getIconIndex();
		case LeavesPlain:
			return underlyingLeaves.getIconIndex();
		case LogInside:
			return underlyingLog.getIconIndex();
		case LogSide:
			return underlyingLog.getIconIndex();
		case Sapling:
			return underlyingSapling.getIconIndex();
		default:
			return null;
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register) {
	}

}
