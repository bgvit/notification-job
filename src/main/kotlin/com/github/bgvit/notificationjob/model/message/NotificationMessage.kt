package com.github.bgvit.notificationjob.model.message

import kotlinx.serialization.Serializable

@Serializable
data class NotificationMessage(
    val id: String,
    val notificationType: String,
    val text: String,
    val deliveryDate: String,
    val accountId: String,
    val isReady: Boolean,
    val wasSent: Boolean
)
