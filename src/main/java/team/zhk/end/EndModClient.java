package team.zhk.end;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.util.Identifier;
import team.zhk.end.entity.GaleArrowEntity;
import team.zhk.end.entity.ModEntities;

public class EndModClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        //末影弓箭实体渲染
        EntityRendererRegistry.register(
                ModEntities.GALE_ARROW,
                (context) -> new ProjectileEntityRenderer<GaleArrowEntity>(context) {
                    @Override
                    public Identifier getTexture(GaleArrowEntity entity) {
                        return new Identifier("end-mod", "textures/entity/gale_arrow.png");
                    }
                }
        );
    }
}
