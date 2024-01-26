package org.example.personalportfolio.sections

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.animation.toAnimation
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.example.personalportfolio.components.Header
import org.example.personalportfolio.components.SocialBar
import org.example.personalportfolio.styles.AppearMoveKeyFrames
import org.example.personalportfolio.styles.ShowKeyFrames
import org.example.personalportfolio.util.Res
import org.jetbrains.compose.web.css.AnimationTimingFunction
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.s
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun BeginSection(
    onMenuClicked: () -> Unit
) {
    val breakpoint = rememberBreakpoint()
    Box(
        modifier = Modifier
            .margin(bottom = if (breakpoint > Breakpoint.MD) 35.px else 0.px)
            .height(
                when {
                    breakpoint >= Breakpoint.LG -> 43.percent
                    breakpoint >= Breakpoint.MD -> 32.percent
                    breakpoint >= Breakpoint.SM -> 22.percent
                    else -> 18.percent
                }
            )
            .fillMaxWidth(),
        contentAlignment = Alignment.TopCenter
    ) {
        Header(breakpoint, onMenuClicked)
        BeginContent(breakpoint)
    }
}

@Composable
fun BeginContent(
    breakpoint: Breakpoint,
) {
    val colorMode by ColorMode.currentState
    Column(
        modifier = Modifier.fillMaxWidth()
            .margin(
                top = 122.px,
            ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (breakpoint >= Breakpoint.SM) {
            Image(
                modifier = Modifier
                    .animation(
                        AppearMoveKeyFrames
                            .toAnimation(
                                duration = 1.s,
                                timingFunction = AnimationTimingFunction.EaseInOut
                            )
                    ),
                src = Res.Image.computer,
            )
        }
        else {
            Image(
                modifier = Modifier
                    .animation(
                        AppearMoveKeyFrames
                            .toAnimation(
                                duration = 1.s,
                                timingFunction = AnimationTimingFunction.EaseInOut
                            )
                    )
                    .width(235.px),
                src = Res.Image.computer
            )
        }
        P(
            attrs = Modifier
                .animation(
                    ShowKeyFrames
                        .toAnimation(
                            duration = 1.s,
                            timingFunction = AnimationTimingFunction.EaseInOut
                        )
                )
                .margin(bottom = 18.px)
                .fontSize(if (breakpoint >= Breakpoint.SM) 40.px else 30.px)
                .textAlign(TextAlign.Center)
                .fontFamily("Roboto")
                .fontWeight(FontWeight.Bold)
                .color(if(colorMode.isLight) Colors.Gray else Colors.LightGray)
                .toAttrs()
        )
        {
            Text("Desenvolvedor")
        }
        SocialBar()
    }
}