package com.github.bgvit.notificationwatch.repository

import com.github.bgvit.notificationwatch.model.Notification
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import java.time.ZonedDateTime

interface NotificationRepository : CrudRepository<Notification, String> {

//    @Query(value = "SELECT n FROM Notification n WHERE delivery_date <= :deliveryDate OR is_ready = :isReady OR was_sent = :wasSent", nativeQuery = true)
//    fun findByExpiredDeliveryDate(@Param("deliveryDate") deliveryDate : ZonedDateTime,
//                                  @Param("isReady") isReady : Boolean,
//                                  @Param("wasSent") wasSent : Boolean) : List<Notification>

    fun findByDeliveryDateBeforeOrIsReadyEqualsOrWasSentEquals(
        deliveryDate: ZonedDateTime,
        @Param("isReady") isReady: Boolean,
        @Param("wasSent") wasSent: Boolean
    ): List<Notification>
}
