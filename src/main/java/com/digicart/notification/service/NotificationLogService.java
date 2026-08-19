package com.digicart.notification.service;

import com.digicart.notification.dto.NotificationLogRequest;
import com.digicart.notification.entity.NotifChannel;
import com.digicart.notification.entity.NotifStatus;
import com.digicart.notification.entity.NotificationLog;
import com.digicart.notification.repository.NotificationLogRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

/**
 * Application service implementing notification log use cases for <em>notification-service</em>.
 */
@Service
public class NotificationLogService {

    private final NotificationLogRepository repository;

    /**
     * Creates a new {@code NotificationLogService}.
     *
     * @param repository repository
     */
    public NotificationLogService(NotificationLogRepository repository) {
        this.repository = repository;
    }

    /**
     * Finds all.
     * @return matching records
     */
    public List<NotificationLog> findAll() {
        return repository.findAll();
    }

    /**
     * Finds by id.
     *
     * @param id resource identifier
     * @return the notification log
     */
    public NotificationLog findById(UUID id) {
        return repository.findById(id)
            .orElseThrow(() -> new NoSuchElementException("Notification log not found: " + id));
    }

    /**
     * Finds by store id.
     *
     * @param storeId store (tenant) identifier
     * @return matching records
     */
    public List<NotificationLog> findByStoreId(String storeId) {
        return repository.findByStoreId(storeId);
    }

    /**
     * Finds by status.
     *
     * @param status status
     * @return matching records
     */
    public List<NotificationLog> findByStatus(NotifStatus status) {
        return repository.findByStatus(status);
    }

    /**
     * Finds by store id and channel.
     *
     * @param storeId store (tenant) identifier
     * @param channel channel
     * @return matching records
     */
    public List<NotificationLog> findByStoreIdAndChannel(String storeId, NotifChannel channel) {
        return repository.findByStoreIdAndChannel(storeId, channel);
    }

    /**
     * Creates a new record.
     *
     * @param req request payload
     * @return the notification log
     */
    public NotificationLog create(NotificationLogRequest req) {
        NotificationLog log = new NotificationLog();
        log.setStoreId(req.getStoreId());
        log.setChannel(req.getChannel());
        log.setEvent(req.getEvent());
        log.setRecipient(req.getRecipient());
        log.setStatus(NotifStatus.PENDING);
        return repository.save(log);
    }

    /**
     * Update status.
     *
     * @param id resource identifier
     * @param status status
     * @param error error
     * @return the notification log
     */
    public NotificationLog updateStatus(UUID id, NotifStatus status, String error) {
        NotificationLog log = findById(id);
        log.setStatus(status);
        if (error != null) log.setError(error);
        if (status == NotifStatus.SENT) log.setSentAt(Instant.now());
        return repository.save(log);
    }

    /**
     * Deletes the record.
     *
     * @param id resource identifier
     */
    public void delete(UUID id) {
        if (!repository.existsById(id)) {
            throw new NoSuchElementException("Notification log not found: " + id);
        }
        repository.deleteById(id);
    }
}
