package com.github.twitch4j.helix.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import java.util.List;

/**
 * URLs to upload entitlements to
 */
@Data
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
public class UploadEntitlementUrlList {

    @NonNull
    @JsonProperty("data")
    private List<UploadEntitlementUrl> links;

}
