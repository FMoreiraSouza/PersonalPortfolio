package org.example.personalportfolio.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.style.toModifier
import org.example.personalportfolio.models.Academic
import org.example.personalportfolio.styles.AcademicStyle
import org.example.personalportfolio.util.Constants.FONT_FAMILY
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun AcademicCard(
    academic: Academic
) {
    Column(
        modifier = AcademicStyle.toModifier()
            .fillMaxWidth()
    ) {
        Image(
            modifier = Modifier
                .fillMaxSize(10.percent),
            src = academic.coatOfArms
        )
        P(
            attrs = Modifier
                .margin(topBottom = 0.px)
                .textAlign(TextAlign.Center)
                .color(Colors.Gray)
                .fontFamily(FONT_FAMILY)
                .fontWeight(FontWeight.Bold)
                .fontSize(20.px)
                .toAttrs()
        ){
            Text(academic.title)
        }
        P(
            attrs = Modifier
                .margin(topBottom = 0.px)
                .textAlign(TextAlign.Center)
                .color(Colors.Gray)
                .fontFamily(FONT_FAMILY)
                .fontWeight(FontWeight.Bold)
                .fontSize(14.px)
                .toAttrs()
        ){
            Text(academic.subtitle)
        }
        P(
            attrs = Modifier
                .margin(topBottom = 0.px)
                .textAlign(TextAlign.Center)
                .color(Colors.Black)
                .fontFamily(FONT_FAMILY)
                .fontWeight(FontWeight.Normal)
                .fontSize(14.px)
                .toAttrs()
        ){
            Text("${academic.from} - ${academic.to}")
        }
        Box(
            modifier = Modifier
                .margin(top = 4.px)
                .height(2.px)
                .width(1100.px)
                .borderRadius(50.px)
        )
    }
}