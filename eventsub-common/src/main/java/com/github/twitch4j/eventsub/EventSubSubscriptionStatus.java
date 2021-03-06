package com.github.twitch4j.eventsub;

public enum EventSubSubscriptionStatus {

    /**
     * Designates that the subscription is in an operable state and is valid.
     */
    ENABLED,
    /**
     * Webhook is pending verification of the callback specified in the subscription creation request.
     */
    WEBHOOK_CALLBACK_VERIFICATION_PENDING,
    /**
     * Webhook failed verification of the callback specified in the subscription creation request.
     */
    WEBHOOK_CALLBACK_VERIFICATION_FAILED,
    /**
     * Notification delivery failure rate was too high.
     */
    NOTIFICATION_FAILURES_EXCEEDED,
    /**
     * Authorization for user(s) in the condition was revoked.
     */
    AUTHORIZATION_REVOKED,
    /**
     * A user in the condition of the subscription was removed.
     */
    USER_REMOVED;

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }

}
