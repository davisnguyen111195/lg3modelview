package io.github.lgs3modelview

import com.badlogic.ashley.core.Entity
import com.badlogic.ashley.core.EntityListener
import com.badlogic.ashley.core.Family
import com.badlogic.ashley.systems.IteratingSystem

class PlanetSystem(private val fieldController: FieldController) : IteratingSystem(Family.all(Planet::class.java).get()), EntityListener {
    override fun processEntity(entity: Entity, deltaTime: Float) {
        val planet = entity.getComponent(Planet::class.java)
        // Logic game liên quan đến hành tinh, ví dụ: thay đổi trạng thái sở hữu
        if (planet.isOwned) {
            // Cập nhật trạng thái, ví dụ thay đổi màu sắc hành tinh
            println("Planet at ${planet.position} is owned")
        }
    }

    // Khi một Entity được thêm vào Engine
    override fun entityAdded(entity: Entity?) {
        // Nếu entity là một hành tinh, bạn có thể cập nhật lại appearance của nó
        val planet = entity?.getComponent(Planet::class.java)
        planet?.let {
            fieldController.updatePlanetAppearance(it)
        }
    }

    override fun entityRemoved(entity: Entity?) {
        TODO("Not yet implemented")
    }
}
