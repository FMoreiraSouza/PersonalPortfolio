package org.example.personalportfolio.components

import GlassBox
import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.animation.toAnimation
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.example.personalportfolio.models.Skill
import org.example.personalportfolio.styles.AppearMoveKeyFrames
import org.example.personalportfolio.styles.SkillStyle
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun SkillCard(
    animatedMargin: CSSSizeValue<CSSUnit.px>,
    animatedOpacity: CSSSizeValue<CSSUnit.percent>
) {
    val breakpoint = rememberBreakpoint()
    SimpleGrid(
        modifier = Modifier
            .opacity(if (breakpoint > Breakpoint.LG && breakpoint <= Breakpoint.XL || breakpoint <= Breakpoint.MD) animatedOpacity else 100.percent)
            .margin(left = if (breakpoint > Breakpoint.LG && breakpoint <= Breakpoint.XL || breakpoint <= Breakpoint.MD) animatedMargin else 0.px)
            .transition(
                CSSTransition(
                    property = "opacity", duration = 1.s,
                    timingFunction = AnimationTimingFunction.EaseInOut
                ),
                CSSTransition(
                    property = "margin", duration = 1.s,
                    timingFunction = AnimationTimingFunction.EaseInOut
                )
            )
            .then(
                if (breakpoint > Breakpoint.MD && breakpoint <= Breakpoint.LG) {
                    Modifier.animation(
                        AppearMoveKeyFrames
                            .toAnimation(
                                duration = 1.s,
                                timingFunction = AnimationTimingFunction.EaseInOut
                            )
                    )
                }
                else {
                    Modifier
                }
            )
            .fillMaxWidth(if (breakpoint >= Breakpoint.SM) 75.percent else 95.percent),
        numColumns = numColumns(base = 1, md = 2)
    ) {
        GlassBox(
            modifier = Modifier
                .margin(
                    bottom = if (breakpoint > Breakpoint.SM) 0.cssRem else 1.cssRem,
                    leftRight = if (breakpoint > Breakpoint.SM) 2.cssRem else 1.cssRem
                )
        ) {
            SimpleGrid(
                modifier = Modifier.padding(all = 1.cssRem),
                numColumns = numColumns(base = 2)
            ) {
                Skill.entries.take(4).forEach { skill ->
                    Column(
                        modifier = SkillStyle.toModifier(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        GlassBox(
                            modifier = Modifier.size(65.px)
                        ) {
                            Image(
                                modifier = Modifier.size(50.px),
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
            modifier = Modifier.margin(
                top = if (breakpoint > Breakpoint.SM) 0.cssRem else 1.cssRem,
                leftRight = if (breakpoint > Breakpoint.SM) 2.cssRem else 1.cssRem
            )
        ) {
            SimpleGrid(
                modifier = Modifier.padding(all = 1.cssRem),
                numColumns = numColumns(base = 2)
            ) {
                Skill.entries.takeLast(4).forEach { skill ->
                    Column(
                        modifier = SkillStyle.toModifier(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    )
                    {
                        GlassBox(
                            modifier = Modifier.size(65.px)
                        ) {
                            Image(
                                modifier = Modifier.size(50.px),
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