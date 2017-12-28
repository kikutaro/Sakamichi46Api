/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sakamichi46.model.evatfm;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author kikuta
 */
@Getter @Setter
public class Podcast {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM")
    private Date date;
    private String podcastUrl;
    private String description;
}
