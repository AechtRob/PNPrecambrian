package net.pnprecambrian.world.dimension.precambrian;

import com.google.common.collect.Lists;
import net.lepidodendron.world.biome.precambrian.BiomePrecambrian;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.util.ReportedException;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeCache;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;
import net.minecraft.world.storage.WorldInfo;
import net.pnprecambrian.world.biome.precambrian.BiomeProterozoicHills;
import net.pnprecambrian.world.dimension.precambrian.GenLayerPrecambrian.GenLayerPrecambrian;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

public class BiomeProviderPrecambrian extends BiomeProvider {
    public static List<Biome> allowedBiomes = Lists.newArrayList(
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:mesoproterozoic_beach")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:paleoproterozoic_regolith")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:archean_tide_pools")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:paleoproterozoic_beach")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cryogenian_desert")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:mesoproterozoic_carpet")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:archean_shallow_sea")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:archean_caustic")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cryogenian_ocean")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:paleoproterozoic_shallows")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:archean_beach")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cryogenian_beach")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:ediacaran_beach")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:proterozoic_hills")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:precambrian_sea")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:precambrian_biome")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:hadean_craters")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:ediacaran_extreme_hills")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:ediacaran_trench")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:neoproterozoic_plains")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:archean_trench")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:hadean_lava")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:ediacaran_frondose_forest")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:hadean_smelts_helper")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:hadean_smelts")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:tonian_sea")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:proterozoic_rift")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:ediacaran_shallow_reef")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:ediacaran_stromatolite_pavement")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:ediacaran_sparse_sea"))

            );
    public GenLayer genBiomes;
    /** A GenLayer containing the indices into BiomeGenBase.biomeList[] */
    public GenLayer biomeIndexLayer;
    /** The biome list. */
    public final BiomeCache biomeCache;
    public final List<Biome> biomesToSpawnIn;

    protected BiomeProviderPrecambrian() {
        this.biomeCache = new BiomeCache(this);
        this.biomesToSpawnIn = Lists.newArrayList(allowedBiomes);
    }

    public BiomeProviderPrecambrian(long seed, WorldType worldType, String options) {
        this();
        GenLayer[] agenlayer = GenLayerPrecambrian.initializeAllBiomeGenerators(seed, worldType, options);
        agenlayer = getModdedBiomeGenerators(worldType, seed, agenlayer);
        this.genBiomes = agenlayer[0];
        this.biomeIndexLayer = agenlayer[1];
    }

    public BiomeProviderPrecambrian(long seed, WorldInfo info) {
        this(seed, info.getTerrainType(), info.getGeneratorOptions());
    }

    @Override
    public List<Biome> getBiomesToSpawnIn() {
        return this.biomesToSpawnIn;
    }

    @Override
    public Biome getBiome(BlockPos pos, Biome defaultBiome) {
        return this.biomeCache.getBiome(pos.getX(), pos.getZ(), BiomeProterozoicHills.biome);
    }

    @Override
    public Biome[] getBiomesForGeneration(Biome[] biomes, int x, int z, int width, int height)
    {
        IntCache.resetIntCache();

        if (biomes == null || biomes.length < width * height)
        {
            biomes = new Biome[width * height];
        }

        int[] aint = this.genBiomes.getInts(x, z, width, height);

        try
        {
            for (int i = 0; i < width * height; ++i)
            {
                biomes[i] = Biome.getBiome(aint[i], Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:proterozoic_hills")));
            }

            return biomes;
        }
        catch (Throwable throwable)
        {
            CrashReport crashreport = CrashReport.makeCrashReport(throwable, "Invalid Biome id");
            CrashReportCategory crashreportcategory = crashreport.makeCategory("RawBiomeBlock");
            crashreportcategory.addCrashSection("biomes[] size", Integer.valueOf(biomes.length));
            crashreportcategory.addCrashSection("x", Integer.valueOf(x));
            crashreportcategory.addCrashSection("z", Integer.valueOf(z));
            crashreportcategory.addCrashSection("w", Integer.valueOf(width));
            crashreportcategory.addCrashSection("h", Integer.valueOf(height));
            throw new ReportedException(crashreport);
        }
    }

    @Override
    public Biome[] getBiomes(@Nullable Biome[] listToReuse, int x, int z, int width, int length, boolean cacheFlag)
    {
        IntCache.resetIntCache();

        if (listToReuse == null || listToReuse.length < width * length)
        {
            listToReuse = new Biome[width * length];
        }

        if (cacheFlag && width == 16 && length == 16 && (x & 15) == 0 && (z & 15) == 0)
        {
            Biome[] abiome = this.biomeCache.getCachedBiomes(x, z);
            System.arraycopy(abiome, 0, listToReuse, 0, width * length);
            return listToReuse;
        }
        else
        {
            int[] aint = this.biomeIndexLayer.getInts(x, z, width, length);

            for (int i = 0; i < width * length; ++i)
            {
                listToReuse[i] = Biome.getBiome(aint[i], Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:proterozoic_hills")));
            }

            return listToReuse;
        }
    }

    @Override
    public boolean areBiomesViable(int x, int z, int radius, List<Biome> allowed) {
        IntCache.resetIntCache();
        int i = x - radius >> 2;
        int j = z - radius >> 2;
        int k = x + radius >> 2;
        int l = z + radius >> 2;
        int i1 = k - i + 1;
        int j1 = l - j + 1;
        int[] aint = this.genBiomes.getInts(i, j, i1, j1);
        try {
            for (int k1 = 0; k1 < i1 * j1; ++k1) {
                Biome biome = Biome.getBiome(aint[k1]);

                if (!allowed.contains(biome)) {
                    return false;
                }
                if (!(biome instanceof BiomePrecambrian)) {
                    return false;
                }
            }

            return true;
        }
        catch (Throwable throwable) {
            CrashReport crashreport = CrashReport.makeCrashReport(throwable, "Invalid Biome id");
            CrashReportCategory crashreportcategory = crashreport.makeCategory("Layer");
            crashreportcategory.addCrashSection("Layer", this.genBiomes.toString());
            crashreportcategory.addCrashSection("x", Integer.valueOf(x));
            crashreportcategory.addCrashSection("z", Integer.valueOf(z));
            crashreportcategory.addCrashSection("radius", Integer.valueOf(radius));
            crashreportcategory.addCrashSection("allowed", allowed);
            throw new ReportedException(crashreport);
        }
    }

    @Override
    @Nullable
    public BlockPos findBiomePosition(int x, int z, int range, List<Biome> biomes, Random random) {
        IntCache.resetIntCache();
        int i = x - range >> 2;
        int j = z - range >> 2;
        int k = x + range >> 2;
        int l = z + range >> 2;
        int i1 = k - i + 1;
        int j1 = l - j + 1;
        int[] aint = this.genBiomes.getInts(i, j, i1, j1);
        BlockPos blockpos = null;
        int k1 = 0;
        for (int l1 = 0; l1 < i1 * j1; ++l1) {
            int i2 = i + l1 % i1 << 2;
            int j2 = j + l1 / i1 << 2;
            Biome biome = Biome.getBiome(aint[l1]);
            if (biomes.contains(biome) && (blockpos == null || random.nextInt(k1 + 1) == 0)) {
                blockpos = new BlockPos(i2, 0, j2);
                ++k1;
            }
        }
        return blockpos;
    }

    @Override
    public void cleanupCache() {
        this.biomeCache.cleanupCache();
    }
}