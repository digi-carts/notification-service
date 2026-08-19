package com.digicart.notification.entity;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "notification_log", schema = "notif_svc")
@EntityListeners(AuditingEntityListener.class)
public class NotificationLog {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "store_id")
    private String storeId;

    @Enumerated(EnumType.STRING)
    @Column(name = "channel", nullable = false)
    private NotifChannel channel;

    @Column(name = "event", nullable = false)
    private String event;

    @Column(name = "recipient", nullable = false)
    private String recipient;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private NotifStatus status = NotifStatus.PENDING;

    @Column(name = "error")
    private String error;

    @Column(name = "sent_at")
    private Instant sentAt;

    @CreatedDate
    @Column(name = "created_at", updatable = false, nullable = false)
    private Instant createdAt;

    public UUID getId() { return id; }
    public String getStoreId() { return storeId; }
    public void setStoreId(String storeId) { this.storeId = storeId; }
    public NotifChannel getChannel() { return channel; }
    public void setChannel(NotifChannel channel) { this.channel = channel; }
    public String getEvent() { return event; }
    public void setEvent(String event) { this.event = event; }
    public String getRecipient() { return recipient; }
    public void setRecipient(String recipient) { this.recipient = recipient; }
    public NotifStatus getStatus() { return status; }
    public void setStatus(NotifStatus status) { this.status = status; }
    public String getError() { return error; }
    public void setError(String error) { this.error = error; }
    public Instant getSentAt() { return sentAt; }
    public void setSentAt(Instant sentAt) { this.sentAt = sentAt; }
    public Instant getCreatedAt() { return createdAt; }
}
