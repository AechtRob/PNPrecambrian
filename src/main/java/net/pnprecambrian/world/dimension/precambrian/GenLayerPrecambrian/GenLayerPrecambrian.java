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
        biomes = new GenLayerArcheanContinents(5208, biomes);

        biomes = new GenLayerZoom(1001L, biomes);

        biomes = new GenLayerPrecambrianArcheanCaustic(740L, biomes);
        biomes = new GenLayerNeoproterozoicPlains(1918L, biomes);
        biomes = new GenLayerStromatolitePavement(1759L, biomes);
        biomes = new GenLayerReef(1767L, biomes);
        biomes = new GenLayerZoom(1003L, biomes);

        biomes = new GenLayerSmooth(700L, biomes);
        biomes = new GenLayerSmooth(701L, biomes);

        biomes = new GenLayerArcheanTidePools(1002L, biomes);

        biomes = new GenLayerZoom(1004L, biomes);
        biomes = new GenLayerSmooth(703L, biomes);
        biomes = new GenLayerFuzzyZoom(1000L, biomes);

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

        //Build and superimpose trenches:
        GenLayer genlayercreek = new GenLayerRiverInit(100L, biomes);
        GenLayer genlayercreek2 = GenLayerZoom.magnify(1000L, genlayercreek, 1);
        GenLayer genlayercreek3 = GenLayerZoom.magnify(1000L, genlayercreek2, 2);
        GenLayer genlayercreek4 = GenLayerZoom.magnify(1000L, genlayercreek3, 2);
        GenLayer genlayercreek5 = GenLayerZoom.magnify(1000L, genlayercreek4, 2);
        GenLayer genlayercreek6 = new GenLayerRiver(1L, genlayercreek5);
        GenLayer genlayercreek7 = new GenLayerSmooth(1000L, genlayercreek6);
        GenLayer genlayertrenchfinal = new GenLayerPrecambrianSeaTrenchesMix(100L, biomes, genlayercreek7);

        GenLayer genlayerrift = new GenLayerRiverInit(200L, biomes);
        GenLayer genlayerrift2 = GenLayerZoom.magnify(2000L, genlayerrift, 1);
        GenLayer genlayerrift3 = GenLayerZoom.magnify(2000L, genlayerrift2, 2);
        GenLayer genlayerrift4 = GenLayerZoom.magnify(2000L, genlayerrift3, 2);
        GenLayer genlayerrift5 = GenLayerZoom.magnify(2000L, genlayerrift4, 2);
        GenLayer genlayerrift6 = GenLayerZoom.magnify(2000L, genlayerrift5, 2);
        GenLayer genlayerrift7 = new GenLayerRiver(2L, genlayerrift6);
        GenLayer genlayerrift8 = new GenLayerSmooth(2000L, genlayerrift7);
        GenLayer genlayerrift9 = new GenLayerZoom(2076L, genlayerrift8);
        GenLayer genlayerrift10 = new GenLayerZoom(3076L, genlayerrift9);
        GenLayer genlayerrift11 = new GenLayerZoom(4076L, genlayerrift10);
        GenLayer genlayerriftfinal = new GenLayerPrecambrianRiftMix(200L, genlayertrenchfinal, genlayerrift11);

        GenLayer genlayervoronoizoom = new GenLayerVoronoiZoom(10L, genlayerriftfinal);

        genlayerriftfinal.initWorldGenSeed(seed);
        genlayervoronoizoom.initWorldGenSeed(seed);
        biomes.initWorldGenSeed(seed);

        genlayervoronoizoom.initWorldGenSeed(seed);
        return (new GenLayer[] { genlayerriftfinal, genlayervoronoizoom, genlayerriftfinal });

    }

}