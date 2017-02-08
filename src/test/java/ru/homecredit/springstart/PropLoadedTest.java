package ru.homecredit.springstart;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.homecredit.springstart.config.TestConfig;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.hasItems;
import static org.junit.Assert.assertEquals;

/**
 * @author dima
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringStartApplication.class)
public class PropLoadedTest {
    @Autowired
    private TestConfig config;

    @Value("${prefix.stringProp1}")
    private String stringProp1;

    @Test
    public void testLoadingOfProperties() {
        System.out.println("stringProp1 = " + stringProp1);
        assertEquals(config.getStringProp1(), "propValue1");

        assertThat(config.getStringProp1(), equalTo("propValue1"));
        assertThat(config.getStringProp2(), equalTo("propValue2"));
        assertThat(config.getIntProp1(), equalTo(50));
        assertThat(config.getListProp(), hasItems("listValue1", "listValue2"));
        assertThat(config.getMapProp(), allOf(hasEntry("key1", "mapValue1"),
                hasEntry("key2", "mapValue2")));
//        assertThrows();
    }
}
