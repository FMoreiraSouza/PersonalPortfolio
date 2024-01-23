package org.example.personalportfolio.models

import org.example.personalportfolio.util.Constants.personalPortfolio
import org.example.personalportfolio.util.Res

enum class Project(
    val link: String,
    val title: String,
    val image: String,
    val platform: String,
) {
    PersonalPortfolio(
        link = personalPortfolio,
        title = "PersonalPortfolio",
        image = Res.Image.profilePhoto,
        platform = "Front-end"
    )
}