package me.dolphin2410.windy

import io.github.monun.kommand.kommand
import org.bukkit.plugin.java.JavaPlugin

class PluginMain: JavaPlugin() {
    companion object {
        lateinit var plugin: JavaPlugin
            private set
    }

    override fun onEnable() {
        plugin = this
        kommand {
            register("windy") {
                then("start") {
                    executes {
                        WindyRunnable().runTaskLater(this@PluginMain, WindyRunnable.randomTick())
                    }
                }
            }
        }
    }
}