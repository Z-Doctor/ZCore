package zdoctor.zcore.example;

import net.minecraft.item.ItemFood;
import zdoctor.zcore.ZCore;
import zdoctor.zcore.common.EasyFood;

public class ExampleFood {
	public static void load() {
		harmburger = new EasyFood("hamburger", ZCore.modid);
	}
	
	public static ItemFood harmburger;
}
