package com.sakamichi46.api;

import com.sakamichi46.config.ApplicationConfig;
import com.sakamichi46.model.Member;
import java.io.File;
import javax.inject.Inject;
import static org.hamcrest.CoreMatchers.is;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import static org.junit.Assert.*;
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
    
    @Inject
    Nogizaka46Resource nogizaka;
    
    @Test
    public void Nogizaka46OfficialBlogUrlTest() {
        assertThat(nogizaka.getBlogUrl(), is("http://www.nogizaka46.com/"));                
    }
}
