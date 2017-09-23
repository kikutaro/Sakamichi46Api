/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sakamichi46.api;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

/**
 *
 * @author kikuta
 */
@Component
@ApplicationPath("api")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(HiraganaKeyakiResource.class);
        register(Keyakizaka46Resource.class);
        register(Nogizaka46Resource.class);
        register(Nogizaka46ThirdResource.class);
    }

}
