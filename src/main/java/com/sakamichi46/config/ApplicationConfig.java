package com.sakamichi46.config;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author kikuta
 */
@javax.ws.rs.ApplicationPath("api")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.sakamichi46.api.HiraganaKeyakiResource.class);
        resources.add(com.sakamichi46.api.Keyakizaka46Resource.class);
        resources.add(com.sakamichi46.api.Nogizaka46Resource.class);
        resources.add(com.sakamichi46.api.Nogizaka46ThirdResource.class);
    }
    
}
