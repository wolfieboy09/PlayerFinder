package dev.wolfieboy09.playerlocator.neoforge;

import dev.wolfieboy09.playerlocator.Platform;
import dev.wolfieboy09.playerlocator.PlayerLocator;
import dev.wolfieboy09.playerlocator.commands.FindPlayerCommand;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import org.jetbrains.annotations.NotNull;

@Mod(PlayerLocator.MOD_ID)
public final class PlayerLocatorNeoForge {
    public PlayerLocatorNeoForge() {
        PlayerLocator.init(Platform.NEOFORGE);
        NeoForge.EVENT_BUS.addListener(this::commandEvent);
    }

    public void commandEvent(@NotNull RegisterCommandsEvent event) {
        FindPlayerCommand.createCommand(event.getDispatcher());
    }
}
