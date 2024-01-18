package org.example.personalportfolio.sections

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.margin
import kotlinx.coroutines.launch
import org.example.personalportfolio.components.AcademicCard
import org.example.personalportfolio.components.SectionTitle
import org.example.personalportfolio.models.Academic
import org.example.personalportfolio.models.Section
import org.example.personalportfolio.util.ObserveViewportEntered
import org.jetbrains.compose.web.css.px

@Composable
fun AcademicSection() {
    Box(
        modifier = Modifier
            .id(Section.Academics.id)
            .margin(bottom = 50.px)
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        AcademicContent()
    }
}

@Composable
fun AcademicContent() {
    val scope = rememberCoroutineScope()
    var animatedMargin by remember { mutableStateOf((-2020).px) }
    ObserveViewportEntered(
        sectionId = Section.About.id,
        distanceFromTop = 50.0,
        onViewportEntered = {
            scope.launch {
                animatedMargin = 0.px
            }
        }
    )
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SectionTitle(section = Section.Academics)
        Academic.entries.forEach { academic ->
            AcademicCard(academic, animatedMargin)
        }
    }
}