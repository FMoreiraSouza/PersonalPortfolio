package org.example.personalportfolio.components

import androidx.compose.runtime.Composable
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
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.example.personalportfolio.models.Experience
import org.example.personalportfolio.models.Theme
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun ExperienceCard(experience: Experience) {
    val breakpoint = rememberBreakpoint()
    if (breakpoint > Breakpoint.MD) {
        SimpleGrid(
            modifier = Modifier.fillMaxWidth(90.percent),
            numColumns = numColumns(base = 1, md = 2)
        ) {
            ExperienceDescription(experience.description)
            ExperienceDetails(experience)
        }
    } else {
        SimpleGrid(
            modifier = Modifier.fillMaxWidth(95.percent),
            numColumns = numColumns(base = 1)
        ) {
            ExperienceDetails(experience)
            ExperienceDescription(experience.description)
        }
    }
}

@Composable
fun ExperienceDescription(
    description: String
) {
    val breakpoint = rememberBreakpoint()
    Box(
        modifier = Modifier
            .margin(right = 10.px, bottom = 5.px, top = 5.px)
            .padding(all = 14.px)
    ) {
        P(
            attrs = Modifier
                .margin(topBottom = 0.px)
                .fontFamily("Sans-Serif")
                .fontSize(if(breakpoint >= Breakpoint.SM) 14.px else 12.px)
                .textAlign(TextAlign.Justify)
                .lineHeight(1.7)
                .fontWeight(FontWeight.Normal)
                .color(Theme.Primary.rgb)
                .toAttrs()
        ) {
            Text(description)
        }
    }
}

@Composable
fun ExperienceDetails(
    experience: Experience
) {
    val breakpoint = rememberBreakpoint()
    if (breakpoint > Breakpoint.MD) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .margin(left = 20.px),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            ExperienceIcon(experience)
            Column(
                Modifier
                    .margin(0.px)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center
            ) {
                P(
                    attrs = Modifier
                        .margin(topBottom = 0.px)
                        .fontFamily("Sans-Serif")
                        .fontSize(20.px)
                        .fontWeight(FontWeight.Bold)
                        .color(Theme.Primary.rgb)
                        .toAttrs()
                ) {
                    Text(experience.jobPosition)
                }
                P(
                    attrs = Modifier
                        .margin(topBottom = 0.px)
                        .fontFamily("Sans-Serif")
                        .fontSize(10.px)
                        .fontWeight(FontWeight.Normal)
                        .color(Theme.Primary.rgb)
                        .toAttrs()
                ) {
                    Text("${experience.from} - ${experience.to}")
                }
                P(
                    attrs = Modifier
                        .margin(topBottom = 0.px)
                        .fontFamily("Sans-Serif")
                        .fontSize(10.px)
                        .fontWeight(FontWeight.Bold)
                        .color(Colors.RoyalBlue)
                        .toAttrs()
                ) {
                    Text(experience.company)
                }
            }

        }
    } else {
        Column(
            Modifier,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ExperienceIcon(experience)
            P(
                attrs = Modifier
                    .margin(top = 5.px)
                    .fontFamily("Sans-Serif")
                    .textAlign(TextAlign.Center)
                    .fontSize(18.px)
                    .fontWeight(FontWeight.Bold)
                    .color(Theme.Primary.rgb)
                    .toAttrs()
            ) {
                Text(experience.jobPosition)
            }
            P(
                attrs = Modifier
                    .margin(top = 5.px)
                    .fontFamily("Sans-Serif")
                    .textAlign(TextAlign.Center)
                    .fontSize(10.px)
                    .fontWeight(FontWeight.Normal)
                    .color(Theme.Primary.rgb)
                    .toAttrs()
            ) {
                Text("${experience.from} - ${experience.to}")
            }
            P(
                attrs = Modifier
                    .margin(top = 5.px)
                    .fontFamily("Sans-Serif")
                    .textAlign(TextAlign.Center)
                    .fontSize(10.px)
                    .fontWeight(FontWeight.Bold)
                    .color(Colors.RoyalBlue)
                    .toAttrs()
            ) {
                Text(experience.company)
            }
        }
    }
}

@Composable
fun ExperienceIcon(
    experience: Experience
) {
    val breakpoint = rememberBreakpoint()
    Box(
        modifier = Modifier
            .fillMaxHeight()
            .width(3.px)
            .margin(
                right = if (breakpoint > Breakpoint.MD) 50.px else 0.px
            )
            .backgroundColor(Colors.RoyalBlue),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .size(60.px)
                .boxShadow(blurRadius = 5.px, spreadRadius = 3.px, color = Colors.Gray)
                .backgroundColor(Colors.White)
                .borderRadius(50.percent),
            contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = Modifier
                    .size(50.px),
                src = experience.icon
            )
        }
    }
}