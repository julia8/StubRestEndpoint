package myservice.resources;

import myservice.api.Response;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class HappyResourceTest {
    private HappyResource resource;

    @Before
    public void setup() {
        resource = new HappyResource();
    }

    @Test
    public void testHappyBirthday() {
        Response resp = resource.getResponse("me", "Birthday");
        assertThat(resp.getMeta().getCode(), is(200));
        assertThat(resp.getContent().toString(), is("Happy Birthday to me"));
    }

}