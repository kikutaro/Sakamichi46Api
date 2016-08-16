package com.sakamichi46.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author kikuta
 */
@Getter @Setter
public class Music {
    private String title;
    private String releaseVersion;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date releaseDate;
    private String lyricsUri;
    private String coverPhotoUri;
    private String officialMovieUri;
    private String type;
}
