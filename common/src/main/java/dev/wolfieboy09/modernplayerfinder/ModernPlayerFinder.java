package dev.wolfieboy09.modernplayerfinder;


import com.mojang.logging.LogUtils;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;

public final class ModernPlayerFinder {
    public static final String MOD_ID = "modernplayerfinder";
    private static final Logger LOGGER = LogUtils.getLogger();

    public static void init(@NotNull Platform platform) {
        LOGGER.info("[ModernPlayerFinder] Launching on {}", platform);
    }
}
