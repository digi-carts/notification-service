package com.digicart.notification.controller;

import com.digicart.notification.dto.NotificationLogRequest;
import com.digicart.notification.entity.NotifChannel;
import com.digicart.notification.entity.NotifStatus;
import com.digicart.notification.entity.NotificationLog;
import com.digicart.notification.service.NotificationLogService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * REST controller exposing notification log HTTP APIs for <em>notification-service</em>.
 */
@RestController
@RequestMapping("/api/notification-logs")
public class NotificationLogController {

    private final NotificationLogService service;

    public NotificationLogController(NotificationLogService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<NotificationLog>> getAll(
            @RequestHeader("X-User-Id") String userId,
            @RequestHeader("X-User-Role") String userRole,
            @RequestParam(required = false) String storeId,
            @RequestParam(required = false) NotifStatus status,
            @RequestParam(required = false) NotifChannel channel) {
        if (storeId != null && channel != null) {
            return ResponseEntity.ok(service.findByStoreIdAndChannel(storeId, channel));
        } else if (storeId != null) {
            return ResponseEntity.ok(service.findByStoreId(storeId));
        } else if (status != null) {
            return ResponseEntity.ok(service.findByStatus(status));
        }
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<NotificationLog> getById(
            @RequestHeader("X-User-Id") String userId,
            @RequestHeader("X-User-Role") String userRole,
            @PathVariable UUID id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<NotificationLog> create(
            @RequestHeader("X-User-Id") String userId,
            @RequestHeader("X-User-Role") String userRole,
            @Valid @RequestBody NotificationLogRequest req) {
        return ResponseEntity.status(201).body(service.create(req));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<NotificationLog> updateStatus(
            @RequestHeader("X-User-Id") String userId,
            @RequestHeader("X-User-Role") String userRole,
            @PathVariable UUID id,
            @RequestBody Map<String, String> body) {
        NotifStatus status = NotifStatus.valueOf(body.get("status"));
        String error = body.get("error");
        return ResponseEntity.ok(service.updateStatus(id, status, error));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @RequestHeader("X-User-Id") String userId,
            @RequestHeader("X-User-Role") String userRole,
            @PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
