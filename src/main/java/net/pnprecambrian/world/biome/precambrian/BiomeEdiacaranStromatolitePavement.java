
package net.pnprecambrian.world.biome.precambrian;

import net.lepidodendron.block.*;
import net.lepidodendron.util.EnumBiomeTypePrecambrian;
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
public class BiomeEdiacaranStromatolitePavement extends ElementsPNPrecambrianMod.ModElement {
	@GameRegistry.ObjectHolder("lepidodendron:ediacaran_stromatolite_pavement")
	public static final BiomeGenCustom biome = null;
	public BiomeEdiacaranStromatolitePavement(ElementsPNPrecambrianMod instance) {
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
			super(new BiomeProperties("Ediacaran Stromatolite Pavement").setRainfall(0.95F).setBaseHeight(1.1F).setHeightVariation(0.05F).setTemperature(1.1F));
			setRegistryName("lepidodendron:ediacaran_stromatolite_pavement");
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
				for (int i = 0; i < 14; ++i) {
					int radius = 8;
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
						REEF_GENERATOR.generate(worldIn, rand, pos1, radius, true, false);
					}
				}

				for (int i = 0; i < 14; ++i) {
					int radius = 4;
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
						REEF_GENERATOR.generate(worldIn, rand, pos1, radius, true, false);
					}
				}

				for (int i = 0; i < 56; ++i) {
					int radius = 2;
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
						REEF_GENERATOR.generate(worldIn, rand, pos1, radius, true, false);
					}
				}

				for (int i = 0; i < 56; ++i) {
					int radius = 2;
					int j;
					int k;
					if (radius < 8) {
						j = rand.nextInt(16) + 8;
						k = rand.nextInt(16) + 8;
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
						REEF_GENERATOR.generate(worldIn, rand, pos1, radius, true, false);
					}
				}
			}

			for (int i = 0; i < 92; ++i) {
				LITTER.generate(worldIn, rand, pos.add(rand.nextInt(16) + 8, 0, rand.nextInt(16) + 8), 0, 90, BlockStromatolite.block.getDefaultState(), -1);
			}

			for (int i = 0; i < 92; ++i) {
				LITTER.generate(worldIn, rand, pos.add(rand.nextInt(16) + 8, 0, rand.nextInt(16) + 8), 0, 90, BlockStromatolite.block.getDefaultState(), 0);
			}

			super.decorate(worldIn, rand, pos);
		}

		@Override
		public EnumBiomeTypePrecambrian getBiomeType() {
			return EnumBiomeTypePrecambrian.Ediacaran;
		}

	}
}
