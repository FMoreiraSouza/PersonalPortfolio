package org.example.personalportfolio.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
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
import org.example.personalportfolio.models.Section
import org.example.personalportfolio.styles.DarkerPresentationColumnStyle
import org.example.personalportfolio.styles.LighterPresentationColumnStyle
import org.example.personalportfolio.util.Constants
import org.example.personalportfolio.util.Res
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun PresentationCard(animatedMargin: CSSSizeValue<CSSUnit.px>, section: Section) {
    val breakpoint = rememberBreakpoint()
    if (breakpoint >= Breakpoint.MD) {
        SimpleGrid(
            modifier = Modifier
                .fillMaxWidth(90.percent),
            numColumns = numColumns(base = 1, md = 2)
        ) {
            MyDescription(breakpoint, animatedMargin, section)
            MyProfessionalPhoto(breakpoint, animatedMargin, section)
        }
    } else {
        Column(
            modifier = Modifier
                .fillMaxWidth(80.percent),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MyDescription(breakpoint, animatedMargin, section)
            MyProfessionalPhoto(breakpoint, animatedMargin, section)
        }
    }
}

@Composable
fun MyDescription(breakpoint: Breakpoint, animatedMargin: CSSSizeValue<CSSUnit.px>, section: Section) {
    var colorMode by ColorMode.currentState
    Column(
        modifier = (if (colorMode.isLight) LighterPresentationColumnStyle.toModifier() else DarkerPresentationColumnStyle.toModifier())
            .margin(
                left = if (breakpoint <= Breakpoint.MD) {
                    if (section.id == Section.About.id) {
                        0.px
                    }
                    else {
                        animatedMargin
                    }
                }
                else {
                    animatedMargin
                }
            )
            .transition(
                CSSTransition(
                    property = "margin",
                    duration = 2.s,
                    delay = 100.ms
                )
            )
            .fillMaxWidth(),
        horizontalAlignment = if (breakpoint >= Breakpoint.MD) Alignment.Start else Alignment.CenterHorizontally
    ) {
        P(
            attrs = Modifier
                .fontSize(
                    when {
                        breakpoint > Breakpoint.MD -> 28.px
                        breakpoint > Breakpoint.SM -> 25.px
                        else -> 22.px
                    }
                )
                .fontFamily("Roboto")
                .textAlign(TextAlign.End)
                .fontWeight(FontWeight.Bolder)
                .color(if (colorMode.isLight) Colors.Gray else Colors.White)
                .toAttrs()
        )
        {
            Text("Prazer, Felipe Moreira")
        }
        P(
            attrs = Modifier
                .margin(bottom = if (breakpoint >= Breakpoint.MD) 0.px else 35.px)
                .fontSize(if (breakpoint >= Breakpoint.MD) 18.px else 14.px)
                .textAlign(if (breakpoint >= Breakpoint.MD) TextAlign.Left else TextAlign.Center)
                .fontFamily("Sans-Serif")
                .fontWeight(FontWeight.Normal)
                .color(if (colorMode.isLight) Colors.Black else Colors.White)
                .toAttrs()
        ) {
            Text(Constants.About)
        }
    }
}

@Composable
fun MyProfessionalPhoto(breakpoint: Breakpoint, animatedMargin: CSSSizeValue<CSSUnit.px>, section: Section) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .margin(
                    left = if (breakpoint <= Breakpoint.MD) {
                        if (section.id == Section.About.id) {
                            0.px
                        } else {
                            animatedMargin
                        }
                    } else {
                        animatedMargin
                    },
                    top = if (breakpoint >= Breakpoint.MD) 0.px else 5.px,
                )
                .transition(
                    CSSTransition(
                        property = "margin",
                        duration = 2.s,
                        delay = 100.ms
                    )
                )
                .padding(left = if (breakpoint >= Breakpoint.MD) 10.px else 0.px)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                modifier = Modifier
                    .size(if (breakpoint >= Breakpoint.MD) 300.px else 250.px),
                src = Res.Image.profilePhoto
            )
        }
    }
}