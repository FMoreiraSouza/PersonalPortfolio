package org.example.personalportfolio.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.silk.components.icons.fa.FaGithub
import com.varabyte.kobweb.silk.components.icons.fa.FaLinkedin
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.toModifier
import org.example.personalportfolio.models.Section
import org.example.personalportfolio.styles.ButtonStyle
import org.example.personalportfolio.styles.SocialLinkStyle
import org.example.personalportfolio.util.Constants.GITHUB
import org.example.personalportfolio.util.Constants.LINKEDIN
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Text

@Composable
fun SocialBar() {
    Row(
        modifier = Modifier
            .borderRadius(r = 20.px),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        SocialLinks()
        GetInTouch()
    }
}

@Composable
fun SocialLinks() {
    Link(
        modifier = Modifier
            .margin(bottom = 20.px, left = 20.px),
        path = LINKEDIN,
        openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB
    ) {
        FaLinkedin(
            modifier = SocialLinkStyle.toModifier(),
            size = IconSize.XXL
        )
    }
    Link(
        modifier = Modifier
            .margin(bottom = 20.px, left = 20.px),
        path = GITHUB,
        openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB
    ) {
        FaGithub(
            modifier = SocialLinkStyle.toModifier(),
            size = IconSize.XXL
        )
    }
}

@Composable
fun GetInTouch() {
    Link(
        modifier = ButtonStyle.toModifier()
            .margin(bottom = 20.px, left = 20.px),
        path = Section.Contact.path
    ) {
        Button(
            attrs = Modifier
                .height(50.px)
                .width(100.px)
                .border(width = 0.px)
                .borderRadius(r = 5.px)
                .boxShadow(blurRadius = 5.px, spreadRadius = 3.px, color = Colors.LightGray)
                .cursor(Cursor.Pointer)
                .toAttrs()
        ) {
            Text("Fale Comigo")
        }
    }
}