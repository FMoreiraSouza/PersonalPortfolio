package org.example.personalportfolio.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.style.toModifier
import org.example.personalportfolio.components.SectionTitle
import org.example.personalportfolio.models.Section
import org.example.personalportfolio.models.Skill
import org.example.personalportfolio.styles.SkillStyle
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Text

@Composable
fun SkillSection() {
    Box(
        modifier = Modifier
            .id(Section.Skills.id)
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        SkillContent()
    }
}

@Composable
fun SkillContent(){
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SectionTitle(
            section = Section.Skills
        )
        Skills()
    }
}
@Composable
fun Skills() {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Skill.values().forEach { skill ->
            Column(
                modifier = SkillStyle.toModifier()
                    .fillMaxSize(6.percent)
                    .textAlign(TextAlign.Center)
                    .padding(all = 10.px),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxSize(100.percent)
                        .padding(bottom = 15.px),
                    src = skill.icon
                )
                Text(skill.title)
            }
        }
    }
}