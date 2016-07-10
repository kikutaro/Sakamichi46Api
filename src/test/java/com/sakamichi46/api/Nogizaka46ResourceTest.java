package com.sakamichi46.api;

import com.sakamichi46.config.ApplicationConfig;
import com.sakamichi46.model.Member;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
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
                .addAsDirectory("WEB-INF/classes")
                .addAsResource(new File("src/main/webapp/WEB-INF/classes/", "Hiraganakeyaki.json"))
                .addAsResource(new File("src/main/webapp/WEB-INF/classes/", "Keyakizaka46.json"))
                .addAsResource(new File("src/main/webapp/WEB-INF/classes/", "Nogizaka46.json"));
    }
    
    @ArquillianResource
    private URL base;
    
    @Test
    @RunAsClient
    public void Nogizaka46OfficialBlogUrlTest() throws MalformedURLException {
        Response get = ResteasyClientBuilder.newBuilder().build().target(new URL(base, "api/nogizaka46/blog").toExternalForm()).request().get();
        assertThat(get.readEntity(String.class), is("http://www.nogizaka46.com/"));            
    }
}
