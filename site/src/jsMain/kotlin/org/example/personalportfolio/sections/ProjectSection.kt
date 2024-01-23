package org.example.personalportfolio.sections

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.margin
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
import org.jetbrains.compose.web.css.px

@Composable
fun ProjectSection() {
    Box(
        modifier = Modifier
            .id(Section.Projects.id)
            .margin(bottom = 40.px)
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
    var animatedMargin by remember { mutableStateOf((-400).px) }
    ObserveViewportEntered(
        sectionId = Section.About.id,
        distanceFromTop = 5.0,
        onViewportEntered = {
            scope.launch {
                animatedMargin = 0.px
            }
        }
    )
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SectionTitle(section = Section.Projects)
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
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
            } else {
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
}