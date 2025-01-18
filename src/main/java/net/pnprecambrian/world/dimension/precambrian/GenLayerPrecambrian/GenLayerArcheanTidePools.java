package net.pnprecambrian.world.dimension.precambrian.GenLayerPrecambrian;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerArcheanTidePools extends GenLayer
{

    public Biome ARCHEAN_WINDSWEPT = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:archean_windswept"));
    public int ARCHEAN_WINDSWEPT_ID =  Biome.getIdForBiome(ARCHEAN_WINDSWEPT);

    public Biome PALEOPROTEROZOIC_OCEAN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:paleoproterozoic_shallows"));
    public int PALEOPROTEROZOIC_OCEAN_ID =  Biome.getIdForBiome(PALEOPROTEROZOIC_OCEAN);
    public Biome MESOPROTEROZOIC_OCEAN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:mesoproterozoic_carpet"));
    public int MESOPROTEROZOIC_OCEAN_ID =  Biome.getIdForBiome(MESOPROTEROZOIC_OCEAN);
    public Biome CRYOGENIAN_OCEAN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cryogenian_ocean"));
    public int CRYOGENIAN_OCEAN_ID =  Biome.getIdForBiome(CRYOGENIAN_OCEAN);

    public Biome ARCHEAN_OCEAN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:archean_shallow_sea"));
    public int ARCHEAN_OCEAN_ID =  Biome.getIdForBiome(ARCHEAN_OCEAN);

    public Biome ARCHEAN_POOLS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:archean_tide_pools"));
    public int ARCHEAN_POOLS_ID =  Biome.getIdForBiome(ARCHEAN_POOLS);

    public Biome EDIACARAN_OCEAN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:precambrian_sea"));
    public int EDIACARAN_OCEAN_ID =  Biome.getIdForBiome(EDIACARAN_OCEAN);
    public Biome DIACARAN_OCEAN_HILLS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:ediacaran_extreme_hills"));
    public int EDIACARAN_OCEAN_HILLS_ID =  Biome.getIdForBiome(DIACARAN_OCEAN_HILLS);
    public Biome EDIACARAN_FRONDOSE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:ediacaran_frondose_forest"));
    public int EDIACARAN_FRONDOSE_ID =  Biome.getIdForBiome(EDIACARAN_FRONDOSE);
    public Biome EDIACARAN_STROMATOLITE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:ediacaran_stromatolite_pavement"));
    public int EDIACARAN_STROMATOLITE_ID =  Biome.getIdForBiome(EDIACARAN_STROMATOLITE);
    public Biome EDIACARAN_REEF = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:ediacaran_shallow_reef"));
    public int EDIACARAN_REEF_ID =  Biome.getIdForBiome(EDIACARAN_REEF);
    public Biome EDIACARAN_SPARSE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:ediacaran_sparse_sea"));
    public int EDIACARAN_SPARSE_ID =  Biome.getIdForBiome(EDIACARAN_SPARSE);

    public GenLayerArcheanTidePools(long seed, GenLayer genLayer)
    {
        super(seed);
        this.parent = genLayer;
    }

    public int[] getInts(int areaX, int areaY, int areaWidth, int areaHeight)
    {
        int[] aint = this.parent.getInts(areaX - 1, areaY - 1, areaWidth + 2, areaHeight + 2);
        int[] aint1 = IntCache.getIntCache(areaWidth * areaHeight);

        for (int i = 0; i < areaHeight; ++i)
        {
            for (int j = 0; j < areaWidth; ++j)
            {
                this.initChunkSeed((long)(j + areaX), (long)(i + areaY));
                int k = aint[j + 1 + (i + 1) * (areaWidth + 2)];
                //Biome biome = Biome.getBiome(k);

               if (isOcean(k))
                {
                    int l1 = aint[j + 1 + (i + 1 - 1) * (areaWidth + 2)];
                    int k2 = aint[j + 1 + 1 + (i + 1) * (areaWidth + 2)];
                    int j3 = aint[j + 1 - 1 + (i + 1) * (areaWidth + 2)];
                    int i4 = aint[j + 1 + (i + 1 + 1) * (areaWidth + 2)];

                    if (isArcheanLand(l1) || isArcheanLand(k2) || isArcheanLand(j3) || isArcheanLand(i4))
                    {
                        aint1[j + i * areaWidth] = ARCHEAN_POOLS_ID;
                    }
                    else {
                        aint1[j + i * areaWidth] = k;
                    }
                }
                else
                {
                    aint1[j + i * areaWidth] = k;
                }
            }
        }

        return aint1;
    }

    private boolean isOcean(int biomeID) {
        if (biomeID == PALEOPROTEROZOIC_OCEAN_ID || biomeID == MESOPROTEROZOIC_OCEAN_ID
                || biomeID == CRYOGENIAN_OCEAN_ID
                || biomeID == EDIACARAN_OCEAN_ID
                || biomeID == EDIACARAN_OCEAN_HILLS_ID
                || biomeID == EDIACARAN_FRONDOSE_ID
                || biomeID == EDIACARAN_STROMATOLITE_ID
                || biomeID == EDIACARAN_REEF_ID
                || biomeID == EDIACARAN_SPARSE_ID
                || biomeID == ARCHEAN_OCEAN_ID) {
            return true;
        }
        return false;
    }

    private boolean isArcheanLand(int biomeID) {
        if (biomeID == ARCHEAN_WINDSWEPT_ID) {
            return true;
        }
        return false;
    }

}
