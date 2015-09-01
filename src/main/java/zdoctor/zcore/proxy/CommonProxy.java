package zdoctor.zcore.proxy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import zdoctor.zcore.common.ISubEvent;
import zdoctor.zcore.example.ExampleBlocks;
import zdoctor.zcore.example.ExampleCrop;
import zdoctor.zcore.example.ExampleFood;
import zdoctor.zcore.example.ExampleItems;
import zdoctor.zcore.example.ExampleSeed;

public class CommonProxy {
	private static List<ISubEvent> subPre = new ArrayList<ISubEvent>();
	private static List<ISubEvent> subInit = new ArrayList<ISubEvent>();
	private static List<ISubEvent> subPost = new ArrayList<ISubEvent>();
	
	public void preForge() {
		ExampleItems.load();
		ExampleBlocks.load();
    	ExampleFood.load();
    	ExampleSeed.load();
	}
	
	public void preInit(FMLPreInitializationEvent e) {
		alert(e);
		//ExampleCrop.load();
	}
	
	public void init(FMLInitializationEvent e) {
		alert(e);
	}
	
	public void postInit(FMLPostInitializationEvent e) {
		alert(e);
	}
	
	/**
	 * -1 pre, 0 init, 1 post
	 * @param event - The type of event
	 */
	public static void subEvent(ISubEvent object, int event) {
		switch (event) {
			case -1:
				subPre.add(object);
				break;
			case 0:
				subInit.add(object);
				break;
			case 1:
				subPost.add(object);
				break;
			default:
				if(object.equals(Item.class))
					System.out.println("Invalid input. Skipping " + ((Item)object).getUnlocalizedName());
				else
					System.out.println("Invalid input detected!");
				break;
		}
	}

	public static void alert(FMLPreInitializationEvent e) {
		Iterator<ISubEvent> iteratorSubPre = subPre.iterator();
		while(iteratorSubPre.hasNext()){
			iteratorSubPre.next().fire(e);
		}
	}

	public static void alert(FMLInitializationEvent e) {
		Iterator<ISubEvent> iteratorSubInit = subInit.iterator();
		while(iteratorSubInit.hasNext()){
			iteratorSubInit.next().fire(e);
		}
	}
	public static void alert(FMLPostInitializationEvent e) {
		Iterator<ISubEvent> iteratorSubPost = subPost.iterator();
		while(iteratorSubPost.hasNext()){
			iteratorSubPost.next().fire(e);
		}
	}
}
