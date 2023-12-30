package org.example.personalportfolio.models

enum class Section(
    val id: String,
    val title: String,
    val path: String
) {
    Habilidades(
        id = "skills",
        title = "Habilidades",
        path = "#skills",
    ),
    Academics(
        id = "academics",
        title = "Formações",
        path = "#academics",
    ),
    Experience(
        id = "experience",
        title = "Experiência",
        path = "#experience",
    ),
    Contact(
        id = "contact",
        title = "Contato",
        path = "#contact",
    )
}