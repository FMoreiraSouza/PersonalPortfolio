package org.example.personalportfolio.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.forms.Button
import com.varabyte.kobweb.silk.components.forms.ButtonVars
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.icons.MoonIcon
import com.varabyte.kobweb.silk.components.icons.SunIcon
import com.varabyte.kobweb.silk.components.icons.fa.FaBars
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.example.personalportfolio.models.Section
import org.example.personalportfolio.styles.CircleButtonVariant
import org.example.personalportfolio.styles.NavigationHeaderStyle
import org.example.personalportfolio.util.Res
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.A

@Composable
fun Header(onMenuClicked: () -> Unit) {
    val breakpoint = rememberBreakpoint()
    val colorMode by ColorMode.currentState
    Row(
        modifier = Modifier
            .padding(1.cssRem)
            .position(Position.Fixed)
            .zIndex(2)
            .fillMaxWidth()
            .backgroundColor(if (colorMode.isLight) Color.Companion.rgb(255, 255, 255) else Color.Companion.rgb(35, 35, 35)),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        LeftSide(breakpoint, onMenuClicked)
        if (breakpoint >= Breakpoint.MD) {
            RightSide(breakpoint, colorMode)
        }
    }
}

@Composable
fun LeftSide(
    breakpoint: Breakpoint,
    onMenuClicked: () -> Unit
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        if (breakpoint < Breakpoint.MD) {
            FaBars(
                modifier = Modifier
                    .margin(right = 4.px, bottom = 8.px)
                    .cursor(Cursor.Pointer)
                    .onClick {
                        onMenuClicked()
                    },
                size = if (breakpoint >= Breakpoint.SM) IconSize.XL else IconSize.LG
            )
        }
        A(href = "/") {
            Image(
                modifier = Modifier.fillMaxSize(if (breakpoint >= Breakpoint.SM && breakpoint < Breakpoint.MD) 80.percent else 100.percent),
                src = Res.Image.professionalLogo
            )
        }
    }
}

@Composable
fun RightSide(
    breakpoint: Breakpoint,
    colorMode: ColorMode
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.End,
    ) {
        Section.entries.forEach { section ->
            Link(
                modifier = NavigationHeaderStyle.toModifier()
                    .padding(leftRight = 5.px, topBottom = 10.px)
                    .margin(bottom = 4.px)
                    .fontFamily("Sans-Serif")
                    .textAlign(TextAlign.Center)
                    .fontSize(if (breakpoint > Breakpoint.MD) 18.px else 14.px)
                    .fontWeight(FontWeight.Normal)
                    .textDecorationLine(TextDecorationLine.None)
                    .color(if (colorMode.isLight) Colors.Black else Colors.White),
                path = section.path,
                text = section.title
            )
        }
        ToogleColorThemeButton(breakpoint)
    }
}

@Composable
fun ToogleColorThemeButton(breakpoint: Breakpoint) {
    var colorMode by ColorMode.currentState
    Button(
        onClick = { colorMode = colorMode.opposite },
        modifier = Modifier
            .setVariable(ButtonVars.FontSize, 1.em)
            .margin(
                top = if (breakpoint < Breakpoint.MD) 10.px else 1.px,
                left = if (breakpoint < Breakpoint.SM) 8.px else if (breakpoint < Breakpoint.MD) 10.px else 5.px
            ),
        variant = CircleButtonVariant
    ) {
        if (colorMode.isLight) MoonIcon() else SunIcon()
    }
}