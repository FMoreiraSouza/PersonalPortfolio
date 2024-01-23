package org.example.personalportfolio.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
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
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.example.personalportfolio.styles.DarkerButtonStyle
import org.example.personalportfolio.styles.DarkerFormStyle
import org.example.personalportfolio.styles.LighterButtonStyle
import org.example.personalportfolio.styles.LighterFormStyle
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.*

@Composable
fun ContactForm() {
    var colorMode by ColorMode.currentState
    val breakpoint = rememberBreakpoint()
    Form(
        action = "https://submit-form.com/ZDEc8vIUB",
        attrs = Modifier
            .attrsModifier {
                attr("method", "POST")
            }
            .toAttrs(),
    ) {
        Input(
            type = InputType.Text,
            attrs = (if (colorMode.isLight) LighterFormStyle else DarkerFormStyle).toModifier()
                .id("inputName")
                .classNames("form-control")
                .backgroundColor(
                    (if (colorMode.isLight) Color.argb(0.1f, 211, 211, 212) else Color.argb(1.0f, 211, 211, 212)))
                .height(40.px)
                .width(
                    when {
                        breakpoint >= Breakpoint.MD -> 500.px
                        breakpoint >= Breakpoint.SM -> 300.px
                        else -> 250.px
                    }
                )
                .borderRadius(r = 5.px)
                .boxShadow(0.px, 0.px, 0.px, 0.px, null)
                .attrsModifier {
                    attr("placeholder", "Nome Completo")
                    attr("name", "Nome")
                    attr("required", "true")
                }
                .toAttrs()
        )
        Input(
            type = InputType.Email,
            attrs = (if (colorMode.isLight) LighterFormStyle else DarkerFormStyle).toModifier()
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
                .boxShadow(0.px, 0.px, 0.px, 0.px, null)
                .attrsModifier {
                    attr("placeholder", "Endereço de Email")
                    attr("name", "Email")
                    attr("required", "true")
                }
                .toAttrs()
        )
        TextArea(
            attrs = (if (colorMode.isLight) LighterFormStyle else DarkerFormStyle).toModifier()
                .id("inputMessage")
                .fontSize(15.px)
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
                .boxShadow(0.px, 0.px, 0.px, 0.px, null)
                .attrsModifier {
                    attr("placeholder", "Sua Mensagem")
                    attr("name", " Mensagem")
                    attr("required", "true")
                }
                .toAttrs()
        )
        Box(
            modifier = (if (colorMode.isLight) LighterButtonStyle else DarkerButtonStyle).toModifier()
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
                    .boxShadow(blurRadius = 5.px, spreadRadius = 3.px, color = Colors.LightGray)
                    .cursor(Cursor.Pointer)
                    .toAttrs()
            ) {
                Text("Enviar")
            }
        }
    }
}