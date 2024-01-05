package org.example.personalportfolio.models

enum class Section(
    val id: String,
    val title: String,
    val path: String
) {
    About(
        id = "about",
        title = "Quem sou",
        path = "#about"
    ),
    Skills(
        id = "skills",
        title = "Habilidades",
        path = "#skills"
    ),
    Academics(
        id = "academics",
        title = "Formações",
        path = "#academics"
    ),
    Projects(
        id = "projects",
        title = "Projetos",
        path = "#projects"
    ),
    Experiences(
        id = "experience",
        title = "Experiência",
        path = "#experience"
    ),
    Contact(
        id = "contact",
        title = "Contato",
        path = "#contact"
    )
}