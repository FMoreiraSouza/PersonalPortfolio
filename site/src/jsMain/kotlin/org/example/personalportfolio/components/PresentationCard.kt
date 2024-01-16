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
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.example.personalportfolio.util.Constants
import org.example.personalportfolio.util.Res
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun PresentationCard(animatedMargin: CSSSizeValue<CSSUnit.px>) {
    val breakpoint = rememberBreakpoint()
    if (breakpoint > Breakpoint.MD) {
        SimpleGrid(
            modifier = Modifier
                .fillMaxWidth(),
            numColumns = numColumns(base = 1, md = 2)
        ) {
            MyDescription(breakpoint, animatedMargin)
            MyProfessionalPhoto(breakpoint, animatedMargin)
        }
    } else {
        Column(
            modifier = Modifier
                .fillMaxWidth(80.percent),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MyDescription(breakpoint, animatedMargin)
            MyProfessionalPhoto(breakpoint, animatedMargin)
        }
    }
}

@Composable
fun MyDescription(breakpoint: Breakpoint, animatedMargin: CSSSizeValue<CSSUnit.px>) {
    var colorMode by ColorMode.currentState
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = if (breakpoint > Breakpoint.MD) Alignment.Start else Alignment.CenterHorizontally
        ) {
            P(
                attrs = Modifier
                    .margin(left = if (breakpoint > Breakpoint.MD) animatedMargin * 2 else 0.px)
                    .padding(right = 10.px)
                    .fontSize(
                        when {
                            breakpoint > Breakpoint.MD -> 28.px
                            breakpoint > Breakpoint.SM -> 25.px
                            else -> 22.px
                        }
                    )
                    .transition(
                        CSSTransition(
                            property = "margin",
                            duration = 1.s,
                            delay = 100.ms
                        )
                    )
//                    .fillMaxWidth()
                    .fontFamily("Roboto")
                    .fontWeight(FontWeight.Bolder)
                    .color(Colors.Gray)
                    .toAttrs()
            )
            {
                Text("Prazer, Felipe Moreira")
            }
            P(
                attrs = Modifier
                    .margin(
                        left = if (breakpoint > Breakpoint.MD) 200.px else 0.px,
                        bottom = if (breakpoint > Breakpoint.MD) animatedMargin else 0.px
                    )
                    .padding(right = 10.px)
                    .fillMaxWidth(if (breakpoint >= Breakpoint.MD) 80.percent else 100.percent)
                    .fontSize(if (breakpoint >= Breakpoint.MD) 18.px else 14.px)
                    .textAlign(if (breakpoint > Breakpoint.MD) TextAlign.Left else TextAlign.Center)
                    .fontFamily("Sans-Serif")
                    .fontWeight(FontWeight.Normal)
                    .transition(
                        CSSTransition(
                            property = "margin",
                            duration = 1.s,
                            delay = 100.ms
                        )
                    )
                    .color(if (colorMode.isLight) Colors.Black else Colors.White)
                    .toAttrs()
            ) {
                Text(Constants.About)
            }
        }
    }
}

@Composable
fun MyProfessionalPhoto(breakpoint: Breakpoint, animatedMargin: CSSSizeValue<CSSUnit.px>) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .margin(
                    right = if (breakpoint > Breakpoint.MD) 200.px else 0.px,
                    top = if (breakpoint > Breakpoint.MD) 0.px else 5.px,
                )
                .padding(left = if (breakpoint > Breakpoint.MD) 10.px else 0.px),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                modifier = Modifier
                    .margin(left = if (breakpoint > Breakpoint.MD) animatedMargin else 0.px)
                    .transition(
                        CSSTransition(
                            property = "margin",
                            duration = 1.s,
                            delay = 100.ms
                        )
                    )
                    .size(if (breakpoint >= Breakpoint.MD) 300.px else 250.px),
                src = Res.Image.profilePhoto
            )
        }
    }
}