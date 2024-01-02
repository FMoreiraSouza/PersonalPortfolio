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
        description = "Atuei como um membro do time do Sistema de Pagamentos Brasileiro (SPB) desenvolvendo soluções no lado do servidor e em contexto bancário relacionadas a débito e crédito de contas via Transferência Eletrônica Disponível.",
        company = "Fitbank 450",
        from = "Abril 2022",
        to = "Fevereiro 2023"
    ),
    Second(
        icon = nemo,
        jobPosition = "Desenvolvedor de Aplicativos Móveis",
        description = "Se trata de um aplicativo de plataforma cruzada com o intuito de possibilitar a Comarca de Limoeiro do Norte a intermediar solicitações de pensões alimentícias.",
        company = "Núcleo de Estudos Avançados em Aprendizado de Máquina e Otimização",
        from = "Abril 2022",
        to = "Dezembro 2022"
    ),
    Third(
        icon = ufc,
        jobPosition = "Monitor nas disciplinas de Arquitetura de Computadores e Sistemas Operacionais",
        description = "Auxílio para os professores de ambas as disciplinas envolvidas, onde foram desenvolvidos desafios práticos de programação para os alunos da instituição.",
        company = "Universidade Federal do Ceará",
        from = "Maio 2021",
        to = "Fevereiro 2022"
    )
}