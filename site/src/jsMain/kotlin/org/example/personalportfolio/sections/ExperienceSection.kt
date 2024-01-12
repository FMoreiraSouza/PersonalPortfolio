package org.example.personalportfolio.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.id
import org.example.personalportfolio.components.ExperienceCard
import org.example.personalportfolio.components.SectionTitle
import org.example.personalportfolio.models.Experience
import org.example.personalportfolio.models.Section

@Composable
fun ExperienceSection() {
    Box(
        modifier = Modifier
            .id(Section.Experiences.id)
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        ExperienceContent()
    }
}

@Composable
fun ExperienceContent() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SectionTitle(
            section = Section.Experiences
        )
        Experience.values().forEach { experience ->
            ExperienceCard(
                experience
            )
        }
    }
}