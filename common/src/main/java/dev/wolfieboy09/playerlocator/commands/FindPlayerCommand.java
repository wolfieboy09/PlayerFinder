package dev.wolfieboy09.playerlocator.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.tree.LiteralCommandNode;
import net.minecraft.command.argument.EntityArgumentType;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.ClickEvent;
import net.minecraft.text.HoverEvent;
import net.minecraft.text.Text;
import net.minecraft.text.Texts;
import net.minecraft.util.Formatting;
import org.jetbrains.annotations.NotNull;

public class FindPlayerCommand {
    public FindPlayerCommand(){}

    public static void createCommand(@NotNull CommandDispatcher<ServerCommandSource> dispatcher) {
        LiteralCommandNode<ServerCommandSource> source = dispatcher.register(CommandManager.literal("findplayer").requires((cmd) -> cmd.hasPermissionLevel(3))
                .then(CommandManager.argument("player", EntityArgumentType.player())
                        .executes(context -> {
                            final ServerPlayerEntity player = EntityArgumentType.getPlayer(context, "player");
                            final int playerX = player.getBlockX();
                            final int playerY = player.getBlockY();
                            final int playerZ = player.getBlockZ();

                            // Took this line from LocateCommand from Minecraft
                            // It's what I needed, and it works well
                            final Text teleportTo = Texts.bracketed(Text.translatable("chat.coordinates", playerX, playerY, playerZ)).styled((style) -> style.withColor(Formatting.GREEN).withClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/tp @s " + playerX + " " + playerY + " " + playerZ)).withHoverEvent(new HoverEvent(net.minecraft.text.HoverEvent.Action.SHOW_TEXT, Text.translatable("chat.coordinates.tooltip"))));
                            context.getSource().sendFeedback(() -> Text.translatable("commands.findplayer.location", player.getDisplayName(), teleportTo),  false);
                            return 1;
                        })));

        dispatcher.register(CommandManager.literal("findplayer").redirect(source));
    }
}