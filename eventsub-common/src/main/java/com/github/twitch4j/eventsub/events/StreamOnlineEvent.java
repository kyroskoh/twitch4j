package com.github.twitch4j.eventsub.events;

import com.github.twitch4j.eventsub.domain.StreamType;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class StreamOnlineEvent extends EventSubChannelEvent {

    /**
     * The event id.
     */
    private String id;

    /**
     * The stream type.
     */
    private StreamType type;

}
