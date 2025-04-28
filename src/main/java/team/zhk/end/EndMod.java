package team.zhk.end;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EndMod implements ModInitializer {
	public static final String MOD_ID = "end-mod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("模组正在初始化...");
		LOGGER.info("模组初始化完成！");
	}
}