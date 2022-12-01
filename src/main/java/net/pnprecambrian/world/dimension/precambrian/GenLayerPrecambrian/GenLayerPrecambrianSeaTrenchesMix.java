package net.pnprecambrian.world.dimension.precambrian.GenLayerPrecambrian;

import net.lepidodendron.util.EnumBiomeTypePrecambrian;
import net.lepidodendron.world.biome.precambrian.BiomePrecambrian;
import net.minecraft.init.Biomes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;
import net.pnprecambrian.world.biome.precambrian.BiomeArcheanShallowSea;

public class GenLayerPrecambrianSeaTrenchesMix extends GenLayer
{
    private final GenLayer biomePatternGeneratorChain;
    private final GenLayer riverPatternGeneratorChain;

    //Trenches to use:
    public Biome EDIACARAN_TRENCH = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:ediacaran_trench"));
    public int EDIACARAN_TRENCH_ID = Biome.getIdForBiome(EDIACARAN_TRENCH);
    public Biome ARCHEAN_TRENCH = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:archean_trench"));
    public int ARCHEAN_TRENCH_ID = Biome.getIdForBiome(ARCHEAN_TRENCH);
    
    //Biomes to include for trenches:
    public Biome ARCHEAN_SEA = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:archean_shallow_sea"));
    public int ARCHEAN_SEA_ID =  Biome.getIdForBiome(ARCHEAN_SEA);
    public Biome EDIACARAN_HILLS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:ediacaran_extreme_hills"));
    public  int EDIACARAN_HILLS_ID =  Biome.getIdForBiome(EDIACARAN_HILLS);
    public Biome EDIACARAN_FRONDOSE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:ediacaran_frondose_forest"));
    public  int EDIACARAN_FRONDOSE_ID =  Biome.getIdForBiome(EDIACARAN_FRONDOSE);
    public  Biome EDIACARAN_SEA = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:precambrian_sea"));
    public  int EDIACARAN_SEA_ID =  Biome.getIdForBiome(EDIACARAN_SEA);

    public GenLayerPrecambrianSeaTrenchesMix(long p_i2129_1_, GenLayer p_i2129_3_, GenLayer p_i2129_4_)
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
                    //Add the rivers we want:
                    Biome biome = Biome.getBiome(aint[i]);
                    if (biome instanceof BiomePrecambrian) {
                        BiomePrecambrian BiomePrecambrian = (BiomePrecambrian) biome;
                        if (BiomePrecambrian.getBiomeType() == EnumBiomeTypePrecambrian.Ediacaran) {
                            aint2[i] = EDIACARAN_TRENCH_ID;
                        }
                        else if (biome == BiomeArcheanShallowSea.biome) {
                            aint2[i] = ARCHEAN_TRENCH_ID;
                        }
                        else {
                            aint2[i] = aint[i];
                        }
                    }
                    else {
                        aint2[i] = aint[i];
                    }
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
        return (biomeID == ARCHEAN_SEA_ID || biomeID == EDIACARAN_HILLS_ID
            || biomeID == EDIACARAN_SEA_ID || biomeID == EDIACARAN_FRONDOSE_ID);
    }
}
