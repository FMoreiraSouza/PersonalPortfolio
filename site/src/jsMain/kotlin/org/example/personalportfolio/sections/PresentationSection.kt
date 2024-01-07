package org.example.personalportfolio.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import org.example.personalportfolio.components.SectionTitle
import org.example.personalportfolio.models.Section
import org.example.personalportfolio.models.Theme
import org.example.personalportfolio.util.Constants
import org.example.personalportfolio.util.Res
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

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
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SectionTitle(
            section = Section.About
        )
        SimpleGrid(
            modifier = Modifier.fillMaxWidth(),
            numColumns = numColumns(base = 1, md = 2)
        ) {
            MyDescription()
            MyProfessionalPhoto()
        }
    }
}

@Composable
fun MyDescription() {
    Row(
        modifier = Modifier.fillMaxWidth()
            .margin(left = 45.px),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            P(
                attrs = Modifier
                    .margin(all = 20.px)
                    .fontSize(50.px)
                    .fontFamily(Constants.FONT_FAMILY)
                    .fontWeight(FontWeight.Bolder)
                    .color(Colors.Gray)
                    .toAttrs()
            )
            {
                Text("Prazer, Felipe Moreira")
            }
            P(
                attrs = Modifier
                    .margin(left = 20.px, bottom = 0.px)
                    .fontSize(20.px)
                    .fontFamily(Constants.FONT_FAMILY)
                    .fontWeight(FontWeight.Bold)
                    .color(Colors.Gray)
                    .toAttrs()
            )
            {
                Text("Desenvolvedor Mobile")
                Image(
                    modifier = Modifier
                        .fillMaxSize(5.percent),
                    src = Res.Icon.mobilePhone
                )
            }
            P(
                attrs = Modifier
                    .margin(all = 20.px)
                    .maxWidth(570.px)
                    .fontSize(20.px)
                    .fontFamily("Montserrat", "sans-serif")
                    .textAlign(TextAlign.Justify)
                    .fontWeight(FontWeight.Normal)
                    .color(Theme.Primary.rgb)
                    .toAttrs()
            ) {
                Text(Constants.About)
            }
        }
    }
}

@Composable
fun MyProfessionalPhoto() {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Image(
                modifier = Modifier
                    .margin(left = 110.px)
                    .boxShadow(blurRadius = 5.px, spreadRadius = 3.px, color = Colors.Gray)
                    .fillMaxSize(50.percent),
                src = Res.Image.profilePhoto
            )
        }
    }
}