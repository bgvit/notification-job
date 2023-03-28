package com.github.bgvit.notificationjob.extension

import com.github.bgvit.notificationjob.model.Notification
import com.github.bgvit.notificationjob.model.message.NotificationMessage

fun Notification.toNotificationMessage(): NotificationMessage {
    return NotificationMessage(
        id = this.id,
        notificationType = this.notificationType,
        text = this.notificationMessage,
        deliveryDate = this.deliveryDate.toString(),
        accountId = this.accountId,
        isReady = this.isReady,
        wasSent = this.wasSent
    )
}
