Feature: Notification config component
  Scenario: missing config is an error
    When I GET "/api/notification-config"
    Then the response status is 404
