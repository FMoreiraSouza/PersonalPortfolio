package org.example.personalportfolio.components

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import kotlinx.coroutines.launch
import org.example.personalportfolio.models.Section
import org.example.personalportfolio.util.ObserveViewportEntered
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun SectionTitle(
    modifier: Modifier,
    section: Section
) {
    val breakpoint = rememberBreakpoint()
    val colorMode by ColorMode.currentState
    val scope = rememberCoroutineScope()
    var titleOpacity by remember { mutableStateOf(0.percent) }
    ObserveViewportEntered(
        sectionId = section.id,
        distanceFromTop = if (breakpoint > Breakpoint.LG) 500.0 else if (breakpoint < Breakpoint.MD) 700.0 else 1400.0,
        onViewportEntered = {
            scope.launch {
                titleOpacity = 100.percent
            }
        }
    )
    Column(
        modifier = modifier
            .margin(bottom = 40.px),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        P(
            attrs = Modifier
                .textAlign(TextAlign.Center)
                .color(if(colorMode.isLight) Colors.Gray else Colors.LightGray)
                .fontFamily("Roboto")
                .fontWeight(FontWeight.Bold)
                .fontSize(40.px)
                .toAttrs()
        )
        {
            Text(section.title)
        }
    }
}