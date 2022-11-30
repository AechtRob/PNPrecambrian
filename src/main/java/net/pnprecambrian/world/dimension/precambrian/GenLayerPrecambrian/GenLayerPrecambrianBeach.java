package net.pnprecambrian.world.dimension.precambrian.GenLayerPrecambrian;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerPrecambrianBeach extends GenLayer
{

    public Biome PALEOPROTEROZOIC_BEACH = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:paleoproterozoic_beach"));
    public int PALEOPROTEROZOIC_BEACH_ID =  Biome.getIdForBiome(PALEOPROTEROZOIC_BEACH);
    public Biome MESOPROTEROZOIC_BEACH = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:mesoproterozoic_beach"));
    public int MESOPROTEROZOIC_BEACH_ID =  Biome.getIdForBiome(MESOPROTEROZOIC_BEACH);
    public Biome CRYOGENIAN_BEACH = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cryogenian_beach"));
    public int CRYOGENIAN_BEACH_ID =  Biome.getIdForBiome(CRYOGENIAN_BEACH);

    public Biome PALEOPROTEROZOIC_OCEAN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:paleoproterozoic_shallows"));
    public int PALEOPROTEROZOIC_OCEAN_ID =  Biome.getIdForBiome(PALEOPROTEROZOIC_OCEAN);
    public Biome MESOPROTEROZOIC_OCEAN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:mesoproterozoic_carpet"));
    public int MESOPROTEROZOIC_OCEAN_ID =  Biome.getIdForBiome(MESOPROTEROZOIC_OCEAN);
    public Biome CRYOGENIAN_OCEAN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cryogenian_ocean"));
    public int CRYOGENIAN_OCEAN_ID =  Biome.getIdForBiome(CRYOGENIAN_OCEAN);

    public GenLayerPrecambrianBeach(long seed, GenLayer genLayer)
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

                    if (!isOceanOrBeach(l1) || !isOceanOrBeach(k2) || !isOceanOrBeach(j3) || !isOceanOrBeach(i4))
                    {
                        if (k == PALEOPROTEROZOIC_OCEAN_ID) {
                            aint1[j + i * areaWidth] = PALEOPROTEROZOIC_BEACH_ID;
                        }
                        else if (k == MESOPROTEROZOIC_OCEAN_ID) {
                            aint1[j + i * areaWidth] = MESOPROTEROZOIC_BEACH_ID;
                        }
                        else if (k == CRYOGENIAN_OCEAN_ID) {
                            aint1[j + i * areaWidth] = CRYOGENIAN_BEACH_ID;
                        }
                        else {
                            aint1[j + i * areaWidth] = k;
                        }
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
                || biomeID == CRYOGENIAN_OCEAN_ID) {
            return true;
        }
        return false;
    }

    private boolean isOceanOrBeach(int biomeID) {
        return (isOcean(biomeID) || isBeach(biomeID));
    }

    private boolean isBeach(int biomeID) {
        if (biomeID == PALEOPROTEROZOIC_BEACH_ID || biomeID == MESOPROTEROZOIC_BEACH_ID
                || biomeID == CRYOGENIAN_BEACH_ID) {
            return true;
        }
        return false;
    }

}
