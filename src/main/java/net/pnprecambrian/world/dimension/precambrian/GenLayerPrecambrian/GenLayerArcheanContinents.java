package net.pnprecambrian.world.dimension.precambrian.GenLayerPrecambrian;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerArcheanContinents extends GenLayer
{

    public static Biome ARCHEAN_SEA = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:archean_shallow_sea"));
    public static int ARCHEAN_SEA_ID =  Biome.getIdForBiome(ARCHEAN_SEA);

    public Biome ARCHEAN_WINDSWEPT = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:archean_windswept"));
    public int ARCHEAN_WINDSWEPT_ID =  Biome.getIdForBiome(ARCHEAN_WINDSWEPT);


    public GenLayerArcheanContinents(long seed, GenLayer genLayer)
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
                this.initChunkSeed(j + areaX, i + areaY);
                int k = aint[j + 1 + (i + 1) * (areaWidth + 2)];

                if (isSea(k))
                {
                    int l1 = aint[j + 1 + (i + 1 - 1) * (areaWidth + 2)];
                    int k2 = aint[j + 1 + 1 + (i + 1) * (areaWidth + 2)];
                    int j3 = aint[j + 1 - 1 + (i + 1) * (areaWidth + 2)];
                    int i4 = aint[j + 1 + (i + 1 + 1) * (areaWidth + 2)];
                    if (isSea(l1)
                            && isSea(k2)
                            && isSea(j3)
                            && isSea(i4))
                    {
                        if (nextInt(5) == 0) {
                            aint1[j + i * areaWidth] = ARCHEAN_WINDSWEPT_ID;
                        }
                        else {
                            aint1[j + i * areaWidth] = k;
                        }
                    }
                    else {
                        aint1[j + i * areaWidth] = k;
                    }
                }
                else {
                    aint1[j + i * areaWidth] = k;
                }
            }
        }

        return aint1;
    }

    public static boolean isSea(int i) {
        return i == ARCHEAN_SEA_ID;
    }
    
}
