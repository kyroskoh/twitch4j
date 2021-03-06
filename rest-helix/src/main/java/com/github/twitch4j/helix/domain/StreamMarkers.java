package com.github.twitch4j.helix.domain;

import lombok.*;

import java.util.List;

/**
 * Model representing a stream.
 * <p>
 * A stream is a channel, that is currently streaming live.
 */
@Data
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
public class StreamMarkers {

    /** Stream ID. */
    @NonNull
    private String userId;

    /** Markers */
    @NonNull
    private List<VideoMarkers> videos;

}
