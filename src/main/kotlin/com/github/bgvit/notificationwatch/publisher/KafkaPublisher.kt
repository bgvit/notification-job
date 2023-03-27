package com.github.bgvit.notificationwatch.publisher

import com.github.bgvit.notificationwatch.model.Notification
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class KafkaPublisher(
    private val kafkaTemplate: KafkaTemplate<String, String>,
    @Value("\${notification-watch.kafka.produce.topic}")
    private val topic: String
) {

    fun sendMessage(topic: String, notification: Notification) {
        kafkaTemplate.send(topic, notification.toString())
    }
}
