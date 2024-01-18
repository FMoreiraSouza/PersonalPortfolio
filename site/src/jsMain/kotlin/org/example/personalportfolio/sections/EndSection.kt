package org.example.personalportfolio.sections

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.example.personalportfolio.components.SocialLinks
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun EndSection() {
    var colorMode by ColorMode.currentState
    Box(
        modifier = Modifier
            .backgroundColor(if (colorMode.isLight) Color.argb(0.7f, 211, 211, 212) else Color.argb(0.2f, 211, 211, 212))
            .height(100.px)
            .fillMaxWidth(),
        contentAlignment = Alignment.TopCenter
    ) {
        EndContent()
    }
}

@Composable
fun EndContent() {
    val breakpoint = rememberBreakpoint()
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        P(
            attrs = Modifier
                .margin(bottom = 20.px)
                .fontSize(if (breakpoint >= Breakpoint.SM) 40.px else 30.px)
                .textAlign(TextAlign.Center)
                .fontFamily("Roboto")
                .fontWeight(FontWeight.Bold)
                .color(Colors.Gray)
                .toAttrs()
        )
        {
            Text("Desenvolvedor")
        }
        Row {
            SocialLinks()
        }
    }
}