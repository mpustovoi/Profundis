package firenh.profundis.util;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import com.google.gson.GsonBuilder;

import firenh.profundis.Profundis;
import firenh.profundis.gen.ProfundisCaveBiomes;

public class Config {
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    //Config Default Values

    public String CONFIG_VERSION_DO_NOT_TOUCH_PLS = Profundis.VERSION.toString();

    public boolean logWhenLoaded = true;
    public String comment1 = "Enable or disable any cave biome individually.";
    public boolean generateFrozenCaves = true;
    public boolean generateMushroomCaves = true;
    public boolean generateMoltenCaves = true;
    public boolean generateAmethystCaves = true;
    public boolean generateBlackCaves = true;
    public boolean generateAridCaves = true;
    public boolean generateFloralLushCaves = true;
    public boolean generateSparseLushCaves = true;
    public boolean generateWhiteCaves = true;
    public boolean generatePaintedCaves = true;
    public Debug debug = new Debug();

    // public Advanced advancedSettings = new Advanced();
    
    //~~~~~~~~

    public static class Advanced {
        public List<ProfundisCaveBiomes.CaveBiome> caveBiomes = new ArrayList<>();

        public Advanced() {
            caveBiomes.addAll(ProfundisCaveBiomes.DEFAULT_CAVE_BIOMES);
        }
    }

    public static class Debug {
        // public boolean enableMultinoiseCommand = false;
    }

    public static Config init() {
        Config config = null;

        try {
            Path configPath = Paths.get("", "config", "profundis.json");

            if (Files.exists(configPath)) {
                config = gson.fromJson(
                    new FileReader(configPath.toFile()),
                    Config.class
                );

                if (!config.CONFIG_VERSION_DO_NOT_TOUCH_PLS.equals(Profundis.VERSION.toString())) {
                    config.CONFIG_VERSION_DO_NOT_TOUCH_PLS = Profundis.VERSION.toString();

                    BufferedWriter writer = new BufferedWriter(
                        new FileWriter(configPath.toFile())
                    );

                    writer.write(gson.toJson(config));
                    writer.close();
                }

            } else {
                config = new Config();
                Paths.get("", "config").toFile().mkdirs();

                BufferedWriter writer = new BufferedWriter(
                    new FileWriter(configPath.toFile())
                );

                writer.write(gson.toJson(config));
                writer.close();
            }


        } catch (IOException exception) {
            exception.printStackTrace();
        }

        return config;
    }
}
