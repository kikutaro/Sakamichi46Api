package com.sakamichi46.api;

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
    
    private static final String NOGIZAKA_MEMBER_FILE = "Nogizaka46.json";
    
    private static final String NOGIZAKA_MUSIC_FILE = "Nogizaka46Music.json";
    
    @PostConstruct
    @Override
    public void init() {
        readData(NOGIZAKA_MEMBER_FILE, NOGIZAKA_MUSIC_FILE);
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
    @Path("matome")
    @Produces(MediaType.TEXT_PLAIN)
    @Override
    public String getMatomeUrl() {
        return "http://nogizaka46democracy.blog.jp/";
    }
    
    @GET
    @Path("tv")
    @Produces(MediaType.TEXT_PLAIN)
    @Override
    public String getTvUrl() {
        return "https://talent.thetv.jp/person/1000082336/program/";
    }

    @GET
    @Path("tweetrank")
    @Produces(MediaType.TEXT_PLAIN)
    @Override
    public String getTwitterRankingUrl() {
        return "http://46collection.sakamichi46.com/nogizaka46";
    }

    @GET
    @Path("reload")
    @Override
    public void reload() {
        readData(NOGIZAKA_MEMBER_FILE, NOGIZAKA_MUSIC_FILE);
    }
}
