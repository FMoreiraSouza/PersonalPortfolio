package org.example.personalportfolio.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.id
import org.example.personalportfolio.components.AcademicCard
import org.example.personalportfolio.components.SectionTitle
import org.example.personalportfolio.models.Academics
import org.example.personalportfolio.models.Section
import org.jetbrains.compose.web.css.percent

@Composable
fun AcademicSection() {
    Box(
        modifier = Modifier
            .id(Section.Academics.id)
//            .margin(bottom = 50.px)
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        AcademicContent()
    }
}

@Composable
fun AcademicContent() {
    Column(
        modifier = Modifier
            .fillMaxWidth(90.percent),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SectionTitle(
            section = Section.Academics
        )
        AcademicCard(academics = Academics.Bachelor)
    }
}