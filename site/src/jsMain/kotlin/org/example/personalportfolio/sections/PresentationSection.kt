package org.example.personalportfolio.sections

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.margin
import kotlinx.coroutines.launch
import org.example.personalportfolio.components.PresentationCard
import org.example.personalportfolio.components.SectionTitle
import org.example.personalportfolio.models.Section
import org.example.personalportfolio.util.ObserveViewportEntered
import org.jetbrains.compose.web.css.px

@Composable
fun PresentationSection() {
    Box(
        modifier = Modifier
            .id(Section.About.id)
            .margin(bottom = 50.px)
            .fillMaxWidth(),
        contentAlignment = Alignment.TopCenter
    ) {
        PresentationContent()
    }
}

@Composable
fun PresentationContent() {
    val section = Section.About
    val scope = rememberCoroutineScope()
    var animatedMargin by remember { mutableStateOf((-50).px) }
    ObserveViewportEntered(
        sectionId = Section.About.id,
        distanceFromTop = 500.0,
        onViewportEntered = {
            scope.launch {
                animatedMargin = 0.px
            }
        }
    )
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SectionTitle(section = Section.About)
        PresentationCard(animatedMargin, section)
    }
}