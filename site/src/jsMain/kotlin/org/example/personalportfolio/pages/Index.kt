package org.example.personalportfolio.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.core.Page
import org.example.personalportfolio.sections.AcademicSection
import org.example.personalportfolio.sections.PresentationSection
import org.example.personalportfolio.sections.SkillSection

@Page
@Composable
fun HomePage() {
    Box(
        Modifier
            .fillMaxSize(),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            PresentationSection()
            SkillSection()
            AcademicSection()
        }
    }
}
