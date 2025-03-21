
package net.pnprecambrian.world.biome.precambrian;

import net.lepidodendron.ElementsLepidodendronMod;
import net.lepidodendron.LepidodendronConfig;
import net.lepidodendron.block.*;
import net.lepidodendron.util.EnumBiomeTypePrecambrian;
import net.lepidodendron.world.biome.precambrian.BiomePrecambrian;
import net.lepidodendron.world.gen.WorldGenAddSomethingToTopSolidBlock;
import net.lepidodendron.world.gen.WorldGenNullTree;
import net.lepidodendron.world.gen.WorldGenPuddles;
import net.lepidodendron.world.gen.WorldGenToxicMud;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.Random;

@ElementsLepidodendronMod.ModElement.Tag
public class BiomeArcheanTidePools extends ElementsLepidodendronMod.ModElement {
	@GameRegistry.ObjectHolder("lepidodendron:archean_tide_pools")
	public static final BiomeGenCustom biome = null;
	public BiomeArcheanTidePools(ElementsLepidodendronMod instance) {
		super(instance, 1589);
	}

	@Override
	public void initElements() {
		elements.biomes.add(() -> new BiomeGenCustom());
	}

	@Override
	public void init(FMLInitializationEvent event) {
		BiomeDictionary.addTypes(biome, BiomeDictionary.Type.OCEAN);
		BiomeDictionary.addTypes(biome, BiomeDictionary.Type.BEACH);
		BiomeDictionary.addTypes(biome, BiomeDictionary.Type.WATER);
	}

	static class BiomeGenCustom extends BiomePrecambrian {
		public BiomeGenCustom() {
			//super(new BiomeProperties("Permian Desert").setRainfall(0.0F).setBaseHeight(0.18F).setHeightVariation(0.17F).setTemperature(2.2F).setRainDisabled().setWaterColor(10990706));
			super(new BiomeProperties("Archean Tide Pools").setBaseHeight(2.55F).setHeightVariation(0.0F).setTemperature(0.6F).setWaterColor(0x539E32));
			setRegistryName("lepidodendron:archean_tide_pools");
			topBlock = BlockSandBlack.block.getDefaultState();
			fillerBlock = BlockLavaRock.block.getDefaultState();
			decorator.treesPerChunk = -999;
			decorator.flowersPerChunk = 0;
			decorator.grassPerChunk = 0;
			decorator.mushroomsPerChunk = 0;
			decorator.bigMushroomsPerChunk = 0;
			decorator.reedsPerChunk = 0;
			decorator.cactiPerChunk = 0;
			decorator.sandPatchesPerChunk = 0;
			decorator.gravelPatchesPerChunk = 1;
			this.spawnableMonsterList.clear();
			this.spawnableCreatureList.clear();
			this.spawnableWaterCreatureList.clear();
			this.spawnableCaveCreatureList.clear();
		}

		protected static final WorldGenNullTree NULL_TREE = new WorldGenNullTree(false);

		protected static final WorldGenAddSomethingToTopSolidBlock LITTER = new WorldGenAddSomethingToTopSolidBlock();
		protected static final WorldGenToxicMud MUD_GENERATOR = new WorldGenToxicMud();
		protected static final WorldGenPuddles PUDDLES_GENERATOR = new WorldGenPuddles();

		public WorldGenAbstractTree getRandomTreeFeature(Random rand)
		{
			return NULL_TREE;
		}

		@Override
		public int getSkyColorByTemp(float par1)
		{
			if (LepidodendronConfig.renderFog) {
				return 0xD7450A;
			}
			return super.getSkyColorByTemp(par1);
		}

		@Override
		public void decorate(World worldIn, Random rand, BlockPos pos) {

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), DecorateBiomeEvent.Decorate.EventType.GRASS)) {
				for (int i = 0; i < 24; ++i) {
					LITTER.generate(worldIn, rand, pos.add(16, 0, 16), 0, 50, Blocks.MAGMA.getDefaultState(), -1);
				}
				for (int i = 0; i < 8; ++i) {
					LITTER.generate(worldIn, rand, pos.add(16, 0, 16), 0, 50, Blocks.MAGMA.getDefaultState(), 0);
				}

				for (int i = 0; i < 3; ++i) {
					LITTER.generate(worldIn, rand, pos.add(16, 0, 16), 0, 50, Blocks.OBSIDIAN.getDefaultState(), -1);
				}

				for (int i = 0; i < 3; ++i) {
					LITTER.generate(worldIn, rand, pos.add(16, 0, 16), 0, 50, BlockVolcanicAshLight.block.getDefaultState(), -1);
				}

				for (int i = 0; i < 3; ++i) {
					LITTER.generate(worldIn, rand, pos.add(16, 0, 16), 0, 50, BlockVolcanicAshDark.block.getDefaultState(), -1);
				}

				for (int i = 0; i < 3; ++i) {
					LITTER.generate(worldIn, rand, pos.add(16, 0, 16), 0, 50, BlockVolcanicAsh.block.getDefaultState(), -1);
				}

				for (int i = 0; i < 4; ++i) {
					LITTER.generate(worldIn, rand, pos.add(16, 0, 16), 0, 50, BlockVolcanicAshLight.block.getDefaultState(), 0);
				}

				for (int i = 0; i < 4; ++i) {
					LITTER.generate(worldIn, rand, pos.add(16, 0, 16), 0, 50, BlockVolcanicAshDark.block.getDefaultState(), 0);
				}

				for (int i = 0; i < 4; ++i) {
					LITTER.generate(worldIn, rand, pos.add(16, 0, 16), 0, 50, BlockVolcanicAsh.block.getDefaultState(), 0);
				}

				for (int i = 0; i < 2; ++i) {
					LITTER.generate(worldIn, rand, pos.add(16, 0, 16), 0, 50, BlockSulphurOre.block.getDefaultState(), -1);
				}

				for (int i = 0; i < 1; ++i) {
					LITTER.generate(worldIn, rand, pos.add(16, 0, 16), 0, 50, BlockSulphurOre.block.getDefaultState(), 0);
				}

				for (int i = 0; i < 2; ++i) {
					LITTER.generate(worldIn, rand, pos.add(16, 0, 16), 0, 50, BlockLavaRockZirconOre.block.getDefaultState(), -1);
				}

				if (rand.nextInt(8) == 0) {
					LITTER.generate(worldIn, rand, pos.add(16, 0, 16), 0, 50, BlockLavaRockDiamondOre.block.getDefaultState(), -1);
				}

				if (rand.nextInt(6) == 0) {
					for (int i = 0; i < 6; ++i) {
						if (rand.nextInt(6) == 0) {
							LITTER.generate(worldIn, rand, pos.add(16, 0, 16), 0, 60, BlockSulphurVent.block.getDefaultState(), 0);
						}
					}
				}
			}

			if (net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 36; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					PUDDLES_GENERATOR.generate(worldIn, rand, pos.add(j, l, k));
				}

			if (net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 128; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					MUD_GENERATOR.generate(worldIn, rand, pos.add(j, l, k));
				}

			super.decorate(worldIn, rand, pos);

		}

		@Override
		public EnumBiomeTypePrecambrian getBiomeType() {
			return EnumBiomeTypePrecambrian.Archean;
		}

	}
}
