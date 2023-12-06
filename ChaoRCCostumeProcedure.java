package net.mcreator.sonicadventures.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.sonicadventures.init.SonicadventuresModItems;

public class ChaoRCCostumeProcedure {
	public static void execute(Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == SonicadventuresModItems.NEUTRAL_FRUIT.get()) {
			if (entity.getPersistentData().getDouble("CHAOALIGNMENT") != 0) {
				if (entity.getPersistentData().getDouble("CHAOALIGNMENT") > 0) {
					entity.getPersistentData().putDouble("CHAOALIGNMENT", (entity.getPersistentData().getDouble("CHAOALIGNMENT") - 1));
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("Your Chao Drifts From The Light"), false);
				} else if (entity.getPersistentData().getDouble("CHAOALIGNMENT") < 0) {
					entity.getPersistentData().putDouble("CHAOALIGNMENT", (entity.getPersistentData().getDouble("CHAOALIGNMENT") + 1));
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("Your Chao Steps Into The Light"), false);
				}
			} else {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("Your Chao Is Perfectly Balanced As All Things Should Be."), false);
			}
		} else if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == SonicadventuresModItems.HERO_FRUIT.get()) {
			if (entity.getPersistentData().getDouble("CHAOALIGNMENT") != 2) {
				entity.getPersistentData().putDouble("CHAOALIGNMENT", (entity.getPersistentData().getDouble("CHAOALIGNMENT") + 1));
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("Your Chao Steps Into The Light"), false);
			} else {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("Your Chao Is Already A Hero"), false);
			}
		} else if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == SonicadventuresModItems.DARK_FRUIT.get()) {
			if (entity.getPersistentData().getDouble("CHAOALIGNMENT") != -2) {
				entity.getPersistentData().putDouble("CHAOALIGNMENT", (entity.getPersistentData().getDouble("CHAOALIGNMENT") - 1));
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("Your Chao Drifts From The Light"), false);
			} else {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("Your Chao Is Already Lurks In The Shadows"), false);
			}
		}
	}
}
