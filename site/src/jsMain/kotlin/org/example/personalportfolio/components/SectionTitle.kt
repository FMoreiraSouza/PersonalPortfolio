package org.example.personalportfolio.components

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.css.CSSTransition
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
import kotlinx.coroutines.launch
import org.example.personalportfolio.models.Section
import org.example.personalportfolio.util.ObserveViewportEntered
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.s
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun SectionTitle(
    section: Section,
) {
    val breakpoint = rememberBreakpoint()
    val scope = rememberCoroutineScope()
    var titleMargin by remember { mutableStateOf((-100).px) }

    ObserveViewportEntered(
        sectionId = section.id,
        distanceFromTop = 500.0,
        onViewportEntered = {
            scope.launch {
                titleMargin = 0.px
            }
        }
    )
    Column(
        modifier = Modifier.margin(bottom = 40.px),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        P(
            attrs = Modifier
                .textAlign(
                    TextAlign.Center
                )
                .margin(left = if (breakpoint > Breakpoint.MD) titleMargin else 0.px)
                .color(Colors.Gray)
                .fontFamily("Roboto")
                .fontWeight(FontWeight.Bold)
                .fontSize(40.px)
                .transition(CSSTransition(property = "margin", duration = 1.s))
                .toAttrs()
        )
        {
            Text(section.title)
        }
    }
}