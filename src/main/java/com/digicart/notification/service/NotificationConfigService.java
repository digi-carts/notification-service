package com.digicart.notification.service;

import com.digicart.notification.dto.NotificationConfigRequest;
import com.digicart.notification.entity.NotificationConfig;
import com.digicart.notification.repository.NotificationConfigRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class NotificationConfigService {

    private final NotificationConfigRepository repository;

    public NotificationConfigService(NotificationConfigRepository repository) {
        this.repository = repository;
    }

    public NotificationConfig get() {
        return repository.findById("global")
            .orElseThrow(() -> new NoSuchElementException("Notification config not found"));
    }

    public NotificationConfig upsert(NotificationConfigRequest req) {
        NotificationConfig config = repository.findById("global")
            .orElseGet(() -> { NotificationConfig c = new NotificationConfig(); c.setId("global"); return c; });

        if (req.getSmtpHost() != null) config.setSmtpHost(req.getSmtpHost());
        if (req.getSmtpPort() != null) config.setSmtpPort(req.getSmtpPort());
        if (req.getSmtpUser() != null) config.setSmtpUser(req.getSmtpUser());
        if (req.getSmtpPassword() != null) config.setSmtpPassword(req.getSmtpPassword());
        if (req.getSmtpFrom() != null) config.setSmtpFrom(req.getSmtpFrom());
        if (req.getEmailEnabled() != null) config.setEmailEnabled(req.getEmailEnabled());
        if (req.getWaProvider() != null) config.setWaProvider(req.getWaProvider());
        if (req.getWaApiKey() != null) config.setWaApiKey(req.getWaApiKey());
        if (req.getWaPhoneId() != null) config.setWaPhoneId(req.getWaPhoneId());
        if (req.getWaAccountSid() != null) config.setWaAccountSid(req.getWaAccountSid());
        if (req.getWaAuthToken() != null) config.setWaAuthToken(req.getWaAuthToken());
        if (req.getWaEnabled() != null) config.setWaEnabled(req.getWaEnabled());
        if (req.getAlertOrderPlaced() != null) config.setAlertOrderPlaced(req.getAlertOrderPlaced());
        if (req.getAlertOrderShipped() != null) config.setAlertOrderShipped(req.getAlertOrderShipped());
        if (req.getAlertOrderDelivered() != null) config.setAlertOrderDelivered(req.getAlertOrderDelivered());
        if (req.getAlertOrderCancelled() != null) config.setAlertOrderCancelled(req.getAlertOrderCancelled());
        if (req.getAlertOrderRefunded() != null) config.setAlertOrderRefunded(req.getAlertOrderRefunded());

        return repository.save(config);
    }
}
