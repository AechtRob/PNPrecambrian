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
    public  Biome PROTEROZOIC_LAND = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:proterozoic_hills"));
    public  int PROTEROZOIC_LAND_ID =  Biome.getIdForBiome(PROTEROZOIC_LAND);
    public  Biome ARCHEAN_LAND = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:archean_hills"));
    public  int ARCHEAN_LAND_ID =  Biome.getIdForBiome(ARCHEAN_LAND);
    public  Biome ARCHEAN_SEA = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:archean_shallow_sea"));
    public  int ARCHEAN_SEA_ID =  Biome.getIdForBiome(ARCHEAN_SEA);
    public  Biome CRYOGENIAN_DESERT = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cryogenian_desert"));
    public  int CRYOGENIAN_DESERT_ID =  Biome.getIdForBiome(CRYOGENIAN_DESERT);

    private final int PrecambrianBiomes[] = new int[] {
            PRECAMBRIAN_OCEAN_ID, //default Ediacaran
            HADEAN_LAND_ID, //default Hadean
            PALEOPROTEROZOIC_LAND_ID, //default Paleoproterozoic
            MESOPROTEROZOIC_SEA_ID, //default Mesoproterozoic
            PROTEROZOIC_LAND_ID, //general Proterozoic
            ARCHEAN_LAND_ID, //general Archean land
            ARCHEAN_SEA_ID, //general Archean
            CRYOGENIAN_DESERT_ID //general Neoproterozoic (excluding Ediacaran)
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