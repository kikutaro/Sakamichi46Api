package com.sakamichi46.model;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author kikuta
 */
@Getter @Setter
public class Member {
    private String name;
    private Date birthday;
    private String bloodType;
    private String constellation;
    private String profilePhotoUri;
    private String blogUri;
}
