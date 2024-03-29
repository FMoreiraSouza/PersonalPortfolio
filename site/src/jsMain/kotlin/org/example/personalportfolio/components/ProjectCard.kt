package org.example.personalportfolio.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color.Companion.argb
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.example.personalportfolio.models.Project
import org.example.personalportfolio.styles.PortfolioStyle
import org.example.personalportfolio.util.Res
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun ProjectCard(
    breakpoint: Breakpoint,
    project: Project,
    animatedMargin: CSSSizeValue<CSSUnit.px>
) {
    val colorMode by ColorMode.currentState
    Column(
        modifier = Modifier
            .margin(
                top = 25.px,
                left = animatedMargin
            )
            .transition(
                CSSTransition(
                    property = "margin", duration = 1.s,
                    timingFunction = AnimationTimingFunction.EaseInOut
                )
            )
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = PortfolioStyle.toModifier().size(if (breakpoint > Breakpoint.SM) 300.px else 225.px),
            verticalAlignment = Alignment.CenterVertically
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
                        modifier = Modifier.size(if (breakpoint > Breakpoint.SM) 300.px else 225.px),
                        src = project.image
                    )
                    Box(
                        modifier = Modifier
                            .id("blueCurtain")
                            .fillMaxHeight()
                            .backgroundColor(
                                if (colorMode.isLight) argb(0.2f, 135, 206, 235)
                                else argb(0.2f, 65, 105, 225)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            modifier = Modifier
                                .size(30.px)
                                .id("linkIcon"),
                            src = Res.Icon.redirect
                        )
                    }
                }
                P(
                    attrs = Modifier
                        .id("projectTitle")
                        .fillMaxWidth(95.percent)
                        .margin(topBottom = 0.px)
                        .textAlign(TextAlign.Start)
                        .fontFamily("Roboto")
                        .fontWeight(FontWeight.Bold)
                        .fontSize(if (breakpoint >= Breakpoint.SM) 20.px else 18.px)
                        .toAttrs()
                ) {
                    Text(project.title)
                }
                P(
                    attrs = Modifier
                        .id("projectPlatform")
                        .fillMaxWidth(95.percent)
                        .margin(topBottom = 0.px)
                        .textAlign(TextAlign.Start)
                        .color(if (colorMode.isLight) Colors.Gray else Colors.LightGray)
                        .fontFamily("Roboto")
                        .fontWeight(FontWeight.Normal)
                        .fontSize(if (breakpoint >= Breakpoint.SM) 18.px else 16.px)
                        .toAttrs()
                ) {
                    Text(project.platform)
                }
            }
        }
    }
}