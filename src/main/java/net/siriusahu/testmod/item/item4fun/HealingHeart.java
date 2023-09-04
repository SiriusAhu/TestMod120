package net.siriusahu.testmod.item.item4fun;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class HealingHeart extends Item {
    public HealingHeart(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        outputMessage(user);
        // Give the player a potion effect: continuous healing level 10 for 1 second
        user.addStatusEffect(new net.minecraft.entity.effect.StatusEffectInstance(
                net.minecraft.entity.effect.StatusEffects.REGENERATION, 20, 4));
        // Cool down for 3 seconds
        user.getItemCooldownManager().set(this, 60);

        // Durability - 1
        user.getStackInHand(hand).damage(1, user, playerEntity -> playerEntity.sendToolBreakStatus(playerEntity.getActiveHand()));

        return super.use(world, user, hand);
    }

    private void outputMessage(PlayerEntity user){
        user.sendMessage(Text.translatable("item.testmod.healing_heart.use"), false);
    }
}
