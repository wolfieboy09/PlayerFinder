package dev.wolfieboy09.modernplayerfinder.neoforge;

import dev.wolfieboy09.modernplayerfinder.Platform;
import dev.wolfieboy09.modernplayerfinder.ModernPlayerFinder;
import dev.wolfieboy09.modernplayerfinder.commands.FindPlayerCommand;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import org.jetbrains.annotations.NotNull;

@Mod(ModernPlayerFinder.MOD_ID)
public final class ModernPlayerFinderNeoForge {
    public ModernPlayerFinderNeoForge() {
        ModernPlayerFinder.init(Platform.NEOFORGE);
        NeoForge.EVENT_BUS.addListener(this::commandEvent);
    }

    public void commandEvent(@NotNull RegisterCommandsEvent event) {
        FindPlayerCommand.createCommand(event.getDispatcher());
    }
}
