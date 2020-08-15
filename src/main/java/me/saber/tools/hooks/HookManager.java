package me.saber.tools.hooks;

import me.saber.tools.SaberTools;
import me.saber.tools.utils.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * SaberTools - Developed by Driftay.
 * All rights reserved 2020.
 * Creation Date: 5/21/2020
 */

public class HookManager {
    private static Map<String, PluginHook<?>> pluginMap = new HashMap<>();

    public HookManager(List<PluginHook<?>> list) {
        for (PluginHook<?> hook : list) {
            pluginMap.put(hook.getName(), (PluginHook) hook.setup());
            if (SaberTools.instance.getServer().getPluginManager().getPlugin(hook.getName()) != null) {
                Logger.print("successfully hooked " + hook.getName(), Logger.PrefixType.DEFAULT);
                continue;
            }
            Logger.print("could not hook " + hook.getName(), Logger.PrefixType.WARNING);
        }
    }

    public static Map<String, PluginHook<?>> getPluginMap() {
        return pluginMap;
    }
}


