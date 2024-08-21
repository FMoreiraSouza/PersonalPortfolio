package org.example.personalportfolio.models

import org.example.personalportfolio.util.Res.Icon.fitbank450
import org.example.personalportfolio.util.Res.Icon.nemo
import org.example.personalportfolio.util.Res.Icon.novacode
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
        icon = novacode,
        jobPosition = "Desenvolvedor Mobile",
        description = "Adição e manutenção de funcionalidades e lógicas nas telas dos aplicativos POS, MQ e Qpay, esses direcionados, respectivamente, para um terminal eletrônico, clientes e franqueados.",
        company = "Novacode",
        from = "Março 2024",
        to = "Presente"
    ),
    Second(
        icon = fitbank450,
        jobPosition = "Desenvolvedor Back-end",
        description = "Atuei na criação de soluções em contexto bancário para o Sistema de Pagamentos Brasileiro, essas relacionadas a débito e crédito em contas via Transferência Eletrônica Disponível.",
        company = "Fitbank 450",
        from = "Abril 2022",
        to = "Fevereiro 2023"
    ),
    Third(
        icon = nemo,
        jobPosition = "Estagiário em Desenvolvimento",
        description = "Desenvolvi um aplicativo de plataforma cruzada com o intuito de intermediar solicitações de pensões alimentícias.",
        company = "Núcleo de Estudos em Aprendizado de Máquina e Otimização",
        from = "Abril 2022",
        to = "Dezembro 2022"
    ),
    Fourth(
        icon = ufc,
        jobPosition = "Assistente em Docência",
        description = "Criei desafios práticos de programação para os alunos da instituição, de forma a prestar auxílio na docência das disciplinas de Arquitetura de Computadores e Sistemas Operacionais.",
        company = "Universidade Federal do Ceará",
        from = "Maio 2021",
        to = "Fevereiro 2022"
    ),
}