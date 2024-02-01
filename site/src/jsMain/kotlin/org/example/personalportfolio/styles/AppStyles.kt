package org.example.personalportfolio.styles

import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.css.Visibility
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.animation.Keyframes
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

val NavigationHeaderStyle by ComponentStyle {
    base {
        Modifier
            .transition(CSSTransition(property = "color", duration = 200.ms))
    }
    hover {
        Modifier
            .backgroundColor(if (colorMode.isLight) Colors.SkyBlue else Colors.RoyalBlue)
    }
}

val ButtonStyle by ComponentStyle {
    cssRule(" > :only-child") {
        Modifier
            .backgroundColor(Colors.Gray)
            .transition(CSSTransition(property = "background", duration = 200.ms))
    }
    cssRule(":hover > :only-child") {
        Modifier
            .backgroundColor(if (colorMode.isLight) Colors.SkyBlue else Colors.RoyalBlue)
    }
}

val SocialLinkStyle by ComponentStyle {
    base {
        Modifier
            .color(if (colorMode.isLight) Colors.Gray else Colors.LightGray)
            .transition(CSSTransition(property = "color", duration = 200.ms))
    }
    hover {
        Modifier
            .color(if (colorMode.isLight) Colors.SkyBlue else Colors.RoyalBlue)
    }
}

val PresentationStyle by ComponentStyle {
    base {
        Modifier
            .backgroundColor(Color.argb(0.7f, 211, 211, 212))
            .transition(CSSTransition(property = "background", duration = 200.ms))
    }
    hover {
        Modifier
            .backgroundColor(if (colorMode.isLight) Colors.SkyBlue else Colors.RoyalBlue)
    }
}

val SkillStyle by ComponentStyle {
    base {
        Modifier
            .color(if (colorMode.isLight) Colors.Gray else Colors.LightGray)
            .transition(CSSTransition(property = "color", duration = 200.ms))
    }
    hover {
        Modifier
            .color(if (colorMode.isLight) Colors.SkyBlue else Colors.RoyalBlue)
    }
}

val AcademicStyle by ComponentStyle {
    cssRule(" > :last-child") {
        Modifier
            .backgroundColor(Colors.Gray)
            .transition(CSSTransition(property = "background", duration = 200.ms))
    }
    cssRule(":hover > :last-child") {
        Modifier
            .backgroundColor(if (colorMode.isLight) Colors.SkyBlue else Colors.RoyalBlue)
    }
}

val PortfolioStyle by ComponentStyle {
    cssRule(" > #linkParent > #boxParent > #blueCurtain") {
        Modifier
            .width(0.px)
            .transition(CSSTransition(property = "width"))
    }
    cssRule(":hover > #linkParent > #boxParent > #blueCurtain") {
        Modifier
            .fillMaxWidth()
    }
    cssRule(" > #linkParent > #boxParent > #blueCurtain > #linkIcon") {
        Modifier
            .visibility(Visibility.Hidden)
            .transition(CSSTransition(property = "visibility"))
    }
    cssRule(":hover > #linkParent > #boxParent > #blueCurtain > #linkIcon") {
        Modifier
            .visibility(Visibility.Visible)
    }
    cssRule(" > #linkParent > #projectTitle") {
        Modifier
            .color(if (colorMode.isLight) Colors.Gray else Colors.LightGray)
            .translate(0.percent)
            .transition(CSSTransition(property = "color"))
            .transition(CSSTransition(property = "translate", duration = 200.ms))
    }
    cssRule(":hover > #linkParent > #projectTitle") {
        Modifier
            .color(if (colorMode.isLight) Colors.SkyBlue else Colors.RoyalBlue)
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

val FormStyle by ComponentStyle {
    base {
        Modifier
            .border(2.px, LineStyle.Solid, Colors.Gray)
            .transition(CSSTransition(property = "border", duration = 200.ms))
    }
    hover {
        Modifier
            .border(2.px, LineStyle.Solid, if (colorMode.isLight) Colors.SkyBlue else Colors.RoyalBlue)
    }
}

val AppearMoveKeyFrames by Keyframes {
    0.percent {
        Modifier
            .margin(left = (-50).px)
            .opacity(0)
    }
    100.percent {
        Modifier
            .margin(left = 0.px)
            .opacity(1)
    }
}

val ShowKeyFrames by Keyframes {
    0.percent {
        Modifier
            .opacity(0)
    }
    100.percent {
        Modifier
            .opacity(1)
    }
}