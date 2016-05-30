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
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author kikuta
 */
@Startup
@Singleton
@Path("hiraganakeyaki")
public class HiraganaKeyakiResource extends AbstractSakamichi46Resource {
    
    @PostConstruct
    @Override
    public void init() {
        try {
            memberMap = mapper.readValue(getClass().getClassLoader().getResource("Hiraganakeyaki.json"), new TypeReference<Map<String, Member>>() {});
        } catch (IOException ex) {
            Logger.getLogger(HiraganaKeyakiResource.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @GET
    @Path("blog")
    @Produces(MediaType.TEXT_PLAIN)
    @Override
    public String getBlogUrl() {
        return "www.keyakizaka46.com/";
    }
}
