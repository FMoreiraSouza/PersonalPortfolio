package org.example.personalportfolio.models

import org.example.personalportfolio.util.Res.Icon.fitbank450
import org.example.personalportfolio.util.Res.Icon.nemo
import org.example.personalportfolio.util.Res.Icon.ufc

enum class Experience(
    val icon: String,
    val jobPosition: String,
    val description: String,
    val company: String,
    val from: String,
    val to: String
) {
    First(
        icon = fitbank450,
        jobPosition = "Desenvolvedor Backend",
        description = "Atuei na criação de soluções em contexto bancário para o Sistema de Pagamentos Brasileiro, essas relacionadas a débito e crédito em contas via Transferência Eletrônica Disponível.",
        company = "Fitbank 450",
        from = "Abril 2022",
        to = "Fevereiro 2023"
    ),
    Second(
        icon = nemo,
        jobPosition = "Desenvolvedor Mobile",
        description = "Desenvolvi um aplicativo de plataforma cruzada com o intuito de possibilitar a intermediação de solicitações de pensões alimentícias.",
        company = "Núcleo de Estudos em Aprendizado de Máquina e Otimização",
        from = "Abril 2022",
        to = "Dezembro 2022"
    ),
    Third(
        icon = ufc,
        jobPosition = "Assistente em Docência",
        description = "Criei desafios práticos de programação para os alunos da instituição, para assim, auxíliar na docência das disciplinas de Arquitetura de Computadores e Sistemas Operacionais.",
        company = "Universidade Federal do Ceará",
        from = "Maio 2021",
        to = "Fevereiro 2022"
    )
}