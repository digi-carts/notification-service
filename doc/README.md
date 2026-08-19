# notification-service

Outbound email (SMTP) and WhatsApp configuration plus send logs. Port **3003**, schema **`notif_svc`**.

Platform design: [System design](https://github.com/digi-carts/doc/blob/main/architecture/system-design.md)

## Domain

A single global `NotificationConfig` row (`id = "global"`) holds SMTP and WhatsApp provider credentials and alert toggles (order placed, shipped, etc.). `NotificationLog` records channel, status, and payload for auditing.

Credentials are stored in the database and edited via API (platform/merchant settings UIs), not only env vars.

## Tech stack

Java 21, Spring Boot 3.3.0, Web, JPA, Liquibase, PostgreSQL.

Enums: `WaProvider`, `NotifChannel`, `NotifStatus`.

## Data model

| Entity | Table | Notes |
|--------|--------|--------|
| `NotificationConfig` | `notification_config` | SMTP host/port/user/password/from; WA API key / phone id / Twilio-style SID+token; alert flags |
| `NotificationLog` | `notification_logs` | Delivery history; status can be patched |

## HTTP API

Gateway prefix: `/api/notifications/**`.

### Config — `/api/notification-config`

| Method | Path |
|--------|------|
| GET | `/api/notification-config` |
| PUT | `/api/notification-config` |

### Logs — `/api/notification-logs`

| Method | Path |
|--------|------|
| GET | `/api/notification-logs` |
| GET | `/api/notification-logs/{id}` |
| POST | `/api/notification-logs` |
| PATCH | `/api/notification-logs/{id}/status` |
| DELETE | `/api/notification-logs/{id}` |

### Health

`GET /health`

## Configuration

| Variable | Required | Default |
|----------|----------|---------|
| `DATABASE_URL` | yes | schema `notif_svc` |
| `PORT` | no | `3003` |

Runtime SMTP/WhatsApp comes from `NotificationConfig`.

## Local run

```bash
export DATABASE_URL="jdbc:postgresql://localhost:5432/digicarts?currentSchema=notif_svc"
mvn spring-boot:run
```

## CI/CD

`digi-cart-notification-service-dev` / `digi-cart-notification-service`.

## Related

- [platform-ui](https://github.com/digi-carts/platform-ui/blob/stage/doc/README.md) notifications admin
- [merchant-ui](https://github.com/digi-carts/merchant-ui/blob/stage/doc/README.md) store alerts
- [order-service](https://github.com/digi-carts/order-service/blob/stage/doc/README.md)

## REST API reference

See [api.md](api.md) for every HTTP endpoint generated from Spring controllers.
