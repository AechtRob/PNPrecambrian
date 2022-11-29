package net.pnprecambrian.world.dimension.precambrian.GenLayerPrecambrian;

import net.lepidodendron.util.EnumBiomeTypePermian;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;
import net.pnprecambrian.world.biome.precambrian.BiomePaleoproterozoicRegolith;

public class GenLayerDiversifyPrecambrian extends GenLayer {

    public  Biome PALEOPROTEROZOIC_REGOLITH = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:paleoproterozoic_regolith"));
    public  int PALEOPROTEROZOIC_REGOLITH_ID =  Biome.getIdForBiome(PALEOPROTEROZOIC_REGOLITH);
    public  Biome PALEOPROTEROZOIC_SHALLOWS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:paleoproterozoic_shallows"));
    public  int PALEOPROTEROZOIC_SHALLOWS_ID =  Biome.getIdForBiome(PALEOPROTEROZOIC_SHALLOWS);

     private final int PaleoproterozoicBiomes[] = new int[] {
             PALEOPROTEROZOIC_REGOLITH_ID,
             PALEOPROTEROZOIC_REGOLITH_ID,
             PALEOPROTEROZOIC_SHALLOWS_ID
    };

    public GenLayerDiversifyPrecambrian(long seed, GenLayer genlayer) {
        super(seed);
        this.parent = genlayer;
    }

    @Override
    public int[] getInts(int x, int z, int width, int height) {
        return diversify(x, z, width, height);
    }

    private int[] diversify(int x, int z, int width, int height) {
        int input[] = this.parent.getInts(x, z, width, height);
        int output[] = IntCache.getIntCache(width * height);
        EnumBiomeTypePermian type;
        for (int zOut = 0; zOut < height; zOut++) {
            for (int xOut = 0; xOut < width; xOut++) {
                int i = xOut + zOut * width;
                int center = input[i];
                initChunkSeed(xOut + x, zOut + z);
                if (nextInt(2) == 0) {
                    if (Biome.getBiome(center) == BiomePaleoproterozoicRegolith.biome)
                        output[i] = PaleoproterozoicBiomes[nextInt(PaleoproterozoicBiomes.length)];

                    else output[i] = center;
                } else output[i] = center;
            }
        }
        return output;
    }

}