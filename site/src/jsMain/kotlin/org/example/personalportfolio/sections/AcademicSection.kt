package org.example.personalportfolio.sections

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import kotlinx.coroutines.launch
import org.example.personalportfolio.components.AcademicCard
import org.example.personalportfolio.components.SectionTitle
import org.example.personalportfolio.models.Academic
import org.example.personalportfolio.models.Section
import org.example.personalportfolio.util.ObserveViewportEntered
import org.jetbrains.compose.web.css.AnimationTimingFunction
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.s

@Composable
fun AcademicSection() {
    Box(
        modifier = Modifier
            .id(Section.Academics.id)
            .margin(top = 50.px)
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
    var animatedOpacity by remember { mutableStateOf(0.percent) }
    ObserveViewportEntered(
        sectionId = Section.Academics.id,
        distanceFromTop = 500.0,
        onViewportEntered = {
            scope.launch {
                animatedMargin = 0.px
                animatedOpacity = 100.percent
            }
        }
    )
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SectionTitle(
            modifier = Modifier
                .opacity(animatedOpacity)
                .transition(
                    CSSTransition(
                        property = "opacity", duration = 1.s,
                        timingFunction = AnimationTimingFunction.EaseInOut
                    )
                ),
            section = Section.Academics
        )
        Academic.entries.forEach { academic ->
            AcademicCard(academic, animatedMargin)
        }
    }
}