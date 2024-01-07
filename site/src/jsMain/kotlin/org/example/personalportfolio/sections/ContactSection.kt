package org.example.personalportfolio.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.padding
import org.example.personalportfolio.components.ContactForm
import org.example.personalportfolio.components.SectionTitle
import org.example.personalportfolio.models.Section
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

@Composable
fun ContactSection() {
    Box(
        modifier = Modifier
            .id(Section.Contact.id)
            .fillMaxWidth(80.percent)
            .padding(topBottom = 20.px),
        contentAlignment = Alignment.Center
    ) {
        ContactContent()
    }
}

@Composable
fun ContactContent() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SectionTitle(
            section = Section.Contact
        )
        ContactForm()
    }
}