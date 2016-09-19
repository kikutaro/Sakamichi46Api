package com.sakamichi46.api;

import com.sakamichi46.config.ApplicationConfig;
import com.sakamichi46.model.Member;
import com.sakamichi46.model.Music;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import javax.ws.rs.core.Response;
import static org.hamcrest.CoreMatchers.is;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Test for Nogizaka46 API.
 * 
 * @author kikuta
 */
@RunWith(Arquillian.class)
public class Nogizaka46ResourceTest {
    
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(AbstractSakamichi46Resource.class)
                .addClass(HiraganaKeyakiResource.class)
                .addClass(Keyakizaka46Resource.class)
                .addClass(Nogizaka46Resource.class)
                .addClass(ApplicationConfig.class)
                .addClass(Member.class)
                .addClass(Music.class)
                .addAsDirectory("WEB-INF/classes")
                .addAsResource(new File("src/main/webapp/WEB-INF/classes/", "Hiraganakeyaki.json"))
                .addAsResource(new File("src/main/webapp/WEB-INF/classes/", "Keyakizaka46.json"))
                .addAsResource(new File("src/main/webapp/WEB-INF/classes/", "Nogizaka46.json"))
                .addAsResource(new File("src/main/webapp/WEB-INF/classes/", "Nogizaka46Music.json"))
                .addAsResource(new File("src/main/webapp/WEB-INF/classes/", "Keyakizaka46Music.json"));
    }
    
    @ArquillianResource
    private URL base;
    
    @Test
    @RunAsClient
    public void Nogizaka46OfficialBlogUrlTest() throws MalformedURLException {
        Response res = ResteasyClientBuilder.newBuilder().build().target(new URL(base, "api/nogizaka46/blog").toExternalForm()).request().get();
        assertThat(res.readEntity(String.class), is("http://www.nogizaka46.com/"));
    }
    
    @Test
    @RunAsClient
    public void Nogizaka46OfficialBlogMobileUrlTest() throws MalformedURLException {
        Response get = ResteasyClientBuilder.newBuilder().build().target(new URL(base, "api/nogizaka46/blog/mobile").toExternalForm()).request().get();
        assertThat(get.readEntity(String.class), is("http://www.nogizaka46.com/smph/"));
    }
    
    @Test
    @RunAsClient
    public void Nogizaka46OfficialGoodsUrlTest() throws MalformedURLException {
        Response get = ResteasyClientBuilder.newBuilder().build().target(new URL(base, "api/nogizaka46/goods").toExternalForm()).request().get();
        assertThat(get.readEntity(String.class), is("http://www.nogizaka46shop.com/"));
    }
    
    @Test
    @RunAsClient
    public void Nogizaka46OfficialGoodsMobileUrlTest() throws MalformedURLException {
        Response get = ResteasyClientBuilder.newBuilder().build().target(new URL(base, "api/nogizaka46/goods/mobile").toExternalForm()).request().get();
        assertThat(get.readEntity(String.class), is("http://www.nogizaka46shop.com/msp/"));
    }
    
    @Test
    @RunAsClient
    public void Nogizaka46MemberProfileUrlTest() throws MalformedURLException {
        Member maiShiraishi = ResteasyClientBuilder.newBuilder().build()
                .target(new URL(base, "api/nogizaka46/profile/shiraishimai").toExternalForm())
                .request().get().readEntity(Member.class);
        assertThat(maiShiraishi.getName(), is("白石麻衣"));
        DateTimeFormatter dateformat = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        assertThat(
                maiShiraishi.getBirthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().format(dateformat),
                is(LocalDate.of(1992, 8, 20).format(dateformat)));
        assertThat(maiShiraishi.getBloodType(), is("A"));
        assertThat(maiShiraishi.getConstellation(), is("しし座"));
        assertThat(maiShiraishi.getProfilePhotoUri(), is("http://img.nogizaka46.com/www/member/img/shiraishimai_prof.jpg"));
        assertThat(maiShiraishi.getBlogUri(), is("http://blog.nogizaka46.com/mai.shiraishi/smph/"));
        assertThat(maiShiraishi.getGoodsUri(), is("http://www.nogizaka46shop.com/category/33"));
    }
    
    @Test
    @RunAsClient
    public void Nogizaka46MemberCountTest() throws MalformedURLException {
        long count = ResteasyClientBuilder.newBuilder().build().target(new URL(base, "api/nogizaka46/count").toExternalForm()).request().get().readEntity(long.class);
        assertThat(count, is(35L));
    }
}
