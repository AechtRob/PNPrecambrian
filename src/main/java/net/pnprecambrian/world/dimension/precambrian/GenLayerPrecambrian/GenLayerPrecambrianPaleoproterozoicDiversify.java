package net.pnprecambrian.world.dimension.precambrian.GenLayerPrecambrian;

import net.lepidodendron.util.EnumBiomeTypePermian;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;
import net.pnprecambrian.world.biome.precambrian.BiomePaleoproterozoicRegolith;

public class GenLayerPrecambrianPaleoproterozoicDiversify extends GenLayer {

    public Biome PRECAMBRIAN_REGOLITH = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:paleoproterozoic_regolith"));
    public  int PRECAMBRIAN_REGOLITH_ID =  Biome.getIdForBiome(PRECAMBRIAN_REGOLITH);
    public Biome PRECAMBRIAN_FRIGID = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:paleoproterozoic_frigid"));
    public  int PRECAMBRIAN_FRIGID_ID =  Biome.getIdForBiome(PRECAMBRIAN_FRIGID);

    public GenLayerPrecambrianPaleoproterozoicDiversify(long seed, GenLayer genlayer) {
        super(seed);
        this.parent = genlayer;
    }

    private final int PaleoproterozoicBiomes[] = new int[] {
            PRECAMBRIAN_REGOLITH_ID,
            PRECAMBRIAN_FRIGID_ID
    };

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
                if (nextInt(12) == 0) {
                    if (Biome.getBiome(center) == BiomePaleoproterozoicRegolith.biome)
                        output[i] = PaleoproterozoicBiomes[nextInt(PaleoproterozoicBiomes.length)];
                    else output[i] = center;
                } else output[i] = center;
            }
        }
        return output;
    }

}
