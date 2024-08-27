package ut.dev.jira.rest;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import org.mockito.Mockito;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import dev.jira.rest.NoticeRestModule;
import dev.jira.rest.NoticeRestModuleModel;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.GenericEntity;

public class NoticeRestModuleTest {

    @Before
    public void setup() {

    }

    @After
    public void tearDown() {

    }

    @Test
    public void messageIsValid() {
        //NoticeRestModule resource = new NoticeRestModule();

       // Response response = resource.getMessage();
        //final NoticeRestModuleModel message = (NoticeRestModuleModel) response.getEntity();

       // assertEquals("wrong message","Hello World",message.getMessage());
    }
}
