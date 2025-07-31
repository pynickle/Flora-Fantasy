package com.euphony.flora_fantasy.common.init;

import com.euphony.flora_fantasy.FloraFantasy;
import com.euphony.flora_fantasy.common.block.*;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RedstoneLampBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class FFBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(FloraFantasy.MOD_ID, Registries.BLOCK);

    public static final RegistrySupplier<LuminBerryBushBlock> LUMIN_BERRY_BUSH = BLOCKS.register("lumin_berry_bush",
            () -> new LuminBerryBushBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SWEET_BERRY_BUSH)
                    .lightLevel(state -> {
                        if(state.getValue(LuminBerryBushBlock.AGE) == 1) {
                            return 7;
                        }
                        return 0;
                    })
                    .offsetType(BlockBehaviour.OffsetType.XZ)));

    public static final RegistrySupplier<IronbaneFernBlock> IRONBANE_FERN = BLOCKS.register("ironbane_fern",
            () -> new IronbaneFernBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FERN).randomTicks().offsetType(BlockBehaviour.OffsetType.XZ)));

    public static final RegistrySupplier<IronbaneFrondFernBlock> IRONBANE_FROND_FERN = BLOCKS.register("ironbane_frond_fern",
            () -> new IronbaneFrondFernBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FERN).offsetType(BlockBehaviour.OffsetType.XZ)));

    public static final RegistrySupplier<SaltspudBlock> SALTSPUD = BLOCKS.register("saltspud",
            () -> new SaltspudBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.POTATOES)));

    public static final RegistrySupplier<RedstoneLampBlock> SALT_CRYSTAL_LAMP = BLOCKS.register("salt_crystal_lamp",
            () -> new RedstoneLampBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_LAMP)));

    public static final RegistrySupplier<SnapBeanBlock> SNAP_BEAN = BLOCKS.register("snap_bean",
            () -> new SnapBeanBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BEETROOTS)));
}
