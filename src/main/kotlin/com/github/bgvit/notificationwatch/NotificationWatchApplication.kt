package com.github.bgvit.notificationwatch

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
class NotificationWatchApplication

fun main(args: Array<String>) {
    runApplication<NotificationWatchApplication>(*args)
}
