package me.saber.tools.hooks;

/**
 * SaberTools - Developed by Driftay.
 * All rights reserved 2020.
 * Creation Date: 5/21/2020
 */

public interface PluginHook<T> {
    T setup();

    String getName();
}

