package org.example.personalportfolio.models

import org.example.personalportfolio.util.Res.Icon.pucprCoatOfArms
import org.example.personalportfolio.util.Res.Icon.ufcCoatOfArms

enum class Academic(
    val coatOfArms: String,
    val title: String,
    val subtitle: String,
    val from: String,
    val to: String,
) {
    Bachelor(
        coatOfArms = ufcCoatOfArms,
        title = "Universidade Federal do Ceará",
        subtitle = "Bacharelado em Ciência da Computação",
        from = "Agosto 2017",
        to = "Dezembro 2022"
    ),
    GraduateCertificate(
    coatOfArms = pucprCoatOfArms,
    title = "Pontifícia Universidade Católica do Paraná",
    subtitle = "Especialização em Desenvolvimento de Aplicativos Móveis",
    from = "Maio 2024",
    to = "Maio 2026"
    )
}