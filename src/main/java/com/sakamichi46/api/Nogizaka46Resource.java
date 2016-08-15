package com.sakamichi46.api;

import com.fasterxml.jackson.core.type.TypeReference;
import static com.sakamichi46.api.AbstractSakamichi46Resource.mapper;
import com.sakamichi46.model.Member;
import com.sakamichi46.model.Music;
import java.io.IOException;
import java.util.List;
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
@Path("nogizaka46")
public class Nogizaka46Resource extends AbstractSakamichi46Resource {
    
    @PostConstruct
    @Override
    public void init() {
        try {
            memberMap = mapper.readValue(getClass().getClassLoader().getResource("Nogizaka46.json"), new TypeReference<Map<String, Member>>() {});
            musicList = mapper.readValue(getClass().getClassLoader().getResource("Nogizaka46Music.json"), new TypeReference<List<Music>>() {});
        } catch (IOException ex) {
            Logger.getLogger(Nogizaka46Resource.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @GET
    @Path("blog")
    @Produces(MediaType.TEXT_PLAIN)
    @Override
    public String getBlogUrl() {
        return "http://www.nogizaka46.com/";
    }
    
    @GET
    @Path("blog/mobile")
    @Produces(MediaType.TEXT_PLAIN)
    @Override
    public String getBlogMobileUrl() {
        return "http://www.nogizaka46.com/smph/";
    }

    @GET
    @Path("goods")
    @Produces(MediaType.TEXT_PLAIN)
    @Override
    public String getGoodsUrl() {
        return "http://www.nogizaka46shop.com/";
    }

    @GET
    @Path("goods/mobile")
    @Produces(MediaType.TEXT_PLAIN)
    @Override
    public String getGoodsMobileUrl() {
        return "http://www.nogizaka46shop.com/msp/";
    }

    @GET
    @Path("tweetrank")
    @Produces(MediaType.TEXT_PLAIN)
    @Override
    public String getTwitterRankingUrl() {
        return "http://46collection.sakamichi46.com/nogizaka46";
    }
}
