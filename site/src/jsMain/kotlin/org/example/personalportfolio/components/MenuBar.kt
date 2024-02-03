package org.example.personalportfolio.components

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.css.*
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color
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
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.example.personalportfolio.models.Section
import org.example.personalportfolio.styles.NavigationHeaderStyle
import org.example.personalportfolio.util.Res
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.A

@Composable
fun MenuBar(onMenuClosed: () -> Unit) {
    val breakpoint = rememberBreakpoint()
    val scope = rememberCoroutineScope()
    val colorMode by ColorMode.currentState
    var translateX by remember { mutableStateOf((-100).percent) }
    var opacity by remember { mutableStateOf(0.percent) }
    LaunchedEffect(breakpoint) {
        translateX = 0.percent
        opacity = 100.percent
        if (breakpoint >= Breakpoint.MD) {
            scope.launch {
                translateX = (-100).percent
                opacity = 0.percent
                delay(500)
                onMenuClosed()
            }
        }
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.vh)
            .zIndex(2)
            .position(Position.Fixed)
            .translate(tx = translateX)
            .transition(CSSTransition(property = "translate", duration = 500.ms))
            .backgroundColor(if (colorMode.isLight) Color.Companion.rgb(255, 255, 255) else Color.Companion.rgb(35, 35, 35)),
        verticalArrangement = Arrangement.Top
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            FaXmark(
                modifier = Modifier
                    .margin(left = 14.px, top = 8.px)
                    .cursor(Cursor.Pointer)
                    .onClick {
                        scope.launch {
                            translateX = (-100).percent
                            opacity = 0.percent
                            delay(500)
                            onMenuClosed()
                        }
                    },
                size = if (breakpoint >= Breakpoint.SM) IconSize.XL else IconSize.LG
            )
            ToogleColorThemeButton(breakpoint)
            A(href = "/") {
                Image(
                    modifier = Modifier
                        .margin(left = 4.px, top = 15.px)
                        .fillMaxSize(if (breakpoint >= Breakpoint.SM && breakpoint < Breakpoint.MD) 80.percent else if (breakpoint < Breakpoint.SM) 95.percent else 100.percent),
                    src = Res.Image.professionalLogo
                )
            }
        }
        Column(modifier = Modifier.margin(left = 7.px, top = 4.px)) {
            Section.entries.forEach { section ->
                Link(
                    modifier = NavigationHeaderStyle.toModifier()
                        .padding(leftRight = 5.px, topBottom = 5.px)
                        .fontFamily("Sans-Serif")
                        .textAlign(TextAlign.Center)
                        .fontSize(18.px)
                        .fontWeight(FontWeight.Normal)
                        .textDecorationLine(TextDecorationLine.None)
                        .color(if (colorMode.isLight) Colors.Black else Colors.White),
                    path = section.path,
                    text = section.title
                )
            }
        }
    }
}