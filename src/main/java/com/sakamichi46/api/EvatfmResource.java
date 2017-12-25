/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sakamichi46.api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import static com.sakamichi46.api.AbstractSakamichi46Resource.CHARSET_UTF8;
import com.sakamichi46.model.evatfm.Episode;
import com.sakamichi46.model.evatfm.Podcast;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@Path("evatfm")
public class EvatfmResource {
    
    private static final ObjectMapper mapper = new ObjectMapper();
    
    private static final String EVATFM_FILE_EPISODE = "EvatfmEpisode.json";
    private static final String EVATFM_FILE_PODCAST = "EvatfmPodcast.json";
    
    private List<Episode> listEpisodes;
    private List<Podcast> listPodcasts;
    
    @PostConstruct
    public void init() {
        try {
            listEpisodes = mapper.readValue(getClass().getClassLoader().getResource(EVATFM_FILE_EPISODE), new TypeReference<List<Episode>>() {});
            listPodcasts = mapper.readValue(getClass().getClassLoader().getResource(EVATFM_FILE_PODCAST), new TypeReference<List<Podcast>>() {});
        } catch (IOException ex) {
            Logger.getLogger(EvatfmResource.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @GET
    public String evatfm() {
        return "evatfm";
    }
    
    @GET
    @Path("episodes")
    @Produces(MediaType.APPLICATION_JSON + CHARSET_UTF8)
    public List<Episode> getAllEpisodes() {
        return listEpisodes;
    }
    
    @GET
    @Path("podcasts")
    @Produces(MediaType.APPLICATION_JSON + CHARSET_UTF8)
    public List<Podcast> getAllPodcasts() {
        return listPodcasts;
    }
}
