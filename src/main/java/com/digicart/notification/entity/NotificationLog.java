package com.digicart.notification.entity;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
import java.util.UUID;

/**
 * JPA entity mapped in this service schema (Notification Log).
 */
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

    /**
     * Returns id.
     * @return the uuid
     */
    public UUID getId() { return id; }
    /**
     * Returns store id.
     * @return the string
     */
    public String getStoreId() { return storeId; }
    /**
     * Sets store id.
     *
     * @param storeId store (tenant) identifier
     */
    public void setStoreId(String storeId) { this.storeId = storeId; }
    /**
     * Returns channel.
     * @return the notif channel
     */
    public NotifChannel getChannel() { return channel; }
    /**
     * Sets channel.
     *
     * @param channel channel
     */
    public void setChannel(NotifChannel channel) { this.channel = channel; }
    /**
     * Returns event.
     * @return the string
     */
    public String getEvent() { return event; }
    /**
     * Sets event.
     *
     * @param event event
     */
    public void setEvent(String event) { this.event = event; }
    /**
     * Returns recipient.
     * @return the string
     */
    public String getRecipient() { return recipient; }
    /**
     * Sets recipient.
     *
     * @param recipient recipient
     */
    public void setRecipient(String recipient) { this.recipient = recipient; }
    /**
     * Returns status.
     * @return the notif status
     */
    public NotifStatus getStatus() { return status; }
    /**
     * Sets status.
     *
     * @param status status
     */
    public void setStatus(NotifStatus status) { this.status = status; }
    /**
     * Returns error.
     * @return the string
     */
    public String getError() { return error; }
    /**
     * Sets error.
     *
     * @param error error
     */
    public void setError(String error) { this.error = error; }
    /**
     * Returns sent at.
     * @return the instant
     */
    public Instant getSentAt() { return sentAt; }
    /**
     * Sets sent at.
     *
     * @param sentAt sent at
     */
    public void setSentAt(Instant sentAt) { this.sentAt = sentAt; }
    /**
     * Returns created at.
     * @return the instant
     */
    public Instant getCreatedAt() { return createdAt; }
}
