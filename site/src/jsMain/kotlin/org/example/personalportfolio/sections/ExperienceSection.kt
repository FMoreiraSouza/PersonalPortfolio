package org.example.personalportfolio.sections

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import kotlinx.coroutines.launch
import org.example.personalportfolio.components.ExperienceCard
import org.example.personalportfolio.components.SectionTitle
import org.example.personalportfolio.models.Experience
import org.example.personalportfolio.models.Section
import org.example.personalportfolio.util.ObserveViewportEntered
import org.jetbrains.compose.web.css.AnimationTimingFunction
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.s

@Composable
fun ExperienceSection() {
    val breakpoint = rememberBreakpoint()
    Box(
        modifier = Modifier
            .id(Section.Experiences.id)
            .margin(top = if (breakpoint >= Breakpoint.MD) 50.px else 0.px)
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        ExperienceContent()
    }
}

@Composable
fun ExperienceContent() {
    val breakpoint = rememberBreakpoint()
    val scope = rememberCoroutineScope()
    var animatedOpacity by remember { mutableStateOf(0.percent) }
    ObserveViewportEntered(
        sectionId = Section.Experiences.id,
        distanceFromTop = if (breakpoint > Breakpoint.LG || breakpoint < Breakpoint.MD) 500.0 else 1200.0,
        onViewportEntered = {
            scope.launch {
                animatedOpacity = 100.percent
            }
        }
    )
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SectionTitle(
            modifier = Modifier
                .opacity(animatedOpacity)
                .transition(
                    CSSTransition(
                        property = "opacity", duration = 1.s,
                        timingFunction = AnimationTimingFunction.EaseInOut
                    )
                ),
            section = Section.Experiences
        )
        Experience.entries.forEach { experience ->
            ExperienceCard(experience, animatedOpacity)
        }
    }
}