package net.mcreator.sonicadventures.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;


import net.mcreator.sonicadventures.init.SonicadventuresModItems;
import net.mcreator.sonicadventures.SonicadventuresMod;

import net.mcreator.sonicadventures.entity.ChaoEntity;
import net.mcreator.sonicadventures.ChaoType;
import net.mcreator.sonicadventures.ChaoSubType;
import net.mcreator.sonicadventures.ChaoColor;
import javax.annotation.Nullable;


public class TestingCostumeProcedure {
	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		ChaoEntity chaoentity = (ChaoEntity) entity;
		
		if (entity == null || sourceentity == null)
			return;
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == SonicadventuresModItems.NEUTRAL_FRUIT.get()) {
			if (chaoentity.getChaoType() != ChaoType.NORMALCHAO) {
				
				//SonicadventuresMod.queueServerWork(20, () -> {
					chaoentity.setChaoType(ChaoType.NORMALCHAO);
				//});
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("Back to Normal" + chaoentity.getChaoType()), false);
			} else {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("Your Chao can't be anymore Normal." + chaoentity.getChaoType()), false);
					//return chaoentity.getChaoType();
			}
		} else if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == SonicadventuresModItems.HERO_FRUIT.get()) {
			if (chaoentity.getChaoType() != ChaoType.HEROCHAO) {
				
				SonicadventuresMod.queueServerWork(20, () -> {
				chaoentity.setChaoType(ChaoType.HEROCHAO);
				});
				
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("It's Hero Time." + chaoentity.getChaoType()), false);
			} else {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("Your Chao already radiates Light." + chaoentity.getChaoType()), false);
			}
		} else if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == SonicadventuresModItems.DARK_FRUIT.get()) {
			if (chaoentity.getChaoType() != ChaoType.DARKCHAO) {
				
				SonicadventuresMod.queueServerWork(20, () -> {
				chaoentity.setChaoType(ChaoType.DARKCHAO);
				});
				
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("Welcome to the Dark Side." + chaoentity.getChaoType()), false);
			} else {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("Your Chao already treads through Darkness." + chaoentity.getChaoType()), false);
			}
		}
	}
}
