package mod.yourmediocrepal.noel.client.model;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import mod.yourmediocrepal.noel.entities.GingerBreadEntity;
import mod.yourmediocrepal.noel.entities.SugarPlumFairyEntity;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class GingerBreadModel<T extends GingerBreadEntity> extends BipedModel<GingerBreadEntity> {

	public GingerBreadModel() {
		super(0.0F, 0.0F, 64, 64);

		this.bipedHeadwear.showModel = false;

		this.bipedLeftLeg = new ModelRenderer(this, 32, 0);
		this.bipedLeftLeg.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F);
		this.bipedLeftLeg.setRotationPoint(1.9F, 12.0F, 0.0F);

		this.bipedRightLeg = new ModelRenderer(this, 32, 0);
		this.bipedRightLeg.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F);
		this.bipedRightLeg.setRotationPoint(-1.9F, 12.0F, 0.0F);
	}

}