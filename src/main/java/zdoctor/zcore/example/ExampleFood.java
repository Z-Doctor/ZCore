package zdoctor.zcore.example;

import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import zdoctor.zcore.ZCore;
import zdoctor.zcore.common.EasyFood;
import zdoctor.zcore.common.EasyItem;

public class ExampleFood {
	public static void load() {
		harmburger = new EasyFood("hamburger", ZCore.modid);
	}
	
	public static ItemFood harmburger;
}
