package com.digicart.notification.dto;

import com.digicart.notification.entity.NotifChannel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * Request/response DTO: Notification Log Request.
 */
public class NotificationLogRequest {

    private String storeId;

    @NotNull
    private NotifChannel channel;

    @NotBlank
    private String event;

    @NotBlank
    private String recipient;

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
}
