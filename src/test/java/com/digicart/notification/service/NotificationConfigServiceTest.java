package com.digicart.notification.service;

import com.digicart.notification.dto.NotificationConfigRequest;
import com.digicart.notification.entity.NotificationConfig;
import com.digicart.notification.repository.NotificationConfigRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class NotificationConfigServiceTest {

    @Mock
    private NotificationConfigRepository repository;

    @InjectMocks
    private NotificationConfigService service;

    @Test
    void getThrowsWhenMissing() {
        when(repository.findById("global")).thenReturn(Optional.empty());
        assertThatThrownBy(() -> service.get()).isInstanceOf(NoSuchElementException.class);
    }

    @Test
    void upsertCreatesGlobalRow() {
        when(repository.findById("global")).thenReturn(Optional.empty());
        when(repository.save(any(NotificationConfig.class))).thenAnswer(i -> i.getArgument(0));
        NotificationConfigRequest req = new NotificationConfigRequest();
        req.setEmailEnabled(true);
        req.setSmtpHost("smtp.example.com");
        NotificationConfig cfg = service.upsert(req);
        assertThat(cfg.getId()).isEqualTo("global");
        assertThat(cfg.getEmailEnabled()).isTrue();
        assertThat(cfg.getSmtpHost()).isEqualTo("smtp.example.com");
    }
}
