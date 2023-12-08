package com.prabidhi.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.prabidhi.entity.WikimediaData}
 */
@Value
public class WikimediaDataDto implements Serializable {
    Long id;
    String wikiEventData;
}