package org.example.personalportfolio.models

import org.example.personalportfolio.util.Res.Icon.android
import org.example.personalportfolio.util.Res.Icon.apacheKafka
import org.example.personalportfolio.util.Res.Icon.firebase
import org.example.personalportfolio.util.Res.Icon.jetpackCompose
import org.example.personalportfolio.util.Res.Icon.kobwebFramework
import org.example.personalportfolio.util.Res.Icon.kotlin
import org.example.personalportfolio.util.Res.Icon.ktorFramework
import org.example.personalportfolio.util.Res.Icon.postgreSQL

enum class Skill(
    val icon: String,
    val title: String
) {
    Android(
        icon = android,
        title = "Android"

    ),
    ApacheKafka(
        icon = apacheKafka,
        title = "Apache Kafka"
    ),
    Firebase(
        icon = firebase,
        title = "Firebase"
    ),
    JetpackCompose(
        icon = jetpackCompose,
        title = "Jetpack Compose"
    ),
    Kobweb(
        icon = kobwebFramework,
        title = "Kobweb"
    ),
    Kotlin(
        icon = kotlin,
        title = "Kotlin"
    ),
    Ktor(
        icon = ktorFramework,
        title = "Ktor"
    ),
    PostgreSQL(
        icon = postgreSQL,
        title = "PostgreSQL"
    )
}