package org.example.personalportfolio.styles

import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.forms.ButtonStyle
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.addVariantBase
import com.varabyte.kobweb.silk.components.style.anyLink
import com.varabyte.kobweb.silk.components.style.hover
import org.example.personalportfolio.models.Theme
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

val CircleButtonVariant by ButtonStyle.addVariantBase {
    Modifier.padding(0.px).borderRadius(50.percent)
}

val NavigationStyle by ComponentStyle{
    base {
        Modifier
            .color(Theme.Primary.rgb)
            .transition(CSSTransition(property = "color", duration = 200.ms))
    }
    anyLink{
        Modifier
            .color(Theme.Primary.rgb)
    }
    hover{
        Modifier
            .border(width = 1.px, style = LineStyle.Solid, color = Colors.SkyBlue)
            .backgroundColor(Colors.SkyBlue)
    }
}

val ButtonStyle by ComponentStyle{
    base{
        Modifier
            .backgroundColor(Colors.Blue)
            .transition(CSSTransition(property = "background", duration = 200.ms))
    }
    hover{
        Modifier
            .backgroundColor(Colors.SkyBlue)
    }
}

val SocialLinkStyle by ComponentStyle{
    base {
        Modifier
            .color(Colors.Gray)
            .transition(CSSTransition(property = "color", duration = 200.ms))
    }
    hover{
        Modifier
            .color(Colors.SkyBlue)
    }
}

val SkillStyle by ComponentStyle{
    base {
        Modifier
            .color(Colors.Gray)
            .transition(CSSTransition(property = "color", duration = 200.ms))
    }
    hover{
        Modifier
            .color(Colors.SkyBlue)
    }
}