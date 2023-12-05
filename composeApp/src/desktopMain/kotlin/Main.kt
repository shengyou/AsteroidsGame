import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.withFrameNanos
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerMoveFilter
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.*
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import com.jetbrains.game.Game
import com.jetbrains.game.components.Asteroid
import com.jetbrains.game.components.Bullet
import com.jetbrains.game.components.Ship
import com.jetbrains.game.models.AsteroidData
import com.jetbrains.game.models.BulletData
import com.jetbrains.game.models.ShipData

@OptIn(ExperimentalComposeUiApi::class)
fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Asteroids for Desktop",
        state = WindowState(
            size = DpSize(700.dp, 900.dp),
        )
    ) {
        val game = remember { Game() }
        val density = LocalDensity.current
        LaunchedEffect(Unit) {
            while (true) {
                withFrameNanos {
                    game.update(it)
                }
            }
        }

        Column(modifier = Modifier.background(Color(51, 153, 255)).fillMaxHeight()) {
            Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
                Button(onClick = {
                    game.startGame()
                }) {
                    Text("开始")
                }
                Text(
                    game.gameStatus,
                    modifier = Modifier.align(Alignment.CenterVertically).padding(horizontal = 16.dp),
                    color = Color.White
                )
            }
            Box(
                modifier = Modifier
                    .aspectRatio(1.0f)
                    .background(Color(0, 0, 30))
                    .fillMaxWidth()
                    .fillMaxHeight()
            ) {
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .clipToBounds()
                    .pointerMoveFilter(onMove = {
                        with(density) {
                            game.targetLocation = DpOffset(it.x.toDp(), it.y.toDp())
                        }
                        false
                    })
                    .clickable() {
                        game.ship.fire(game)
                    }
                    .onSizeChanged {
                        with(density) {
                            game.width = it.width.toDp()
                            game.height = it.height.toDp()
                        }
                    }) {
                    game.gameObjects.forEach {
                        when (it) {
                            is ShipData -> Ship(it)
                            is BulletData -> Bullet(it)
                            is AsteroidData -> Asteroid(it)
                        }
                    }
                }
            }
        }
    }
}
