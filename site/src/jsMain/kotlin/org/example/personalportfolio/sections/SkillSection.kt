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
import org.example.personalportfolio.components.SectionTitle
import org.example.personalportfolio.components.SkillBar
import org.example.personalportfolio.models.Section
import org.example.personalportfolio.util.ObserveViewportEntered
import org.jetbrains.compose.web.css.px

@Composable
fun SkillSection() {
    Box(
        modifier = Modifier
            .id(Section.Skills.id)
            .margin(bottom = 40.px)
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        SkillContent()
    }
}

@Composable
fun SkillContent() {
    val scope = rememberCoroutineScope()
    var animatedMargin by remember{ mutableStateOf((-50).px) }
    ObserveViewportEntered(
        sectionId = Section.Skills.id,
        distanceFromTop = 500.0,
        onViewportEntered = {
            scope.launch {
                animatedMargin = 50.px
            }
        }
    )
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SectionTitle(section = Section.Skills)
        SkillBar(animatedMargin)
    }
}