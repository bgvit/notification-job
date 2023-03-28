package com.github.bgvit.notificationjob.job

import com.github.bgvit.notificationjob.service.NotificationService
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.Scheduled

@Configuration
class FindExpiredNotificationsJob(private val notificationService: NotificationService) {

    @Scheduled(cron = "3 * * * * *")
    fun execute() {
        notificationService.findExpiredNotificationsAndSendToTopic()
    }
}
