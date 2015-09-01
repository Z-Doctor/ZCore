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
	public EasyBlock(String model, String mod) {
		this(model, mod, CreativeTabs.tabDecorations);
	}
	public EasyBlock(String model, String mod, CreativeTabs tab) {
		super(Material.rock);
		this.itemModel = model;
		this.modID = mod;
		
		this.setCreativeTab(tab);
		this.setUnlocalizedName(this.getModelPath());
		this.setHardness(1.5F);
		this.setResistance(10.0F);
		this.setStepSound(soundTypePiston);
		
		CommonProxy.subEvent(this, 0);	
	}
	
	/** Override to set a different path */
	public String getModelPath() {
		return this.itemModel;
	}
	/** Override to change meta */
	public int getBlockMeta() {
		return 0;
	}
	
	/** Shaped by default 
	 * @param recipe - The food's recipe object */
	public EasyBlock setRecipe(Object[] recipe) {
		return this.setRecipe(recipe, false);
	}
	/**
	 * @param recipe - The item's recipe
	 * @param isShapeless - Whether or not the food's recipe is shapeless
	 */
	public EasyBlock setRecipe(Object[] recipe, boolean isShapeless) {
		if(this.recipe == null) {
			this.recipe = recipe;
			this.isShapeless = isShapeless;
		}
		return this;
	}
	
	public Item asItem() {
		return Item.getItemFromBlock(this);
	}
	public EasyBlock setNoTab() {
		this.setCreativeTab((CreativeTabs)null);
		return this;
	}
	
	// Overrides
	@Override
	public void fire(FMLStateEvent e) {
		System.out.println(this.modID + ":" + this.getModelPath());
		GameRegistry.registerBlock(this, this.getModelPath());
		if(e.getSide() == Side.CLIENT)
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(this.asItem(), this.getBlockMeta(), 
				new ModelResourceLocation(this.modID + ":" + this.getModelPath(), "inventory"));
		if(this.recipe != null) {
			if(this.isShapeless)
				GameRegistry.addShapelessRecipe(new ItemStack(this), this.recipe);
			else
				GameRegistry.addRecipe(new ItemStack(this), this.recipe);
		}
	}
	/** Override to change material */
	@Override
	public Material getMaterial() {
		return super.getMaterial();
	}
}