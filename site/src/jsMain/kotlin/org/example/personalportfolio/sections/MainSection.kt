package org.example.personalportfolio.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import org.example.personalportfolio.components.Header
import org.example.personalportfolio.components.SocialBar
import org.example.personalportfolio.util.Constants.FONT_FAMILY
import org.example.personalportfolio.util.Res
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun MainSection() {
    Box(
        modifier = Modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.TopCenter
    ) {
        Header()
        MainContent()
    }
}

@Composable
fun MainContent() {
    Column(
        modifier = Modifier.fillMaxWidth()
            .margin(topBottom = 100.px),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .fillMaxSize(30.percent)
                .transition(CSSTransition(property = "background", duration = 100.ms)),
            src = Res.Icon.computer
        )
        P(
            attrs = Modifier
                .margin(bottom = 20.px)
                .fontSize(30.px)
                .fontFamily(FONT_FAMILY)
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