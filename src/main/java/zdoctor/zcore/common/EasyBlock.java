package zdoctor.zcore.common;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLStateEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import zdoctor.zcore.proxy.CommonProxy;

public class EasyBlock extends Block implements ISubEvent {
	
	protected int blockMeta;
	protected String blockModel;
	protected String modID;
	
	protected Block block;
	
	protected Object[] recipe;
	protected boolean isShapeless;
	
	public EasyBlock(String model, String mod) {
		this(model, 0, mod, CreativeTabs.tabDecorations);
	}
	public EasyBlock(String model, int meta, String mod) {
		this(model, meta, mod, CreativeTabs.tabDecorations);
	}
	public EasyBlock(String model, String mod, CreativeTabs tab) {
		this(model, 0, mod, tab);
	}
	public EasyBlock(String model, int meta, String mod, CreativeTabs tab) {
		super(Material.rock);
		this.blockModel = model;
		this.blockMeta = meta;
		this.modID = mod;
		
		setUnlocalizedName(this.blockModel);
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
		System.out.println(this.modID + ":" + this.blockModel);
		GameRegistry.registerBlock(this, this.blockModel);
		if(e.getSide() == Side.CLIENT)
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(this), this.blockMeta, 
						new ModelResourceLocation(this.modID + ":" + this.blockModel, "inventory"));
		if(this.recipe != null) {
			if(this.isShapeless)
				GameRegistry.addShapelessRecipe(new ItemStack(this), this.recipe);
			else
				GameRegistry.addRecipe(new ItemStack(this), this.recipe);
		}
	}
	

}
