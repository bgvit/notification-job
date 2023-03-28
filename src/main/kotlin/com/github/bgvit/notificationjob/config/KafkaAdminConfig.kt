package com.github.bgvit.notificationjob.config

import org.apache.kafka.clients.admin.AdminClientConfig
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.KafkaAdmin

@Configuration
class KafkaAdminConfig(
    @Value(value = "\${spring.kafka.bootstrap-servers}")
    private val bootstrapAddress: String

) {

    @Bean
    fun kafkaAdmin(): KafkaAdmin {
        val configs: MutableMap<String, Any?> = HashMap()
        configs[AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG] = bootstrapAddress
        return KafkaAdmin(configs)
    }

    @Value("\${spring.cloud.stream.kafka.binder.producer-properties.schema.registry.url}")
    private val endPoint: String? = null

//    @Bean
//    fun schemaRegistryClient(): SchemaRegistryClient {
//        val client = ()
//        client.setEndpoint(endPoint)
//        return client
//    }
}
