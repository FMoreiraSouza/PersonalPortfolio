package org.example.personalportfolio.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color.Companion.argb
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.toModifier
import org.example.personalportfolio.models.Project
import org.example.personalportfolio.styles.PortfolioStyle
import org.example.personalportfolio.util.Constants
import org.example.personalportfolio.util.Res
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun ProjectCard(
    project: Project,
) {
    Column(
        modifier = PortfolioStyle.toModifier()
    ) {
        Link(
            modifier = Modifier
                .id("linkParent")
                .textDecorationLine(TextDecorationLine.None),
            path = project.link,
            openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB,
        ) {
            Box(
                modifier = Modifier
                    .id("boxParent")
                    .fillMaxWidth(),
            ) {
                Image(
                    modifier = Modifier
                        .size(300.px),
                    src = project.image
                )
                Box(
                    modifier = Modifier
                        .backgroundColor(Colors.Blue)
                        .id("blueCurtain")
                        .fillMaxHeight()
                        .backgroundColor(argb(0.5f, 135, 206, 235)),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        modifier = Modifier
                            .id("linkIcon"),
                        src = Res.Icon.redirect
                    )
                }
            }
            P(
                attrs = Modifier
                    .id("projectTitle")
                    .margin(topBottom = 0.px)
                    .textAlign(TextAlign.Start)
                    .fontFamily(Constants.FONT_FAMILY)
                    .fontWeight(FontWeight.Bold)
                    .fontSize(20.px)
                    .toAttrs()
            ) {
                Text(project.title)
            }
            P(
                attrs = Modifier
                    .id("projectPlatform")
                    .margin(topBottom = 0.px)
                    .textAlign(TextAlign.Start)
                    .color(Colors.Gray)
                    .fontFamily(Constants.FONT_FAMILY)
                    .fontWeight(FontWeight.Normal)
                    .fontSize(18.px)
                    .toAttrs()
            ) {
                Text(project.platform)
            }
        }
    }
}