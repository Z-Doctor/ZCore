package zdoctor.zcore.example;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;
import zdoctor.zcore.common.EasyCrop;

public class ExampleCrop {
	public static void load() {
		plantDiamond = new EasyCrop();
	}
	
	public static Block plantDiamond;
}
