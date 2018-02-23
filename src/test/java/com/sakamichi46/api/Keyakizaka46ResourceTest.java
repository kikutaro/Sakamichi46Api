package com.sakamichi46.api;

import com.sakamichi46.model.Member;
import java.net.MalformedURLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Test for Keyakizaka46 API.
 * 
 * @author kikuta
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class Keyakizaka46ResourceTest {
    
    @Autowired
    private TestRestTemplate restTemplate;
    
    @Test
    public void Keyakizaka46OfficialBlogUrlTest() throws MalformedURLException {
        ResponseEntity<String> blogUrl = this.restTemplate.getForEntity("/sakamichi46api/api/keyakizaka46/blog", String.class);
        assertThat(blogUrl.getBody(), is("http://www.keyakizaka46.com/"));
    }
    
    @Test
    public void Keyakizaka46MusicTest() throws MalformedURLException {
        ResponseEntity<String> blogUrl = this.restTemplate.getForEntity("/sakamichi46api/api/keyakizaka46/music", String.class);
        assertThat(blogUrl.getBody(), is("http://www.keyakizaka46.com/"));
    }
}
