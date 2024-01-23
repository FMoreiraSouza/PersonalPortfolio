package org.example.personalportfolio.styles

import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.css.Visibility
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.forms.ButtonStyle
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.addVariantBase
import com.varabyte.kobweb.silk.components.style.hover
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

val CircleButtonVariant by ButtonStyle.addVariantBase {
    Modifier.padding(0.px).borderRadius(50.percent)
}

val LighterNavigationStyle by ComponentStyle {
    base {
        Modifier
            .backgroundColor(Colors.Transparent)
            .transition(CSSTransition(property = "color", duration = 200.ms))
    }
    hover {
        Modifier
            .backgroundColor(Colors.SkyBlue)
    }
}

val DarkerNavigationStyle by ComponentStyle {
    base {
        Modifier
            .backgroundColor(Colors.Transparent)
            .transition(CSSTransition(property = "color", duration = 200.ms))
    }
    hover {
        Modifier
            .backgroundColor(Colors.RoyalBlue)
    }
}

val LighterButtonStyle by ComponentStyle {
    cssRule(" > :only-child") {
        Modifier
            .backgroundColor(Colors.Gray)
            .transition(CSSTransition(property = "background", duration = 200.ms))
    }
    cssRule(":hover > :only-child") {
        Modifier
            .backgroundColor(Colors.SkyBlue)
    }
}

val DarkerButtonStyle by ComponentStyle {
    cssRule(" > :only-child") {
        Modifier
            .backgroundColor(Colors.Gray)
            .transition(CSSTransition(property = "background", duration = 200.ms))
    }
    cssRule(":hover > :only-child") {
        Modifier
            .backgroundColor(Colors.RoyalBlue)
    }
}

val LighterSocialLinkStyle by ComponentStyle {
    base {
        Modifier
            .color(Colors.Gray)
            .transition(CSSTransition(property = "color", duration = 200.ms))
    }
    hover {
        Modifier
            .color(Colors.SkyBlue)
    }
}

val DarkerSocialLinkStyle by ComponentStyle {
    base {
        Modifier
            .color(Colors.Gray)
            .transition(CSSTransition(property = "color", duration = 200.ms))
    }
    hover {
        Modifier
            .color(Colors.RoyalBlue)
    }
}

val LighterPresentationColumnStyle by ComponentStyle {
    base {
        Modifier
            .backgroundColor(Color.argb(0.7f, 211, 211, 212))
            .transition(CSSTransition(property = "background", duration = 200.ms))
    }
    hover {
        Modifier
            .backgroundColor(Colors.SkyBlue)
    }
}

val DarkerPresentationColumnStyle by ComponentStyle {
    base {
        Modifier
            .backgroundColor(Color.argb(0.2f, 211, 211, 212))
            .transition(CSSTransition(property = "background", duration = 200.ms))
    }
    hover {
        Modifier
            .backgroundColor(Colors.RoyalBlue)
    }
}

val LighterSkillStyle by ComponentStyle {
    base {
        Modifier
            .color(Colors.Gray)
            .transition(CSSTransition(property = "color", duration = 200.ms))
    }
    hover {
        Modifier
            .color(Colors.SkyBlue)
    }
}

val DarkerSkillStyle by ComponentStyle {
    base {
        Modifier
            .color(Colors.Gray)
            .transition(CSSTransition(property = "color", duration = 200.ms))
    }
    hover {
        Modifier
            .color(Colors.RoyalBlue)
    }
}

val LighterAcademicStyle by ComponentStyle {
    cssRule(" > :last-child") {
        Modifier
            .backgroundColor(Colors.Gray)
            .transition(CSSTransition(property = "background", duration = 200.ms))
    }
    cssRule(":hover > :last-child") {
        Modifier.backgroundColor(Colors.SkyBlue)
    }
}

val DarkerAcademicStyle by ComponentStyle {
    cssRule(" > :last-child") {
        Modifier
            .backgroundColor(Colors.Gray)
            .transition(CSSTransition(property = "background", duration = 200.ms))
    }
    cssRule(":hover > :last-child") {
        Modifier.backgroundColor(Colors.RoyalBlue)
    }
}

val LighterPortfolioStyle by ComponentStyle {
    cssRule(" > #linkParent > #boxParent > #blueCurtain") {
        Modifier
            .width(0.px)
            .transition(CSSTransition(property = "width", duration = 500.ms))
    }
    cssRule(":hover > #linkParent > #boxParent > #blueCurtain") {
        Modifier
            .fillMaxWidth()
    }
    cssRule(" > #linkParent > #boxParent > #blueCurtain > #linkIcon") {
        Modifier
            .size(0.px)
            .visibility(Visibility.Hidden)
            .transition(CSSTransition(property = "visibility", duration = 200.ms))
            .transition(CSSTransition(property = "size", duration = 200.ms))
    }
    cssRule(":hover > #linkParent > #boxParent > #blueCurtain > #linkIcon") {
        Modifier
            .size(30.px)
            .visibility(Visibility.Visible)
    }
    cssRule(" > #linkParent > #projectTitle") {
        Modifier
            .color(Colors.Gray)
            .translate(0.percent)
            .transition(CSSTransition(property = "color", duration = 200.ms))
            .transition(CSSTransition(property = "translate", duration = 200.ms))
    }
    cssRule(":hover > #linkParent > #projectTitle") {
        Modifier
            .color(Colors.SkyBlue)
            .translate(5.percent)
    }
    cssRule(" > #linkParent > #projectPlatform") {
        Modifier
            .translate(0.percent)
            .transition(CSSTransition(property = "translate", duration = 200.ms))
    }
    cssRule(":hover > #linkParent > #projectPlatform") {
        Modifier
            .translate(5.percent)
    }
}

val DarkerPortfolioStyle by ComponentStyle {
    cssRule(" > #linkParent > #boxParent > #blueCurtain") {
        Modifier
            .width(0.px)
            .transition(CSSTransition(property = "width", duration = 500.ms))
    }
    cssRule(":hover > #linkParent > #boxParent > #blueCurtain") {
        Modifier
            .fillMaxWidth()
    }
    cssRule(" > #linkParent > #boxParent > #blueCurtain > #linkIcon") {
        Modifier
            .size(0.px)
            .visibility(Visibility.Hidden)
            .transition(CSSTransition(property = "visibility", duration = 200.ms))
            .transition(CSSTransition(property = "size", duration = 200.ms))
    }
    cssRule(":hover > #linkParent > #boxParent > #blueCurtain > #linkIcon") {
        Modifier
            .size(30.px)
            .visibility(Visibility.Visible)
    }
    cssRule(" > #linkParent > #projectTitle") {
        Modifier
            .color(Colors.Gray)
            .translate(0.percent)
            .transition(CSSTransition(property = "color", duration = 200.ms))
            .transition(CSSTransition(property = "translate", duration = 200.ms))
    }
    cssRule(":hover > #linkParent > #projectTitle") {
        Modifier
            .color(Colors.RoyalBlue)
            .translate(5.percent)
    }
    cssRule(" > #linkParent > #projectPlatform") {
        Modifier
            .translate(0.percent)
            .transition(CSSTransition(property = "translate", duration = 200.ms))
    }
    cssRule(":hover > #linkParent > #projectPlatform") {
        Modifier
            .translate(5.percent)
    }
}

val LighterFormStyle by ComponentStyle {
    base {
        Modifier
            .border(2.px, LineStyle.Solid, Colors.Gray)
            .transition(CSSTransition(property = "border", duration = 200.ms))
    }
    hover {
        Modifier
            .border(2.px, LineStyle.Solid, Colors.SkyBlue)
    }
}

val DarkerFormStyle by ComponentStyle {
    base {
        Modifier
            .border(2.px, LineStyle.Solid, Colors.Gray)
            .transition(CSSTransition(property = "border", duration = 200.ms))
    }
    hover {
        Modifier
            .border(2.px, LineStyle.Solid, Colors.RoyalBlue)
    }
}