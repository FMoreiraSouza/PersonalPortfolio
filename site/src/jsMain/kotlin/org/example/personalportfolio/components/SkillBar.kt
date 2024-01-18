package org.example.personalportfolio.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.example.personalportfolio.models.Section
import org.example.personalportfolio.models.Skill
import org.example.personalportfolio.styles.SkillStyle
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Text

@Composable
fun SkillBar(animatedMargin: CSSSizeValue<CSSUnit.px>, section: Section) {
    val breakpoint = rememberBreakpoint()
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .margin(
                left = if (breakpoint <= Breakpoint.MD) {
                    if (section.id == Section.Skills.id) {
                        0.px
                    } else {
                        animatedMargin
                    }
                } else {
                    animatedMargin
                },
            )
            .transition(
                CSSTransition(
                    property = "margin",
                    duration = 2.s,
                    delay = 200.ms
                )
            ),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (breakpoint > Breakpoint.MD) {
            Skill.entries.forEach { skill ->
                Column(
                    modifier = SkillStyle.toModifier()
                        .fillMaxSize(8.percent)
                        .textAlign(TextAlign.Center)
                        .padding(leftRight = 20.px),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        modifier = Modifier
                            .fillMaxSize(100.percent),
                        src = skill.icon
                    )
                    Text(skill.title)
                }
            }
        } else {
            SimpleGrid(
                numColumns = numColumns(base = 2, sm = 4),
                modifier = Modifier.alignContent(AlignContent.Center)
            ) {
                Skill.entries.forEach { skill ->
                    Column(
                        modifier = SkillStyle.toModifier()
                            .fillMaxSize(50.percent)
                            .margin(left = if (breakpoint >= Breakpoint.SM) 32.px else 42.px)
                            .textAlign(TextAlign.Center),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            modifier = Modifier
                                .fillMaxSize(100.percent),
                            src = skill.icon
                        )
                        Text(skill.title)
                    }
                }
            }
        }
    }
}