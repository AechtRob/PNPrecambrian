package net.pnprecambrian.world.dimension.precambrian.GenLayerPrecambrian;

import net.lepidodendron.LepidodendronConfig;
import net.minecraft.world.WorldType;
import net.minecraft.world.gen.layer.*;

public class GenLayerPrecambrian {

    protected GenLayer parent;

    public static GenLayer[] initializeAllBiomeGenerators(long seed, WorldType worldType, String options) {

        GenLayer biomes = new GenLayerPrecambrianBiomes(1L);
        biomes = new GenLayerFuzzyZoom(2000L, biomes);
        if (!LepidodendronConfig.doShrinkBiomes) {
            biomes = new GenLayerZoom(2001L, biomes);
        }
        //General diversify:
        biomes = new GenLayerDiversifyPrecambrian(6789L, biomes);
        biomes = new GenLayerZoom(1000L, biomes);
        biomes = new GenLayerSmooth(700L, biomes);
        //General diversify:
        biomes = new GenLayerDiversifyPrecambrian(789L, biomes);
        biomes = new GenLayerPrecambrianHadeanMolten(700L, biomes);
        biomes = new GenLayerZoom(1001L, biomes);
        //biomes = new GenLayerDiversifyPermian(1002L, biomes);
        //biomes = new GenLayerPermianDeepOcean(1100L, biomes);
        //biomes = new GenLayerPermianShallowOcean(1300L, biomes);
        //biomes = new GenLayerPermianTreefernCopse(209L, biomes);
        //biomes = new GenLayerPermianSpongeReef(1975L, biomes);
        biomes = new GenLayerPrecambrianArcheanCaustic(740L, biomes);
        biomes = new GenLayerNeoproterozoicPlains(1918L, biomes);
        biomes = new GenLayerZoom(1003L, biomes);
        //biomes = new GenLayerPermianMountainEdge(2L, biomes);
        biomes = new GenLayerSmooth(700L, biomes);
        biomes = new GenLayerSmooth(701L, biomes);

        biomes = new GenLayerArcheanTidePools(1002L, biomes);

        biomes = new GenLayerZoom(1004L, biomes);
        biomes = new GenLayerSmooth(703L, biomes);
        biomes = new GenLayerFuzzyZoom(1000L, biomes);
        //biomes = new GenLayerPermianBeach(1050L, biomes);
        //biomes = new GenLayerPermianFloodBasaltEdge(3L, biomes);
        //biomes = new GenLayerPermianCliff(1080L, biomes);

        biomes = new GenLayerSmooth(705L, biomes);
        biomes = new GenLayerFuzzyZoom(1001L, biomes);
        //Add beaches and rivers between biomes etc:
        //N/A
        biomes = new GenLayerPrecambrianBeach(321L, biomes);

        biomes = new GenLayerPrecambrianHadeanLavaEdge(1056L, biomes);
        biomes = new GenLayerSmooth(706L, biomes);
        biomes = new GenLayerFuzzyZoom(1002L, biomes);
        //Add extra rivers between biomes:
        //N/A
        biomes = new GenLayerPrecambrianBeach(322L, biomes);

        biomes = new GenLayerZoom(1006L, biomes);
        biomes = new GenLayerPrecambrianHadeanLavaEdge(1057L, biomes);
        GenLayer genlayervoronoizoom = new GenLayerVoronoiZoom(10L, biomes);
        biomes.initWorldGenSeed(seed);
        genlayervoronoizoom.initWorldGenSeed(seed);
        return (new GenLayer[] { biomes, genlayervoronoizoom });
    }

}