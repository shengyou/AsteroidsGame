package com.jetbrains.game.extensions

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.jetbrains.game.models.GameObject

val GameObject.xOffset: Dp get() = position.x.dp - (size.dp / 2)
val GameObject.yOffset: Dp get() = position.y.dp - (size.dp / 2)
