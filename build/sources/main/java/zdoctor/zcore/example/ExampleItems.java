package zdoctor.zcore.example;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import zdoctor.zcore.ZCore;
import zdoctor.zcore.common.EasyItem;

public class ExampleItems {
	public static void load() {
		debugTool = new EasyItem("debugtool", ZCore.modid).setRecipe(new Object[]{
			" CI", " BC", "B  ", 'C', Items.coal, 'B', Items.blaze_rod, 'I', Items.iron_ingot
		});
	}
	
	public static Item debugTool;
}
