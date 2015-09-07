package zdoctor.zcore;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import zdoctor.zcore.proxy.CommonProxy;

@Mod(modid = ZCore.modid, version = ZCore.verid, name = ZCore.name)
public class ZCore {
	public static final  String modid = "zcore";
	public static final String verid = "0.0.9";
	public static final String name = "ZCore";
	
	@SidedProxy(clientSide="zdoctor.zcore.proxy.ClientProxy", serverSide="zdoctor.zcore.proxy.ServerProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	public void preFore(FMLConstructionEvent e){
		System.out.println("Using version 0.8 of ZCore test");
	}
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
	    this.proxy.preInit(e);
	}

	@EventHandler
	public void init(FMLInitializationEvent e) {
	    this.proxy.init(e);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {
	    this.proxy.postInit(e);
	}
	
	
}
