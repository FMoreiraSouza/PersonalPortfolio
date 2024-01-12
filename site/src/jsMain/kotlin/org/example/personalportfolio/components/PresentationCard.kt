package org.example.personalportfolio.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.varabyte.kobweb.compose.css.FontVariantAlternates
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
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun PresentationCard(){
    val breakpoint = rememberBreakpoint()
    if (breakpoint > Breakpoint.MD) {
        SimpleGrid(
            modifier = Modifier.fillMaxWidth(),
            numColumns = numColumns(base = 1, md = 2)
        ) {
            MyDescription(breakpoint)
            MyProfessionalPhoto(breakpoint)
        }
    } else {
        Column(
            modifier = Modifier
                .fillMaxWidth(80.percent),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MyDescription(breakpoint)
            MyProfessionalPhoto(breakpoint)
        }
    }
}

@Composable
fun MyDescription(breakpoint: Breakpoint) {
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
                    .margin(left = if (breakpoint > Breakpoint.MD) 200.px else 0.px)
                    .padding(right = 10.px)
                    .fontSize(
                        when {
                            breakpoint > Breakpoint.MD -> 28.px
                            breakpoint > Breakpoint.SM -> 25.px
                            else -> 22.px
                        }
                    )
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
                    .margin(left = if (breakpoint > Breakpoint.MD) 200.px else 0.px)
                    .padding(right = 10.px)
                    .fontSize(if (breakpoint >= Breakpoint.MD) 14.px else 12.px)
                    .fontFamily("Sans-Serif")
                    .fontVariant(FontVariantAlternates.Inherit)
                    .textAlign(TextAlign.Justify)
                    .fontWeight(FontWeight.Normal)
                    .color(if (colorMode.isLight) Colors.Black else Colors.White)
                    .toAttrs()
            ) {
                Text(Constants.About)
            }
        }
    }
}

@Composable
fun MyProfessionalPhoto(breakpoint: Breakpoint) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .margin(
                    right = if (breakpoint > Breakpoint.MD) 200.px else 0.px,
                    top = if (breakpoint > Breakpoint.MD) 0.px else 5.px
                )
                .padding(left = if (breakpoint > Breakpoint.MD) 10.px else 0.px),
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