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

@Service
public class NotificationLogService {

    private final NotificationLogRepository repository;

    public NotificationLogService(NotificationLogRepository repository) {
        this.repository = repository;
    }

    public List<NotificationLog> findAll() {
        return repository.findAll();
    }

    public NotificationLog findById(UUID id) {
        return repository.findById(id)
            .orElseThrow(() -> new NoSuchElementException("Notification log not found: " + id));
    }

    public List<NotificationLog> findByStoreId(String storeId) {
        return repository.findByStoreId(storeId);
    }

    public List<NotificationLog> findByStatus(NotifStatus status) {
        return repository.findByStatus(status);
    }

    public List<NotificationLog> findByStoreIdAndChannel(String storeId, NotifChannel channel) {
        return repository.findByStoreIdAndChannel(storeId, channel);
    }

    public NotificationLog create(NotificationLogRequest req) {
        NotificationLog log = new NotificationLog();
        log.setStoreId(req.getStoreId());
        log.setChannel(req.getChannel());
        log.setEvent(req.getEvent());
        log.setRecipient(req.getRecipient());
        log.setStatus(NotifStatus.PENDING);
        return repository.save(log);
    }

    public NotificationLog updateStatus(UUID id, NotifStatus status, String error) {
        NotificationLog log = findById(id);
        log.setStatus(status);
        if (error != null) log.setError(error);
        if (status == NotifStatus.SENT) log.setSentAt(Instant.now());
        return repository.save(log);
    }

    public void delete(UUID id) {
        if (!repository.existsById(id)) {
            throw new NoSuchElementException("Notification log not found: " + id);
        }
        repository.deleteById(id);
    }
}
