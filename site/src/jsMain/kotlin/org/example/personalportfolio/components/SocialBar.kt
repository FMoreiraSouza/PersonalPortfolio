package org.example.personalportfolio.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.silk.components.animation.toAnimation
import com.varabyte.kobweb.silk.components.icons.fa.FaGithub
import com.varabyte.kobweb.silk.components.icons.fa.FaLinkedin
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import org.example.personalportfolio.styles.ButtonStyle
import org.example.personalportfolio.styles.ShowKeyFrames
import org.example.personalportfolio.styles.SocialLinkStyle
import org.example.personalportfolio.util.Constants
import org.example.personalportfolio.util.Constants.GITHUB
import org.example.personalportfolio.util.Constants.LINKEDIN
import org.jetbrains.compose.web.css.AnimationTimingFunction
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.s
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Text

@Composable
fun SocialBar(breakpoint: Breakpoint) {
    Column(
        modifier = Modifier
            .animation(
                ShowKeyFrames
                    .toAnimation(
                        duration = 1.s,
                        timingFunction = AnimationTimingFunction.EaseInOut
                    )
            )
            .borderRadius(r = 20.px),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (breakpoint >= Breakpoint.SM) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                SocialLinks(breakpoint)
                SpeakOnEmail(breakpoint)
            }
        }
        else {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                SpeakOnEmail(breakpoint)
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    SocialLinks(breakpoint)
                }
            }
        }
    }
}

@Composable
fun SocialLinks(breakpoint: Breakpoint) {
    Link(
        modifier = Modifier.margin(
            right = if (breakpoint >= Breakpoint.SM) 8.px else 10.px,
            bottom = if (breakpoint >= Breakpoint.SM) 20.px else 0.px
        ),
        path = GITHUB,
        openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB
    ) {
        FaGithub(
            modifier = SocialLinkStyle.toModifier(),
            size = IconSize.XXL
        )
    }
    Link(
        modifier = Modifier.margin(
            left = if (breakpoint >= Breakpoint.SM) 10.px else 15.px,
            bottom = if (breakpoint >= Breakpoint.SM) 20.px else 0.px
        ),
        path = LINKEDIN,
        openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB
    ) {
        FaLinkedin(
            modifier = SocialLinkStyle.toModifier(),
            size = IconSize.XXL
        )
    }
}

@Composable
fun SpeakOnEmail(breakpoint: Breakpoint) {
    Link(
        modifier = ButtonStyle.toModifier()
            .margin(
                bottom = if (breakpoint >= Breakpoint.SM) 20.px else 35.px,
                left = if (breakpoint >= Breakpoint.SM) 20.px else 0.px
            )
            .height(50.px)
            .width(100.px),
        path = Constants.MAIL_TO
    ) {
        Button(
            attrs = Modifier
                .fillMaxSize()
                .fontSize(14.px)
                .fontWeight(FontWeight.Bold)
                .color(Colors.White)
                .border(width = 0.px)
                .borderRadius(r = 5.px)
                .cursor(Cursor.Pointer)
                .toAttrs()
        ) {
            Text("E-mail")
        }
    }
}