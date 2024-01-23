package org.example.personalportfolio.components

import GlassBox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.example.personalportfolio.models.Skill
import org.example.personalportfolio.styles.DarkerSkillStyle
import org.example.personalportfolio.styles.LighterSkillStyle
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun SkillBar(animatedMargin: CSSSizeValue<CSSUnit.px>) {
    val breakpoint = rememberBreakpoint()
    var colorMode by ColorMode.currentState
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .margin(left = animatedMargin)
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
        SimpleGrid(
            modifier = Modifier
                .fillMaxWidth(if(breakpoint >= Breakpoint.SM) 75.percent else 95.percent),
            numColumns = numColumns(base = 1, md = 2)
        ) {
            GlassBox(
                modifier = Modifier.margin(all = 2.cssRem)
            ) {
                SimpleGrid(
                    modifier = Modifier.padding(all = 1.cssRem),
                    numColumns = numColumns(base = 2)
                ) {
                    Skill.entries.take(4).forEach { skill ->
                        Column(
                            modifier = (if (colorMode.isLight) LighterSkillStyle else DarkerSkillStyle).toModifier(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            GlassBox(
                                modifier = Modifier.size(65.px)
                            ) {
                                Image(
                                    modifier = Modifier.size(45.px),
                                    src = skill.icon
                                )
                            }
                            P(
                                attrs = Modifier
                                    .textAlign(TextAlign.Center)
                                    .toAttrs()
                            ) {
                                Text(skill.title)
                            }
                        }
                    }
                }
            }
            GlassBox(
                modifier = Modifier.margin(all = 2.cssRem)
            ) {
                SimpleGrid(
                    modifier = Modifier.padding(all = 1.cssRem),
                    numColumns = numColumns(base = 2)
                ) {
                    Skill.entries.takeLast(4).forEach { skill ->
                        Column(
                            modifier = (if (colorMode.isLight) LighterSkillStyle else DarkerSkillStyle).toModifier(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        )
                        {
                            GlassBox(
                                modifier = Modifier.size(65.px)
                            ) {
                                Image(
                                    modifier = Modifier.size(45.px),
                                    src = skill.icon
                                )
                            }
                            P(
                                attrs = Modifier
                                    .textAlign(TextAlign.Center)
                                    .toAttrs()
                            ) {
                                Text(skill.title)
                            }
                        }
                    }
                }
            }
        }
    }
}