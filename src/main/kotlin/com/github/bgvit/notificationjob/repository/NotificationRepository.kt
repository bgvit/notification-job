package com.github.bgvit.notificationjob.repository

import com.github.bgvit.notificationjob.model.Notification
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate
import org.springframework.data.relational.core.query.Criteria
import org.springframework.data.relational.core.query.Query
import org.springframework.r2dbc.core.DatabaseClient
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import java.time.ZonedDateTime

@Repository
class NotificationRepository(private val client: DatabaseClient, private val template: R2dbcEntityTemplate) {

    fun getExpiredNotifications2(deliveryDate: ZonedDateTime, isReady: Boolean, wasSent: Boolean): Flux<Notification> {
        return template
            .select(Notification::class.java)
            .matching(
                Query.query(
                    Criteria
                        .where("delivery_date")
                        .lessThanOrEquals(deliveryDate)
                        .or("is_ready").`is`(isReady)
                        .or("was_sent").`is`(wasSent)
                )
            )
            .all()
    }
}
