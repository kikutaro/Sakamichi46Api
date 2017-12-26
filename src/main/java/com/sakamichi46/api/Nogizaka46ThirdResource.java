package com.sakamichi46.api;

import com.fasterxml.jackson.core.type.TypeReference;
import static com.sakamichi46.api.AbstractSakamichi46Resource.mapper;
import com.sakamichi46.model.Member;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.stereotype.Component;

/**
 * Nogizaka46 3rd members resource.
 * 
 * @author kikuta
 */
@Component
@Path("nogizaka46/3rd")
public class Nogizaka46ThirdResource extends AbstractSakamichi46Resource {
    
    @PostConstruct
    @Override
    public void init() {
        try {
            memberMap = mapper.readValue(getClass().getClassLoader().getResource("Nogizaka46Third.json"), new TypeReference<Map<String, Member>>() {});
        } catch (IOException ex) {
            Logger.getLogger(Nogizaka46ThirdResource.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @GET
    @Path("blog")
    @Produces(MediaType.TEXT_PLAIN)
    @Override
    public String getBlogUrl() {
        return "http://www.nogizaka46.com/third/member/";
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @GET
    @Path("goods/mobile")
    @Produces(MediaType.TEXT_PLAIN)
    @Override
    public String getGoodsMobileUrl() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @GET
    @Path("matome")
    @Produces(MediaType.TEXT_PLAIN)
    @Override
    public String getMatomeUrl() {
        return "http://nogizaka46democracy.blog.jp/archives/cat_1201660.html";
    }
    
    @GET
    @Path("tv")
    @Produces(MediaType.TEXT_PLAIN)
    @Override
    public String getTvUrl() {
        return "https://talent.thetv.jp/person/1000082336/program/";
    }

    @Override
    public String getTwitterRankingUrl() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void reload() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
