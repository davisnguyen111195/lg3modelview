package io.github.lgs3modelview

import com.badlogic.gdx.Gdx


import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.utils.viewport.FitViewport
import com.badlogic.ashley.core.Engine
import com.badlogic.ashley.core.Entity

class Main : ApplicationAdapter() {
    lateinit var engine: Engine
    lateinit var stage: Stage
    lateinit var fieldController: FieldController
    lateinit var planetSystem: PlanetSystem
    lateinit var batch: SpriteBatch

    override fun create() {
        batch = SpriteBatch()

        // Tạo Stage và Engine
        stage = Stage(FitViewport(800f, 600f))
        engine = Engine()

        // Khởi tạo các hệ thống và Controller

        fieldController = FieldController(engine, stage)
        planetSystem = PlanetSystem(fieldController)
        engine.addSystem(planetSystem)



        // Tạo Entity cho hành tinh
        val planet = Entity()
        val planetComponent = Planet()
        planetComponent.position.set(100f, 100f)
        planet.add(planetComponent)
        engine.addEntity(planet)

        // Tạo UI và thêm vào Stage
        val planetButton = PlanetButton(planet, fieldController, stage)
        stage.addActor(planetButton)

        // Thiết lập Input Processor cho Stage
        stage.viewport.apply()
        stage.act(Math.min(1f / 60f, 1f / 30f))
        Gdx.input.inputProcessor = stage
    }

    override fun render() {
        // Xóa màn hình và vẽ lại UI
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        stage.act(Math.min(1f / 60f, 1f / 30f))
        stage.draw()
    }

    override fun resize(width: Int, height: Int) {
        stage.viewport.update(width, height, true)
    }

    override fun pause() {
        super.pause()
    }

    override fun resume() {
        super.resume()
    }

    override fun dispose() {
        batch.dispose()
        stage.dispose()
    }
}
