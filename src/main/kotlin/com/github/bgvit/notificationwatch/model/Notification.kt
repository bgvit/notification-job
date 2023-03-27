package com.github.bgvit.notificationwatch.model

import com.github.bgvit.notificationwatch.model.enums.NotificationType
import jakarta.persistence.Entity
import jakarta.persistence.Id
import org.springframework.data.relational.core.mapping.Table
import java.time.ZonedDateTime

@Table("notification")
@Entity
data class Notification(
    @Id
    val id: String,
    val notificationType: NotificationType,
    val notificationMessage: String,
    val deliveryDate: ZonedDateTime = ZonedDateTime.now(),
    val accountId: String,
    val isReady: Boolean,
    val wasSent: Boolean
)
