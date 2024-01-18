package org.example.personalportfolio.models

import org.example.personalportfolio.util.Res.Icon.apacheKafka
import org.example.personalportfolio.util.Res.Icon.firebase
import org.example.personalportfolio.util.Res.Icon.jetpackCompose
import org.example.personalportfolio.util.Res.Icon.kobwebFramework
import org.example.personalportfolio.util.Res.Icon.kotlin
import org.example.personalportfolio.util.Res.Icon.ktorFramework
import org.example.personalportfolio.util.Res.Icon.mongoDB
import org.example.personalportfolio.util.Res.Icon.postgreSQL

enum class Skill(
    val icon: String,
    val title: String
) {
    Kobweb(
        icon = kobwebFramework,
        title = "Kobweb"
    ),
    Ktor(
        icon = ktorFramework,
        title = "Ktor"
    ),
    JetpackCompose(
        icon = jetpackCompose,
        title = "Jetpack Compose"
    ),
    Kotlin(
        icon = kotlin,
        title = "Kotlin"
    ),
    ApacheKafka(
        icon = apacheKafka,
        title = "Apache Kafka"
    ),
    PostgreSQL(
        icon = postgreSQL,
        title = "PostgreSQL"
    ),
    Firebase(
        icon = firebase,
        title = "Firebase"
    ),
    MongoDB(
        icon = mongoDB,
        title = "MongoDB"
    )
}