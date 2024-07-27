package firenh.profundis.util;

import com.mojang.datafixers.util.Pair;

import firenh.profundis.Profundis;
import firenh.profundis.gen.ProfundisBiomeKeys;
// import firenh.profundis.biomes.ProfundisBiomeKeys;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;
import net.minecraft.world.biome.source.util.MultiNoiseUtil.NoiseHypercube;
import net.minecraft.world.biome.source.util.MultiNoiseUtil.ParameterRange;

public class VanillaBiomeParametersHelper {
    public static void writeCaveBiomeParameters(
            java.util.function.Consumer<Pair<NoiseHypercube, RegistryKey<Biome>>> parameters, ParameterRange temperature,
            ParameterRange humidity, ParameterRange continentalness, ParameterRange erosion,
            ParameterRange depth, ParameterRange weirdness, float offset, RegistryKey<Biome> biome) {
        boolean bl = false;

        if (biome.getValue().equals(ProfundisBiomeKeys.FROZEN_CAVES.getValue()) && Profundis.getConfig().generateFrozenCaves) bl = true;
        else if (biome.getValue().equals(ProfundisBiomeKeys.MUSHROOM_CAVES.getValue()) && Profundis.getConfig().generateMushroomCaves) bl = true;
        else if (biome.getValue().equals(ProfundisBiomeKeys.MOLTEN_CAVES.getValue()) && Profundis.getConfig().generateMoltenCaves) bl = true;
        else if (biome.getValue().equals(ProfundisBiomeKeys.AMETHYST_CAVES.getValue()) && Profundis.getConfig().generateAmethystCaves) bl = true;
        else if (biome.getValue().equals(ProfundisBiomeKeys.BLACK_CAVES.getValue()) && Profundis.getConfig().generateBlackCaves) bl = true;
        else if (biome.getValue().equals(ProfundisBiomeKeys.ARID_CAVES.getValue()) && Profundis.getConfig().generateAridCaves) bl = true;
        else if (biome.getValue().equals(ProfundisBiomeKeys.FLORAL_LUSH_CAVES.getValue()) && Profundis.getConfig().generateFloralLushCaves) bl = true;
        else if (biome.getValue().equals(ProfundisBiomeKeys.SPARSE_LUSH_CAVES.getValue()) && Profundis.getConfig().generateSparseLushCaves) bl = true;
        else if (biome.getValue().equals(ProfundisBiomeKeys.WHITE_CAVES.getValue()) && Profundis.getConfig().generateWhiteCaves) bl = true;
        else if (biome.getValue().equals(ProfundisBiomeKeys.PAINTED_CAVES.getValue()) && Profundis.getConfig().generatePaintedCaves) bl = true;




        if (bl) {
            parameters.accept(Pair.of(MultiNoiseUtil.createNoiseHypercube(temperature, humidity, continentalness, erosion, depth, weirdness, offset), biome));
        }
    }
}
