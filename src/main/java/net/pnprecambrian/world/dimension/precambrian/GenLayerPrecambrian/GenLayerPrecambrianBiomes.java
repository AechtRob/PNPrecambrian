package net.pnprecambrian.world.dimension.precambrian.GenLayerPrecambrian;

//import net.lepidodendron.world.biome.devonian.
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerPrecambrianBiomes extends GenLayer {

    public Biome PRECAMBRIAN_OCEAN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:precambrian_sea"));
    public  int PRECAMBRIAN_OCEAN_ID =  Biome.getIdForBiome(PRECAMBRIAN_OCEAN);
    public  Biome HADEAN_LAND = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:precambrian_biome"));
    public  int HADEAN_LAND_ID =  Biome.getIdForBiome(HADEAN_LAND);
    public  Biome PALEOPROTEROZOIC_LAND = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:paleoproterozoic_regolith"));
    public  int PALEOPROTEROZOIC_LAND_ID =  Biome.getIdForBiome(PALEOPROTEROZOIC_LAND);
    public  Biome MESOPROTEROZOIC_SEA = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:mesoproterozoic_carpet"));
    public  int MESOPROTEROZOIC_SEA_ID =  Biome.getIdForBiome(MESOPROTEROZOIC_SEA);

    private final int PrecambrianBiomes[] = new int[] {
            PRECAMBRIAN_OCEAN_ID, //default Ediacaran
            HADEAN_LAND_ID, //default Hadean
            PALEOPROTEROZOIC_LAND_ID, //default Paleoproterozoic
            MESOPROTEROZOIC_SEA_ID //default Mesoproterozoic
    };

    public GenLayerPrecambrianBiomes(long seed) {
        super(seed);
    }

    @Override
    public int[] getInts(int x, int z, int width, int height) {
        int dest[] = IntCache.getIntCache(width * height);
        for (int dz = 0; dz < height; dz++) {
            for (int dx = 0; dx < width; dx++) {
                initChunkSeed(dx + x, dz + z);
                dest[dx + dz * width] = PrecambrianBiomes[nextInt(PrecambrianBiomes.length)];
            }
        }
        return dest;
    }
}