package org.example.personalportfolio.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.example.personalportfolio.models.Academic
import org.example.personalportfolio.styles.AcademicStyle
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun AcademicCard(
    academic: Academic
) {
    val colorMode by ColorMode.currentState
    val breakpoint = rememberBreakpoint()
    Column(
        modifier = AcademicStyle.toModifier()
            .fillMaxWidth(90.percent),
        horizontalAlignment = if(breakpoint > Breakpoint.SM) Alignment.Start else Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(250.px)
                .boxShadow(blurRadius = 5.px, spreadRadius = 3.px, color = Colors.Gray)
                .backgroundColor(Colors.White)
                .borderRadius(50.percent),
            contentAlignment = Alignment.Center
        ) {
        Image(
            modifier = Modifier,
            src = academic.coatOfArms
        )
            }
        P(
            attrs = Modifier
                .margin(top = 5.px)
                .color(Colors.Gray)
                .fontFamily("Roboto")
                .textAlign(if(breakpoint > Breakpoint.SM) TextAlign.Start else TextAlign.Center)
                .fontWeight(FontWeight.Bold)
                .fontSize(20.px)
                .toAttrs()
        ){
            Text(academic.title)
        }
        P(
            attrs = Modifier
                .margin(topBottom = 0.px)
                .color(Colors.Gray)
                .fontFamily("Roboto")
                .textAlign(if(breakpoint > Breakpoint.SM) TextAlign.Start else TextAlign.Center)
                .fontWeight(FontWeight.Bold)
                .fontSize(15.px)
                .toAttrs()
        ){
            Text(academic.subtitle)
        }
        P(
            attrs = Modifier
                .margin(top = 2.px)
                .color(if (colorMode.isLight) Colors.Black else Colors.White)
                .fontFamily("Sans-Serif")
                .textAlign(if(breakpoint > Breakpoint.SM) TextAlign.Start else TextAlign.Center)
                .fontWeight(FontWeight.Normal)
                .fontSize(12.px)
                .toAttrs()
        ){
            Text("${academic.from} - ${academic.to}")
        }
        Box(
            modifier = Modifier
                .margin(top = 4.px)
                .height(2.px)
                .width(100.percent)
                .borderRadius(50.px)
        )
    }
}