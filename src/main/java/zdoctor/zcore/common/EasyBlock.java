package zdoctor.zcore.common;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLStateEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import zdoctor.zcore.proxy.CommonProxy;

public class EasyBlock extends Block implements ISubEvent {
	
	private int itemMeta;
	private String itemModel;
	private String modID;
	
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
		this.itemModel = model;
		this.itemMeta = meta;
		this.modID = mod;
		
		setUnlocalizedName(this.itemModel);
		setCreativeTab(tab);
		
		CommonProxy.subEvent(this, 0);	
	}

	@Override
	public void fire(FMLStateEvent e) {
		if(e.getSide() == Side.CLIENT)
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(this), this.itemMeta, 
						new ModelResourceLocation(this.modID + ":" + this.itemModel, "inventory"));
		System.out.println(this.modID + ":" + this.itemModel);
		GameRegistry.registerBlock(this, this.itemModel);
	}
	

}
