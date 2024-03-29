package org.example.personalportfolio.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.Width
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.attrsModifier
import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.example.personalportfolio.styles.ButtonStyle
import org.example.personalportfolio.styles.FormStyle
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*

@Composable
fun ContactForm(
    breakpoint: Breakpoint,
    animatedOpacity: CSSSizeValue<CSSUnit.percent>)
{
    val colorMode by ColorMode.currentState
    Form(
        action = "https://formcarry.com/s/oA7nFSSWOMI",
        attrs = Modifier
            .opacity(animatedOpacity)
            .transition(
                CSSTransition(
                    property = "opacity", duration = 1.s,
                    timingFunction = AnimationTimingFunction.EaseInOut
                )
            )
            .attrsModifier {
                attr("method", "POST")
            }
            .toAttrs(),
    ) {
        Input(
            type = InputType.Text,
            attrs = FormStyle.toModifier()
                .id("inputName")
                .classNames("form-control")
                .backgroundColor((if (colorMode.isLight) Color.argb(0.1f, 211, 211, 212) else Color.argb(1.0f, 211, 211, 212)))
                .height(40.px)
                .width(
                    when {
                        breakpoint >= Breakpoint.MD -> 500.px
                        breakpoint >= Breakpoint.SM -> 300.px
                        else -> 250.px
                    }
                )
                .borderRadius(r = 5.px)
                .attrsModifier {
                    attr("placeholder", "Nome Completo")
                    attr("name", "Nome")
                    attr("required", "true")
                }
                .toAttrs()
        )
        Input(
            type = InputType.Email,
            attrs = FormStyle.toModifier()
                .id("inputEmail")
                .classNames("form-control")
                .backgroundColor((if (colorMode.isLight) Color.argb(0.1f, 211, 211, 212) else Color.argb(1.0f, 211, 211, 212)))
                .height(40.px)
                .width(
                    if (breakpoint >= Breakpoint.MD) 500.px
                    else if (breakpoint >= Breakpoint.SM) 300.px
                    else 250.px
                )
                .borderRadius(r = 5.px)
                .margin(top = 10.px)
                .attrsModifier {
                    attr("placeholder", "Endereço de Email")
                    attr("name", "Email")
                    attr("required", "true")
                }
                .toAttrs()
        )
        TextArea(
            attrs = FormStyle.toModifier()
                .id("inputMessage")
                .fontSize(14.px)
                .classNames("form-control")
                .backgroundColor((if (colorMode.isLight) Color.argb(0.1f, 211, 211, 212) else Color.argb(1.0f, 211, 211, 212)))
                .borderRadius(r = 5.px)
                .margin(topBottom = 10.px)
                .height(150.px)
                .width(
                    if (breakpoint >= Breakpoint.MD) 500.px
                    else if (breakpoint >= Breakpoint.SM) 300.px
                    else 250.px
                )
                .attrsModifier {
                    attr("placeholder", "Sua Mensagem")
                    attr("name", " Mensagem")
                    attr("required", "true")
                }
                .toAttrs()
        )
        Box(
            modifier = ButtonStyle.toModifier()
                .margin(
                    left = when {
                        breakpoint >= Breakpoint.MD -> 200.px
                        breakpoint >= Breakpoint.SM -> 100.px
                        else -> 75.px
                    }
                )
                .width(Width.MaxContent),
            contentAlignment = Alignment.Center,
        ) {
            Button(
                attrs = Modifier
                    .fontSize(14.px)
                    .fontWeight(FontWeight.Bold)
                    .height(50.px)
                    .width(100.px)
                    .color(Colors.White)
                    .border(width = 0.px)
                    .borderRadius(r = 5.px)
                    .cursor(Cursor.Pointer)
                    .toAttrs()
            ) {
                Text("Enviar")
            }
        }
    }
}