package org.example.personalportfolio.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.padding
import org.example.personalportfolio.components.ProjectCard
import org.example.personalportfolio.components.SectionTitle
import org.example.personalportfolio.models.Project
import org.example.personalportfolio.models.Section
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

@Composable
fun ProjectSection() {
    Box(
        modifier = Modifier
            .id(Section.Projects.id)
            .fillMaxWidth(80.percent)
            .padding(topBottom = 20.px),
        contentAlignment = Alignment.Center
    ) {
        ProjectContent()
    }
}

@Composable
fun ProjectContent() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SectionTitle(
            section = Section.Projects
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            Project.values().forEach {project ->
                ProjectCard(project = project)
            }
        }
    }
}