package com.digicart.notification.dto;

import com.digicart.notification.entity.WaProvider;

public class NotificationConfigRequest {
    private String smtpHost;
    private Integer smtpPort;
    private String smtpUser;
    private String smtpPassword;
    private String smtpFrom;
    private Boolean emailEnabled;
    private WaProvider waProvider;
    private String waApiKey;
    private String waPhoneId;
    private String waAccountSid;
    private String waAuthToken;
    private Boolean waEnabled;
    private Boolean alertOrderPlaced;
    private Boolean alertOrderShipped;
    private Boolean alertOrderDelivered;
    private Boolean alertOrderCancelled;
    private Boolean alertOrderRefunded;

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
}
