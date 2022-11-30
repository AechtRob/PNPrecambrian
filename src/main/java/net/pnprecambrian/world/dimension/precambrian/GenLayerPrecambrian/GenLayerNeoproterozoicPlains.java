package net.pnprecambrian.world.dimension.precambrian.GenLayerPrecambrian;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerNeoproterozoicPlains extends GenLayer
{

    public Biome CRYOGENIAN_OCEAN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cryogenian_ocean"));
    public int CRYOGENIAN_OCEAN_ID =  Biome.getIdForBiome(CRYOGENIAN_OCEAN);
    public Biome CRYOGENIAN_BEACH = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cryogenian_beach"));
    public int CRYOGENIAN_BEACH_ID =  Biome.getIdForBiome(CRYOGENIAN_BEACH);

    public Biome CRYOGENIAN_LAND = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cryogenian_desert"));
    public int CRYOGENIAN_LAND_ID =  Biome.getIdForBiome(CRYOGENIAN_LAND);


    public Biome PLAINS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:neoproterozoic_plains"));
    public int PLAINS_ID =  Biome.getIdForBiome(PLAINS);

    public GenLayerNeoproterozoicPlains(long seed, GenLayer genLayer)
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

               if (k == CRYOGENIAN_LAND_ID)
                {
                    int l1 = aint[j + 1 + (i + 1 - 1) * (areaWidth + 2)];
                    int k2 = aint[j + 1 + 1 + (i + 1) * (areaWidth + 2)];
                    int j3 = aint[j + 1 - 1 + (i + 1) * (areaWidth + 2)];
                    int i4 = aint[j + 1 + (i + 1 + 1) * (areaWidth + 2)];

                    if (!isCryogenian(l1) || !isCryogenian(k2) || !isCryogenian(j3) || !isCryogenian(i4))
                    {
                        //if (nextInt(6) == 0 ) {
                            aint1[j + i * areaWidth] = PLAINS_ID;
                        //}
                        //else {
                        //    aint1[j + i * areaWidth] = k;
                        //}
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

    private boolean isCryogenian(int biomeID) {
        if (biomeID == CRYOGENIAN_OCEAN_ID || biomeID == CRYOGENIAN_BEACH_ID || biomeID == CRYOGENIAN_LAND_ID) {
            return true;
        }
        return false;
    }

}
