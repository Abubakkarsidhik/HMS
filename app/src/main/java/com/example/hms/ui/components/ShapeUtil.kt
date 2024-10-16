package com.example.hms.ui.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp

object ShapeUtil {

    // Custom shape to create slanted sides and rounded top corners
    class TopBarShape : Shape {
        override fun createOutline(
            size: Size,
            layoutDirection: LayoutDirection,
            density: Density
        ): Outline {

            val path = Path().apply {
                // Start from bottom-left corner
                moveTo(0f, size.height)

                // Slant up toward the top-left corner (adjusting the offset to match the right side)
                lineTo(size.width * 0.075f, size.height * 0.3f)

                // Top left rounded corner with 15f offset
                arcTo(
                    rect = Rect(15f, 0f, size.width * 0.3f, size.height * 0.65f),
                    startAngleDegrees = 180f,  // Start from the left side and sweep upward
                    sweepAngleDegrees = 90f,   // Sweep to create the rounded top left corner
                    forceMoveTo = false
                )

                // Line across the top (straight)
                lineTo(size.width * 0.7f, 0f)

                // Top right rounded corner with 15f offset
                arcTo(
                    rect = Rect(size.width * 0.7f - 15f, 0f, size.width - 15f, size.height * 0.65f),
                    startAngleDegrees = 270f,  // Start from the top-right and sweep downward
                    sweepAngleDegrees = 90f,   // Sweep to create the rounded top right corner
                    forceMoveTo = false
                )

                // Slant down toward the bottom-right corner
                lineTo(size.width * 1.0f - 15f, size.height * 0.3f)

                // Close the path with a flat bottom
                lineTo(size.width, size.height)

                // Finish closing the path
                lineTo(0f, size.height)
                close()
            }




            return Outline.Generic(path)
        }
    }

    val appShape = RoundedCornerShape(8.dp)

}

