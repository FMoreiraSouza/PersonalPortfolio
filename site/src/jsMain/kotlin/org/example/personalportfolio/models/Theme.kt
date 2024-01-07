package org.example.personalportfolio.models

import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.rgb

enum class Theme(val rgb: CSSColorValue) {
    Primary(rgb(18, 30, 52)),
    LighterGray(rgb(249, 249, 249))
}