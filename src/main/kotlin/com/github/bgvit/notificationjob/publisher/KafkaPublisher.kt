package com.github.bgvit.notificationjob.publisher

import com.github.avrokotlin.avro4k.Avro
import com.github.bgvit.notificationjob.model.message.NotificationMessage
import org.apache.avro.generic.GenericRecord
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class KafkaPublisher(
    private val kafkaTemplate: KafkaTemplate<String, GenericRecord>,
    @Value("\${notification-watch.kafka.produce.topic}")
    private val topic: String
) {

    fun sendMessage(topic: String, notificationMessage: NotificationMessage) {
        try {
            val avroRecord = Avro.default.toRecord(NotificationMessage.serializer(), notificationMessage)
            kafkaTemplate.send(topic, avroRecord)
        } catch (t: Throwable) {
            println(t.localizedMessage)
        }
    }
}
