
package net.mcreator.sonicadventures.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.mcreator.sonicadventures.entity.ChaoEntity;
import net.mcreator.sonicadventures.client.model.Modelchao_new;

import net.mcreator.sonicadventures.ChaoType;
import net.mcreator.sonicadventures.ChaoSubType;
import net.mcreator.sonicadventures.ChaoColor;

public class ChaoRenderer extends MobRenderer<ChaoEntity, Modelchao_new<ChaoEntity>> 
{

	private static final ResourceLocation CHAO_NEUTRAL_LOCATION = new ResourceLocation("sonicadventures:textures/entities/chao_normal.png");
	private static final ResourceLocation CHAO_HERO_LOCATION = new ResourceLocation("sonicadventures:textures/entities/chao_hero.png");
	private static final ResourceLocation CHAO_DARK_LOCATION = new ResourceLocation("sonicadventures:textures/entities/chao_dark.png");
	
	public ChaoRenderer(EntityRendererProvider.Context context) 
	{
		super(context, new Modelchao_new(context.bakeLayer(Modelchao_new.LAYER_LOCATION)), 0.5f);
	}
	
	@Override
	public ResourceLocation getTextureLocation(ChaoEntity entity) 
	{
		if (entity.getChaoType() == ChaoType.DARKCHAO)
		{
			return CHAO_DARK_LOCATION;
		}
		else if (entity.getChaoType() == ChaoType.HEROCHAO)
		{
			return CHAO_HERO_LOCATION;
		}
		else
		{
			return CHAO_NEUTRAL_LOCATION;
		}
	}
	/*
	@Override
	public ResourceLocation getTextureLocation(ChaoEntity entity) 
	{
		if (entity.getPersistentData().getDouble("ALIGNMENT") == 2)
		{
			return CHAO_DARK_LOCATION;
		}
		else if (entity.getPersistentData().getDouble("ALIGNMENT") == 1)
		{
			return CHAO_HERO_LOCATION;
		}
		else //if (entity.getPersistentData().getDouble("ALIGNMENT") == 0)
		{
			return CHAO_NEUTRAL_LOCATION;
		}
	}
	*/
}
