
package net.pnprecambrian.world.biome.precambrian;

import net.lepidodendron.LepidodendronConfig;
import net.lepidodendron.block.*;
import net.lepidodendron.util.EnumBiomeTypePrecambrian;
import net.lepidodendron.world.biome.ChunkGenSpawner;
import net.lepidodendron.world.biome.precambrian.BiomePrecambrian;
import net.lepidodendron.world.gen.*;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.pnprecambrian.ElementsPNPrecambrianMod;

import java.util.Random;

@ElementsPNPrecambrianMod.ModElement.Tag
public class BiomeEdiacaranExtremeHills extends ElementsPNPrecambrianMod.ModElement {
	@GameRegistry.ObjectHolder("lepidodendron:ediacaran_extreme_hills")
	public static final BiomeGenCustom biome = null;
	public BiomeEdiacaranExtremeHills(ElementsPNPrecambrianMod instance) {
		super(instance, 1591);
	}

	@Override
	public void initElements() {
		elements.biomes.add(() -> new BiomeGenCustom());
	}

	@Override
	public void init(FMLInitializationEvent event) {
		BiomeDictionary.addTypes(biome, BiomeDictionary.Type.OCEAN);
		BiomeDictionary.addTypes(biome, BiomeDictionary.Type.WATER);
	}

	static class BiomeGenCustom extends BiomePrecambrian {
		public BiomeGenCustom() {
			super(new BiomeProperties("Ediacaran Extreme Sea Hills").setRainfall(0.95F).setBaseHeight(0F).setHeightVariation(0.50F).setTemperature(1.1F));
			setRegistryName("lepidodendron:ediacaran_extreme_hills");
			topBlock = Blocks.STONE.getDefaultState();
			fillerBlock = Blocks.STONE.getDefaultState();
			decorator.treesPerChunk = -999;
			decorator.flowersPerChunk = 0;
			decorator.grassPerChunk = 0;
			decorator.mushroomsPerChunk = 0;
			decorator.bigMushroomsPerChunk = 0;
			decorator.reedsPerChunk = 0;
			decorator.cactiPerChunk = 0;
			decorator.sandPatchesPerChunk = 2;
			decorator.gravelPatchesPerChunk = 0;
			this.spawnableMonsterList.clear();
			this.spawnableCreatureList.clear();
			this.spawnableWaterCreatureList.clear();
			this.spawnableCaveCreatureList.clear();
		}

		protected static final WorldGenAddSomethingToTopSolidBlock LITTER = new WorldGenAddSomethingToTopSolidBlock();
		protected static final WorldGenAshes ASH_GENERATOR = new WorldGenAshes();
		protected static final WorldGenToxicMud TOXIC_MUD_GENERATOR = new WorldGenToxicMud();
		//protected static final WorldGenIceOnSea ICE_GENERATOR = new WorldGenIceOnSea();
		//protected static final WorldGenSnow SNOW_GENERATOR = new WorldGenSnow();
		protected static final WorldGenStromatoliteReefPrecambrian REEF_GENERATOR = new WorldGenStromatoliteReefPrecambrian();
		protected static final WorldGenBacterialCrust CRUST_GENERATOR = new WorldGenBacterialCrust();
		protected static final WorldGenSingleStaticInWaterUpwards STATIC_GENERATOR = new WorldGenSingleStaticInWaterUpwards();
		protected static final WorldGenSingleStaticInWaterRotational STATIC_ROTATIONAL_GENERATOR = new WorldGenSingleStaticInWaterRotational();
		protected static final WorldGenSingleStaticInWaterSideways STATIC_SIDEWAYS_GENERATOR = new WorldGenSingleStaticInWaterSideways();

		public WorldGenAbstractTree getRandomTreeFeature(Random rand)
	    {
	        return null;
	    }

		/*@Override
		public int getSkyColorByTemp(float par1)
		{
			if (LepidodendronConfig.renderFog) {
				return 0xC81400;
			}
			return super.getSkyColorByTemp(par1);
		}*/

		@Override
	    public void decorate(World worldIn, Random rand, BlockPos pos)
	    {

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), DecorateBiomeEvent.Decorate.EventType.GRASS)) {

				for (int i = 0; i < 5; ++i) {
					LITTER.generate(worldIn, rand, pos.add(16, 0, 16), 0, 60, Blocks.STONE.getStateFromMeta(1), -1);
				}

				for (int i = 0; i < 5; ++i) {
					LITTER.generate(worldIn, rand, pos.add(16, 0, 16), 0, 60, Blocks.STONE.getStateFromMeta(3), -1);
				}

				for (int i = 0; i < 5; ++i) {
					LITTER.generate(worldIn, rand, pos.add(16, 0, 16), 0, 60, Blocks.STONE.getStateFromMeta(5), -1);
				}

				for (int i = 0; i < 3; ++i) {
					LITTER.generate(worldIn, rand, pos.add(16, 0, 16), 0, 60, Blocks.STONE.getStateFromMeta(1), 0);
				}

				for (int i = 0; i < 3; ++i) {
					LITTER.generate(worldIn, rand, pos.add(16, 0, 16), 0, 60, Blocks.STONE.getStateFromMeta(3), 0);
				}

				for (int i = 0; i < 3; ++i) {
					LITTER.generate(worldIn, rand, pos.add(16, 0, 16), 0, 60, Blocks.STONE.getStateFromMeta(5), 0);
				}

				for (int i = 0; i < 5; ++i) {
					LITTER.generate(worldIn, rand, pos.add(16, 0, 16), 0, 50, BlockVolcanicAshLight.block.getDefaultState(), -1);
				}

				for (int i = 0; i < 5; ++i) {
					LITTER.generate(worldIn, rand, pos.add(16, 0, 16), 0, 50, BlockVolcanicAshDark.block.getDefaultState(), -1);
				}

				for (int i = 0; i < 5; ++i) {
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

				for (int i = 0; i < 48; ++i) {
					LITTER.generate(worldIn, rand, pos.add(16, 0, 16), 0, 50, Blocks.STONE.getDefaultState(), 0);
				}
				for (int i = 0; i < 24; ++i) {
					LITTER.generate(worldIn, rand, pos.add(16, 0, 16), 0, 50, Blocks.GRAVEL.getDefaultState(), 0);
				}

				for (int i = 0; i < 6; ++i) {
					LITTER.generate(worldIn, rand, pos.add(16, 0, 16), 0, 50, BlockSulphurOre.block.getDefaultState(), -1);
				}


				if (rand.nextInt(4) == 0) {
					for (int i = 0; i < 8; ++i) {
						if (rand.nextInt(4) == 0) {
							LITTER.generate(worldIn, rand, pos.add(16, 0, 16), 0, 60, BlockSulphurVent.block.getDefaultState(), 0);
						}
					}
				}
			}

			if (net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), DecorateBiomeEvent.Decorate.EventType.ROCK))
			{
				int i = rand.nextInt(2);
				for (int j = 0; j < i; ++j)
				{
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(16) + 8;
					BlockPos blockpos = worldIn.getHeight(pos.add(k, 0, l));
					ASH_GENERATOR.generate(worldIn, rand, blockpos);
				}
			}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 128; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					TOXIC_MUD_GENERATOR.generate(worldIn, rand, pos.add(j, l, k));
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 30; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					CRUST_GENERATOR.generate(worldIn, rand, pos.add(j, l, k));
				}


			if (net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), DecorateBiomeEvent.Decorate.EventType.CLAY)) {
				for (int i = 0; i < 12; ++i) {
					int radius = 3;
					int j;
					int k;
					if (radius < 8) {
						j = 16 + (int)Math.floor(rand.nextInt(16 - radius - 8)/2) - (int)Math.floor(rand.nextInt(16 - radius - 6)/2);
						k = 16 + (int)Math.floor(rand.nextInt(16 - radius - 8)/2) - (int)Math.floor(rand.nextInt(16 - radius - 6)/2);
					}
					else {
						radius = 8;
						j = 16;
						k = 16;
					}
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					BlockPos pos1 = pos.add(j, l, k);
					if (
							(pos1.getY() < worldIn.getSeaLevel())
							&& pos1.getY() > 55
					) {
						REEF_GENERATOR.generate(worldIn, rand, pos1, radius, true, true);
					}
				}

			}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 12; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					STATIC_GENERATOR.generate(BlockGrypania.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), 1, 255, 65, 255);
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 24; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					STATIC_GENERATOR.generate(BlockGrypania.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), 1, 255, 65, 110);
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 12; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					STATIC_GENERATOR.generate(BlockTawuia.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), 1, 255, 0, 255);
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 5; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = ChunkGenSpawner.getTopSolidBlock(new BlockPos(pos.add(i, 0, k)), worldIn).getY() + 1;
					STATIC_GENERATOR.generate(BlockTuanshanzia.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), 1, 255, 65, 255);
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS)) {
				double edicarandensity = LepidodendronConfig.genEdiacaran;
				if (edicarandensity < 0.01) {
					edicarandensity = 0.01;
				}
				if (edicarandensity > 1.0) {
					edicarandensity = 1.0;
				}
				for (int i = 0; i < Math.ceil(14D * edicarandensity); ++i) {
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					if (worldIn.getBiome(pos.add(j, l, k)) == this) {
						STATIC_ROTATIONAL_GENERATOR.generate(BlockCharnia.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), 8, 255, 60, 255);
					}
				}
			}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS)) {
				double edicarandensity = LepidodendronConfig.genEdiacaran;
				if (edicarandensity < 0.01) {
					edicarandensity = 0.01;
				}
				if (edicarandensity > 1.0) {
					edicarandensity = 1.0;
				}
				for (int i = 0; i < Math.ceil(14D * edicarandensity); ++i) {
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					if (worldIn.getBiome(pos.add(j, l, k)) == this) {
						STATIC_ROTATIONAL_GENERATOR.generate(BlockBomakellia.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), 8, 255, 0, 38);
					}
				}
			}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS)) {
				double edicarandensity = LepidodendronConfig.genEdiacaran;
				if (edicarandensity < 0.01) {
					edicarandensity = 0.01;
				}
				if (edicarandensity > 1.0) {
					edicarandensity = 1.0;
				}
				for (int i = 0; i < Math.ceil(2D * edicarandensity); ++i) {
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = ChunkGenSpawner.getTopSolidBlock(new BlockPos(pos.add(i, 0, k)), worldIn).getY() + 1;
					if (worldIn.getBiome(pos.add(j, l, k)) == this) {
						STATIC_ROTATIONAL_GENERATOR.generate(BlockFrondophyllas.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), 2, 255, 0, 38);
					}
				}
			}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS)) {
				double edicarandensity = LepidodendronConfig.genEdiacaran;
				if (edicarandensity < 0.01) {
					edicarandensity = 0.01;
				}
				if (edicarandensity > 1.0) {
					edicarandensity = 1.0;
				}
				for (int i = 0; i < Math.ceil(2D * edicarandensity); ++i) {
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = ChunkGenSpawner.getTopSolidBlock(new BlockPos(pos.add(i, 0, k)), worldIn).getY() + 1;
					if (worldIn.getBiome(pos.add(j, l, k)) == this) {
						STATIC_ROTATIONAL_GENERATOR.generate(BlockHapsidophyllas.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), 2, 255, 0, 38);
					}
				}
			}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS)) {
				double edicarandensity = LepidodendronConfig.genEdiacaran;
				if (edicarandensity < 0.01) {
					edicarandensity = 0.01;
				}
				if (edicarandensity > 1.0) {
					edicarandensity = 1.0;
				}
				for (int i = 0; i < Math.ceil(2D * edicarandensity); ++i) {
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = ChunkGenSpawner.getTopSolidBlock(new BlockPos(pos.add(i, 0, k)), worldIn).getY() + 1;
					if (worldIn.getBiome(pos.add(j, l, k)) == this) {
						STATIC_ROTATIONAL_GENERATOR.generate(BlockPrimocandelabrum1.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), 2, 255, 0, 38);
					}
				}
			}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS)) {
				double edicarandensity = LepidodendronConfig.genEdiacaran;
				if (edicarandensity < 0.01) {
					edicarandensity = 0.01;
				}
				if (edicarandensity > 1.0) {
					edicarandensity = 1.0;
				}
				for (int i = 0; i < Math.ceil(2D * edicarandensity); ++i) {
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = ChunkGenSpawner.getTopSolidBlock(new BlockPos(pos.add(i, 0, k)), worldIn).getY() + 1;
					if (worldIn.getBiome(pos.add(j, l, k)) == this) {
						STATIC_ROTATIONAL_GENERATOR.generate(BlockPrimocandelabrum2.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), 2, 255, 0, 38);
					}
				}
			}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS)) {
				double edicarandensity = LepidodendronConfig.genEdiacaran;
				if (edicarandensity < 0.01) {
					edicarandensity = 0.01;
				}
				if (edicarandensity > 1.0) {
					edicarandensity = 1.0;
				}
				for (int i = 0; i < Math.ceil(2D * edicarandensity); ++i) {
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = ChunkGenSpawner.getTopSolidBlock(new BlockPos(pos.add(i, 0, k)), worldIn).getY() + 1;
					if (worldIn.getBiome(pos.add(j, l, k)) == this) {
						STATIC_ROTATIONAL_GENERATOR.generate(BlockParviscopa.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), 2, 255, 0, 38);
					}
				}
			}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS)) {
				double edicarandensity = LepidodendronConfig.genEdiacaran;
				if (edicarandensity < 0.01) {
					edicarandensity = 0.01;
				}
				if (edicarandensity > 1.0) {
					edicarandensity = 1.0;
				}
				for (int i = 0; i < Math.ceil(2D * edicarandensity); ++i) {
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = ChunkGenSpawner.getTopSolidBlock(new BlockPos(pos.add(i, 0, k)), worldIn).getY() + 1;
					if (worldIn.getBiome(pos.add(j, l, k)) == this) {
						STATIC_ROTATIONAL_GENERATOR.generate(BlockGigarimaneta.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), 2, 255, 0, 38);
					}
				}
			}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS)) {
				double edicarandensity = LepidodendronConfig.genEdiacaran;
				if (edicarandensity < 0.01) {
					edicarandensity = 0.01;
				}
				if (edicarandensity > 1.0) {
					edicarandensity = 1.0;
				}
				for (int i = 0; i < Math.ceil(2D * edicarandensity); ++i) {
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = ChunkGenSpawner.getTopSolidBlock(new BlockPos(pos.add(i, 0, k)), worldIn).getY() + 1;
					if (worldIn.getBiome(pos.add(j, l, k)) == this) {
						STATIC_ROTATIONAL_GENERATOR.generate(BlockHylaecullulus.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), 2, 255, 0, 38);
					}
				}
			}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS)) {
				double edicarandensity = LepidodendronConfig.genEdiacaran;
				if (edicarandensity < 0.01) {
					edicarandensity = 0.01;
				}
				if (edicarandensity > 1.0) {
					edicarandensity = 1.0;
				}
				for (int i = 0; i < Math.ceil(2D * edicarandensity); ++i) {
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = ChunkGenSpawner.getTopSolidBlock(new BlockPos(pos.add(i, 0, k)), worldIn).getY() + 1;
					if (worldIn.getBiome(pos.add(j, l, k)) == this) {
						STATIC_GENERATOR.generate(BlockBradgatia.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), 2, 255, 0, 38);
					}
				}
			}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS)) {
				double edicarandensity = LepidodendronConfig.genEdiacaran;
				if (edicarandensity < 0.01) {
					edicarandensity = 0.01;
				}
				if (edicarandensity > 1.0) {
					edicarandensity = 1.0;
				}
				for (int i = 0; i < Math.ceil(2D * edicarandensity); ++i) {
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = ChunkGenSpawner.getTopSolidBlock(new BlockPos(pos.add(i, 0, k)), worldIn).getY() + 1;
					if (worldIn.getBiome(pos.add(j, l, k)) == this) {
						STATIC_GENERATOR.generate(BlockHaootia.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), 2, 255, 0, 38);
					}
				}
			}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS)) {
				double edicarandensity = LepidodendronConfig.genEdiacaran;
				if (edicarandensity < 0.01) {
					edicarandensity = 0.01;
				}
				if (edicarandensity > 1.0) {
					edicarandensity = 1.0;
				}
				for (int i = 0; i < Math.ceil(3D * edicarandensity); ++i) {
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = ChunkGenSpawner.getTopSolidBlock(new BlockPos(pos.add(i, 0, k)), worldIn).getY() + 1;
					if (worldIn.getBiome(pos.add(j, l, k)) == this) {
						STATIC_GENERATOR.generate(BlockFractofusus.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), 2, 255, 0, 38);
					}
				}
			}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 30; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					STATIC_GENERATOR.generate(BlockEukaryoticMat.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), 1, 255, 0, 255);
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 45; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					STATIC_GENERATOR.generate(BlockEukaryoticMat.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), 1, 255, 0, 35);
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS)) {
				for (int i = 0; i < 16; ++i) {
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					if (worldIn.getBiome(pos.add(j, l, k)) == this) {
						STATIC_SIDEWAYS_GENERATOR.generate(BlockFedomia.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), 10, 85, 40, 255);
					}
				}
			}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS)) {
				for (int i = 0; i < 16; ++i) {
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					if (worldIn.getBiome(pos.add(j, l, k)) == this) {
						STATIC_GENERATOR.generate(BlockFedomia.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), 10, 85, 40, 255);
					}
				}
			}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS)) {
				double edicarandensity = LepidodendronConfig.genEdiacaran;
				if (edicarandensity < 0.01) {
					edicarandensity = 0.01;
				}
				if (edicarandensity > 1.0) {
					edicarandensity = 1.0;
				}
				for (int i = 0; i < Math.ceil(14D * edicarandensity); ++i) {
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					if (worldIn.getBiome(pos.add(j, l, k)) == this) {
						STATIC_ROTATIONAL_GENERATOR.generate(BlockPteridinium.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), 1, 255, 65, 255);
					}
				}
			}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS)) {
				for (int i = 0; i < 19; ++i) {
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					if (worldIn.getBiome(pos.add(j, l, k)) == this) {
						STATIC_GENERATOR.generate(BlockPalaeopascichnid.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), 1, 255, 0, 255);
					}
				}
			}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS)) {
				for (int i = 0; i < 14; ++i) {
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					if (worldIn.getBiome(pos.add(j, l, k)) == this) {
						STATIC_GENERATOR.generate(BlockAuroralumina.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), 20, 200, 0,  35);
					}
				}
			}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS)) {
				for (int i = 0; i < 14; ++i) {
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					if (worldIn.getBiome(pos.add(j, l, k)) == this) {
						STATIC_SIDEWAYS_GENERATOR.generate(BlockAuroralumina.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), 20, 200, 0,  35);
					}
				}
			}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS)) {
				for (int i = 0; i < 40; ++i) {
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					if (worldIn.getBiome(pos.add(j, l, k)) == this) {
						STATIC_GENERATOR.generate(BlockBurykhia.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), 2, 70, 0, 255);
					}
				}
			}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS)) {
				for (int i = 0; i < 19; ++i) {
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					if (worldIn.getBiome(pos.add(j, l, k)) == this) {
						STATIC_GENERATOR.generate(BlockRangea.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), 4, 100, 63, 255);
					}
				}
			}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS)) {
				for (int i = 0; i < 14; ++i) {
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					if (worldIn.getBiome(pos.add(j, l, k)) == this) {
						STATIC_GENERATOR.generate(BlockTribrachidium.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), 2, 80, 65, 255);
					}
				}
			}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS)) {
				for (int i = 0; i < 14; ++i) {
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					if (worldIn.getBiome(pos.add(j, l, k)) == this) {
						STATIC_SIDEWAYS_GENERATOR.generate(BlockTribrachidium.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), 2, 80, 65, 255);
					}
				}
			}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS)) {
				for (int i = 0; i < 34; ++i) {
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					if (worldIn.getBiome(pos.add(j, l, k)) == this) {
						STATIC_GENERATOR.generate(BlockVendoconularia.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), 2, 45, 65, 255);
					}
				}
			}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS)) {
				for (int i = 0; i < 34; ++i) {
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					if (worldIn.getBiome(pos.add(j, l, k)) == this) {
						STATIC_GENERATOR.generate(BlockVentogyrus.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), 2, 70, 65, 255);
					}
				}
			}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS)) {
				for (int i = 0; i < 12; ++i) {
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = ChunkGenSpawner.getTopSolidBlock(new BlockPos(pos.add(i, 0, k)), worldIn).getY() + 1;
					if (worldIn.getBiome(pos.add(j, l, k)) == this) {
						STATIC_GENERATOR.generate(BlockWaterBottomGunk.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), 2, 255, 0, 38);
					}
				}
			}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 32; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					STATIC_GENERATOR.generate(BlockGreenAlgaeMat.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), 1, 255, 90, 110);
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 32; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					STATIC_GENERATOR.generate(BlockRedAlgaeMat.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), 1, 255, 70, 100);
				}

			super.decorate(worldIn, rand, pos);
		}

		@Override
		public EnumBiomeTypePrecambrian getBiomeType() {
			return EnumBiomeTypePrecambrian.Ediacaran;
		}

	}
}
