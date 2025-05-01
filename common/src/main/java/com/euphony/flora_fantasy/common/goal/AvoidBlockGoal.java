package com.euphony.flora_fantasy.common.goal;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.util.DefaultRandomPos;
import net.minecraft.world.level.pathfinder.Path;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;
import java.util.Optional;
import java.util.function.Predicate;

public class AvoidBlockGoal<T extends LivingEntity> extends Goal {
    protected final PathfinderMob mob;
    private final double walkSpeedModifier;
    private final double sprintSpeedModifier;
    protected BlockPos toAvoid;
    protected final float maxDist;
    @Nullable
    protected Path path;
    protected final PathNavigation pathNav;
    protected final Predicate<BlockPos> posFilter;

    public AvoidBlockGoal(PathfinderMob pathfinderMob, float f, double d, double e, Predicate<BlockPos> posFilter) {
        this.mob = pathfinderMob;
        this.maxDist = f;
        this.walkSpeedModifier = d;
        this.sprintSpeedModifier = e;
        this.posFilter = posFilter;
        this.pathNav = pathfinderMob.getNavigation();
        this.setFlags(EnumSet.of(Flag.MOVE));
    }

    public boolean canUse() {
        Optional<BlockPos> blockPos = BlockPos.findClosestMatch(this.mob.blockPosition(), 8, 4, posFilter);
        if (blockPos.isPresent()) {
            Vec3 vec3 = DefaultRandomPos.getPosAway(mob, 16, 7, blockPos.get().getCenter());
            if (vec3 == null) {
                return false;
            } else if (this.mob.distanceToSqr(vec3.x, vec3.y, vec3.z) < this.mob.distanceToSqr(blockPos.get().getCenter())) {
                return false;
            } else {
                this.path = this.pathNav.createPath(vec3.x, vec3.y, vec3.z, 0);
                if (this.path != null) {
                    this.toAvoid = blockPos.get();
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    public boolean canContinueToUse() {
        return !this.pathNav.isDone();
    }

    public void start() {
        this.pathNav.moveTo(this.path, this.walkSpeedModifier);
    }

    public void stop() {
        this.toAvoid = null;
    }

    public void tick() {
        if (this.mob.distanceToSqr(this.toAvoid.getCenter()) < (double)49.0F) {
            this.mob.getNavigation().setSpeedModifier(this.sprintSpeedModifier);
        } else {
            this.mob.getNavigation().setSpeedModifier(this.walkSpeedModifier);
        }

    }
}