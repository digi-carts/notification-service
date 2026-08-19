package com.digicart.notification.entity;

import jakarta.persistence.*;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

@Entity
@Table(name = "notification_config", schema = "notif_svc")
@EntityListeners(AuditingEntityListener.class)
public class NotificationConfig {

    @Id
    @Column(name = "id", nullable = false)
    private String id = "global";

    @Column(name = "smtp_host")
    private String smtpHost;

    @Column(name = "smtp_port")
    private Integer smtpPort;

    @Column(name = "smtp_user")
    private String smtpUser;

    @Column(name = "smtp_password")
    private String smtpPassword;

    @Column(name = "smtp_from")
    private String smtpFrom;

    @Column(name = "email_enabled", nullable = false)
    private Boolean emailEnabled = false;

    @Enumerated(EnumType.STRING)
    @Column(name = "wa_provider")
    private WaProvider waProvider;

    @Column(name = "wa_api_key")
    private String waApiKey;

    @Column(name = "wa_phone_id")
    private String waPhoneId;

    @Column(name = "wa_account_sid")
    private String waAccountSid;

    @Column(name = "wa_auth_token")
    private String waAuthToken;

    @Column(name = "wa_enabled", nullable = false)
    private Boolean waEnabled = false;

    @Column(name = "alert_order_placed", nullable = false)
    private Boolean alertOrderPlaced = true;

    @Column(name = "alert_order_shipped", nullable = false)
    private Boolean alertOrderShipped = true;

    @Column(name = "alert_order_delivered", nullable = false)
    private Boolean alertOrderDelivered = true;

    @Column(name = "alert_order_cancelled", nullable = false)
    private Boolean alertOrderCancelled = true;

    @Column(name = "alert_order_refunded", nullable = false)
    private Boolean alertOrderRefunded = false;

    @LastModifiedDate
    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getSmtpHost() { return smtpHost; }
    public void setSmtpHost(String smtpHost) { this.smtpHost = smtpHost; }
    public Integer getSmtpPort() { return smtpPort; }
    public void setSmtpPort(Integer smtpPort) { this.smtpPort = smtpPort; }
    public String getSmtpUser() { return smtpUser; }
    public void setSmtpUser(String smtpUser) { this.smtpUser = smtpUser; }
    public String getSmtpPassword() { return smtpPassword; }
    public void setSmtpPassword(String smtpPassword) { this.smtpPassword = smtpPassword; }
    public String getSmtpFrom() { return smtpFrom; }
    public void setSmtpFrom(String smtpFrom) { this.smtpFrom = smtpFrom; }
    public Boolean getEmailEnabled() { return emailEnabled; }
    public void setEmailEnabled(Boolean emailEnabled) { this.emailEnabled = emailEnabled; }
    public WaProvider getWaProvider() { return waProvider; }
    public void setWaProvider(WaProvider waProvider) { this.waProvider = waProvider; }
    public String getWaApiKey() { return waApiKey; }
    public void setWaApiKey(String waApiKey) { this.waApiKey = waApiKey; }
    public String getWaPhoneId() { return waPhoneId; }
    public void setWaPhoneId(String waPhoneId) { this.waPhoneId = waPhoneId; }
    public String getWaAccountSid() { return waAccountSid; }
    public void setWaAccountSid(String waAccountSid) { this.waAccountSid = waAccountSid; }
    public String getWaAuthToken() { return waAuthToken; }
    public void setWaAuthToken(String waAuthToken) { this.waAuthToken = waAuthToken; }
    public Boolean getWaEnabled() { return waEnabled; }
    public void setWaEnabled(Boolean waEnabled) { this.waEnabled = waEnabled; }
    public Boolean getAlertOrderPlaced() { return alertOrderPlaced; }
    public void setAlertOrderPlaced(Boolean alertOrderPlaced) { this.alertOrderPlaced = alertOrderPlaced; }
    public Boolean getAlertOrderShipped() { return alertOrderShipped; }
    public void setAlertOrderShipped(Boolean alertOrderShipped) { this.alertOrderShipped = alertOrderShipped; }
    public Boolean getAlertOrderDelivered() { return alertOrderDelivered; }
    public void setAlertOrderDelivered(Boolean alertOrderDelivered) { this.alertOrderDelivered = alertOrderDelivered; }
    public Boolean getAlertOrderCancelled() { return alertOrderCancelled; }
    public void setAlertOrderCancelled(Boolean alertOrderCancelled) { this.alertOrderCancelled = alertOrderCancelled; }
    public Boolean getAlertOrderRefunded() { return alertOrderRefunded; }
    public void setAlertOrderRefunded(Boolean alertOrderRefunded) { this.alertOrderRefunded = alertOrderRefunded; }
    public Instant getUpdatedAt() { return updatedAt; }
}
