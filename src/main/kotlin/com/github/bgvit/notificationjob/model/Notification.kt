package com.github.bgvit.notificationjob.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.time.ZonedDateTime

@Table
data class Notification(
    @Id val id: String,
    val notificationType: String,
    val notificationMessage: String,
    val deliveryDate: ZonedDateTime = ZonedDateTime.now(),
    val accountId: String,
    val isReady: Boolean,
    val wasSent: Boolean
)
