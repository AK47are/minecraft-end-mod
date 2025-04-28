package team.zhk.end;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import team.zhk.end.block.ModBlocks;
import team.zhk.end.effect.ModStatusEffects;
import team.zhk.end.entity.ModEntities;
import team.zhk.end.event.ModEvents;
import team.zhk.end.event.PlayerDamageCallback;
import team.zhk.end.item.ModItemGroups;
import team.zhk.end.item.ModItems;
import team.zhk.end.potion.ModPotions;
import team.zhk.end.world.gen.ModWorldGeneration;

public class EndMod implements ModInitializer {
	public static final String MOD_ID = "end-mod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModPotions.register();//药水注册
		ModEntities.registerentities();//实体注册
		ModItems.registerItems();//物品注册
		ModItemGroups.registerGroups();//物品栏注册
		ModBlocks.registerModblocks();//方块注册
		ModEvents.registerevents();//事件注册
		ModStatusEffects.registerststeeffects();//效果注册
		PlayerDamageCallback.register();//受伤监听注册
		ModWorldGeneration.generateModWorldGen();//世界注册

		LOGGER.info("Hello Fabric world!");
	}
}