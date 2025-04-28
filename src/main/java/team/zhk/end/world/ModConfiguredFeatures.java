package team.zhk.end.world;

import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import team.zhk.end.EndMod;
import team.zhk.end.block.ModBlocks;

import java.util.List;

public class ModConfiguredFeatures {
    //虚空水晶矿物生成
    public static final RegistryKey<ConfiguredFeature<?,?>> VOID_BEACON_ORE_KEY = registerKey("void_beacon_ore");

    public static void boostrap(Registerable<ConfiguredFeature<?,?>> context) {
        // 暂时注释虚空水晶矿生成配置

        RuleTest endPlace = new BlockMatchRuleTest(Blocks.END_STONE);
        List<OreFeatureConfig.Target> end =
                List.of(OreFeatureConfig.createTarget(endPlace, ModBlocks.VOID_BEACON_ORE.getDefaultState()));
        register(context, VOID_BEACON_ORE_KEY, Feature.ORE, new OreFeatureConfig(end, 6));

    }


    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(EndMod.MOD_ID, name));
    }

    private static <Fc extends FeatureConfig, F extends Feature<Fc>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, Fc configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
