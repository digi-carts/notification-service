package com.digicart.notification.dto;

import com.digicart.notification.entity.NotifChannel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class NotificationLogRequest {

    private String storeId;

    @NotNull
    private NotifChannel channel;

    @NotBlank
    private String event;

    @NotBlank
    private String recipient;

    public String getStoreId() { return storeId; }
    public void setStoreId(String storeId) { this.storeId = storeId; }
    public NotifChannel getChannel() { return channel; }
    public void setChannel(NotifChannel channel) { this.channel = channel; }
    public String getEvent() { return event; }
    public void setEvent(String event) { this.event = event; }
    public String getRecipient() { return recipient; }
    public void setRecipient(String recipient) { this.recipient = recipient; }
}
