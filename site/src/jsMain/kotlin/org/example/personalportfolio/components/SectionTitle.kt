package org.example.personalportfolio.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import org.example.personalportfolio.models.Section
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun SectionTitle(section: Section) {
    Column(
        modifier = Modifier,
    ) {
        P(
            attrs = Modifier
                .textAlign(TextAlign.Center)
                .color(Colors.Gray)
                .fontFamily("Roboto")
                .fontWeight(FontWeight.Bold)
                .fontSize(40.px)
                .toAttrs()
        )
        {
            Text(section.title)
        }
    }
}