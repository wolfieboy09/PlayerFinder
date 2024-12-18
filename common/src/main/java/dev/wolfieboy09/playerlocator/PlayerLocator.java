package dev.wolfieboy09.playerlocator;


import com.mojang.logging.LogUtils;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;

public final class PlayerLocator {
    public static final String MOD_ID = "playerlocator";
    private static final Logger LOGGER = LogUtils.getLogger();

    public static void init(@NotNull Platform platform) {
        LOGGER.info("Launching on {}", platform);
    }
}
