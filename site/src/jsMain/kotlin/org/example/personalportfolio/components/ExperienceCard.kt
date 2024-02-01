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
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.example.personalportfolio.models.Experience
import org.example.personalportfolio.styles.PresentationStyle
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun ExperienceCard(
    experience: Experience,
    animatedOpacity: CSSSizeValue<CSSUnit.percent>
) {
    val breakpoint = rememberBreakpoint()
    SimpleGrid(
        modifier = Modifier
            .opacity(animatedOpacity)
            .transition(
                CSSTransition(
                    property = "opacity", duration = 2.s,
                    timingFunction = AnimationTimingFunction.EaseInOut
                )
            )
            .fillMaxWidth(90.percent),
        numColumns = numColumns(base = 1, md = 2)
    ) {
        if (breakpoint >= Breakpoint.MD) {
            ExperienceDescription(experience.description, breakpoint)
            ExperienceDetails(experience, breakpoint)
        } else {
            ExperienceDetails(experience, breakpoint)
            ExperienceDescription(experience.description, breakpoint)
        }
    }
}

@Composable
fun ExperienceDescription(
    description: String,
    breakpoint: Breakpoint,
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
                .textAlign(if (breakpoint >= Breakpoint.MD) TextAlign.Left else TextAlign.Center)
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
    experience: Experience,
    breakpoint: Breakpoint,
) {
    val colorMode by ColorMode.currentState
    if (breakpoint >= Breakpoint.MD) {
        Row(
            modifier = Modifier.fillMaxWidth(90.percent),
            verticalAlignment = Alignment.CenterVertically,
        )
        {
            ExperienceIcon(experience, breakpoint)
            Column(
                Modifier
                    .margin(0.px)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center
            ) {
                P(
                    attrs = Modifier
                        .margin(topBottom = 0.px)
                        .fontFamily("Roboto")
                        .fontSize(22.px)
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
                        .fontSize(18.px)
                        .fontWeight(FontWeight.Bold)
                        .color(if (colorMode.isLight) Colors.SkyBlue else Colors.RoyalBlue)
                        .toAttrs()
                ) {
                    Text(experience.company)
                }
                P(
                    attrs = Modifier
                        .margin(topBottom = 0.px)
                        .fontFamily("Sans-Serif")
                        .fontSize(14.px)
                        .fontWeight(FontWeight.Normal)
                        .color(if (colorMode.isLight) Colors.Gray else Colors.LightGray)
                        .toAttrs()
                ) {
                    Text("${experience.from} - ${experience.to}")
                }
            }
        }
    } else {
        Column(
            Modifier,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ExperienceIcon(experience, breakpoint)
            P(
                attrs = Modifier
                    .margin(topBottom = 0.px)
                    .fontFamily("Roboto")
                    .textAlign(TextAlign.Center)
                    .fontSize(20.px)
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
                    .textAlign(TextAlign.Center)
                    .fontSize(14.px)
                    .fontWeight(FontWeight.Bold)
                    .color(if (colorMode.isLight) Colors.SkyBlue else Colors.RoyalBlue)
                    .toAttrs()
            ) {
                Text(experience.company)
            }
            P(
                attrs = Modifier
                    .margin(topBottom = 0.px)
                    .fontFamily("Sans-Serif")
                    .textAlign(TextAlign.Center)
                    .fontSize(10.px)
                    .fontWeight(FontWeight.Normal)
                    .color(if (colorMode.isLight) Colors.Gray else Colors.LightGray)
                    .toAttrs()
            ) {
                Text("${experience.from} - ${experience.to}")
            }
        }
    }
}

@Composable
fun ExperienceIcon(
    experience: Experience,
    breakpoint: Breakpoint,
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
                .boxShadow(
                    blurRadius = 5.px,
                    spreadRadius = 3.px,
                    color = if (colorMode.isLight) Colors.LightGray else Colors.Gray
                )
                .backgroundColor(Colors.White)
                .borderRadius(50.percent),
            contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = Modifier.size(50.px),
                src = experience.icon
            )
        }
    }
}