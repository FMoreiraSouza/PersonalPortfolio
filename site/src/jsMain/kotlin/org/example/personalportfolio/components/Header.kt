package org.example.personalportfolio.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.varabyte.kobweb.compose.css.FontWeight
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
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.example.personalportfolio.models.Section
import org.example.personalportfolio.models.Theme
import org.example.personalportfolio.styles.CircleButtonVariant
import org.example.personalportfolio.styles.NavigationStyle
import org.example.personalportfolio.util.Res
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.em
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

@Composable
fun Header() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(1.cssRem),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        ProfessionalLogo()
        Topics()
        ColorModeButton()
    }
}

@Composable
fun ProfessionalLogo() {
    Row(
        modifier = Modifier
            .margin(bottom = 2.px, right = 290.px)
            .fillMaxSize(20.percent),
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            modifier = Modifier
                .fillMaxSize(),
            src = Res.Image.professionalLogo
        )
    }
}

@Composable
fun Topics() {
    var colorMode by ColorMode.currentState
    Row(
        modifier = Modifier
            .margin(bottom = 2.px, left = 20.px)
            .fillMaxWidth(60.percent),
        horizontalArrangement = Arrangement.Center
    ) {
        Section.values().take(6).forEach { section ->
            Link(
                modifier = NavigationStyle.toModifier()
                    .margin(all = 10.px)
                    .fontFamily("Montserrat", "sans-serif")
                    .fontSize(18.px)
                    .fontWeight(FontWeight.Normal)
                    .textDecorationLine(TextDecorationLine.None)
                    .color(if (colorMode.isLight) Theme.Primary.rgb else Colors.Gray),
                path = section.path,
                text = section.title,
            )
        }
    }
}

@Composable
fun ColorModeButton() {
    var colorMode by ColorMode.currentState
    Button(
        onClick = { colorMode = colorMode.opposite },
        modifier = Modifier.setVariable(ButtonVars.FontSize, 1.em),
        variant = CircleButtonVariant
    ) {
        if (colorMode.isLight) MoonIcon() else SunIcon()
    }
}