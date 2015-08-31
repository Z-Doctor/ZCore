package zdoctor.zcore.example;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import zdoctor.zcore.ZCore;
import zdoctor.zcore.common.EasyBlock;

public class ExampleBlocks {
	public static void load() {
		dawnstone = new EasyBlock("dawnstone", ZCore.modid){
			@Override
			public void onBlockDestroyedByPlayer(World worldIn, BlockPos pos, IBlockState state) {
				worldIn.setWorldTime(0L);
				super.onBlockDestroyedByPlayer(worldIn, pos, state);
			}
		};
	}
	
	public static Block dawnstone;
}
