package com.github.twitch4j.helix.webhooks.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.twitch4j.helix.webhooks.topics.TwitchWebhookTopic;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class WebhookRequest {

    public static final String MODE_SUBSCRIBE = "subscribe";
    public static final String MODE_UNSUBSCRIBE = "unsubscribe";

    /**
     * Callback URL
     */
    @NonNull
    @JsonProperty("hub.callback")
    private String callback;

    /**
     * Either "subscribe" or "unsubscribe"
     */
    @NonNull
    @JsonProperty("hub.mode")
    private String mode;

    /**
     * Topic URL
     * Can be generated by TwitchWebhookTopic.toString()
     */
    @NonNull
    @JsonProperty("hub.topic")
    private String topic;

    /**
     * Lease time in seconds.
     * Default is 0, which is only useful for testing.
     */
    @JsonProperty("hub.lease_seconds")
    private Integer leaseSeconds;

    /**
     * Secret used to sign notification payloads. The X-Hub-Signature header is generated by sha256(secret, notification_bytes).
     * We strongly encourage you to use this, so your application can verify that notifications are genuine.
     */
    @JsonProperty("hub.secret")
    private String secret;

    public WebhookRequest(@NonNull String callback, @NonNull String mode, @NonNull TwitchWebhookTopic topic, Integer leaseSeconds, String secret) {
        this(callback, mode, topic.toString(), leaseSeconds, secret);
    }
}
