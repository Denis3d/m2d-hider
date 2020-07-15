package ml.denisd3d.m2dhider;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class HiderConfig
{
    public static final ServerConfig SERVER;
    public static final ForgeConfigSpec SERVER_SPECS;
    static {
        final Pair<ServerConfig, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(ServerConfig::new);
        SERVER_SPECS = specPair.getRight();
        SERVER = specPair.getLeft();
    }

    public static class ServerConfig {

        public final ForgeConfigSpec.ConfigValue<List<? extends String>> hidedPlayersUUID;
        public final ForgeConfigSpec.ConfigValue<List<? extends String>> hidedPlayersName;

        public ServerConfig(ForgeConfigSpec.Builder builder) {
            builder.comment(" Configuration file for M2D Hider, an extension for Minecraft2Discord\n" +
                "   - Curseforge : https://www.curseforge.com/minecraft/mc-mods/m2d-hider\n" +
                "   - Github : https://github.com/Denis3D/M2D-hider\n" +
                "   - Discord : https://discord.gg/rzzd76c").push("M2D Hider");

            List<String> a = new ArrayList<>();
            a.add(UUID.randomUUID().toString());
            hidedPlayersUUID = builder.defineList("hidedPlayersUUID", a, o -> M2DHider.isUUID((String) o));

            hidedPlayersName = builder.defineList("hidedPlayersName", new ArrayList<>(), o -> StringUtils.isAlpha((CharSequence) o));
            builder.pop();
        }

    }
}
