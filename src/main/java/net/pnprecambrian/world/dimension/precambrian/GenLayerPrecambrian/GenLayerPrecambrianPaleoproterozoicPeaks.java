package net.pnprecambrian.world.dimension.precambrian.GenLayerPrecambrian;

import net.lepidodendron.util.EnumBiomeTypePermian;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;
import net.pnprecambrian.world.biome.precambrian.BiomePaleoproterozoicFrigidWastes;

public class GenLayerPrecambrianPaleoproterozoicPeaks extends GenLayer {

    public Biome PRECAMBRIAN_FRIGID = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:paleoproterozoic_frigid"));
    public  int PRECAMBRIAN_FRIGID_ID =  Biome.getIdForBiome(PRECAMBRIAN_FRIGID);
    public Biome PRECAMBRIAN_FRIGID_PEAKS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:paleoproterozoic_frigid_peaks"));
    public  int PRECAMBRIAN_FRIGID_PEAKS_ID =  Biome.getIdForBiome(PRECAMBRIAN_FRIGID_PEAKS);

    public GenLayerPrecambrianPaleoproterozoicPeaks(long seed, GenLayer genlayer) {
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
                if (nextInt(9) == 0) {
                    if (Biome.getBiome(center) == BiomePaleoproterozoicFrigidWastes.biome)
                        output[i] = PRECAMBRIAN_FRIGID_PEAKS_ID;
                    else output[i] = center;
                } else output[i] = center;
            }
        }
        return output;
    }

}
