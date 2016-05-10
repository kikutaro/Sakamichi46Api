package com.sakamichi46.api;

import com.fasterxml.jackson.core.type.TypeReference;
import static com.sakamichi46.api.AbstractSakamichi46Resource.mapper;
import com.sakamichi46.model.Member;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ws.rs.Path;

/**
 *
 * @author kikuta
 */
@Startup
@Singleton
@Path("keyakizaka46")
public class Keyakizaka46Resource extends AbstractSakamichi46Resource {
    
    @PostConstruct
    @Override
    public void init() {
        try {
            memberMap = mapper.readValue(getClass().getClassLoader().getResource("Keyakizaka46.json"), new TypeReference<Map<String, Member>>() {});
        } catch (IOException ex) {
            Logger.getLogger(Keyakizaka46Resource.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
