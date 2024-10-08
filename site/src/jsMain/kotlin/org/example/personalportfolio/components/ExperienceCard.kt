package org.example.personalportfolio.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.example.personalportfolio.models.Experience
import org.example.personalportfolio.styles.PresentationStyle
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun ExperienceCard(
    breakpoint: Breakpoint,
    experience: Experience,
    animatedOpacity: CSSSizeValue<CSSUnit.percent>
) {
    SimpleGrid(
        modifier = Modifier
            .opacity(animatedOpacity)
            .transition(
                CSSTransition(
                    property = "opacity", duration = 1.s,
                    timingFunction = AnimationTimingFunction.EaseInOut
                )
            )
            .fillMaxWidth(90.percent),
        numColumns = numColumns(base = 1, md = 2)
    ) {
        if (breakpoint >= Breakpoint.MD) {
            ExperienceDescription(breakpoint, experience.description)
            Row(
                modifier = Modifier.fillMaxWidth(90.percent),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                ExperienceIcon(breakpoint, experience)
                Column(
                    Modifier
                        .margin(0.px)
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center
                ) {
                    ExperienceDetails(breakpoint, experience)
                }
            }
        }
        else {
            Column(
                Modifier,
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ExperienceIcon(breakpoint, experience)
                ExperienceDetails(breakpoint, experience)
            }
            ExperienceDescription(breakpoint, experience.description)
        }
    }
}

@Composable
fun ExperienceDescription(
    breakpoint: Breakpoint,
    description: String
) {
    val colorMode by ColorMode.currentState
    Column(
        modifier = PresentationStyle.toModifier()
            .fillMaxWidth(if (breakpoint >= Breakpoint.MD) 90.percent else 100.percent)
            .margin(
                left = if (breakpoint > Breakpoint.MD) 10.px else 0.px,
                bottom = if (breakpoint >= Breakpoint.MD) 5.px else 10.px,
                top = 5.px
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        P(
            attrs = Modifier
                .margin(topBottom = 0.px)
                .fontFamily("Sans-Serif")
                .fontSize(if (breakpoint >= Breakpoint.SM) 18.px else 14.px)
                .textAlign(if (breakpoint >= Breakpoint.MD) TextAlign.Justify else TextAlign.Center)
                .lineHeight(1.7)
                .fontWeight(FontWeight.Normal)
                .color(if (colorMode.isLight) Colors.Black else Colors.White)
                .toAttrs()
        ) {
            Text(description)
        }
    }
}

@Composable
fun ExperienceDetails(
    breakpoint: Breakpoint,
    experience: Experience
) {
    val colorMode by ColorMode.currentState
    P(
        attrs = Modifier
            .margin(topBottom = 0.px)
            .fontFamily("Roboto")
            .textAlign(if (breakpoint >= Breakpoint.MD) TextAlign.Start else TextAlign.Center)
            .fontSize(if (breakpoint >= Breakpoint.MD) 22.px else 20.px)
            .fontWeight(FontWeight.Bold)
            .color(if (colorMode.isLight) Colors.Black else Colors.White)
            .toAttrs()
    ) {
        Text(experience.jobPosition)
    }
    P(
        attrs = Modifier
            .margin(topBottom = 0.px)
            .fontFamily("Roboto")
            .textAlign(if (breakpoint >= Breakpoint.MD) TextAlign.Start else TextAlign.Center)
            .fontSize(if (breakpoint >= Breakpoint.MD) 18.px else 14.px)
            .fontWeight(FontWeight.Bold)
            .color(if (colorMode.isLight) Colors.SkyBlue else Colors.RoyalBlue)
            .toAttrs()
    ) {
        Text(experience.company)
    }
    P(
        attrs = Modifier
            .margin(top = if(breakpoint >= Breakpoint.MD) 4.px else 2.px)
            .fontFamily("Sans-Serif")
            .textAlign(if (breakpoint >= Breakpoint.MD) TextAlign.Start else TextAlign.Center)
            .fontSize(if (breakpoint >= Breakpoint.MD) 14.px else 10.px)
            .fontWeight(FontWeight.Normal)
            .color(if (colorMode.isLight) Colors.Gray else Colors.LightGray)
            .toAttrs()
    ) {
        Text("${experience.from} - ${experience.to}")
    }
}

@Composable
fun ExperienceIcon(
    breakpoint: Breakpoint,
    experience: Experience
) {
    val colorMode by ColorMode.currentState
    Box(
        modifier = Modifier
            .fillMaxHeight()
            .width(2.px)
            .margin(
                left = if (breakpoint > Breakpoint.MD) 4.px else if (breakpoint == Breakpoint.MD) 8.px else 0.px,
                right = if (breakpoint >= Breakpoint.MD) 45.px else 0.px,
                bottom = if (breakpoint >= Breakpoint.MD) 0.px else 5.px,
            )
            .backgroundColor(if (colorMode.isLight) Colors.SkyBlue else Colors.RoyalBlue),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .size(70.px)
                .then(if (colorMode.isLight) Modifier.border(color = Colors.LightGray, width = 1.px, style = LineStyle.Ridge) else Modifier)
                .backgroundColor(if (colorMode.isLight) Colors.White else Colors.LightGray)
                .borderRadius(50.percent),
            contentAlignment = Alignment.Center
        )
        {
            Image(
                modifier = Modifier.size(50.px),
                src = experience.icon
            )
        }
    }
}