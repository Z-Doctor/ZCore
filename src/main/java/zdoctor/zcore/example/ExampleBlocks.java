package zdoctor.zcore.example;

import net.minecraft.block.Block;
import zdoctor.zcore.ZCore;
import zdoctor.zcore.common.EasyBlock;

public class ExampleBlocks {
	public static void load() {
		debugBlock = new EasyBlock("debugBlock", ZCore.modid);
	}
	
	public static Block debugBlock;
}
