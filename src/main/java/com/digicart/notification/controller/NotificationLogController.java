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

    /**
     * Creates a new {@code NotificationLogController}.
     *
     * @param service service
     */
    public NotificationLogController(NotificationLogService service) {
        this.service = service;
    }

    /**
     * Handles GET.
     *
     * @param userId caller user id from the gateway ({@code X-User-Id})
     * @param userRole caller role from the gateway ({@code X-User-Role})
     * @param storeId store (tenant) identifier
     * @param status status
     * @param channel channel
     * @return HTTP response
     */
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

    /**
     * Handles {@code GET /{id}}.
     *
     * @param userId caller user id from the gateway ({@code X-User-Id})
     * @param userRole caller role from the gateway ({@code X-User-Role})
     * @param id resource identifier
     * @return HTTP response
     */
    @GetMapping("/{id}")
    public ResponseEntity<NotificationLog> getById(
            @RequestHeader("X-User-Id") String userId,
            @RequestHeader("X-User-Role") String userRole,
            @PathVariable UUID id) {
        return ResponseEntity.ok(service.findById(id));
    }

    /**
     * Handles POST.
     *
     * @param userId caller user id from the gateway ({@code X-User-Id})
     * @param userRole caller role from the gateway ({@code X-User-Role})
     * @param req request payload
     * @return HTTP response
     */
    @PostMapping
    public ResponseEntity<NotificationLog> create(
            @RequestHeader("X-User-Id") String userId,
            @RequestHeader("X-User-Role") String userRole,
            @Valid @RequestBody NotificationLogRequest req) {
        return ResponseEntity.status(201).body(service.create(req));
    }

    /**
     * Handles {@code PATCH /{id}/status}.
     *
     * @param userId caller user id from the gateway ({@code X-User-Id})
     * @param userRole caller role from the gateway ({@code X-User-Role})
     * @param id resource identifier
     * @param body JSON request body
     * @return HTTP response
     */
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

    /**
     * Handles {@code DELETE /{id}}.
     *
     * @param userId caller user id from the gateway ({@code X-User-Id})
     * @param userRole caller role from the gateway ({@code X-User-Role})
     * @param id resource identifier
     * @return HTTP response
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @RequestHeader("X-User-Id") String userId,
            @RequestHeader("X-User-Role") String userRole,
            @PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
