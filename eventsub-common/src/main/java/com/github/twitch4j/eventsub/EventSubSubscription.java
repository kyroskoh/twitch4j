package com.github.twitch4j.eventsub;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.twitch4j.eventsub.condition.EventSubCondition;
import com.github.twitch4j.eventsub.subscriptions.SubscriptionType;
import com.github.twitch4j.eventsub.subscriptions.SubscriptionTypes;
import com.github.twitch4j.eventsub.util.EventSubConditionConverter;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;
import java.util.Map;

@Data
@Builder
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class EventSubSubscription {

    /**
     * ID of the subscription.
     */
    private String id;

    /**
     * Status of the subscription.
     */
    private EventSubSubscriptionStatus status;

    /**
     * The category and version of the subscription.
     */
    @JsonIgnore
    @ToString.Exclude
    @Getter(onMethod_ = { @JsonIgnore })
    private SubscriptionType<?, ?, ?> type;

    /**
     * Object specifying custom parameters for the subscription.
     */
    private EventSubCondition condition;

    /**
     * Timestamp indicating when the subscription was created.
     */
    private Instant createdAt;

    /**
     * Object indicating the notification delivery specific information
     */
    private EventSubTransport transport;

    /**
     * The category of the subscription.
     */
    @JsonProperty("type")
    private String rawType;

    /**
     * The version of the subscription.
     */
    @JsonProperty("version")
    private String rawVersion;

    @JsonCreator
    public EventSubSubscription(@JsonProperty("id") String id, @JsonProperty("status") EventSubSubscriptionStatus status, @JsonProperty("type") String type, @JsonProperty("version") String version,
                                @JsonProperty("condition") Map<String, Object> condition, @JsonProperty("created_at") Instant createdAt, @JsonProperty("transport") EventSubTransport transport) {
        this.id = id;
        this.status = status;
        this.rawType = type;
        this.rawVersion = version;
        this.type = SubscriptionTypes.getSubscriptionType(type, version);
        this.condition = EventSubConditionConverter.getCondition(this.type, condition);
        this.createdAt = createdAt;
        this.transport = transport;
    }

}
