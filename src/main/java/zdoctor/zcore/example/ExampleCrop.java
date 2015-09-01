package zdoctor.zcore.example;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import zdoctor.zcore.ZCore;
import zdoctor.zcore.common.EasyCrop;
import zdoctor.zcore.common.EasySeed;

public class ExampleCrop {
	public static void load() {
		plantDiamond = new EasyCrop("diamondcrop", ZCore.modid).setCrop(Items.diamond,
				new EasySeed("diamondseed", ZCore.modid));
	}
	
	public static Block plantDiamond;
	public static Item diamondseed;
}
