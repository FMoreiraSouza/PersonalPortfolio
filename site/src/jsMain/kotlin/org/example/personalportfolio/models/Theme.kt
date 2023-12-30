package org.example.personalportfolio.models

import com.varabyte.kobweb.compose.ui.graphics.Color.Companion.rgb
import org.jetbrains.compose.web.css.CSSColorValue

enum class Theme(val rgb: CSSColorValue) {
    Primary(rgb(18, 30, 52)),
}