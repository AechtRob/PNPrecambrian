package net.pnprecambrian.world.dimension.precambrian.GenLayerPrecambrian;

import net.minecraft.init.Biomes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerPrecambrianRiftMix extends GenLayer
{
    private final GenLayer biomePatternGeneratorChain;
    private final GenLayer riverPatternGeneratorChain;

    //Trenches to use:
    public Biome PROTEROZOIC_RIFT = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:proterozoic_rift"));
    public int PROTEROZOIC_RIFT_ID = Biome.getIdForBiome(PROTEROZOIC_RIFT);

    //Biomes to include for trenches:
    public Biome PROTEROZOIC_LAND = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:proterozoic_hills"));
    public int PROTEROZOIC_LAND_ID =  Biome.getIdForBiome(PROTEROZOIC_LAND);


    public GenLayerPrecambrianRiftMix(long p_i2129_1_, GenLayer p_i2129_3_, GenLayer p_i2129_4_)
    {
        super(p_i2129_1_);
        this.biomePatternGeneratorChain = p_i2129_3_;
        this.riverPatternGeneratorChain = p_i2129_4_;
    }

    public void initWorldGenSeed(long seed)
    {
        this.biomePatternGeneratorChain.initWorldGenSeed(seed);
        this.riverPatternGeneratorChain.initWorldGenSeed(seed);
        super.initWorldGenSeed(seed);
    }

    public int[] getInts(int areaX, int areaY, int areaWidth, int areaHeight)
    {
        int[] aint = this.biomePatternGeneratorChain.getInts(areaX, areaY, areaWidth, areaHeight);
        int[] aint1 = this.riverPatternGeneratorChain.getInts(areaX, areaY, areaWidth, areaHeight);
        int[] aint2 = IntCache.getIntCache(areaWidth * areaHeight);

        for (int i = 0; i < areaWidth * areaHeight; ++i)
        {
            if (aint1[i] == Biome.getIdForBiome(Biomes.RIVER))
            {
                //Exclude rivers here:
                if (!hasTrench(aint[i]))
                {
                    aint2[i] = aint[i];
                }
                else {
                    aint2[i] = PROTEROZOIC_RIFT_ID;
                }
            }
            else
            {
                aint2[i] = aint[i];
            }

        }

        return aint2;
    }
    
    public boolean hasTrench(int biomeID) {
        return (biomeID == PROTEROZOIC_LAND_ID);
    }
}
