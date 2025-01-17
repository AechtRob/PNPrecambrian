package net.pnprecambrian.world.dimension.precambrian.GenLayerPrecambrian;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerPrecambrianArcheanCaustic extends GenLayer {

    public Biome CAUSTIC = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:archean_caustic"));
    public int CAUSTIC_ID =  Biome.getIdForBiome(CAUSTIC);
    public Biome ARCHEAN_WINDSWEPT = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:archean_windswept"));
    public int ARCHEAN_WINDSWEPT_ID =  Biome.getIdForBiome(ARCHEAN_WINDSWEPT);

    public Biome PRECAMBRIAN_LAND = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:proterozoic_hills"));
    public int PRECAMBRIAN_LAND_ID =  Biome.getIdForBiome(PRECAMBRIAN_LAND);

    public GenLayerPrecambrianArcheanCaustic(long seed, GenLayer genlayer) {
        super(seed);
        this.parent = genlayer;
    }

    private final int CausticBiomes[] = new int[] {
            CAUSTIC_ID,
            ARCHEAN_WINDSWEPT_ID
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

                if (k == PRECAMBRIAN_LAND_ID)
                {
                    int l1 = aint[j + 1 + (i + 1 - 1) * (areaWidth + 2)];
                    int k2 = aint[j + 1 + 1 + (i + 1) * (areaWidth + 2)];
                    int j3 = aint[j + 1 - 1 + (i + 1) * (areaWidth + 2)];
                    int i4 = aint[j + 1 + (i + 1 + 1) * (areaWidth + 2)];

                    if (l1 == PRECAMBRIAN_LAND_ID && k2 == PRECAMBRIAN_LAND_ID && j3 == PRECAMBRIAN_LAND_ID && i4 == PRECAMBRIAN_LAND_ID & nextInt(4) == 0)
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
