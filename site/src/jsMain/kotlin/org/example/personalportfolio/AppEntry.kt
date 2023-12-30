package org.example.personalportfolio

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.varabyte.kobweb.compose.ui.modifiers.minHeight
import com.varabyte.kobweb.core.App
import com.varabyte.kobweb.silk.SilkApp
import com.varabyte.kobweb.silk.components.layout.Surface
import com.varabyte.kobweb.silk.components.style.common.SmoothColorStyle
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.init.InitSilk
import com.varabyte.kobweb.silk.init.InitSilkContext
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import kotlinx.browser.localStorage
import org.jetbrains.compose.web.css.vh

private val COLOR_MODE_KEY = ColorMode

@InitSilk
fun initColorMode(ctx: InitSilkContext) {
    ctx.config.initialColorMode =
        localStorage.getItem(COLOR_MODE_KEY.toString())?.let { ColorMode.valueOf(it) } ?: ColorMode.DARK
}

@App
@Composable
fun MyApp(content: @Composable () -> Unit) {

    SilkApp {
        val colorMode = ColorMode.current
        LaunchedEffect(colorMode){
            localStorage.setItem(COLOR_MODE_KEY.toString(), colorMode.name)
        }
        Surface(SmoothColorStyle.toModifier().minHeight(100.vh)) {
            content()
        }
    }
}