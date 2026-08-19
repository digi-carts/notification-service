package com.digicart.notification.repository;

import com.digicart.notification.entity.NotificationConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationConfigRepository extends JpaRepository<NotificationConfig, String> {
}
