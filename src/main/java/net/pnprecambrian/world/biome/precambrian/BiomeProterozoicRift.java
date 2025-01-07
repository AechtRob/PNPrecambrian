
package net.pnprecambrian.world.biome.precambrian;

import net.lepidodendron.block.*;
import net.lepidodendron.util.EnumBiomeTypePrecambrian;
import net.lepidodendron.world.biome.ChunkGenSpawner;
import net.lepidodendron.world.biome.precambrian.BiomePrecambrian;
import net.lepidodendron.world.gen.WorldGenAddSomethingToTopSolidBlock;
import net.lepidodendron.world.gen.WorldGenBacterialCrust;
import net.lepidodendron.world.gen.WorldGenToxicMud;
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
public class BiomeProterozoicRift extends ElementsPNPrecambrianMod.ModElement {
	@GameRegistry.ObjectHolder("lepidodendron:proterozoic_rift")
	public static final BiomeGenCustom biome = null;
	public BiomeProterozoicRift(ElementsPNPrecambrianMod instance) {
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
		BiomeDictionary.addTypes(biome, BiomeDictionary.Type.BEACH);
	}

	static class BiomeGenCustom extends BiomePrecambrian {
		public BiomeGenCustom() {
			super(new BiomeProperties("Proterozoic Rift").setRainfall(0.9F).setBaseHeight(2.55F).setHeightVariation(0.122F).setTemperature(0.8F));
			setRegistryName("lepidodendron:proterozoic_rift");
			topBlock = BlockLavaCobble.block.getDefaultState();
			fillerBlock = BlockLavaRock.block.getDefaultState();
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
		protected static final WorldGenToxicMud TOXIC_MUD_GENERATOR = new WorldGenToxicMud();
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

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 28; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					BlockPos posIn = pos.add(j, 0, k);
					int l = ChunkGenSpawner.getTopSolidBlock(posIn, worldIn).getY();
					TOXIC_MUD_GENERATOR.generate(worldIn, rand, new BlockPos(posIn.getX(), l, posIn.getZ()));
				}


			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 92; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					CRUST_GENERATOR.generate(worldIn, rand, pos.add(j, l, k));
				}


			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), DecorateBiomeEvent.Decorate.EventType.GRASS)) {

				for (int i = 0; i < 5; ++i) {
					LITTER.generate(worldIn, rand, pos.add(16, 0, 16), 0, 109, BlockVolcanicAshDark.block.getDefaultState(), -1);
				}

				for (int i = 0; i < 4; ++i) {
					LITTER.generate(worldIn, rand, pos.add(16, 0, 16), 0, 109, BlockVolcanicAshDark.block.getDefaultState(), 0);
				}

				for (int i = 0; i < 3; ++i) {
					LITTER.generate(worldIn, rand, pos.add(16, 0, 16), 0, 109, BlockSulphurOreLavaRock.block.getDefaultState(), -1);
				}

				for (int i = 0; i < 2; ++i) {
					LITTER.generate(worldIn, rand, pos.add(16, 0, 16), 0, 109, BlockSulphurOreLavaRock.block.getDefaultState(), 0);
				}

				for (int i = 0; i < 4; ++i) {
					LITTER.generate(worldIn, rand, pos.add(16, 0, 16), 0, 108, BlockSulphurVent.block.getDefaultState(), 0);
				}

			}

			super.decorate(worldIn, rand, pos);
		}

		@Override
		public EnumBiomeTypePrecambrian getBiomeType() {
			return EnumBiomeTypePrecambrian.Proterozoic_Land;
		}

	}
}
