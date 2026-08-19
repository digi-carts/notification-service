package com.digicart.notification.cucumber;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import com.digicart.notification.exception.GlobalExceptionHandler;
import com.digicart.notification.controller.HealthController;
import com.digicart.notification.controller.NotificationConfigController;
import com.digicart.notification.service.NotificationConfigService;

@CucumberContextConfiguration
@WebMvcTest(controllers = { HealthController.class, NotificationConfigController.class })
@AutoConfigureMockMvc(addFilters = false)
@Import(GlobalExceptionHandler.class)
public class CucumberSpringConfiguration {
    @MockBean
    NotificationConfigService notificationConfigService;

}
