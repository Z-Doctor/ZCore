package zdoctor.zcore.common;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.StatList;
import net.minecraft.world.World;

/* Quick Reference
 * Food	HealAmount Saturation
 ***Apple***4***0.3F
 ***Bread***5***0.6F
 ***Porkchop/Beef(Raw)***3***0.3F
 ***Porkchop/Beef(Cooked)***8***0.8F
 ***Golden Apple***4***1.2F
 */
import net.minecraftforge.fml.common.event.FMLStateEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import zdoctor.zcore.proxy.CommonProxy;

public class EasyFood extends ItemFood implements ISubEvent {
	protected int itemMeta;
	protected String itemModel;
	protected String modID;
	
	protected Object[] recipe;
	
	/** Number of ticks to run while 'EnumAction'ing until result. 20 ticks is 1 second */
	protected int itemUseDuration;
    /** The amount this food item heals the player. */
	protected int healAmount;
	protected float saturationModifier;
    /** Whether wolves like this food (true for raw and cooked porkchop). */
	protected boolean isWolfsFavoriteMeat;
	
	public EasyFood(String model, String mod) {
		this(model, 0, mod, CreativeTabs.tabFood);
	}
	public EasyFood(String model, int meta, String mod) {
		this(model, meta, mod, CreativeTabs.tabFood);
	}
	public EasyFood(String model, String mod, CreativeTabs tab) {
		this(model, 0, mod, tab);
	}
	public EasyFood(String model, int meta, String mod, CreativeTabs tab) {
		super(4, 0.3F, false);
		this.itemModel = "food/" + model;
		this.itemMeta = meta;
		this.modID = mod;
		
		setCreativeTab(tab);
		setUnlocalizedName(this.itemModel);
		
		this.itemUseDuration = 32;
		this.healAmount = 4;
		this.saturationModifier = 0.3F;
		this.isWolfsFavoriteMeat = false;
		
		CommonProxy.subEvent(this, 0);	
	}
	
	
	public void setStats(int amount, float saturation){
		this.setStats(32, amount, saturation, false);
	}
	public void setStats(int amount, float saturation, boolean isWolfFood){
		this.setStats(32, amount, saturation, isWolfFood);
	}
	public void setStats(int eatTime, int amount, float saturation){
		this.setStats(eatTime, amount, saturation, false);
	}
	public void setStats(int eatTime, int amount, float saturation, boolean isWolfFood){
		this.itemUseDuration = eatTime;
		this.healAmount = amount;
		this.saturationModifier = saturation;
		this.isWolfsFavoriteMeat = isWolfFood;
	}
	
	@Override
	public void fire(FMLStateEvent e) {
		if(e.getSide() == Side.CLIENT)
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(this, 
					this.itemMeta, new ModelResourceLocation(this.modID + ":" +
						this.itemModel, "inventory"));
		System.out.println(this.modID + ":" + this.itemModel);
		GameRegistry.registerItem(this, this.itemModel, this.modID);
	}
	
	@Override
	public boolean isWolfsFavoriteMeat() {
		// TODO Auto-generated method stub
		return this.isWolfsFavoriteMeat;
	}
	@Override
	public int getHealAmount(ItemStack stack) {
		// TODO Auto-generated method stub
		return this.healAmount;
	}
	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityPlayer playerIn) {
		return super.onItemUseFinish(stack, worldIn, playerIn);
	}
	@Override
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
		super.onFoodEaten(stack, worldIn, player);
	}
	@Override
	public int getMaxItemUseDuration(ItemStack stack) {
		return this.itemUseDuration;
	}
	@Override
	public EnumAction getItemUseAction(ItemStack stack) {
		return super.getItemUseAction(stack);
	}
	@Override
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn) {
		return super.onItemRightClick(itemStackIn, worldIn, playerIn);
	}
	@Override
	public float getSaturationModifier(ItemStack stack) {
		return this.saturationModifier;
	}
	@Override
	public ItemFood setPotionEffect(int id, int duration, int amplifier, float probability) {
		return super.setPotionEffect(id, duration, amplifier, probability);
	}
}
