package com.euphony.flora_fantasy.mixin;

import com.euphony.flora_fantasy.common.goal.AvoidBlockGoal;
import com.euphony.flora_fantasy.common.init.FFBlocks;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.NeutralMob;
import net.minecraft.world.entity.animal.AbstractGolem;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(IronGolem.class)
public abstract class IronGolemMixin extends AbstractGolem implements NeutralMob {
    protected IronGolemMixin(EntityType<? extends AbstractGolem> entityType, Level level) {
        super(entityType, level);
    }

    @Inject(method = "registerGoals", at = @At("TAIL"))
    protected void registerGoals(CallbackInfo ci) {
        this.goalSelector.addGoal(2, new AvoidBlockGoal<>(this, 8, 0.6, 1.0, (pos) -> {
            BlockState state = this.level().getBlockState(pos);
            return state.is(FFBlocks.IRONBANE_FERN.get()) || state.is(FFBlocks.IRONBANE_FROND_FERN.get());
        }));
    }
}
