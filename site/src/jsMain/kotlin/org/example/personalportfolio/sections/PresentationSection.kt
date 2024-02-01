package org.example.personalportfolio.sections

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.animation.toAnimation
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import kotlinx.coroutines.launch
import org.example.personalportfolio.components.PresentationCard
import org.example.personalportfolio.components.SectionTitle
import org.example.personalportfolio.models.Section
import org.example.personalportfolio.styles.ShowKeyFrames
import org.example.personalportfolio.styles.VanishKeyFrames
import org.example.personalportfolio.util.ObserveViewportEntered
import org.jetbrains.compose.web.css.AnimationTimingFunction
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.s

@Composable
fun PresentationSection() {
    Box(
        modifier = Modifier
            .id(Section.About.id)
            .fillMaxWidth(),
        contentAlignment = Alignment.TopCenter
    ) {
        PresentationContent()
    }
}

@Composable
fun PresentationContent() {
    val breakpoint = rememberBreakpoint()
    val scope = rememberCoroutineScope()
    var animatedMargin by remember { mutableStateOf((-50).px) }
    var animatedOpacity by remember { mutableStateOf(0.percent) }
    ObserveViewportEntered(
        sectionId = Section.About.id,
        distanceFromTop = 500.0,
        onViewportEntered = {
            scope.launch {
                animatedMargin = 0.px
                animatedOpacity = 100.percent
            }
        }
    )
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SectionTitle(
            modifier = Modifier
                .opacity(
                    if (breakpoint > Breakpoint.LG && breakpoint <= Breakpoint.XL) animatedOpacity
                    else 100.percent
                )
                .transition(
                    CSSTransition(
                        property = "opacity", duration = 2.s,
                        timingFunction = AnimationTimingFunction.EaseInOut
                    )
                )
                .animation(
                    if (breakpoint <= Breakpoint.LG) {
                        ShowKeyFrames
                            .toAnimation(
                                duration = 2.s,
                                timingFunction = AnimationTimingFunction.EaseInOut
                            )
                    }
                    else {
                        VanishKeyFrames.toAnimation()
                    }
                ),
            section = Section.About
        )
        PresentationCard(animatedMargin, animatedOpacity)
    }
}