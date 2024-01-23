package org.example.personalportfolio.components

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.Visibility
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.components.forms.Button
import com.varabyte.kobweb.silk.components.forms.ButtonVars
import com.varabyte.kobweb.silk.components.icons.fa.FaArrowUp
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.coroutines.launch
import org.example.personalportfolio.styles.CircleButtonVariant
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.em
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.w3c.dom.SMOOTH
import org.w3c.dom.ScrollBehavior
import org.w3c.dom.ScrollToOptions

@Composable
fun ButtonToTop() {
    val scope = rememberCoroutineScope()
    var scroll: Double? by remember { mutableStateOf(null) }
    LaunchedEffect(Unit) {
        window.addEventListener(type = "scroll", callback = {
            scroll = document.documentElement?.scrollTop
        })
    }
    var colorMode by ColorMode.currentState
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
        val show = scroll != null && scroll!! > 400.0
        Button(
            onClick = {
                scope.launch {
                    document.documentElement?.scroll(ScrollToOptions(top = 0.0, behavior = ScrollBehavior.SMOOTH))
                }
            },
            modifier = Modifier
                .setVariable(ButtonVars.FontSize, 1.em)
                .visibility(
                    if (show) Visibility.Visible
                    else Visibility.Hidden
                )
                .margin(right = 2.px, bottom = 20.px)
                .size(50.px)
                .borderRadius(100.percent)
                .cursor(Cursor.Pointer)
                .styleModifier {
                    property("pointer-events", "auto")
                },
            variant = CircleButtonVariant
        )
        {
            FaArrowUp(
                modifier = Modifier.color(if (colorMode.isLight) Colors.Black else Colors.White),
                size = IconSize.LG
            )
        }
    }
}