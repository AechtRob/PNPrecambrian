package net.pnprecambrian.world.dimension.precambrian.GenLayerPrecambrian;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerPrecambrianArcheanCaustic extends GenLayer {

    public Biome CAUSTIC = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:archean_caustic"));
    public int CAUSTIC_ID =  Biome.getIdForBiome(CAUSTIC);

    public Biome ARCHEAN_LAND = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:archean_hills"));
    public int ARCHEAN_LAND_ID =  Biome.getIdForBiome(ARCHEAN_LAND);

    public GenLayerPrecambrianArcheanCaustic(long seed, GenLayer genlayer) {
        super(seed);
        this.parent = genlayer;
    }

    private final int CausticBiomes[] = new int[] {
            CAUSTIC_ID,
            CAUSTIC_ID
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

                if (k == ARCHEAN_LAND_ID)
                {
                    int l1 = aint[j + 1 + (i + 1 - 1) * (areaWidth + 2)];
                    int k2 = aint[j + 1 + 1 + (i + 1) * (areaWidth + 2)];
                    int j3 = aint[j + 1 - 1 + (i + 1) * (areaWidth + 2)];
                    int i4 = aint[j + 1 + (i + 1 + 1) * (areaWidth + 2)];

                    if (l1 == ARCHEAN_LAND_ID && k2 == ARCHEAN_LAND_ID && j3 == ARCHEAN_LAND_ID && i4 == ARCHEAN_LAND_ID & nextInt(4) == 0)
                    {
                        aint1[j + i * areaWidth] = CausticBiomes[nextInt(CausticBiomes.length)];;
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
