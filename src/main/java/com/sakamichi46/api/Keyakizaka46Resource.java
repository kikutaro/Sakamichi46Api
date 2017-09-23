package com.sakamichi46.api;

import javax.annotation.PostConstruct;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.stereotype.Component;

/**
 *
 * @author kikuta
 */
@Component
@Path("keyakizaka46")
public class Keyakizaka46Resource extends AbstractSakamichi46Resource {
    
    private static final String KEYAKIZAKA_MEMBER_FILE = "Keyakizaka46.json";
    
    private static final String KEYAKIZAKA_MUSIC_FILE = "Keyakizaka46Music.json";
    
    @PostConstruct
    @Override
    public void init() {
        readData(KEYAKIZAKA_MEMBER_FILE, KEYAKIZAKA_MUSIC_FILE);
    }

    @GET
    @Path("blog")
    @Produces(MediaType.TEXT_PLAIN)
    @Override
    public String getBlogUrl() {
        return "http://www.keyakizaka46.com/";
    }
    
    @GET
    @Path("blog/mobile")
    @Produces(MediaType.TEXT_PLAIN)
    @Override
    public String getBlogMobileUrl() {
        //same url because of responsive site
        return getBlogUrl();
    }

    @GET
    @Path("goods")
    @Produces(MediaType.TEXT_PLAIN)
    @Override
    public String getGoodsUrl() {
        return "https://official-goods-store.jp/keyakizaka46/";
    }

    @GET
    @Path("goods/mobile")
    @Produces(MediaType.TEXT_PLAIN)
    @Override
    public String getGoodsMobileUrl() {
        //same url because of responsive site
        return getGoodsUrl();
    }
    
    @GET
    @Path("matome")
    @Produces(MediaType.TEXT_PLAIN)
    @Override
    public String getMatomeUrl() {
        return "http://www.keyakizaka46matomerabo.com/";
    }
    
    @GET
    @Path("tv")
    @Produces(MediaType.TEXT_PLAIN)
    @Override
    public String getTvUrl() {
        return "https://talent.thetv.jp/person/2000006918/program/";
    }
    
    @GET
    @Path("tweetrank")
    @Produces(MediaType.TEXT_PLAIN)
    @Override
    public String getTwitterRankingUrl() {
        return "http://46collection.sakamichi46.com/keyakizaka46";
    }

    @GET
    @Path("reload")
    @Override
    public void reload() {
        readData(KEYAKIZAKA_MEMBER_FILE, KEYAKIZAKA_MUSIC_FILE);
    }
}
