package org.example.personalportfolio.sections

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import kotlinx.coroutines.launch
import org.example.personalportfolio.components.ProjectCard
import org.example.personalportfolio.components.SectionTitle
import org.example.personalportfolio.models.Project
import org.example.personalportfolio.models.Section
import org.example.personalportfolio.util.ObserveViewportEntered
import org.jetbrains.compose.web.css.AnimationTimingFunction
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.s

@Composable
fun ProjectSection() {
    val breakpoint = rememberBreakpoint()
    Box(
        modifier = Modifier
            .id(Section.Projects.id)
            .margin(top = if(breakpoint >= Breakpoint.MD) 50.px else 0.px)
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        ProjectContent()
    }
}

@Composable
fun ProjectContent() {
    val breakpoint = rememberBreakpoint()
    val scope = rememberCoroutineScope()
    var animatedMargin by remember { mutableStateOf((-1000).px) }
    var animatedOpacity by remember { mutableStateOf(0.percent) }
    ObserveViewportEntered(
        sectionId = Section.Projects.id,
        distanceFromTop = if(breakpoint > Breakpoint.LG || breakpoint < Breakpoint.MD) 500.0 else 1000.0,
        onViewportEntered = {
            scope.launch {
                animatedMargin = 0.px
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
                        property = "opacity", duration = 2.s,
                        timingFunction = AnimationTimingFunction.EaseInOut
                    )
                ),
            section = Section.Projects
        )
        if (breakpoint > Breakpoint.MD) {
            SimpleGrid(
                modifier = Modifier
                    .fillMaxWidth(),
                numColumns = numColumns(base = 1, md = 3)
            ) {
                Project.entries.forEach { project ->
                    ProjectCard(project, breakpoint, animatedMargin)
                }
            }
        }
        else {
            SimpleGrid(
                modifier = Modifier
                    .fillMaxWidth(),
                numColumns = numColumns(base = 1, sm = 2)
            ) {
                Project.entries.forEach { project ->
                    ProjectCard(project, breakpoint, animatedMargin)
                }
            }
        }
    }
}