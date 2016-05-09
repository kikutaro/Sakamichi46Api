package com.sakamichi46.api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sakamichi46.model.Member;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import lombok.Getter;

/**
 *
 * @author kikuta
 */
@Startup
@Singleton
@Path("nogizaka46")
public class Nogizaka46Resource {
    
    private static final ObjectMapper mapper = new ObjectMapper();
    
    @Getter
    private List<Member> list;
    
    private Map<String, Member> map;
    
    @PostConstruct
    public void init() {
        try {
            map = mapper.readValue(getClass().getClassLoader().getResource("Nogizaka46.json"), new TypeReference<Map<String, Member>>() {});
        } catch (IOException ex) {
            Logger.getLogger(Nogizaka46Resource.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @GET
    @Path("profile/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Member getProfile(@PathParam("name") String name) {
        return map.get(name);
    }
    
    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Member> getAll() {
        return map.values().stream().collect(Collectors.toList());
    }
}
