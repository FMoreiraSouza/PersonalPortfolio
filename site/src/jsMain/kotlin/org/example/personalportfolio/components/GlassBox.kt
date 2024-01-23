import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.MixBlendMode
import com.varabyte.kobweb.compose.css.functions.LinearGradient
import com.varabyte.kobweb.compose.css.functions.linearGradient
import com.varabyte.kobweb.compose.css.mixBlendMode
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.BoxScope
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.jetbrains.compose.web.css.*

@Composable
fun GlassBox(
    modifier: Modifier = Modifier,
    borderColor: CSSColorValue = when (ColorMode.current) {
        ColorMode.LIGHT -> Color.Companion.argb(1.0f, 211, 211, 212)
        ColorMode.DARK -> Color.Companion.argb(1.0f, 211, 211, 212)
    },
    content: @Composable BoxScope.() -> Unit
) {
    Box(
        modifier = Modifier.margin(leftRight = 1.cssRem).then(modifier),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .margin(leftRight = 1.cssRem)
                .borderRadius(10.px)
                .border(1.px, LineStyle.Solid, borderColor)
                .styleModifier {
                    mixBlendMode(MixBlendMode.Normal)
                }
                .backgroundImage(
                    linearGradient(
                        LinearGradient.Direction.ToBottomRight,
                        rgba(255, 255, 255, 0),
                        rgba(255, 255, 255, 0.08),
                    )
                )
        )
        content()
    }
}