package zdoctor.zcore.example;

import net.minecraft.item.Item;
import zdoctor.zcore.ZCore;
import zdoctor.zcore.common.EasySeed;

public class ExampleSeed {
	public static void load() {
		testSeed = new EasySeed("diamondseed", ZCore.modid);
	}
	public static Item testSeed;
}
