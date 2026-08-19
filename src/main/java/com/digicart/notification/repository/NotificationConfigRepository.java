package com.digicart.notification.repository;

import com.digicart.notification.entity.NotificationConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for notification config  persistence.
 */
@Repository
public interface NotificationConfigRepository extends JpaRepository<NotificationConfig, String> {
}
