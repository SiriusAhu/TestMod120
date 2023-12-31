package net.siriusahu.testmod.item.custom;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    // Check vanilla `FoodComponents` by pressing `Ctrl` + left click `FoodComponents`, then do it again after page jump
    public static final FoodComponent BLACK_BREAD = new FoodComponent.Builder()
            .hunger(5) // 5 hunger points
            .saturationModifier(0.6f) // 60% saturation
            .statusEffect(new StatusEffectInstance(StatusEffects.SATURATION, 40), 0.75f) // 75% chance to get saturation for 2 seconds
            .build();

    // green_apple: a copy of vanilla apple, but have 50% chance to get poison for 4 seconds
    public static final FoodComponent GREEN_APPLE = new FoodComponent.Builder()
            .hunger(4)
            .saturationModifier(0.3f)
            .statusEffect(new StatusEffectInstance(StatusEffects.POISON, 60, 0), 0.5f)
            .build();
}
