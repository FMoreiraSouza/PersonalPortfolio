package org.example.personalportfolio.pages

import androidx.compose.runtime.*
import com.binayshaw7777.kotfolio.components.widgets.ButtonToTop
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.isExporting
import com.varabyte.kobweb.core.rememberPageContext
import org.example.personalportfolio.components.MenuBar
import org.example.personalportfolio.sections.*

@Page
@Composable
fun HomePage() {
    var menuOpened by remember {
        mutableStateOf(false)
    }
    if (!rememberPageContext().isExporting) {
        Box(
            Modifier
                .fillMaxSize(),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                BeginSection { menuOpened = true }
                PresentationSection()
                SkillSection()
                AcademicSection()
                ProjectSection()
                ExperienceSection()
                ContactSection()
                EndSection()
            }
            ButtonToTop()
            if (menuOpened) MenuBar { menuOpened = false }
        }
    }
}