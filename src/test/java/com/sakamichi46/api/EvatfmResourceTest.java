package com.sakamichi46.api;

import com.sakamichi46.model.evatfm.Episode;
import com.sakamichi46.model.evatfm.Podcast;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import static org.hamcrest.CoreMatchers.is;

/**
 * Test for Evatfm API.
 * 
 * @author kikuta
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EvatfmResourceTest {
    
    @Autowired
    private TestRestTemplate restTemplate;
    
    @Test
    public void EvatfmEpisodesTest() {
        ResponseEntity<List<Episode>> episodes = this.restTemplate.exchange("/sakamichi46api/api/evatfm/episodes",
                    HttpMethod.GET, null, new ParameterizedTypeReference<List<Episode>>() {
            });
        assertThat(episodes.getBody().size(), is(91));
    }
    
    @Test
    public void EvatfmPodcastsTest() {
        ResponseEntity<List<Podcast>> podcasts = this.restTemplate.exchange("/sakamichi46api/api/evatfm/podcasts",
                    HttpMethod.GET, null, new ParameterizedTypeReference<List<Podcast>>() {
            });
        assertThat(podcasts.getBody().size(), is(21));
    }
}
