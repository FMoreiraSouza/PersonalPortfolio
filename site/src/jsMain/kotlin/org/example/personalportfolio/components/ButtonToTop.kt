package org.example.personalportfolio.components

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.Visibility
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.components.icons.fa.FaArrowUp
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.components.style.toModifier
import kotlinx.browser.document
import kotlinx.browser.window
import org.example.personalportfolio.styles.ButtonToTopStyle
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

@Composable
fun ButtonToTop() {
    var scroll: Double? by remember { mutableStateOf(null) }
    LaunchedEffect(Unit) {
        window.addEventListener(type = "scroll", callback = {
            scroll = document.documentElement?.scrollTop
        })
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .position(Position.Fixed)
            .zIndex(1)
            .styleModifier {
                property("pointer-events", "none")
            },
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.End
    ) {
        Box(
            modifier = ButtonToTopStyle.toModifier()
                .visibility(
                    if(scroll != null && scroll!! > 400.0) Visibility.Visible
                    else Visibility.Hidden
                )
                .margin(right = 2.px, bottom = 20.px)
                .size(50.px)
                .borderRadius(20.percent)
                .cursor(Cursor.Pointer)
                .onClick {
                    document.documentElement?.scroll(x = 0.0, y = 0.0)
                }
                .styleModifier {
                    property("pointer-events", "auto")
                },
            contentAlignment = Alignment.Center
        ) {
            FaArrowUp(
                modifier = Modifier.color(Colors.White),
                size = IconSize.LG
            )
        }
    }
}