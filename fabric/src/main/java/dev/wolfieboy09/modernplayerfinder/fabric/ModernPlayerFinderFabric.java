package dev.wolfieboy09.modernplayerfinder.fabric;

import dev.wolfieboy09.modernplayerfinder.Platform;
import dev.wolfieboy09.modernplayerfinder.ModernPlayerFinder;
import dev.wolfieboy09.modernplayerfinder.commands.FindPlayerCommand;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;

public final class ModernPlayerFinderFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        ModernPlayerFinder.init(Platform.FABRIC);
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> FindPlayerCommand.createCommand(dispatcher));
    }
}
