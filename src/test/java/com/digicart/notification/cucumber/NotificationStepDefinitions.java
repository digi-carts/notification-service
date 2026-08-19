package com.digicart.notification.cucumber;

import com.digicart.notification.service.NotificationConfigService;
import io.cucumber.java.Before;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.NoSuchElementException;

import static org.mockito.Mockito.when;

public class NotificationStepDefinitions {
    @Autowired
    NotificationConfigService notificationConfigService;

    @Before
    public void stubs() {
        when(notificationConfigService.get()).thenThrow(new NoSuchElementException("Notification config not found"));
    }
}
