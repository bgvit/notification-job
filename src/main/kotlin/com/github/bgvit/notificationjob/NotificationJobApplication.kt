package com.github.bgvit.notificationjob

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
@EnableR2dbcRepositories
class NotificationJobApplication

fun main(args: Array<String>) {
    runApplication<NotificationJobApplication>(*args)
}
