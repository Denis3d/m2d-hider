package ml.denisd3d.m2dhider;

import ml.denisd3d.minecraft2discord.api.M2DExtension;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.AdvancementEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.server.command.ConfigCommand;

public class HiderExtension extends M2DExtension
{
    @Override
    public Boolean onAdvancement(AdvancementEvent event)
    {
        if (HiderConfig.SERVER.hidedPlayersName.get().stream().anyMatch(s -> s.equals(event.getPlayer().getName().getString())) ||
            HiderConfig.SERVER.hidedPlayersUUID.get().stream().anyMatch(s -> s.equals(event.getPlayer().getUniqueID().toString())))
            return null;

        return super.onAdvancement(event);
    }

    @Override
    public Boolean onDeath(LivingDeathEvent event)
    {
        if (HiderConfig.SERVER.hidedPlayersName.get().stream().anyMatch(s -> s.equals(event.getEntity().getName().getString())) ||
            HiderConfig.SERVER.hidedPlayersUUID.get().stream().anyMatch(s -> s.equals(event.getEntity().getUniqueID().toString())))
            return null;

        return super.onDeath(event);
    }

    @Override
    public Boolean onPlayerJoin(PlayerEvent.PlayerLoggedInEvent event)
    {
        if (HiderConfig.SERVER.hidedPlayersName.get().stream().anyMatch(s -> s.equals(event.getPlayer().getName().getString())) ||
            HiderConfig.SERVER.hidedPlayersUUID.get().stream().anyMatch(s -> s.equals(event.getPlayer().getUniqueID().toString())))
            return null;

        return super.onPlayerJoin(event);
    }

    @Override
    public Boolean onPlayerLeft(PlayerEvent.PlayerLoggedOutEvent event)
    {
        if (HiderConfig.SERVER.hidedPlayersName.get().stream().anyMatch(s -> s.equals(event.getPlayer().getName().getString())) ||
            HiderConfig.SERVER.hidedPlayersUUID.get().stream().anyMatch(s -> s.equals(event.getPlayer().getUniqueID().toString())))
            return null;

        return super.onPlayerLeft(event);
    }

    @Override
    public Boolean onMinecraftMessage(ServerChatEvent event)
    {
        if (HiderConfig.SERVER.hidedPlayersName.get().stream().anyMatch(s -> s.equals(event.getPlayer().getName().getString())) ||
            HiderConfig.SERVER.hidedPlayersUUID.get().stream().anyMatch(s -> s.equals(event.getPlayer().getUniqueID().toString())))
            return null;

        return super.onMinecraftMessage(event);
    }
}
