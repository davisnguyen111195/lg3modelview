package io.github.lgs3modelview

import com.badlogic.ashley.core.Engine
import com.badlogic.ashley.core.Entity
import com.badlogic.gdx.scenes.scene2d.Stage

class FieldController(val engine: Engine, val stage: Stage) {
    fun togglePlanetOwnership(planetEntity: Entity) {
        val planet = planetEntity.getComponent(Planet::class.java)
        planet.isOwned = !planet.isOwned  // Toggle trạng thái sở hữu

        // Cập nhật giao diện, ví dụ: thay đổi màu sắc hoặc nút bấm
        updatePlanetAppearance(planet)
    }

    fun updatePlanetAppearance(planet: Planet) {
        // Cập nhật UI khi trạng thái hành tinh thay đổi
        println("Planet ownership changed: ${planet.isOwned}")
    }
}

