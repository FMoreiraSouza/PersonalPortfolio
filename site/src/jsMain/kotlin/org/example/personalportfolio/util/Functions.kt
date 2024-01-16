package org.example.personalportfolio.util

import androidx.compose.runtime.*
import kotlinx.browser.document
import kotlinx.browser.window
import org.w3c.dom.events.EventListener

@Composable
fun ObserveViewportEntered(
    sectionId: String,
    onViewportEntered: () -> Unit,
    distanceFromTop: Double
){
    var viewportEntered by remember{
        mutableStateOf(false)
    }
    var listener = remember{
        EventListener{
            val top = document.getElementById(sectionId)?.getBoundingClientRect()?.top
            if(top != null && top < distanceFromTop){
                viewportEntered = true
            }
        }
    }
    LaunchedEffect(viewportEntered){
        if(viewportEntered){
            onViewportEntered()
            window.removeEventListener(type = "scroll", callback = listener)
        }
        else{
            window.addEventListener(type = "scroll", callback = listener)
        }
    }
}