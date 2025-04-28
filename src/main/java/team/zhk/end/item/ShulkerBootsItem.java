package team.zhk.end.item;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import team.zhk.end.effect.ModStatusEffects;

public class ShulkerBootsItem extends ArmorItem {
    public ShulkerBootsItem(ArmorMaterial material, Settings settings) {
        super(material, Type.BOOTS, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, net.minecraft.entity.Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);

        if (!world.isClient && entity instanceof PlayerEntity player) {
            // 检查是否穿上了鞋子
            boolean isWearingBoots = player.getEquippedStack(EquipmentSlot.FEET).isOf(this);

            // 每10游戏刻（0.5秒）检查一次
            if (world.getTime() % 10 == 0) {
                if (isWearingBoots) {
                    // 添加218刻（10.9秒）持续时间的效果，保证在状态时间跳转前更新状态，避免状态时间快速闪动
                    player.addStatusEffect(new StatusEffectInstance(
                            ModStatusEffects.SHULKER_IMMUNITY,
                            218, // 10.9秒持续时间
                            0,
                            true,
                            false
                    ));
                }
                else if (player.hasStatusEffect(ModStatusEffects.SHULKER_IMMUNITY)) {
                    player.removeStatusEffect(ModStatusEffects.SHULKER_IMMUNITY);
                }
            }
        }
    }

    @Override
    public void onCraft(ItemStack stack, World world, PlayerEntity player) {
        super.onCraft(stack, world, player);
        if (!world.isClient) {
            player.addStatusEffect(new StatusEffectInstance(ModStatusEffects.SHULKER_IMMUNITY, 200, 0, true, false));
        }
    }
}