package org.example.personalportfolio.components

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.icons.fa.FaXmark
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import kotlinx.coroutines.launch
import org.example.personalportfolio.models.Section
import org.example.personalportfolio.styles.NavigationDarkStyle
import org.example.personalportfolio.styles.NavigationLightStyle
import org.example.personalportfolio.util.Res
import org.jetbrains.compose.web.css.*

@Composable
fun MenuBar(onMenuClosed: () -> Unit) {
    val scope = rememberCoroutineScope()
    val breakpoint = rememberBreakpoint()
    var colorMode by ColorMode.currentState
    var translateX by remember { mutableStateOf((-100).percent) }
    LaunchedEffect(breakpoint) {
        translateX = 0.percent
        if (breakpoint > Breakpoint.MD) {
            scope.launch {
                onMenuClosed()
            }
        }
    }
    Column(
        modifier = Modifier
            .fillMaxWidth(if (breakpoint >= Breakpoint.MD) 50.percent else 100.percent)
            .height(48.vh)
            .position(Position.Fixed)
            .translate(tx = translateX)
            .transition(CSSTransition(property = "translate", duration = 500.ms))
            .backgroundColor((if (colorMode.isLight) Colors.White else Colors.Black)),
    ) {
        Row {
            FaXmark(
                modifier = Modifier
                    .margin(top = 22.px, left = 10.px)
                    .onClick {
                        scope.launch {
                            onMenuClosed()
                        }
                    },
                size = IconSize.LG
            )
            ToogleColorThemeButton(breakpoint)
            if (breakpoint <= Breakpoint.MD) {
                Image(
                    modifier = Modifier
                        .margin(top = 5.px)
                        .fillMaxSize(80.percent),
                    src = Res.Image.professionalLogo
                )
            }
        }
        Column(
            modifier = Modifier.margin(left = 5.px)
        ) {
            Section.entries.forEach { section ->
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
        }
    }
}