package zdoctor.zcore.example;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import zdoctor.zcore.ZCore;
import zdoctor.zcore.common.EasyFood;

public class ExampleFood {
	public static void load() {
		harmburger = new EasyFood("hamburger", ZCore.modid).setRecipe(new Object[] {
			" B ", " M ", " B ", 'B', Items.bread, 'M', Items.cooked_beef
		});
	}
	
	public static ItemFood harmburger;
}
