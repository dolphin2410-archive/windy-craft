package me.dolphin2410.windy

import org.bukkit.util.Vector
import java.util.*

enum class Direction(val vector: Vector) {
    NORTH(Vector(0.0, 0.0, -1.0)),
    EAST(Vector(1.0, 0.0, 0.0)),
    WEST(Vector(-1.0, 0.0, 0.0)),
    SOUTH(Vector(0.0, 0.0, 1.0));

    companion object {
        fun random(): Direction {
            val random = Random().nextInt(4)
            return values()[random]
        }
    }
}