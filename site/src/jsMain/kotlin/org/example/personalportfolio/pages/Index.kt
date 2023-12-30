package org.example.personalportfolio.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.core.Page
import org.example.personalportfolio.sections.PresentationSection
import org.example.personalportfolio.sections.SkillsSection

@Page
@Composable
fun HomePage() {
    // TODO: Replace the following with your own content
    Box(
        Modifier
//            .backgroundColor(Colors.Blue)
            .fillMaxSize(),
//        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
//                .backgroundColor(Colors.Red)
        ) {
            PresentationSection()
            SkillsSection()
        }
    }
}
