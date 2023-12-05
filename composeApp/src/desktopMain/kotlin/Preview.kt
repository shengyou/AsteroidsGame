import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.jetbrains.game.components.Asteroid
import com.jetbrains.game.components.Bullet
import com.jetbrains.game.components.Ship
import com.jetbrains.game.models.AsteroidData
import com.jetbrains.game.models.BulletData
import com.jetbrains.game.models.ShipData

@Preview
@Composable
fun AsteroidPreview() {
    Box(
        modifier = Modifier.fillMaxSize()
            .background(Color(0, 0, 30)),
        contentAlignment = Alignment.Center,
    ) {
        Asteroid(
            asteroidData = AsteroidData()
        )
    }
}

@Preview
@Composable
fun ShipPreview() {
    Box(
        modifier = Modifier.fillMaxSize()
            .background(Color.Gray),
        contentAlignment = Alignment.Center,
    ) {
        Ship(
            shipData = ShipData(),
            shipColor = Color.Green,
            backgroundColor = Color.Red,
        )
    }
}

@Preview
@Composable
fun BulletPreview() {
    Box(
        modifier = Modifier.fillMaxSize()
            .background(Color(0, 0, 30)),
        contentAlignment = Alignment.Center,
    ) {
        Bullet(
            bulletData = BulletData()
        )
    }
}
