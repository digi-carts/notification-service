package com.digicart.notification.repository;

import com.digicart.notification.entity.NotifChannel;
import com.digicart.notification.entity.NotifStatus;
import com.digicart.notification.entity.NotificationLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

/**
 * Spring Data JPA repository for notification log  persistence.
 */
@Repository
public interface NotificationLogRepository extends JpaRepository<NotificationLog, UUID> {
    /**
     * Finds by store id.
     *
     * @param storeId store (tenant) identifier
     * @return matching records
     */
    List<NotificationLog> findByStoreId(String storeId);
    /**
     * Finds by status.
     *
     * @param status status
     * @return matching records
     */
    List<NotificationLog> findByStatus(NotifStatus status);
    /**
     * Finds by store id and channel.
     *
     * @param storeId store (tenant) identifier
     * @param channel channel
     * @return matching records
     */
    List<NotificationLog> findByStoreIdAndChannel(String storeId, NotifChannel channel);
}
