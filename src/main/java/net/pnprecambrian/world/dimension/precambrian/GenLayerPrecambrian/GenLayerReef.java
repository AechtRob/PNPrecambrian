package net.pnprecambrian.world.dimension.precambrian.GenLayerPrecambrian;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerReef extends GenLayer
{

    public Biome REEF = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:ediacaran_shallow_reef"));
    public int REEF_ID =  Biome.getIdForBiome(REEF);

    public Biome EDIACARAN_OCEAN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:precambrian_sea"));
    public int EDIACARAN_OCEAN_ID =  Biome.getIdForBiome(EDIACARAN_OCEAN);
    public Biome DIACARAN_OCEAN_HILLS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:ediacaran_extreme_hills"));
    public int EDIACARAN_OCEAN_HILLS_ID =  Biome.getIdForBiome(DIACARAN_OCEAN_HILLS);
    public Biome EDIACARAN_FRONDOSE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:ediacaran_frondose_forest"));
    public int EDIACARAN_FRONDOSE_ID =  Biome.getIdForBiome(EDIACARAN_FRONDOSE);
    public Biome EDIACARAN_SPARSE_OCEAN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:ediacaran_sparse_sea"));
    public int EDIACARAN_SPARSE_OCEAN_ID =  Biome.getIdForBiome(EDIACARAN_SPARSE_OCEAN);

    public GenLayerReef(long seed, GenLayer genLayer)
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

               if (isEdiacaran(k))
                {
                    int l1 = aint[j + 1 + (i + 1 - 1) * (areaWidth + 2)];
                    int k2 = aint[j + 1 + 1 + (i + 1) * (areaWidth + 2)];
                    int j3 = aint[j + 1 - 1 + (i + 1) * (areaWidth + 2)];
                    int i4 = aint[j + 1 + (i + 1 + 1) * (areaWidth + 2)];

                    if (isEdiacaran(l1) && isEdiacaran(k2) && isEdiacaran(j3) && isEdiacaran(i4) && nextInt(36) == 0)
                    {
                        aint1[j + i * areaWidth] = REEF_ID;
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

    private boolean isEdiacaran(int biomeID) {
        if (biomeID == EDIACARAN_OCEAN_ID
                || biomeID == EDIACARAN_OCEAN_HILLS_ID
                || biomeID == EDIACARAN_FRONDOSE_ID
                || biomeID == EDIACARAN_SPARSE_OCEAN_ID) {
            return true;
        }
        return false;
    }

}
