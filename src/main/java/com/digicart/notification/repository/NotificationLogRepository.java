package com.digicart.notification.repository;

import com.digicart.notification.entity.NotifChannel;
import com.digicart.notification.entity.NotifStatus;
import com.digicart.notification.entity.NotificationLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface NotificationLogRepository extends JpaRepository<NotificationLog, UUID> {
    List<NotificationLog> findByStoreId(String storeId);
    List<NotificationLog> findByStatus(NotifStatus status);
    List<NotificationLog> findByStoreIdAndChannel(String storeId, NotifChannel channel);
}
