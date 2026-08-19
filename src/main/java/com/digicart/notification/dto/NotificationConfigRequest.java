package com.digicart.notification.dto;

import com.digicart.notification.entity.WaProvider;

/**
 * Request/response DTO: Notification Config Request.
 */
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

    /**
     * Returns smtp host.
     * @return the string
     */
    public String getSmtpHost() { return smtpHost; }
    /**
     * Sets smtp host.
     *
     * @param smtpHost smtp host
     */
    public void setSmtpHost(String smtpHost) { this.smtpHost = smtpHost; }
    /**
     * Returns smtp port.
     * @return the integer
     */
    public Integer getSmtpPort() { return smtpPort; }
    /**
     * Sets smtp port.
     *
     * @param smtpPort smtp port
     */
    public void setSmtpPort(Integer smtpPort) { this.smtpPort = smtpPort; }
    /**
     * Returns smtp user.
     * @return the string
     */
    public String getSmtpUser() { return smtpUser; }
    /**
     * Sets smtp user.
     *
     * @param smtpUser smtp user
     */
    public void setSmtpUser(String smtpUser) { this.smtpUser = smtpUser; }
    /**
     * Returns smtp password.
     * @return the string
     */
    public String getSmtpPassword() { return smtpPassword; }
    /**
     * Sets smtp password.
     *
     * @param smtpPassword smtp password
     */
    public void setSmtpPassword(String smtpPassword) { this.smtpPassword = smtpPassword; }
    /**
     * Returns smtp from.
     * @return the string
     */
    public String getSmtpFrom() { return smtpFrom; }
    /**
     * Sets smtp from.
     *
     * @param smtpFrom smtp from
     */
    public void setSmtpFrom(String smtpFrom) { this.smtpFrom = smtpFrom; }
    /**
     * Returns email enabled.
     * @return the boolean
     */
    public Boolean getEmailEnabled() { return emailEnabled; }
    /**
     * Sets email enabled.
     *
     * @param emailEnabled email enabled
     */
    public void setEmailEnabled(Boolean emailEnabled) { this.emailEnabled = emailEnabled; }
    /**
     * Returns wa provider.
     * @return the wa provider
     */
    public WaProvider getWaProvider() { return waProvider; }
    /**
     * Sets wa provider.
     *
     * @param waProvider wa provider
     */
    public void setWaProvider(WaProvider waProvider) { this.waProvider = waProvider; }
    /**
     * Returns wa api key.
     * @return the string
     */
    public String getWaApiKey() { return waApiKey; }
    /**
     * Sets wa api key.
     *
     * @param waApiKey wa api key
     */
    public void setWaApiKey(String waApiKey) { this.waApiKey = waApiKey; }
    /**
     * Returns wa phone id.
     * @return the string
     */
    public String getWaPhoneId() { return waPhoneId; }
    /**
     * Sets wa phone id.
     *
     * @param waPhoneId wa phone id
     */
    public void setWaPhoneId(String waPhoneId) { this.waPhoneId = waPhoneId; }
    /**
     * Returns wa account sid.
     * @return the string
     */
    public String getWaAccountSid() { return waAccountSid; }
    /**
     * Sets wa account sid.
     *
     * @param waAccountSid wa account sid
     */
    public void setWaAccountSid(String waAccountSid) { this.waAccountSid = waAccountSid; }
    /**
     * Returns wa auth token.
     * @return the string
     */
    public String getWaAuthToken() { return waAuthToken; }
    /**
     * Sets wa auth token.
     *
     * @param waAuthToken wa auth token
     */
    public void setWaAuthToken(String waAuthToken) { this.waAuthToken = waAuthToken; }
    /**
     * Returns wa enabled.
     * @return the boolean
     */
    public Boolean getWaEnabled() { return waEnabled; }
    /**
     * Sets wa enabled.
     *
     * @param waEnabled wa enabled
     */
    public void setWaEnabled(Boolean waEnabled) { this.waEnabled = waEnabled; }
    /**
     * Returns alert order placed.
     * @return the boolean
     */
    public Boolean getAlertOrderPlaced() { return alertOrderPlaced; }
    /**
     * Sets alert order placed.
     *
     * @param alertOrderPlaced alert order placed
     */
    public void setAlertOrderPlaced(Boolean alertOrderPlaced) { this.alertOrderPlaced = alertOrderPlaced; }
    /**
     * Returns alert order shipped.
     * @return the boolean
     */
    public Boolean getAlertOrderShipped() { return alertOrderShipped; }
    /**
     * Sets alert order shipped.
     *
     * @param alertOrderShipped alert order shipped
     */
    public void setAlertOrderShipped(Boolean alertOrderShipped) { this.alertOrderShipped = alertOrderShipped; }
    /**
     * Returns alert order delivered.
     * @return the boolean
     */
    public Boolean getAlertOrderDelivered() { return alertOrderDelivered; }
    /**
     * Sets alert order delivered.
     *
     * @param alertOrderDelivered alert order delivered
     */
    public void setAlertOrderDelivered(Boolean alertOrderDelivered) { this.alertOrderDelivered = alertOrderDelivered; }
    /**
     * Returns alert order cancelled.
     * @return the boolean
     */
    public Boolean getAlertOrderCancelled() { return alertOrderCancelled; }
    /**
     * Sets alert order cancelled.
     *
     * @param alertOrderCancelled alert order cancelled
     */
    public void setAlertOrderCancelled(Boolean alertOrderCancelled) { this.alertOrderCancelled = alertOrderCancelled; }
    /**
     * Returns alert order refunded.
     * @return the boolean
     */
    public Boolean getAlertOrderRefunded() { return alertOrderRefunded; }
    /**
     * Sets alert order refunded.
     *
     * @param alertOrderRefunded alert order refunded
     */
    public void setAlertOrderRefunded(Boolean alertOrderRefunded) { this.alertOrderRefunded = alertOrderRefunded; }
}
