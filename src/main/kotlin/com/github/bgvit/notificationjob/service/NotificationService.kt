package com.github.bgvit.notificationjob.service

import com.github.bgvit.notificationjob.extension.toNotificationMessage
import com.github.bgvit.notificationjob.publisher.KafkaPublisher
import com.github.bgvit.notificationjob.repository.NotificationRepository
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.time.ZonedDateTime

@Service
class NotificationService(
    val notificationRepository: NotificationRepository,
    val kafkaPublisher: KafkaPublisher,
    @Value("\${notification-watch.kafka.produce.topic}") val topic: String
) {
    fun findExpiredNotificationsAndSendToTopic() {
        try {
            /*Add log here for start. todo()*/
            val notificationsFlow = notificationRepository.getExpiredNotifications2(ZonedDateTime.now(), isReady = true, wasSent = false)

            notificationsFlow
                .collectList().block()?.forEach {
                        notification ->
                    kafkaPublisher.sendMessage(topic = topic, notificationMessage = notification.toNotificationMessage())
                }
            /*Finish task here, add log todo()*/
        } catch (t: Throwable) {
            println("some problem happened")
        }
    }
}
