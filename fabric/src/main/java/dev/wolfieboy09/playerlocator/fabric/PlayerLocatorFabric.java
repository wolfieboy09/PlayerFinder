package dev.wolfieboy09.playerlocator.fabric;

import dev.wolfieboy09.playerlocator.Platform;
import dev.wolfieboy09.playerlocator.PlayerLocator;
import dev.wolfieboy09.playerlocator.commands.FindPlayerCommand;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;

public final class PlayerLocatorFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        PlayerLocator.init(Platform.FABRIC);
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> FindPlayerCommand.createCommand(dispatcher));
    }
}
