package com.sakamichi46.api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sakamichi46.model.Member;
import com.sakamichi46.model.Music;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author kikuta
 */
public abstract class AbstractSakamichi46Resource {
    
    protected static final ObjectMapper mapper = new ObjectMapper();
    
    protected Map<String, Member> memberMap;
    
    protected List<Music> musicList;
    
    protected static final String CHARSET_UTF8 = ";charset=utf-8";
    
    public abstract void init();
    
    @GET
    @Path("profile/{name}")
    @Produces(MediaType.APPLICATION_JSON  + CHARSET_UTF8)
    public Member getProfile(@PathParam("name") String name) {
        return memberMap.get(name);
    }
    
    @GET
    @Path("profile")
    @Produces(MediaType.APPLICATION_JSON + CHARSET_UTF8)
    public List<Member> getAllProfiles() {
        return memberMap.values().stream()
                .filter(m -> m.getGraduateDate() == null)
                .collect(Collectors.toList());
    }
    
    @GET
    @Path("graduate")
    @Produces(MediaType.APPLICATION_JSON + CHARSET_UTF8)
    public List<Member> getAllGraduates() {
        return memberMap.values().stream()
                .filter(m -> m.getGraduateDate() != null)
                .collect(Collectors.toList());
    }
    
    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN + CHARSET_UTF8)
    public long getMemberCount() {
        return memberMap.values().stream()
                .filter(m -> m.getGraduateDate() == null)
                .count();
    }
    
    @GET
    @Path("music")
    @Produces(MediaType.APPLICATION_JSON + CHARSET_UTF8)
    public List<Music> getAllMusics() {
        return musicList;
    }
    
    @GET
    @Path("music/count")
    @Produces(MediaType.TEXT_PLAIN + CHARSET_UTF8)
    public long getMusicCount() {
        return musicList.size();
    }
    
    public abstract String getBlogUrl();
    
    public abstract String getBlogMobileUrl();
    
    public abstract String getGoodsUrl();
    
    public abstract String getGoodsMobileUrl();
    
    public abstract String getMatomeUrl();
    
    public abstract String getTwitterRankingUrl();
    
    public abstract void reload();
    
    protected boolean readData(String memberDataSource, String musicDataSource) {
        try {
            memberMap = mapper.readValue(getClass().getClassLoader().getResource(memberDataSource), new TypeReference<Map<String, Member>>() {});
            musicList = mapper.readValue(getClass().getClassLoader().getResource(musicDataSource), new TypeReference<List<Music>>() {});
        } catch (IOException ex) {
            Logger.getLogger(Nogizaka46Resource.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
}
