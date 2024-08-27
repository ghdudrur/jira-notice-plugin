package it.dev.jira.rest;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import org.mockito.Mockito;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import dev.jira.rest.NoticeRestModule;
import dev.jira.rest.NoticeRestModuleModel;
import org.apache.wink.client.Resource;
import org.apache.wink.client.RestClient;

public class NoticeRestModuleFuncTest {

    @Before
    public void setup() {

    }

    @After
    public void tearDown() {

    }

    @Test
    public void messageIsValid() {

        String baseUrl = System.getProperty("baseurl");
        String resourceUrl = baseUrl + "/rest/notice/1.0/message";

        RestClient client = new RestClient();
        Resource resource = client.resource(resourceUrl);

        NoticeRestModuleModel message = resource.get(NoticeRestModuleModel.class);

        assertEquals("wrong message","Hello World",message.getMessage());
    }
}
