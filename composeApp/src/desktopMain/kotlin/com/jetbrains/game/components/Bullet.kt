package com.jetbrains.game.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.jetbrains.game.extensions.xOffset
import com.jetbrains.game.extensions.yOffset
import com.jetbrains.game.models.BulletData

@Composable
fun Bullet(bulletData: BulletData) {
    val bulletSize = bulletData.size.dp
    Box(
        Modifier
            .offset(bulletData.xOffset, bulletData.yOffset)
            .size(bulletSize)
            .rotate(bulletData.angle.toFloat())
            .clip(CircleShape)
            .background(Color.Cyan)
    )
}
