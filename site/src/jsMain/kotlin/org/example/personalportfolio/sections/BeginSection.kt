package org.example.personalportfolio.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.example.personalportfolio.components.Header
import org.example.personalportfolio.components.SocialBar
import org.example.personalportfolio.util.Res
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun BeginSection() {
    val breakpoint = rememberBreakpoint()
    Box(
        modifier = Modifier
            .height(
                when {
                    breakpoint >= Breakpoint.LG -> 43.percent
                    breakpoint >= Breakpoint.MD -> 32.percent
                    breakpoint >= Breakpoint.SM -> 22.percent
                    else -> 18.percent
                }
            )
            .fillMaxWidth(),
        contentAlignment = Alignment.TopCenter
    ) {
        Header(breakpoint)
        BeginContent(breakpoint)
    }
}

@Composable
fun BeginContent(breakpoint: Breakpoint) {
    Column(
        modifier = Modifier.fillMaxWidth()
            .margin(top = 122.px),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .fillMaxSize(35.percent),
            src = Res.Image.computer,
        )
        P(
            attrs = Modifier
                .fontSize(if(breakpoint >= Breakpoint.SM) 30.px else 20.px)
                .textAlign(TextAlign.Center)
                .fontFamily("Roboto")
                .fontWeight(FontWeight.Bold)
                .color(Colors.Gray)
                .toAttrs()
        )
        {
            Text("Desenvolvedor Mobile")
        }
        SocialBar()
    }
}