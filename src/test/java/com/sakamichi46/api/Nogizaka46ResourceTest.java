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
 * Test for Nogizaka46 API.
 * 
 * @author kikuta
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class Nogizaka46ResourceTest {
    
    @Autowired
    private TestRestTemplate restTemplate;
    
    @Test
    public void Nogizaka46OfficialBlogUrlTest() throws MalformedURLException {
        ResponseEntity<String> blogUrl = this.restTemplate.getForEntity("/sakamichi46api/api/nogizaka46/blog", String.class);
        assertThat(blogUrl.getBody(), is("http://www.nogizaka46.com/"));
    }
    
    @Test
    public void Nogizaka46OfficialBlogMobileUrlTest() throws MalformedURLException {
        ResponseEntity<String> blogUrl = this.restTemplate.getForEntity("/sakamichi46api/api/nogizaka46/blog/mobile", String.class);
        assertThat(blogUrl.getBody(), is("http://www.nogizaka46.com/smph/"));
    }
    
    @Test
    public void Nogizaka46OfficialGoodsUrlTest() throws MalformedURLException {
        ResponseEntity<String> goodsUrl = this.restTemplate.getForEntity("/sakamichi46api/api/nogizaka46/goods", String.class);
        assertThat(goodsUrl.getBody(), is("http://www.nogizaka46shop.com/"));
    }
    
    @Test
    public void Nogizaka46OfficialGoodsMobileUrlTest() throws MalformedURLException {
        ResponseEntity<String> goodsMobileUrl = this.restTemplate.getForEntity("/sakamichi46api/api/nogizaka46/goods/mobile", String.class);
        assertThat(goodsMobileUrl.getBody(), is("http://www.nogizaka46shop.com/msp/"));
    }
    
    @Test
    public void Nogizaka46MatomeUrlTest() throws MalformedURLException {
        ResponseEntity<String> matomeUrl = this.restTemplate.getForEntity("/sakamichi46api/api/nogizaka46/matome", String.class);
        assertThat(matomeUrl.getBody(), is("http://nogizaka46democracy.blog.jp/"));
    }
    
    @Test
    public void Nogizaka46MemberProfileUrlTest() throws MalformedURLException {
        ResponseEntity<Member> maiShiraishi = this.restTemplate.getForEntity("/sakamichi46api/api/nogizaka46/profile/shiraishimai", Member.class);
        assertThat(maiShiraishi.getBody().getName(), is("白石麻衣"));
        DateTimeFormatter dateformat = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        assertThat(
                maiShiraishi.getBody().getBirthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().format(dateformat),
                is(LocalDate.of(1992, 8, 20).format(dateformat)));
        assertThat(maiShiraishi.getBody().getBloodType(), is("A"));
        assertThat(maiShiraishi.getBody().getConstellation(), is("しし座"));
        assertThat(maiShiraishi.getBody().getProfilePhotoUri(), is("http://img.nogizaka46.com/www/member/img/shiraishimai_prof.jpg"));
        assertThat(maiShiraishi.getBody().getBlogUri(), is("http://blog.nogizaka46.com/mai.shiraishi/smph/"));
        assertThat(maiShiraishi.getBody().getTvUri(), is("https://talent.thetv.jp/person/1000082696/program/"));
        assertThat(maiShiraishi.getBody().getGoodsUri(), is("http://www.nogizaka46shop.com/category/33"));
        assertThat(maiShiraishi.getBody().getMatomeUri().get(0), is("http://nogizaka46democracy.blog.jp/archives/cat_51850.html"));
    }
}
