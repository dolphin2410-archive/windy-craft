package me.dolphin2410.windy

import org.bukkit.Bukkit
import org.bukkit.scheduler.BukkitRunnable
import java.util.Random

class WindyRunnable: BukkitRunnable() {
    companion object {
        fun randomTick(): Long {
            return Random().nextLong(400) + 300 // 15s ~ 35s
        }
    }

    fun blowWind(direction: Direction) {
        for (player in Bukkit.getOnlinePlayers()) {
            var counter = 0
            object: BukkitRunnable() {
                override fun run() {
                    if (counter++ > 14) {
                        cancel()
                        return
                    }
                    player.velocity = player.velocity.add(direction.vector.clone().multiply(0.21))
                    for (entity in player.getNearbyEntities(40.0, 40.0, 40.0)) {
                        entity.velocity = entity.velocity.add(direction.vector.clone().multiply(0.21))
                    }
                }
            }.runTaskTimer(PluginMain.plugin, 0, 5)
        }
    }

    override fun run() {
        blowWind(Direction.random())
        WindyRunnable().runTaskLater(PluginMain.plugin, 100 + randomTick())
    }
}