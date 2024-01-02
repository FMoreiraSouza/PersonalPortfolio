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
import org.example.personalportfolio.models.Experience
import org.example.personalportfolio.models.Theme
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun ExperienceCard(experience: Experience) {
    SimpleGrid(
        modifier = Modifier.fillMaxWidth(),
        numColumns = numColumns(base = 1, md = 2)
    ) {
        ExperienceDescription(experience.description)
        ExperienceDetails(experience)
    }
}

@Composable
fun ExperienceDescription(
    description: String
) {
    Box(
        modifier = Modifier
            .margin(topBottom = 5.px)
            .padding(all = 14.px)
    ) {
        P(
            attrs = Modifier
                .margin(topBottom = 0.px)
                .fontFamily("Montserrat", "sans-serif")
                .fontSize(20.px)
                .textAlign(TextAlign.Justify)
                .lineHeight(1.6)
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
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .margin(left = 14.px),
        verticalAlignment = Alignment.CenterVertically
    ) {
        ExperienceIcon(experience)
        Column(
            Modifier
                .fillMaxSize()
                .margin(left = 0.px),
            verticalArrangement = Arrangement.Center
        ) {
            P(
                attrs = Modifier
                    .margin(topBottom = 0.px)
                    .fontFamily("Montserrat", "sans-serif")
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
                    .fontFamily("Montserrat", "sans-serif")
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
                    .fontFamily("Montserrat", "sans-serif")
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
    Box(
        modifier = Modifier
            .fillMaxHeight()
            .width(3.px)
            .margin(left = 20.px, right = 45.px)
            .backgroundColor(Colors.RoyalBlue),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .size(60.px)
                .border(
                    width = 1.px,
                    style = LineStyle.Solid,
                    color = Colors.Black
                )
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