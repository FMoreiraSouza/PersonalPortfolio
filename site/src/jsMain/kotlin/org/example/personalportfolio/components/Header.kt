package org.example.personalportfolio.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
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
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.example.personalportfolio.models.Section
import org.example.personalportfolio.styles.CircleButtonVariant
import org.example.personalportfolio.styles.NavigationDarkStyle
import org.example.personalportfolio.styles.NavigationLightStyle
import org.example.personalportfolio.util.Res
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.em
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

@Composable
fun Header(
    breakpoint: Breakpoint
) {
    Row(
        modifier = Modifier
            .padding(1.cssRem)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        LeftSide(breakpoint)
        if (breakpoint > Breakpoint.MD) {
            RightSide()
        }
    }
}

@Composable
fun LeftSide(breakpoint: Breakpoint) {
    Row(
        modifier = Modifier
            .fillMaxSize(20.percent),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        if (breakpoint <= Breakpoint.MD) {
            FaBars(
                modifier = Modifier
                    .onClick {},
                size = IconSize.XL,
            )
        }
        if(breakpoint >= Breakpoint.SM){
            Image(
                src = Res.Image.professionalLogo
            )
        }
        else{
            Image(
                modifier = Modifier.width(235.px),
                src = Res.Image.professionalLogo
            )
        }
    }
}

@Composable
fun RightSide() {
    var colorMode by ColorMode.currentState
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.End,
    ) {
        Section.values().take(6).forEach { section ->
            Link(
                modifier = (if (colorMode.isLight) NavigationLightStyle.toModifier() else NavigationDarkStyle.toModifier())
                    .padding(topBottom = 10.px, leftRight = 5.px)
                    .margin(right = 10.px)
                    .fontFamily("Sans-Serif")
                    .textAlign(TextAlign.Center)
                    .fontSize(18.px)
                    .fontWeight(FontWeight.Normal)
                    .textDecorationLine(TextDecorationLine.None)
                    .color(if (colorMode.isLight) Colors.Black else Colors.White),
                path = section.path,
                text = section.title,
            )
        }
        var colorMode by ColorMode.currentState
        Button(
            onClick = { colorMode = colorMode.opposite },
            modifier = Modifier
                .setVariable(ButtonVars.FontSize, 1.em),
            variant = CircleButtonVariant
        ) {
            if (colorMode.isLight) MoonIcon() else SunIcon()
        }
    }
}