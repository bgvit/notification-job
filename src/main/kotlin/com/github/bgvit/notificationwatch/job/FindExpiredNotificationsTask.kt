package com.github.bgvit.notificationwatch.job

import com.github.bgvit.notificationwatch.service.NotificationService
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.Scheduled

@Configuration
class FindExpiredNotificationsTask(private val notificationService: NotificationService) {

    @Scheduled(cron = "3 * * * * *")
    fun execute() {
        notificationService.findExpiredNotificationsAndSendToTopic()
    }
}
