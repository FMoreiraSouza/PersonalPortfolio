package org.example.personalportfolio.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.id
import org.example.personalportfolio.components.SectionTitle
import org.example.personalportfolio.components.SkillBar
import org.example.personalportfolio.models.Section

@Composable
fun SkillSection() {
    Box(
        modifier = Modifier
            .id(Section.Skills.id)
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        SkillContent()
    }
}

@Composable
fun SkillContent() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SectionTitle(
            section = Section.Skills
        )
        SkillBar()
    }
}