package io.github.lgs3modelview

import com.badlogic.ashley.core.Component
import com.badlogic.gdx.math.Vector2

class Planet : Component {
    var position = Vector2()
    var isOwned = false
}

