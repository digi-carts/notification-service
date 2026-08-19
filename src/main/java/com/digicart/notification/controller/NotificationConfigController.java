package com.digicart.notification.controller;

import com.digicart.notification.dto.NotificationConfigRequest;
import com.digicart.notification.entity.NotificationConfig;
import com.digicart.notification.service.NotificationConfigService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller exposing notification config HTTP APIs for <em>notification-service</em>.
 */
@RestController
@RequestMapping("/api/notification-config")
public class NotificationConfigController {

    private final NotificationConfigService service;

    public NotificationConfigController(NotificationConfigService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<NotificationConfig> get(
            @RequestHeader("X-User-Id") String userId,
            @RequestHeader("X-User-Role") String userRole) {
        return ResponseEntity.ok(service.get());
    }

    @PutMapping
    public ResponseEntity<NotificationConfig> upsert(
            @RequestHeader("X-User-Id") String userId,
            @RequestHeader("X-User-Role") String userRole,
            @RequestBody NotificationConfigRequest req) {
        return ResponseEntity.ok(service.upsert(req));
    }
}
