package zdoctor.zcore.example;

import net.minecraft.item.Item;
import zdoctor.zcore.ZCore;
import zdoctor.zcore.common.EasyItem;

public class ExampleItems {
	public static void load() {
		debugTool = new EasyItem("debugtool", ZCore.modid);
	}
	
	public static Item debugTool;
}
