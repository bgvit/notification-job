package com.github.bgvit.notificationwatch.service

import com.github.bgvit.notificationwatch.publisher.KafkaPublisher
import com.github.bgvit.notificationwatch.repository.NotificationRepository
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
        /*Add log here for start. todo()*/
        val notifications = notificationRepository.findByDeliveryDateBeforeOrIsReadyEqualsOrWasSentEquals(ZonedDateTime.now(), isReady = true, wasSent = false)
        notifications.forEach {
                notification ->
            kafkaPublisher.sendMessage(topic = topic, notification = notification)
        }
        /*Finish task here, add log todo()*/
    }
}
