package zdoctor.zcore.common;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLStateEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import zdoctor.zcore.proxy.CommonProxy;

public class EasyItem extends Item implements ISubEvent {
	
	protected int itemMeta;
	protected String itemModel;
	protected String modID;
		
	protected Object[] recipe;
	
	protected boolean isShapeless;
	
	public EasyItem(String model, String mod) {
		this(model, 0, mod, CreativeTabs.tabMisc);
	}
	public EasyItem(String model, int meta, String mod) {
		this(model, meta, mod, CreativeTabs.tabMisc);
	}
	public EasyItem(String model, String mod, CreativeTabs tab) {
		this(model, 0, mod, tab);
	}
	public EasyItem(String model, int meta, String mod, CreativeTabs tab) {
		this.itemModel = model;
		this.itemMeta = meta;
		this.modID = mod;

		setUnlocalizedName(this.itemModel);
		setCreativeTab(tab);
		
		CommonProxy.subEvent(this, 0);	
	}
	
	public void setRecipe(Object[] recipe) {
		this.setRecipe(recipe, false);
	}
	/**
	 * 
	 * @param recipe - The item's recipe
	 * @param isShapeless - if shapeless, defaults false
	 */
	public void setRecipe(Object[] recipe, boolean isShapeless) {
		if(this.recipe == null) {
			this.recipe = recipe;
			this.isShapeless = isShapeless;
		}
	}
	
	@Override
	public void fire(FMLStateEvent e) {
		GameRegistry.registerItem(this, this.itemModel, this.modID);
		System.out.println(this.modID + ":" + this.itemModel);
		if(e.getSide() == Side.CLIENT)
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(this,  this.itemMeta, 
				new ModelResourceLocation(this.modID + ":" + this.itemModel, "inventory"));
		if(this.recipe != null) {
			if(this.isShapeless)
				GameRegistry.addShapelessRecipe(new ItemStack(this), this.recipe);
			else
				GameRegistry.addRecipe(new ItemStack(this), this.recipe);
		}
	}
	

}
