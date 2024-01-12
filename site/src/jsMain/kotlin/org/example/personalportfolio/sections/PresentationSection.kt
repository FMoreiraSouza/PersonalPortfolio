package org.example.personalportfolio.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.id
import org.example.personalportfolio.components.PresentationCard
import org.example.personalportfolio.components.SectionTitle
import org.example.personalportfolio.models.Section

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
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SectionTitle(
            section = Section.About
        )
        PresentationCard()
    }
}