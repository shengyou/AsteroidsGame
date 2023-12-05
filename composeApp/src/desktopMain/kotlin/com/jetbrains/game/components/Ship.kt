package com.jetbrains.game.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.unit.dp
import com.jetbrains.game.extensions.xOffset
import com.jetbrains.game.extensions.yOffset
import com.jetbrains.game.models.ShipData

@Composable
fun Ship(shipData: ShipData, shipColor: Color = Color.White, backgroundColor: Color = Color.Black) {
    val shipSize = shipData.size.dp
    Box(
        Modifier
            .offset(shipData.xOffset, shipData.yOffset)
            .size(shipSize)
            .rotate(shipData.visualAngle.toFloat())
            .clip(CircleShape)
            .background(backgroundColor)
    ) {
        Canvas(modifier = Modifier.fillMaxSize(), onDraw = {
            drawPath(
                color = shipColor,
                path = Path().apply {
                    val size = shipSize.toPx()
                    moveTo(0f, 0f) // Top-left corner...
                    lineTo(size, size / 2f) // ...to right-center...
                    lineTo(0f, size) // ... to bottom-left corner.
                }
            )
        })
    }
}
