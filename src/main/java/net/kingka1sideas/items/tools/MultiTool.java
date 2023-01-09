package net.kingka1sideas.items.tools;

import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.util.Pair;
import net.fabricmc.fabric.mixin.content.registry.AxeItemAccessor;
import net.fabricmc.fabric.mixin.content.registry.HoeItemAccessor;
import net.fabricmc.fabric.mixin.content.registry.ShovelItemAccessor;
import net.kingka1sideas.procedures.HasteProcedure;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class MultiTool extends PickaxeItem implements AxeItemAccessor, ShovelItemAccessor, HoeItemAccessor{

        private static final Map<Block, Block> STRIPPED_BLOCKS = AxeItemAccessor.getStrippedBlocks();
        private static final Map<Block, BlockState> PATH_STATES = ShovelItemAccessor.getPathStates();
        private static final Map<Block, Pair<Predicate<ItemUsageContext>, Consumer<ItemUsageContext>>> TILLING_ACTIONS = HoeItemAccessor.getTillingActions();

    public MultiTool(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public float getMiningSpeedMultiplier(ItemStack itemstack, BlockState blockstate) {
            return this.getMaterial().getMiningSpeedMultiplier();
    }

    @Override
    public boolean isSuitableFor(BlockState blockstate) {
        int i = this.getMaterial().getMiningLevel();
        if (i < 3 && blockstate.isIn(BlockTags.NEEDS_DIAMOND_TOOL)) {
            return false;
        } else if (i < 2 && blockstate.isIn(BlockTags.NEEDS_IRON_TOOL)) {
            return false;
        } else {
            return (i < 1 && blockstate.isIn(BlockTags.NEEDS_STONE_TOOL)) || (blockstate.isIn(BlockTags.AXE_MINEABLE) || blockstate.isIn(BlockTags.HOE_MINEABLE)
                        || blockstate.isIn(BlockTags.PICKAXE_MINEABLE) || blockstate.isIn(BlockTags.SHOVEL_MINEABLE));
        }
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity entity, LivingEntity sourceentity) {
        stack.damage(1, sourceentity, i -> i.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
        return true;
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos blockPos = context.getBlockPos();
        PlayerEntity playerEntity = context.getPlayer();
        BlockState blockState = world.getBlockState(blockPos);

        Optional<BlockState> optional = this.getStrippedState(blockState);
        Optional<BlockState> optional2 = Oxidizable.getDecreasedOxidationState(blockState);
        Optional<BlockState> optional3 = Optional.ofNullable((Block) ((BiMap<?, ?>) HoneycombItem.WAXED_TO_UNWAXED_BLOCKS.get()).get(blockState.getBlock())).map((waxedBlock) -> waxedBlock.getStateWithProperties(blockState));
        Optional<BlockState> optional4 = Optional.empty();
        ItemStack itemStack = context.getStack();

        if (optional.isPresent()) {
            world.playSound(playerEntity, blockPos, SoundEvents.ITEM_AXE_STRIP, SoundCategory.BLOCKS, 1.0F, 1.0F);
            optional4 = optional;
        } else if (optional2.isPresent()) {
            world.playSound(playerEntity, blockPos, SoundEvents.ITEM_AXE_SCRAPE, SoundCategory.BLOCKS, 1.0F, 1.0F);
            world.syncWorldEvent(playerEntity, 3005, blockPos, 0);
            optional4 = optional2;
        } else if (optional3.isPresent()) {
            world.playSound(playerEntity, blockPos, SoundEvents.ITEM_AXE_WAX_OFF, SoundCategory.BLOCKS, 1.0F, 1.0F);
            world.syncWorldEvent(playerEntity, 3004, blockPos, 0);
            optional4 = optional3;
        }

        if (optional4.isPresent()) {
            if (playerEntity instanceof ServerPlayerEntity) {
                Criteria.ITEM_USED_ON_BLOCK.trigger((ServerPlayerEntity) playerEntity, blockPos, itemStack);
            }

            world.setBlockState(blockPos, optional4.get(), 11);
            world.emitGameEvent(GameEvent.BLOCK_CHANGE, blockPos, GameEvent.Emitter.of(playerEntity, optional4.get()));
            if (playerEntity != null) {
                itemStack.damage(1, playerEntity, (p) -> p.sendToolBreakStatus(context.getHand()));
            }

                return ActionResult.success(world.isClient);
            } else {
                BlockState blockState2 = (PATH_STATES.get(blockState.getBlock()));
                BlockState blockState3 = null;
                if (blockState2 != null && world.getBlockState(blockPos.up()).isAir()) {
                    world.playSound(playerEntity, blockPos, SoundEvents.ITEM_SHOVEL_FLATTEN, SoundCategory.BLOCKS, 1.0F, 1.0F);
                    blockState3 = blockState2;
                } else if (blockState.getBlock() instanceof CampfireBlock && blockState.get(CampfireBlock.LIT)) {
                    if (!world.isClient()) {
                        world.syncWorldEvent(null, 1009, blockPos, 0);
                    }

                    CampfireBlock.extinguish(context.getPlayer(), world, blockPos, blockState);
                    blockState3 = blockState.with(CampfireBlock.LIT, false);
                }

                if (blockState3 != null) {
                    if (!world.isClient) {
                        world.setBlockState(blockPos, blockState3, 11);
                        world.emitGameEvent(GameEvent.BLOCK_CHANGE, blockPos, GameEvent.Emitter.of(playerEntity, blockState3));
                        if (playerEntity != null) {
                            context.getStack().damage(1, playerEntity, (p) -> p.sendToolBreakStatus(context.getHand()));
                        }
                    }

                    return ActionResult.success(world.isClient);
                } else {
                    Pair<Predicate<ItemUsageContext>, Consumer<ItemUsageContext>> pair = TILLING_ACTIONS.get(world.getBlockState(blockPos).getBlock());
                    if (pair == null) {
                    } else {
                        Predicate<ItemUsageContext> predicate = pair.getFirst();
                        Consumer<ItemUsageContext> consumer = pair.getSecond();
                        if (predicate.test(context)) {
                            world.playSound(playerEntity, blockPos, SoundEvents.ITEM_HOE_TILL, SoundCategory.BLOCKS, 1.0F, 1.0F);
                            if (!world.isClient) {
                                consumer.accept(context);
                                if (playerEntity != null) {
                                    context.getStack().damage(1, playerEntity, (p) -> p.sendToolBreakStatus(context.getHand()));
                                }
                                return ActionResult.success(world.isClient);
                            }
                        } else {
                            return ActionResult.PASS;
                        }
                    }
                }
            }
            return ActionResult.PASS;
    }

    private Optional<BlockState> getStrippedState(BlockState state) {
        return Optional.ofNullable(STRIPPED_BLOCKS.get(state.getBlock())).map((block) -> block.getDefaultState().with(PillarBlock.AXIS, state.get(PillarBlock.AXIS)));
    }

    public void inventoryTick(ItemStack itemstack, World world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(itemstack, world, entity, slot, selected);
        if (selected) {
            HasteProcedure.execute(ImmutableMap.builder().put("entity", entity).build());
        }
    }
}
