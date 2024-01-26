package org.example.personalportfolio.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.varabyte.kobweb.compose.css.*
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
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
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.example.personalportfolio.models.Section
import org.example.personalportfolio.styles.CircleButtonVariant
import org.example.personalportfolio.styles.NavigationItemStyle
import org.example.personalportfolio.util.Res
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.A

@Composable
fun Header(
    breakpoint: Breakpoint,
    onMenuClicked: () -> Unit
) {
    val colorMode by ColorMode.currentState
    Row(
        modifier = Modifier
            .padding(1.cssRem)
            .position(Position.Fixed)
            .zIndex(2)
            .fillMaxWidth()
            .backgroundColor(if (colorMode.isLight) Colors.White else Colors.Black),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        LeftSide(
            breakpoint,
            onMenuClicked
        )
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
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        if (breakpoint < Breakpoint.MD) {
            FaBars(
                modifier = Modifier
                    .margin(bottom = if (breakpoint < Breakpoint.SM) 6.px else 8.px)
                    .cursor(Cursor.Pointer)
                    .onClick {
                        onMenuClicked()
                    },
                size = IconSize.XL,
            )
        }
        A(
            href = "/",
            attrs = Modifier
                .transition(
                    CSSTransition(
                        property = "margin",
                        duration = 2.s,
                        delay = 500.ms
                    )
                )
                .toAttrs()
        ) {
            Image(
                modifier = Modifier.fillMaxSize(),
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
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.End,
    ) {
        Section.entries.forEach { section ->
            Link(
                modifier = NavigationItemStyle.toModifier()
                    .padding(topBottom = 10.px, leftRight = 5.px)
                    .margin(right = 5.px, bottom = 4.px)
                    .fontFamily("Sans-Serif")
                    .textAlign(TextAlign.Center)
                    .fontSize(if (breakpoint > Breakpoint.MD) 18.px else 14.px)
                    .fontWeight(FontWeight.Normal)
                    .textDecorationLine(TextDecorationLine.None)
                    .color(if (colorMode.isLight) Colors.Black else Colors.White),
                path = section.path,
                text = section.title,
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
                top = if (breakpoint < Breakpoint.MD) 10.px else 0.px,
                left = if (breakpoint < Breakpoint.MD) 6.px else 0.px
            ),
        variant = CircleButtonVariant,
    ) {
        if (colorMode.isLight) MoonIcon() else SunIcon()
    }
}