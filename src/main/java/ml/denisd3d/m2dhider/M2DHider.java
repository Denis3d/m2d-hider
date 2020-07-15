package ml.denisd3d.m2dhider;

import ml.denisd3d.minecraft2discord.api.M2DUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.UUID;

@Mod("m2d-hider")
public class M2DHider {

    private static final Logger LOGGER = LogManager.getLogger();

    public M2DHider() {
        MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, this::onServerStarting);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, HiderConfig.SERVER_SPECS, "m2d-hider.toml");
    }

    public void onServerStarting(FMLServerStartingEvent event)
    {
        M2DUtils.registerExtension(new HiderExtension());
    }

    static boolean isUUID(String string) {
        try {
            UUID.fromString(string);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
