package zdoctor.zcore.common;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.event.FMLStateEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import zdoctor.zcore.proxy.CommonProxy;

public class EasyItem extends Item implements ISubEvent {
	// Basic info
	protected final String itemModel;
	protected final String modID;
	// Advance
	protected Object[] recipe;
	protected boolean isShapeless;
	
    /** The amount this food item heals the player. */
	protected int healAmount;
	protected float saturationModifier;
    /** Whether wolves like this food (true for raw and cooked pork chop). */
	protected boolean isWolfsFavoriteMeat;
	
	// Constructors
	public EasyItem(String model, String mod) {
		this(model, mod, CreativeTabs.tabMisc);
	}
	public EasyItem(String model, String mod, CreativeTabs tab) {
		this.itemModel = model;
		this.modID = mod;
		
		this.setCreativeTab(tab);
		this.setUnlocalizedName(this.getModelPath());
		
		CommonProxy.subEvent(this, 0);	
	}
	
	/** Override to set a different path */
	public String getModelPath() {
		return this.itemModel;
	}
	/** Override to change meta */
	public int getItemMeta() {
		return 0;
	}
	
	/** Shaped by default 
	 * @param recipe - The food's recipe object */
	public EasyItem setRecipe(Object[] recipe) {
		return this.setRecipe(recipe, false);
	}
	/**
	 * @param recipe - The item's recipe
	 * @param isShapeless - Whether or not the food's recipe is shapeless
	 */
	public EasyItem setRecipe(Object[] recipe, boolean isShapeless) {
		if(this.recipe == null) {
			this.recipe = recipe;
			this.isShapeless = isShapeless;
		}
		return this;
	}
	
	public EasyItem setNoTab() {
		this.setCreativeTab((CreativeTabs)null);
		return this;
	}
	
	// Overrides
	@Override
	public void fire(FMLStateEvent e) {
		System.out.println(this.modID + ":" + this.getModelPath());
		GameRegistry.registerItem(this, this.getModelPath(), this.modID);
		if(e.getSide() == Side.CLIENT)
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(this, this.getItemMeta(), 
				new ModelResourceLocation(this.modID + ":" + this.getModelPath(), "inventory"));
		if(this.recipe != null) {
			if(this.isShapeless)
				GameRegistry.addShapelessRecipe(new ItemStack(this), this.recipe);
			else
				GameRegistry.addRecipe(new ItemStack(this), this.recipe);
		}
	}
}