package net.pnprecambrian.world.dimension.precambrian.GenLayerPrecambrian;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerPrecambrianHadeanMolten extends GenLayer {

    public Biome PRECAMBRIAN_LAVA = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:hadean_smelts"));
    public  int PRECAMBRIAN_LAVA_ID =  Biome.getIdForBiome(PRECAMBRIAN_LAVA);
    public Biome PRECAMBRIAN_MAGMA = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:hadean_lava"));
    public  int PRECAMBRIAN_MAGMA_ID =  Biome.getIdForBiome(PRECAMBRIAN_MAGMA);
    public  Biome PRECAMBRIAN_LAND = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:precambrian_biome"));
    public  int PRECAMBRIAN_LAND_ID =  Biome.getIdForBiome(PRECAMBRIAN_LAND);

    public GenLayerPrecambrianHadeanMolten(long seed, GenLayer genlayer) {
        super(seed);
        this.parent = genlayer;
    }

    private final int MoltenBiomes[] = new int[] {
            PRECAMBRIAN_LAVA_ID,
            PRECAMBRIAN_MAGMA_ID
    };

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
                Biome biome = Biome.getBiome(k);

                if (k == PRECAMBRIAN_LAND_ID)
                {
                    int l1 = aint[j + 1 + (i + 1 - 1) * (areaWidth + 2)];
                    int k2 = aint[j + 1 + 1 + (i + 1) * (areaWidth + 2)];
                    int j3 = aint[j + 1 - 1 + (i + 1) * (areaWidth + 2)];
                    int i4 = aint[j + 1 + (i + 1 + 1) * (areaWidth + 2)];

                    if (l1 == PRECAMBRIAN_LAND_ID && k2 == PRECAMBRIAN_LAND_ID && j3 == PRECAMBRIAN_LAND_ID && i4 == PRECAMBRIAN_LAND_ID & nextInt(4) == 0)
                    {
                        aint1[j + i * areaWidth] = MoltenBiomes[nextInt(MoltenBiomes.length)];;
                    }
                    else
                    {
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

}
