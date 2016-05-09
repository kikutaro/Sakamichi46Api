package com.sakamichi46.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sakamichi46.model.Member;
import java.util.List;
import java.util.Map;
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
    
    public abstract void init();
    
    @GET
    @Path("profile/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Member getProfile(@PathParam("name") String name) {
        return memberMap.get(name);
    }
    
    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Member> getAll() {
        return memberMap.values().stream().collect(Collectors.toList());
    }  
}
