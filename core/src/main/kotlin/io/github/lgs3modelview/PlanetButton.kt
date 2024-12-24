package io.github.lgs3modelview

import com.badlogic.ashley.core.Entity
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.scenes.scene2d.Actor
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.TextButton
import com.badlogic.gdx.scenes.scene2d.ui.Skin

class PlanetButton(val planet: Entity, val fieldController: FieldController, stage: Stage) : Actor() {
    private val skin = Skin(Gdx.files.internal("skin_compose_by_dat.json"))
    private val button = TextButton("Change Ownership", skin)

    init {
        button.addListener {
            fieldController.togglePlanetOwnership(planet) // Gọi controller để thay đổi trạng thái
            true
        }
        stage.addActor(button)
    }
}
